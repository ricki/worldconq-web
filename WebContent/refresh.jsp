<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib uri="/struts-tags" prefix="s"%><?xml version="1.0" encoding="utf-8"?>
<gamedata>
	<territories>
		<s:iterator value="map" status="itStatus">
		<territory>
			<id><s:property value="idTerritory"/></id>
			<s:if test="owner == null">
				<owner>?</owner>
			</s:if>
			<s:else>
				<owner><s:property value="owner"/></owner>
			</s:else>
			<soldiers><s:property value="numSoldiers"/></soldiers>
			<cannons>
				<cannon><s:property value="numCannons[0]"/></cannon>
				<cannon><s:property value="numCannons[1]"/></cannon>
				<cannon><s:property value="numCannons[2]"/></cannon>
			</cannons>
			<missiles><s:property value="numMissiles"/></missiles>
			<icbm><s:property value="numICBMs"/></icbm>
			<antimissiles><s:property value="numAntiMissiles"/></antimissiles>
		</territory>
		</s:iterator>
	</territories>
	<players>
		<s:iterator value="players" status="itStatus">
			<player>
				<name><s:property value="name"/></name>
				<money><s:property value="money"/></money>
				<s:if test="!online">
					<status>0</status>
				</s:if>
				<s:else>
					<s:if test="!hasTurn">
						<state>1</state>
					</s:if>
					<s:else>
						<state>2</state>
					</s:else>
				</s:else>
			</player>
		</s:iterator>
	</players>
</gamedata>
