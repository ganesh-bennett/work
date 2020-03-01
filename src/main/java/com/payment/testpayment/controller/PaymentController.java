package com.payment.testpayment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.InputSource;

import com.payment.testpayment.dto.BillingAddress;
import com.payment.testpayment.dto.Customer;
import com.payment.testpayment.dto.Product;
import com.payment.testpayment.dto.Sale;
import com.payment.testpayment.dto.ShippingAddress;
import com.payment.testpayment.dto.Step1Response;
import com.payment.testpayment.dto.Step3Request;

@Controller
public class PaymentController {

	@RequestMapping("/")
	public String home()
	{
		return "step1";
	}
	
	
	@RequestMapping("/step3")
	public String step3(HttpServletRequest request, ModelMap model)
	{
		String tokenId = request.getParameter("token-id");
		model.addAttribute("tokenId", tokenId);
		model.addAttribute("apiKey", "2F822Rw39fx762MaV7Yy86jXGTC7sCDy");
		return "step3";
	}

	@PostMapping("/step1submit")
	public String stepOneSubmit(HttpServletRequest request, ModelMap model)
	{

		Sale sale = parseSaleFromRequest(request);
		
		String xmlString = getSaleXMLRequest(sale);
		
		Step1Response response = null;
		
		try
		{
			String strReponse = post(xmlString);
			response = parseStep1Response(strReponse);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Response : "+response);
		model.addAttribute("targetUrl", response.getFormUrl());
		
		return "step2";
		
	}
	
	@PostMapping("/step3submit")
	public String step3Submit(HttpServletRequest request, ModelMap model)
	{

		Step3Request step3 = parseCompleteActionRequest(request);
		
		String xmlString = getStep3XMLRequest(step3);
		
		String response = null;
		
		try
		{
			response = post(xmlString);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Step3 Response : "+response);
		model.addAttribute("step3result", response);
		return "step3result";
		
	}
	
	
	private Step3Request parseCompleteActionRequest(HttpServletRequest request)
	{
		Step3Request step3 = new Step3Request();
		
		try
		{
			String apiKey = request.getParameter("txtAPIKey");
			String tokenId = request.getParameter("txtTokenId");
			
			step3.setApiKey(apiKey);
			step3.setTokenId(tokenId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return step3;
		
		
		
	}
	
	private Step1Response parseStep1Response(String response)
	{
		Step1Response step1Response = null;
	     try
	     {
		     JAXBContext context = JAXBContext.newInstance(Step1Response.class);
		     Unmarshaller unmarshaller = context.createUnmarshaller();
		     XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(response));
		    
		     step1Response = (Step1Response) unmarshaller.unmarshal(reader);
		     System.out.println("Response : "+step1Response);
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     
	     return step1Response;
		
	}
	
	private String post(String request) throws IOException, JAXBException, XMLStreamException, FactoryConfigurationError
	{
		HttpURLConnection postConn;

	     HostnameVerifier hv = new HostnameVerifier() {
	        public boolean verify(String urlHostName, SSLSession session) {
	            return true;
	        }
	     };

	     HttpsURLConnection.setDefaultHostnameVerifier(hv);

	     URL post = new URL("https://secure.nmi.com/api/v2/three-step");
	     postConn = (HttpURLConnection)post.openConnection();

	     postConn.setRequestMethod("POST");
	     postConn.setDoOutput(true);
	     postConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

	     PrintWriter out = new PrintWriter(postConn.getOutputStream());
	     out.print(request);
	     out.close();

	     BufferedReader in =
	        new BufferedReader(new InputStreamReader(postConn.getInputStream()));

	     String inputLine;
	     StringBuffer buffer = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	        buffer.append(inputLine);
	     }
	     in.close();


	     String response = "";
	     if(buffer!=null)
	    	 response = buffer.toString();
	     
	     return response;
	     
	}
	
	private String postRequest(String requestXML) throws IOException
	{
		URL url = new URL("https://secure.nmi.com/api/v2/three-step");
		
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        
        con.setDoOutput(true);

		// Set timeout as per needs
		con.setConnectTimeout(20000);
		con.setReadTimeout(20000);

		
		con.setRequestMethod("POST");

		// Set Headers
		con.setRequestProperty("Accept", "application/xml");
		con.setRequestProperty("Content-Type", "application/xml");

		// Write XML
		OutputStream outputStream = con.getOutputStream();
		byte[] b = requestXML.getBytes("UTF-8");
		outputStream.write(b);
		outputStream.flush();
		outputStream.close();

		// Read XML
		InputStream inputStream = con.getInputStream();
		byte[] res = new byte[2048];
		int i = 0;
		StringBuilder response = new StringBuilder();
		while ((i = inputStream.read(res)) != -1) {
			response.append(new String(res, 0, i));
		}
		inputStream.close();

		System.out.println("Response= " + response.toString());
		return response.toString();
	}
	
	private String getSaleXMLRequest(Sale sales)
	{
		String xmlContent = "";
		try
		{
			JAXBContext context = JAXBContext.newInstance(Sale.class);
			
			Marshaller jaxbMarshaller = context.createMarshaller();
			 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(sales, sw);
             
            //Verify XML Content
            xmlContent = sw.toString();
            System.out.println( xmlContent );
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return xmlContent;
	}
	
	private String getStep3XMLRequest(Step3Request step3)
	{
		String xmlContent = "";
		try
		{
			JAXBContext context = JAXBContext.newInstance(Step3Request.class);
			
			Marshaller jaxbMarshaller = context.createMarshaller();
			 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(step3, sw);
             
            //Verify XML Content
            xmlContent = sw.toString();
            System.out.println( xmlContent );
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return xmlContent;
	}
	
	
	  private Sale parseSaleFromRequest(HttpServletRequest request) 
	  {
		  Sale sale = new Sale();
		
		  try
		  {
			  String apiKey = request.getParameter("txtApiKey");
			  String redirectUrl = request.getParameter("txtRedirectURL");
			  String amount = request.getParameter("txtAmount");
			  String valtId = request.getParameter("txtCustValtId");
			  String currency = request.getParameter("txtCurrency");
			  String orderId = request.getParameter("txtOrderId");
			  String orderDescription = request.getParameter("txtOrderDescription");
			  String merchanField1 = request.getParameter("txtMerField1");
			  String merchanField2 = request.getParameter("txtMerField2");
			  String taxAmount = request.getParameter("txtTaxAmount");
			  String shippingAmount = request.getParameter("txtShippingAmount");
			  
			  String billingFirstName = request.getParameter("billingAddressFirstName");
			  String billingLastName = request.getParameter("billingAddressLastName");
			  String billingAddr1 = request.getParameter("billingAddressAddress1");
			  String billingAddr2 = request.getParameter("billingAddressAddress2");
			  String billingCity = request.getParameter("billingAddressCity");
			  String billingState = request.getParameter("billingAddressState");
			  String billingZip = request.getParameter("billingAddressZip");
			  String billingCountry = request.getParameter("billingAddressCountry");
			  String billingPhone = request.getParameter("billingAddressPhone");
			  String billingCompany = request.getParameter("billingAddressCompany");
			  String billingEmail = request.getParameter("billingAddressEmail");
			  String billingFax = request.getParameter("billingFax");
			  
			  
			  String shippingFirstName = request.getParameter("shippingAddressFirstName");
			  String shippingLastName = request.getParameter("shippingAddressLastName");
			  String shippingAddr1 = request.getParameter("shippingAddressAddress1");
			  String shippingAdd2 = request.getParameter("shippingAddressAddress2");
			  String shippingCity = request.getParameter("shippingAddressCity");
			  String shippingState = request.getParameter("shippingAddressState");
			  String shippingZip = request.getParameter("shippingAddressZip");
			  String shippingCountry = request.getParameter("shippingAddressCountry");
			  String shippingPhone = request.getParameter("shippingAddressPhone");
			  
			  
			  String prdCode = request.getParameter("txtPrdCode");
			  String prdDescription = request.getParameter("txtDescription");
			  String prdQty = request.getParameter("txtQty");
			  String prdUnitOfMeasure = request.getParameter("txtUnitOfMeasure");
			  String prdTotalAmount = request.getParameter("txtTotalAmount");
			  String prdDiscount = request.getParameter("txtDiscount");
			  String prdTax = request.getParameter("txtTaxAmount");
			  String prdTaxRate = request.getParameter("txtTaxRate");
			  
			  
			  sale.setApiKey(apiKey);
			  sale.setRedirectURL(redirectUrl);
			  sale.setAmount(amount);
			  sale.setCurrency(currency);
			  sale.setOrderId(orderId);
			  sale.setOrderDescription(orderDescription);
			  sale.setMerchantField1(merchanField1);
			  sale.setMerchantField2(merchanField2);
			  sale.setTaxAmount(taxAmount);
			  sale.setShippingAmount(shippingAmount);
			  
			  Customer cust = new Customer();
			  cust.setCustValtId(valtId);
			  sale.setAddCustomer(cust);
			  
			  BillingAddress billing = new BillingAddress();
			  billing.setFirstName(billingFirstName);
			  billing.setLastName(billingLastName);
			  billing.setAddress1(billingAddr1);
			  billing.setCity(billingCity);
			  billing.setState(billingState);
			  billing.setCountry(billingCountry);
			  billing.setPostal(billingZip);
			  billing.setEmail(billingEmail);
			  billing.setCompany(billingCompany);
			  billing.setAddress2(billingAddr2);
			  billing.setFax(billingFax);
			  billing.setPhone(billingPhone);
			  
			  sale.setBillingAddress(billing);
			  
			  ShippingAddress shipping = new ShippingAddress();
			  shipping.setFirstName(shippingFirstName);
			  shipping.setLastName(shippingLastName);
			  shipping.setAddress1(shippingAddr1);
			  shipping.setCity(shippingCity);
			  shipping.setState(shippingState);
			  shipping.setPostal(shippingZip);
			  shipping.setCountry(shippingCountry);
			  shipping.setPhone(shippingPhone);
			  shipping.setEmail(billingEmail);
			  shipping.setCompany(billingCompany);
			  shipping.setAddress2(billingAddr2);
			  shipping.setFax(billingFax);
			  shipping.setAddress2(shippingAdd2);
			  
			  sale.setShippingAddress(shipping);
			  
			  Product product = new Product();
			  product.setProductCode(prdCode);
			  product.setDescription(prdDescription);
			  product.setQuantity(prdQty);
			  product.setUnitOfMeasure(prdUnitOfMeasure);
			  product.setTotalAmount(prdTotalAmount);
			  product.setDiscountAmount(prdDiscount);
			  product.setTaxAmount(prdTax);
			  product.setTaxRate(prdTaxRate);
			  List<Product> prdList = new ArrayList<Product>();
			  prdList.add(product);
			  sale.setProductList(prdList);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return sale;
	  
	  }
	 
	 
	
}
