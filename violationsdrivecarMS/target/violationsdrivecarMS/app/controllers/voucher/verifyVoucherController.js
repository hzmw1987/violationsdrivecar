/**
 * 
 */

'use strict';
angular.module('app.core').controller('VerifyVoucherController',
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
	console.log($rootScope.batchInfo);
	$("#u414").load($rootScope.batchInfo.description);
	function UseVoucher() {
		VoucherService.useCouponCode({
			couponCode:$scope.couponCode,
		}).then(function(data) {
			$rootScope.couponCode = data.couponCode;
        	$rootScope.locations = data.locations;
        	$rootScope.batchInfo = data.batchInfo;
        	$location.path('/voucher/use');
		}, function (error) {
    		toaster.pop('Error occurs', 'Networking' + error.errorText);
    		alert(error.errorText);
		});
	}
	
	$scope.useVoucher = function() {
		UseVoucher();
	}
	
	$scope.backVoucher = function() {
		$location.path('/voucher');
	}
});