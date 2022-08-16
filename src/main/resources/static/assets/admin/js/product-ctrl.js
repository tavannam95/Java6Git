app.controller("product-ctrl", function($scope, $http, $location) {
	
	$scope.items = [];
	$scope.form = {};
	$scope.initalize = function(){
		$http.get("/rest/products").then(res =>{
			$scope.items = res.data;
			$scope.items.forEach(i =>{
				i.createdate = new Date(i.createdate)
			})
			
		})
	}
	$scope.initalize();
	$scope.reset = function(){
		
	}
	$scope.check_radio = function(){
		console.log($scope.form);
	}
	$scope.edit = function(item){
		$scope.form = angular.copy(item);
		console.log($scope.form);
	}
	$scope.create = function(){
		
	}
	$scope.update = function(){
		
	}
	$scope.delete = function(item){
		
	}
	$scope.imageChange = function(files){
		
	}
})