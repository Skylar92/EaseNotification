(function () {

    var application = angular.module('application', [
        'ngRoute',
        'ui.bootstrap',
        'ui.bootstrap.modal',
        'application.services',
        'application.registration'
    ]);

    application.config(['$routeProvider', function ($routeProvider) {
        /**
         * Configuration router
         */
        $routeProvider
            .when('/services', {
                templateUrl: 'pages/services.html',
                controller: 'servicesController'
            })
            .when('/aboutUs', {
                templateUrl: 'pages/aboutUs.html',
                controller: 'defaultController'
            })
            .otherwise({
                redirectTo: '/',
                templateUrl: 'pages/home.html',
                controller: 'defaultController'
            });
    }]);

    application.run(['$rootScope', '$timeout', '$location', function ($rootScope, $timeout) {
        $rootScope.layout = {};

        $rootScope.$on('$routeChangeStart', function () {
            $timeout(function () {
                $rootScope.layout.loading = true;
            });
        });

        $rootScope.$on('$routeChangeSuccess', function () {
            $timeout(function () {
                $rootScope.layout.loading = false;
            }, 400);
        });

        $rootScope.$on('$routeChangeError', function () {
            console.log('Error on call spinner gif animation');
            $rootScope.layout.loading = false;
        });

    }]);

    application.factory('commonFactory', ['$http', function ($http) {

        return {
            getServices: function () {
                return $http.post('resources/common/services', []);
            }
        };
    }]);

    application.controller('defaultController', ['$scope', '$uibModal', function ($scope, $uibModal) {

        $scope.openRegistrationWindows = function () {
            $uibModal.open({
                animation: true,
                templateUrl: 'pages/registration.html',
                controller: 'registrationController'
            });
        };
    }])

})();
