<jsp:include page="header.jsp"></jsp:include>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<main class="user-form">
		
		<h1>Account Login</h1>
		
		<form:form id="loginForm" modelAttribute="userLogin" method="post" action="loggingin">
		
			<div class="form-group">
				<label for="emailInput">Email:</label>
				<form:input id="emailInput" path="email" type="text" name="email" placeholder="Enter email address" class="form-control"/>
				<form:errors path="email" cssClass="error" />
			</div>
				
			<div class="form-group">
				<label for="passwordInput">Password:</label>
				<form:input id="passwordInput" path="password" type="password" name="password" placeholder="Enter password" class="form-control"/>
				<form:errors path="password" cssClass="error" />
			</div>
			
			
			<div class="form-group">
				<input type="submit" value="Login" class="btn btn-primary"/>
			</div>	
		</form:form>
		
		<br>
		<p>No account? Register <a href="<c:url value = "/register"/>">Here</a></p>
		
	</main>
	
<jsp:include page="footer.jsp"></jsp:include>