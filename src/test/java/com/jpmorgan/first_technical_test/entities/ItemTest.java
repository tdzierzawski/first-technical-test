package com.jpmorgan.first_technical_test.entities;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	Item item;
	
	@Before
	public void setup() throws ParseException {
		
		item = new Item();
		
		String agreedFx = "0.50";
		
		item.setEntity("foo");
		item.setBuySell("B");
		item.setAgreedFx(Double.valueOf(agreedFx));
		item.setCurrency("SGP");
		
		DateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		Date instructionDate = df.parse("01 Jan 2016");
		
		item.setInstructionDate(instructionDate);
				 
		Date settlementDate = df.parse("02 Jan 2016");
		
		item.setSettlementDate(settlementDate);
		item.setUnits(200);
		item.setPricePerUnit(100.25);
	}
	
	@Test
	public void testUSDAmountCounting() {
		
		Double result = item.getAmountUSD();
		Double in = (double) 10025;
		
		assertEquals(in, result);
	}
}
