package com.hds.util;

import com.hds.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ConfigDatabase
{

	public void addItem(Customer customerPojo)
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

			Customer customerPojo = session.get(Customer.class, idToDoList);
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

	public Customer getItem(int id)
	{
		Transaction transaction = null;
		Customer customerPojo = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			// getting to_do item
			customerPojo = session.get(Customer.class, id);

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

	public List<Customer> viewDB()
	{
		Transaction transaction = null;
		List <Customer> customerList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
//			Query query = session.createQuery("FROM CustomerPojo");
			Query query = session.createQuery("FROM Customer c inner join c.address");

			customerList = query.getResultList();

			//			for(TodolistEntity list : toDoLists)
			//			{
			//				System.out.println(list);
			//			}

		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}return customerList;
	}
}
