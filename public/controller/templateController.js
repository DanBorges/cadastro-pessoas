var moduleTemplate = angular.module('moduleTemplate', [ 'ui.bootstrap', 'ngRoute', 'ngCookies',
                                                        'moduleIndex', 'smart-table']);

moduleTemplate.directive('directiveAlertaSistemaTemplate', function() {
    return {
        templateUrl : 'assets/directives/directiveAlertaSistema.html'
    };
});




moduleTemplate.config(function($routeProvider, $locationProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'assets/pages/index.html',
		controller  : 'indexController'
	}).otherwise({
        redirectTo: "/"
    });
});



moduleTemplate.controller('controllerTemplate', function($scope, $http, $modal, $timeout, $window, $location, $q, $cookies) {
		console.log("Chegou aquii");
     	$scope.alertaSistemaTemplate = {};
     	$scope.nomeUsuarioLogado = '';
     	$scope.navtitles = true;

     	
});




