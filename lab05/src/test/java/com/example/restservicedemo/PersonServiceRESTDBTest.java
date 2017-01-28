package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.given;

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

import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PersonServiceRESTDBTest {
	
	private static IDatabaseConnection connection ;
	private static IDatabaseTester databaseTester;
	private static Response response;
    private static String jsonString;
    private static HashMap<String, String> personsArrayList;
	

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
				new FileInputStream(new File("src/test/resources/fullData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);


		Person aPerson = new Person("Bolek", 1967);
		Person bPerson = new Person("Lolek", 1967);
		Person cPerson = new Person("Tola", 1965);
		Person dPerson = new Person("Ziutek", 2010);
		Person[] persons = new Person[]{aPerson, bPerson, cPerson, dPerson};
		
		for(int i = 0; i < persons.length; i++){
			given().contentType("application/json; charset=UTF-16").body(persons[i])
			.when().post("/persons/").then().assertThat().statusCode(201);
		}
	}

	@Test
	public void validateData() throws Exception{
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("PERSON");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"ID"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/personData.xml"));
		ITable expectedTable = expectedDataSet.getTable("PERSON");
		
//		Assertion.assertEquals(expectedTable, filteredTable);
		assertThat(expectedTable.getRowCount(), greaterThanOrEqualTo(filteredTable.getRowCount()));
	}
	
	@Test
	public void getAllPerson() throws Exception{
		response = when().get("/persons/").then().assertThat().contentType(ContentType.JSON).extract().response();
        jsonString = response.asString();
        personsArrayList = from(jsonString).get("");
        assertThat(personsArrayList.size(), greaterThan(0));
	}
	
	@Test
	public void deletePerson() throws Exception{
		when().delete("/persons/0").then().assertThat().statusCode(200);
	}

	@AfterClass
	public static void tearDown() throws Exception{
		databaseTester.onTearDown();
	}

}
