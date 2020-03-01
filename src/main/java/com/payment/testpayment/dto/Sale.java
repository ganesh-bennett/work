package com.payment.testpayment.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sale implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="api-key")
	private String apiKey;
	
	@XmlElement(name="redirect-url")
	private String redirectURL;
	
	@XmlElement(name="amount")
	private String amount;
	
	@XmlElement(name="currency")
	private String currency;
	
	@XmlElement(name="order-id")
	private String orderId;
	
	@XmlElement(name="order-description")
	private String orderDescription;
	
	@XmlElement(name="merchant-defined-field-1")
	private String merchantField1;
	
	@XmlElement(name="merchant-defined-field-2")
	private String merchantField2;
	
	@XmlElement(name="tax-amount")
	private String taxAmount;
	
	@XmlElement(name="shipping-amount")
	private String shippingAmount;
	
	@XmlElement(name="add-customer")
	private Customer addCustomer;
	
	@XmlElement(name="billing")
	private BillingAddress billingAddress;
	
	@XmlElement(name="shipping")
	private ShippingAddress shippingAddress;
	
	@XmlElement(name="product")
	List<Product> productList;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public String getMerchantField1() {
		return merchantField1;
	}

	public void setMerchantField1(String merchantField1) {
		this.merchantField1 = merchantField1;
	}

	public String getMerchantField2() {
		return merchantField2;
	}

	public void setMerchantField2(String merchantField2) {
		this.merchantField2 = merchantField2;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(String shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public Customer getAddCustomer() {
		return addCustomer;
	}

	public void setAddCustomer(Customer addCustomer) {
		this.addCustomer = addCustomer;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Sale [apiKey=" + apiKey + ", redirectURL=" + redirectURL + ", amount=" + amount + ", currency="
				+ currency + ", orderId=" + orderId + ", orderDescription=" + orderDescription + ", merchantField1="
				+ merchantField1 + ", merchantField2=" + merchantField2 + ", taxAmount=" + taxAmount
				+ ", shippingAmount=" + shippingAmount + ", addCustomer=" + addCustomer + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + ", productList=" + productList + "]";
	}
	
}
