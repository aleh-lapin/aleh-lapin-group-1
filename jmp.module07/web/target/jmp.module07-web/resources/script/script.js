var appModule = angular.module('exchangerApp', ['ngRoute', 'ngResource']);

appModule.config(['$routeProvider', function($routeProvider){
	$routeProvider.
	when('/accounts/', {
		controller: 'AccountsCtrl',
		resolve: {
			accounts: function(MultipleAccountLoader) {
				return MultipleAccountLoader.getAccounts();
			}
		},
		templateUrl:'templates/accounts.html'
	})
	.when('/account/', {
		controller: 'AccountCtrl',
		resolve: {
			accounts: function(MultipleAccountLoader) {
				return MultipleAccountLoader.getAccounts();
			}
		},
		templateUrl:'templates/account.html'
	})
	.when('/exchanger/', {
		controller: function($scope, ExchangerLoader){
			ExchangerLoader().then(function(response){
				$scope.exchanger = response;
			}, 
			function(err){
				alert("Error.");
			});
			$scope.update = function(){
				$scope.exchanger.$updateExchanger();
			};
		},
		templateUrl:'templates/exchanger.html'
	})
	.otherwise({redirectTo:'/'});
}]);

appModule.factory('Exchanger', ['$resource',
                                function($resource) {
	return $resource('http://localhost:8080/jmp.module07-web/webapi/accounts/get_exchanger', {},
			{updateExchanger : {method: 'POST', 
				url:'http://localhost:8080/jmp.module07-web/webapi/accounts/update_exchanger',
				isArray: false}});
}]);


appModule.factory('ExchangerLoader', ['Exchanger', '$q',
                                      function(Exchanger, $q) {
	return function() {
		var delay = $q.defer();
		Exchanger.get({}, function(exchanger) {
			delay.resolve(exchanger);
		}, function(err) {
			delay.reject('Unable to fetch exchanger');
		});
		return delay.promise;
	};
}]);
appModule.controller('ExchangerCtrl', ['$scope', 'ExchangerLoader', 
                                       function($scope, ExchangerLoader){
	ExchangerLoader().then(function(response){
		$scope.exchanger = response;
	}, 
	function(err){
		alert("Error.");
	});
}]);

appModule.controller('NavCtrl', ['$scope', 
                                 function($scope){
	$scope.items = [
	                {id:"accounts", value:"Accounts"},
	                {id:"account", value:"Manage account"},
	                {id:"exchanger", value:"Exchanger"}
	                ];
	$scope.currentLink = $scope.items[0].id;
	$scope.setLink = function(id) {
		$scope.currentLink = id;
	}
}]);

appModule.factory('Account', ['$resource',
                              function($resource) {
	return $resource('http://localhost:8080/jmp.module07-web/webapi/accounts/:id', 
			{id: '@id'},
			{createAccount : {method: 'POST', 
				url:'http://localhost:8080/jmp.module07-web/webapi/accounts/create',
				isArray: false}}
	);
}]);

appModule.factory('AccountLoader', ['Account', '$q',
                                    function(Account, $q) {
	return {
		getAccount : function(accountId) {
			var delay = $q.defer();
			Account.get({id: accountId}, function(account) {
				delay.resolve(account);
			}, function(err) {
				delay.reject('Unable to fetch account');
			});
			return delay.promise;
		}
	}
}]);

appModule.factory('MultipleAccountLoader', ['Account', '$q',
                                            function(Account, $q) {
	return {
		getAccounts : function() {
			var delay = $q.defer();
			Account.query(function(accounts) {
				delay.resolve(accounts);
			}, function(err) {
				delay.reject('Unable to fetch account');
			});
			return delay.promise;
		}
	}
}]);

appModule.controller('AccountCtrl', ['$scope', 'AccountLoader', 
                                     function($scope, AccountLoader){
	$scope.acc = {
			credit : {
				value : 0.0,
				curr : "NOT_DEFINED"
			},
			debit : {
				value : 0.0,
				curr : "NOT_DEFINED"
			},
			ballance : {
				value : 0.0,
				curr : "NOT_DEFINED"
			}};
	$scope.searchAccount = function() {
		AccountLoader.getAccount($scope.accountId).then(function(response){
			$scope.account = response;
			$scope.acc.credit = $scope.account.credit;
			$scope.acc.debit = $scope.account.debit;
			$scope.acc.ballance = $scope.account.ballance;
		}, 
		function(err){
			alert("Error.");
		});
		
	};
	$scope.update = function(){
		$scope.account.credit = $scope.acc.credit;
		$scope.account.debit = $scope.acc.debit;
		$scope.account.ballance = $scope.acc.ballance;
		$scope.account.$save();
	};
	
}]);

appModule.controller('AccountsCtrl', ['$scope', 'accounts', 
                                      function($scope, accounts){
	$scope.accounts = accounts;
}]);