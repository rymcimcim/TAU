package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {
	
	private long id;
	
	private String name;
	private int postalCode;
	
	public City() {
	}

	public City(String name, int postalCode) {
		this.name = name;
		this.postalCode = postalCode;
	}
	
	public City(long id, String name, int postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
}
