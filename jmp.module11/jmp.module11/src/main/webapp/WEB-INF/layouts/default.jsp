<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<title>Spring MVC Account Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />
</head>

<body>
	<div id="headerWrapper">
		<tiles:insertAttribute name="header" ignore="true" />
	</div>
	<div id="wrapper">
		<tiles:insertAttribute name="menu" ignore="true" />
		<div id="main">
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" ignore="true" />
		</div>
	</div>
</body>
</html>
