package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.project.Event.HibernateUtil.HibernateUtil;
import com.project.EventManagementSystem.dao.SponsorsDAO;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Guests;
import com.project.EventManagementSystem.entities.Sponsors;

public class SponsersDAOImpl implements SponsorsDAO {

	@Override
	public boolean saveSponsor(Sponsors sponsor) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(sponsor);
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
	public Sponsors findById(int sponsorId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Sponsors sponsor = session.get(Sponsors.class, sponsorId);
			session.getTransaction().commit();
			return sponsor;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	@Override
	public boolean updateSponsor(int sponserId, String name, String email, Long mobileNumber, Event event) {
		Sponsors existSponsor = null;

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			existSponsor = session.load(Sponsors.class, sponserId);
			// update
			if (existSponsor != null) {

				existSponsor.setName(name);
				existSponsor.setEmail(email);
				existSponsor.setMobileno(mobileNumber);
				existSponsor.setEvent(event);

				session.update(existSponsor);
				session.getTransaction().commit();
				System.out.println("Guest with ID " + sponserId + " updated successfully.");
				return true;
			} else {
				System.out.println("Guest with ID " + sponserId + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return false;
	}

	@Override
	public boolean deleteSponsor(int sponsorId) {
		try (Session session = HibernateUtil.getSession()) {

			Sponsors sponsor = session.get(Sponsors.class, sponsorId);

			session.beginTransaction();
			if (sponsor != null) {
				sponsor.setRecord_status('I');
				session.saveOrUpdate(sponsor);
				session.getTransaction().commit();

				System.out.println("Sponsor deleted successfully.");

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
	public List<Sponsors> findSponsorsByEventId(int sponsorId) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();

			String hqlQuery = "Select * from Event where event_id =eventId";

			List<Sponsors> guests = session.createNativeQuery(hqlQuery, Sponsors.class)
					.setParameter("sponsorId", sponsorId).getResultList();

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
