package com.jpmorgan.first_technical_test.service;

import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;

public class ReportRanking implements Report {

	public void generate(List<Item> units) {
		System.out.println("Ranking settled for outgoing.");
	}

}
