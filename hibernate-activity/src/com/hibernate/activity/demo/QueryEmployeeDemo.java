package com.hibernate.activity.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.activity.entity.Employee;


public class QueryEmployeeDemo {

	public static void main(String[] args)
	{
	
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			
			session.beginTransaction();
			
			List<Employee> resultList = new ArrayList<Employee>();
			
			resultList = session.createQuery("from Employee e where e.company = 'ATMECS'").getResultList();
			
			resultList.stream().forEach(System.out :: println);
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}
	}

}
