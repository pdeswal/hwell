var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/MyApp',
    USER_SERVICE_API : 'http://localhost:8080/MyApp/api/user/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'LayoutController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, ReportService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        ReportService.getAllReports().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

