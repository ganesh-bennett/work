package com.payment.testpayment.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="product-code")
	private String productCode;
	
	@XmlElement(name="description")
	private String description;
	
	@XmlElement(name="quantity")
	private String quantity;
	
	@XmlElement(name="unit-of-measure")
	private String unitOfMeasure;
	
	@XmlElement(name="total-amount")
	private String totalAmount;
	
	@XmlElement(name="discount-amount")
	private String discountAmount;
	
	@XmlElement(name="tax-amount")
	private String taxAmount;
	
	@XmlElement(name="tax-rate")
	private String taxRate;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", description=" + description + ", quantity=" + quantity
				+ ", unitOfMeasure=" + unitOfMeasure + ", totalAmount=" + totalAmount + ", discountAmount="
				+ discountAmount + ", taxAmount=" + taxAmount + ", taxRate=" + taxRate + "]";
	}
	
	

}
