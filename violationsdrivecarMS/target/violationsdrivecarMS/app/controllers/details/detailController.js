
/**
 * 
 */

'use strict';
angular.module('app.core').controller('DetailController',
    function ($rootScope, $scope, $log,toaster,$filter,DetailService,$location,$cookieStore, $translate) {
	
	function showDealsDetail() {
		DetailService.getbatchs({
			pageSize:1000,
		}).then( function(data) {
			console.log(data.entries);
			$scope.batchinfo = data.entries;
			document.getElementById('showJson').innerHTML = $filter('json')(data);
		},function (error) {
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
	}
	
	$scope.toDetail = function(id) {
		$rootScope.dealId = id;
		var exp = new Date();
		var trixVal1,trixVal2;
		exp.setMinutes(exp.getMinutes() + 30);
		$cookieStore.put('dealId', $rootScope.dealId, { expires: exp });
		console.log(id);
		$location.path('/batchDetail');
    };
	
	showDealsDetail();
});

