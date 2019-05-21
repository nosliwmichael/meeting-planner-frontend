(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.controller('UserController', UserController);
	
    UserController.$inject = ['UserFactory'];
	
	function UserController(UserFactory) {
        
        var vm = this;

        // Exposed Properties
        vm.currentUser = {};
        
        // Init
        getUser(1);
        
        function getUser(id) {
            UserFactory.methods.getUser(id)
            .then((response) => {
                vm.currentUser = response.data;
			})
			.catch((error) => {
				if (error.status == 204)
					console.log("Conflict Error: Meeting was not found.");
				else
					console.log(error);
			});
        }

    } // End of Controller

})();