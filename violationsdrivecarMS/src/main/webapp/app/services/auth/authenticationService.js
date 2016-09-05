/**
 * 
 */

'use strict';
angular.module('app.services')
    .factory('AuthenticationService', function ($log, $q, messageClient) {
        return {
        	/*getLoginUser: function () {
                return SessionService.getCurrentUser();
            },*/
            
            login: function (params) {
                return messageClient.call('/user/login.json', params).then(function (data) {
                    $log.info(JSON.stringify(data));
                	var user = data.user;
                    $log.info(JSON.stringify(data.user));
                    return data;
                });
            },
            exit: function () {
                return messageClient.call('/exit.json').then(function (data) {
                    return data;
                });
            }

        }
    });