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

import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.PersonManager;

@Path("persons")
public class PersonRESTService {	
	
	private PersonManager pm = new PersonManager();
	
	@GET
	@Path("/{personId}")
	@Produces("application/json")
	public Person getPerson(@PathParam("personId") Long id){
		Person p = pm.getPerson(id);
		return p;
	}
	
	@DELETE
	@Path("/{personId}")
	@Produces("text/html")
	public String deletePerson(@PathParam("personId") Long id){
		int result = pm.deletePerson(id);
		if (result == 1) {
			return "Person deleted";
		} else {
			return "Something went wrong";
		}
	}
	
	@GET
	@Path("/")
	@Produces("application/json")
	public ArrayList<Person> getAllPersons(){
		return (ArrayList<Person>)pm.getAllPersons();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person){
		System.out.println("Person" + person.getFirstName());
		pm.addPerson(person);
		return Response.status(201).entity(person).build(); 
	}
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}

}
