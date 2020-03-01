
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<title>Step3</title>
</head>
<body>
<h3>step3 </h3>
<form:form id="form1" action="/payment/step3submit" method="post">

<table>
	<tr>
		<td> Key </td>
		<td>
			<input type="text" name="txtAPIKey" id="txtAPIKey" value="${apiKey }"/>
		</td>
	</tr>
	<tr>
		<td> Token </td>
		<td>
			<input type="text" name="txtTokenId" id="txtTokenId" value = "${tokenId }" />
		</td>
	</tr>
</table>
<input type="submit" value="Submit Step 3" id="submitStep3" />
</form:form>
</body>
</html>