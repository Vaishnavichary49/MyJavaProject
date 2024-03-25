package com.project.Event.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;
import com.project.EventManagementSystem.entities.Guests;
import com.project.EventManagementSystem.entities.Sponsors;
import com.project.EventManagementSystem.entities.Vendors;
public class HibernateUtil {

	private final static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			return new Configuration().configure("com/project/Event/cfgs/cfgs.xml").addAnnotatedClass(Event.class)
					.addAnnotatedClass(EventPlanners.class)
					.addAnnotatedClass(Guests.class)
					.addAnnotatedClass(Sponsors.class)
					.addAnnotatedClass(Vendors.class)
.buildSessionFactory();

		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession(); // session opened
	}

}