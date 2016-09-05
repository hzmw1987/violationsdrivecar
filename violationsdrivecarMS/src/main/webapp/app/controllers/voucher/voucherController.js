
/**
 * 
 */

'use strict';
angular.module('app.core').controller('VoucherController',
    function ($rootScope, $scope, $log,toaster,VoucherService,$location) {
	
	$scope.orderPageChanged = function () {
    	refreshChannelList();
    };
    
    function VerifyCouponCode() {
    	VoucherService.verifyCouponCode({
    		couponCode:$scope.voucherCode,
    	}).then(function (data) {
    		$rootScope.couponCode = data.couponCode;
        	$rootScope.locations = data.locations;
        	$rootScope.batchInfo = data.batchInfo;
        	$location.path('/voucher/verify');
    	}, function (error) {
    		toaster.pop('Error occurs', 'Networking' + error.errorText);
    		alert(error.errorText);
		});
    }
    
    $scope.verifyVoucher = function() {
    	if ($scope.voucherCode == undefined || $scope.voucherCode == null || $scope.voucherCode == '') {
    		toaster.pop('Error occurs', 'Networkingthe voucher is not exist！');
    		alert('the voucher is not exist！');
    	} else {
    		VerifyCouponCode();
    	}
    	
	}
});

