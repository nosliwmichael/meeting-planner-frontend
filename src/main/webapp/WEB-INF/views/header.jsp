<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Meeting Planner - ${title}</title>
	<link rel="icon" href="<c:url value = "/resources/images/favicon.ico"/>" />
	
	<!-- Stylesheets -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="<c:url value = "/resources/css/main.css"/>"/>
</head>
<body>
	
	<nav class="navbar navbar-expand-sm">
	
		<span class="navbar-brand">Meeting Planner</span>
	
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value = "/"/>">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value = "/login"/>">Account</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value = "/meeting"/>">Meetings</a>
			</li>
		</ul>
		
	</nav>