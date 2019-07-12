<jsp:include page="header.jsp"></jsp:include>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<main class="user-form">
	
		<h1>Enter Account Details</h1>
		
		<form:form commandName="newUser" method="post" action="creating">
		
			<div class="form-group">
				First Name: <form:input class="form-control" 
							 path="firstName" type="text" name="firstName" 
							 placeholder="First Name" required="required"/>
				<form:errors path="firstName" cssClass="error" />
			</div>
			
			<div class="form-group">
				Last Name: <form:input class="form-control" 
							path="lastName" type="text" name="lastName" 
							placeholder="Last Name"/>
				<form:errors path="lastName" cssClass="error" />
			</div>
			
			<div class="form-group">
				Email: <form:input class="form-control" 
						path="email" type="email" name="email" 
						placeholder="Email Address"/>
				<form:errors path="email" cssClass="error"  required="required"/>
			</div>
			
			<div class="form-group">
				Password: <form:input class="form-control" 
						   path="password" type="password" name="password" 
						   placeholder="Password"/>
				<form:errors path="password" cssClass="error"  required="required"/>
			</div>
			
			<span id="errorMessage" class="error"></span><br>
			
			<div class="form-group">
				<input id="submitButton" type="submit" value="Create" class="btn btn-primary"/>
			</div>
		
		</form:form>
		
	</main>
	
<jsp:include page="footer.jsp"></jsp:include>
<script src="resources/javascript/data-validation.js"></script>