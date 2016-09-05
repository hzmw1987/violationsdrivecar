
/**
 * 
 */

'use strict';
angular.module('app.core').controller('CateDetailController',
    function ($rootScope, $scope, $log,toaster,VendorsService,DealService,$location,$cookieStore) {
	
	$scope.busy = false; 
	$scope.nowTime =Date.parse(new Date());

	//保存controller传过来的参数
	var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.id != undefined || $rootScope.name != undefined){
		$cookieStore.put('id', $rootScope.id, { expires: exp });
		$cookieStore.put('name', $rootScope.name, { expires: exp });
	}else{
		$rootScope.id = $cookieStore.get('id');
		$rootScope.name = $cookieStore.get('name');
	}
	//下拉加载分页数据
	$scope.batchinfo = [];
	
	$scope.page = 1;
	$scope.nextPage = function(){
		console.log($scope.page>$scope.totalPage);
		if($scope.page > $scope.totalPage){
			return;
		}
		$scope.busy = true;
		$scope.getBatchByType();
	}
	
	$scope.name=$rootScope.name;
	console.log($scope.name);
    
    $scope.toEdit = function(){
    	$location.path('/edit/categories');
    }
    $scope.toNewDeal = function(){
    	$rootScope.channelName = "";
    	$location.path('/deal');
    }
    $scope.toEditDeal = function(bat){
    	$rootScope.channelId = bat.channelId;
    	$rootScope.bat = bat;
    	$location.path('/deal/edit');
    }
    
    $scope.getBatchByType = function(){
    	console.log($scope.page);
    	DealService.getBatchByType({
    		type:$rootScope.id,
    		page:$scope.page
    	}).then(function (data) {
       	for(var i=0;i<data.batchinfo.length;i++){
			$scope.batchinfo.push(data.batchinfo[i]);
		}
		$scope.totalPage = data.totalPage;
		$scope.channel = data.channel;
		$scope.page = $scope.page+1;
		$scope.busy = false;
       }, function (error) {
    	   alert(error.errorText);
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    }
    
   // $scope.getBatchByType();
    });

