package com.redhat.samples.blackjack.model;

public class Balance {

//	"balance":
//        {
//            "amount": "1234567",
//            "currency": "USD"
//        }
	
	private Long amount;
	private String currency;
	
	public Balance(Long amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
