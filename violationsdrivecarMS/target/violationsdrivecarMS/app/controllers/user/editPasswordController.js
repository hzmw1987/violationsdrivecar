
/**
 * 
 */

'use strict';
angular.module('app.core').controller('EditPasswordController',
    function ($rootScope, $scope, $log,toaster,UserService,$location) {
	
	$scope.checkPassword = function(){
		if($scope.password != $scope.repassword){
			alert("密码不一致");
		}
	}
	
	$scope.updatePassword = function() {
		UserService.editPassword({
			oldPassword:$scope.oldPassword,
			password:$scope.password
		}).then(function (data) {
			alert("请重新登陆");
    		$location.path('/home');
        }, function (error) {
        	alert(error.errorText);
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
	}
	$scope.back = function() {
		$location.path('/home');
	}
});

