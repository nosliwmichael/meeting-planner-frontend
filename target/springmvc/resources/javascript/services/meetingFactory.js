(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.factory('MeetingFactory', MeetingFactory);
	
	MeetingFactory.$inject = ['$http'];
	
	function MeetingFactory($http) {
		return {
			// Shared Properties
			properties: {
				selectedMeeting: { id: -1, subject: 'subject', time: '', location: 'office' }
			},
			// Shared Methods
			methods : {
				createMeeting: createMeeting,
				getMeeting: getMeeting,
				getAllMeetings: getAllMeetings,
				updateMeeting: updateMeeting,
				deleteMeeting: deleteMeeting
			}
		};
		
		// Function Definitions
		function createMeeting(meeting) {
			return $http.post("/springmvc/meeting/",meeting);
		}
		function getMeeting(id) {
			return $http.get("/springmvc/meeting/"+id);
		}
		function getAllMeetings() {
			return $http.get("/springmvc/meeting/getall");
		}
		function updateMeeting(meeting) {
			return $http.put("/springmvc/meeting/", meeting);
		}
		function deleteMeeting(id) {
			return $http.delete("/springmvc/meeting/"+id);
		}
	}
})();