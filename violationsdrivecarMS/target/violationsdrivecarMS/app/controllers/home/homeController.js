
/**
 * 
 */

'use strict';
angular.module('app.core').controller('HomeController',
    function ($rootScope, $scope, $log,toaster,PermissionService,UserService,$location,$translate) {
	
	$scope.lang =  $translate.use();
	/* Change languages with the language string */
    $scope.changeLanguage = function (key) {
    	if(key == undefined){
    		key = $translate.use();
    	}
    	$scope.lang = key;
    	getPermission();
        $translate.use(key);
        
    };

    /* Determine it is English or not */
    $scope.isEnUs = function () {
        return $translate.use() == "en_US";
    }

    /* Determine it is simplified Chinese or not */
    $scope.isZhCn = function () {
        return $translate.use() == "zh_CN";
    }

    /* Determine it is traditional Chinese or not */
//    $scope.isZhHant = function () {
//        return $translate.use() == "ja_JP";
//   }
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
					$scope.merchantName = data.merchantName;
					$scope.user = data.user;
				},
				function (error) {
					//toaster.pop('Error occurs', 'Networking', '(' + error.errorCode + ') : ' + error.errorText);
				}
		);
	}
	
	getPermission();
    
    });

