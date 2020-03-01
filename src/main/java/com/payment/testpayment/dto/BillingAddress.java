package com.payment.testpayment.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class BillingAddress implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="first-name")
	private String firstName;
	
	@XmlElement(name="last-name")
	private String lastName;
	
	@XmlElement(name="address1")
	private String address1;
	
	@XmlElement(name="city")
	private String city;
	
	@XmlElement(name="state")
	private String state;
	
	@XmlElement(name="postal")
	private String postal;
	
	@XmlElement(name="country")
	private String country;
	
	@XmlElement(name="phone")
	private String phone;
	
	@XmlElement(name="email")
	private String email;
	
	@XmlElement(name="company")
	private String company;
	
	@XmlElement(name="address2")
	private String address2;
	
	@XmlElement(name="fax")
	private String fax;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Address [firstName=" + firstName + ", lastName=" + lastName + ", address1=" + address1 + ", city="
				+ city + ", state=" + state + ", postal=" + postal + ", country=" + country + ", phone=" + phone
				+ ", email=" + email + ", company=" + company + ", address2=" + address2 + ", fax=" + fax + "]";
	}

	
	
	

}
