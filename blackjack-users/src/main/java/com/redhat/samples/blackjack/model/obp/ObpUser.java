package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpUser {

//	{
//	    "user_id": "3a2e480a-1d23-44fc-8cd5-0f0e3913e9c0",
//	    "email": "fred@example.com",
//	    "provider_id": "fred",
//	    "provider": "obp-deployment-795fc4d5f8-hb2s2",
//	    "username": "fred",
//	    "entitlements": {
//	        "list": [
//	            {
//	                "entitlement_id": "be9a33cd-fc2c-4416-9dfa-d8f17e1d29a6",
//	                "role_name": "CanCheckFundsAvailable",
//	                "bank_id": ""
//	            }
//	        ]
//	    }
//	}
	
	
	@JsonProperty("user_id")
	private String userId;
	private String email;
	@JsonProperty("provider_id")
	private String providerId;
	private String provider;
	private String username;
	private ObpEntitlements entitlements;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ObpEntitlements getEntitlements() {
		return entitlements;
	}
	public void setEntitlements(ObpEntitlements entitlements) {
		this.entitlements = entitlements;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	
	
}
