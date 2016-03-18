

App.factory('FilmService', ['$http', '$q', function($http, $q){

    return {

        fetchAllFilms: function() {
            return $http.get('http://localhost:8080/list')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching films');
                        return $q.reject(errResponse);
                    }
                );
        },

        createFilm: function(film){
            return $http.post('http://localhost:8080/create', film)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating film');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateFilm: function(film, id){
            return $http.put('http://localhost:8080/update/'+id, film)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating film');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteFilm: function(id){
            return $http.delete('http://localhost:8080/delete/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting film');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);