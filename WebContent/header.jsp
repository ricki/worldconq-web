<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<div id="header">
	<h1>
		<s:a action="index">WorldConq</s:a>
	</h1>
	<ul id="headlist">
		<li id="ini"><s:a action="index">Inicio</s:a></li>
		<s:if test="%{ #session.user != null}">
			<li><s:a action="logout">Logout</s:a></li>
		</s:if>
		<s:else>		
			<li><s:a action="register">Registrarse</s:a>
			<li><s:a action="index">Conectarse</s:a></li>
		</s:else>

	</ul>
</div>
