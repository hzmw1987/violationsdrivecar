'use strict';
angular.module('app.config', []).config(
    function ($httpProvider) {
        $httpProvider.interceptors.push(function ($location, $log, $q) {
            function error(response) {
                if (response.status === 401) {
                    $log.error('You are unauthorised to access the requested resource (401)');
                } else if (response.status === 404) {
                    $log.error('The requested resource could not be found (404)');
                } else if (response.status === 500) {
                    $log.error('Internal server error (500)');
                }
                return $q.reject(response);
            }
            function success(response) {
                //Request completed successfully
                return response;
            }
            return function (promise) {
                return promise.then(success, error);
            }
        });

        //
        // $httpProvider.defaults.timeout = 10000;

        $httpProvider.defaults.withCredentials = true;

        $httpProvider.defaults.headers.post = {
            'Content-Type': 'application/x-www-form-urlencoded'
        };
    });
