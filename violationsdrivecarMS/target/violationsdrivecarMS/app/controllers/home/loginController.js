/**
 * 
 */

'use strict';
angular.module('app.core').controller('LoginController',
    function ($scope, $log, $location, toaster, AuthenticationService) {
        $scope.user = null;
        $scope.userLogin = function () {
            $log.info('login...');
            AuthenticationService.login(
            		$scope.user).then(
                function (data) {
                    // 登录成功
                    $log.info('login OK, user info:' + JSON.stringify(data.user));
                    window.location = 'index.html';
                },
                function (error) {
                	alert(error.errorText);
                });
        };
        $scope.exit = function () {
        	AuthenticationService.exit().then(
                    function (data) {
                        $log.info('exit OK');
                        window.location = 'login.html';
                    },
                    function (error) {
                        toaster.pop('Error occurs', 'Networking', '(' + error.errorCode + ') : ' + error.errorText);
                    });
        }
    });
