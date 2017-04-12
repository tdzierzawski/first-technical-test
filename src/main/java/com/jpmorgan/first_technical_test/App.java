package com.jpmorgan.first_technical_test;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;
import com.jpmorgan.first_technical_test.service.Report;
import com.jpmorgan.first_technical_test.service.ReportFactory;
import com.jpmorgan.first_technical_test.service.ReportType;

/**
 * J.P Morgan Java Technical Test
 */
public class App 
{
    public static void main( String[] args )
    {
    	ReportFactory reportFactory = new ReportFactory();

    	List<Item> units = new ArrayList<Item>();
    	
        Report reportUSDIncoming = reportFactory.getReport(ReportType.USD_INCOMING);

        reportUSDIncoming.generate(units);

        Report reportUSDOutgoing = reportFactory.getReport(ReportType.USD_OUTGOING);

        reportUSDOutgoing.generate(units);

        Report reportRanking = reportFactory.getReport(ReportType.RANKING);

        reportRanking.generate(units);
    }
}
