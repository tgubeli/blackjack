package com.redhat.samples.blackjack.processor;

import com.redhat.samples.blackjack.model.UserRanking;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RankingProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		List<UserRanking> users = new ArrayList<UserRanking>();

		List<Map<String, Object>> body = exchange.getIn().getBody(List.class);
		for (Map<String, Object> item : body) {
			UserRanking user = new UserRanking();
			String balance = String.valueOf(item.get("accountbalance"));
			user.setEmail(String.valueOf(item.get("holder")));
			if(!balance.equals("0")){
				user.setBalance(
					balance.substring(
						0,(balance.length()-2)
						)
					.concat(".00")
				);
			}else{
				user.setBalance(balance.concat(".00"));	
			}
			users.add(user);
		}

		exchange.getOut().setBody(users);
	}

}
