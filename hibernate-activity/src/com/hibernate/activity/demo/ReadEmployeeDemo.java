package com.hibernate.activity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.activity.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			
			session.beginTransaction();
			
			System.out.println("Retrieving row using primary key\n");
			Employee myEmployee = session.get(Employee.class, "Aman");
			System.out.println(myEmployee);
			
			session.getTransaction().commit();
			
			
		}
		finally 
		{
			factory.close();
		}
	}

}
