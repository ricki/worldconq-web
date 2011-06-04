<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib uri="/struts-tags" prefix="s"%><?xml version="1.0" encoding="utf-8"?>
<response>
	<status>Error</status>
	<s:iterator value="actionErrors" status="itStatus">
		<message><s:property/></message>
	</s:iterator>
</response>