package com.hibernate.activity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.activity.entity.Employee;


public class DeleteEmployeeDemo {

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
			
			Employee myEmployee = session.get(Employee.class, "Aman");
			
			session.delete(myEmployee);
			System.out.println("Employee deleted ");
			
			session.getTransaction().commit();
			
			
		}
		finally 
		{
			factory.close();
		}
		
	}

}
