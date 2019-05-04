package com.springBootExample.model;

import org.springframework.stereotype.Component;

@Component				// A class with no annotation won't be scanned & we will get declare Bean of type "Status" exception
public class Status {
	private String responseMsg;

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	
}
