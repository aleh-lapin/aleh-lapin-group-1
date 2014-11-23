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
	<div id="container" ng-app="exchangerApp">
		<div ng-controller="ExchangerCtrl">
			<div style"float:right;width: 250px">
			<table class="simpletablestyle" width="200" border="1"
				cellspacing="0">
				<caption align="top">Banck name - {{exchanger.bankRef}}.
					Basic currency - {{exchanger.basicCurrency}}</caption>
				<thead align="center" style="background: #fc0; color: black">
					<tr>
						<td>Currency</td>
						<td>Course</td>
					</tr>
				</thead>

				<tbody align="right">
					<tr ng-repeat="item in exchanger.course">
						<td>{{item.curr}}</td>
						<td>{{item.value}}</td>
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


</body>
</html>
