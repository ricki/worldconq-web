<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">
<title>WorldConq - Attack</title>
<script type="text/javascript" src="info_territories.js"></script>
<script type="text/javascript">
//script para recoger en variables de javascript lo que hayamos pasado por get en la url.

var Url = location.href;
Url = Url.replace(/.*\?(.*?)/,"$1");
Variables = Url.split ("&");
for (i = 0; i < Variables.length; i++) {
       Separ = Variables[i].split("=");
       eval ('var '+Separ[0]+'="'+Separ[1]+'"');
}

</script>
</head>
<body bgcolor="#000000" background="image/mapafondo.jpg" style="background-attachment: fixed; background-position: top center; background-repeat: no-repeat;">
	<s:form action="do_attack">
	<table align="center" style="padding-top: 30px">
		<tr><td><s:property value="availableTargets" /></td></tr>
		<tr style="text-align: center;">
			<td>
				<select id="territory_attack" onchange="changeTerritory()"></select>
			</td>
		</tr>
		<tr>
			<s:actionmessage />
			<s:actionerror />
		</tr>
		<tr>
			<td>
				<table>
				<tr>
					<td colspan=4>
						¿Con cuantas unidades desea atacar?
					</td>
				</tr>
					<tr>
						<td>
							Soldados:
						</td>
						<td>
							<s:textfield name="soldiers" id="soldiers" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="-" onclick="del('soldiers')">
						</td>
						<td>
							<input type="button" value="+" onclick="add('soldiers')">
						</td>
					</tr>
					<tr>
						<td>
							Cañones:
						</td>
						<td>
							<s:textfield name="cannons" id="cannons" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="-" onclick="del('cannons')">
						</td>
						<td>
							<input type="button" value="+" onclick="add('cannons')">
						</td>
					</tr>
					<tr>
						<td>
							Misiles: 
						</td>
						<td>
							<s:textfield name="missiles" id="missiles" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="-" onclick="del('missiles')">
						</td>
						<td>
							<input type="button" value="+" onclick="add('missiles')">
						</td>
					</tr>
					<tr>
						<td>
							ICBM:
						</td>
						<td>
							<s:textfield name="icbm" id="icbm" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="-" onclick="del('icbm')">
						</td>
						<td>
							<input type="button" value="+" onclick="add('icbm')">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<s:submit value="Atacar" theme="simple"/>
			</td>
		</tr>
	</table>
	<s:hidden name="index" value="%{index}" />
	<s:hidden name="target" value="" />
	</s:form>

<script type="text/javascript">

var territorio = <s:property value="index" />;

cargarAdyacentes();

function cargarAdyacentes(){
	
	array = new Array();
	<s:iterator value="availableTargets" status="itStatus">
		alert(<s:property/>);
		array["%{itStatus.index}"] = <s:property/>;
	</s:iterator>
	
	option = "<option value ='--def--''>Seleccione un territorio</option>";
	for(var id in array){
		option = option + "<option value ="+array[id]+">"+datos_paises[array[id]][1]+"</option>";
	}
	
	document.getElementById('territory_attack').innerHTML = option;
	
	
}

function add(field){
	availableSoldiers = <s:property value="availableSoldiers" />;
	availableCannons = <s:property value="availableCannons" />;
	availableMissiles = <s:property value="availableMissiles" />;
	availableIcbm = <s:property value="availableICBM" />;
	
	ini = document.getElementById(field).value;
	parametro="";
	if(field == "soldiers") parametro = availableSoldiers;
	if(field == "cannons") parametro = availableCannons;
	if(field == "missiles") parametro = availableMissiles;
	if(field == "icbm") parametro = availableIcbm;
	
	if(ini < parametro){
		document.getElementById(field).value = ++ini;
	}
	
}

function del(field){
	ini = document.getElementById(field).value;
	if(ini > 0){
		document.getElementById(field).value = --ini;
	}
}

function changeTerritory(){
	index = document.getElementById('territory_attack').selectedIndex;
	document.getElementsByName('target').value = document.getElementById('territory_attack').options[index].value;
}
</script>

</body>
</html>