(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.controller('MeetingController', MeetingController);
	
	MeetingController.$inject = ['$window', 'MeetingFactory', 'UserFactory'];
	
	function MeetingController($window, MeetingFactory, UserFactory) {

		let vm = this;

		// Exposed Properties
		vm.newMeeting = { };
		vm.selectedMeeting = MeetingFactory.properties.selectedMeeting;
		vm.errorMessage = "";
		
		// Exposed Methods
		vm.selectMeeting = selectMeeting;
		vm.createMeeting = createMeeting;
		vm.updateMeeting = updateMeeting;
		
		console.log(vm.selectedMeeting);
		
		// Set Selected Meeting
		function selectMeeting(meeting) {
			MeetingFactory.properties.selectedMeeting = meeting;
		}
		
		// Create Meeting
		function createMeeting() {
			if (vm.newMeeting.subject &&
				vm.newMeeting.time &&
				vm.newMeeting.location &&
				vm.newMeeting.hostUser.id) {

				MeetingFactory.methods.createMeeting(vm.newMeeting)
					.then((response) => {
						console.log("Meeting created");
						$window.location.href = '#/!';
					})
					.catch((error) => {
						if (error.status == 409)
							vm.errorMessage = "Conflict Error: A meeting already exists at this time and date.";
						else
							vm.errorMessage = "A problem occured while attempting to create your meeting.";
					});
			} else {
				vm.errorMessage = "Please complete all fields.";
			}
		}
		
		// Update Meeting
		function updateMeeting() {
			if (vm.selectedMeeting.subject &&
				vm.selectedMeeting.time &&
				vm.selectedMeeting.location &&
				vm.selectedMeeting.hostUser.id) {
				
				MeetingFactory.methods.updateMeeting(vm.selectedMeeting)
					.then((response) => {
						$window.location.href = '#/!';
					})
					.catch((error) => {
						console.log("Error: ", error); 
						vm.errorMessage = 'Conflict Error: This meeting may not exist or conflicts with an existing meeting.';
					});
			} else {
				vm.errorMessage = "Please complete all fields.";
			}
		}
		
	} // End of Controller
})();