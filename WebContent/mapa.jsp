<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Language" content="es">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>___ La Conquista del Mundo ___</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
   <script>
	   	var seleccionado = 0;
   		var territorio_seleccionado = "";
		var datos = new Array();	
		/*eliminar despues, cuando funcione el ajax*/
		var xml2='<?xml version="1.0" encoding="UTF-8"?><INFO><USERINFO><NAME>Toni</NAME><MONEY>1561</MONEY></USERINFO><PLAYERS><USER><NAME>Toni</NAME><STATE>1</STATE></USER><USER><NAME>Angel</NAME><STATE>0</STATE></USER><USER><NAME>Jorge</NAME><STATE>2</STATE></USER><USER><NAME>Laura</NAME><STATE>1</STATE></USER></PLAYERS><TERRITORIES><country><NAME>venezuela</NAME><PRICE>1500</PRICE><OWNER>Angel</OWNER><SOLDIERS>12</SOLDIERS><CANNONS>0</CANNONS><MISSILES>2</MISSILES><ANTIMISSILES>1</ANTIMISSILES><ICBMS>0</ICBMS></country><country><NAME>brasil</NAME><PRICE>1200</PRICE><OWNER>Toni</OWNER><SOLDIERS>10</SOLDIERS><CANNONS>1</CANNONS><MISSILES>1</MISSILES><ANTIMISSILES>1</ANTIMISSILES><ICBMS>1</ICBMS></country><country><NAME>china</NAME><PRICE>900</PRICE><OWNER></OWNER><SOLDIERS>0</SOLDIERS><CANNONS>0</CANNONS><MISSILES>0</MISSILES><ANTIMISSILES>0</ANTIMISSILES><ICBMS>0</ICBMS></country></TERRITORIES></INFO>';

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
		/*eliminar hasta aqui*/
		
		var ajax;
		var array_territorios = new Array();
		var array_usuarios = new Array();
		
		datos[0]=[0,'uno mismo'];
		datos[1]=[1,'conectado'];
		datos[2]=[2,'desconectado'];
		datos[3]=[3,'con turno'];
		
		var general = new Array();
		general[0]=['Usuario:','user'];
		general[1]=['Gallifantes:','99999999'];
		
		var info_territorio = new Array();
		info_territorio[0]=['Territorio:','España'];
		info_territorio[1]=['Precio','1233'];		
		info_territorio[2]=['Soldados','23'];
		info_territorio[3]=['Cañones','2'];				
		function seleccionarTerritorio(territorio){
			if(seleccionado == 0){
				document.getElementById(territorio).setAttribute('class','territorio_seleccionado');
				territorio_seleccionado = territorio;
				seleccionado = 1;
				
				cargarDatosTerritorio(territorio);
				 
			}else if (seleccionado == 1 && territorio_seleccionado != territorio){
				alert(territorio_seleccionado +" Atacar "+ territorio);
				seleccionado = 0;
				document.getElementById(territorio_seleccionado).className=territorio_seleccionado; 
			}else{
				seleccionado = 0;
				document.getElementById(territorio_seleccionado).setAttribute('class','territorio');
			}
				
		}
		
		function inicializarTablaUsuarios(array_datos){
			
			texto = "<table class='tablados'><tr><th>Estado</th><th>Usuario</th></tr>";
			for(var id in array_datos){
				var imagen="";
				if(array_datos[id][0]==0){//uno mismo
					imagen = "<img title = 'Tu' src='image/mipuntero.png'></img>";
				}else if(array_datos[id][0]==1){//conectado
					imagen = "<img title = 'Conectado' src='image/punterosmall.png'></img>";
				}else if(array_datos[id][0]==2){//desconectado
					imagen = "<img title = 'Desconectado' src='image/punteroenemigo.png'></img>";
				}else if(array_datos[id][0]==3){//turno
					imagen = "<img title = 'Turno' src='image/seleccionado.png'></img>";
				}
				texto = texto + "<tr><td>"+imagen+"</td><td>"+array_datos[id][1]+"</td></tr>"
			}
			texto = texto +"</table>";
			document.getElementById('infodos').innerHTML = texto;
		}
		
		function inicializarInfoGeneral(info_general){
			texto="<table class='tablauno'>";
			for(var id in info_general){
					texto = texto + "<tr><td class='campo'>"+info_general[id][0]+"</td><td class='campo_texto'>"+info_general[id][1]+"</td></tr>";
			}
			texto = texto + "</table>";
			
			document.getElementById('infouno').innerHTML = texto;
		}
		
		function inicializarInfoTerritorio(info_territorio){
			texto="<table class='tablatres'>";
			for(var id in info_territorio){
					texto = texto + "<tr><td class='campo'>"+info_territorio[id][0]+"</td><td class='campo_texto'>"+info_territorio[id][1]+"</td></tr>";
			}
			texto = texto + "</table>";
			
			document.getElementById('infotres').innerHTML = texto;
		}

		function funcionCallback()
		{
			// Comprobamos si la peticion se ha completado (estado 4)
			if( ajax.readyState == 4 )
			{
				// Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
				if( ajax.status == 200 )
				{
					// Escribimos el resultado en la pagina HTML mediante DHTML
					//xml = ajax.responseXML;
					
					refreshTerritories();
					refreshUsers();
					inicializarTablaUsuarios();
					
				}
			}
		}
		
		function refreshTerritories(){
			//alert((new XMLSerializer()).serializeToString(xml));
			var t = xml.getElementsByTagName('country');
			alert(t.length);
			for(var i= 0; i<t.length; i++){
				var territorio = new Array();
				territorio[0] = t[i].getElementsByTagName('id')[0].firstChild.nodeValue;
				territorio[1] = array_info_territorios[territorio[0]][1];
				if(t[i].getElementsByTagName('owner')[0].firstChild != null){
					territorio[2] = t[i].getElementsByTagName('owner')[0].firstChild.nodeValue;
				}else{
					territorio[2] = "";
				}
				territorio[0] = t[i].getElementsByTagName('soldiers')[0].firstChild.nodeValue;
				territorio[0] = t[i].getElementsByTagName('')[0].firstChild.nodeValue;
				array_territorios[i] = territorio;
			}
			
		}
		
		function refreshUsers(){
			for(var i in xml.getElementsByTagName("USER")){
				var usuarios = new Array();
				usuarios[i][0] = xml.getElementsByTagName("USER")[i][0];
				usuarios[i][1] = xml.getElementsByTagName("USER")[i][1];
				usuarios[i][2] = xml.getElementsByTagName("USER")[i][2];
				array_usuarios[i] = usuarios[i];
			}
		}

		function getInfoMap()
		{
			// Creamos el control XMLHttpRequest segun el navegador en el que estemos 
			if( window.XMLHttpRequest )
				ajax = new XMLHttpRequest(); // No Internet Explorer
			else
				ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer

			// Almacenamos en el control al funcion que se invocara cuando la peticion
			// cambie de estado	
			ajax.onreadystatechange = functionCallback;

			// Enviamos la peticion
			ajax.open( "GET", "/worldconq-web/refreshGame.action", true );
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
						info_territorio[3] = "";
						info_territorio[4] = "";
						info_territorio[5] = "";
						info_territorio[6] = "";
						info_territorio[7] = "";
						info_territorio[8] = "";
						info_territorio[9] = "";
					}else{
						info_territorio[2] = "";
						info_territorio[3] = "";
						info_territorio[4] = "";
						info_territorio[5] = "";
						info_territorio[6] = "";
						info_territorio[7] = "";
						info_territorio[8] = "";
						info_territorio[9] = "";
					}
				}
			}
			
			texto="<table class='tablatres'>";
			texto = texto + "<tr><td class='campo'>Territorio:</td><td class='campo_texto'>"+info_territorio[0]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Precio:</td><td class='campo_texto'>"+info_territorio[1]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Propietario:</td><td class='campo_texto'>"+info_territorio[2]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Soldados:</td><td class='campo_texto'>"+info_territorio[3]+"</td></tr>";
			texto = texto + "<tr><td class='campo'>Cañones:</td><td class='campo_texto'>"+info_territorio[4]+"</td></tr>";
			texto = texto + "</table>";
			//alert(texto);
			document.getElementById('infotres').innerHTML = texto;
		}
	</script>
</head>

<body bgcolor="#000000">

	<s:include value="header.jsp"/>

	<table border="0" width="100%" cellspacing="0" cellpadding="0" height="680">
		<tr>
			<td width="42" height="680" background="image/liito.png">&nbsp;</td>
			<td background="image/repe.png">
			<div align="center">
				<table border="0" width="100%" cellspacing="0" cellpadding="0" height="680">
				<tr>
					<td align="center" width="800" height="100">			  	
						<img border="0" src="image/titulo.png" width="500" height="100"></td>
					<td align="center">&nbsp;</td>
					<td align="center" width="260" height="680" rowspan="2">
					<div align="center">
						<table border="0" width="260" cellspacing="5" cellpadding="0" height="680" background="image/info.png">
							<tr>
								<td align="center" width="250" height="70"></td>
							</tr>
							<tr>
								<td align="center" bordercolor="#422100" bordercolorlight="#422100" bordercolordark="#000000" valign="bottom" background="image/cinchouno.png" width="250" height="135">
								<div id="infouno" style="overflow:auto; height:105px; width:190px;" valign="bottom"></div>
								</td>
							</tr>
							<tr>
								<td align="center" width="250" height="225" background="image/cinchodos.png" valign="center">
								<div id="infodos" style="overflow:auto; height:195px; width:170px;">
                                
								</div>
								</td>
							</tr>
							<tr>
								<td align="center" valign="bottom" background="image/cinhotres.png" width="250" height="225">
                                <div id="infotres" style="overflow:auto; height:195px; width:190px;">
								
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
                	<!--America del sur-->			
                        <div class="territorio" title="brasil" id="brasil" onClick="seleccionarTerritorio('brasil')"></div>
                        <div class="territorio" title="argentina" id="argentina" onClick="seleccionarTerritorio('argentina')"></div>
                        <div class="territorio" title="venezuela" id="venezuela" onClick="seleccionarTerritorio('venezuela')"></div>
                        <div class="territorio" title="peru" id="peru" onClick="seleccionarTerritorio('peru')"></div>
                        
                        <!-- Africa -->
                        <div class="territorio" title="congo" id="congo" onClick="seleccionarTerritorio('congo')"></div>
                        <div class="territorio" title="africa_oriental" id="africa_oriental" onClick="seleccionarTerritorio('africa_oriental')"></div>
                        <div class="territorio" title="sudafrica" id="sudafrica" onClick="seleccionarTerritorio('sudafrica')"></div>
                        <div class="territorio" title="africa_norte" id="africa_norte" onClick="seleccionarTerritorio('africa_norte')"></div>
                        <div class="territorio" title="egipto" id="egipto" onClick="seleccionarTerritorio('egipto')"></div>
                        <div class="territorio" title="madagascar" id="madagascar" onClick="seleccionarTerritorio('madagascar')"></div>
                        
                        <!-- Oceania -->
                        <div class="territorio" title="australia_oriental" id="australia_oriental" onClick="seleccionarTerritorio('australia_oriental')"></div>
                        <div class="territorio" title="indonesia" id="indonesia" onClick="seleccionarTerritorio('indonesia')"></div>
                        <div class="territorio" title="nueva_guinea" id="nueva_guinea" onClick="seleccionarTerritorio('nueva_guinea')"></div>
                        <div class="territorio" title="australia_occidental" id="australia_occidental" onClick="seleccionarTerritorio('australia_occidental')"></div>
                        
                         <!-- Asia -->
                         <div class="territorio" title="afghanistan" id="afghanistan" onClick="seleccionarTerritorio('afghanistan')"></div>
                         <div class="territorio" title="china" id="china" onClick="seleccionarTerritorio('china')"></div>
                         <div class="territorio" title="india" id="india" onClick="seleccionarTerritorio('india')"></div>
                         <div class="territorio" title="irkutsk" id="irkutsk" onClick="seleccionarTerritorio('irkutsk')"></div>
                         <div class="territorio" title="japon" id="japon" onClick="seleccionarTerritorio('japon')"></div>
                         <div class="territorio" title="kamchatka" id="kamchatka" onClick="seleccionarTerritorio('kamchatka')"></div>
                         <div class="territorio" title="oriente_medio" id="oriente_medio" onClick="seleccionarTerritorio('oriente_medio')"></div>
                         <div class="territorio" title="mongolia" id="mongolia" onClick="seleccionarTerritorio('mongolia')"></div>
                         <div class="territorio" title="siam" id="siam" onClick="seleccionarTerritorio('siam')"></div>
                         <div class="territorio" title="siberia" id="siberia" onClick="seleccionarTerritorio('siberia')"></div>
                         <div class="territorio" title="ural" id="ural" onClick="seleccionarTerritorio('ural')"></div>
                         <div class="territorio" title="yakutsk" id="yakutsk" onClick="seleccionarTerritorio('yakutsk')"></div>
                        
                        <!-- Europa -->
                        <div class="territorio" title="gran_bretana" id="gran_bretana" onClick="seleccionarTerritorio('gran_bretaña')"></div>
                        <div class="territorio" title="iceland" id="iceland" onClick="seleccionarTerritorio('iceland')"></div>
                        <div class="territorio" title="europa_norte" id="europa_norte" onClick="seleccionarTerritorio('europa_norte')"></div>
                        <div class="territorio" title="escandinavia" id="escandinavia" onClick="seleccionarTerritorio('escandinavia')"></div>
                        <div class="territorio" title="europa_sur" id="europa_sur" onClick="seleccionarTerritorio('europa_sur')"></div>
                        <div class="territorio" title="ucrania" id="ucrania" onClick="seleccionarTerritorio('ucrania')"></div>
                        <div class="territorio" title="europa_occidental" id="europa_occidental" onClick="seleccionarTerritorio('europa_occidental')"></div>
                        
                        <!-- america del norte -->
                        <div class="territorio" title="alaska" id="alaska" onClick="seleccionarTerritorio('alaska')"></div>
                        <div class="territorio" title="alberta" id="alberta" onClick="seleccionarTerritorio('alberta')"></div>
                        <div class="territorio" title="america_central" id="america_central" onClick="seleccionarTerritorio('america_central')"></div>
                        <div class="territorio" title="estados_unidos_este" id="estados_unidos_este" onClick="seleccionarTerritorio('estados_unidos_este')"></div>
                        <div class="territorio" title="groenlandia" id="groenlandia"  onClick="seleccionarTerritorio('groenlandia')" ></div>
                        <div class="territorio" title="territerios_noroeste" id="territerios_noroeste" onClick="seleccionarTerritorio('territerios_noroeste')" ></div>
                        <div class="territorio" title="ontario" id="ontario"  onClick="seleccionarTerritorio('ontario')" ></div>
                        <div class="territorio" title="quebec" id="quebec" onClick="seleccionarTerritorio('quebec')"></div>
                       	<div class="territorio" title="estados_unidos_oeste" id="estados_unidos_oeste" onClick="seleccionarTerritorio('estados_unidos_oeste')"></div>
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
<script>
inicializarTablaUsuarios(datos);
inicializarInfoGeneral(general);
inicializarInfoTerritorio(info_territorio);
</script>
</body>

</html>