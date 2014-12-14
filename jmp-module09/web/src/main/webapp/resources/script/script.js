var appModule = angular.module('employeeApp', ['ngRoute', 'ngResource']);

appModule.config(['$routeProvider', function($routeProvider){
	$routeProvider.
	when('/unit/', {
		controller: 'UnitsCtrl',
		resolve: {
			units: function(UnitsLoader) {
				return UnitsLoader.getUnits();
			}
		},
		templateUrl:'templates/unit.html'
	})
	.when('/project/', {
		controller: 'ProjectsCtrl',
		resolve: {
			projects: function(ProjectsLoader) {
				return ProjectsLoader.getProjects();
			}
		},
		templateUrl:'templates/project.html'
	})
	.when('/employee/', {
		controller: 'EmployeeCtrl',
		resolve: {
			pros: function(ProjectsLoader) {
				return ProjectsLoader.getProjects();
			},
			units: function(UnitsLoader) {
				return UnitsLoader.getUnits();
			}
		},
		templateUrl:'templates/employee.html'
	})
	.otherwise({redirectTo:'/'});
}]);



appModule.factory('Employees', ['$resource',
                                function($resource) {
	return $resource('http://localhost:8080/jmp-module09-web/webapi/employees/:id', {id: '@id'},
			{createEmployee : {method: 'POST', 
				url:'http://localhost:8080/jmp-module09-web/webapi/employees/create',
				isArray: false},
			getEmployees : { method: 'GET',
				url:'http://localhost:8080/jmp-module09-web/webapi/employees',
				isArray: true
			}
				});
}]);


appModule.factory('EmployeesLoader', ['Employees', '$q',
                                      function(Employees, $q) {
	return { 
		getEmployees : function() {
			var delay = $q.defer();
			Employees.getEmployees(function(employees) {
				delay.resolve(employees);
			}, function(err) {
				delay.reject('Unable to fetch employees');
			});
			return delay.promise;
		},
		createEmployee : function(employee) {
			Employees.createEmployee({}, employee, function(data) {

			}, function(err) {
				alert(err);
			});
		},
		getEmployee : function(employeeId) {
			var delay = $q.defer();
			Employees.get({"id":employeeId}, function(employee) {
				delay.resolve(employee);
			}, function(err) {
				delay.reject('Unable to fetch exchanger');
			});
			return delay.promise;
		}
	}
}]);


appModule.controller('EmployeeCtrl', ['$scope', 'EmployeesLoader', 'pros', 'units', '$rootScope',
                                       function($scope, EmployeesLoader, pros, units, $rootScope){
	
	$scope.pros = pros;
	$scope.units = units;
	
	var builder = function() {
		return {
		      id : 1,
		      country : "",
		      city : "",
		      district : "",
		      telephones : [ {
		        value : "",
		        telephoneType : "HOME",
		        id : 4
		      }, {
		        value : "",
		        telephoneType : "WORK",
		        id : 1
		      }, {
		        value : "",
		        telephoneType : "MOBILE",
		        id : 2
		      }, {
		        value : "",
		        telephoneType : "VO_IP",
		        id : 3
		      } ]
		    }
	};
	var addr = builder();
	$scope.isSearch = false;
	$scope.newEmployee = {
			  person : {
				    firstName : "",
				    surName : "",
				    lastName : "",
				    birthDate : "",
				    workPlace : "",
				    genre : "",
				    nationality : "",
				    addresses : [addr],
				    id : 0,
				    email : ""
				  },
				  employeeStatus : "",
				  lastUpdatedDate : "",
				  unit : "",
				  projects : "",
				  id : 0
				};
	
	$scope.cancel = function(){
		$scope.isSearch = false;
		$scope.newEmployee.person.firstName = "";
		$scope.newEmployee.person.surName = "";
		$scope.newEmployee.person.lastName = "";
		$scope.newEmployee.person.birthDate = "";
		$scope.newEmployee.person.workPlace = "";
		$scope.newEmployee.person.genre = "";
		$scope.newEmployee.person.nationality = "";
		$scope.newEmployee.person.email = "";
		$scope.newEmployee.employeeStatus = "";
		$scope.newEmployee.lastUpdatedDate = new Date();
		$scope.newEmployee.unit = "";
		$scope.newEmployee.project = "";
		$scope.employeeId = "";
	}
	
	createEmployee = function(employee) {
		EmployeesLoader.createEmployee(employee);
	}
	$scope.searchEmployee = function() {
		EmployeesLoader.getEmployee($scope.employeeId).then(function(response){
			$scope.isSearch = true;
			$scope.employee = response;
//			for(prop in $scope.employee){
//				if ($scope.employee.hasOwnProperty(prop)) {
//					$scope.newEmployee[prop] = $scope.employee[prop];
//				}
//			}
			//alert(JSON.stringify($scope.employee));
			$scope.newEmployee.person.firstName = $scope.employee.person.firstName;
			$scope.newEmployee.person.surName = $scope.employee.person.surName;
			$scope.newEmployee.person.lastName = $scope.employee.person.lastName;
			$scope.newEmployee.person.birthDate = $scope.employee.person.birthDate;
			$scope.newEmployee.person.workPlace = $scope.employee.person.workPlace;
			$scope.newEmployee.person.genre = $scope.employee.person.genre;
			$scope.newEmployee.person.nationality = $scope.employee.person.nationality;
			$scope.newEmployee.person.email = $scope.employee.person.email;
			$scope.newEmployee.person.addresses = $scope.employee.person.addresses;
			$scope.newEmployee.employeeStatus = $scope.employee.employeeStatus;
			$scope.newEmployee.lastUpdatedDate = $scope.employee.lastUpdatedDate;
			$scope.newEmployee.unit = $scope.employee.unit;
			$scope.newEmployee.projects = $scope.employee.projects;
			//alert(JSON.stringify($scope.newEmployee));
		}, 
		function(err){
			alert("Error.");
		});
		
	};
	update = function(){
		$scope.employee.person.firstName = $scope.newEmployee.person.firstName;
		$scope.employee.person.surName = $scope.newEmployee.person.surName;
		$scope.employee.person.lastName = $scope.newEmployee.person.lastName;
		$scope.employee.person.birthDate = $scope.newEmployee.person.birthDate;
		$scope.employee.person.workPlace = $scope.newEmployee.person.workPlace;
		$scope.employee.person.genre = $scope.newEmployee.person.genre;
		$scope.employee.person.nationality = $scope.newEmployee.person.nationality;
		$scope.employee.person.email = $scope.newEmployee.person.email;
		//$scope.employee.person.addresses = $scope.newEmployee.person.addresses;
		$scope.employee.employeeStatus = $scope.newEmployee.employeeStatus;
		$scope.employee.lastUpdatedDate = $scope.newEmployee.lastUpdatedDate;
		$scope.employee.unit = $scope.unit;
		$scope.employee.projects = [$scope.project];

		$scope.employee.$save();
		$scope.isSearch = false;
	};
	
	$scope.process = function(){
		if($scope.isSearch) {
			update();
		} else {
			$scope.newEmployee.id = 0;
			$scope.newEmployee.projects = [$scope.project];
			createEmployee($scope.newEmployee);
		}
		alert($scope.$parent.employees);
		$rootScope.$broadcast("employee:notify");
	}
}]);

appModule.controller('EmployeesCtrl', ['$scope', 'EmployeesLoader', 
                                       function($scope, EmployeesLoader){
	
	$scope.$on("employee:notify", function(e){
		setTimeout(function(){
			$scope.$apply(function(scope){
				EmployeesLoader.getEmployees().then(function(response){
					$scope.employees = response;
				}, 
				function(err){
					alert("Error.");
				});
			})}, 500);
	});
	
	EmployeesLoader.getEmployees().then(function(response){
		$scope.employees = response;
	}, 
	function(err){
		alert("Error.");
	});
}]);


appModule.factory('Units', ['$resource',
                            function($resource) {
return $resource('http://localhost:8080/jmp-module09-web/webapi/units/:id', {id: '@id'},
		{createUnit : {method: 'POST', 
			url:'http://localhost:8080/jmp-module09-web/webapi/units/create',
			isArray: false},
		getUnits : { method: 'GET',
			url:'http://localhost:8080/jmp-module09-web/webapi/units',
			isArray: true
		}
			});
}]);

appModule.controller('NavCtrl', ['$scope', 
                                 function($scope){
	$scope.items = [
	                {id:"employee", value:"Manage Employee"},
	                {id:"unit", value:"Manage Unit"},
	                {id:"project", value:"Manage Project"}
	                ];
	$scope.currentLink = $scope.items[0].id;
	$scope.setLink = function(id) {
		$scope.currentLink = id;
	}
}]);

appModule.factory('UnitsLoader', ['Units', '$q',
                                  function(Units, $q) {
return { 
	getUnits : function() {
		var delay = $q.defer();
		Units.getUnits(function(units) {
			delay.resolve(units);
		}, function(err) {
			alert("Error" + err);
			delay.reject('Unable to fetch Units');
		});
		return delay.promise;
	},
	createUnit : function(unit) {
		Units.createUnit({}, unit, function(data) {

		}, function(err) {
			alert("Error" +err);
		});
	},
	getUnit : function(unitId) {
		var delay = $q.defer();
		Units.get({"id":unitId}, function(unit) {
			delay.resolve(unit);
		}, function(err) {
			delay.reject('Unable to fetch exchanger');
		});
		return delay.promise;
	}
}
}]);

appModule.controller('UnitsCtrl', ['$scope', 'UnitsLoader', 'units', 
                                   function($scope, UnitsLoader, units){
	$scope.isSearch = false;
	$scope.units = units;
	$scope.newUnit = {
			id : new Number(0),
			unitType : ""
	}
	
	$scope.cancel = function(){
		$scope.isSearch = false;
		$scope.newUnit.unitType = "";
		$scope.unitId = "";
	}
	
	createUnit = function(unit) {
		UnitsLoader.createUnit(unit);
	}
	$scope.searchUnit = function() {
		UnitsLoader.getUnit($scope.unitId).then(function(response){
			$scope.isSearch = true;
			$scope.unit = response;
			$scope.newUnit.id = $scope.unit.id;
			$scope.newUnit.unitType = $scope.unit.unitType;
		}, 
		function(err){
			alert("Error.");
		});
		
	};
	update = function(){
		$scope.unit.unitType = $scope.newUnit.unitType;
		$scope.unit.$save();
		$scope.isSearch = false;
	};
	$scope.process = function(){
		if($scope.isSearch) {
			update();
		} else {
			$scope.newUnit.id = 0;
			createUnit($scope.newUnit);
		}
		setTimeout(function(){
			$scope.$apply(function(scope){
				UnitsLoader.getUnits().then(function(response){
					scope.units = response;
				}, 
				function(err){
					alert("Error.");
				});
			})}, 500);
	}
//	UnitsLoader.getUnits().then(function(response){
//		$scope.units = response;
//	}, 
//	function(err){
//		alert("Error.");
//	});
}]);


appModule.factory('Projects', ['$resource',
                               function($resource) {
	return $resource('http://localhost:8080/jmp-module09-web/webapi/projects/:id', {id: '@id'},
			{createProject : {method: 'POST', 
				url:'http://localhost:8080/jmp-module09-web/webapi/projects/create',
				isArray: false},
			getProjects : { method: 'GET',
				url:'http://localhost:8080/jmp-module09-web/webapi/projects',
				isArray: true
			}
				});
}]);


appModule.factory('ProjectsLoader', ['Projects', '$q',
                                     function(Projects, $q) {
	return { 
		getProjects : function() {
			var delay = $q.defer();
			Projects.getProjects(function(projects) {
				delay.resolve(projects);
			}, function(err) {
				delay.reject('Unable to fetch Projects');
			});
			return delay.promise;
		},
		createProject : function(project) {
			Projects.createProject({}, project, function(data) {

			}, function(err) {
				alert(err);
			});
		},
		getProject : function(projectId) {
			var delay = $q.defer();
			Projects.get({"id":projectId}, function(project) {
				delay.resolve(project);
			}, function(err) {
				delay.reject('Unable to fetch exchanger');
			});
			return delay.promise;
		}
	}
}]);

appModule.controller('ProjectsCtrl', ['$scope', 'ProjectsLoader', 'projects', '$location',
                                      function($scope, ProjectsLoader, projects, $location){
	$scope.projects = projects;
	$scope.newProject = {
			id : new Number(0),
			name : ""
	}
	createProject = function(project) {
		ProjectsLoader.createProject(project);
	}
	
	$scope.isSearch = false;
	
	$scope.cancel = function(){
		$scope.isSearch = false;
		$scope.newProject.name = "";
		$scope.projectId = "";
	}

	$scope.searchProject = function() {
		ProjectsLoader.getProject($scope.projectId).then(function(response){
			$scope.isSearch = true;
			$scope.project = response;
			$scope.newProject.id = $scope.project.id;
			$scope.newProject.name = $scope.project.name;
		}, 
		function(err){
			alert("Error.");
		});
		
	};
	update = function(){
		$scope.project.name = $scope.newProject.name;
		$scope.project.$save();
		$scope.isSearch = false;
	};
	$scope.process = function(){
		if($scope.isSearch) {
			update();
		} else {
			$scope.newProject.id = 0;
			createProject($scope.newProject);
		}
		setTimeout(function(){
		$scope.$apply(function(scope){
			ProjectsLoader.getProjects().then(function(response){
				scope.projects = response;
			}, 
			function(err){
				alert("Error.");
			});
		})}, 500);
	}
	
//	ProjectsLoader.getProjects().then(function(response){
//		$scope.projects = response;
//	}, 
//	function(err){
//		alert("Error.");
//	});
}]);