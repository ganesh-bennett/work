

<html>

<head>
	<title>Step2</title>
</head>
<body>

<form>

<h3> Payment Information</h3>
 <table>
     <tr>
     	<td>Credit Card Number</td>
     	<td>
     		<INPUT type ="text" name="billing-cc-number" value="4111111111111111"> 
     	</td>
     </tr>
     <tr>
     	<td>Expiration Date</td>
     	<td>
     		<INPUT type ="text" name="billing-cc-exp" value="1012"> 
     	</td>
     </tr>
     <tr>
     	<td>CVV</td>
     	<td>
     		<INPUT type ="text" name="cvv" > 
     	</td>
     </tr>
     <tr>
     	<Td colspan="2" align=center>
     		<INPUT type ="button" value="Submit Step Two" onclick="fnSubmitStep2()">
     	</td> 
     </tr>
 </table>
            
<input type="text" name="hidUrl" id="hidUrl" value="${targetUrl}"/>
</form>
</body>
<script>
function fnSubmitStep2()
{
	alert("Submitting the form");
	document.forms[0].action = document.getElementById("hidUrl").value;
	document.forms[0].method = "post";
	document.forms[0].submit();
}
</script>
</html>