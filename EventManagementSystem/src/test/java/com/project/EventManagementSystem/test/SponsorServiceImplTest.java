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
import com.project.Event.services.SponsorsService;
import com.project.Event.servicesImpl.EventPlannersServiceImpl;
import com.project.Event.servicesImpl.EventServiceImpl;
import com.project.Event.servicesImpl.SponsorsServiceImpl;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;
import com.project.EventManagementSystem.entities.Sponsors;

public class SponsorServiceImplTest {
	static SessionFactory sessionFactory;
	static Session session;
	static SponsorsService sponsorsService;
	static EventService eventService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		sponsorsService = new SponsorsServiceImpl();
		eventService = new EventServiceImpl();

	}

	@Test
	void testSaveSponsors() {
		Event event = eventService.findById(2);
		Sponsors sponsor = new Sponsors(2, 'A', "Pranathi", "pranathi@gmail.com", 7788994466L, event);
		assertTrue(sponsorsService.saveSponsor(sponsor));
	} 

/*	@Test
	void testGetAllSponsorsByEventId() {
		List<Sponsors> sponsors = sponsorsService.findSponsorsByEventId(2);
		assertNotNull(sponsors);
		assertFalse(sponsors.isEmpty());
	} */

	@Test
	void testGetSponsorsById() {
		Sponsors sponsor = sponsorsService.findById(1);
		assertNotNull(sponsor);
		assertEquals(1, sponsor.getSponsorId());
	}

	@Test
	void testUpdateSponsor() {
		Event event = eventService.findById(1);
		boolean sponsor = sponsorsService.updateSponsor(1, "Venkat", "vaishu@gmail.com", 9988776655L, event);
	}

	@Test
	void testDeleteSponsor() {
		boolean eventPlanner = sponsorsService.deleteSponsor(1);
		assertTrue(eventPlanner);
	} 

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
