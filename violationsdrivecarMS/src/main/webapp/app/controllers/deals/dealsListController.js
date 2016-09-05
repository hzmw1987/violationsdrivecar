
/**
 * 
 */

'use strict';
angular.module('app.core').controller('DealsListController',
    function ($rootScope, $scope, $log,toaster,DealsService,$location) {
	
	$scope.orderPageChanged = function () {
    	refreshChannelList();
    };
    
    $scope.showDeal = function(batchId){
    	$rootScope.id = batchId;
    	$location.path('/deals/overview');
    }
    $scope.nowTime =Date.parse(new Date());
    
  //下拉加载分页数据
	$scope.deals = [];
	
	$scope.page = 1;
	$scope.nextPage = function(){
		console.log($scope.page>$scope.totalPage);
		if($scope.busy){
			return;
		}
		$scope.busy = true;
		queryDealList();
	}
	
    function queryDealList() {
    	DealsService.getDealListByPage({
    		pageNo:$scope.page,
    		pageSize:10
    	}).then(function (data) {
    		for(var i=0;i<data.page.list.length;i++){
    			$scope.deals.push(data.page.list[i]);
    		}
        	$scope.totalPage = data.page.totalPage;
    		$scope.page = $scope.page+1;
    		$scope.busy = false;
    		
    	}, function (error) {
    		toaster.pop('Error occurs', 'Networking' + error.errorText);
		});
    }
    
//    queryDealList();
});

