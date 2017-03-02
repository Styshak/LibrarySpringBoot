<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title><spring:message code="page_title"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
<div class="container container-table">
    <div class="row vertical-center-row">
        <div class="col-xs-8 col-xs-offset-2 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 well">
            <form method="POST">
                <div class="form-group text-center">
                    <div class="logo">
                        <span class="glyphicon glyphicon-flash set-logo"></span>
                    </div>
                </div>
                <c:if test="${logout}">
                    <div class="alert alert-info" role="alert">You have been logged out successful</div>
                </c:if>
                <c:if test="${error}">
                    <div class="alert alert-danger" role="alert">Invalid username or password</div>
                </c:if>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" class="form-control input-lg" placeholder="Username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control input-lg" placeholder="Password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-lg btn-block btn-success">Sign in</button>
                </div>
                <div class="form-group last-row">
                    <label class="checklabel">
                        <input type="checkbox"> Remember me
                    </label>
                    <a href="/register" class="pull-right">Create an account</a>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>
        </div>
    </div>
</div>
</body>
</html>
