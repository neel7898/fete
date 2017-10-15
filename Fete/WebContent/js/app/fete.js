var app = angular.module("fete",['ngRoute','ngStorage']);


app.config(['$routeProvider',function($routeProvider){
	
	console.log("fete app");

	$routeProvider.
	when('/addRestaurant',{
		templateUrl: "html/restaurant/addRestaurant.html",
		controller: "restaurantConroller"
	}).	when('/RegistrationSuccess',{
		templateUrl: "html/restaurant/RegistrationSuccess.html"
	}).	when('/login',{
		templateUrl: "html/restaurant/Login.html",
		controller: "loginConroller"
	}).	when('/userDashboard',{
		templateUrl: "jsp/userDashboard.jsp"
	}).when('/RestaurantDashBoard',{
		templateUrl: "html/restaurant/RestaurantDashBoard.html"
	}).when('/home',{
		templateUrl: "html/home.html"
	}).when('/accountDetails',{
		templateUrl: "jsp/accountDetails.jsp",
		controller: "accountController"
	}).when('/myBookings',{
		templateUrl: "jsp/myBookings.jsp"
	}).when('/myHall',{
		templateUrl: "jsp/myHall.jsp"
	}).when('/myMenu',{
		templateUrl: "jsp/myMenu.jsp"
	}).when('/myDjDetails',{
		templateUrl: "jsp/djDetails.jsp"
	}).when('/myDecoration',{
		templateUrl: "jsp/myDecoration.jsp"
	}).when('/myPackages',{
		templateUrl: "jsp/partyPackages.jsp"
	}).when('/myCoupon',{
		templateUrl: "jsp/discount.jsp"
	}).when('/myTransport',{
		templateUrl: "jsp/transportation.jsp"
	}).when('/otherServices',{
		templateUrl: "jsp/otherServices.jsp"
	}).when('/address',{
		templateUrl: "jsp/location.jsp"
	}).
	otherwise({
		redirectTo: 'home'
	});
}]);

app.run(function($rootScope) {
	$rootScope.sessionUser = sessionStorage.getItem("sessionUser");
});