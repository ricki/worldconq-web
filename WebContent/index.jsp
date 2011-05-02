<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">
<title>WorldConq - Home</title>
<s:if test="%{ #session.user != null}">
	<meta http-equiv="Refresh" content="0;/worldconq-web/listGames.action">
</s:if>
</head>

<body bgcolor="#000000" background="image/mapafondobig.jpg" style="background-attachment: fixed; background-position: 50% 40%; background-repeat: no-repeat;">
	<table align="center" style="padding-top: 60px">
		<tr>
			<s:include value="header.jsp" />
		</tr>
	</table>
	<table align="center" style="padding-top: 60px">
		<tr>
			<td>		
			<s:div id="content">

				<s:actionmessage />
				<s:actionerror />

				<s:if test="%{ #session.user == null}">
					<s:form action="login">
						<s:textfield name="username" label="Usuario" />
						<s:password name="password" label="Contraseña" />
						<s:submit value="Entrar"/>
					</s:form>
				</s:if>
			</s:div>
			
			</td>
		</tr>
	</table>
</body>

</html>