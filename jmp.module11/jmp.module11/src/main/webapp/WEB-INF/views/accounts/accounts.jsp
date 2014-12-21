<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="container">
	<h2>Accounts</h2>
	<c:choose>
		<c:when test="${accounts.size()==0}">
			<em>No registered accounts.</em>
		</c:when>
		<c:otherwise>
			<table class="simpletablestyle">
				<thead>
					<tr>
						<th>First name</th>
						<th>Surname</th>
						<th>last name</th>
						<th>Birth date</th>
						<th>Work places</th>
						<th>Genre</th>
						<th>Nationality</th>
						<th>Country</th>
						<th>City</th>
						<th>District</th>
						<th>Telephones</th>
						<th>Credit</th>
						<th>Debit</th>
						<th>Ballance</th>
						<th>Last updated date</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accounts}" var="account">
						<tr>
							<td>${account.person.firstName}</td>
							<td>${account.person.surName}</td>
							<td>${account.person.lastName}</td>
							<td>${account.person.birthDate}</td>
							<td>${account.person.workPlace[0]}</td>
							<td>${account.person.genre}</td>
							<td>${account.person.nationality}</td>
							<td>${account.person.address.country}</td>
							<td>${account.person.address.city}</td>
							<td>${account.person.address.district}</td>
							<td><c:forEach
									items="${account.person.address.telephones.telephones}"
									var="tel">
									<span>${tel.value} ${tel.telephoneType}</span>
								</c:forEach></td>
							<td>${account.credit.value} ${account.credit.curr}</td>
							<td>${account.debit.value} ${account.debit.curr}</td>
							<td>${account.ballance.value} ${account.ballance.curr}</td>
							<td>${account.lastUpdatedDate}</td>
							<td><a href="<c:url value="/${account.id}?form"/>">Edit</a></td>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</div>

