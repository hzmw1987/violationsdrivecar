/**
 * 
 */

'use strict';
angular.module('app.services')
    .factory('PermissionService', function ($log, $q, messageClient, AuthenticationService) {
        return {
            getByRoleId: function (params) {
            	// 根据userid获取其权限信息map
                return messageClient.call('/user/getJurisdiction.json',params).then(function (data) {
                    return data;
                });
            },
            
            checkBtnShow: function (btnid) {
            	// 根据传入的id标识，判断当前用户是否有此权限，没有则禁止该按钮显示
            	var user = AuthenticationService.getLoginUser();
            	var data = {
            		btnid:btnid.btnid,
            		roleid:user.roleid
            	};
                return messageClient.call('/permission/checkShow.do', data).then(function (data) {
                    return data;
                });
            }
        }
    });
