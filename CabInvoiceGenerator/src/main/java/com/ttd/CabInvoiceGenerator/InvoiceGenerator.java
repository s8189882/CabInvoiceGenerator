package com.ttd.CabInvoiceGenerator;

import java.util.HashMap;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;
	private HashMap<String, Ride[]> rideRepository = new HashMap<>();

	public double calculateFare(double distance, int time) {
		double fare = (distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE);
		return Math.max(fare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double fareTotal = 0;
		for(Ride ride : rides) {
			fareTotal += this.calculateFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rides.length, fareTotal);
	}
	
	public void addRides(String userID, Ride rides[]) {
		rideRepository.put(userID, rides);
	}
	
	public InvoiceSummary getRides(String userID) {
		return calculateFare(rideRepository.get(userID));
	}
}
