package com.redhat.samples.blackjack.model;

public class Balance {

//	"balance":
//        {
//            "amount": "1234567",
//            "currency": "USD"
//        }
	
	private String amount;
	private String currency;
	
	public Balance(String amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
