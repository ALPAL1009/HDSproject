package com.hds.util;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.model.ProductPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConfigDatabase
{
	public int getNextAddressId()
	{
		Transaction transaction = null;
		int addressID = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "select max(address.AddressID) from hds.address";
			List IDResult = session.createSQLQuery(queryString).list();
			addressID = Integer.parseInt(IDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return addressID;
	}

	public int getNextCustomerId()
	{
		Transaction transaction = null;
		int customerID = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "select max(CustomerID) from hds.customer";
			List customerIDResult = session.createSQLQuery(queryString).list();
			customerID = Integer.parseInt(customerIDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customerID;
	}

	public void addToDataBase(Object object)
	{
		System.out.println("Adding " + object.toString());
		Transaction transaction = null;
		try (
				Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			session.save(object);

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

	public List customerViewDB()
	{
		Transaction transaction = null;
		List customerList = new ArrayList<CustomerPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT " +
					"c.CustomerID, " +
					"c.LastName, " +
					"c.FirstName, " +
					"c.MI, " +
					"c.PhoneNum, " +
					"c.Email, " +
					"c.OrderCount, " +
					"c.AccountBalance, " +
					"a.Street, " +
					"a.City, " +
					"a.State, " +
					"a.Zip " +
					"FROM hds.customer c " +
					"INNER JOIN hds.address a ON c.AddressID = a.AddressID";

			SQLQuery query = session.createSQLQuery(queryString);
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

	//	public void deleteItem(int idToDoList)
	//	{
	//		Transaction transaction = null;
	//		try (Session session = HibernateUtil.getSessionFactory().openSession())
	//		{
	//			transaction = session.beginTransaction();
	//
	//			CustomerPojo customerPojo = session.get(CustomerPojo.class, idToDoList);
	//			if(customerPojo != null)
	//			{
	//				// deleting to_do item
	//				session.delete(customerPojo);
	//				System.out.println("Deleted todolistEntity item");
	//			}
	//
	//			transaction.commit();
	//		}catch(Exception e)
	//		{
	//			if(transaction != null)
	//			{
	//				transaction.rollback();
	//			}
	//			e.printStackTrace();
	//		}
	//	}

	//	public CustomerPojo getItem(int id)
	//	{
	//		Transaction transaction = null;
	//		CustomerPojo customerPojo = null;
	//		try (Session session = HibernateUtil.getSessionFactory().openSession())
	//		{
	//			transaction = session.beginTransaction();
	//
	//			customerPojo = session.get(CustomerPojo.class, id);
	//
	//			transaction.commit();
	//		}catch(Exception e)
	//		{
	//			if(transaction != null)
	//			{
	//				transaction.rollback();
	//			}
	//			e.printStackTrace();
	//		}
	//		return customerPojo;
	//	}



}

