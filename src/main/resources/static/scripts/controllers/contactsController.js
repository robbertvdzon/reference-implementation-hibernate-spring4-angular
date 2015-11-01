'use strict';

angular.module('mswFrontendApp')

    .controller('ContactsCtrl', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {

        $scope.contacts = [];
        $scope.selectedcontact = {};
        $scope.newcontact = {};
        $scope.showEditContact = false;
        $scope.showNewContact = false;


        $scope.initialize = function () {
            $scope.loadData();
        }

        $scope.loadData = function () {
            {
            $http({
                url: "/rest/contacts/getContacts",
                method: "GET",
             }).success(
                   function (response) {
                       $scope.contacts = response;
                       $scope.selectedcontact = [];
                       $scope.newcontact = [];
               })
            }
        }

       $scope.edit = function (uuid) {
            for (var i = 0; i < $scope.contacts.length; i++) {
                  var contact = $scope.contacts[i];
                  if (contact.uuid===uuid) {
                       $scope.selectedcontact = {};
                       $scope.selectedcontact.uuid = contact.uuid;
                       $scope.selectedcontact.name = contact.name;
                       $scope.selectedcontact.email = contact.email;
                  }
            }
            $scope.showEditContact = true;
        }

       $scope.save = function () {
            $http({
                url: "/rest/contacts/",
                method: "POST",
                params: $scope.selectedcontact
             }).success(
                   function (response) {
                       $scope.reloadContacts(response);
               });
            $scope.showEditContact = false;

        }

       $scope.delete = function (uuid) {
            $http({
                url: "/rest/contacts/"+uuid,
                method: "DELETE",
                params: $scope.selectedcontact
             }).success(
                   function (response) {
                       $scope.reloadContacts(response);
               });
        }

       $scope.newContact = function () {
            $scope.showNewContact = true;
        }


       $scope.add = function () {
            var newContact = {};
            newContact.name = $scope.newcontact.name;
            newContact.email = $scope.newcontact.email;
            $http({
                url: "/rest/contacts/",
                method: "PUT",
                params: newContact
             }).success(
                   function (response) {
                       $scope.reloadContacts(response);
               });
            $scope.showNewContact = false;

        }

       $scope.cancel = function () {
            $scope.showEditContact = false;
            $scope.showNewContact = false;
        }


       $scope.reloadContacts = function (contacts) {
            $scope.contacts = contacts;
            $scope.selectedcontact = [];
            $scope.newcontact = [];
       }


        $scope.initialize();

    }]);
