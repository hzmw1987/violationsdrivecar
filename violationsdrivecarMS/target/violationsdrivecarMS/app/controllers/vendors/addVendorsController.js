
/**
 * 
 */

'use strict';
angular.module('app.core').controller('AddVendorsController',
    function ($rootScope, $scope, $log,toaster,VendorsService,$location,$cookieStore,$http) {
	
	var arrayObj = new Array([0]);
	
	$scope.array = arrayObj;
	var dataform = null;
	var count = 0;
    var drawMap = 0;
    var deleteMap = 0;
    var lastMap = 0;
    var map,localSearch;
	
	$scope.location = [];
	$scope.local = [];
	var exp = new Date();
	exp.setMinutes(exp.getMinutes() + 30);
	if($rootScope.channelId != undefined || $rootScope.channelName != undefined){
		$cookieStore.put('channelId', $rootScope.channelId, { expires: exp });
		$cookieStore.put('channelName', $rootScope.channelName, { expires: exp });
	}else{
		$rootScope.channelId = $cookieStore.get('channelId');
		$rootScope.channelName = $cookieStore.get('channelName');
	}
	
	if($rootScope.update != undefined){
		$cookieStore.put('update', $rootScope.update, { expires: exp });
	}else{
		$rootScope.update = $cookieStore.get('update');
	}
	
	$scope.update = $rootScope.update;
	
	/**
	 * 删除某个地址
	 */
    $scope.removeItem = function(i) {
        deleteMap = 1;
        $scope.locationList.splice(i, 1);
        var testList = $scope.locationList.length;
        if (testList <= 0) {
            $('#container0').remove();
            $('#container').hide();
        } else {
            if (i == 0) {
                $('#container').css('display', 'none');
            }
            var j = 2;
            var poshh = $('#pos' + (i + 1)).val();
            if(poshh){
                deleteMap1(i,poshh,'del');  
            }else{
                $('#container'+i).html('');
                $('#resultLng'+i).val('');
                $('#resultLat'+i).val('');
            }
            var test = setInterval(function() {
                if (deleteMap == j) {
                    var h = i + 1;
                    j = j + 1;
                    var poshh = $('#pos' + h).val();
                    if(poshh){
                        deleteMap1(h,poshh,'del');   
                    }else{
                       $('#container'+h).html('');
                       $('#resultLng'+h).val('');
                       $('#resultLat'+h).val(''); 
                    }
                }
                if (deleteMap == 0) {
                    clearInterval(test);

                }
            }, 1000);
        }
    };
	
	$scope.channelId = $rootScope.channelId;
	$scope.channelName = $rootScope.channelName;
	
	$scope.addVentor = function (boo) {
		if(boo){
			return;
		}
		getFilePath();
    };
    
    $scope.addVentor1 = function () {
    		VendorsService.addVentor({
        		vendorName:$scope.vendorName,
        		locationList:JSON.stringify($scope.location),
        		path:$scope.uploadUrl,
        	}).then(function (data) {
        		$location.path('/vendors');
           }, function (error) {
        	   alert(error.errorText);
               toaster.pop('Error occurs', 'Networking' + error.errorText);
           });
    }
    
    $scope.back = function (){
    	$location.path('/vendors');
    }
    
    $scope.overView = function (){
    	$location.path('/vendor/overview');
    }
    
    $scope.getCityName = function(i){
    	 document.getElementById('citys'+i).style.visibility="hidden";
    }
    
    function getFilePath(){
    	var imgFile = {};
    	var fd = new FormData();
        var file = document.querySelector('input[type=file]').files[0];
        $scope.imgFile = file;
        fd.append('file', file); 
         $http({
              method:'POST',
              url:"requestUpload.json",
              data: fd,
              headers: {'Content-Type':undefined},
              transformRequest: angular.identity 
               })   
              .success( function ( data ){
                  $scope.uploadUrl = data.body.url;
                  $scope.path = data.body.path;
                  upload();
          }); 
     }
    
    function upload(){
    	 var theFormFile=$scope.imgFile;
         var url=$scope.uploadUrl;
         url=url?url:'';
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
                	 if($scope.update){
             			$scope.updateVentor1();
             		} else{
             			 $scope.addVentor1();
             		}
             }
             XHR.send(theFormFile);
         }
             
    }
    
    
    $scope.addFile = function(){
    	var value = document.getElementById('fileFiled').value;
   	    document.getElementById('textfield').innerHTML=value.substring(value.lastIndexOf("\\")+1);
    	dataform = new FormData();
    	dataform.append("file",document.getElementById('fileFiled').value);
    }
    $scope.updateVentor =  function (boo) {
        console.log(JSON.stringify($scope.locationList))
    	if(boo){
    		return;
    	}
    	if(document.querySelector('input[type=file]').files[0] == undefined){
    		$scope.uploadUrl = "";
    		$scope.updateVentor1();
    	}else{
    		getFilePath();
    	}
    }
    
 $scope.updateVentor1 = function () {
	 console.log(JSON.stringify($scope.locationList));
    	VendorsService.editVentor({
    		channelId:$scope.channelId,
    		vendorName:$scope.channelName,
    		path:$scope.uploadUrl,
    		locationList:JSON.stringify($scope.locationList),
    	}).then(function (data) {
    		$location.path('/vendors');
       }, function (error) {
    	   alert(error.errorText);
           toaster.pop('Error occurs', 'Networking' + error.errorText);
       });
    }
 /**
  * 添加地址
  */
 $scope.addlocation = function() {
	 if($scope.update){
		 $scope.location = {
		         englishAddress: "",
		         chineseAddress: "",
		         telphone: "",
		         city: "",
		         longitude:"",
		         latitude:"",
		         companyName:"",
		     };
		     $scope.locationList[$scope.locationList.length] = $scope.location;
     }else{
         $scope.addContainer();
		 arrayObj.push(arrayObj.length+1);
	 }
 }
    
    $scope.renderFinish = function() {
    	$scope.location1 ={englishAddress:"",chineseAddress:"",telphone:"",city:""};
    	$scope.addContainer();
        arrayObj.push(arrayObj.length + 1);
}
    $scope.map = function(self) {
        if($scope.update&&$scope.locationList.length==1||self.$index==0){
            $('#container').show();
            map = new BMap.Map('container');
        }else{
            map = new BMap.Map('container'+self.$index);
        }
        localSearch = new BMap.LocalSearch(map);
        map.centerAndZoom("北京", 12);
        map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
        map.addControl(new BMap.NavigationControl()); //添加默认缩放平移控件
        map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
        $scope.searchMap(self);
    };
    $scope.searchMap = function(self){
        map.clearOverlays(); //清空原来的标注
        var keyword = document.getElementById('pos'+self.$index).value;
        var companyName = $('#companyName'+self.$index).val();
        localSearch.setSearchCompleteCallback(function(searchResult) {
            var poi = searchResult.getPoi(0);
            if($scope.update){
                $scope.locationList[self.$index].longitude = poi.point.lng;
                $scope.locationList[self.$index].latitude = poi.point.lat;
            }else{
                $scope.location[self.$index].longitude = poi.point.lng;
                $scope.location[self.$index].latitude = poi.point.lat;
            }
            document.getElementById("resultLng"+self.$index).value = poi.point.lng;
            document.getElementById("resultLat"+self.$index).value = poi.point.lat;

            map.centerAndZoom(poi.point, 15);
            var marker = new BMap.Marker(new BMap.Point(poi.point.lng, poi.point.lat)); // 创建标注，为要查询的地方对应的经纬度
            map.addOverlay(marker);
            var content = '店名：'+companyName+'<br>地址：'+keyword;
            var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
            marker.addEventListener("click", function() {
                this.openInfoWindow(infoWindow);
            });
            marker.enableDragging();    
            marker.addEventListener("dragend", function(e){
                var conLength = $('#addMap').find('.location').length;
            if($scope.update){
                for(var i=0;i<conLength;i++){
                    if($('#pos'+i).val()){
                        var lastLat = e.currentTarget._lastPt.lat;
                        var changeLat = $scope.locationList[i].latitude;
                        if(lastLat == changeLat){
                           $scope.locationList[i].latitude = e.point.lat;
                           $scope.locationList[i].longitude = e.point.lng;
                           $('#resultLat'+i).val(e.point.lat);
                           $('#resultLng'+i).val(e.point.lng);
                           console.log($scope.locationList[i].latitude+'  '+$scope.locationList[i].longitude);
                           return;   
                        }    
                    }
                } 
            }else{
                for(var i=0;i<conLength;i++){
                    if($('#pos'+i).val()){
                        var lastLat = e.currentTarget._lastPt.lat;
                        var changeLat = $scope.location[i].latitude;
                        if(lastLat == changeLat){
                           $scope.location[i].latitude = e.point.lat;
                           $scope.location[i].longitude = e.point.lng;
                           $('#resultLat'+i).val(e.point.lat);
                           $('#resultLng'+i).val(e.point.lng);
                           console.log($scope.location[i].latitude+'  '+$scope.location[i].longitude);
                           return;   
                        }
                    }
                } 
            }       
            })
        });
        localSearch.search(keyword);
    };
    function deleteMap1(j,key,del){
        if($scope.locationList.length==1){
            $('#container').show();
            map = new BMap.Map('container');
        }else{
            map = new BMap.Map('container'+j);
        }
        var keyword = $('#pos'+j).val();
        var companyName = $('#companyName'+j).val();
        localSearch = new BMap.LocalSearch(map);
        map.centerAndZoom("北京", 12);
        map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
        map.addControl(new BMap.NavigationControl()); //添加默认缩放平移控件
        map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
        map.clearOverlays(); //清空原来的标注
        if(!key){
           return; 
        }
        localSearch.setSearchCompleteCallback(function(searchResult) {
                var lat = $scope.locationList[j].latitude;console.log(lat);
                var lng = $scope.locationList[j].longitude;
                var new_point = new BMap.Point(lng,lat);
                map.centerAndZoom(new_point, 15);
                var marker = new BMap.Marker(new_point);  // 创建标注
                map.addOverlay(marker);              // 将标注添加到地图中
                map.panTo(new_point);
                var content = '店名：'+companyName+'<br>地址：'+keyword;    
            var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
            marker.addEventListener("click", function() {
                this.openInfoWindow(infoWindow);
            });
            marker.enableDragging();    
            marker.addEventListener("dragend", function(e){
             var conLength = $('#addMap').find('.location').length;    
             for(var i=0;i<conLength;i++){
                if($('#pos'+i).val()){
                    var lastLat = e.currentTarget._lastPt.lat;
                    var changeLat = $scope.locationList[i].latitude;
                    if(lastLat == changeLat){
                       $scope.locationList[i].latitude = e.point.lat;
                       $scope.locationList[i].longitude = e.point.lng;
                       $('#resultLat'+i).val(e.point.lat);
                       $('#resultLng'+i).val(e.point.lng);
                       console.log($scope.locationList[i].latitude+'  '+$scope.locationList[i].longitude);
                       return;   
                    }
                }
             }
 
            });
            if(del == 'del'){
              deleteMap = deleteMap +1;
              if(deleteMap == $scope.locationList.length+1){
                  deleteMap = 0;
              }  
            }

        });
        localSearch.search(key);
    }

    function showMap(j,companyName,keyword,lat,lng){
        map = new BMap.Map('container'+j);
        localSearch = new BMap.LocalSearch(map);
        map.centerAndZoom("北京", 12);
        map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
        map.addControl(new BMap.NavigationControl()); //添加默认缩放平移控件
        map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
        map.clearOverlays(); //清空原来的标注
        if(!lat){
           return; 
        }
        localSearch.setSearchCompleteCallback(function(searchResult) {
            console.log(lat)
            var new_point = new BMap.Point(lng,lat);
            console.log(new_point)
            map.centerAndZoom(new_point, 15);
            var marker = new BMap.Marker(new_point);  // 创建标注
            map.addOverlay(marker);              // 将标注添加到地图中
            map.panTo(new_point); 
            var content = '店名：'+companyName+'<br>地址：'+keyword;
            var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>" + content + "</p>");
            marker.addEventListener("click", function() {
                this.openInfoWindow(infoWindow);
            });
            marker.enableDragging();    
            marker.addEventListener("dragend", function(e){ 
             var conLength = $('#addMap').find('.location').length;   
             for(var i=0;i<conLength;i++){
                if($('#pos'+i).val()){
                    var lastLat = e.currentTarget._lastPt.lat;
                    var changeLat = $scope.locationList[i].latitude;
                    if(lastLat == changeLat){
                       $scope.locationList[i].latitude = e.point.lat;
                       $scope.locationList[i].longitude = e.point.lng;
                       $('#resultLat'+i).val(e.point.lat);
                       $('#resultLng'+i).val(e.point.lng);
                       console.log($scope.locationList[i].latitude+'  '+$scope.locationList[i].longitude);
                       return;   
                    }
                }
             }
    
            });
            drawMap = drawMap + 1;
            if(drawMap == $scope.locationList.length){
                drawMap = 0;
            }
        });
        localSearch.search(lat,lng);
    }
    $scope.toNew = function(){
    	$location.path('/vendors/new');
    }
    
    function getAreaList(){
    	VendorsService.getAreaList({
    		
    	}).then(function (data){
    		$scope.areaList = data.area;

    	}, function (error) {
    		 alert(error.errorText);
            toaster.pop('Error occurs', 'Networking' + error.errorText);
        });
    }
    
    function showChannel(){
    	if($scope.update){
        	VendorsService.showChannelById({
        		channelId:$scope.channelId,
        		page:0
        	}).then(function (data){
        		$scope.locationList = data.location;
                $scope.imageUrl = data.channel.logoPath;
                var lat = data.location[0].latitude;
                var lng = data.location[0].longitude;
                var companyName = data.location[0].companyName;
                var keyword = data.location[0].chineseAddress;
                showMap('',companyName,keyword,lat,lng);
               var myPot = false;
               var start = setInterval(function(){
                var conLength = $('#addMap').find('.location').length;
                if(conLength == $scope.locationList.length){
                    myPot = true;
                    if(myPot){
                        for(var j=1;j<$scope.locationList.length;j++){
                        var lat = data.location[j].latitude;
                        var lng = data.location[j].longitude;
                        var companyName = data.location[j].companyName;
                        var keyword = data.location[j].chineseAddress;
                        if(j == drawMap){
                            showMap(j,companyName,keyword,lat,lng);
                            if(drawMap == $scope.locationList.length-1) {
                                clearInterval(start);

                            }   
                        }
                        }           
                    }
                }
               },1000);
               
            }, function (error) {
                toaster.pop('Error occurs', 'Networking' + error.errorText);
            });
    	}
    	
    }
    $scope.addContainer = function(){
       count=count+1;
       var oldStyle=document.getElementById("container");
       var newTop = oldStyle.offsetTop + 443*count +'px';
       var addMap = document.createElement('div');
       addMap.id = 'container'+count;
       addMap.className = 'baidu-map';
       addMap.style.top = newTop;
       document.getElementById('addMap').appendChild(addMap); 
    }
    showChannel();
    
    getAreaList();

    }).directive('contenteditable', function() {//自定义ngModel的属性可以用在div等其他元素中
    return {
      restrict: 'A', // 作为属性使用
      require: '?ngModel', // 此指令所代替的函数
      link: function(scope, element, attrs, ngModel) {
        if (!ngModel) {
          return;
        } // do nothing if no ng-model
        // Specify how UI should be updated
        ngModel.$render = function() {
          element.html(ngModel.$viewValue || '');
        };
        // Listen for change events to enable binding
        element.on('blur keyup change', function() {
          scope.$apply(readViewText);
        });
        // No need to initialize, AngularJS will initialize the text based on ng-model attribute
        // Write data to the model
        function readViewText() {
          var html = element.html();
          // When we clear the content editable the browser leaves a <br> behind
          // If strip-br attribute is provided then we strip this out
          if (attrs.stripBr && html === '<br>') {
            html = '';
          }
          ngModel.$setViewValue(html);
        }
      }
    };
  })