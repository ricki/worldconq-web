<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WorldConq - CreateGame</title>
	<script src="/worldconq-web/js/jscal2.js"></script> 
    <script src="/worldconq-web/js/lang/es.js"></script> 
    <link rel="stylesheet" type="text/css" href="/worldconq-web/css/jscal2.css" /> 
    <link rel="stylesheet" type="text/css" href="/worldconq-web/css/border-radius.css" /> 
    <link rel="stylesheet" type="text/css" href="/worldconq-web/css/steel/steel.css" /> 
    <script> 
    	var cont=0;
    	var cal = Calendar.setup({onSelect: function(cal) {cal.hide();},showTime: true});
    	
    	function inicializar(){
    		cal.manageFields("f_btn0", "f_date0", "%d-%m-%Y %H:%M");
    	}
    	
		function ejecutaCodigo() { 
			//guardamos el HTML sin contenido
			var formulario = document.getElementById("fechas").innerHTML;
			
			//guardamos el contenido de los valores de las fechas
			arrayfechas=new Array();
			for(i=0;i<=cont;i++){
				arrayfechas[i]=document.getElementById("f_date"+i).value;
			}
			cont++;
			//creamos la nueva linea para anadir
			var fechaNueva='<br><input size="30" id="f_date'+cont+'" readonly="true" /><input type="button" id="f_btn'+cont+'" value="..." />';
			
			//asignamos los valores al formulario
			document.getElementById("fechas").innerHTML=formulario+fechaNueva;
			
			//restauramos los valores de las fechas anteriores
			for(i=0;i<cont;i++){
				document.getElementById("f_date"+i).value=arrayfechas[i];
			}
			
			//asignamos los botones del calendario al campo
			for(i=0;i<=cont;i++){
				cal.manageFields("f_btn"+i, "f_date"+i, "%d-%m-%Y %I:%M");
			}
			
		}
	      
	</script> 
	
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
		
		
		<s:form name="crearJuego" action="createGame" >
			<s:textfield name="name" label="Nombre" />
			<s:textfield name="description" label="Descripción" />			
			<s:textfield name="turnTime" label="Tiempo de Turno" />
			<s:textfield name="defTime" label="Tiempo de Defensa" />
			<s:textfield name="negTime" label="Tiempo de Negociación" />
		</s:form>
		
		<h4>Lista de Fechas de juego:</h4>
		<s:form name="listaFechas">
			<s:div id="fechas">
				<input size="30" id="f_date0" readonly="true" /><input type="button" id="f_btn0" value="..." />
				<script>inicializar();</script>
				<input type="button" value="+" id="btnMas" onclick="ejecutaCodigo()" /> 
    		</s:div>
    		<s:submit value="Create Game"/>
		</s:form>
	</s:div>
	
	
</body>
</html>