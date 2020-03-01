package com.payment.testpayment.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="customer-vault-id")
	private String custValtId;

	public String getCustValtId() {
		return custValtId;
	}

	public void setCustValtId(String custValtId) {
		this.custValtId = custValtId;
	}

	@Override
	public String toString() {
		return "Customer [custValtId=" + custValtId + "]";
	}

	
}
