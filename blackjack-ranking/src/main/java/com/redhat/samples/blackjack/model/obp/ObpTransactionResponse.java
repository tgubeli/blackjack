package com.redhat.samples.blackjack.model.obp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpTransactionResponse {
	
//	{
//	    "id": "670adb2b-285a-4137-9643-aa30a55280e2",
//	    "type": "SANDBOX_TAN",
//	    "from": {
//	        "bank_id": "psd201-bank-x--uk",
//	        "account_id": "d561dd1a-4f3f-4549-a5ae-0a100369faa3-1570485677886"
//	    },
//	    "details": {
//	        "to_sandbox_tan": {
//	            "bank_id": "psd201-bank-x--uk",
//	            "account_id": "d561dd1a-4f3f-4549-a5ae-0a100369faa3-1570485677886"
//	        },
//	        "value": {
//	            "currency": "USD",
//	            "amount": "1"
//	        },
//	        "description": "this is for work"
//	    },
//	    "transaction_ids": [
//	        "74f4ae4c-cd91-4318-accb-ae36ac54604e"
//	    ],
//	    "status": "COMPLETED",
//	    "start_date": "2019-10-07T23:31:25Z",
//	    "end_date": "2019-10-07T23:31:25Z",
//	    "challenge": null,
//	    "charge": {
//	        "summary": "Total charges for completed transaction",
//	        "value": {
//	            "currency": "USD",
//	            "amount": "2.0"
//	        }
//	    }
//	}
	
	private String id;
	private String type;
	private ObpTransactionTo from;
	private ObpTransactionDetails details;
	@JsonProperty("transaction_ids")
	private List<String> transactionIds;
	private String status;
	private String start_date;
	private String end_date;
	private String challenge;
	private ObpTransactionCharge charge;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ObpTransactionTo getFrom() {
		return from;
	}
	public void setFrom(ObpTransactionTo from) {
		this.from = from;
	}
	public ObpTransactionDetails getDetails() {
		return details;
	}
	public void setDetails(ObpTransactionDetails details) {
		this.details = details;
	}
	public List<String> getTransactionIds() {
		return transactionIds;
	}
	public void setTransactionIds(List<String> transactionIds) {
		this.transactionIds = transactionIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getChallenge() {
		return challenge;
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	public ObpTransactionCharge getCharge() {
		return charge;
	}
	public void setCharge(ObpTransactionCharge charge) {
		this.charge = charge;
	}
	
	
	

}
