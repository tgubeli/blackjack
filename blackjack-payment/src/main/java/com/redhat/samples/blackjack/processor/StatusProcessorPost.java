package com.redhat.samples.blackjack.processor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;

import com.redhat.samples.blackjack.model.Status;


public class StatusProcessorPost{

	/**
	 * Sets init and end DateTime values in Exchenge (camel) headers.
	 * This is use after to update status values in DB where the status belongs to a specific day
	 * @param exchange
	 * @throws Exception
	 */
	public void setDates(Exchange exchange) throws Exception {
		try{
			Map<String, Object> headers = exchange.getIn().getHeaders();
			Object body = exchange.getIn().getBody();
			
			// puts actual date range into headers
			String strDateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String dateInit = format.format(format.parse(strDateNow+" 00:00:00"));
			String dateEnd = format.format(format.parse(strDateNow+" 23:59:59"));
			String dateNow = format.format(new Date());
			
			headers.put("status_date_init", dateInit);
			headers.put("status_date_end", dateEnd);
			headers.put("status_date_now", dateNow);
			
			
			exchange.getOut().setHeaders(headers);
			exchange.getOut().setBody(body);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Process the result from an SQL Update (status update in BD)
	 * @param exchange
	 * @throws Exception
	 */
	public void process(Exchange exchange) throws Exception {
		
		Status finalState = new Status();
		
		List<Map<String, Object>> body = exchange.getIn().getBody(List.class);
		for (Map<String, Object> item : body) {
			finalState.setStarted(String.valueOf(String.valueOf(item.get("is_init"))));
		}
		
		
		exchange.getOut().setBody(finalState);
	}
	
}
