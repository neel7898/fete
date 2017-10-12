var app = angular.module("fete",['ngRoute','ngStorage']);


app.config(['$routeProvider',function($routeProvider){
	
	console.log("fete app");

	$routeProvider.
	when('/addRestaurant',{
		templateUrl: "html/restaurant/addRestaurant.html",
		controller: "restaurantConroller"
	}).
	when('/RegistrationSuccess',{
		templateUrl: "html/restaurant/RegistrationSuccess.html"
	}).
	when('/login',{
		templateUrl: "html/restaurant/Login.html",
		controller: "loginConroller"
	}).
	when('/userDashboard',{
		templateUrl: "jsp/userDashboard.jsp"
	}).
	when('/RestaurantDashBoard',{
		templateUrl: "html/restaurant/RestaurantDashBoard.html"
	}).when('/home',{
		templateUrl: "html/home.html"
	}).
	otherwise({
		redirectTo: 'home'
	});
}]);

app.run(function($rootScope) {
	$rootScope.sessionUser = sessionStorage.getItem("sessionUser");
});