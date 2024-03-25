package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.Event.HibernateUtil.HibernateUtil;
import com.project.EventManagementSystem.dao.EventDAO;
import com.project.EventManagementSystem.entities.Event;

public class EventDAOImpl implements EventDAO {
	
	@Override
	public boolean saveEvent(Event event) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(event);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return false;
	}

	@Override
	public Event findById(int eventId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Event event = session.get(Event.class, eventId);
			session.getTransaction().commit();
			return event;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	@Override
	public boolean updateEvent(int eventId, String name, String time, String date, String location) {
		Event existEvent = null;
		
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			existEvent = session.load(Event.class, eventId);
			// update
			if (existEvent != null) {
				
				existEvent.setEventName(name);
				existEvent.setDate(date);
				existEvent.setTime(time);
				existEvent.setLocation(location);

				session.update(existEvent);
				session.getTransaction().commit();
				System.out.println("Event with ID " + eventId + " updated successfully.");
				return true;
			} else {
				System.out.println("Event with ID " + eventId + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return false;
	}

	@Override
	public boolean deleteEvent(int eventId) {
		try (Session session = HibernateUtil.getSession()) {

			Event event = session.get(Event.class, eventId);

			session.beginTransaction();
			if (event != null) {
				event.setRecord_status('I');
				session.saveOrUpdate(event);
				session.getTransaction().commit();

				System.out.println("Event deleted successfully.");

				return true;
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);

		}
		return false;
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> events = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			events = session.createQuery("FROM Event", Event.class).getResultList();
			session.getTransaction().commit();
			System.out.println("Event details retrieved successfully.");
			return events;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return events;
	}

	
}
