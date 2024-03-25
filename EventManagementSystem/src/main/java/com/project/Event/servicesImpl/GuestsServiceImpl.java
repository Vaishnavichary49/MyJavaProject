package com.project.Event.servicesImpl;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Guests;
import com.project.Event.services.GuestsService;
import com.project.EventManagementSystem.dao.GuestsDAO; // Assuming GuestsDAO interface exists
import com.project.EventManagementSystem.daoImpl.GuestsDAOImpl;

public class GuestsServiceImpl implements GuestsService {

	GuestsDAO guestDao = new GuestsDAOImpl();
	
	@Override
	public boolean saveGuest(Guests guest) {
		return guestDao.saveGuest(guest);
	}

	@Override
	public Guests findById(int guestId) {
		return guestDao.findById(guestId);
	}

	@Override
	public boolean updateGuest(int guestId, String name, String email, Long mobileNumber, Event event) {
		return guestDao.updateGuest(guestId, name, email, mobileNumber, event);
	}

	@Override
	public boolean deleteGuest(int guestId) {
		return guestDao.deleteGuest(guestId);
	}

	@Override
	public List<Guests> findGuestsByEventId(int eventId) {
		return guestDao.findGuestsByEventId(eventId);
	}

   
}
