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
				<h2>Tickets</h2>
				<c:choose>
					<c:when test="${tickets.size()==0}">
						<em>No available tickets.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Description</th>
									<th>Price</th>
									<th>Available ticket`s amount</th>
									<th>Your ballance</th>
									<th>order ticket</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${tickets}" var="ticket">
									<tr>
										<td>${ticket.description}</td>
										<td>${ticket.price}</td>
										<td>${ticket.amount}</td>
										<td>${ballance}</td>
										<td><a
											href="<c:url value="/order?ticketId=${ticket.identity}"/>">Order</a></td>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<jsp:include page="footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>
