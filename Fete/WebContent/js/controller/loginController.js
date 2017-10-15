/**
 * 
 */
app.controller("loginController", function($scope,$http,$location,$rootScope) {
	
	console.log("login controller");
	
	$scope.message = "Please enter your credentials below."
	
	$scope.login = {};
	
	$scope.idchk = isFinite($scope.login.feteId);
	
	$scope.loginUser = function(login){
		 $http({
		        url: 'rest/loginUser',
		        method: 'POST',
		        headers: {
		            'Content-Type': 'application/x-www-form-urlencoded'
		        }, params: {
		            id: login.feteId,
		            password: login.password,
		        }
		    }).success(function(data){
		    	console.log(data);
		    	if(data.substr(0, 7) == "success"){
		    	console.log('login successful');
		    	$("[data-dismiss=modal]").trigger({ type: "click" });
		    	$rootScope.sessionUser = true;
		    	sessionStorage.setItem("sessionUser",true);
		    	sessionStorage.setItem("feteId", data.substring(8))
		    	$location.path('/userDashboard');
		    	}else{
		    		alert(data);
		    		$('#message').css({"color":"red"});
		    	}
		    }).error(function(){});
	}

});