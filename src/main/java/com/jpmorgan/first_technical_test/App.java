package com.jpmorgan.first_technical_test;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.first_technical_test.entities.Item;
import com.jpmorgan.first_technical_test.service.Report;
import com.jpmorgan.first_technical_test.service.ReportFactory;
import com.jpmorgan.first_technical_test.service.ReportType;
import com.jpmorgan.first_technical_test.utils.DataMapper;

/**
 * J.P Morgan Java Technical Test
 */
public class App 
{
    public static void main( String[] args )
    {
    	ReportFactory reportFactory = new ReportFactory();

    	List<Item> units = null;
    	
    	try {
			units = DataMapper.proceed();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
    	
        Report reportUSDIncoming = reportFactory.getReport(ReportType.USD_INCOMING);

        reportUSDIncoming.generate(units);

        Report reportUSDOutgoing = reportFactory.getReport(ReportType.USD_OUTGOING);

        reportUSDOutgoing.generate(units);

        Report reportRanking = reportFactory.getReport(ReportType.RANKING);

        reportRanking.generate(units);
    }
    
    
}
