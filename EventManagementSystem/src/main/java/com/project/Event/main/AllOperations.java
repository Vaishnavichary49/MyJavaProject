package com.project.Event.main;

import java.util.List;
import java.util.Scanner;

import com.anudip.HotelManagement.entities.Booking;
import com.project.Event.services.*;
import com.project.Event.servicesImpl.EventPlannersServiceImpl;
import com.project.Event.servicesImpl.EventServiceImpl;
import com.project.Event.servicesImpl.GuestsServiceImpl;
import com.project.Event.servicesImpl.SponsorsServiceImpl;
import com.project.Event.servicesImpl.VendorsServiceImpl;
import com.project.EventManagementSystem.entities.*;

public class AllOperations {
	static EventService eventService = new EventServiceImpl();
	static EventPlannersService eventPlannersService = new EventPlannersServiceImpl();
	static GuestsService guestService = new GuestsServiceImpl();
	static SponsorsService sponsorsService = new SponsorsServiceImpl();
	static VendorsService vendorsService = new VendorsServiceImpl();

	static Scanner scanner = new Scanner(System.in);

	public static <T> T getEntityById(Scanner scanner, String entityType) {
		System.out.print("Enter " + entityType + " ID: ");
		int entityId = scanner.nextInt();
		return null;
	}

	public static Event eventInputs() {
		scanner.nextLine();
		System.out.println("Enter Event Id: ");
		int eventId = scanner.nextInt();

		System.out.println("Enter event name: ");
		String eventName = scanner.nextLine();

		System.out.println("Enter event date: ");
		String eventDate = scanner.nextLine();

		System.out.println("Enter event time: ");
		String eventTime = scanner.nextLine();

		System.out.println("Enter event location: ");
		String eventLocation = scanner.nextLine();

		return new Event(eventId, eventName, eventDate, eventTime, eventLocation);

	}

	public static EventPlanners eventPlannersInputs() {
		scanner.nextLine();

		System.out.println("Enter EventPlanner Id: ");
		int ePId = scanner.nextInt();

		System.out.println("Enter EventPlanner Name: ");
		String ePName = scanner.nextLine();

		System.out.println("Enter EventPlanner email: ");
		String ePEmail = scanner.nextLine();

		System.out.println("Enter EventPlanner mobile Number: ");
		Long ePMobile = scanner.nextLong();

		System.out.println("Enter event id: ");
		int eventId = scanner.nextInt();
		Event event = eventService.findById(eventId);

		return new EventPlanners(ePId, ePName, ePEmail, ePMobile, event);

	}

	public static Guests guestInputs() {
		scanner.nextLine();

		System.out.println("Enter Guest id: ");
		int gId = scanner.nextInt();

		System.out.println("Enter Guest Name: ");
		String gName = scanner.nextLine();

		System.out.println("Enter Guest Email: ");
		String gEmail = scanner.nextLine();

		System.out.println("Enter guest Mobile No: ");
		Long gMobile = scanner.nextLong();

		System.out.println("Enter event id: ");
		int eventId = scanner.nextInt();
		Event event = eventService.findById(eventId);

		return new Guests(gId, gName, gEmail, gMobile, event);
	}

	public static Sponsors sponsorsInputs() {
		scanner.nextLine();

		System.out.println("Enter sponsor id: ");
		int sId = scanner.nextInt();

		System.out.println("Enter sponsor name: ");
		String sName = scanner.nextLine();

		System.out.println("Enter sponsor email: ");
		String sEmail = scanner.nextLine();

		System.out.println("Enter sponsor Mobile: ");
		Long sMobile = scanner.nextLong();

		System.out.println("Enter event id: ");
		int eventId = scanner.nextInt();
		Event event = eventService.findById(eventId);

		return new Sponsors(sId, sName, sEmail, sMobile, event);

	}

	public static Vendors vendorsInputs() {
		scanner.nextLine();

		System.out.println("Enter vendor id: ");
		int vId = scanner.nextInt();

		System.out.println("Enter vendor name :");
		String vName = scanner.nextLine();

		System.out.println("Enter vendor email: ");
		String vEmail = scanner.nextLine();

		System.out.println("Enter vendor Mobile: ");
		Long vMobile = scanner.nextLong();

		System.out.println("Enter vendor service: ");
		String vService = scanner.nextLine();

		System.out.println("Enter event id: ");
		int eventId = scanner.nextInt();
		Event event = eventService.findById(eventId);

		return new Vendors(vId, vName, vEmail, vMobile, vService, event);
	}

	public static void eventOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Event ");
			System.out.println("2. Get event by id");
			System.out.println("3. Get all Events");
			System.out.println("4. Update Event by id");
			System.out.println("5. Delet event by id");
			System.out.println("6. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Event event = eventInputs();
				boolean savedEntity = eventService.saveEvent(event);
				System.out.println("Event details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Event id: ");
				int id = scanner.nextInt();
				Event eventbyId = eventService.findById(id);
				System.out.println("Event details: " + eventbyId);
				break;

			case 3:
				List<Event> events = eventService.getAllEvents();
				for (Event event1 : events) {
					System.out.println(event1);
				}
				break;

			case 4:
				System.out.println("Enter the Event details you want to Update");
				int eid = scanner.nextInt();
				String ename = scanner.nextLine();
				String edate = scanner.nextLine();
				String etime = scanner.nextLine();
				String elocation = scanner.nextLine();
				boolean update = eventService.updateEvent(eid, ename, edate, etime, elocation);
				break;

			case 5:
				System.out.println("Enter the Event id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = eventService.deleteEvent(deletebyId);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void eventPlannersOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new EventPlanners ");
			System.out.println("2. Get eventPlanner by id");
			System.out.println("3. Get all EventPlanner");
			System.out.println("4. Update EventPlanner by id");
			System.out.println("5. Delet eventPlanner by id");
			System.out.println("6. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				EventPlanners eventPlanners = eventPlannersInputs();
				boolean savedEntity = eventPlannersService.saveEventPlanner(eventPlanners);
				System.out.println("EventPlanner details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the EventPlanner id: ");
				int id = scanner.nextInt();
				EventPlanners eventPlannerbyId = eventPlannersService.findById(id);
				System.out.println("Event details: " + eventPlannerbyId);
				break;

			case 3:
				List<EventPlanners> ePlanners = eventPlannersService.getAllEventPlanners();
				for (EventPlanners eventPlanner : ePlanners) {
					System.out.println(ePlanners);
				}
				break;

			case 4:
				System.out.println("Enter the EventPlanner details you want to Update");
				int epid = scanner.nextInt();
				String epname = scanner.nextLine();
				String epemail = scanner.nextLine();
				Long epmobile = scanner.nextLong();
				int eventId = scanner.nextInt();
				Event event = eventService.findById(eventId);
				boolean update = eventPlannersService.updateEventPlanner(epid, epname, epemail, epmobile, event);
				break;

			case 5:
				System.out.println("Enter the EventPlanner id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = eventPlannersService.deleteEventPlanner(deletebyId);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void guestsOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Guest ");
			System.out.println("2. Get guest by id");
			System.out.println("3. Get all Guests");
			System.out.println("4. Update Guest by id");
			System.out.println("5. Delet Guest by id");
			System.out.println("6. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Guests guests = guestInputs();
				boolean savedEntity = guestService.saveGuest(guests);
				System.out.println("Guest details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Guest id: ");
				int id = scanner.nextInt();
				Guests guestbyId = guestService.findById(id);
				System.out.println("Guest details: " + guestbyId);
				break;

			case 3:
				System.out.println("Enter event id to see all perticular event guests");
				int eventId = scanner.nextInt();
				List<Guests> eguests = guestService.findGuestsByEventId(eventId);
				for (Guests guest : eguests) {
					System.out.println(guest);
				}
				break;

			case 4:
				System.out.println("Enter the Guest details you want to Update");
				int gid = scanner.nextInt();
				String gname = scanner.nextLine();
				String gemail = scanner.nextLine();
				Long gmobile = scanner.nextLong();
				int geventId = scanner.nextInt();
				Event event = eventService.findById(geventId);
				boolean update = guestService.updateGuest(gid, gname, gemail, gmobile, event);
				break;

			case 5:
				System.out.println("Enter the Guest id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = guestService.deleteGuest(deletebyId);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void sponsorsOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Sponsor ");
			System.out.println("2. Get Sponsor by id");
			System.out.println("3. Get all Sponsors");
			System.out.println("4. Update Sponsor by id");
			System.out.println("5. Delete Sponsor by id");
			System.out.println("6. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Sponsors sponsors = sponsorsInputs();
				boolean savedEntity = sponsorsService.saveSponsor(sponsors);
				System.out.println("Sponsor details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Sponsor id: ");
				int id = scanner.nextInt();
				Sponsors sponsorbyId = sponsorsService.findById(id);
				System.out.println("Sponsor details: " + sponsorbyId);
				break;

			case 3:
				System.out.println("Enter event id to see all perticular event sponsors");
				int eventId = scanner.nextInt();
				List<Sponsors> esponsors = sponsorsService.findSponsorsByEventId(eventId);
				for (Sponsors sponsor : esponsors) {
					System.out.println(sponsor);
				}
				break;

			case 4:
				System.out.println("Enter the Sponsor details you want to Update");
				int sid = scanner.nextInt();
				String sname = scanner.nextLine();
				String semail = scanner.nextLine();
				Long smobile = scanner.nextLong();
				int seventId = scanner.nextInt();
				Event event = eventService.findById(seventId);
				boolean update = sponsorsService.updateSponsor(sid, sname, semail, smobile, event);
				break;

			case 5:
				System.out.println("Enter the Sponsor id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = sponsorsService.deleteSponsor(deletebyId);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

	public static void vendorsOperations() {
		while (true) {
			System.out.println("Choose any ony one option: ");
			System.out.println("1. Create new Vendor ");
			System.out.println("2. Get Vendor by id");
			System.out.println("3. Get all Vendors");
			System.out.println("4. Update Vendor by id");
			System.out.println("5. Delete Vendor by id");
			System.out.println("6. Go back to main menu");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				Vendors vendors = vendorsInputs();
				boolean savedEntity = vendorsService.saveVendor(vendors);
				System.out.println("Vendor details saved successfully" + savedEntity);
				break;

			case 2:
				System.out.println("Enter the Vendor id: ");
				int id = scanner.nextInt();
				Vendors vendorbyId = vendorsService.findById(id);
				System.out.println("Vendor details: " + vendorbyId);
				break;

			case 3:
				List<Vendors> evendors = vendorsService.getAllVendors();
				for (Vendors vendor : evendors) {
					System.out.println(vendor);
				}
				break;

			case 4:
				System.out.println("Enter the Vendor details you want to Update");
				int vid = scanner.nextInt();
				String vname = scanner.nextLine();
				String vemail = scanner.nextLine();
				Long vmobile = scanner.nextLong();
				int veventId = scanner.nextInt();
				Event event = eventService.findById(veventId);
				boolean update = sponsorsService.updateSponsor(vid, vname, vemail, vmobile, event);
				break;

			case 5:
				System.out.println("Enter the Vendor id you want to delete");
				int deletebyId = scanner.nextInt();
				boolean delete = vendorsService.deleteVendor(deletebyId);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			default:
				System.out.println("Invalid option. Please choose again.");

			}

		}

	}

}
