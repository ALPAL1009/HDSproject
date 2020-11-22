package com.hds.model;

import javax.persistence.*;

@Entity
//@Entity(name = "Address")
@Table(name = "Address")
public class Address
{

	@Id
	@Column(name = "AddressID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;

	@Column(name = "Street")
	private String street;

	@Column(name = "City")
	private String city;

	@Column(name = "State")
	private String state;

	@Column(name = "Zip")
	private String zip;

	public Address(String street, String city, String state, String zip)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address()
	{

	}

	// Getter Setter methods

	public int getAddress_id()
	{
		return address_id;
	}

	public void setAddress_id(int address_id)
	{
		this.address_id = address_id;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}
}
