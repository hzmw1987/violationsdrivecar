/**
 * 
 */

'use strict';
angular.module('app.services').factory('CategoriesService', function ($http, $log, messageClient) {
    return {
        /**
         * 获取渠道列表
         * 
         */
        getCatelList: function (params) {
            return messageClient.call('/categories/showCategories.json', params).then(function (data) {
                return data;
            });
        },
        
        addCate:function (params) {
            return messageClient.call('/categories/addCategories.json', params).then(function (data) {
                return data;
            });
        },
        
        editCate:function(params){
        	 return messageClient.call('/categories/editCategories.json',params).then(function (data) {
                 return data;
             });
        },
        
    }
});
