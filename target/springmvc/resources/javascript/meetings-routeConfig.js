(function() {
	'use strict';
	
	let TEMPLATE_FOLDER = '/springmvc/resources/angularTemplates/';
	
	angular
		.module('meeting.planner')
		.config(config);
	
	function config($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl: TEMPLATE_FOLDER + 'allMeetings.html',
				controller: 'AllMeetingsController',
				controllerAs: 'meetings'
			})
			.when('/myMeetings', {
				templateUrl: TEMPLATE_FOLDER + 'myMeetings.html',
				controller: 'AllMeetingsController',
				controllerAs: 'meetings'
			})
			.when('/newMeeting', {
				templateUrl: TEMPLATE_FOLDER + 'newMeeting.html',
				controller: 'MeetingController',
				controllerAs: 'meeting'
			})
			.when('/updateMeeting', {
				templateUrl: TEMPLATE_FOLDER + 'updateMeeting.html',
				controller: 'MeetingController',
				controllerAs: 'meeting'
			});
	}
})();