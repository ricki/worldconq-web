<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">

<title>WorldConq - Esta siendo atacado</title>
</head>
<body>
	<s:include value="header.jsp" />
	<s:div id="content">
		<s:form name="underAttack">
			<s:div id="nombre">
			Te está atacando 
			<s:text name="currentAttack.getOrigin().owner"></s:text>
			desde el territorio 
			<s:text name="currentAttack.getOrigin().getName()"></s:text>
			al territorio
			<s:text name="currentAttack.getDestination().getName()"></s:text>
			
			<table>
				<tr>
					
				</tr>
			
			</table>
			
			</s:div>
		</s:form>
	</s:div>



</body>
</html>