'use strict';

angular.module('app.core').constant(
    'BASE_URL', 'http://localhost:8080/violationsdrivecarMS').provider('messageClient', {

        $get: function ($http, $log,toaster, $q, $location,$rootScope,$cookieStore, BASE_URL) {
        	
        	/*var exp = new Date();
        	exp.setMinutes(exp.getMinutes() + 30);
        	if($rootScope.lang != undefined){
        		$cookieStore.put('lang', $rootScope.lang, { expires: exp });
        	}else{
        		$rootScope.lang = $cookieStore.get('lang');
        	}*/
            return {
                /**
                 * 远程API调用统一入口
                 * 参数:
                 *      path: API http路径
                 *      params: HTTP参数key/value表
                 */
                call: function (path, params) {
                    var qs = '';
                    angular.forEach(params, function (value, key) {
                        if (value == null)
                            return;
                        if (qs.length > 0)
                            qs += '&';
                         qs += (encodeURIComponent(key) + '=' + encodeURIComponent(value));
                        /* if(encodeURIComponent(key) == "lang"){
                        	 $rootScope.lang = encodeURIComponent(value);
                         }*/
                    });
                    qs += "&lang="+$rootScope.lang;
                    var url = BASE_URL + path;
                 //   var url = 'violationsdrivecarMS' + path;
                    $log.info("url=" + url);
                    $log.info("qs=" + qs);

                    var delayResult = $q.defer();
                    var http = $http.post(
                        url,
                        qs
                    ).then(function (response) {
                        var status = response.data.respCode;
                        var body = response.data.body;
                       // var list = response.data.list;
                        //$log.info(list);
                        if(status == undefined){
                            window.location = "login.html";
                            delayResult.reject(status);
                        } else if(status == 300){
                        	 window.location = "login.html";
                             delayResult.reject(status);
                        }else if (status == 200) {
                        	delayResult.resolve(body);
                        	//delayResult.resolve(list);
                        }else {
                        	$log.info(response.data.reMark)
                        	delayResult.reject({
                                "errorCode": 500,
                                "errorText": response.data.reMark
                            });
                        }
                    }, function (errorResponse) {
                        var status = errorResponse.status;
                        $log.info(status+"   error status  ");
                        $log.error('XHR Failed for messageClient');
                        delayResult.reject({
                            "errorCode": 500,
                            "errorText": 'Request failed, ' + ((status == 0)
                                    ? ('unable to connect to server.')
                                            : ('server returns (' + status + ")."))
                        });
                    });
                    return delayResult.promise;
                },
            };
        }
    });
