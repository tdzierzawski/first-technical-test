package com.jpmorgan.first_technical_test.service;

import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;

public class ReportUSDIncoming implements Report {

	public void generate(List<Item> units) {
		
		for (Item unit : units) {
			System.out.println("Amount in USD settled incoming: "+unit.getAmountUSD());
		}

	}

}
