/**
 * 
 */

'use strict';
angular.module('app.services').factory('DealsService', function ($http, $log, messageClient) {
    return {
    	/**
         * 获取批次分页列表
         * 
         */
    	getDealListByPage: function (params) {
            return messageClient.call('/deal/queryDealListByPage.json', params).then(function (data) {
                return data;
            });
        },
        /**
         * 获取批次列表
         * 
         */
        getDealList: function (params) {
            return messageClient.call('/deal/queryDealList.json', params).then(function (data) {
                return data;
            });
        },
        /**
         * 获取批次详情
         * 
         */
        getDeal:function (params) {
            return messageClient.call('/deal/queryDeal.json', params).then(function (data) {
                return data;
            });
        }
        
    }
});
