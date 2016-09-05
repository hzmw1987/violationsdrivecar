
/**
 * 
 */

'use strict';
angular.module('app.core').controller('CategoryController',
    function ($rootScope, $scope, $log,toaster,CategoriesService,$location) {
	
    $scope.orderPageChanged = function () {
    	refreshChannelList();
    };
    
    
    $scope.showChannel = function(channelId,channelName){
    	console.log(channelId+"   "+channelName);
    	$rootScope.id = channelId;
    	$rootScope.name = channelName;
    	$location.path('/cate/overview');
    }
    $scope.toNew = function(){
    	$rootScope.name = "";
    	$location.path('/add/categories');
    }
   
    function queryCategoriesList() {
    	
    	CategoriesService.getCatelList({
    	}).then(function (data) {
    		
       	 $scope.categories = data.category;
       	 
       }, function (error) {
    	   alert(error.errorText);
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    }
    

    queryCategoriesList();


    });

