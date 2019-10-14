package com.redhat.samples.blackjack.model.obp;

import java.util.List;

public class ObpAccountList {
//	[{
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
//		}]
	
	
	private List<ObpAccount> lsAccounts;

	public List<ObpAccount> getLsAccounts() {
		return lsAccounts;
	}

	public void setLsAccounts(List<ObpAccount> lsAccounts) {
		this.lsAccounts = lsAccounts;
	}
	
	
	
}
