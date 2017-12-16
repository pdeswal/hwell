'use strict';

angular.module('crudApp').factory('ReportService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            		getAllReports: getAllReports,
            		getAllAppliancesData: getAllAppliancesData,
            		addAppliance: addAppliance
            };

            return factory;

            function getAllReports() {
                console.log('Fetching all Appliance reports');
                var deferred = $q.defer();
                $http.get(urls.REPORT_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Appliance reports');
                            $localStorage.reports = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Appliance reports');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllAppliancesData(){
                return $localStorage.reports;
            }

            function addAppliance(report) {
                console.log('Adding Appliance Data');
                var deferred = $q.defer();
                $http.post(urls.REPORT_SERVICE_API, report)
                    .then(
                        function (response) {
                        	getAllppliancesData();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error Adding Appliance Data : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);