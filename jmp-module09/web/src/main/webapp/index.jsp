<html>
<head>
<title>Exchanger application</title>
<link href="resources/css/screen.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="resources/script/angular.js">
	
</script>
<script type="text/javascript" src="resources/script/angular-route.js">
	
</script>
<script type="text/javascript"
	src="resources/script/angular-resource.js">
	
</script>
<script type="text/javascript" src="resources/script/script.js">
	
</script>
</head>
<body>
	<h2>RESTful Web Application!</h2>
	<div id="container" ng-app="employeeApp">
		<div ng-controller="EmployeesCtrl">
			<div>
				<table class="simpletablestyle" width="100%" border="1"
					cellspacing="0">
					<caption align="top">Employee`s list.</caption>
					<thead align="center" style="background: #fc0; color: black">
						<tr>
							<td>First name</td>
							<td>Surname</td>
							<td>last name</td>
							<td>Birth date</td>
							<td>Work places</td>
							<td>Genre</td>
							<td>Nationality</td>
							<td>Email</td>
							<td>Employee status</td>
							<td>Unit</td>
							<td>Projects list</td>
						</tr>
					</thead>

					<tbody align="right">
						<tr ng-repeat="employee in employees">
							<td>{{employee.person.firstName}}</td>
							<td>{{employee.person.surName}}</td>
							<td>{{employee.person.lastName}}</td>
							<td>{{employee.person.birthDate}}</td>
							<td ng-bind="employee.person.workPlace"></td>
							<td>{{employee.person.genre}}</td>
							<td>{{employee.person.nationality}}</td>
							<td>{{employee.person.email}}</td>
							<td>{{employee.employeeStatus}}</td>
							<td>{{employee.unit.unitType}}</td>
							<td>
							<span style="display:block" ng-repeat="pr in employee.projects">{{pr.name}}</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div>
			<div ng-controller="NavCtrl">
				<ul class="nav">
					<li ng-repeat="item in items"
						ng-class="{true: 'active', false: ''}[currentLink == item.id]"><a
						href="#/{{item.id}}/" ng-click="setLink(item.id)">{{item.value}}</a></li>
				</ul>
			</div>
			</div>
			
		</div>
		<div id="content" ng-view>

		</div>
	</div>
	</div>


</body>
</html>
