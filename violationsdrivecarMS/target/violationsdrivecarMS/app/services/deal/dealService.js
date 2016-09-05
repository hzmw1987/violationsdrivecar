/**
 * 
 */

'use strict';
angular.module('app.services').factory('DealService', function ($http, $log, messageClient) {
    return {
        /**
         * 获取渠道列表
         * 
         */
        addBatch: function (params) {
            return messageClient.call('/deal/addDeal.json', params).then(function (data) {
                return data;
            });
        },
        getBatchByType: function (params) {
            return messageClient.call('/batch/showByCouponType.json', params).then(function (data) {
                return data;
            });
        },
        editBatch: function (params) {
            return messageClient.call('/deal/editDeal.json', params).then(function (data) {
                return data;
            });
        },
        getTotal: function (params) {
            return messageClient.call('/getTotal.json', params).then(function (data) {
                return data;
            });
        },
                
    };
});
