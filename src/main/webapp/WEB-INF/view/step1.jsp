
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title> Step1 </title>
</head>
<body>


<form:form id="form1" action="/payment/step1submit" method="post">

<h2>Step One: Collect non-sensitive payment information.<br /></h2>

<h3> Customer Information</h3>
<table>
	<tr>
		<td>API Key  </td>
		<td>
			<input type="text" id = "txtApiKey" name="txtApiKey" value="2F822Rw39fx762MaV7Yy86jXGTC7sCDy" />
		</td>
	</tr>
	<tr>
		<td>Redirect URL  </td>
		<td>
			<input type="text" id = "txtRedirectURL" name="txtRedirectURL"
				value="http://localhost:8080/payment/step3" />
		</td>
	</tr>
	<tr>
		<td>Amount  </td>
		<td>
			<input type="text" id = "txtAmount" name="txtAmount" value="10.00"/>
		</td>
	</tr>
	<tr>
		<td>Customer Vault Id  </td>
		<td>
			<input type="text" id = "txtCustValtId" name="txtCustValtId"/>
		</td>
	</tr>
	<tr>
		<td>Currency  </td>
		<td>
			<input type="text" id = "txtCurrency" name="txtCurrency" value="USD"/>
		</td>
	</tr>
	<tr>
		<td>Order Id  </td>
		<td>
			<input type="text" id = "txtOrderId" name="txtOrderId" value="1234"/>
		</td>
	</tr>
	<tr>
		<td>Order Description  </td>
		<td>
			<input type="text" id = "txtOrderDescription" name="txtOrderDescription" value="Small Order"/>
		</td>
	</tr>
	<tr>
		<td>Merchant Field 1  </td>
		<td>
			<input type="text" id = "txtMerField1" name="txtMerField1" value="Red"/>
		</td>
	</tr>
	<tr>
		<td>Merchant Field 2  </td>
		<td>
			<input type="text" id = "txtMerField2" name="txtMerField2" value="Medium"/>
		</td>
	</tr>
	<tr>
		<td>Tax Amount  </td>
		<td>
			<input type="text" id = "txtTaxAmount" name="txtTaxAmount" value="0.00"/>
		</td>
	</tr>
	<tr>
		<td>Shipping Amount  </td>
		<td>
			<input type="text" id = "txtShippingAmount" name="txtShippingAmount" value="0.00"/>
		</td>
	</tr>
</table>

<table>
	<tr>
		<td align="center">
			<b>Billing Details</b>
		</td>
		<td align="center">
			<b>Shipping Details</b>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td>First Name </td>
					<td>
						<input type="text" id = "billingAddressFirstName" name="billingAddressFirstName" value="John"/>
					</td>
				</tr>
				<tr>
					<td>Last Name </td>
					<td>
						<input type="text" id = "billingAddressLastName" name="billingAddressLastName" value="Smith"/>
					</td>
				</tr>
				<tr>
					<td>Address </td>
					<td>
						<input type="text" id = "billingAddressAddress1" name="billingAddressAddress1" value="1234 Main St."/>
					</td>
				</tr>
				<tr>
					<td>Address2</td>
					<td>
						<input type="text" id = "billingAddressAddress2" name="billingAddressAddress2" value="Acme, Inc."/>
					</td>
				</tr>
				<tr>
					<td>City </td>
					<td>
						<input type="text" id = "billingAddressCity" name="billingAddressCity" value="Beverly Hills"/>
					</td>
				</tr>
				<tr>
					<td>State/Province </td>
					<td>
						<input type="text" id = "billingAddressState" name="billingAddressState" value="CA"/>
					</td>
				</tr>
				<tr>
					<td>Zip/Postal </td>
					<td>
						<input type="text" id = "billingAddressZip" name="billingAddressZip" value="90210"/>
					</td>
				</tr>
				<tr>
					<td>Country </td>
					<td>
						<input type="text" id = "billingAddressCountry" name="billingAddressCountry" value="US"/>
					</td>
				</tr>
				<tr>
					<td>Phone Number </td>
					<td>
						<input type="text" id = "billingAddressPhone" name="billingAddressPhone" value="555-555-5555"/>
				</td>
				</tr>
				<tr>
					<td>Company</td>
					<td>
						<input type="text" id = "billingAddressCompany" name="billingAddressCompany" value="Acme, Inc."/>
					</td>
				</tr>
				<tr>
					<td>Email Address </td>
					<td>
						<input type="text" id = "billingAddressEmail" name="billingAddressEmail" value="test@test.com"/>
					</td>
				</tr>
				<tr>
					<td>Fax </td>
					<td>
						<input type="text" id = "billingFax" name="billingFax" value="2323"/>
					</td>
				</tr>
			</table>
		</td>
		<td>
			<table>
				<tr>
					<td>First Name </td>
					<td>
						<input type="text" id = "shippingAddressFirstName" name="shippingAddressFirstName" value="Mary"/>
					</td>
				</tr>
				<tr>
					<td>Last Name </td>
					<td>
						<input type="text" id = "shippingAddressLastName" name="shippingAddressLastName" value="Smith"/>
					</td>
				</tr>
				<tr>
					<td>Address </td>
					<td>
						<input type="text" id = "shippingAddressAddress1" name="shippingAddressAddress1" value="1234 Main St."/>
					</td>
				</tr>
				<tr>
					<td>City </td>
					<td>
						<input type="text" id = "shippingAddressCity" name="shippingAddressCity" value="Beverly Hills"/>
					</td>
				</tr>
				<tr>
					<td>State/Province </td>
					<td>
						<input type="text" id = "shippingAddressState" name="shippingAddressState" value="CA"/>
					</td>
				</tr>
				<tr>
					<td>Zip/Postal </td>
					<td>
						<input type="text" id = "shippingAddressZip" name="shippingAddressZip" value="90210"/>
					</td>
				</tr>
				<tr>
					<td>Country</td>
					<td>
						<input type="text" id = "shippingAddressCountry" name="shippingAddressCountry" value="US"/>
					</td>
				</tr>
				<tr>
					<td>Phone Number </td>
					<td>
						<input type="text" id = "shippingAddressPhone" name="shippingAddressPhone" value="555-555-5555"/>
					</td>
				</tr>
				<tr>
					<td>Email </td>
					<td>
						<input type="text" id = "shippingEmail" name="shippingEmail" value="test@test.com"/>
					</td>
				</tr>
				<tr>
					<td>Company </td>
					<td>
						<input type="text" id = "shippingCompany" name="shippingCompany" value="cccc"/>
					</td>
				</tr>
				<tr>
					<td>Suite</td>
					<td>
						<input type="text" id = "shippingAddressAddress2" name="shippingAddressAddress2" value="Unit #2"/>
					</td>
				</tr>
				<tr>
					<td>fax</td>
					<td>
						<input type="text" id = "shippingFax" name="shippingFax" value="343242"/>
					</td>
				</tr>
							
			</table>
		</td>
	</tr>
	
</table>

<br/>
<table rules="all">
	<tr>
		<td colspan="8"> <b> Product </b></td>
	</tr>
	<tr>
		<td> Product Code </td>
		<td> Description </td>
		<td> Quantity </td>
		<td> Unit of Measure </td>
		<td> Total Amount </td>
		<td> Discount Amount </td>
		<td> Tax Amount </td>
		<td> Tax Rate </td>
	</tr>
	<tr>
		<td>
			<input type="text" name="txtPrdCode" id="txtPrdCode" value="SKU-654321"/>
		</td>
		<td>
			<input type="text" name="txtDescription" id="txtDescription" value="Videos"/>
		</td>
		<td>
			<input type="text" name="txtQty" id="txtQty" value="1"/>
		</td>
		<td>
			<input type="text" name="txtUnitOfMeasure" id="txtUnitOfMeasure" value=""/>
		</td>
		<td>
			<input type="text" name="txtTotalAmount" id="txtTotalAmount" value="12"/>
		</td>
		<td>
			<input type="text" name="txtDiscount" id="txtDiscount" value="0.00"/>
		</td>
		<td>
			<input type="text" name="txtTaxAmount" id="txtTaxAmount" value="0.00"/>
		</td>
		<td>
			<input type="text" name="txtTaxRate" id="txtTaxRate" value="0.00"/>
		</td>
	</tr>
	
</table>

<br/>
<input type="submit" value="Submit Step One" id="submitStepOne" />

</form:form>




</body>
</html>