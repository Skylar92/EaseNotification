angular.module("application.registration", []).controller('registrationController', ['$scope', function ($scope) {

    $scope.customerRegistration = function (form) {
        console.log('send data to registration');
        if (!form.$valid) {
            console.log('invalid form');
            return;
        }
        console.log('valid!');
    }
}]);