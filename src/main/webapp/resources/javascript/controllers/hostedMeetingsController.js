(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.controller('HostedMeetingsController', HostedMeetingsController);
	
	HostedMeetingsController.$inject = ['MeetingFactory', 'UserFactory'];
	
	function HostedMeetingsController(MeetingFactory, UserFactory) {
		let vm = this;
		
		// Exposed Properties
		vm.hostedMeetings = [];
		vm.errorMessage = "";

		getHostedMeetings();
		
		function getHostedMeetings() {
			MeetingFactory.methods.getHostedMeetings(UserFactory.properties.currentUser.id)
			.then((response) => {
				console.log(response.data);
				vm.hostedMeetings = response.data;
			})
			.catch((error) => {
				console.error(error);
			});
		}
	}
	
})();