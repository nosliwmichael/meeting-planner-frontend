(function() {
	'use strict';
	
	angular
		.module('meeting.planner')
		.factory('MeetingFactory', MeetingFactory);
	
	MeetingFactory.$inject = ['$http'];
	
	let API_URL = '/meeting-planner/api/meeting/';
	
	function MeetingFactory($http) {
		
		return {
			// Shared Properties
			properties: {
				selectedMeeting: { id: -1 },
				hostedMeetings: []
			},
			// Shared Methods
			methods : {
				createMeeting: createMeeting,
				getMeeting: getMeeting,
				getHostedMeetings: getHostedMeetings,
				getAllMeetings: getAllMeetings,
				updateMeeting: updateMeeting,
				deleteMeeting: deleteMeeting
			}
		};
		
		// Function Definitions
		function createMeeting(meeting) {
			return $http.post(API_URL, meeting);
		}
		function getMeeting(id) {
			return $http.get(API_URL + id);
		}
		function getHostedMeetings(id) {
			return $http.get(API_URL + '/byHost/' + id);
		}
		function getAllMeetings() {
			return $http.get(API_URL);
		}
		function updateMeeting(meeting) {
			return $http.put(API_URL, meeting);
		}
		function deleteMeeting(id) {
			return $http.delete(API_URL + id);
		}
	
	} // End of Factory
	
})();