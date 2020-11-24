package com.hds.util;

import com.hds.model.CustomerPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConfigDatabase
{

	public void addItem(CustomerPojo customerPojo)
	{
		Transaction transaction = null;
		try (
				Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			// saving to_do item
			session.save(customerPojo);

			transaction.commit();

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteItem(int idToDoList)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			CustomerPojo customerPojo = session.get(CustomerPojo.class, idToDoList);
			if(customerPojo != null)
			{
				// deleting to_do item
				session.delete(customerPojo);
				System.out.println("Deleted todolistEntity item");
			}

			transaction.commit();
		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public CustomerPojo getItem(int id)
	{
		Transaction transaction = null;
		CustomerPojo customerPojo = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			// getting to_do item
			customerPojo = session.get(CustomerPojo.class, id);

			transaction.commit();
		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customerPojo;
	}

	public List viewDB()
	{
		Transaction transaction = null;
		List customerList = new ArrayList<CustomerPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();


			SQLQuery query = session.createSQLQuery("SELECT \n" +
					"    c.CustomerID,\n" +
					"    c.LastName,\n" +
					"    c.FirstName,\n" +
					"    c.MI,\n" +
					"    c.PhoneNum,\n" +
					"    c.Email,\n" +
					"    c.OrderCount,\n" +
					"    c.AccountBalance,\n" +
					"    a.Street,\n" +
					"    a.City,\n" +
					"    a.State,\n" +
					"    a.Zip\n" +
					"FROM\n" +
					"    hds.customer c\n" +
					"        INNER JOIN\n" +
					"    hds.address a ON c.AddressID = a.AddressID");
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				CustomerPojo customer = new CustomerPojo();
				customer.setCustomer_id(Integer.parseInt(row[0].toString()));
				// skip row[1] since we don't need to display addressID
				customer.setCustomer_last_name(row[1].toString());
				customer.setCustomer_first_name(row[2].toString());
				customer.setCustomer_mi(row[3].toString());
				if(row[4] != null)
					customer.setCustomer_phone_num(row[4].toString());
				if(row[5] != null)
					customer.setCustomer_email(row[5].toString());
				customer.setCustomer_order_count(Integer.parseInt(row[6].toString()));
				customer.setCustomer_account_balance(Double.parseDouble(row[7].toString()));
				customer.setStreet(row[8].toString());
				customer.setCity(row[9].toString());
				customer.setState(row[10].toString());
				customer.setZip(Integer.parseInt(row[11].toString()));
				customerList.add(customer);
			}

//			customerList = query.getResultList();
			//			for(TodolistEntity list : toDoLists)
			//			{
			//				System.out.println(list);
			//			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customerList;
	}

}

