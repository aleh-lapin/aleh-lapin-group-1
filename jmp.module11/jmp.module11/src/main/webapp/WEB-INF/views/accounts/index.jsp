<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="container">

	<form:form commandName="newAccount" id="reg">
		<h2>Registration</h2>
		<p>Create/edit </p>
		<table>
			<tbody>
				<form:hidden path="id" />
				<form:hidden path="ballance.value" />
				<form:hidden path="ballance.curr" />
				<tr>
					<td><form:label path="credit.value">Credit:</form:label></td>
					<td><form:input path="credit.value" /></td>
					<td><form:errors class="invalid" path="credit.value" /></td>
				</tr>
				<tr>
					<td><form:label path="credit.curr">Credit currency:</form:label></td>
					<td><form:select path="credit.curr">
							<form:option value="RU" label="--- Select currency type ---" />
							<form:options items="${currencyList}" />
						</form:select></td>
					<td><form:errors class="invalid"
							path="credit.curr" /></td>
				</tr>
				<tr>
					<td><form:label path="debit.value">Debit:</form:label></td>
					<td><form:input path="debit.value" /></td>
					<td><form:errors class="invalid" path="debit.value" /></td>
				</tr>
				<tr>
					<td><form:label path="debit.curr">Debit currency:</form:label></td>
					<td><form:select path="debit.curr">
							<form:option value="RU" label="--- Select currency type ---" />
							<form:options items="${currencyList}" />
						</form:select></td>
					<td><form:errors class="invalid" path="debit.curr" /></td>
				</tr>

				<tr>
					<td><form:label path="person.firstName">First name:</form:label></td>
					<td><form:input path="person.firstName" /></td>
					<td><form:errors class="invalid"
							path="person.firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="person.lastName">Sur name:</form:label></td>
					<td><form:input path="person.lastName" /></td>
					<td><form:errors class="invalid"
							path="person.lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="person.surName">Last name:</form:label></td>
					<td><form:input path="person.surName" /></td>
					<td><form:errors class="invalid" path="person.surName" /></td>
				</tr>

				<tr>
					<fmt:formatDate value="${person.birthDate}"
						var="dateString" pattern="yyyy-MM-dd" />
					<td><form:label path="person.birthDate">Last name:</form:label></td>
					<td><form:input path="person.birthDate" /></td>
					<td><form:errors class="invalid"
							path="person.birthDate" /></td>
				</tr>

				<tr>
					<td><form:label path="person.workPlace[0]">Work place:</form:label></td>
					<td><form:input path="person.workPlace[0]" /></td>
					<td><form:errors class="invalid"
							path="person.workPlace[0]" /></td>
				</tr>

				<tr>
					<td><form:label path="person.genre">Genre:</form:label></td>
					<td><form:select path="person.genre">
							<form:option value="RU" label="--- Select genre ---" />
							<form:options items="${genreList}" />
						</form:select></td>
					<td><form:errors class="invalid" path="person.genre" /></td>
				</tr>

				<tr>
					<td><form:label path="person.nationality">Genre:</form:label></td>
					<td><form:select path="person.nationality">
							<form:option value="RU" label="--- Select nationality ---" />
							<form:options items="${nationalityList}" />
						</form:select></td>
					<td><form:errors class="invalid"
							path="person.nationality" /></td>
				</tr>

				<tr>
					<td><form:label path="person.address.country">Country:</form:label></td>
					<td><form:input path="person.address.country" /></td>
					<td><form:errors class="invalid"
							path="person.address.country" /></td>
				</tr>

				<tr>
					<td><form:label path="person.address.city">City:</form:label></td>
					<td><form:input path="person.address.city" /></td>
					<td><form:errors class="invalid"
							path="person.address.city" /></td>
				</tr>

				<tr>
					<td><form:label path="person.address.district">District:</form:label></td>
					<td><form:input path="person.address.district" /></td>
					<td><form:errors class="invalid"
							path="person.address.district" /></td>
				</tr>

				<tr>
					<td><form:label
							path="person.address.telephones.telephones[0].value">Home telephone:</form:label></td>
					<td><form:input
							path="person.address.telephones.telephones[0].value" /></td>
					<td><form:errors class="invalid"
							path="person.address.telephones.telephones[0].value" /></td>
				</tr>

				<tr>
					<td><form:label
							path="person.address.telephones.telephones[1].value">Modile telephone:</form:label></td>
					<td><form:input
							path="person.address.telephones.telephones[1].value" /></td>
					<td><form:errors class="invalid"
							path="person.address.telephones.telephones[1]v" /></td>
				</tr>

				<tr>
					<td><form:label
							path="person.address.telephones.telephones[2].value">Work telephone:</form:label></td>
					<td><form:input
							path="person.address.telephones.telephones[2].value" /></td>
					<td><form:errors class="invalid"
							path="person.address.telephones.telephones[2].value" /></td>
				</tr>

				<tr>
					<td><form:label
							path="person.address.telephones.telephones[3].value">VoIP telephone:</form:label></td>
					<td><form:input
							path="person.address.telephones.telephones[3].value" /></td>
					<td><form:errors class="invalid"
							path="person.address.telephones.telephones[3].value" /></td>
				</tr>

			</tbody>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="Register" class="register" />
				</td>
			</tr>
		</table>
	</form:form>

</div>