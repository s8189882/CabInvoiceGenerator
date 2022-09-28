package com.ttd.CabInvoiceGenerator;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double fareTotal = (distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE);
		if (fareTotal < MINIMUM_FARE)
			return MINIMUM_FARE;
		return fareTotal;
	}

	public double calculateFare(Ride[] rides) {
		double aggregateFare = 0;
		for(Ride ride : rides) {
			aggregateFare += this.calculateFare(ride.getDistance(), ride.getTime());
		}
		return aggregateFare;
	}
}
