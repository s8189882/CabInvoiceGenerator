package com.ttd.CabInvoiceGenerator;

public class Ride {
	
	public enum RideCategory {
		NORMAL(10, 1, 5),
		PREMIUM(15, 2, 20);
		
		public double minimumCostPerKm;
		public int minimumCostPerMinute;
		public double minimumFare;
		
		private RideCategory(double minimumCostPerKM, int minimumCostPerMinute, double minimumFare) {
			this.minimumCostPerKm = minimumCostPerKM;
			this.minimumCostPerMinute = minimumCostPerMinute;
			this.minimumFare = minimumFare;
		}
	}

	private double distance;
	private int time;
	private RideCategory rideCategory;

	public Ride(RideCategory rideCategory, double distance, int time) {
		this.rideCategory = rideCategory;
		this.distance = distance;
		this.time = time;
	}
	
	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	public RideCategory getRideCategory() {
		return rideCategory;
	}

	public void setRideCategory(RideCategory rideCategory) {
		this.rideCategory = rideCategory;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
