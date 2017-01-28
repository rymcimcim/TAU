package com.example.restservicedemo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.City;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class CityServiceRESTDBTest {
	
	private static IDatabaseConnection connection ;
	private static IDatabaseTester databaseTester;
	private static Response response;
    private static String jsonString;
    private static HashMap<String, String> citiesArrayList;
	

	@BeforeClass
	public static void setUp() throws Exception{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo";
		
		Connection jdbcConnection;
		jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		connection = new DatabaseConnection(jdbcConnection);
		
		databaseTester = new JdbcDatabaseTester(
				"org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/fullCityData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);


		City aCity = new City("Gdańsk", 80339);
		City bCity = new City("Gdynia", 19671);
		City cCity = new City("Sopot", 19652);
		City dCity = new City("Warszawa", 20103);
		City[] cities = new City[]{aCity, bCity, cCity, dCity};
		
		for(int i = 0; i < cities.length; i++){
			given().contentType("application/json; charset=UTF-16").body(cities[i])
			.when().post("/cities/").then().assertThat().statusCode(201);
		}
	}

	@Test
	public void validateData() throws Exception{
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("CITY");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"ID"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/cityData.xml"));
		ITable expectedTable = expectedDataSet.getTable("CITY");
		

		assertThat(expectedTable.getRowCount(), greaterThanOrEqualTo(filteredTable.getRowCount()));
		}
	
	@Test
	public void getAllCities() throws Exception{
		response = when().get("/cities/").then().assertThat().contentType(ContentType.JSON).extract().response();
        jsonString = response.asString();
        citiesArrayList = from(jsonString).get("");
        assertThat(citiesArrayList.size(), greaterThan(0));
	}
	
	@Test
	public void deleteCity() throws Exception{
		when().delete("/cities/0").then().assertThat().statusCode(200);
	}

	@AfterClass
	public static void tearDown() throws Exception{
		databaseTester.onTearDown();
	}

}
