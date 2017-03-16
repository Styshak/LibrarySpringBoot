<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title><spring:message code="create.account"/></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/register.css">
</head>
<body>
<div class="container container-table">
	<div class="row vertical-center-row">
		<div class="col-xs-8 col-xs-offset-2 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 well">
			<div class="pull-right">
				<a href="?lang=ru"><img src="/resources/images/ru.png" width="25" height="25"></a>
				<a href="?lang=en"><img src="/resources/images/eng.png" width="25" height="25"></a>
			</div>
			<form:form method="POST" modelAttribute="user">
				<div class="text-center" style="margin-top: 30px">
					<h1><spring:message code="create.account"/></h1>
				</div>
				<spring:bind path="username">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<spring:message code="username" var="username"/>
							<form:input path="username" type="text" class="form-control input-lg" placeholder="${username}"/>
						</div>
						<form:errors path="username"/>
					</div>
				</spring:bind>

				<spring:bind path="password">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<spring:message code="username" var="username"/>
							<spring:message code="password" var="password"/>
							<form:input path="password" type="password" class="form-control input-lg" placeholder="${password}"/>
						</div>
						<form:errors path="password"/>
					</div>
				</spring:bind>

				<spring:bind path="confirmPassword">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<spring:message code="confirm.password" var="confirm"/>
							<form:input path="confirmPassword" type="password" class="form-control input-lg" placeholder="${confirm}"/>
						</div>
						<form:errors path="confirmedPassword"/>
					</div>
				</spring:bind>

				<div class="form-group">
					<button type="submit" class="btn btn-default btn-lg btn-block btn-success"><spring:message code="sign.up"/></button>
				</div>
				<c:if test="${userAlreadyExist}">
					<div class="form-group">
						<label><spring:message code="user.already.exist"/></label>
					</div>
				</c:if>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>
