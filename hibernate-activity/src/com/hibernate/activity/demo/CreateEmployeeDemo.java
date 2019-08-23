package com.hibernate.activity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.activity.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) 
	{

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		try
		{
			
			Employee emp1 = new Employee("Deepankar" , "Pathak" , "ATMECS" );
			Employee emp2 = new Employee("Deepak" , "Gupt" , "BHU" );
			Employee emp3 = new Employee("Ritesh" , "Verma" , "Cognizant" );
			Employee emp4 = new Employee("Aman" , "Bhadwa" , "ATMECS" );
			
			System.out.println(emp1);
			System.out.println(emp3);
			
			
			session.beginTransaction();
			
			
			System.out.println("Saving employees");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

}
