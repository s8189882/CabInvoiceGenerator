package com.ttd.CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator = null;
	
	@Before
	public void setUp() throws IOException{
		invoiceGenerator = new InvoiceGenerator();
	}

	@org.junit.Test
	public void givenDistanceAndTime_InvoiceGenerator_ShouldReturnFare() {
		double distance = 5.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(55, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTimeLessThanMinimum_InvoiceGenerator_ShouldReturnFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = {new Ride(5.0, 5), new Ride(0.1, 1)};
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
		assertEquals(expectedInvoiceSummary, summary);
	}
}
