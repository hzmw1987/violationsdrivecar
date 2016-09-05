

/**
 * 
 */

'use strict';
angular.module('app.core').controller('VoucherListController',
    function ($rootScope, $scope, $log,toaster,VoucherService,$location) {
    $scope.batchId;
    console.log($scope.batchId);
    $scope.className = true;
    $scope.className1 = false;
    $scope.ctrollShow = 'display-block';
    $scope.ctrollHide = 'display-none'; 
    // if($scope.className) {
    //     $scope.status = -1;
    // } else{
    //     $scope.status = -1;
    // }
    console.log($scope.status);  
    $scope.changeClass = function(x){console.log(x);
        if(x==0){
            $scope.className = true;
            $scope.className1 = false; 
            $scope.ctrollShow = 'display-block';
            $scope.ctrollHide = 'display-none';     
        }else{
            $scope.className = false;
            $scope.className1 = true;
            $scope.ctrollShow = 'display-none';
            $scope.ctrollHide = 'display-block';  
        }
        $scope.queryVoucher('');  
    }
    
    //下拉加载分页数据
	$scope.voucherList = [];
	
	$scope.page = 1;
	$scope.nextPage = function(){
		console.log($scope.page>$scope.totalPage);
		if($scope.page > $scope.totalPage){
			return;
		}
		$scope.busy = true;
		$scope.queryVoucher();
	}
	
	
    $scope.queryVoucher = function(batchId){
        if(!batchId){
            batchId = $scope.batchId;
        }
        if($scope.className) {
            $scope.status = -1;
        } else{
            $scope.status = 3;
        }  
        VoucherService.getVoucherList({
            status:$scope.status,
            batchId:batchId,
            startDate:'',
            endDate:'',
            pageNo:$scope.page,
            pageSize:3
        }).then(function(data){
        	for(var i=0;i<data.page.list.length;i++){
    			$scope.voucherList.push(data.page.list[i]);
    		}
        	$scope.totalPage = data.page.totalPage;
    		$scope.page = $scope.page+1;
    		$scope.busy = false;
        }, function (error) {
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    };
    $scope.queryDeal = function(){
        VoucherService.getDealList({

        }).then(function(data){
            $scope.dealList = data.dealList;console.log(data.dealList);
        }, function (error) {
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    };
    $scope.queryDeal();

    });