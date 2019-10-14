package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpTransactionDetails {
	
//	  { 
//		   "to_sandbox_tan":{ 
//		      "bank_id":"psd201-bank-x--uk",
//		      "account_id":"38abd23e-3f9e-408b-8ca5-8db3dcb00c08-1570218292091"
//		   },
//		   "value":{ 
//		      "currency":"USD",
//		      "amount":"800"
//		   },
//		   "description":"this is for work"
//		}
	
	@JsonProperty("to_sandbox_tan")
	private ObpTransactionTo toSandboxTan;
	private ObpBalance value;
	private String description;
	
	
	
	public ObpTransactionTo getToSandboxTan() {
		return toSandboxTan;
	}
	public void setToSandboxTan(ObpTransactionTo toSandboxTan) {
		this.toSandboxTan = toSandboxTan;
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
