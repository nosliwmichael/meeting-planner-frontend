(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.factory('UserFactory', UserFactory);
	
    UserFactory.$inject = ['$http'];
    
    let BASE_URL = '/meeting-planner/';
    let API_URL = '/meeting-planner/api/user/';
	
	function UserFactory($http) {
		
		return {
			// Shared Properties
			properties: {
				currentUser: { id: 1 }
			},
			// Shared Methods
			methods : {
				createUser: createUser,
				getUser: getUser,
				getAllUsers: getAllUsers,
				updateUser: updateUser
			}
		};
		
		// Function Definitions
		function createUser(user) {
			return $http.post(BASE_URL + '/register/', user);
		}
		function getUser(id) {
			return $http.get(API_URL + id);
		}
		function getAllUsers() {
			return $http.get(API_URL);
		}
		function updateUser(user) {
			return $http.put(API_URL, user);
		}
		
    } // End of Factory
    
})();