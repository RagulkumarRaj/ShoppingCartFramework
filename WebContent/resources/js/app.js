var app = angular.module('Appln', []);
app.controller('TestCtrl', function($scope, $http){
	$scope.name="Ragss";
	//$http.get('resources/data/data.json').success(function(data){
	//	$scope.products = data;
	//});
	$http.get('viewProductList').success(function(data){
	$scope.products = data;
	});
});
app.filter('bracketless',function() {
    return function(input) {
        if (input) {
            return input.replace(/\(/g,"[").replace(/\)/g,"]");  
        }
    }
});