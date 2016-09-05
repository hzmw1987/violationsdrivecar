
/**
 * 
 */

'use strict';
angular.module('app.core').controller('UserController',
    function ($rootScope, $scope, $log,toaster,UserService,$location) {
	$scope.busy = false; 
	$scope.page = 1;
	$scope.nextPage = function(){
		$scope.busy = true;
		$scope.userList.push($scope.userList1[1]);
		$scope.page = $scope.page+1;
		$scope.busy = false;
	}
    
    $scope.showChannel = function(channelId,channelName){
    	$rootScope.channelId = channelId;
    	$rootScope.channelName = channelName;
    	$location.path('/vendor/overview');
    }
    $scope.toNew = function(){
    	$rootScope.visiable = true;
    	$location.path('/user/new');
    }
    
    $scope.toEdit = function(userId){
    	$rootScope.userId = userId;
    	$rootScope.visiable = false;
    	$location.path('/user/edit');
    }
    
    $scope.queryUsers = function(){
    	queryUser();
    }
   
    function queryUser() {
    	UserService.getUserList({
    		roleId:$scope.roleId,
    		userName:$scope.userName,
    		page:$scope.page
    	}).then(function (data) {
       	 $scope.userList = data.user;
       }, function (error) {
    	   alert(error.errorText);
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    }
    
    
    function getRoleList(){
    	UserService.getRoleList({
    	}).then(function (data) {
       	 $scope.roleList = data.roleList;
       }, function (error) {
    	   alert(error.errorText);
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    }
    
    function init(){
    	$scope.page = 1;
    	$scope.busy = false;
    }

    getRoleList();
    queryUser();


    });

