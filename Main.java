package com.taxi;
import java.util.*;

public class Main {
	static List<Taxi> TaxiList = new ArrayList<Taxi>();// To creating list of objects using array of list for TAXI

	public static void main(String[] args) {
		createTaxi(5);
		Scanner sc = new Scanner(System.in);
		int choice;
		boolean flag = true;
		while (flag) {
			System.out.print("Enter your choice 1-Book 2-Print Details  3-Exit  : ");  //User Inputs
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				Customer cust = new Customer();
				cust.createCust();
				for (int i = 0; i < 5; i++) {
					if (TaxiList.get(i).Isavailable(cust.st_mins)) {         // To check the taxi available
						TaxiList.get(i).bookTaxi(i + 1, cust);
						break;
					}
				}
			}
				break;
			case 2:
				for (int i = 0; i < 5; i++) {
					System.out.println("Travel History of Taxi - " + (i + 1));
					TaxiList.get(i).printCustDetails();// To print the customer details
				}
				break;
			case 3:
				flag = false;

			}
		}
		sc.close();
	}

	static void createTaxi(int num) {
		for (int i = 0; i < num; i++)
			TaxiList.add(new Taxi()); // Adding members in list
	}
}
