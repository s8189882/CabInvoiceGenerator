package com.ttd.CabInvoiceGenerator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.ttd.CabInvoiceGenerator.Ride.RideCategory;

public class CategoryInvoiceGeneratorTester {

CategoryInvoiceGenerator categoryInvoiceGenerator = null;
	
	@Before
	public void setUp() throws IOException{
		categoryInvoiceGenerator = new CategoryInvoiceGenerator();
	}

	@Test
	public void givenRidesNormal_ShouldReturnAccurateFare() {
		Ride[] rides = {new Ride(RideCategory.NORMAL, 5.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
		InvoiceSummary summary = categoryInvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
		assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenRidesPremium_ShouldReturnAccurateFare() {
		Ride[] rides = {new Ride(RideCategory.PREMIUM, 5.0, 5), new Ride(RideCategory.PREMIUM, 0.1, 1)};
		InvoiceSummary summary = categoryInvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 105);
		assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenUserIDAndCategory_ShouldReturnListofRidesAndInvoice() {
		String user1 = "John";
		Ride[] ridesUser1 = {new Ride(RideCategory.PREMIUM, 5.0, 5), new Ride(RideCategory.PREMIUM,0.1, 1)};
		categoryInvoiceGenerator.addRides(user1, ridesUser1);
		InvoiceSummary summaryUser1 = categoryInvoiceGenerator.getRides(user1);
		InvoiceSummary expectedInvoiceSummaryUser1 = new InvoiceSummary(2, 105);
		assertEquals(expectedInvoiceSummaryUser1, summaryUser1);
		
		String user2 = "Ben";
		Ride[] ridesUser2 = {new Ride(RideCategory.NORMAL, 5.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1), new Ride(RideCategory.NORMAL, 10, 10), new Ride(RideCategory.NORMAL, 1, 20)};
		categoryInvoiceGenerator.addRides(user2, ridesUser2);
		InvoiceSummary summaryUser2 = categoryInvoiceGenerator.getRides(user2);
		InvoiceSummary expectedInvoiceSummaryUser2 = new InvoiceSummary(4, 200);
		assertEquals(expectedInvoiceSummaryUser2, summaryUser2);
		
		String user3 = "Mike";
		Ride[] ridesUser3 = {new Ride(RideCategory.PREMIUM, 5.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1), new Ride(RideCategory.PREMIUM, 10, 10), new Ride(RideCategory.NORMAL, 1, 20)};
		categoryInvoiceGenerator.addRides(user3, ridesUser3);
		InvoiceSummary summaryUser3 = categoryInvoiceGenerator.getRides(user3);
		InvoiceSummary expectedInvoiceSummaryUser3 = new InvoiceSummary(4, 290);
		assertEquals(expectedInvoiceSummaryUser3, summaryUser3);
	}
}
