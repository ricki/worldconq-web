<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Language" content="es">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>___ La Conquista del Mundo ___</title>
<script type="text/javascript">
    var GB_ROOT_DIR = "./greybox/";
</script>

<script type="text/javascript" src="greybox/AJS.js"></script>
<script type="text/javascript" src="greybox/AJS_fx.js"></script>
<script type="text/javascript" src="greybox/gb_scripts.js"></script>
<script type="text/javascript" src="info_territories.js"></script>
<link href="greybox/gb_styles.css" rel="stylesheet" type="text/css" media="all" />
    
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
   <script>
   		var seleccionado = 0;
   		var territorio_seleccionado = "";
		var datos = new Array();	
		/*eliminar despues, cuando funcione el ajax
		var xml2='<?xml version="1.0" encoding="UTF-8"?><gamedata><territories><territory><id>0</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>1</id><owner>a</owner><soldiers>13</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>2</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>3</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>4</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>5</id><owner>qwer</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>6</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>7</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>8</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>9</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>10</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>11</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>12</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>13</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>14</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>15</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>16</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>17</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>18</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>19</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>20</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>21</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>22</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>23</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>24</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>25</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>26</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>27</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>28</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>29</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>30</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>31</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>32</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>33</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>34</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>35</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>36</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>37</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>38</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>39</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>40</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory><territory><id>41</id><owner>?</owner><soldiers>0</soldiers><cannons><cannon>0</cannon><cannon>0</cannon><cannon>0</cannon></cannons><missiles>0</missiles><icbm>0</icbm><antimissiles>0</antimissiles></territory></territories><players><player><name>a</name><money>1000</money><state>1</state></player><player><name>qwer</name><money>1000</money><state>2</state></player></players></gamedata>';

		if (window.DOMParser)
		  {
		  parser=new DOMParser();
		  xml=parser.parseFromString(xml2,"text/xml");
		  }
		else // Internet Explorer
		  {
		  xml=new ActiveXObject("Microsoft.XMLDOM");
		  xml.async="false";
		  xml.loadXML(xml2);
		  }
		
		
		eliminar hasta aqui*/
		
		var ajax;
		var array_territorios = new Array();
		var array_usuarios = new Array();
					
		function seleccionarTerritorio(territorio){
			if(seleccionado == 0){
				document.getElementById(datos_paises[territorio][0]).setAttribute('class','territorio_seleccionado');
				territorio_seleccionado = territorio;
				seleccionado = 1;
				
				cargarDatosTerritorio(territorio);
				
				//habilitamos los botones
				if(array_territorios[territorio][3] == document.getElementById('self_user').value){
					//El territorio ya es del usuario
					document.getElementById('boton_mover').disabled = false;
					document.getElementById('boton_mover').src="./image/botonmover.png";
					
					document.getElementById('boton_refuerzos').disabled = false;
					document.getElementById('boton_refuerzos').src="./image/botonrefuerzos.png";
					
					document.getElementById('boton_atacar').disabled = false;
					document.getElementById('boton_atacar').src="./image/botonatacar.png";
					
					//deshabilitar
					document.getElementById('boton_comprar').disabled = true;
					document.getElementById('boton_comprar').src="./image/botoncomprar_disabled.png";
					
					document.getElementById('boton_espiar').disabled = true;
					document.getElementById('boton_espiar').src="./image/botonespiar_disabled.png";
					
					
				}else{
					//territorio libre
					document.getElementById('boton_comprar').disabled = false;
					document.getElementById('boton_comprar').src="./image/botoncomprar.png";
					
					document.getElementById('boton_espiar').disabled = false;
					document.getElementById('boton_espiar').src="./image/botonespiar.png";
					
					//deshabilitar
					document.getElementById('boton_mover').disabled = true;
					document.getElementById('boton_mover').src="./image/botonmover_disabled.png";
					
					document.getElementById('boton_refuerzos').disabled = true;
					document.getElementById('boton_refuerzos').src="./image/botonrefuerzos_disabled.png";
					
					document.getElementById('boton_atacar').disabled = true;
					document.getElementById('boton_atacar').src="./image/botonatacar_disabled.png";
					
				}
				drawTerritories();
				 
			}else if (seleccionado == 1 && territorio_seleccionado != territorio){
				//alert(territorio_seleccionado +" Atacar "+ territorio);
				seleccionado = 1;
				document.getElementById(datos_paises[territorio_seleccionado][0]).setAttribute('class','territorio');
				document.getElementById(datos_paises[territorio][0]).setAttribute('class','territorio_seleccionado');
				territorio_seleccionado = territorio;
				cargarDatosTerritorio(territorio);
				
				if(array_territorios[territorio][3] == document.getElementById('self_user').value){
					//El territorio ya es del usuario
					document.getElementById('boton_mover').disabled = false;
					document.getElementById('boton_mover').src="./image/botonmover.png";
					
					document.getElementById('boton_refuerzos').disabled = false;
					document.getElementById('boton_refuerzos').src="./image/botonrefuerzos.png";
					
					document.getElementById('boton_atacar').disabled = false;
					document.getElementById('boton_atacar').src="./image/botonatacar.png";
					
					//deshabilitar
					document.getElementById('boton_comprar').disabled = true;
					document.getElementById('boton_comprar').src="./image/botoncomprar_disabled.png";
					
					document.getElementById('boton_espiar').disabled = true;
					document.getElementById('boton_espiar').src="./image/botonespiar_disabled.png";
					
					
				}else{
					//territorio libre
					document.getElementById('boton_comprar').disabled = false;
					document.getElementById('boton_comprar').src="./image/botoncomprar.png";
					
					document.getElementById('boton_espiar').disabled = false;
					document.getElementById('boton_espiar').src="./image/botonespiar.png";
					
					//deshabilitar
					document.getElementById('boton_mover').disabled = true;
					document.getElementById('boton_mover').src="./image/botonmover_disabled.png";
					
					document.getElementById('boton_refuerzos').disabled = true;
					document.getElementById('boton_refuerzos').src="./image/botonrefuerzos_disabled.png";
					
					document.getElementById('boton_atacar').disabled = true;
					document.getElementById('boton_atacar').src="./image/botonatacar_disabled.png";
					
				}
				
				drawTerritories();
				
			}else{
				seleccionado = 0;
				document.getElementById(datos_paises[territorio_seleccionado][0]).setAttribute('class','territorio');
				inicializarInfoTerritorio();
				
				//deshabilitamos todos los botones
				document.getElementById('boton_comprar').disabled = true;
				document.getElementById('boton_comprar').src="./image/botoncomprar_disabled.png";
				
				document.getElementById('boton_espiar').disabled = true;
				document.getElementById('boton_espiar').src="./image/botonespiar_disabled.png";
				
				document.getElementById('boton_mover').disabled = true;
				document.getElementById('boton_mover').src="./image/botonmover_disabled.png";
				
				document.getElementById('boton_refuerzos').disabled = true;
				document.getElementById('boton_refuerzos').src="./image/botonrefuerzos_disabled.png";
				
				document.getElementById('boton_atacar').disabled = true;
				document.getElementById('boton_atacar').src="./image/botonatacar_disabled.png";
				
				drawTerritories();
			}
				
		}
		
		function inicializarTablaUsuarios(){
			//alert(array_usuarios);
			texto = "<table class='tablados'><tr><th style='width:30%'>Estado</th><th style='width:70%'>Usuario</th></tr>";
			for(var id in array_usuarios){
				var imagen="";
			 	if(array_usuarios[id][2]==1){//conectado
					imagen = "<img title = 'Conectado' src='image/mipuntero.png'></img>";
				}else if(array_usuarios[id][2]==0){//desconectado
					imagen = "<img title = 'Desconectado' src='image/punteroenemigo.png'></img>";
				}else if(array_usuarios[id][2]==2){//turno
					imagen = "<img title = 'Turno' src='image/punterosmall.png'></img>";
				}
				texto = texto + "<tr><td>"+imagen+"</td><td>"+array_usuarios[id][0]+"</td></tr>";
			}
			texto = texto +"</table>";
			document.getElementById('infodos').innerHTML = texto;
		}
		
		function inicializarInfoGeneral(){
			var self_user = document.getElementById('self_user').value;
			
			var self_money = 0;
			for(var id in array_usuarios){
				if(array_usuarios[id][0] == self_user){
					self_money = array_usuarios[id][1];
				}
			}
			
			texto="<table class='tablauno'>";
			texto = texto + "<tr><td class='campo' style='width:50%'>Usuario:</td><td class='campo_texto' style='width:50%'>"+self_user+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Galligantes:</td><td class='campo_texto'>"+self_money+"</td></tr>";
			texto = texto + "</table>";
		
			document.getElementById('infouno').innerHTML = texto;
		}
		
		function inicializarInfoTerritorio(){
			texto="<table class='tablatres'>";
			texto = texto + "<tr><td class='campo' style='width:50%'>Territorio:</td><td class='campo_texto' style='width:50%'></td></tr>";
			texto = texto + "<tr><td class='campo'>Precio:</td><td class='campo_texto'></td></tr>";
			texto = texto + "<tr><td class='campo'>Propietario:</td><td class='campo_texto'></td></tr>";
			texto = texto + "<tr><td class='campo'>Soldados:</td><td class='campo_texto'></td></tr>";
			texto = texto + "<tr><td class='campo'>Cañones:</td><td class='campo_texto'></td></tr>";
			texto = texto + "<tr><td class='campo'>Misiles:</td><td class='campo_texto'></td></tr>";
			texto = texto + "<tr><td class='campo'>Antimisiles:</td><td class='campo_texto'></td></tr>";
			texto = texto + "<tr><td class='campo'>ICBM:</td><td class='campo_texto'></td></tr>";
			texto = texto + "</table>";
			
			document.getElementById('infotres').innerHTML = texto;
		}

		function functionCallback()
		{
			// Comprobamos si la peticion se ha completado (estado 4)
			if( ajax.readyState == 4 )
			{
				// Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
				if( ajax.status == 200 )
				{
					// Escribimos el resultado en la pagina HTML mediante DHTML
					xml = ajax.responseXML;
					
					refreshTerritories();
					refreshUsers();
					inicializarTablaUsuarios();
					inicializarInfoGeneral();
					if(territorio_seleccionado == ""){
						inicializarInfoTerritorio();	
					}
					drawTerritories();
					checkEvents();

					
				}
			}
		}
		
		function callbackAjax()
		{
			// Comprobamos si la peticion se ha completado (estado 4)
			if( ajax.readyState == 4 )
			{
				// Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
				if( ajax.status == 200 )
				{
					// Escribimos el resultado en la pagina HTML mediante DHTML
				respuesta = ajax.responseXML;
					
				comprobarRespuestas(respuesta);
					
				}
			}
		}
		
		function checkEvents(){
			var e = xml.getElementsByTagName('events');
			
			for(var i= 0; i<e.length; i++){
				switch(e[i].getElementsByTagName('type')[0].firstChild.nodeValue){
					case 0:
						//evento de mensaje de texto
						texto = document.getElementById('infoArea').innerHTML;
						texto = texto+"\n"+e[i].getElementsByTagName('message')[0].firstChild.nodeValue;
						document.getElementById('infoArea').innerHTML = texto;
						break;
					case 1:
						GB_show('Estas siendo atacado!!!', '../underAttack.jsp');
						break;
					case 2:
						soldiers = e[i].getElementsByTagName('soldiers')[0].firstChild.nodeValue;
						money = e[i].getElementsByTagName('money')[0].firstChild.nodeValue;
						texto = "Negociación:\n ¿Deseas negociar?\n "+soldiers+" Soldados.\n"+money+" Gallifantes.";
						valor = confirm(texto);
						if(valor){
							//Aceptamos negociación.
							responseNegotiationAjax(1);
						}else{
							//Rechazamos negociación
							responseNegotiationAjax(0);
						}
						break;
				}
			}
			
		}
		
		function drawTerritories(){
			for (t=0; t<array_territorios.length;t++){
				if(array_territorios[t][3] == document.getElementById('self_user').value){
					document.getElementById(datos_paises[t][0]).setAttribute("class", "territorio_propio");
				}else if (array_territorios[t][3] != "?" && array_territorios[t][3] != ""){
					document.getElementById(datos_paises[t][0]).setAttribute("class", "territorio_enemigo");
				}else{
					document.getElementById(datos_paises[t][0]).setAttribute("class", "territorio");
				}
			}
			
			//volvemos a marcar el territorio seleccionado si lo habia
			if(seleccionado == 1){
				document.getElementById(datos_paises[territorio_seleccionado][0]).setAttribute('class','territorio_seleccionado');
				cargarDatosTerritorio(territorio_seleccionado);
			}
		}
		
		function refreshTerritories(){
			//alert((new XMLSerializer()).serializeToString(xml));
			var t = xml.getElementsByTagName('territory');
			//alert(t.length);
			for(var i= 0; i<t.length; i++){
				var territorio = new Array();
				territorio[0] = t[i].getElementsByTagName('id')[0].firstChild.nodeValue;
				territorio[1] = datos_paises[territorio[0]][1];
				territorio[2] = datos_paises[territorio[0]][2];
				if(t[i].getElementsByTagName('owner')[0].firstChild != null){
					territorio[3] = t[i].getElementsByTagName('owner')[0].firstChild.nodeValue;
				}else{
					territorio[3] = "";
				}
				territorio[4] = t[i].getElementsByTagName('soldiers')[0].firstChild.nodeValue;
				var c = xml.getElementsByTagName('cannons');
				//alert(c.length);
				for(var j= 0; j<c.length; j++){
					territorio[5] = c[j].getElementsByTagName('cannon')[0].firstChild.nodeValue;
					territorio[6] = c[j].getElementsByTagName('cannon')[1].firstChild.nodeValue;
					territorio[7] = c[j].getElementsByTagName('cannon')[2].firstChild.nodeValue;
				}
				territorio[8] = t[i].getElementsByTagName('missiles')[0].firstChild.nodeValue;
				territorio[9] = t[i].getElementsByTagName('icbm')[0].firstChild.nodeValue;
				territorio[10] = t[i].getElementsByTagName('antimissiles')[0].firstChild.nodeValue;
				
				array_territorios[i] = territorio;
			}
			
		}
		
		function refreshUsers(){
			var p = xml.getElementsByTagName('player');
			//alert(p.length);
			for(var i= 0; i<p.length; i++){
				var usuario = new Array();
				usuario[0] = p[i].getElementsByTagName('name')[0].firstChild.nodeValue;
				usuario[1] = p[i].getElementsByTagName('money')[0].firstChild.nodeValue;
				usuario[2] = p[i].getElementsByTagName('state')[0].firstChild.nodeValue;
				array_usuarios[i] = usuario;
			}
		}

		function getInfoMap()
		{
			setTimeout("getInfoMap()",10000);

//			Creamos el control XMLHttpRequest segun el navegador en el que estemos 
 			if( window.XMLHttpRequest )
 				ajax = new XMLHttpRequest(); // No Internet Explorer
 			else
 				ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

//			Almacenamos en el control al funcion que se invocara cuando la peticion
//			cambie de estado	
 			ajax.onreadystatechange = functionCallback;

//			Enviamos la peticion
 			ajax.open( "GET", "/worldconq-web/refreshGame.action", true );
 			ajax.send( "" );
		}
		
		function buyTerritoryAjax()
		{
//			Creamos el control XMLHttpRequest segun el navegador en el que estemos 
 			if( window.XMLHttpRequest )
 				ajax = new XMLHttpRequest(); // No Internet Explorer
 			else
 				ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

//			Almacenamos en el control al funcion que se invocara cuando la peticion
//			cambie de estado	
 			ajax.onreadystatechange = callbackAjax;
//			Enviamos la peticion
 			ajax.open( "GET", "/worldconq-web/do_buyTerritory-"+territorio_seleccionado+".action", true );
 			ajax.send( "" );
		}
		
		function spyTerritoryAjax()
		{
//			Creamos el control XMLHttpRequest segun el navegador en el que estemos 
 			if( window.XMLHttpRequest )
 				ajax = new XMLHttpRequest(); // No Internet Explorer
 			else
 				ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

//			Almacenamos en el control al funcion que se invocara cuando la peticion
//			cambie de estado	
 			ajax.onreadystatechange = callbackAjax;
//			Enviamos la peticion
 			ajax.open( "GET", "/worldconq-web/do_deploySpy-"+territorio_seleccionado+".action", true );
 			ajax.send( "" );
		}
		
		function requestNegotiationAjax(accept)
		{
//			Creamos el control XMLHttpRequest segun el navegador en el que estemos 
 			if( window.XMLHttpRequest )
 				ajax = new XMLHttpRequest(); // No Internet Explorer
 			else
 				ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

//			Almacenamos en el control al funcion que se invocara cuando la peticion
//			cambie de estado	
 			ajax.onreadystatechange = callbackAjax;
//			Enviamos la peticion
			if(accept == 1){
				ajax.open( "GET", "/worldconq-web/do_requestNegotiation.action", true );
			}else{
				ajax.open( "GET", "/worldconq-web/do_requestAttack.action", true );	
			}
 			ajax.send( "" );
		}
		
		function cargarDatosTerritorio(territorio){
			//alert(xml);
			//alert(array_territorios);
			refreshTerritories();
			//alert(array_territorios);
			var info_territorio = new Array();
			for(var j in array_territorios){
				//alert(array_territorios[j][0] +" == "+ territorio);
				if(array_territorios[j][0] == territorio){
					info_territorio[0] = array_territorios[j][0];
					info_territorio[1] = array_territorios[j][1];
					if(array_territorios[j][2] != ""){
						info_territorio[2] = array_territorios[j][2];
						info_territorio[3] = array_territorios[j][3];//propietario
						info_territorio[4] = array_territorios[j][4];//soldados
						info_territorio[5] = array_territorios[j][5]+" - "+array_territorios[j][6]+" - "+array_territorios[j][7];//cañones
						info_territorio[6] = array_territorios[j][8];//misiles
						info_territorio[7] = array_territorios[j][10];//icbm
						info_territorio[8] = array_territorios[j][9];//antimisiles
					}else{
						info_territorio[2] = "";
						info_territorio[3] = "";
						info_territorio[4] = "";
						info_territorio[5] = "";
						info_territorio[6] = "";
						info_territorio[7] = "";
						info_territorio[8] = "";
					}
				}
			}
			
			texto="<table class='tablatres'>";
			texto = texto + "<tr><td class='campo' style='width:50%'>Territorio:</td><td class='campo_texto' style='width:50%'>"+info_territorio[1]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Precio:</td><td class='campo_texto'>"+info_territorio[2]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Propietario:</td><td class='campo_texto'>"+info_territorio[3]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Soldados:</td><td class='campo_texto'>"+info_territorio[4]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Cañones:</td><td class='campo_texto'>"+info_territorio[5]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Misiles:</td><td class='campo_texto'>"+info_territorio[6]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Antimisiles:</td><td class='campo_texto'>"+info_territorio[7]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>ICBM:</td><td class='campo_texto'>"+info_territorio[8]+"</td></tr>";
			texto = texto + "</table>";
			//alert(texto);
			document.getElementById('infotres').innerHTML = texto;
			
		}
		
		function buyTerritory(territorio){
			if(territorio != ""){
				valor = confirm("¿Esta seguro de que desea comprar "+datos_paises[territorio][1]+" por "+datos_paises[territorio][2]+" Gallifantes?");
				if(valor){
					buyTerritoryAjax();
				}
			}else{
				alert("Debe seleccianar un territorio");
			}
		}
		
		function sendSpy(territorio){
			if(territorio != ""){
				if(array_territorios[territorio][3] == "?" || array_territorios[territorio][3] == ""){
					spyTerritoryAjax();
				}else{
					alert("No se puede espiar este territorio.");
				}
			}else{
				alert("Debe seleccianar un territorio");
			}
		}
		
		//función a la que se le pasa una respuesta en xml y devuelve un alert.
		function comprobarRespuestas(respuesta){
			var r = respuesta.getElementsByTagName('status')[0].firstChild.nodeValue;
			//alert(r);
			if(r == "Success"){
				alert("Operación realizada con exito");
			}else if (r == "Input"){
				alert("Los datos introducidos no son correctos");
			}else{
				
				if(respuesta.getElementsByTagName('message')[0].firstChild == null){
					alert("Se ha producido un error, la operación ha sido cancelada");
				}else{
					var m = respuesta.getElementsByTagName('message')[0].firstChild.nodeValue;
					alert("Se ha producido un error:\n"+m);	
				}
			}
			
		}
	</script>
</head>

<body bgcolor="#000000">
	<s:include value="header.jsp"/>
	<div style="padding-bottom: 2px;"></div>
	<div id="menu">
		<table style="width: 100%">
			<tr>
				<td>
					<input onclick="buyTerritory(territorio_seleccionado)" type="image" disabled src="./image/botoncomprar_disabled.png" id="boton_comprar" style="width: 95px; height: 35px;">
				</td>
				<td>
					<input onclick="return GB_show('Atacar', '../attack.jsp?territorio='+territorio_seleccionado);" type="image" disabled src="./image/botonatacar_disabled.png" id="boton_atacar" style="width: 95px; height: 35px;">
				</td>
				<td>
					<input onclick="sendSpy(territorio_seleccionado)" type="image" disabled src="./image/botonespiar_disabled.png" id="boton_espiar" style="width: 95px; height: 35px;">
				</td>
				<td>
					<input onclick="return GB_show('Mover tropas', '../moveUnits.jsp?territorio='+territorio_seleccionado);" type="image" disabled src="./image/botonmover_disabled.png" id="boton_mover" style="width: 95px; height: 35px;">
				</td>
				<td>
					<input onclick="return GB_show('Comprar Tropas', '../buyUnits.jsp?territorio='+territorio_seleccionado);" type="image" disabled src="./image/botonrefuerzos_disabled.png" id="boton_refuerzos" style="width: 95px; height: 35px;">
				</td>
			</tr>
		</table>
	</div>
	<input id=self_user type="hidden" value="<s:property value='#session.user' />"/>
	<table border="0" width="100%" cellspacing="0" cellpadding="0" height="680">
		<tr>
			<td width="42" height="680" background="image/liito.png">&nbsp;</td>
			<td background="image/repe.png">
			<div align="center">
				<table border="0" width="100%" cellspacing="0" cellpadding="0" height="680">
				<tr>
					<td align="center" width="800" height="100">
						<s:a action="index">		  	
							<img border="0" src="image/titulo.png" width="500" height="100">
						</s:a>
					</td>		
					<td align="center">&nbsp;</td>
					<td align="center" width="260" height="680" rowspan="2">
					<div align="center">
						<table border="0" width="260" cellspacing="5" cellpadding="0" height="680" background="image/info.png">
							<tr>
								<td align="center" width="250" height="70"></td>
							</tr>
							<tr>
								<td align="center" bordercolor="#422100" bordercolorlight="#422100" bordercolordark="#000000" valign="bottom" background="image/cinchouno.png" width="250" height="95">
								<div id="infouno" style="overflow:auto; height:90px; width:190px;" valign="bottom"></div>
								</td>
							</tr>
							<tr>
								<td align="center" width="250" height="245" background="image/cinchodos.png" valign="center">
								<div id="infodos" style="overflow:auto; height:195px; width:170px;">
                                
								</div>
								</td>
							</tr>
							<tr>
								<td align="center" valign="top" background="image/cinchotres.png" width="250" height="245">
                                <div id="infotres" style="overflow:auto; height:195px; width:190px; padding-top: 5px">
								
								</div>
								</td>
							</tr>
						</table>
					</div>
					</td>
				</tr>
				<tr>
					<td align="center" width="800" height="580">			  	
                    <div id="mapa">
                    	<div class="infoArea" title="Información sobre los eventos" id="infoArea">
							<textarea name="infoArea" cols="100" rows="2" readonly tabindex="3" style="font-family: Verdana; font-size: 8pt; color: #191919; font-weight: bold; border: 1px solid #422100; padding: 0; background-color:#9E7D45"></textarea>
						</div>							
                	<!--America del sur-->			
                        <div class="territorio" title="brasil" id="brasil" onClick="seleccionarTerritorio(35)"></div>
                        <div class="territorio" title="argentina" id="argentina" onClick="seleccionarTerritorio(34)"></div>
                        <div class="territorio" title="venezuela" id="venezuela" onClick="seleccionarTerritorio(37)"></div>
                        <div class="territorio" title="peru" id="peru" onClick="seleccionarTerritorio(36)"></div>
                        
                        <!-- Africa -->
                        <div class="territorio" title="congo" id="congo" onClick="seleccionarTerritorio(19)"></div>
                        <div class="territorio" title="africa_oriental" id="africa_oriental" onClick="seleccionarTerritorio(20)"></div>
                        <div class="territorio" title="sudafrica" id="sudafrica" onClick="seleccionarTerritorio(24)"></div>
                        <div class="territorio" title="africa_norte" id="africa_norte" onClick="seleccionarTerritorio(23)"></div>
                        <div class="territorio" title="egipto" id="egipto" onClick="seleccionarTerritorio(21)"></div>
                        <div class="territorio" title="madagascar" id="madagascar" onClick="seleccionarTerritorio(22)"></div>
                        
                        <!-- Oceania -->
                        <div class="territorio" title="australia_oriental" id="australia_oriental" onClick="seleccionarTerritorio(38)"></div>
                        <div class="territorio" title="indonesia" id="indonesia" onClick="seleccionarTerritorio(39)"></div>
                        <div class="territorio" title="nueva_guinea" id="nueva_guinea" onClick="seleccionarTerritorio(40)"></div>
                        <div class="territorio" title="australia_occidental" id="australia_occidental" onClick="seleccionarTerritorio(41)"></div>
                        
                         <!-- Asia -->
                         <div class="territorio" title="afghanistan" id="afghanistan" onClick="seleccionarTerritorio(7)"></div>
                         <div class="territorio" title="china" id="china" onClick="seleccionarTerritorio(8)"></div>
                         <div class="territorio" title="india" id="india" onClick="seleccionarTerritorio(9)"></div>
                         <div class="territorio" title="irkutsk" id="irkutsk" onClick="seleccionarTerritorio(10)"></div>
                         <div class="territorio" title="japon" id="japon" onClick="seleccionarTerritorio(11)"></div>
                         <div class="territorio" title="kamchatka" id="kamchatka" onClick="seleccionarTerritorio(12)"></div>
                         <div class="territorio" title="oriente_medio" id="oriente_medio" onClick="seleccionarTerritorio(13)"></div>
                         <div class="territorio" title="mongolia" id="mongolia" onClick="seleccionarTerritorio(14)"></div>
                         <div class="territorio" title="siam" id="siam" onClick="seleccionarTerritorio(15)"></div>
                         <div class="territorio" title="siberia" id="siberia" onClick="seleccionarTerritorio(16)"></div>
                         <div class="territorio" title="ural" id="ural" onClick="seleccionarTerritorio(17)"></div>
                         <div class="territorio" title="yakutsk" id="yakutsk" onClick="seleccionarTerritorio(18)"></div>
                        
                        <!-- Europa -->
                        <div class="territorio" title="gran_bretana" id="gran_bretana" onClick="seleccionarTerritorio(0)"></div>
                        <div class="territorio" title="iceland" id="iceland" onClick="seleccionarTerritorio(1)"></div>
                        <div class="territorio" title="europa_norte" id="europa_norte" onClick="seleccionarTerritorio(2)"></div>
                        <div class="territorio" title="escandinavia" id="escandinavia" onClick="seleccionarTerritorio(3)"></div>
                        <div class="territorio" title="europa_sur" id="europa_sur" onClick="seleccionarTerritorio(4)"></div>
                        <div class="territorio" title="ucrania" id="ucrania" onClick="seleccionarTerritorio(5)"></div>
                        <div class="territorio" title="europa_occidental" id="europa_occidental" onClick="seleccionarTerritorio(6)"></div>
                        
                        <!-- america del norte -->
                        <div class="territorio" title="alaska" id="alaska" onClick="seleccionarTerritorio(25)"></div>
                        <div class="territorio" title="alberta" id="alberta" onClick="seleccionarTerritorio(26)"></div>
                        <div class="territorio" title="america_central" id="america_central" onClick="seleccionarTerritorio(27)"></div>
                        <div class="territorio" title="estados_unidos_este" id="estados_unidos_este" onClick="seleccionarTerritorio(28)"></div>
                        <div class="territorio" title="groenlandia" id="groenlandia"  onClick="seleccionarTerritorio(29)" ></div>
                        <div class="territorio" title="territerios_noroeste" id="territerios_noroeste" onClick="seleccionarTerritorio(30)" ></div>
                        <div class="territorio" title="ontario" id="ontario"  onClick="seleccionarTerritorio(31)" ></div>
                        <div class="territorio" title="quebec" id="quebec" onClick="seleccionarTerritorio(32)"></div>
                       	<div class="territorio" title="estados_unidos_oeste" id="estados_unidos_oeste" onClick="seleccionarTerritorio(33)"></div>
					</div>
                    </td>
					<td align="center"></td>
				</tr>		
			</table>
			</div>			
			</td>
			<td background="image/ldito.png" width="42" height="680">&nbsp;</td>
		</tr>
	</table>
	<s:hidden name="index" value="" />
<script>
getInfoMap();
</script>
</body>

</html>