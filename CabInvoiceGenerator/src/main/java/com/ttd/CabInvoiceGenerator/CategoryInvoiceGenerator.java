package com.ttd.CabInvoiceGenerator;

import java.util.HashMap;

import com.ttd.CabInvoiceGenerator.Ride.RideCategory;

public class CategoryInvoiceGenerator {
	private HashMap<String, Ride[]> rideRepository = new HashMap<>();

	
	public double calculateFare(double distance, int time, RideCategory category) {
		double fare = (distance * category.minimumCostPerKm + time * category.minimumCostPerMinute);
		return Math.max(fare, category.minimumFare);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double fareTotal = 0;
		for(Ride ride : rides) {
			fareTotal += this.calculateFare(ride.getDistance(), ride.getTime(), ride.getRideCategory());
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
