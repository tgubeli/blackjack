package com.redhat.samples.blackjack.processor;

import java.util.Date;

import org.apache.camel.Exchange;

import com.redhat.samples.blackjack.model.Account;
import com.redhat.samples.blackjack.model.Balance;
import com.redhat.samples.blackjack.model.User;
import com.redhat.samples.blackjack.model.obp.ObpAccount;
import com.redhat.samples.blackjack.model.obp.ObpAccountList;
import com.redhat.samples.blackjack.model.obp.ObpAccountRouting;
import com.redhat.samples.blackjack.model.obp.ObpBalance;
import com.redhat.samples.blackjack.model.obp.ObpCreditLimit;
import com.redhat.samples.blackjack.model.obp.ObpCreditRating;
import com.redhat.samples.blackjack.model.obp.ObpCustomer;
import com.redhat.samples.blackjack.model.obp.ObpFaceImage;
import com.redhat.samples.blackjack.model.obp.ObpOverallBalance;
import com.redhat.samples.blackjack.model.obp.ObpTransactionRequest;
import com.redhat.samples.blackjack.model.obp.ObpTransactionTo;
import com.redhat.samples.blackjack.model.obp.ObpUser;
import com.redhat.samples.blackjack.model.obp.ObpUserCustomer;
import com.redhat.samples.blackjack.model.obp.ObpUserData;

public class UserProcessor {
	
	private static String BRANCH_ID = "9cf8-1234";
	
	public void setUserInfo(Exchange exchange) throws Exception {
		try{
			
			ObpOverallBalance obpOverallBalance = exchange.getIn().getBody(ObpOverallBalance.class);
			ObpUser obpUser = (ObpUser) exchange.getProperty("obpUser");
	    	
	        User user = new User();
	        user.setEmail(obpUser.getEmail());
	        user.setUid(obpUser.getUserId());
	        
	        if(obpOverallBalance!=null && obpOverallBalance.getAccounts()!=null && obpOverallBalance.getAccounts().size()>0) {
	        	ObpAccount obpAccount =  obpOverallBalance.getAccounts().get(0);
	 	        Account account = new Account();
	 	        account.setAcid(obpAccount.getId());
	 	        Balance balance = new Balance(obpAccount.getBalance().getAmount(), obpAccount.getBalance().getCurrency());
	 	        account.setBalance(balance);
	 	        user.setAccount(account);
	        }
	       
			
			exchange.getOut().setBody(user);
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void setEmailProperty(Exchange exchange) throws Exception {
		try{
			
			String queryString = exchange.getIn().getHeader(Exchange.HTTP_QUERY, String.class);
	    	
	        if(queryString!=null && queryString.contains("email")) {
	        	exchange.setProperty("email",queryString.split("=")[1]);
	        	
	        }else {
	        	throw new Exception("Malformed URL. User ID (uid) not present in HTTP Query String. ");
	        }
			
			
			exchange.getOut().setBody(exchange.getIn().getBody());
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void createPojoUserOBP(Exchange exchange) throws Exception {
		try{
			
			String email = (String) exchange.getProperty("email");
			String defaultPassword = (String) exchange.getProperty("userdefaultpassword");
			ObpUserData obpUserData = new ObpUserData();
	    	
	        if(email!=null) {
	        	
	        	obpUserData.setEmail(email);
	        	obpUserData.setUsername(email);
	        	obpUserData.setFirstName("Demo Jam");
	        	obpUserData.setLastName("Dummy Name");
	        	obpUserData.setPassword(defaultPassword);
	        	
	        }else {
	        	throw new Exception("Malformed URL. User Name or Email not present in Payload Header. ");
	        }
			
			
			exchange.getOut().setBody(obpUserData);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void setUserIntoPayload(Exchange exchange) throws Exception {
		System.out.println("Body: "+exchange.getIn().getBody());
		exchange.getOut().setBody(exchange.getIn().getBody());
	}
	
	public void createPojoOBPCustomer(Exchange exchange) throws Exception {
		try{
			
			String email = (String) exchange.getProperty("email");
			ObpCustomer obpCustomer = new ObpCustomer();
	    	
	        if(email!=null) {
	        	
	        	ObpCreditLimit obpCreditLimit = new ObpCreditLimit();
		        	obpCreditLimit.setAmount("2000");
		        	obpCreditLimit.setCurrency("USD");
	        	ObpCreditRating obpCreditRating = new ObpCreditRating();
	        		obpCreditRating.setRating("OBP");
	        		obpCreditRating.setSource("OBP");
	        	ObpFaceImage obpFaceImage = new ObpFaceImage();
	        		obpFaceImage.setDate("2019-10-15T00:00:00Z");
	        		obpFaceImage.setUrl("https://cdn1.iconfinder.com/data/icons/profession-avatar-solid-2/48/53-512.png");
	        	
	        	
	        	obpCustomer.setEmail(email);
	        	obpCustomer.setBranchId(BRANCH_ID);
	        	obpCustomer.setCreditLimit(obpCreditLimit);
	        	obpCustomer.setCreditRating(obpCreditRating);
	        	obpCustomer.setDateOfBirth("1984-09-19T00:00:00Z");
	        	obpCustomer.setDependants(0);
	        	obpCustomer.setDobOfDependants(null);
	        	obpCustomer.setEmploymentStatus("worker");
	        	obpCustomer.setFaceImage(obpFaceImage);
	        	obpCustomer.setHighestEducationAttained("Master");
	        	obpCustomer.setKycStatus(true);
	        	obpCustomer.setLastOkDate("2017-09-19T00:00:00Z");
	        	obpCustomer.setLegalName(email);
	        	obpCustomer.setMobilePhoneNumber("+44 07972 444 876");
	        	obpCustomer.setNameSuffix("Sr");
	        	obpCustomer.setRelationshipStatus("single");
	        	obpCustomer.setTitle("Dr.");
	        	
	        }else {
	        	throw new Exception("Malformed URL. User Name or Email not present in Payload.");
	        }
	        
			exchange.getOut().setBody(obpCustomer);
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void createPojoOBPUserCustomer(Exchange exchange) throws Exception {
		try{
			
//			Map<String, Object> properties = exchange.getProperties();
//			for (String key : properties.keySet()) {
//				System.out.println("key: "+key+", value: "+properties.get(key));
//			}
			
			String uid = (String) exchange.getProperty("userId");
			String cid = (String) exchange.getProperty("customerId");
			ObpUserCustomer obpUserCustomer = new ObpUserCustomer();
	    	
	        if(uid!=null && cid!=null ) {
	        	obpUserCustomer.setCustomerId(cid);
	        	obpUserCustomer.setUserId(uid);
	        }else {
	        	throw new Exception("User ID or Customer ID not present in Payload.");
	        }
	        
	        exchange.getOut().setBody(obpUserCustomer);
	        
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void createPojoOBPAccount(Exchange exchange) throws Exception {
		try{
			
			
			String uid = (String) exchange.getProperty("userId");
			
			// Label generation (account id). This must be an unic ID
			String label = uid+"-"+new Date().getTime();
			exchange.setProperty("labelId", label);
			
			ObpAccount obpAccount = new ObpAccount();
	    	
	        if(uid!=null) {
	        	
	        	ObpBalance balance = new ObpBalance();
	        	balance.setAmount("0"); // initial balance always must be 0
	        	balance.setCurrency("USD");
	        	
	        	ObpAccountRouting accountRouting = new ObpAccountRouting();
	        	accountRouting.setAddress("Apoquindo 2827");
	        	accountRouting.setScheme("OBP");
	        	
	        	obpAccount.setBranchId(BRANCH_ID);
	        	obpAccount.setUserId(uid);
	        	obpAccount.setLabel(label);
	        	obpAccount.setType("CURRENT");
	        	obpAccount.setAccountRouting(accountRouting);
	        	obpAccount.setBalance(balance);
	        	
	        }else {
	        	throw new Exception("User ID or Customer ID not present in Payload.");
	        }
	        
	        exchange.getOut().setBody(obpAccount);
	        
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void getMainAccount(Exchange exchange) throws Exception {
		try{
			
			
			ObpAccountList accountList = (ObpAccountList) exchange.getIn().getBody();
			ObpAccount mainAccount = null;
			
	        if(accountList!=null && accountList.getLsAccounts().size()>0) {
	        	
	        	mainAccount = accountList.getLsAccounts().get(0);
	        	
	        }else {
	        	throw new Exception("User without Accounts");
	        }
	        
	        exchange.getOut().setBody(mainAccount);
	        
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void createTransfer(Exchange exchange) throws Exception {
		try{
			
			
			ObpTransactionRequest obpTransactionRequest = new ObpTransactionRequest();
			ObpTransactionTo to = new ObpTransactionTo();
			ObpBalance value = new ObpBalance();
			
			obpTransactionRequest.setDescription("DemoJam account Transaction");
			to.setAccountId((String)exchange.getProperty("accountIdTo"));
			to.setBankId((String)exchange.getProperty("bankId"));
			obpTransactionRequest.setTo(to);
			value.setAmount((String)exchange.getProperty("ammount"));
			value.setCurrency("USD"); // default value
			obpTransactionRequest.setValue(value);
			
	        exchange.getOut().setBody(obpTransactionRequest);
	        
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}
