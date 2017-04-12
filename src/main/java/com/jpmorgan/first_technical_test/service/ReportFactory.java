package com.jpmorgan.first_technical_test.service;

public class ReportFactory {

	public Report getReport(ReportType reportType){
	      
		if (reportType == null){
			return null;
		}
		
	    if (reportType.equals(ReportType.USD_INCOMING)) {
	         return new ReportUSDIncoming();	         
	    } else if (reportType.equals(ReportType.USD_OUTGOING)){
	         return new ReportUSDOutgoing();	         
	      } else if(reportType.equals(ReportType.RANKING)){
	         return new ReportRanking();
	      }
	      
	      return null;
	   }
	
}
