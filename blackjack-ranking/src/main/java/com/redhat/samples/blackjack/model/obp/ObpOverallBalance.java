package com.redhat.samples.blackjack.model.obp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpOverallBalance {

//	{
//	    "accounts": [
//	        {
//	            "id": "3fb204b2-0596-4689-9004-6275921d6327-1570503418787",
//	            "label": "3fb204b2-0596-4689-9004-6275921d6327-1570503418787",
//	            "bank_id": "psd201-bank-x--uk",
//	            "account_routings": [
//	                {
//	                    "scheme": "OBP",
//	                    "address": "Apoquindo 2827"
//	                }
//	            ],
//	            "balance": {
//	                "currency": "USD",
//	                "amount": "0.00"
//	            }
//	        }
//	    ],
//	    "overall_balance": {
//	        "currency": "USD",
//	        "amount": "0.00"
//	    },
//	    "overall_balance_date": "2019-10-08T13:15:21Z"
//	}
	
	private List<ObpAccount> accounts;
	@JsonProperty("overall_balance")
	private ObpBalance overalBalance;
	@JsonProperty("overall_balance_date")
	private String overallBalanceDate;
	
	public List<ObpAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<ObpAccount> accounts) {
		this.accounts = accounts;
	}
	public ObpBalance getOveralBalance() {
		return overalBalance;
	}
	public void setOveralBalance(ObpBalance overalBalance) {
		this.overalBalance = overalBalance;
	}
	public String getOverallBalanceDate() {
		return overallBalanceDate;
	}
	public void setOverallBalanceDate(String overallBalanceDate) {
		this.overallBalanceDate = overallBalanceDate;
	}
	
}
