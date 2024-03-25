package com.project.Event.servicesImpl;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Sponsors;
import com.project.Event.services.SponsorsService;
import com.project.EventManagementSystem.dao.SponsorsDAO; // Assuming SponsorsDAO interface exists
import com.project.EventManagementSystem.daoImpl.SponsersDAOImpl;

public class SponsorsServiceImpl implements SponsorsService {

	SponsorsDAO sponsorDao = new SponsersDAOImpl();
	
	@Override
	public boolean saveSponsor(Sponsors sponsor) {
		return sponsorDao.saveSponsor(sponsor);
	}

	@Override
	public Sponsors findById(int sponsorId) {
		return sponsorDao.findById(sponsorId);
	}

	@Override
	public boolean updateSponsor(int sponserId, String name, String email, Long mobileNumber, Event event) {
		return sponsorDao.updateSponsor(sponserId, name, email, mobileNumber, event);
	}

	@Override
	public boolean deleteSponsor(int sponsorId) {
		return sponsorDao.deleteSponsor(sponsorId);
	}

	@Override
	public List<Sponsors> findSponsorsByEventId(int eventId) {
		return sponsorDao.findSponsorsByEventId(eventId);
	}

   
}
