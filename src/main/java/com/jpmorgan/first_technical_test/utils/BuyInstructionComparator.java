package com.jpmorgan.first_technical_test.utils;

import java.util.Comparator;

import com.jpmorgan.first_technical_test.entities.Item;

public class BuyInstructionComparator implements Comparator<Item> {
	
	public int compare(Item item1, Item item2) {
		return (int) (item1.getAmountUSD() - item2.getAmountUSD());
    }
}
