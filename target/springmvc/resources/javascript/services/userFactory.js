(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.factory('UserFactory', UserFactory);
	
        UserFactory.$inject = ['$http'];
	
	function UserFactory($http) {
		return {
			// Shared Properties
			properties: {
				currentUser: { }
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
			return $http.post("/springmvc/user/register", user);
		}
		function getUser(id) {
			return $http.get("/springmvc/user/" + id);
		}
		function getAllUsers() {
			return $http.get("/springmvc/user/getall");
		}
		function updateUser(user) {
			return $http.put("/springmvc/user/", user);
		}
    }
    
})();