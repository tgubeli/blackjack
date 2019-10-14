package com.redhat.samples.blackjack.model.obp;

public class ObpTransactionRequest {
	
//	  { 
//		   "to":{ 
//		      "bank_id":"psd201-bank-x--uk",
//		      "account_id":"38abd23e-3f9e-408b-8ca5-8db3dcb00c08-1570218292091"
//		   },
//		   "value":{ 
//		      "currency":"USD",
//		      "amount":"800"
//		   },
//		   "description":"this is for work"
//		}
	
	private ObpTransactionTo to;
	private ObpBalance value;
	private String description;
	
	
	public ObpTransactionTo getTo() {
		return to;
	}
	public void setTo(ObpTransactionTo to) {
		this.to = to;
	}
	public ObpBalance getValue() {
		return value;
	}
	public void setValue(ObpBalance value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
