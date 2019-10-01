package com.redhat.samples.blackjack.processor;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.samples.blackjack.model.Status;


public class StatusProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		Status finalState = new Status();
		
		List<Map<String, Object>> body = exchange.getIn().getBody(List.class);
		for (Map<String, Object> item : body) {
			finalState.setStarted(String.valueOf(String.valueOf(item.get("is_init"))));
		}
		
		System.out.println("Estado: "+finalState.getStarted());
		
		exchange.getOut().setBody(finalState);
	}
	
}
