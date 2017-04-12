package com.jpmorgan.first_technical_test.service;

import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;

public interface Report {
	void generate(List<Item> units);
}
