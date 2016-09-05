
/**
 * 
 */

'use strict';
angular.module('app.core').controller('DetailBatchController',
    function ($rootScope, $scope, $log,toaster,$filter,DetailService,$location,$cookieStore, $translate,$modal ) {
	
	var exp = new Date();
	var trixVal1,trixVal2;
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.batchId != undefined){
		$cookieStore.put('dealId', $rootScope.dealId, { expires: exp });
	}else{
		$rootScope.dealId = $cookieStore.get('dealId');
	}
	
	$scope.count = 1;
	function showDealsDetail() {
		console.log($rootScope.dealId)
		DetailService.getBatchDetail({
			dealId:$rootScope.dealId,
		}).then( function(data) {
			console.log(data);
			$scope.batchinfo = data;
			$scope.editorValue = $scope.batchinfo.description + ' #aaa';
			$scope.location = $scope.batchinfo.channelMsg.locations;
			console.log($scope.location.length);
			document.getElementById('showJson').innerHTML = $filter('json')(data);
			$scope.showDescription ();
		},function (error) {
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
	}
	$scope.time=30;
	$scope.toBuy = function(){
		DetailService.toBuy({
			user:$scope.telphone,
			count:$scope.count,
			dealId:$rootScope.dealId,
			validTime:$scope.time
			}).then(
    	  function(data){
    		console.log(data);
    		console.log($scope.location.length);
  			document.getElementById('showJson').innerHTML = $filter('json')(data);
  			$modal.open("aaaa")
    	  },
    	  function (error) {
    		  toaster.pop('Error occurs', 'Networking' + error.errorText);
			}
    	)
    }
	

	  
	  $scope.showDescription = function() {
		  $('#test').load($scope.editorValue,function(){
		      });
	  }
	  
	showDealsDetail();
});

