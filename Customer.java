package com.taxi;

import java.util.Scanner;

public class Customer {
	static int NoOfCust = 0;
	int CustId;
	char StartingPoint; // Declaring customer class instances
	char DestPoint;
	float time;
	int st_mins;
	int dt_mins;
	int amount;

	public void createCust() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Pickup point : "); // Receiving inputs from the user
		this.StartingPoint = sc.next().charAt(0);
		System.out.print("Dest Point : ");
		this.DestPoint = sc.next().charAt(0);
		System.out.print("Pickup Time : ");
		this.time = sc.nextFloat();
		if (sc.next().charAt(1) == 'P') // To check whether it is AM or PM
			time += 12; // To convert time to 24 hours format
		// sc.close();
		this.CustId = ++NoOfCust;
		st_mins = tomins(time);

	}

	public void printDetails() {
		System.out.println("     ");
		System.out.print(this.CustId + " " + this.StartingPoint + " " + this.DestPoint + " " + this.time + " ");
		totime(this.dt_mins);
		System.out.println("  " + this.amount);// Printing the required output
	}

	public static int tomins(float time) {
		return (int) time * 60 + (int) Math.round(time * 100) % 100; // To convert hours format to minutes format
	}

	public static void totime(int mins) {
		System.out.print(mins / 60 + "." + mins % 60); // To convert minutes to hours
	}
}