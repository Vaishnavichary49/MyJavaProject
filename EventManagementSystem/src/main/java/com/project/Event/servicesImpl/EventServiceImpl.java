package com.project.Event.servicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.EventManagementSystem.dao.EventDAO; // Assuming EventDAO interface exists
import com.project.EventManagementSystem.daoImpl.EventDAOImpl;
import com.project.EventManagementSystem.entities.Event;
import com.project.Event.services.EventService;

public class EventServiceImpl implements EventService {
	
	EventDAO eventDao = new EventDAOImpl();

	@Override
	public boolean saveEvent(Event event) {
		return eventDao.saveEvent(event);
	}

	@Override
	public Event findById(int eventId) {
		return eventDao.findById(eventId);
	}

	@Override
	public boolean updateEvent(int eventId, String name, String time, String date, String location) {
		return eventDao.updateEvent(eventId, name, time, date, location);
	}

	@Override
	public boolean deleteEvent(int eventId) {
		return eventDao.deleteEvent(eventId);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

   
}
