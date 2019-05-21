(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.controller('AllMeetingsController', AllMeetingsController);
	
	AllMeetingsController.$inject = ['$window', 'MeetingFactory'];
	
	function AllMeetingsController($window, MeetingFactory) {

		let vm = this;
		
		// Exposed Properties
		vm.selectedMeeting = MeetingFactory.properties.selectedMeeting;
		vm.allMeetings = [];
		vm.errorMessage = "";
		
		// Exposed Methods
		vm.selectMeeting = selectMeeting;
		vm.getMeeting = getMeeting;
		vm.getAllMeetings = getAllMeetings;
		vm.deleteMeeting = deleteMeeting;
		
		// Populate allMeetings array
		getAllMeetings();
		
		// Set Selected Meeting
		function selectMeeting(meeting) {
			MeetingFactory.properties.selectedMeeting = meeting;
		}
		
		// Read
		function getMeeting() {
			MeetingFactory.methods.getMeeting(MeetingFactory.properties.selectedMeeting.id)
			.then((response) => {
				let sObj = response.data;
				MeetingFactory.selectedMeeting.id = sObj.id;
				MeetingFactory.selectedMeeting.subject = sObj.subject;
				MeetingFactory.selectedMeeting.time = new Date(meeting[i].time);
				MeetingFactory.selectedMeeting.location = response.data.location;
			})
			.catch((error) => {
				if (error.status == 204)
					console.error("Conflict Error: Meeting was not found.");
				else
					console.error(error);
			});
		}
		function getAllMeetings() {
			MeetingFactory.methods.getAllMeetings()
				.then((response) => {
					let meeting = response.data;
					console.log('All Meetings: ', meeting);
					vm.allMeeting = [];
					for (var i = 0; i < meeting.length; i++) {
						vm.allMeetings[i] = {
								id: meeting[i].id, 
								subject: meeting[i].subject,
								time: new Date(meeting[i].time), 
								location: meeting[i].location,
								hostUser: meeting[i].hostUser
						};
						vm.allMeetings[i].hostUser.fullName = 
							vm.allMeetings[i].hostUser.firstName + " " +
							vm.allMeetings[i].hostUser.lastName;
					}
				})
				.catch((error) => { console.error(error); });
		}
		// Delete
		function deleteMeeting(meeting) {
			MeetingFactory.methods.deleteMeeting(meeting.id)
				.then((response) => { 
					console.log('Delete Response: ', response); 
					$window.location.href = '#!';
				})
				.catch((error) => { console.error(error); });
		}
		
	} // End of Controller
})();