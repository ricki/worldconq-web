<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">
<link rel="stylesheet" href="css/lists.css" type="text/css">
<title>List Games</title>
</head>
<body>
	<table>
		<tr>
			<s:include value="header.jsp"></s:include>
		</tr>

		<tr>
			<s:actionmessage />
			<s:actionerror />
		</tr>

		<tr>
			<div id="content">
				<h1>Partidas Disponibles</h1>
				<table width="100%" border="1">
					<tr>
						<th>Nombre de partida</th>
						<th>Descripción</th>
						<th>N. Jugadores</th>
						<th>T. Libres</th>
					</tr>
					<s:iterator value="currentGames" status="itStatus">
						<tr>
							<td><a
								href="playGame-<s:property value="#itStatus.index"/>.action"><s:text
										name="name"></s:text> </a></td>
							<td><s:text name="description"></s:text></td>
							<td><s:text name="players.size()"></s:text></td>
							<td><s:text name="getnFreeTerritories()"></s:text></td>
						</tr>
					</s:iterator>
				</table>

				<h1>Partidas Libres</h1>
				<table width="100%" border="1">
					<tr>
						<th>Nombre de partida</th>
						<th>Descripción</th>
						<th>N. Jugadores</th>
						<th>T. Libres</th>
					</tr>
					<s:iterator value="openGames" status="itStatus">
						<tr>
							<td><a
								href="joinGame-<s:property value="#itStatus.index"/>.action"><s:text
										name="name"></s:text> </a></td>
							<td><s:text name="description"></s:text></td>
							<td><s:text name="players.size()"></s:text></td>
							<td><s:text name="getnFreeTerritories()"></s:text></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</tr>
	</table>

</body>
</html>
