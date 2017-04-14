package com.jpmorgan.first_technical_test.service;

import java.util.Collections;
import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;
import com.jpmorgan.first_technical_test.utils.BuyInstructionComparator;

public class ReportRanking implements Report {

	public final static String MESSAGE = "Ranking settled for outgoing: ";
	
	public void generate(List<Item> units) {
		
		Collections.sort(units, new BuyInstructionComparator());
		
		int i=1;
		for (Item unit : units) {
			if (unit.isOutgoing()) {				
				System.out.println(i+" "+unit.getEntity());
				
				i++;
			}
		}
	}
}
