package com.ttd.CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

public class InvoiceGeneratorTest {

	@org.junit.Test
	public void givenDistanceAndTime_InvoiceGenerator_ShouldReturnFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 5.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(55, fare, 0.0);
	}

}
