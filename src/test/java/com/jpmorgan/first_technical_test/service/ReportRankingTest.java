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

public class ReportRankingTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private Item item;
	
	private Item item2;
	
	private List<Item> units = new ArrayList<Item>();
	
	@Before
	public void setup() throws ParseException {
		
		System.setOut(new PrintStream(outContent));
		
		item = new Item();
		
		String agreedFx = "0.50";
		
		item.setEntity("bar");
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
		
		item2 = new Item();
		
		item2.setEntity("foo");
		item2.setBuySell("B");
		item2.setAgreedFx(Double.valueOf("0.50"));
		item2.setCurrency("SGP");
		
		Date instructionDate2 = df.parse("01 Jan 2016");
		
		item2.setInstructionDate(instructionDate2);
				 
		Date settlementDate2 = df.parse("02 Jan 2016");
		
		item2.setSettlementDate(settlementDate2);
		item2.setUnits(200);
		item2.setPricePerUnit(100.25);
		
		units.add(item2);
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void testReportGenerating() {
		ReportRanking rIn = new ReportRanking();
		
		rIn.generate(units);
		
		String expectedOutput = "1 "+item.getEntity()+System.getProperty("line.separator")+"2 "+item2.getEntity()+System.getProperty("line.separator");
		assertEquals(expectedOutput, outContent.toString());
	}
	
}
