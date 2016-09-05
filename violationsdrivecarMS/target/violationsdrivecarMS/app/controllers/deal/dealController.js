/**
 * 
 */

'use strict';
angular.module('app.core').controller('dealController',
  function($rootScope, $scope, $log, toaster,$cookieStore, DealService,VendorsService,CategoriesService,
		  $location,$filter,$http,$q) {
	
	$scope.url = new Array("0","1","2");
	
	$scope.path = new Array();;
	var exp = new Date();
	var trixVal1,trixVal2;
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.bat != undefined || $rootScope.channelId || $rootScope.channelName){
		$cookieStore.put('bat', $rootScope.bat, { expires: exp });
		$cookieStore.put('channelId', $rootScope.channelId, { expires: exp });
	}else{
		$rootScope.bat = $cookieStore.get('bat');
		$rootScope.channelId = $cookieStore.get('channelId');
	}
	//修改时初始化数据
	$scope.channelId = $rootScope.channelId;
	$scope.bat = $rootScope.bat;
	console.log($scope.bat);
	if($scope.channelId == undefined && $scope.bat != undefined){
		$scope.channelId = $scope.bat.channelId;
	}
	
	$scope.queryCompanys = function() {
    	VendorsService.getChannelList({
      }).then(function(data) {
        $scope.channel = data.channel;
        $scope.count = data.count;
      }, function(error) {
    	  alert(error.errorText);
        toaster.pop('Error occurs', 'Networking' + error.errorText);
      });
    };
    
    $scope.gohistory = function(){
    	history.go(-1);
    }

    $scope.upload1 = function(){
    	if(document.getElementById('editor1') != null){
    		var trix1 = document.getElementById('editor1').value;
        	console.log(trix1 == "");
        	if(trix1 != ""){
        		trix1 = '<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"></head><body><div id="aaa">'+trix1+'</div></body></html>';
            	getFilePath(trix1,0);
        	}
    	}
    	
    }
    
    $scope.upload2 = function(){
    	if(document.getElementById('editor2') != null){
    		console.log(document.getElementById('editor2'));
        	var trix2 = document.getElementById('editor2').value;
        	if(trix2 != ""){
        		trix2 = '<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"></head><body><div id="bbb">'+trix2+'</div></body></html>';
            	getFilePath(trix2,1);
        	}
    	}
    }
    $scope.save = function(boo) {
    	if(boo){
    		return;
    	}
    	$scope.click = true;
    	
    	var file = document.querySelector('input[type=file]').files[0];
    	if(file != undefined){
    		getFilePath(file,2);
    	}else{
    		if($scope.url[1] != "1" && document.getElementById('editor2').value != document.getElementById('bbb').innerHTML){
        		$scope.url[1] = "1";
        	}
        	if($scope.url[0] != "0" && document.getElementById('editor1').value != document.getElementById('aaa').innerHTML){
        		$scope.url[0] = "0";
        	}
    		if($scope.url[0] == "0"){
    			$scope.upload1();
    		}else if($scope.url[1] == "1"){
    			$scope.upload2();
    		}else{
    			$scope.update();
    		}
    	}
    }
    
    $scope.save1 = function() {
      var payStartTime=$filter('date')($scope.payStartTime,'yyyy-MM-dd');
      var payEndTime=$filter('date')($scope.payEndTime,'yyyy-MM-dd');
      var startTime=$filter('date')($scope.startTime,'yyyy-MM-dd');
      var endTime=$filter('date')($scope.endTime,'yyyy-MM-dd');
      var payStartTimeMin = $filter('date')($scope.payStartTimeMin,'hh:mm');
      var payEndTimeMin = $filter('date')($scope.payEndTimeMin,'hh:mm');
      var startTimeMin = $filter('date')($scope.startTimeMin,'hh:mm');
      var endTimeMin = $filter('date')($scope.endTimeMin,'hh:mm');
      DealService.addBatch({
    	  description:$scope.url[0],
    	  condtionUrl:$scope.url[1],
    	  imageUrl:$scope.url[2],
    	  channelId: $scope.channelId,
    	  locations: $scope.check(),
    	  couponType : $scope.categorie.id,
    	  batchName:$scope.batchName,
    	  purchaseLimit:$scope.purchaseLimit,
    	  batchAmount:$scope.batchAmount,
    	  originalPrice:$scope.originalPrice,
    	  purchasePrice:$scope.purchasePrice,
    	  payStartTimes:payStartTime+" "+payStartTimeMin,
          payEndTimes:payEndTime+" "+payEndTimeMin,
          startTimes:startTime+" "+startTimeMin,
          endTimes:endTime+" "+endTimeMin,
  	}).then(function (data) {
  		history.go(-1);
     }, function (error) {
    	 alert(error.errorText);
         toaster.pop('Error occurs', 'Networking' + error.errorText);
     });
    };
    
    $scope.addFile = function(){
    	var value = document.getElementById('uploadFile').value;
   	    document.getElementById('test1').value=value.substring(value.lastIndexOf("\\")+1);
    }
    
    function getFilePath(fileList,i){
    	var imgFile = {};
    	var fd = new FormData();
    		var fd = new FormData();
    		 $scope.imgFile = fileList;
    	        fd.append('file', fileList); 
    	         $http({
    	              method:'POST',
    	              url:"requestUpload.json",
    	              data: fd,
    	              headers: {'Content-Type':undefined},
    	              transformRequest: angular.identity 
    	               })   
    	              .success( function ( data ){
    	                  $scope.path.push(data.body.path);
    	                  $scope.url[i] = data.body.url;
    	                  console.log($scope.url[i]);
    	                  upload(i);
    	                 }); 
     }
    
    function upload(i){
    	 var theFormFile=$scope.imgFile;
         var url=$scope.url[i];
         url=url?url:'';
         console.log(url);
         var callBack=imgcallBack;
    	 var XHR=null;
         if (window.XMLHttpRequest) {
             // 非IE内核
             XHR = new XMLHttpRequest();
         } else if (window.ActiveXObject) {
             // IE内核,这里早期IE的版本写法不同,具体可以查询下
             XHR = new ActiveXObject("Microsoft.XMLHTTP");
         } else {
             XHR = null;
         }
         if(XHR){
             XHR.open("PUT", url);
             if(!theFormFile.type){
                 XHR.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
             }
             XHR.onreadystatechange = function () {
                 if (XHR.readyState == 4 && XHR.status == 200) {
                     var resultValue = XHR.responseText;
                     uploadComplete(0);
                     XHR = null;
                 }
             }
             function uploadComplete(j,n,evt) {
            	 if($scope.url[0] == "0"){
         			$scope.upload1();
         		}else if($scope.url[1] == "1"){
         			$scope.upload2();
         		}else{
         			if($scope.click){
         				if(document.getElementById('channelId') == undefined){
             				$scope.update();
             	        }else{
             	        	$scope.save1();
             	        }
         			}
         		}
             }
             XHR.send(theFormFile);
         }
    }
    
    $scope.showSth = function(myVar){
      if(myVar == 'radio1'){
        $scope.radio1 = true;
      }else if(myVar == 'radio2'){
        $scope.radio2 = true;
      }else if(myVar == 'radio3'){
        $scope.radio3 = true; 
      }
    };
    $scope.hideSth = function(myVar){
      if(myVar == 'radio1'){
        $scope.radio1 = false;
      }else if(myVar == 'radio2'){
        $scope.radio2 = false;
      }else if(myVar == 'radio3'){
        $scope.radio3 = false; 
      }
    };
    
    $scope.showAdd = function(i) {
    	console.log(i);
    	if(i != 0){
    		$scope.location = "";
    	}else{
    		VendorsService.showChannelById({
    	        channelId: $scope.channelId,
    	        page:0,
    	      }).then(function(data) {
    	        $scope.location = data.location;
    	        $scope.batchinfo = data.batchinfo;
    	      }, function(error) {
    	        toaster.pop('Error occurs', 'Networking' + error.errorText);
    	      });
    	}
    };
    
    $scope.check = function() { //checkbox
      var checkboxNum = document.getElementsByClassName("location-all").length;
      var locationId = "";
      for (var i = 1; i < checkboxNum + 1; i++) {
        var hasCheckbox = document.getElementById("checkbox" + i);
        if (hasCheckbox.checked) {
        	locationId = locationId+hasCheckbox.value+",";
        } 
      }
      return locationId;
    };
    $scope.queryCategories = function() {
    	CategoriesService.getCatelList({}).then(function(data) {
        $scope.categories = data.category;
      }, function(error) {
        toaster.pop('Error occurs', 'Networking' + error.errorText);
      });
    };
    
    $scope.update = function (){
    	
        	var payStartTime=$filter('date')($scope.payStartTime,'yyyy-MM-dd');
            var payEndTime=$filter('date')($scope.payEndTime,'yyyy-MM-dd');
            var startTime=$filter('date')($scope.startTime,'yyyy-MM-dd');
            var endTime=$filter('date')($scope.endTime,'yyyy-MM-dd');
            var payStartTimeMin = $filter('date')($scope.payStartTimeMin,'hh:mm');
            if(payStartTimeMin == undefined){
            	payStartTimeMin = "00:00";
            }
            var payEndTimeMin = $filter('date')($scope.payEndTimeMin,'hh:mm');
            if(payEndTimeMin == undefined){
            	payEndTimeMin = "00:00";
            }
            var startTimeMin = $filter('date')($scope.startTimeMin,'hh:mm');
            if(startTimeMin == undefined){
            	startTimeMin = "00:00";
            }
            var endTimeMin = $filter('date')($scope.endTimeMin,'hh:mm');
            if(endTimeMin == undefined){
            	endTimeMin = "00:00";
            }
            $scope.bat.payStartTimes=payStartTime+" "+payStartTimeMin;
            $scope.bat.payEndTimes=payEndTime+" "+payEndTimeMin;
            $scope.bat.startTimes=startTime+" "+startTimeMin;
            $scope.bat.endTimes=endTime+" "+endTimeMin; 
            $scope.bat.channelId = $scope.channelId;
            console.log();
            if(undefined != $scope.categorie.id){
            	$scope.bat.couponType = $scope.categorie.id;
            }
            $scope.bat.locations = $scope.check();
            $scope.bat.description = $scope.url[0],
            $scope.bat.condtionUrl = $scope.url[1],
            $scope.bat.imageUrl = $scope.url[2],
        	DealService.editBatch({
          	  batch:angular.toJson($scope.bat),
        	}).then(function (data) {
        		history.go(-1);
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    	
    }
    
    $scope.getName = function(){
    	var index = document.getElementById('categories').selectedIndex;
    	$scope.name = document.getElementById('categories').options[index].text;
    }
    
    $scope.init = function(){
    	console.log(document.getElementById('channelId'));
    	if(document.getElementById('channelId') != undefined){
       	    $scope.showAdd(1);
       	    $scope.url = new Array("0","1","2");
       	    $scope.payStartTime = new Date($filter('date')(new Date(),'yyyy/MM/dd'));;
       	    $scope.startTime = new Date($filter('date')(new Date(),'yyyy/MM/dd'));
       	    $scope.endTime = new Date($filter('date')(new Date(),'yyyy/MM/dd'));
       	    $scope.payStartTime = new Date($filter('date')(new Date(),'yyyy/MM/dd'));
        }else{
        	$scope.url[0] = $scope.bat.description;
    		$scope.url[1] = $scope.bat.condtionUrl;
    		$scope.url[2] = $scope.bat.imageUrl;
    		  var editorValue = $scope.bat.description + ' #aaa';
    		  var editCondtion = $scope.bat.condtionUrl+ ' #bbb';

    		  
    		  $scope.trixInitialize1 = function(e, editor) {
    			  $('#test').load(editorValue,function(){
    				  trixVal1 = $('#aaa').html();
    		      	  editor.setSelectedRange([0, 0]);
    		          editor.insertHTML(trixVal1);
    			      });
    		  }
    		  $scope.trixInitialize2 = function(e, editor) {
    			  $('#test1').load(editCondtion,function(){
    				  trixVal2 = $('#bbb').html();
    				  editor.setSelectedRange([0, 0]);
    			      editor.insertHTML(trixVal2);
    			      });
    		     
    		  }
    		$scope.payEndTime = new Date($filter('date')($scope.bat.payEndTime,'yyyy/MM/dd'));
    		var date = new Date($scope.bat.payEndTime).toString().split(' ')[4];
    		$scope.payEndTimeMin = date.substring(0,date.lastIndexOf(':'));
    		document.getElementById('payEndTimeMin').value = $scope.payEndTimeMin;
    		$scope.payStartTime = new Date($filter('date')($scope.bat.payStartTime,'yyyy/MM/dd'));
    		date = new Date($scope.bat.payStartTime).toString().split(' ')[4];
    		$scope.payStartTimeMin = date.substring(0,date.lastIndexOf(':'));
    		document.getElementById('payStartTimeMin').value = $scope.payStartTimeMin;
    		$scope.startTime = new Date($filter('date')($scope.bat.startTime,'yyyy/MM/dd'));
    		date = new Date($scope.bat.startTime).toString().split(' ')[4];
    		$scope.startTimeMin = date.substring(0,date.lastIndexOf(':'));
    		document.getElementById('startTimeMin').value = $scope.startTimeMin;
    		$scope.endTime = new Date($filter('date')($scope.bat.endTime,'yyyy/MM/dd'));
    		date = new Date($scope.bat.endTime).toString().split(' ')[4];
    		$scope.endTimeMin = date.substring(0,date.lastIndexOf(':'));
    		document.getElementById('endTimeMin').value = $scope.endTimeMin;
    		$scope.imageUrl = $scope.bat.imageUrl;
    		$scope.name =  $scope.bat.names;
    		if($scope.bat.batchAmount != 0){
    			$scope.radio2 = true;
    		}
    		if($scope.bat.purchaseLimit != 0){
    			$scope.radio3 = true;
    		}
    		if($scope.bat.purchasePrice != 0){
    			$scope.radio1 = true;
    		}
    		VendorsService.getLocation({
    			batchId : $scope.bat.batchId,
    	        channelId : $scope.channelId,
    	      }).then(function(data) {
    	         $scope.location = data.location;
    	         $scope.channelList = data.channel;
    	      }, function(error) {
    	        toaster.pop('Error occurs', 'Networking' + error.errorText);
    	      });
    		console.log($scope.bat);
    	}
    	
    }
   
    $scope.init();
    $scope.queryCategories();
    $scope.queryCompanys();
  });