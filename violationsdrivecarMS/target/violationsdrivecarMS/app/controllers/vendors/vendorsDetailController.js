
/**
 * 
 */

'use strict';
angular.module('app.core').controller('VendorsDetailController',
    function ($rootScope, $scope, $log,toaster,VendorsService,$location,$cookieStore) {
	
	$scope.nowTime =Date.parse(new Date());
	$scope.batchinfo = [];
	$scope.busy = false; 
	$scope.page = 1;
	$scope.nextPage = function(){
		console.log($scope.page>$scope.totalPage);
		if($scope.page > $scope.totalPage){
			return;
		}
		$scope.busy = true;
		showChannel();
	}

	
	var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.channelId != undefined || $rootScope.channelName != undefined){
		$cookieStore.put('channelId', $rootScope.channelId, { expires: exp });
		$cookieStore.put('channelName', $rootScope.channelName, { expires: exp });
	}else{
		$rootScope.channelId = $cookieStore.get('channelId');
		$rootScope.channelName = $cookieStore.get('channelName');
	}
	
	$scope.channelId = $rootScope.channelId;
	$scope.channelName = $rootScope.channelName;
    $scope.toEdit = function(){
    	$rootScope.update = true;
    	$location.path('/vendors/edit');
    }
    
    $scope.toNewDeal = function(){
    	$rootScope.channelId = $scope.channelId;
    	$rootScope.channelName = $scope.channelName;
    	$rootScope.isShow = true;
    	$location.path('/deal');
    }
    
    $scope.toEditDeal = function(bat,channelId){
    	$rootScope.bat = bat;
    	$rootScope.channelId = channelId;
    	$location.path('/deal/edit');
    }
    
    function showChannel(){
    	console.log($scope.channelId);
    	VendorsService.showChannelById({
    		channelId:$scope.channelId,
    		page:$scope.page
    	}).then(function (data){
    		$scope.location = data.location;
    		for(var i=0;i<data.batchinfo.length;i++){
    			$scope.batchinfo.push(data.batchinfo[i]);
    		}
    		$scope.totalPage = data.totalPage;
    		$scope.channel = data.channel;
    		$scope.page = $scope.page+1;
    		$scope.busy = false;
    	}, function (error) {
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
    }
    
    });

