package com.redhat.samples.blackjack.processor;

import org.apache.camel.Exchange;

import com.redhat.samples.blackjack.model.Account;
import com.redhat.samples.blackjack.model.Balance;
import com.redhat.samples.blackjack.model.User;

public class UserProcessor {
	
	public void getUser(Exchange exchange) throws Exception {
		try{
			
			User user = null;
			
			String queryString = exchange.getIn().getHeader(Exchange.HTTP_QUERY, String.class);
	    	
	        if(queryString!=null && queryString.contains("email")) {
	        	exchange.getOut().setHeader("email",queryString.split("=")[1]);
	        	exchange.getOut().setHeader("uid","12345678");
	        	user = new User();
	        	user.setEmail(queryString.split("=")[1]);
	        	user.setUid("12345678");
	        	Account account = new Account();
	        	Balance balance = new Balance(1230l, "USD");
	        	account.setAcid("12345678");
	        	account.setBalance(balance);
	        	user.setAccount(account);
	        	
	        }else {
	        	throw new Exception("Malformed URL. User ID (uid) not present in HTTP Query String. ");
	        }
			
			
			exchange.getOut().setBody(user);
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}
