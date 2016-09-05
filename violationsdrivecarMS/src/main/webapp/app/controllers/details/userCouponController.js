
/**
 * 
 */

'use strict';
angular.module('app.core').controller('UserCouponController',
    function ($rootScope, $scope, $log,toaster,$filter,DetailService,$location,$cookieStore, $translate) {
	
	$scope.isShow = false;
	
   $scope.showDealsDetail = function () {
		$scope.isShow = true;
		DetailService.getUserCoupon({
			user:$scope.telphone,
			pageSize:1000
		}).then( function(data) {
			$scope.coupon = data.entries;
			console.log($filter('json')(data));
			document.getElementById('showJson').innerHTML = $filter('json')(data);
		},function (error) {
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
	}
	
});

