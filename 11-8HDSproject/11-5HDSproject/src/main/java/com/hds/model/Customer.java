package com.hds.model;

import javax.persistence.*;

@Entity(name = "Customer")
//@Table(name = "Customer")
public class Customer
{



	@Id
	@Column(name = "CustomerID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
// **this is the original
//	    @Column(name = "AddressID")
//	    private String customer_address_id;
//
//	    public String getCustomer_address_id()
//	    {
//	        return customer_address_id;
//	    }
//
//	    public void setCustomer_address_id(String customer_address_id)
//	    {
//	        this.customer_address_id = customer_address_id;
//	    }
	@ManyToOne(targetEntity = Address.class)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	@Column(name = "LastName")
	private String customer_last_name;

	@Column(name = "FirstName")
	private String customer_first_name;

	@Column(name = "MI")
	private String customer_mi;

	@Column(name = "PhoneNum")
	private String customer_phone_num;

	@Column(name = "Email")
	private String customer_email;

	@Column(name = "OrderCount")
	private int customer_order_count;

	// Getter Setter methods

	public int getCustomer_id()
	{
		return customer_id;
	}

	public void setCustomer_id(int customer_id)
	{
		this.customer_id = customer_id;
	}

	public String getCustomer_last_name()
	{
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name)
	{
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_first_name()
	{
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name)
	{
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_mi()
	{
		return customer_mi;
	}

	public void setCustomer_mi(String customer_mi)
	{
		this.customer_mi = customer_mi;
	}

	public String getCustomer_phone_num()
	{
		return customer_phone_num;
	}

	public void setCustomer_phone_num(String customer_phone_num)
	{
		this.customer_phone_num = customer_phone_num;
	}

	public String getCustomer_email()
	{
		return customer_email;
	}

	public void setCustomer_email(String customer_email)
	{
		this.customer_email = customer_email;
	}

	public int getCustomer_order_count()
	{
		return customer_order_count;
	}

	public void setCustomer_order_count(int customer_order_count)
	{
		this.customer_order_count = customer_order_count;
	}
}
