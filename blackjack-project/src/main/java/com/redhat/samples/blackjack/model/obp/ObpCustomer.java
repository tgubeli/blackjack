package com.redhat.samples.blackjack.model.obp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ 
	  "legal_name",
	  "mobile_phone_number",
	  "email",
	  "face_image",
	  "date_of_birth",
	  "relationship_status",
	  "dependants",
	  "dob_of_dependants",
	  "credit_rating",
	  "credit_limit",
	  "highest_education_attained",
	  "employment_status",
	  "kyc_status",
	  "last_ok_date",
	  "title",
	  "branchId",
	  "nameSuffix" 
	  })
public class ObpCustomer {

//	{
//		  "legal_name": "fred",
//		  "mobile_phone_number": "+44 07972 444 876",
//		  "email": "fred@example.com",
//		  "face_image": {
//		    "url": "www.openbankproject",
//		    "date": "2017-09-19T00:00:00Z"
//		  },
//		  "date_of_birth": "2017-09-19T00:00:00Z",
//		  "relationship_status": "single",
//		  "dependants": 10,
//		  "dob_of_dependants": [
//		    "2017-09-19T00:00:00Z"
//		  ],
//		  "credit_rating": {
//		    "rating": "OBP",
//		    "source": "OBP"
//		  },
//		  "credit_limit": {
//		    "currency": "EUR",
//		    "amount": "2000"
//		  },
//		  "highest_education_attained": "Master",
//		  "employment_status": "worker",
//		  "kyc_status": true,
//		  "last_ok_date": "2017-09-19T00:00:00Z",
//		  "title": "Dr.",
//		  "branchId": "9cf8-1234",
//		  "nameSuffix": "Sr"
//		}

	@JsonProperty("legal_name")
	private String legalName;
	@JsonProperty("mobile_phone_number")
	private String mobilePhoneNumber;
	private String email;
	@JsonProperty("date_of_birth")
	private String dateOfBirth;
	@JsonProperty("relationship_status")
	private String relationshipStatus;
	private Integer dependants;
	@JsonProperty("dob_of_dependants")
	private List<String> dobOfDependants;
	@JsonProperty("highest_education_attained")
	private String highestEducationAttained;
	@JsonProperty("employment_status")
	private String employmentStatus;
	@JsonProperty("kyc_status")
	@JsonFormat(shape=JsonFormat.Shape.BOOLEAN)
	private Boolean kycStatus;
	@JsonProperty("last_ok_date")
	private String lastOkDate;
	private String title;
	private String branchId;
	private String nameSuffix;
	@JsonProperty("credit_rating")
	private ObpCreditRating creditRating;
	@JsonProperty("credit_limit")
	private ObpCreditLimit creditLimit;
	@JsonProperty("face_image")
	private ObpFaceImage faceImage;
	
	@JsonProperty("bank_id")
	private String bankId;
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("customer_number")
	private String customerNumber;
	
	
	
	
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public Integer getDependants() {
		return dependants;
	}
	public void setDependants(Integer dependants) {
		this.dependants = dependants;
	}
	public List<String> getDobOfDependants() {
		return dobOfDependants;
	}
	public void setDobOfDependants(List<String> dobOfDependants) {
		this.dobOfDependants = dobOfDependants;
	}
	public String getHighestEducationAttained() {
		return highestEducationAttained;
	}
	public void setHighestEducationAttained(String highestEducationAttained) {
		this.highestEducationAttained = highestEducationAttained;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public Boolean getKycStatus() {
		return kycStatus;
	}
	public void setKycStatus(Boolean kycStatus) {
		this.kycStatus = kycStatus;
	}
	public String getLastOkDate() {
		return lastOkDate;
	}
	public void setLastOkDate(String lastOkDate) {
		this.lastOkDate = lastOkDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getNameSuffix() {
		return nameSuffix;
	}
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}
	public ObpCreditRating getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(ObpCreditRating creditRating) {
		this.creditRating = creditRating;
	}
	public ObpCreditLimit getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(ObpCreditLimit creditLimit) {
		this.creditLimit = creditLimit;
	}
	public ObpFaceImage getFaceImage() {
		return faceImage;
	}
	public void setFaceImage(ObpFaceImage faceImage) {
		this.faceImage = faceImage;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	
	
	
}
