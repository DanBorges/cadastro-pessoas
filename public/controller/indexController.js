var moduleIndexVar = angular.module('moduleIndex', ['ui.bootstrap', 'ngRoute', 'ngCookies', 'angular-md5']);

moduleIndexVar.directive('directiveModalAdicionarPessoa', function() {
    return {
        templateUrl : 'assets/directives/directiveModalAdicionarPessoa.html'
    };
});

moduleIndexVar.directive('directiveModalEditarPessoa', function() {
    return {
        templateUrl : 'assets/directives/directiveModalEditarPessoa.html'
    };
});

moduleIndexVar.directive('directiveModalDeletarPessoa', function() {
    return {
        templateUrl : 'assets/directives/directiveModalDeletarPessoa.html'
    };
});


moduleIndexVar.controller('indexController', ['$rootScope', '$scope', '$http', '$modal', '$timeout', '$window', '$cookies', '$location', 'md5',
                                              function($rootScope, $scope, $http, $modal, $timeout, $window, $cookies, $location, md5) {

	$scope.pessoaList = [];
	findTabelaPessoas();
	
	function findTabelaPessoas() {
		$http.get('/pessoaController/findAllPessoas').
		success(function(responseData) {
			$scope.pessoaList = responseData;
		});
	}
	
	$scope.abrirModalAddPessoa = function() {
		var modalInstance = $modal.open({
            templateUrl: 'idModalAdicionarPessoa',
            controller: modalControlerAdicionarPessoa,
            size: 'md',
        });
		
		

		modalInstance.result.then(function (response) {
			
			$scope.alertaSistemaTemplate.message = response.data.message;
        	$scope.alertaSistemaTemplate.type = response.data.type;
        	$scope.alertaSistemaTemplate.show = true;
        	$scope.alertaSistemaTemplate.icon = response.data.icon;
			$timeout(function() { $scope.alertaSistemaTemplate.show = false; }, 5000);
			

			findTabelaPessoas();
			
			
		}, function (parametro) {
	    });
	};
	
	
	$scope.abrirModalEditarPessoa = function(pessoa) {
		
		var modalInstance = $modal.open({
            templateUrl: 'idModalEditarPessoa',
            controller: modalControlerEditarPessoa,
            size: 'md',
	       
            resolve: {
	        	pessoaParametro: function () {
	        		return pessoa;
	        	}
	        }
	    });


		
		modalInstance.result.then(function (response) {
			
			
			$scope.alertaSistemaTemplate.message = response.data.message;
        	$scope.alertaSistemaTemplate.type = response.data.type;
        	$scope.alertaSistemaTemplate.show = true;
        	$scope.alertaSistemaTemplate.icon = response.data.icon;
			$timeout(function() { $scope.alertaSistemaTemplate.show = false; }, 5000)
			

			findTabelaPessoas();
			
			
		},function (parametro) {
	    });
		
		
	};

	
	
	$scope.abrirModalDelatarPessoa = function(cpf) {
		
		console.log(cpf+"teste");

		var modalInstance = $modal.open({
            templateUrl: 'idAlertaDeletarPessoa',
            controller: modalControlerDeletarPessoa,
            size: 'md',
            resolve: {
                cpfParametro: function () {
                	console.log(cpf)
                    return cpf;
                }

            }
        });
		
		modalInstance.result.then(function (response) {
			
			$scope.alertaSistemaTemplate.message = response.data.message;
        	$scope.alertaSistemaTemplate.type = response.data.type;
        	$scope.alertaSistemaTemplate.show = true;
        	$scope.alertaSistemaTemplate.icon = response.data.icon;
			$timeout(function() { $scope.alertaSistemaTemplate.show = false; }, 5000);
			

			findTabelaPessoas();
			
			
		},function (parametro) {
	    });
		
	};


	

}]);




var modalControlerAdicionarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce) {


	$scope.ufList = [];

	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
		console.log ($scope.ufList);
	});
	
	var objPessoa = {};
	
	$scope.adicionarPessoa = function(){

		cpf = $scope.cpf;
		nome = $scope.nome;
		dia = $scope.dia;
		mes = $scope.mes;
		ano = $scope.ano;
		peso = $scope.peso;
		uf = $scope.uf.id;
		
		objPessoa.cpf = cpf;
		objPessoa.nome = nome;
		objPessoa.dia = dia;
		objPessoa.mes = mes;
		objPessoa.ano = ano;
		objPessoa.peso = peso;
		objPessoa.uf = uf;

		console.log(objPessoa);
		
		
		$http.post('/pessoaController/cadastrarPessoa',
				objPessoa).then(function(response) {
					$modalInstance.close(response);
		});
	}
	
	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};


var modalControlerEditarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce, pessoaParametro) {
	$scope.ufList = [];

	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
		console.log ($scope.ufList);
	});
	
	
	$scope.pessoa = {};
	
	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
		console.log ($scope.ufList);
	});
		
	$scope.pessoa = pessoaParametro;
	
	
	$scope.editarPessoa = function() {
		uf = $scope.pessoa.uf;
		pessoa.uf = uf;
		$http.post('/pessoaController/editarPessoa', $scope.pessoa).then(function(response) {
			$modalInstance.close(response);
		});
	};


	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};


var modalControlerDeletarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce, cpfParametro) {
	$scope.deletarPessoa = function(){
		console.log(cpfParametro+'var');
		$http.get('/pessoaController/deletarPessoa/'+cpfParametro).then(function(response) {
				$modalInstance.close(response);
		});
	}
	
	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};
