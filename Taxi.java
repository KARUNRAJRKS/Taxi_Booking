package com.taxi;

import java.util.*;

public class Taxi {
	int totalEarning;
	char WaitingPoint = 'A'; // Initializing all Taxi to point A
	int freeTime;

	boolean Isavailable(int mins) {
		if (this.freeTime < mins)
			return true;
		else                             // To check whether the Taxi is free
			return false;
	}

	ArrayList<Customer> CustList = new ArrayList<>();

	Taxi() {
		freeTime = 0; // Initializing Taxi constructor
		this.totalEarning = 0;
	}

	public void bookTaxi(int taxiNum, Customer cust) {
		if (cust.StartingPoint != cust.DestPoint)
			CustList.add(cust);
		else {
			System.out.println("Both Start and Destination points are same . \n Taxi is not booked .");
			Customer.NoOfCust--;
			return;
		}
		if (cust.StartingPoint>= 'A' && cust.DestPoint<='E')
		{
		System.out.println("Booking Id " + cust.CustId);
		System.out.println("Alloted Taxi " + taxiNum);
		WaitingPoint = cust.DestPoint;
		cust.dt_mins = cust.st_mins + (cust.DestPoint - cust.StartingPoint) * 15; // To calculate Destination point
		cust.amount = (cust.dt_mins - cust.st_mins) * 10; // To calculate amount for traveling
		freeTime = cust.dt_mins;
		this.totalEarning += cust.amount;
		this.WaitingPoint = cust.DestPoint;
		}
		else 
		{
			Customer.NoOfCust--;
			System.out.println("No Points for travel Found");      // If No points to travel 
		}
	}

	public void printCustDetails() {
		
		Iterator itr = CustList.iterator(); // Creating iterator to retrieve data
		while (itr.hasNext()) {
			((Customer) itr.next()).printDetails(); // To print every customer details
			System.out.println("__________________________________________");
		}
	}
}