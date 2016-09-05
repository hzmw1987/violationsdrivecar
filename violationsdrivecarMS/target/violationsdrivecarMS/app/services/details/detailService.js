/**
 * 
 */

'use strict';
angular.module('app.services').factory('DetailService', function ($http, $log, messageClient1) {
    return {
        /**
         * 获取渠道列表
         * 
         */
        getbatchs: function (params) {
            return messageClient1.call('/test/deals.json', params).then(function (data) {
                return data;
            });
        },
        getBatchDetail: function (params) {
            return messageClient1.call('/test/deals/info.json', params).then(function (data) {
                return data;
            });
        },
        toBuy: function (params) {
        	return messageClient1.call('/test/reserves.json', params).then(function (data) {
        		return data;
        	});
        },
        getUserCoupon: function (params) {
            return messageClient1.call('/test/vouchers.json', params).then(function (data) {
                return data;
            });
        },
    }
});
