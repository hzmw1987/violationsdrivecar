
/**
 * 
 */

'use strict';
angular.module('app.core').controller('AddUserController',
    function ($rootScope, $scope, $log,toaster,UserService,$location,$cookieStore,VendorsService ) {
	
	$scope.visiable = $rootScope.visiable;
	
	$scope.visiable1 = false;
	
	var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.userId != undefined){
		$cookieStore.put('userId', $rootScope.userId, { expires: exp });
	}else{
		$rootScope.userId = $cookieStore.get('userId');
	}
	
	
	$scope.userId = $rootScope.userId;
	
	$scope.checkPassword = function(){
		if($scope.password != $scope.repassword){
			alert("Passwords are not consistent");
		}
	}
	
   
    $scope.addUser = function (boo) {
    	console.log(boo);
    	if(boo){
    		return;
    	}
    	UserService.addUser({
        		userName:$scope.userName,
        		fullName:$scope.fullName,
        		email:$scope.email,
    	        password:$scope.password,
    	        roleId:$scope.roleId,
    	        manageUserId:$scope.manageUserId,
    	        channelId:$scope.channelId
        	}).then(function (data) {
        		$location.path('/users');
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    	
    }
    

    $scope.updateUser = function (boo) {
    	if(boo){
    		return;
    	}
    	if($scope.roleId == 13){
    		$scope.channelId = "";
    	}
    	console.log($scope.userId);
    	UserService.editUser({
    		manageUserId:$scope.userId,
    		userName:$scope.userName,
    		fullName:$scope.fullName,
    		email:$scope.email,
	        password:$scope.password,
	        roleId:$scope.roleId,
	        channelId:$scope.channelId,
        	}).then(function (data) {
        		$location.path('/users');
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    	
    }
    
    $scope.showDiv = function(boo){
    	$scope.visiable1 = boo;
    	console.log($scope.visiable1);
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
    $scope.getChannelName = function(){
   	 document.getElementById('channelName1').style.visibility="hidden";
   }
    
    function getUserById() {
    	if($scope.userId != undefined){
    		UserService.getUserList({
        		userId:$scope.userId,
        	}).then(function (data) {
           	$scope.user = data.user[0];
           	$scope.userName = $scope.user.userName;
           	$scope.fullName = $scope.user.fullName;
           	$scope.email = $scope.user.email;
           	$scope.channelName = $scope.user.channelName;
           	$scope.password = $scope.user.password;
           	$scope.repassword = $scope.user.password;
           	$scope.roleId = $scope.user.roleId;
           	$scope.channelId = $scope.user.channelId;
           	if($scope.roleId == 13){
           		$scope.visiable1 = false;
           	}else{
           		$scope.visiable1 = true;
           	}
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    	}
    }
    function init(){
    	if(document.getElementById("addU") == undefined){
    		getUserById();
    	}else{
    		$scope.user = "";
           	$scope.userName = "";
           	$scope.fullName = "";
           	$scope.email = "";
           	$scope.channelName = "";
           	$scope.password = "";
           	$scope.repassword = "";
           	$scope.roleId = "";
           	$scope.channelId = "";
    	}
    	
    } 
    
    init();
    refreshChannelList();

    });

