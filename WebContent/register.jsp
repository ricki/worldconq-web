<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WorldConq - Register</title>
</head>
<s:include value="header.jsp" />
<body>
	<header>
		<h1>
			<s:a action="index">WoldConq</s:a>
		</h1>
	</header>


	<s:div id="content">
		<h2>Registro</h2>

		<s:actionmessage />
		<s:actionerror />
			
		<s:form action="do_register">
			<s:textfield name="username" label="Usuario" />
			<s:password name="password" label="Contraseña" />
			<s:textfield name="email" label="Email" />
			<s:submit />
		</s:form>		

	</s:div>



</body>
</html>