package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.project.Event.HibernateUtil.HibernateUtil;
import com.project.EventManagementSystem.dao.EventPlannersDAO;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;

public class EventPlannersDAOImpl implements EventPlannersDAO {

	@Override
	public boolean saveEventPlanner(EventPlanners eventPlanner) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(eventPlanner);
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
	public EventPlanners findById(int eventPlannerId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			EventPlanners eventPlanner = session.get(EventPlanners.class, eventPlannerId);
			session.getTransaction().commit();
			return eventPlanner;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	@Override
	public boolean updateEventPlanner(int eventPlannerId, String name, String email, Long phoneNumber, Event event) {
		EventPlanners existEventPlanner = null;

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			existEventPlanner = session.load(EventPlanners.class, eventPlannerId);
			// update
			if (existEventPlanner != null) {

				existEventPlanner.setName(name);
				existEventPlanner.setEmail(email);
				existEventPlanner.setPhoneNumber(phoneNumber);
				existEventPlanner.setEvent(event);

				session.update(existEventPlanner);
				session.getTransaction().commit();
				System.out.println("EventPlanner with ID " + eventPlannerId + " updated successfully.");
				return true;
			} else {
				System.out.println("EventPlanner with ID " + eventPlannerId + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return false;
	}

	@Override
	public boolean deleteEventPlanner(int eventPlannerId) {
		try (Session session = HibernateUtil.getSession()) {

			EventPlanners eventPlanner = session.get(EventPlanners.class, eventPlannerId);

			session.beginTransaction();
			if (eventPlanner != null) {
				eventPlanner.setRecord_status('I');
				session.saveOrUpdate(eventPlanner);
				session.getTransaction().commit();

				System.out.println("EventPlanner deleted successfully.");

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
	public List<EventPlanners> getAllEventPlanners() {
		List<EventPlanners> eventPlanners = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			eventPlanners = session.createQuery("FROM EventPlanners", EventPlanners.class).getResultList();
			session.getTransaction().commit();
			System.out.println("EventPlanner details retrieved successfully.");
			return eventPlanners;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return eventPlanners;
	}

}
