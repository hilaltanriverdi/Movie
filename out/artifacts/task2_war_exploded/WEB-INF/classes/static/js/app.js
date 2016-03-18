var moviesModule = angular.module('moviesApp',[]);

moviesModule.controller('moviesController', function ($scope,$http) {
	
	var urlBase="http://localhost:8080";
	$scope.toggle=true;
	$scope.selection = [];
    $scope.movies = [];


	//$http.defaults.headers.get["Content-Type"] = "application/json";


    function findAllMovies() {

        //get all movies and display initially
        $http.get(urlBase + '/list').
            success(function (data) {

            $scope.movies = data;

                for (var i = 0; i < $scope.movies.length; i++) {

                        $scope.selection.push($scope.movies[i].filmId);

                }
                $scope.filmId="";
                $scope.filmName="";

                $scope.toggle='!toggle';
            });
    }

    findAllMovies();

	//add a new task
	$scope.addTask = function addTask() {
		alert("ekledim");
	};
		
	// toggle selection for a given task by task id
	  $scope.toggleSelection = function toggleSelection(movieUri) {
	    var idx = $scope.selection.indexOf(movieUri);

	    // is currently selected
        // HTTP PATCH to ACTIVE state
	    if (idx > -1) {
	      $http.patch(movieUri).
		  success(function(data) {
		      alert("Task unmarked");
              findAllTasks();
		    });
	      $scope.selection.splice(idx, 1);
	    }

	    // is newly selected
        // HTTP PATCH to COMPLETED state
	    else {
	      $http.patch(movieUri).
		  success(function(data) {
			  alert("Task marked completed");
              findAllTasks();
		    });
	      $scope.selection.push(movieUri);
	    }
	  };
	  

});

//Angularjs Directive for confirm dialog box
moviesModule.directive('ngConfirmClick', [
	function(){
         return {
             link: function (scope, element, attr) {
                 var msg = attr.ngConfirmClick || "Are you sure?";
                 var clickAction = attr.confirmedClick;
                 element.bind('click',function (event) {
                     if ( window.confirm(msg) ) {
                         scope.$eval(clickAction);
                     }
                 });
             }
         };
 }]);