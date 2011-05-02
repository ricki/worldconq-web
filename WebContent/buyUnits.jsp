<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">

<title>WorldConq - BuyUnits</title>

<script>
	function getPrice(field) {
		if (field == "soldiers")
			return 100;
		if (field == "cannons")
			return 300;
		if (field == "missiles")
			return 500;
		if (field == "icbms")
			return 400;
		if (field == "antimissiles")
			return 600;
	}

	function add(field) {
		ini = document.getElementById(field).value;
		document.getElementById(field).value = ++ini;
		coste = parseInt(document.getElementById('coste').value);
		document.getElementById('coste').value = coste
				+ parseInt(getPrice(field));
	}

	function del(field) {
		ini = document.getElementById(field).value;
		if (ini > 0) {
			document.getElementById(field).value = --ini;
			coste = parseInt(document.getElementById('coste').value);
			document.getElementById('coste').value = coste
					- parseInt(getPrice(field));
		}
	}
</script>

</head>
<body bgcolor="#000000" background="image/mapafondo.jpg" style="background-attachment: fixed; background-position: top center; background-repeat: no-repeat;">
<div align=center >
	<s:div id="content">
		<s:form name="buyUnit" action="do_buyUnits">
			<s:div id="nombre">
				<table>
					<tr>
						<td>Dinero Disponible</td>
						<td><s:text name="money"></s:text></td>
					</tr>

					<tr>
						<td>Coste</td>
						<td><s:textfield name="coste" readonly="true" id="coste"
								value="0" theme="simple" />
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
						<td>Número de Cañones</td>
						<td><s:textfield name="cannons" readonly="true" id="cannons"
								value="0" theme="simple" />
						</td>
						<td><input type="button" value="+" id="addCannons"
							onclick="add('cannons')" />
						</td>
						<td><input type="button" value="-" id="lessCannons"
							onclick="del('cannons')" />
						</td>
					</tr>

					<tr>
						<td>Número de Misiles</td>
						<td><s:textfield name="missiles" readonly="true"
								id="missiles" value="0" theme="simple" />
						</td>
						<td><input type="button" value="+" id="addMissiles"
							onclick="add('missiles')" />
						</td>
						<td><input type="button" value="-" id="lessMissiles"
							onclick="del('missiles')" />
						</td>
					</tr>

					<tr>
						<td>Número de ICBMs</td>
						<td><s:textfield name="icbms" readonly="true" id="icbms"
								value="0" theme="simple" />
						</td>
						<td><input type="button" value="+" id="addICMBs"
							onclick="add('icbms')" />
						</td>
						<td><input type="button" value="-" id="lessICMBs"
							onclick="del('icbms')" />
						</td>
					</tr>

					<tr>
						<td>Número de Antimisiles</td>
						<td><s:textfield name="antimissiles" readonly="true"
								id="antimissiles" value="0" theme="simple" />
						</td>
						<td><input type="button" value="+" id="addAntimissiles"
							onclick="add('antimissiles')" />
						</td>
						<td><input type="button" value="-" id="lessAntimissiles"
							onclick="del('antimissiles')" />
						</td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="Comprar Unidades" />
						</td>
					</tr>
				</table>

				<s:hidden name="index" value="%{index}" />
			</s:div>
		</s:form>
	</s:div>
</div>
</body>
</html>
