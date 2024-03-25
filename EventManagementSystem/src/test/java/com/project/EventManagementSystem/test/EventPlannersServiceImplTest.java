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
import com.project.Event.services.EventPlannersService;
import com.project.Event.services.EventService;
import com.project.Event.servicesImpl.EventPlannersServiceImpl;
import com.project.Event.servicesImpl.EventServiceImpl;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;

public class EventPlannersServiceImplTest {
	static SessionFactory sessionFactory;
	static Session session;
	static EventPlannersService eventPlannersService;
	static EventService eventService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		eventPlannersService = new EventPlannersServiceImpl();
		eventService = new EventServiceImpl();

	}

	@Test
	void testSaveEventPlanner() {
		Event event = eventService.findById(2);
		EventPlanners eventPlanner = new EventPlanners(2, 'A', "Pranathi", "pranathi@gmail.com", 7788994466L, event);

		assertTrue(eventPlannersService.saveEventPlanner(eventPlanner));
	} 

	@Test
	void testGetAllEventPlanners() {
		List<EventPlanners> eventPlanners = eventPlannersService.getAllEventPlanners();
		assertNotNull(eventPlanners);
		assertFalse(eventPlanners.isEmpty());
	} 

	@Test
	void testGetEventPlannerById() {
		EventPlanners eventPlanner = eventPlannersService.findById(1);
		assertNotNull(eventPlanner);
		assertEquals(1, eventPlanner.getEventPlannerId());
	}

	@Test
	void testUpdateEvent() {
		Event event = eventService.findById(1);
		boolean eventPlanner = eventPlannersService.updateEventPlanner(1, "Venkat", "vaishu@gmail.com", 9988776655L, event);
	}

	@Test
	void testDeleteEventPlanner() {
		boolean eventPlanner = eventPlannersService.deleteEventPlanner(1);
		assertTrue(eventPlanner);
	} 

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
