var applicationServices = angular.module("application.services", []);

applicationServices.controller('servicesController', ['$scope', 'commonFactory', function ($scope, commonFactory) {
    commonFactory.getServices().then(
        function (response) {
            $scope.services = response.data.services;
        },

        function (response) {
            console.log(response);
        }
    );

}]);
