

App.controller('FilmController', ['$scope', 'FilmService', function($scope, FilmService) {
    var self = this;
    self.film={id:null,filmname:'',filmtype:''};
    self.films=[];

    self.fetchAllFilms = function(){
        FilmService.fetchAllFilms()
            .then(
                function(d) {
                    self.films = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies');
                }
            );
    };

    self.createFilm = function(film){
        FilmService.createFilm(film)
            .then(
                self.fetchAllFilms,
                function(errResponse){
                    console.error('Error while creating Film.');
                }
            );
    };

    self.updateFilm = function(film, id){
        FilmService.updateFilm(film, id)
            .then(
                self.fetchAllFilms,
                function(errResponse){
                    console.error('Error while updating Film.');
                }
            );
    };

    self.deleteFilm = function(id){
        FilmService.deleteFilm(id)
            .then(
                self.fetchAllfilms,
                function(errResponse){
                    console.error('Error while deleting Film.');
                }
            );
    };

    self.fetchAllFilms();

    self.submit = function() {
        if(self.film.id===null){
            console.log('Saving New Film', self.film);
            self.createFilm(self.film);
        }else{
            self.updateFilm(self.film, self.film.id);
            console.log('Film updated with id ', self.film.id);
        }
        self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.films.length; i++){
            if(self.films[i].id === id) {
                self.film = angular.copy(self.films[i]);
                break;
            }
        }
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.film.id === id) {//clean form if the film to be deleted is shown there.
            self.reset();
        }
        self.deleteFilm(id);
    };


    self.reset = function(){
        self.film={id:null,filmname:'',filmtype:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);