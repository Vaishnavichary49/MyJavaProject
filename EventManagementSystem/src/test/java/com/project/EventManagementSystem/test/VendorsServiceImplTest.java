package com.project.EventManagementSystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.project.Event.HibernateUtil.HibernateUtil;
import com.project.Event.services.EventService;
import com.project.Event.services.VendorsService;
import com.project.Event.servicesImpl.EventPlannersServiceImpl;
import com.project.Event.servicesImpl.EventServiceImpl;
import com.project.Event.servicesImpl.VendorsServiceImpl;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;
import com.project.EventManagementSystem.entities.Vendors;

public class VendorsServiceImplTest {
	static SessionFactory sessionFactory;
	static Session session;
	static VendorsService vendorsService;
	static EventService eventService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		vendorsService = new VendorsServiceImpl();
		eventService = new EventServiceImpl();

	}

	@Test
	void testSaveVendor() {
		Event event = eventService.findById(2);
		Vendors vendor = new Vendors(2, 'A', "Pranathi", "pranathi@gmail.com", 7788994466L, "Food",event);

		assertTrue(vendorsService.saveVendor(vendor));
	} 

	@Test
	void testGetAllVendors() {
		List<Vendors> vendors = vendorsService.getAllVendors();
		assertNotNull(vendors);
		assertFalse(vendors.isEmpty());
	} 

	@Test
	void testGetVendorById() {
		Vendors vendor = vendorsService.findById(1);
		assertNotNull(vendor);
		assertEquals(1, vendor.getVendorId());
	}

	@Test
	void testUpdateVendor() {
		Event event = eventService.findById(1);
		boolean vendor = vendorsService.updateVendor(1, "Chinny", "chinny@gmail.com", 9988776655L,"Food", event);
	}

	@Test
	void testDeleteVendor() {
		boolean vendor = vendorsService.deleteVendor(1);
		assertTrue(vendor);
	} 

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
