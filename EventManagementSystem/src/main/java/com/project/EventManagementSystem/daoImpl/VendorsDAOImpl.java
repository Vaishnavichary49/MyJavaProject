package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.project.Event.HibernateUtil.HibernateUtil;
import com.project.EventManagementSystem.dao.VendorsDAO;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Vendors;

public class VendorsDAOImpl implements VendorsDAO {

	@Override
	public boolean saveVendor(Vendors vendor) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(vendor);
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
	public Vendors findById(int vendorId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Vendors vendor = session.get(Vendors.class, vendorId);
			session.getTransaction().commit();
			return vendor;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	@Override
	public boolean updateVendor(int vendorId, String name, String email, Long mobileNumber, String service,
			Event event) {
		Vendors existVendor = null;

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			existVendor = session.load(Vendors.class, vendorId);
			// update
			if (existVendor != null) {

				existVendor.setName(name);
				existVendor.setEmail(email);
				existVendor.setMobileNo(mobileNumber);
				existVendor.setService(service);
				existVendor.setEvent(event);

				session.update(existVendor);
				session.getTransaction().commit();
				System.out.println("Vendor with ID " + vendorId + " updated successfully.");
				return true;
			} else {
				System.out.println("Vendor with ID " + vendorId + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return false;
	}

	@Override
	public boolean deleteVendor(int vendorId) {
		try (Session session = HibernateUtil.getSession()) {

			Vendors vendor = session.get(Vendors.class, vendorId);

			session.beginTransaction();
			if (vendor != null) {
				vendor.setRecord_status('I');
				session.saveOrUpdate(vendor);
				session.getTransaction().commit();

				System.out.println("Vendor deleted successfully.");

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
	public List<Vendors> getAllVendors() {
		List<Vendors> vendors = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			vendors = session.createQuery("FROM Vendors", Vendors.class).getResultList();
			session.getTransaction().commit();
			System.out.println("Vendors details retrieved successfully.");
			return vendors;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return vendors;
	}

}
