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
import com.project.Event.services.GuestsService;
import com.project.Event.servicesImpl.EventServiceImpl;
import com.project.Event.servicesImpl.GuestsServiceImpl;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Guests;

public class GuestServiceImplTest {
	static SessionFactory sessionFactory;
	static Session session;
	static GuestsService guestService;
	static EventService eventService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		guestService = new GuestsServiceImpl();
		eventService = new EventServiceImpl();

	}

	@Test
	void testSaveGuest() {
		Event event = eventService.findById(2);
		Guests guest = new Guests(1, 'A', "Sriveni", "sriveni@gmail.com", 7788994433L, event);

		assertTrue(guestService.saveGuest(guest));
	}

	@Test
	void testGetAllGuestByEventId() {
		List<Guests> guests = guestService.findGuestsByEventId(2);
		assertNotNull(guests);
		assertFalse(guests.isEmpty());
	} 

	@Test
	void testGetGuestById() {
		Guests guest = guestService.findById(1);
		assertNotNull(guest);
		assertEquals(1, guest.getGuestId());
	}

	@Test
	void testUpdateGuest() {
		Event event = eventService.findById(2);
		boolean guest = guestService.updateGuest(1, "Reddy", "reddy@gmail.com", 6699887744L, event);
	}

	@Test
	void testDeleteGuest() {
		boolean guest = guestService.deleteGuest(1);
		assertTrue(guest);
	}

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
