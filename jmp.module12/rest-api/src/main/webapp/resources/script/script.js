var appModule = angular.module('messageApp', ['ngRoute', 'ngResource']);


appModule.factory('Subscribers', ['$resource',
                                function($resource) {
	return $resource('http://localhost:8080/rest-api/webapi/subscribers', {},
			{createSubscriber : {method: 'GET', 
				url:'http://localhost:8080/rest-api/webapi/subscribers/create',
				isArray: false},
			getSubscribers : { method: 'GET',
				url:'http://localhost:8080/rest-api/webapi/subscribers',
				isArray: true
			}
				});
}]);


appModule.factory('SubscribersLoader', ['Subscribers', '$q',
                                      function(Subscribers, $q) {
	return { 
		getSubscribers : function() {
			var delay = $q.defer();
			Subscribers.getSubscribers(function(subscribers) {
				delay.resolve(subscribers);
			}, function(err) {
				delay.reject('Unable to fetch subscribers');
			});
			return delay.promise;
		},
		createSubscriber : function() {
			Subscribers.createSubscriber({}, function(data) {

			}, function(err) {
				alert(err);
			});
		}
	}
}]);


appModule.controller('SubscribersCtrl', ['$scope', 'SubscribersLoader',
                                       function($scope, SubscribersLoader){
	
	function compare(message1, message2) {
	   
	}
	
	function select(){
		SubscribersLoader.getSubscribers().then(function(response){
			$scope.subscribers = response;
		}, 
		function(err){
			alert("Error.");
		});
	}
	//select();
	setTimeout(function(){
		select();
        setTimeout(arguments.callee, 100);         

    }, 100);  

	$scope.createSubscriber = function(){
		SubscribersLoader.createSubscriber().then(function(response){
			select();
		}, 
		function(err){
			alert("Error.");
		})
	} 
}]);