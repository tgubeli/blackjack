package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "rating", "source"})
public class ObpCreditRating {
	
//	"rating": "OBP",
//    "source": "OBP"

	private String rating;
	private String source;
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
}
