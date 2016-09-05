/**
 * 
 */

'use strict';
angular.module('app.services').factory('UserService', function ($http, $log, messageClient) {
    return {
        /**
         * 获取渠道列表
         * 
         */
        getUserList: function (params) {
            return messageClient.call('/users/showUsers.json', params).then(function (data) {
                return data;
            });
        },
        
        addUser:function (params) {
            return messageClient.call('/users/addUser.json', params).then(function (data) {
                return data;
            });
        },
        
        getRoleList:function(){
        	 return messageClient.call('/role/showAll.json').then(function (data) {
                 return data;
             });
        },
        editUser:function (params) {
            return messageClient.call('/users/editUser.json', params).then(function (data) {
                return data;
            });
        },
        editPassword:function (params) {
        	return messageClient.call('/users/editPassword.json', params).then(function (data) {
        		return data;
        	});
        },
        logout:function(){
        	return messageClient.call('/users/logout.json').then(function (data) {
                return data;
            });
        }
        
        
    }
});
