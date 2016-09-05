
/**
 * 
 */

'use strict';
angular.module('app.core').controller('HomeController',
    function ($rootScope, $scope, $log,toaster,PermissionService,UserService,$location) {
	

 // 日历控件打开状态
    $scope.calenders = {
        startDate: false,
        endDate: false
    };
    
 // 事件方法-打开日历控件
    $scope.calendarOpen = function ($event, key) {
        $event.preventDefault();
        $event.stopPropagation();

        angular.forEach($scope.calenders, function (v, k) {
            $scope.calenders[k] = false;
        });
        $scope.calenders[key] = true;
    };
    
    $scope.clickGroup = function (group) {
    	$location.path(group);
    }
    
    $scope.toHome = function(){
    	$location.path('/home');
    }
    
    $scope.logout = function(){
    	UserService.logout().then(
    	  function(data){
    		  window.location.href = "login.html";
    	  },
    	  function (error) {
    		  alert(error.errorText);
				toaster.pop('Error occurs', 'Networking', '(' + error.errorCode + ') : ' + error.errorText);
			}
    	)
    }
    
    function getPermission() {
    	console.log($scope.lang);
		PermissionService.getByRoleId({
			lang:$scope.lang
		}).then (
				function (data) {
					$scope.permissionList = data.module;
					$scope.user = data.user;
				},
				function (error) {
					//toaster.pop('Error occurs', 'Networking', '(' + error.errorCode + ') : ' + error.errorText);
				}
		);
	}
	
	getPermission();
    
    });

