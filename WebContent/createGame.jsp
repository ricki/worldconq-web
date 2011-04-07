<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WorldConq - CreateGame</title>
	<script src="/js/jscal2.js"></script> 
    <script src="/js/lang/es.js"></script> 
    <link rel="stylesheet" type="text/css" href="/css/jscal2.css" /> 
    <link rel="stylesheet" type="text/css" href="/css/border-radius.css" /> 
    <link rel="stylesheet" type="text/css" href="/css/steel/steel.css" /> 
</head>

<body>
	<header>
		<h1>
			<s:a action="index">WorldConq</s:a>
		</h1>
	</header>

<%-- nombre, descripcion, lista sesiones, turno, defensa time, negociacion time --%>

	<s:div id="content">

		<h2>Crear Partida</h2>
		
		<s:actionmessage />
		<s:actionerror />
		
		
		<s:form action="createGame">
			<s:textfield name="name" label="Nombre" />
			<s:textfield name="description" label="Descripción" />
			
			<input size="30" id="f_date1" readonly="true" /><button id="f_btn1">...</button><br /> 
	    	<input size="30" id="f_date2" readonly="true" /><button id="f_btn2">...</button><br /> 
	    	<input size="30" id="f_date3" readonly="true" /><button id="f_btn3">...</button><br /> 
	    	<input size="30" id="f_date4"  /><button id="f_btn4">...</button> 
			
			<s:textfield name="turnTime" label="Tiempo de Turno" />
			<s:textfield name="defTime" label="Tiempo de Defensa" />
			<s:textfield name="negTime" label="Tiempo de Negociación" />
			<s:submit value="Create Game"/>
		</s:form>

	</s:div>
	
	<script type="text/javascript">//<![CDATA[
 
      var cal = Calendar.setup({
          onSelect: function(cal) { cal.hide() },
          showTime: true
      });
      cal.manageFields("f_btn1", "f_date1", "%d/%m/%Y %I:%M %p");
      cal.manageFields("f_btn2", "f_date2", "%d/%m/%Y %I:%M %p");
      cal.manageFields("f_btn3", "f_date3", "%d/%m/%Y %I:%M %p");
      cal.manageFields("f_btn4", "f_date4", "%d/%m/%Y %I:%M %p");
 
    //]]></script> 
</body>
</html>