<jsp:include page="header.jsp"></jsp:include>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/meetings.css" />

<div data-ng-app="meeting.planner" data-ng-controller="UserController as user">
	
	<div class="container">
		<a class="btn btn-primary text-white" href="#!">All Meetings</a>
		<a class="btn btn-primary text-white" href="#!/myMeetings">My Meetings</a>
	</div>
	
	<div data-ng-view></div>
	
</div> <!-- End of AngularJS App -->
	
	
	<!-- AngularJS CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
	
	<!-- AngularJS Scripts -->
	<script src="<%=request.getContextPath()%>/resources/javascript/meetingApp.js"></script>
	<script src="<%=request.getContextPath()%>/resources/javascript/meetings-routeConfig.js"></script>
	<script src="<%=request.getContextPath()%>/resources/javascript/services/meetingFactory.js"></script>
	<script src="<%=request.getContextPath()%>/resources/javascript/services/userFactory.js"></script>
	<script src="<%=request.getContextPath()%>/resources/javascript/controllers/meetingController.js"></script>
	<script src="<%=request.getContextPath()%>/resources/javascript/controllers/allMeetingsController.js"></script>
	<script src="<%=request.getContextPath()%>/resources/javascript/controllers/userController.js"></script>
	
<jsp:include page="footer.jsp"></jsp:include>