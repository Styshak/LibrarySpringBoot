<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/register.css">
</head>
<body>
<div class="container container-table">
	<div class="row vertical-center-row">
		<div class="col-xs-8 col-xs-offset-2 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 well">
			<form:form method="POST" modelAttribute="user">
				<div class="text-center">
					<h1>Create an account</h1>
				</div>
				<spring:bind path="username">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<form:input path="username" type="text" class="form-control input-lg" placeholder="Username"/>
						</div>
						<form:errors path="username"/>
					</div>
				</spring:bind>

				<spring:bind path="password">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<form:input path="password" type="password" class="form-control input-lg" placeholder="Password"/>
						</div>
						<form:errors path="password"/>
					</div>
				</spring:bind>

				<spring:bind path="confirmPassword">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<form:input path="confirmPassword" type="password" class="form-control input-lg" placeholder="Confirm password"/>
						</div>
						<form:errors path="confirmedPassword"/>
					</div>
				</spring:bind>

				<div class="form-group">
					<button type="submit" class="btn btn-default btn-lg btn-block btn-success">Sign up</button>
				</div>
				<c:if test="${userAlreadyExist}">
					<div class="form-group">
						<label>User already exist!</label>
					</div>
				</c:if>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>
