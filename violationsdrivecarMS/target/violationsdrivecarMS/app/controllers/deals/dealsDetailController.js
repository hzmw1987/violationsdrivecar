
/**
 * 
 */

'use strict';
angular.module('app.core').controller('DealsDetailController',
    function ($rootScope, $scope, $log,toaster,DealsService,$location,$cookieStore, $translate) {
	
	var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.id != undefined) {
		$cookieStore.put('id', $rootScope.id, { expires: exp });
	} else {
		$rootScope.id = $cookieStore.get('id');
	}
	
	$scope.batchId = $rootScope.id;
	function showDealsDetail() {
		DealsService.getDeal({
			batchId:$scope.batchId,
		}).then( function(data) {
			$scope.batchinfo = data.deal;
			console.log($scope.batchinfo);
			$("#description").load($scope.batchinfo.description);
			$("#term-cond").load($scope.batchinfo.condtionUrl);
		},function (error) {
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
	}
	showDealsDetail();
	
	$scope.tohistory = function () {
		$rootScope.batchId = $scope.batchId;
		$location.path('/voucher/getVoucherList');
	}
});

