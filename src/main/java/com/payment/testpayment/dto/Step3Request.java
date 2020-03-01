package com.payment.testpayment.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="complete-action")
@XmlAccessorType(XmlAccessType.FIELD)
public class Step3Request implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="api-key")
	private String apiKey;
	
	@XmlElement(name="token-id")
	private String tokenId;
	
	

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Override
	public String toString() {
		return "Step3Request [apiKey=" + apiKey + ", tokenId=" + tokenId + "]";
	}

	
	
}
