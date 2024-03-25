package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.Event.HibernateUtil.HibernateUtil;
import com.project.EventManagementSystem.dao.GuestsDAO;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Guests;

public class GuestsDAOImpl implements GuestsDAO {

	@Override
	public boolean saveGuest(Guests guest) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(guest);
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
	public Guests findById(int guestId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Guests guest = session.get(Guests.class, guestId);
			session.getTransaction().commit();
			return guest;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	@Override
	public boolean updateGuest(int guestId, String name, String email, Long mobileNumber, Event event) {
		Guests existGuest = null;

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			existGuest = session.load(Guests.class, guestId);
			// update
			if (existGuest != null) {

				existGuest.setName(name);
				existGuest.setEmail(email);
				existGuest.setMobile_no(mobileNumber);
				existGuest.setEvent(event);

				session.update(existGuest);
				session.getTransaction().commit();
				System.out.println("Guest with ID " + guestId + " updated successfully.");
				return true;
			} else {
				System.out.println("Guest with ID " + guestId + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return false;
	}

	@Override
	public boolean deleteGuest(int guestId) {
		try (Session session = HibernateUtil.getSession()) {

			Guests guest = session.get(Guests.class, guestId);

			session.beginTransaction();
			if (guest != null) {
				guest.setRecord_status('I');
				session.saveOrUpdate(guest);
				session.getTransaction().commit();

				System.out.println("Guest deleted successfully.");

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
	public List<Guests> findGuestsByEventId(int eventId) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();

			String hqlQuery = "Select * from Guests where event_id =eventId";

			List<Guests> guests = session.createNativeQuery(hqlQuery, Guests.class)
					.setParameter("eventId", eventId).getResultList();

			transaction.commit();
			return guests;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
