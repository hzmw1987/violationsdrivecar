
/**
 * 
 */

'use strict';
angular.module('app.core').controller('VendorsController',
    function ($rootScope, $scope, $log,toaster,VendorsService,$location) {
	
    $scope.orderPageChanged = function () {
    	refreshChannelList();
    };
    
    $scope.queryCompany = function () {
    	VendorsService.getChannelList({
    		channelName:$scope.channelNames,
    	}).then(function (data) {
        	
       	 $scope.channel = data.channel;
       	 $scope.count = data.count;
       }, function (error) {
    	   alert(error.errorText);
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    }
    
    $scope.showChannel = function(channelId,channelName){
    	$rootScope.channelId = channelId;
    	$rootScope.channelName = channelName;
    	$location.path('/vendor/overview');
    }
    $scope.toNew = function(){
    	$rootScope.update = false;
    	$location.path('/vendors/new');
    }
   
    function refreshChannelList() {
    	VendorsService.getChannelList({
    		
        }).then(function (data) {
        	
        	 $scope.channel = data.channel;
        }, function (error) {
        	 alert(error.errorText);
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
    }
    

   refreshChannelList();


    });

