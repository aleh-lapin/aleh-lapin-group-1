<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<title>Ticket Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/screen.css"/>" />
</head>

<body>
	<div id="headerWrapper">
		<jsp:include page="header.jsp" flush="true" />
	</div>
	<div id="wrapper">
		<div id="main">
			<div id="container">
				<h2>Order ticket</h2>
				<form method="POST" action="order">
					<table class="simpletablestyle">
						<thead>
							<tr>
								<th>Description</th>
								<th>Price</th>
								<th>Available ticket`s amount</th>
								<th>Ordered count</th>
								<th>order ticket</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${ticket.description}</td>
								<td>${ticket.price}</td>
								<td>${ticket.amount}</td>
								<td><input type="text" name="count" value="" /> <input
									type="hidden" name="ticketId" value="${ticket.identity}" /></td>
								<td><input type="submit" value="Order" /></td>
						</tbody>
					</table>
				</form>
			</div>
			<jsp:include page="footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>
