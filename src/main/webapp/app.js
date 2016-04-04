
var app = angular.module('myApp', ['ngMaterial','md.data.table']);
app.controller('myCtrl', function ($scope, $http) {
$scope.selected=[];
    $scope.listFilm = function listFilm() {
        $http
            .get("http://192.168.1.4:8080/movies")
            .then(function(response) {
                $scope.films = response.data;
            });
    },


        $scope.deleteFilm = function deleteFilm(id) {
            console.log("deleting " + id);
            $http
                .delete("http://192.168.1.4:8080/movies/" +id)
                .then(function (result) {
                    alert("Film deleted");
                    console.log("Film deleted", result.status, arguments);
                }, function () {
                    console.log("Reject", arguments);
                }, function () {
                    console.log("complete", arguments);
                });
        },



        $scope.addFilm = function addFilm(filmName,filmType){

            $http
                .post("http://192.168.1.4:8080/movies", {
                    filmName: filmName,
                    filmType: filmType

                })
                .then(function(data, status, headers) {
                    alert("Film added");

                });


        },


        $scope.updateFilm = function updateFilm(id,filmName,filmType) {
            console.log("updating " + id +" "+ filmName+" "+ filmType);
            $http
                .post("http://192.168.1.4:8080/movies",{
                    id: id,
                    filmName: filmName,
                    filmType: filmType
                })
                .then(function (result) {
                    console.log("Film updated", result.status, arguments);
                    alert("Film updated");
                }, function () {
                    console.log("Reject", arguments);
                }, function () {
                    console.log("complete", arguments);
                });

        },


        $scope.likeFilm = function likeFilm(id) {
            console.log("like " + id);
            $http
                .post("http://192.168.1.4:8080/movies/"+id+"/like")
                .then(function(data, status, headers) {
                    alert("Film liked");

                });
        },


        $scope.dislikeFilm = function dislikeFilm(id) {
            console.log("unlike " + id);
            $http
                .post("http://192.168.1.4:8080/movies/"+id+"/dislike")
                .then(function (result) {
                    alert("Film unliked");
                    console.log("Film unliked", result.status, arguments);
                }, function () {
                    console.log("Reject", arguments);
                }, function () {
                    console.log("complete", arguments);
                });
        },





    $scope.toggleCustom= function toggleCustom() {
        $scope.custom = true;
        $scope.toggleCustom = function () {
            $scope.custom = $scope.custom === false ? true : false;
        };

    }




});

