var cartApp = angular.module('cartApp', []); // module 이름

// scope과 http라는  module 의존성 주입
cartApp.controller("cartCtrl", function($scope, $http) { // controller 등록

	// cartId를 받아서 scope에 초기화 시키게 된다 -> refreshCart 호출
	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart();

	};

	
	// CartRestController의 메소드가 불린다
	
	$scope.refreshCart = function() {
		
		// get method를 사용해 요청
		// Sync -> 요청 후 응답이 올 때까지 기다린다
		// Async -> 요청 후 응답을 기다리지 않고 바로 리턴해버린다. 나중에 응답이 왔을때 적절하게 callback 함수 부른다.
		// 응답이 오면 알아서 successCallback 얘를 리턴해줘~ : callback function
		$http.get('/eStore/api/cart/' + $scope.cartId).then(
				function successCallback(response) {
					$scope.cart = response.data;
				});
	};

	// cart의 내용을 비우는 것
	$scope.clearCart = function() {
				
		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});

	};
	
	// cart에 담는 것
	$scope.addToCart = function(productId) {
				
		$http.put('/eStore/api/cart/cartItem/' + productId).then(
				function successCallback() {
					alert("Product successfully added to the cart!");

				}, function errorCallback() {
					alert("Adding to the cart failed!")
				});
	};

	$scope.removeFromCart = function(productId) {
		
		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/cartItem/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.calGrandTotal = function() {
		var grandTotal = 0;

		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}

		return grandTotal;
	};
	
});