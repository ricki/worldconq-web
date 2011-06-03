<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="1;/worldconq-web/listGames.action">
<title>Worldconq - Join game</title>
</head>

<body bgcolor="#000000" background="image/mapafondobig.jpg" style="background-attachment: fixed; background-position: 50% 25%; background-repeat: no-repeat;">
	<s:actionmessage />
	<s:actionerror />
	<div align=center>
	<table align="center" style="padding-top: 200px">
		<tr>
		<td>
			<s:a action="listGames.action">Volver a la lista de partidas...</s:a>
		</td>
		</tr>
	</table>
	</div>
</body>

</html>