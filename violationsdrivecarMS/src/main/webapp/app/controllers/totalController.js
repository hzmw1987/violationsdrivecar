
/**
 * 
 */

'use strict';
angular.module('app.core').controller('TotalController',
    function ($rootScope, $scope, $log,toaster,DealService,$location,$filter) {
	
    function init() {
    	DealService.getTotal().then (
				function (data) {
					$scope.purchase = data.purchase;
					$scope.used = data.used;
					$scope.totalCount = data.totalCount;
					$scope.revenue = data.revenue ;
					draw("purchase",$scope.purchase,$scope.totalCount);
					draw("redeemed",$scope.used,$scope.purchase);
					
					document.getElementById('money').innerHTML = "￥"+$scope.revenue;
					$scope.count = new Array();
					$scope.day = new Array();
					$scope.totalList = data.totalList;
					
					for(var i=0;i<$scope.totalList.length;i++){
						$scope.count.push($scope.totalList[i][0][1]);
						$scope.day.push($filter('date')($scope.totalList[i][0][0],'MM/dd'));
					}
					var sold = echarts.init(document.getElementById('sold'));
					var option = {
							backgroundColor: 'white',//背景色
						    title: {
						        text: 'Daily sales',
						    },
						    tooltip: {
						        trigger: 'axis'
						    },
						    toolbox: {
						        show: true,
						        feature: {
						            dataZoom: {
						                yAxisIndex: 'none'
						            },
						            dataView: {readOnly: false},
						            magicType: {type: ['line', 'bar']},
						            restore: {},
						            saveAsImage: {}
						        }
						    },
						    xAxis:  {
						        type: 'category',
						        boundaryGap: false,
						        data: $scope.day
						    },
						    yAxis: {
						        type: 'value',
						        axisLabel: {
						            formatter: '{value}'
						        }
						    },
						    series: [
						        {
						            type:'line',
						            data:$scope.count,
						            markPoint: {
						                data: [
						                    {type: 'max', name: '最大值'},
						                    {type: 'min', name: '最小值'}
						                ]
						            },
						            markLine: {
						                data: [
						                    {type: 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
					 sold.setOption(option);
				},
				function (error) {
					toaster.pop('Error occurs', 'Networking', '(' + error.errorCode + ') : ' + error.errorText);
				}
		);
	}
    
    function draw(id,count,totalCount){
    	 var myChart = echarts.init(document.getElementById(id));
    	 var option = {
    			 backgroundColor: 'white',//背景色
    			    tooltip: {
    			        trigger: 'item',
    			        formatter: "{a} <br/>{b}: {c} ({d}%)"
    			    },
    			    series: [
    			        {
    			            type:'pie',
    			            radius: ['50%', '70%'],
    			            avoidLabelOverlap: false,
    			            label: {
    			                normal: {
    			                    show: false,
    			                    position: 'center'
    			                },
    			                emphasis: {
    			                    show: true,
    			                    textStyle: {
    			                        fontSize: '30',
    			                        fontWeight: 'bold'
    			                    }
    			                }
    			            },
    			            labelLine: {
    			                normal: {
    			                    show: false
    			                }
    			            },
    			            data:[
    			                {value:count, name:count},
    			                {value:totalCount-count, name:totalCount-count},
    			            ],
    			            color:['red','grey']
    			        }
    			    ]
    			};
    	 
    	 myChart.setOption(option);
    	
    }
    
	init();
    
    });

