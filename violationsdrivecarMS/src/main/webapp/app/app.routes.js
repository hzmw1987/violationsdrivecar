/**
 * 
 */

'use strict';

angular.module('app.routes', ['ngRoute'])
    .config(function ($routeProvider) {
        // 定义全局路由列表
        $routeProvider.when('/home', { 
            templateUrl: 'index.html',
            controller: 'HomeController'
        }).when('/login', { 
            templateUrl: 'login.html',
            controller: 'LoginController'
        }).when('/order/orderList', { 
        	templateUrl: 'OrderList.html',
        	controller: 'OrderListController'
        }).otherwise({
            redirectTo: '/home'
        });
        
        
       
        
       
        
        
    });
