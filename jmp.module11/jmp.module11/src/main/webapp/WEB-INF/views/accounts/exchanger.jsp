<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="content">

	<form:form commandName="newExchanger" id="reg">
		<h2>Member Registration</h2>
		<p>Create/edit account.</p>
		<table>
			<caption align="top">
				Bank name -
				<c:out value="${newExchanger.bankref}"></c:out>
				Basic currency -
				<c:out value="${newExchanger.basiccurrency}"></c:out>
			</caption>
			<tbody>
				<tr>
					<form:hidden path="bankref" />
					<form:hidden path="basiccurrency" />
					<form:hidden path="course[0].curr" />
					<form:hidden path="course[1].curr" />
					<form:hidden path="course[2].curr" />
					<td><c:out value="${course[0].currString}"></c:out>
						<form:label path="course[0].value">Enter new course:</form:label></td>
					<td><form:input path="course[0].value" /></td>
					<td><form:errors class="invalid"
							path="course[0].value" /></td>
				</tr>
				<tr>
					<td><c:out value="${course[1].currString}"></c:out>
						<form:label path="course[1].value">Enter new course:</form:label></td>
					<td><form:input path="course[1].value" /></td>
					<td><form:errors class="invalid"
							path="course[1].value" /></td>
				</tr>
				<tr>
					<td><c:out value="${course[2].currString}"></c:out>
						<form:label path="course[2].value">Enter new course:</form:label></td>
					<td><form:input path="course[2].value" /></td>
					<td><form:errors class="invalid"
							path="course[2].value" /></td>
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