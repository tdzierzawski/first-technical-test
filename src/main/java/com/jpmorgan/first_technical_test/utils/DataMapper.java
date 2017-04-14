package com.jpmorgan.first_technical_test.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.jpmorgan.first_technical_test.entities.Item;

public class DataMapper {

	public static List<Item> generateData() throws ParseException {
		
		List<Item> data = new ArrayList();
		
		Item item = new Item();
		
		item.setEntity("foo");
		item.setBuySell("B");
		item.setAgreedFx(Double.valueOf("0.50"));
		item.setCurrency("SGP");
		
		DateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		Date instructionDate = df.parse("01 Jan 2016");
		
		item.setInstructionDate(instructionDate);
				 
		Date settlementDate = df.parse("02 Jan 2016");
		
		item.setSettlementDate(settlementDate);
		item.setUnits(200);
		item.setPricePerUnit(100.25);
		
		data.add(item);
		
		Item item2 = new Item();
		
		item2.setEntity("bar");
		item2.setBuySell("S");
		item2.setAgreedFx(Double.valueOf("0.22"));
		item2.setCurrency("AED");
		
		Date instructionDate2 = df.parse("05 Jan 2016");
		
		item2.setInstructionDate(instructionDate2);
				 
		Date settlementDate2 = df.parse("07 Jan 2016");
		
		item2.setSettlementDate(settlementDate2);
		item2.setUnits(200);
		item2.setPricePerUnit(100.25);
		
		data.add(item2);
		
		return data;
	}
	
	public static List<Item> proceed() throws ParseException {

		List<Item> data = generateData();
		
		for (Item item : data) {
			if (isHoliday(new Date())) {
				Calendar c = Calendar.getInstance(); 
				
				c.setTime(item.getInstructionDate()); 
				c.add(Calendar.DATE, 1);
				item.setInstructionDate(c.getTime());
				
				c.setTime(item.getSettlementDate()); 
				c.add(Calendar.DATE, 1);
				item.setSettlementDate(c.getTime());
			}
		}
		
		return data;
	}
	
	public static boolean isHoliday(Date date)
    {
        boolean isHoliday = false;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
            || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
            isHoliday = true;
        }
        
        return isHoliday;
    }
}
