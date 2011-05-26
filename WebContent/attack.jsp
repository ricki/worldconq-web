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
</head>
<body>
	<s:form action="do_register">
	<table>
		<tr style="text-align: center;">
			<td>
				<select id="territory_attack"></select>
			</td>
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
							<input type="button" value="+" onclick="add('soldiers')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('soldiers')">
						</td>
					</tr>
					<tr>
						<td>
							Cañones 1:
						</td>
						<td>
							<s:textfield name="cannons1" id="cannons1" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="+" onclick="add('cannons1')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('cannons1')">
						</td>
					</tr>
					<tr>
						<td>
							Cañones 2:
						</td>
						<td>
							<s:textfield name="cannons2" id="cannons2" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="+" onclick="add('cannons2')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('cannons2')">
						</td>
					</tr>
					<tr>
						<td>
							Cañones 3:
						</td>
						<td>
							<s:textfield name="cannons3" id="cannons3" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="+" onclick="add('cannons3')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('cannons3')">
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
							<input type="button" value="+" onclick="add('missiles')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('missiles')">
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
							<input type="button" value="+" onclick="add('icbm')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('icbm')">
						</td>
					</tr>
					<tr>
						<td>
							Anti Misiles: 
						</td>
						<td>
							<s:textfield name="antimissiles" id="antimissiles" value="0" theme="simple"/>
						</td>
						<td>
							<input type="button" value="+" onclick="add('antimissiles')">
						</td>
						<td>
							<input type="button" value="-" onclick="del('antimissiles')">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</s:form>

<script type="text/javascript">

cargarAdyacentes();

function cargarAdyacentes(){
	//territorio = request.getParameter("territorio");
	territorio = 1;
	
	territorios_adyacentes = adyacentes[territorio];
	
	option = "";
	for(var id in territorios_adyacentes){
		option = option + "<option value ="+territorios_adyacentes[id]+">"+datos_paises[territorios_adyacentes[id]][1]+"</option>";
	}
	
	document.getElementById('territory_attack').innerHTML = option;
	
	
}

function add(field){
	ini = document.getElementById(field).value;
	document.getElementById(field).value = ++ini;
}

function del(field){
	ini = document.getElementById(field).value;
	if(ini > 0){
		document.getElementById(field).value = --ini;
	}
}

</script>

</body>
</html>