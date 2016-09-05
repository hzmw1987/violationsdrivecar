/**
 * 
 */

'use strict';
angular.module('app.core').controller('UseVoucherController',
    function ($rootScope, $scope, $log,toaster, VoucherService, $location,$cookieStore) {
	
    var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.couponCode != undefined || $rootScope.locations != undefined || $rootScope.batchInfo != undefined){
		$cookieStore.put('couponCode', $rootScope.couponCode, { expires: exp });
		$cookieStore.put('locations', $rootScope.locations, { expires: exp });
		$cookieStore.put('batchInfo', $rootScope.batchInfo, { expires: exp });
	}else{
		$rootScope.couponCode = $cookieStore.get('couponCode');
		$rootScope.locations = $cookieStore.get('locations');
		$rootScope.batchInfo = $cookieStore.get('batchInfo');
	}
	
	$scope.couponCode = $rootScope.couponCode;
	$scope.locations = $rootScope.locations;
	$scope.batchInfo = $rootScope.batchInfo;
	
//	$scope.isShow = $rootScope.batchinfo.purchasePrice == 0 || $rootScope.batchinfo.purchasePrice == null || $rootScope.batchinfo.purchasePrice == undefined;
	
	$("#use-description").load($rootScope.batchInfo.description);
	$scope.backVouchers = function() {
		$location.path('/voucher');
	}
});