<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">

<title>WorldConq - Esta siendo atacado</title>

<script>
	function add(field) {
		ini = document.getElementById(field).value;
		document.getElementById(field).value = ++ini;
	}

	function del(field) {
		ini = document.getElementById(field).value;
		if (ini > 0) {
			document.getElementById(field).value = --ini;
		}
	}
</script>

</head>
<body>
	<s:include value="header.jsp" />
	<s:div id="content">
		<s:form name="underAttack">
			<s:div id="nombre">
			Te está atacando 
			<s:text name="currentAttack.getOrigin().getOwner()"></s:text>
			desde el territorio 
			<s:text name="currentAttack.getOrigin().getName()"></s:text>
			al territorio
			<s:text name="currentAttack.getDestination().getName()"></s:text>

				<HR size=5 width=40% align="left"> 

				<table>
					<tr>
						<td>Tropas atacantes</td>
					</tr>

					<tr>
						<td>Soldados</td>
						<td><s:text name="currentAttack.getArsenal().soldiers"></s:text>
						</td>
					</tr>

					<tr>
						<td>Cañones</td>
						<td><s:text name="currentAttack.getArsenal().cannons"></s:text>
						</td>
					</tr>

					<tr>
						<td>Misiles</td>
						<td><s:text name="currentAttack.getArsenal().missiles"></s:text>
						</td>
					</tr>

					<tr>
						<td>ICBMs</td>
						<td><s:text name="currentAttack.getArsenal().ICBMs"></s:text>
						</td>
					</tr>

					<tr>
						<td><input type="submit" value="Aceptar Ataque" />
						</td>
						<td><input type="submit" value="Rechazar Ataque" />
						</td>
					</tr>

				</table>

				<HR size=5 width=40% align="left"> 

				<table>

					<tr>
						<td>Iniciar Negociación</td>
					</tr>

					<tr>
						<td>Cantidad de Dinero</td>
						<td><s:textfield name="money" readonly="true" id="money"
								value="0" theme="simple" />
						</td>
						<td><input type="button" value="+" id="addMoney"
							onclick="add('money')" />
						</td>
						<td><input type="button" value="-" id="lessMoney"
							onclick="del('money')" />
						</td>
					</tr>

					<tr>
						<td>Número de Soldados</td>
						<td><s:textfield name="soldiers" readonly="true"
								id="soldiers" value="0" theme="simple" />
						</td>
						<td><input type="button" value="+" id="addSoliers"
							onclick="add('soldiers')" />
						</td>
						<td><input type="button" value="-" id="lessSoliers"
							onclick="del('soldiers')" />
						</td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="Negociar" /></td>
					</tr>

				</table>

			</s:div>
		</s:form>
	</s:div>



</body>
</html>