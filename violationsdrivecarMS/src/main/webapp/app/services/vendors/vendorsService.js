/**
 * 
 */

'use strict';
angular.module('app.services').factory('VendorsService', function ($http, $log, messageClient) {
    return {
        /**
         * 获取渠道列表
         * 
         */
        getChannelList: function (params) {
            return messageClient.call('/vendors/showVendors.json', params).then(function (data) {
                return data;
            });
        },
        
        addVentor:function (params) {
            return messageClient.call('/vendors/addVendors.json', params).then(function (data) {
                return data;
            });
        },
        
        getAreaList:function(){
        	 return messageClient.call('/area/showAll.json').then(function (data) {
                 return data;
             });
        },
        showChannelById:function(params){
        	return messageClient.call('/vendors/showVendorById.json',params).then(function (data) {
                return data;
            });
        },
        editVentor:function (params) {
            return messageClient.call('/vendors/editVendors.json', params).then(function (data) {
                return data;
            });
        },
        commitUpload:function(params){
        	 return messageClient.call('/commitUpload.json', params).then(function (data) {
                 return data;
             });
        },
        getLocation:function(params){
        	return messageClient.call('/showLocation.json', params).then(function (data) {
                return data;
            });
        }
        
        
    }
});
