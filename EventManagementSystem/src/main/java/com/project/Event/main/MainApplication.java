package com.project.Event.main;

import java.util.Scanner;

public class MainApplication {
	static Scanner scanner = new Scanner(System.in);

	public static void mainOps() {
		while (true) {
			System.out.println("Welcome to Event Management System:\n " + "***********************************\n"
					+ " 1.Event Details\n" + " 2.EventPlanner Details\n " + "3.Guests Details \n"
					+ " 4.Sponsors Details \n " +"5.Vendors Details \n "+" 6.Exit\n Enter your choice");

			int input = scanner.nextInt();

			switch (input) {
			case 1:
				AllOperations.eventOperations();
				System.out.println("******************");
				break;

			case 2:
				AllOperations.eventPlannersOperations();
				System.out.println("******************");
				break;

			case 3:
				AllOperations.guestsOperations();
				System.out.println("******************");
				break;

			case 4:
				AllOperations.sponsorsOperations();
				System.out.println("******************");
				break;
				
			case 5:
				AllOperations.vendorsOperations();
				System.out.println("******************");
				break;

			case 6:
				System.exit(0);
			default:
				System.out.println("Entered wrong choice. Please choose correct choice...");
			}

		}
	}

	public static void main(String args[]) {
		mainOps();

	}
}
