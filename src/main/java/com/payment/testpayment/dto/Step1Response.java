package com.payment.testpayment.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Step1Response implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="result")
	private String result;
	
	@XmlElement(name="result-text")
	private String resultText;
	
	@XmlElement(name="transaction-id")
	private String transactionId;
	
	@XmlElement(name="result-code")
	private String resultCode;
	
	@XmlElement(name="form-url")
	private String formUrl;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getFormUrl() {
		return formUrl;
	}

	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}

	@Override
	public String toString() {
		return "Step1Response [result=" + result + ", resultText=" + resultText + ", transactionId=" + transactionId
				+ ", resultCode=" + resultCode + ", formUrl=" + formUrl + "]";
	}
	
	
	
}
