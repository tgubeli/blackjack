package com.redhat.samples.blackjack.model;

public class User {
	
//	{
//	    "uid": "213423545",
//	    "email": "tgubeli@redhat.com",
//	    "account": {
//	        "acid": "324324",
//	        "balance":
//	            {
//	                "amount": "1234567",
//	                "currency": "USD"
//	            }
//	    }
//	}
	
	private String uid;
	private String email;
	private Account account;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
