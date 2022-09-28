package com.ttd.CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvoiceGeneratorTest {

	@org.junit.Test
	public void givenDistanceAndTime_InvoiceGenerator_ShouldReturnFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 5.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(55, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTimeLessThanMinimum_InvoiceGenerator_ShouldReturnFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnAggregateFare() {
	InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	Ride[] rides = {new Ride(5.0, 5), new Ride(0.1, 1)};
	double fare = invoiceGenerator.calculateFare(rides);
	assertEquals(30, fare, 0.0);
	
	}
}
