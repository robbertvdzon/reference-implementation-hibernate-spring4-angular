'use strict';

angular.module('mswFrontendApp')

    .controller('MainCtrl', ['$scope','$rootScope','authService',  function ($scope, $rootScope, authService) {
        authService.checkLogin();
    }]
)

;
