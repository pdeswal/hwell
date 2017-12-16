<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">REPORT</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.id" />
 					<div class="row">
	                    <div class="form-group col-md-12">	                        
							<button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Card Sensor</button>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.name" id="uname" class="username form-control input-sm" placeholder="Enter your Card Sensor Details" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>             
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Power Consumption Summary</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Floor</th>
		                <th>Appliances</th>
		                <th>Utilizations</th>
						<th>Status</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="a in ctrl.getAllAppliancesData()">
		                <td>{{a.name}}</td>
		                <td>{{a.name}}</td>
		                <td>{{a.powerRating}}</td>
		                <td>{{a.status}}</td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
    </div>
</div>