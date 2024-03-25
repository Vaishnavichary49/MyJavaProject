package com.project.Event.servicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.EventManagementSystem.dao.EventPlannersDAO; // Assuming EventPlannersDAO interface exists
import com.project.EventManagementSystem.daoImpl.EventPlannersDAOImpl;
import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;
import com.project.Event.services.EventPlannersService;

public class EventPlannersServiceImpl implements EventPlannersService {

	EventPlannersDAO eventPlannersDao = new EventPlannersDAOImpl();
	
	@Override
	public boolean saveEventPlanner(EventPlanners eventPlanner) {	
		return eventPlannersDao.saveEventPlanner(eventPlanner);
	}

	@Override
	public EventPlanners findById(int eventPlannerId) {
		return eventPlannersDao.findById(eventPlannerId);
	}

	@Override
	public boolean updateEventPlanner(int eventPlannerId, String name, String email, Long phoneNumber, Event event) {
		return eventPlannersDao.updateEventPlanner(eventPlannerId, name, email, phoneNumber, event);
	}

	@Override
	public boolean deleteEventPlanner(int eventPlannerId) {
		return eventPlannersDao.deleteEventPlanner(eventPlannerId);
	}

	@Override
	public List<EventPlanners> getAllEventPlanners() {
		return eventPlannersDao.getAllEventPlanners();
	}

   
}
