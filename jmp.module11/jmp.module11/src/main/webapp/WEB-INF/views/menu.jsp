<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu">
	
    <h3>Menu</h3>
    <ul>
    
		<li><a href="<c:url value="/?form"/>"><h3>Add/Edit Account</h3></a></li>
		<li><a href="<c:url value="/list"/>"><h3>Account list</h3></a></li> 
		<li><a href="<c:url value="/exchanger?form"/>"><h3>Get exchanger</h3></a></li>
	</ul>
 
</div>
