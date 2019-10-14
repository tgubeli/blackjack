package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpAccount {
//	{
//		   "user_id":"ddc1f9a4-d825-49bb-8d81-0b1eae8e6914",
//		   "label":"999999",
//		   "type":"CURRENT",
//		   "balance":{
//		      "currency":"EUR",
//		      "amount":"0"
//		   },
//		   "branch_id":"9cf8-1234",
//		   "account_routing":{
//		      "scheme":"OBP",
//		      "address":"CLLira245"
//		   }
//		}
	
	
	@JsonProperty("user_id")
	private String userId;
	private String label;
	private String type;
	private ObpBalance balance;
	@JsonProperty("branch_id")
	private String branchId;
	@JsonProperty("account_routing")
	private ObpAccountRouting accountRouting;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ObpBalance getBalance() {
		return balance;
	}
	public void setBalance(ObpBalance balance) {
		this.balance = balance;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public ObpAccountRouting getAccountRouting() {
		return accountRouting;
	}
	public void setAccountRouting(ObpAccountRouting accountRouting) {
		this.accountRouting = accountRouting;
	}
	
	
	
}
