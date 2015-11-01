'use strict';

angular.module('mswFrontendApp')
    .controller('menuCtrl', ['$scope', 'authService', '$http', function LoginCtrl($scope, authService, $http) {
        $scope.isAuth = function () {
            return authService.isAuthenticated();
        }

        $scope.logOff = function () {
            return authService.logOff();
        }

    }])

;
