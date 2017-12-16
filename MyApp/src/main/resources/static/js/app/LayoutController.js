'use strict';

angular.module('crudApp').controller('LayoutController',
    ['LayoutService', '$scope',  function( ReportService, $scope) {

        var self = this;
        self.report = {};
        self.reports=[];

        self.getAllAppliancesData = getAllAppliancesData;
        self.addApplianceData = addApplianceData;
        self.reset = reset;
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function addApplianceData(report) {
            console.log('About to Add Appliance Data');
            ReportService.addAppliance(report)
                .then(
                    function (response) {
                        console.log('Appliance Data is added successfully');
                        self.successMessage = 'Appliance Data is added successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while adding Appliance Data=');
                        self.errorMessage = 'Error while adding Appliance Data: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
        
        function getAllAppliancesData(){
            return ReportService.getAllppliancesData();
        }
        
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.report={};
            $scope.myForm.$setPristine(); //reset Form
        }
        
    }


]);