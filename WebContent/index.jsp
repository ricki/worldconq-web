<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WorldConq - Home</title>
</head>

<body>
	<header>
		<h1>
			<s:a action="index">WorldConq</s:a>
		</h1>
	</header>

	<s:div id="content">

		<s:actionmessage />
		<s:actionerror />

		<s:if test="%{ #session.user == null}">
			<s:form action="login">
				<s:textfield name="username" label="Usuario" />
				<s:password name="password" label="Contraseña" />
				<s:submit />
			</s:form>
		</s:if>
		<s:else>
			<p>
				Hola
				<s:property value="#session.user" />
			</p>
		</s:else>

	</s:div>
</body>

</html>