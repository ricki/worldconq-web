<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Games</title>
</head>
<body>
	<table>
		<tr>
			<s:include value="header.jsp"></s:include>
		</tr>

		<tr>
			<div id="content">
				<h1>Partidas Disponibles</h1>
				<tr>
					<td height="223"><table width="1000" border="1" align="center">
							<tr>
								<th>Nombre de partida</th>
								<th>Descripción</th>
								<th>N. Jugadores</th>
								<th>T. Libres</th>
							</tr>
							<s:iterator value="currentGames" status="itStatus">
								<tr>
									<td><a
										href="worldconq/playGame-<s:property value="#itStatus.index"/>.action"><s:text
												name="name"></s:text>
									</a>
									</td>
									<td><s:text name="description"></s:text>
									</td>
									<td><s:text name="players.size()"></s:text>
									</td>
									<td><s:text name="getnFreeTerritories()"></s:text>
									</td>
								</tr>
							</s:iterator>
						</table></td>
				</tr>

				<h1>Partidas Libres</h1>
				<tr>
					<td height="223"><table width="1000" border="1" align="center">
							<tr>
								<th>Nombre de partida</th>
								<th>Descripción</th>
								<th>N. Jugadores</th>
								<th>T. Libres</th>
							</tr>
							<s:iterator value="openGames" status="itStatus">
								<tr>
									<td><a
										href="worldconq/joinGame-<s:property value="#itStatus.index"/>.action"><s:text
												name="name"></s:text>
									</a>
									</td>
									<td><s:text name="description"></s:text>
									</td>
									<td><s:text name="players.size()"></s:text>
									</td>
									<td><s:text name="getnFreeTerritories()"></s:text>
									</td>
								</tr>
							</s:iterator>
						</table></td>
				</tr>
			</div>
		</tr>
	</table>

</body>
</html>
