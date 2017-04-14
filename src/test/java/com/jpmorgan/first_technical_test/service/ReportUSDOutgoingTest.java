package com.jpmorgan.first_technical_test.service;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.first_technical_test.entities.Item;

public class ReportUSDOutgoingTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private Item item;
	
	private List<Item> units = new ArrayList<Item>();
	
	@Before
	public void setup() throws ParseException {
		
		System.setOut(new PrintStream(outContent));
		
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
		
		units.add(item);
		
		Item item2 = new Item();
		
		units.add(item2);
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void testReportGenerating() {
		ReportUSDOutgoing rOut = new ReportUSDOutgoing();

		rOut.generate(units);
		
		String expectedOutput = item.getSettlementDate()+ReportUSDOutgoing.MESSAGE+item.getAmountUSD()+System.getProperty("line.separator");
		assertEquals(expectedOutput, outContent.toString());
	}
	
}
