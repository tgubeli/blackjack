package com.redhat.samples.blackjack.model;

public class Payment {
	
//	{ "email": "user@email.com", "amount": "20", "acid": "55456456" }
	
	private String email;
	private String amount;
	private String acid;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	
	
}
