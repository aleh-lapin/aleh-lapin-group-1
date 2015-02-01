<html>
<head>
<title>Message application</title>
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
	<div id="container" ng-app="messageApp">
		<div ng-controller="SubscribersCtrl">
			<div>
				<div>
					<div>
						<ul class="nav">
							<li><a href="#" ng-click="createSubscriber()">Add subscriber</a></li>
						</ul>
					</div>
				</div>
				<table class="simpletablestyle" width="100%" border="1"
					cellspacing="0">
					<caption align="top">Subscriber`s list.</caption>
					<thead align="center" style="background: #fc0; color: black">
						<tr>
							<td>Subscriber name</td>
							<td>Subscriber message`s list</td>
						</tr>
					</thead>

					<tbody align="right">
						<tr ng-repeat="subscriber in subscribers">
							<td>{{subscriber.name}}</td>
							<td>
								<div class = "subscriber">
									<p ng-repeat="message in subscriber.messages">
										<span>
											Message {{message.messageId}}
										</span>
										<span>
											Subject {{message.subject}}
										</span>
										<span>
											{{message.body}}
										</span>
										<span style="text-align:right">
											{{message.postDate}}
										</span>
									</p>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
		</div>

	</div>

</body>
</html>
