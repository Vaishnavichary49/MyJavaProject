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
import com.project.Event.servicesImpl.EventServiceImpl;
import com.project.EventManagementSystem.entities.Event;

public class EventServiceImplTest {
	static SessionFactory sessionFactory;
	static Session session;
	static EventService eventService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		eventService = new EventServiceImpl();

	}

	@Test
	void testSaveEvent() {
		Event event = new Event(1, 'A', "Freshers", "2024-03-17", "10:30 AM", "Hyderabad");

		assertTrue(eventService.saveEvent(event));
	}

	@Test
	void testGetAllEvents() {
		List<Event> events = eventService.getAllEvents();
		assertNotNull(events);
		assertFalse(events.isEmpty());
	}

	@Test
	void testGetEventById() {
		Event event = eventService.findById(1);
		assertNotNull(event);
		assertEquals(1, event.getEventId());
	}

	@Test
	void testUpdateEvent() {
		boolean event = eventService.updateEvent(2, "Fairwell", "7:30 PM", "14-11-2024", "Hyderabad");
	}

	@Test
	void testDeleteEvent() {
		boolean event = eventService.deleteEvent(1);
		assertTrue(event);
	}

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
