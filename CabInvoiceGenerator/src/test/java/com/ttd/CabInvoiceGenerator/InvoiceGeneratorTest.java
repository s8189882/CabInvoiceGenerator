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
	
	@Test
	public void givenUserID_ShouldReturnListofRidesAndInvoice() {
		String user1 = "John";
		Ride[] ridesUser1 = {new Ride(5.0, 5), new Ride(0.1, 1)};
		invoiceGenerator.addRides(user1, ridesUser1);
		InvoiceSummary summaryUser1 = invoiceGenerator.getRides(user1);
		InvoiceSummary expectedInvoiceSummaryUser1 = new InvoiceSummary(2, 60);
		assertEquals(expectedInvoiceSummaryUser1, summaryUser1);
		
		String user2 = "Ben";
		Ride[] ridesUser2 = {new Ride(5.0, 5), new Ride(0.1, 1), new Ride(10, 10), new Ride(1, 20)};
		invoiceGenerator.addRides(user2, ridesUser2);
		InvoiceSummary summaryUser2 = invoiceGenerator.getRides(user2);
		InvoiceSummary expectedInvoiceSummaryUser2 = new InvoiceSummary(4, 200);
		assertEquals(expectedInvoiceSummaryUser2, summaryUser2);
	}
}
