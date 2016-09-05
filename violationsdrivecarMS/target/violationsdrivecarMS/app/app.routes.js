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
        }).when('/vendors', {
            templateUrl: 'app/views/vendors/vendorsList.html',
            controller: 'VendorsController'
        }).when('/vendors/new',{
        	templateUrl: 'app/views/vendors/newVendors.html',
        	controller: 'AddVendorsController'
        }).when('/vendor/overview',{
        	templateUrl: 'app/views/vendors/vendorDetail.html',
        	controller: 'VendorsDetailController'
        }).when('/categories',{
        	templateUrl: 'app/views/categories/categoriesList.html',
        	controller: 'CategoryController'
        }).when('/add/categories',{
        	templateUrl: 'app/views/categories/newCategory.html',
        	controller: 'AddCateController'
        }).when('/cate/overview',{
        	templateUrl: 'app/views/categories/cateDetail.html',
        	controller: 'CateDetailController'
        }).when('/edit/categories',{
        	templateUrl: 'app/views/categories/editCategory.html',
        	controller: 'AddCateController'
        }).when('/users',{
        	templateUrl: 'app/views/users/usersList.html',
        	controller: 'UserController'
        }).when('/user/new',{
        	templateUrl: 'app/views/users/newUser.html',
        	controller: 'AddUserController'
        }).when('/user/edit',{
        	templateUrl: 'app/views/users/editUser.html',
        	controller: 'AddUserController'
        }).when('/user/editPassword',{
        	templateUrl: 'app/views/users/editPassword.html',
        	controller: 'EditPasswordController'
        }).when('/deal',{
            templateUrl: 'app/views/deal/deal.html',
            controller: 'dealController'
        }).when('/vendors/edit',{
            templateUrl: 'app/views/vendors/editVendors.html',
            controller: 'AddVendorsController'
        }).when('/deals',{
            templateUrl: 'app/views/deals/dealList.html',
            controller: 'DealsListController'
        }).when('/deals/overview',{
        	templateUrl: 'app/views/deals/dealDetail.html',
            controller: 'DealsDetailController'
        }).when('/voucher',{
        	templateUrl: 'app/views/voucher/voucher.html',
            controller: 'VoucherController'
        }).when('/voucher/verify',{
        	templateUrl: 'app/views/voucher/verifyVoucher.html',
            controller: 'VerifyVoucherController'
        }).when('/voucher/use',{
        	templateUrl: 'app/views/voucher/userVoucher.html',
            controller: 'UseVoucherController'
        }).when('/voucher/getVoucherList',{
        	templateUrl: 'app/views/voucher/voucherList.html',
            controller: 'VoucherListController'
        }).when('/deal/edit',{
            templateUrl: 'app/views/deal/editDeal.html',
            controller: 'dealController'
        }).when('/home',{
            templateUrl: 'app/views/home.html',
            controller: 'TotalController'
        }).when('/buyDetail',{
            templateUrl: 'app/views/detail/batch.html',
            controller: 'DetailController'
        }).when('/batchDetail',{
            templateUrl: 'app/views/detail/detail.html',
            controller: 'DetailBatchController'
        }).when('/userCou',{
            templateUrl: 'app/views/detail/userCoupon.html',
            controller: 'UserCouponController'
        }).otherwise({
            redirectTo: '/home'
        });
        
        
       
        
       
        
        
    });
