/**
 * 
 */

app.controller("restaurantConroller", function($scope,$http,$location) {
	
	console.log("restaurant controller");
	
	
	$scope.register = function(rest){
		$http.post('rest/restaurant/addAddress',rest.address).success(function(data){
			console.log("Address added successfully");
		}).error(function(){
			console.log("Some error");
		});
		
		$http.post('rest/restaurant/add',rest).success(function(data){
			console.log("Restaurent added successfully");
			$location.path('/RegistrationSuccess');
		}).error(function(){
			console.log("Some error");
		});
	};
	
	$scope.verify = function(login){
		
		/*$http.post('rest/Login',login).success(function(){
			console.log('Login Successful');
			//$location.path('/RestaurantDashBoard');
		}).error(function(){
			console.log('some error while log in');
			alert('Wrong credentials! Try again')
		});*/
	};
	
	
});