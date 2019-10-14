package com.redhat.samples.blackjack.model;

public class Account {

//"account": {
//    "acid": "324324",
//    "balance":
//        {
//            "amount": "1234567",
//            "currency": "USD"
//        }
//}
	
	private String acid;
	//@JsonProperty("balance")
	private Balance balance;
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public Balance getBalance() {
		return balance;
	}
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	
	
	
}
