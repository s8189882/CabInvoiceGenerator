package com.ttd.CabInvoiceGenerator;

public class InvoiceSummary {

	private int numberOfRides;
	private double totalFare;
	private double fareAverage;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.fareAverage = this.totalFare/this.numberOfRides;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) o;
		return (numberOfRides == that.numberOfRides && Double.compare(totalFare, that.totalFare) == 0 && Double.compare(fareAverage, that.fareAverage) == 0);
	}

	public int getNumberOfRides() {
		return numberOfRides;
	}

	public void setNumberOfRides(int numberOfRides) {
		this.numberOfRides = numberOfRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public double getFareAverage() {
		return fareAverage;
	}

	public void setFareAverage(double fareAverage) {
		this.fareAverage = fareAverage;
	}
}
