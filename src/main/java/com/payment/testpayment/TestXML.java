package com.payment.testpayment;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.payment.testpayment.dto.BillingAddress;
import com.payment.testpayment.dto.Customer;
import com.payment.testpayment.dto.Product;
import com.payment.testpayment.dto.Sale;
import com.payment.testpayment.dto.ShippingAddress;

public class TestXML {
	
	public static void main(String[] arg)
	{
		
		Sale sale = new Sale();
		sale.setApiKey("api key");
		sale.setRedirectURL("url");
		sale.setCurrency("cur");
		sale.setAmount("1");
		sale.setMerchantField1("f1");
		sale.setMerchantField2("f2");
		sale.setOrderDescription("ds");
		sale.setOrderId("o1");
		sale.setShippingAmount("1");
		sale.setTaxAmount("1");
		
		Customer cust = new Customer();
		cust.setCustValtId("1");
		
		BillingAddress billing = new BillingAddress();
		billing.setAddress1("add1");
		billing.setAddress2("add2");
		billing.setCity("c1");
		billing.setCompany("ccc");
		billing.setFirstName("fname");
		billing.setLastName("lname");
		
		ShippingAddress shipping = new ShippingAddress();
		shipping.setAddress1("add1");
		shipping.setAddress2("add2");
		shipping.setCity("c1");
		shipping.setCompany("ccc");
		shipping.setFirstName("fname");
		shipping.setLastName("lname");
		
		//sale.setAddCustomer(cust);
		//sale.setBillingAddress(billing);
		//sale.setShippingAddress(shipping);
		
		Product product = new Product();
		product.setDescription("ds");
		product.setDiscountAmount("d1");
		product.setQuantity("1");
		product.setTotalAmount("1");
		
		List<Product> prdList = new ArrayList<Product>();
		prdList.add(product);
		//sale.setProductList(prdList);
		
		try
		{
			JAXBContext context = JAXBContext.newInstance(Sale.class);
			
			Marshaller jaxbMarshaller = context.createMarshaller();
			 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(sale, sw);
             
            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
