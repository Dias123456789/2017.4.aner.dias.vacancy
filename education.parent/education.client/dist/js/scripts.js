// angular.module('MyApp', ['ui.router','ngCookies','btford.socket-io', 'ngMessages','mgcrea.ngStrap'])
angular.module('MyApp', ['ui.router'])
    .config(['$locationProvider','$urlRouterProvider', '$stateProvider' ,function($locationProvider,$urlRouterProvider,$stateProvider) {
        console.log("We are here");
        $locationProvider.html5Mode(true);
        $urlRouterProvider.otherwise('/');
        $stateProvider
            .state('log', {
                url: '/',
                templateUrl: '../views/log.html',
                controller: function($scope,$rootScope,$state,$http) {

                    $scope.mainSelectedId = null;
                    $scope.disButtons = true;
                    $scope.newuser = function () {
                        var data = {
                            "UserN": $scope.selectedUserN,
                            "UserS": $scope.selectedUserS,
                            "Email": $scope.selectedEmail,
                            "Password": $scope.selectedPassword,
                            "Activate": "0"
                        };
                        $http.post("http://localhost:1314/education/api/reg/NewUser", data, {
                            headers: {
                                'Content-Type': "x-www-form-urlencoded"
                            }
                        }).then(function (response) {
                            console.log(data);
                            console.log(response.data);
                            $scope.selectedUserN = null;
                            $scope.selectedUserS = null;
                            $scope.selectedEmail = null;
                            $scope.selectedPassword = null;
                            $scope.selectedActivate = null;
                            $scope.disButtons = true;
                            $scope.list();
                        });
                    }



                    $scope.userlog = function (UserN, Password,Activate) {
                        var data = {
                            "UserN": $scope.selectedUserL,
                            "Password": $scope.selectedPas
                        };
                        $http.post("http://localhost:1314/education/api/reg/NewUser", data, {
                            headers: {
                                'Content-Type': "x-www-form-urlencoded"
                            }
                        }).then(function (response) {
                            console.log(data);
                            console.log(response.data);
                            $scope.selectedUserL = null;
                            $scope.selectedPas = null;
                            $scope.disButtons = true;
                            $scope.list();
                        });

                    }

                    $scope.useredit = function () {
                        var data = {
                            "active" : $scope.selectedActivate
                        };

                        $http.post("http://localhost:1314/education/api/reg/NewUser",data,{
                            headers:{
                                'Content-Type': "x-www-form-urlencoded"
                            }
                        }).then(function(response){
                            console.log(data);
                            console.log(response.data);
                            $scope.selectedActivate=null;
                            $scope.disButtons=true;
                            $scope.list();
                        });
                    }



                }
            })


            .state('any', {
                url: '/',
                templateUrl: '../views/clientList.html',
                controller: function($scope,$rootScope,$state,$http){
                    $scope.mainSelectedId = null;



                    $scope.disButtons = true;
                    $scope.list=function(){
                        $http({
                            method: 'POST',
                            url: 'http://localhost:1314/education/api/client/list'
                        }).then(function successCallback(response) {
                            console.log("Http request run");


                            $scope.data = response.data;


                            console.log(response.data);
                        }, function errorCallback(response) {
                        });
                    }
                    $scope.myFunc = function(id) {
                        if($scope.mainSelectedId==id){
                            $scope.mainSelectedId=null;
                            $scope.selectedName=null;
                            $scope.selectedSurname=null;
                            $scope.selectedPatr=null;
                            $scope.selectedAge=null;
                            $scope.disButtons=true;
                        }
                        else {
                            $scope.mainSelectedId = id;
                            $scope.disButtons = false;
                            for (var i = 0; i < $scope.data.length; i++) {
                                if ($scope.data[i].id == $scope.mainSelectedId) {
                                    $scope.mainSelectedId=$scope.data[i].id;
                                    $scope.selectedName=$scope.data[i].name;
                                    $scope.selectedSurname=$scope.data[i].surname;
                                    $scope.selectedPatr=$scope.data[i].patr;
                                    $scope.selectedAge=$scope.data[i].age;
                                }
                            }
                        }
                        console.log("We select id: "+id);
                    }


                    $scope.delete = function (id) {
                        var data = {
                            "id" : ""+id
                        };

                        $http.post("http://localhost:1314/education/api/client/delete",data,{
                            headers:{
                                'Content-Type': "x-www-form-urlencoded"
                            }
                        }).then(function(response){
                            console.log(data);
                            console.log(response.data);
                            $scope.mainSelectedId=null;
                            $scope.selectedName=null;
                            $scope.selectedSurname=null;
                            $scope.selectedPatr=null;
                            $scope.selectedAge=null;
                            $scope.disButtons=true;
                            $scope.list();
                        });
                    }



                    $scope.add = function () {
                        var data = {
                            "id" : "",
                            "name" : $scope.selectedName,
                            "surname" : $scope.selectedSurname,
                            "patr" : $scope.selectedPatr,
                            "age" : $scope.selectedAge
                        };

                        $http.post("http://localhost:1314/education/api/client/add",data,{
                            headers:{
                                'Content-Type': "x-www-form-urlencoded"
                            }
                        }).then(function(response){
                            console.log(data);
                            console.log(response.data);
                            $scope.mainSelectedId=null;
                            $scope.selectedName=null;
                            $scope.selectedSurname=null;
                            $scope.selectedPatr=null;
                            $scope.selectedAge=null;
                            $scope.disButtons=true;
                            $scope.list();
                        });
                    }
                    $scope.edit = function () {
                        var data = {
                            "id" : $scope.mainSelectedId,
                            "name" : $scope.selectedName,
                            "surname" : $scope.selectedSurname,
                            "patr" : $scope.selectedPatr,
                            "age" : $scope.selectedAge
                        };

                        $http.post("http://localhost:1314/education/api/client/add",data,{
                            headers:{
                                'Content-Type': "x-www-form-urlencoded"
                            }
                        }).then(function(response){
                            console.log(data);
                            console.log(response.data);
                            $scope.mainSelectedId=null;
                            $scope.selectedName=null;
                            $scope.selectedSurname=null;
                            $scope.selectedPatr=null;
                            $scope.selectedAge=null;
                            $scope.disButtons=true;
                            $scope.list();
                        });
                    }

                    $scope.mainSelectedId=null;
                    $scope.selectedName=null;
                    $scope.selectedSurname=null;
                    $scope.selectedPatre=null;
                    $scope.selectedAge=null;

                    $scope.list();
                }
            })

        ;

    }]);
