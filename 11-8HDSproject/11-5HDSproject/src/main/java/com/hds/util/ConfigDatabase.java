package com.hds.util;

import com.hds.model.Address;
import com.hds.model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Set;

public class ConfigDatabase
{

	private static SessionFactory factory;

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

		// THIS IS GOOD CODE
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



		// ****This is a "TEST" good code is above
//		factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//
//		try {
//			tx = session.beginTransaction();
//
//			String queryText = "select a, c from Address a, Customer c " +
//					" where a.address_id = c.customer_id";
//
//			List rows = session.createQuery(queryText).list();
//
//			for (Object row: rows) {
//				System.out.println(" ------- ");
//				System.out.println("Address: " + row.getClass());
//				System.out.println("Customer: " + row.getClass());
//			}
//
//			session.getTransaction();
//			tx.commit();
//
//
//		} catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		}


//		String hql = "FROM Customer c inner join c.address";
//		Set query = session.createQuery(hql);







	}
}
