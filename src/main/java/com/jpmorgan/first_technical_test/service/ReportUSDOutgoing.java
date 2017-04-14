package com.jpmorgan.first_technical_test.service;

import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;

public class ReportUSDOutgoing implements Report {

	public final static String MESSAGE = " amount in USD settled outgoing: ";
	
	public void generate(List<Item> units) {
		
		for (Item unit : units) {			
			if (unit.isOutgoing()) {
				String amount = unit.getAmountUSD().toString();
				System.out.println(unit.getSettlementDate()+MESSAGE+amount);
			}
		}
		
	}

}
