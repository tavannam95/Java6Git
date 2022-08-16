const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function($scope, $http,) {
	$scope.cart = {
		items: [],
		add(id) {
			var item = this.items.find(i => i.id == id);

			if (item) {
				item.qty++;
				this.saveToLocalStogare();
			} else {
				$http.get(`/rest/products/${id}`).then(res => {
					res.data.qty = 1;
					this.items.push(res.data);
					this.saveToLocalStogare();
				});
			}
		},
		remove(id) {
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index,1);
			this.saveToLocalStogare();
		 },
		clear(id) { 
			this.items = [];
			this.saveToLocalStogare();
		},
		amt_of(item) { },
		get count() { 
			return this.items.map(i => i.qty)
						.reduce((total, qty) => total += qty, 0);
		 },
		get amount() {
			return this.items.map(i => i.qty * i.price)
						.reduce((total, qty) => total += qty, 0);
		 },
		saveToLocalStogare() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},
		loadFromLocalStogare() { 
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json):[];
		},
	}
	$scope.cart.loadFromLocalStogare();
	
	$scope.order = {
		createdate: new Date(),
		address: "",
		account: {username: $("#username").text()},
		get orderDetails(){
			return $scope.cart.items.map(i =>{
				return {
					product: {id: i.id},
					price: i.price,
					quantity: i.qty
				}
			});
		},
		purchase(){
			var order = angular.copy(this);
			$http.post("/rest/orders",order).then(res =>{
				alert("Đặt hàng thành công!");
				$scope.cart.clear();
				location.href = "/order/detail/" + res.data.id;
			}).catch(error =>{
				alert("Đặt hàng lỗi!");
				console.log(error);
			})
		}
	}	
	
})