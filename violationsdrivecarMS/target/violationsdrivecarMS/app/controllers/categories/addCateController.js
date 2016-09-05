
/**
 * 
 */

'use strict';
angular.module('app.core').controller('AddCateController',
    function ($rootScope, $scope, $log,toaster,CategoriesService,$location,$cookieStore ) {
	
	var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.id != undefined || $rootScope.name != undefined){
		$cookieStore.put('id', $rootScope.id, { expires: exp });
		$cookieStore.put('name', $rootScope.name, { expires: exp });
	}else{
		$rootScope.id = $cookieStore.get('id');
		$rootScope.name = $cookieStore.get('name');
	}
	
	
	$scope.name = $rootScope.name;
	$scope.id = $rootScope.id;
	
    $scope.addcate = function () {
    	console.log($scope.name);
    		CategoriesService.addCate({
        		name:$scope.name,
        	}).then(function (data) {
        		$location.path('/categories');
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    }
    
    $scope.back = function(){
    	$location.path('/categories');
    }
    
    $scope.cateDetail = function(){
    	$location.path(' /cate/overview');
    }
    
   
    

    $scope.updatecate = function () {
    		CategoriesService.editCate({
        		id:$rootScope.id,
        		name:$scope.name,
        	}).then(function (data) {
        		$location.path('/categories');
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    	
    }
    
    $scope.toNew = function(){
    	$location.path('/vendors/new');
    }
    

    });

