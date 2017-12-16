var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/MyApp',
    REPORT_SERVICE_API : 'http://localhost:8080/MyApp/reportApi/report/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/report',
                controller:'LayoutController',
                controllerAs:'ctrl',
                resolve: {
                    reports: function ($q, ReportService) {
                        console.log('Load all report');
                        var deferred = $q.defer();
                        ReportService.getAllReports().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

