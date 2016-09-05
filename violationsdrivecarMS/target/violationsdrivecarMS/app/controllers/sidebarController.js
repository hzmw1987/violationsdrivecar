/**
 * 
 */

'use strict';
angular.module('app.core').controller('SidebarController',
    function ($rootScope, $scope, $log, $location) {
        $scope.path = '/home';
        $scope.groupClicked = null;
        
        $scope.clickGroup = function (group) {
        	if (group == '/vendors') {
                $scope.groupClicked = ($scope.groupClicked == '/vendors') ? null : '/vendors';
            } else if (group == '/upper') {
                $scope.groupClicked = ($scope.groupClicked == '/upper') ? null : '/upper';
            } else if (group == '/system') {
                $scope.groupClicked = ($scope.groupClicked == '/system') ? null : '/system';
            }  else if(group == '/down'){
            	$scope.groupClicked = ($scope.groupClicked == '/down') ? null : '/down';
            }  else if(group == '/statistic'){
            	$scope.groupClicked = ($scope.groupClicked == '/statistic') ? null : '/statistic';
            }   else if(group == '/up'){
            	$scope.groupClicked = ($scope.groupClicked == '/up') ? null : '/up';
            }else if(group == '/productShip'){
            	 $location.path('/productShip');
            }else if(group == '/toc'){
            	 $location.path('/toc');
            }
        }
        $scope.isOnThePath = function (path) {
        	var result = ($scope.path.indexOf(path) == 0);
            return result;
        }
        // 拦截路由改变事件, 用来控制菜单组展开状态.
        var reloadFirstTime = true;
        $rootScope.$on('$routeChangeSuccess', function () {
            $scope.path = $location.path();
            $log.info('$routeChangeSuccess : $scope.path changed to : ' + $scope.path);
            if (reloadFirstTime) {
                // 首次加载页面,通常为第一次打开页面或F5刷新. 这时候我们需要模拟一个菜单点击时间来展开菜单组
                var pathParts = $scope.path.split('/');
                if (pathParts.length > 1) {
                    $scope.clickGroup('/' + pathParts[1]);
                }
                reloadFirstTime = false;
            }
        });

    });
