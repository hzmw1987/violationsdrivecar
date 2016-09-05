/**
 * 
 */

'use strict';
angular.module('app.services').factory('VoucherService', function ($http, $log, messageClient) {
    return {
        /**
         * 获取优惠券列表
         * 
         */
        getVoucherList: function (params) {
            return messageClient.call('/voucher/queryVoucherList.json', params).then(function (data) {
                return data;
            });
        },
        /**
         * 验码
         * 
         */
        verifyCouponCode:function (params) {
            return messageClient.call('/voucher/verifyCouponCode.json', params).then(function (data) {
                return data;
            });
        },
        /**
         * 用码
         * 
         */
        useCouponCode:function (params) {
        	return messageClient.call('/voucher/useCouponCode.json', params).then(function (data) {
        		return data;
        	});
        },
        getDealList: function (params) {
            return messageClient.call('/deal/queryDealList.json', params).then(function (data) {
                return data;
            });
        },
        
    }
});
