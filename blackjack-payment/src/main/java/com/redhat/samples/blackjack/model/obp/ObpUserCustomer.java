package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpUserCustomer {

	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("customer_id")
	private String customerId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	
}
