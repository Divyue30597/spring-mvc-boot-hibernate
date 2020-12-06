package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class CreateDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
//			Instructor tempInstructor = 
//					new Instructor("Chad", "Derby", "derby@luv2code.com");
//			
//			InstructorDetail tempInstructorDetail = 
//					new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");
			
			Instructor tempInstructor = new Instructor("Madhu","Patel", "madhupatel@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "Guitar");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Start a transaction
			session.beginTransaction();
			
			//save the instructors
			//NOTE: this will also save the instructordetails object
			// because of CascadeType.ALL
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
