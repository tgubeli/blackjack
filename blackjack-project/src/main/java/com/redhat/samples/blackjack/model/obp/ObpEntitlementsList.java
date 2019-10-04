package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "entitlement_id", "role_name", "bank_id"})
public class ObpEntitlementsList {

//	"entitlements": {
//  "list": [
//      {
//          "entitlement_id": "be9a33cd-fc2c-4416-9dfa-d8f17e1d29a6",
//          "role_name": "CanCheckFundsAvailable",
//          "bank_id": ""
//      }
//  ]
//}
	
	@JsonProperty("entitlement_id")
	private String entitlementId;
	@JsonProperty("role_name")
	private String roleName;
	@JsonProperty("bank_id")
	private String bankId;
	
	
	public String getEntitlementId() {
		return entitlementId;
	}
	public void setEntitlementId(String entitlementId) {
		this.entitlementId = entitlementId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	
}
