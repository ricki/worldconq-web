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
<body bgcolor="#000000" background="image/mapafondobig.jpg" style="background-attachment: fixed; background-position: top center; background-repeat: no-repeat;">

	<s:actionmessage />
	<s:actionerror />
	<div align=center style="paddingTop: 30px;">
	<p> </p>
	<s:div id="content">
		<s:form name="underAttackAttack" action="do_replyAttack">
			<s:div id="attack">
			<br>Te está atacando 
			<s:text name="%{ currentAttack.origin.owner}"></s:text>
			desde el territorio 
			<s:text name="%{ currentAttack.origin.name}"></s:text>
			al territorio
			<s:text name="%{ currentAttack.destination.name}"></s:text>

				<HR size=5 width=40% align="center">

				<table>
					<tr>
						<td>Tropas atacantes</td>
					</tr>

					<tr>
						<td>Soldados</td>
						<td><s:text name="%{ currentAttack.arsenal.soldiers}"></s:text>
						</td>
					</tr>

					<tr>
						<td>Cañones</td>
						<td><s:text name="%{ currentAttack.arsenal.cannons}"></s:text>
						</td>
					</tr>

					<tr>
						<td>Misiles</td>
						<td><s:text name="%{ currentAttack.arsenal.missiles}"></s:text>
						</td>
					</tr>

					<tr>
						<td>ICBMs</td>
						<td><s:text name="%{ currentAttack.arsenal.ICBMs}"></s:text>
						</td>
					</tr>

					<tr>
						<td><input type="submit" value="Aceptar Ataque" />
						</td>
					</tr>

				</table>
			</s:div>
		</s:form>

		<s:form name="underAttackNegotiation" action="do_requestNegotiation">
			<s:div id="negotiation">
				<HR size=5 width=40% align="center">

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
						<td><input type="button" value="+" id="addSoldiers"
							onclick="add('soldiers')" />
						</td>
						<td><input type="button" value="-" id="lessSoldiers"
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
	</div>
</body>
</html>