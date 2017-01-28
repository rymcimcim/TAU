package com.example.restservicedemo.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.City;
import com.example.restservicedemo.service.CityManager;

@Path("cities")
public class CityRESTService {	
	
	private CityManager cm = new CityManager();
	
	@GET
	@Path("/{cityId}")
	@Produces("application/json")
	public City getCity(@PathParam("cityId") Long id){
		City c = cm.getCity(id);
		return c;
	}
	
	@GET
	@Path("/")
	@Produces("application/json")
	public ArrayList<City> getCities(){
		return (ArrayList<City>) cm.getAllCities();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCity(City city){
		System.out.println("City" + city.getName());
		cm.addCity(city);
		return Response.status(201).entity(city).build(); 
	}
	
	@DELETE
	@Path("/{cityId}")
	@Produces("text/html")
	public String deletePerson(@PathParam("cityId") Long id){
		int result = cm.deleteCity(id);
		if (result == 1) {
			return "City deleted";
		} else {
			return "Something went wrong";
		}
	}

}
