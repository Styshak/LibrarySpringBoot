<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--@elvariable id="genreService" type="com.styshak.services.GenreService"--%>
<%--@elvariable id="letter" type="com.styshak.utils.Letter"--%>

<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Start Bootstrap</a>
		</div>

		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href="#">About</a>
				</li>
				<li>
					<a href="#">Services</a>
				</li>
				<li>
					<a href="#">Contact</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${username}<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="logout"/></a></li>
					</ul>
				</li>
			</ul>
			<div class="nav navbar-nav navbar-right">
				<ul class="nav navbar-nav locale">
					<li>
						<a href="?lang=ru"><img src="/resources/images/ru.png" width="25" height="25"></a>
					</li>
					<li>
						<a href="?lang=en"><img src="/resources/images/eng.png" width="25" height="25"></a>
					</li>
				</ul>
			</div>
		</div>

	</div>

</nav>


<div class="container">

	<div class="row" style="height: 100%">

		<div class="col-md-3">
			<p class="lead"><spring:message code="page_title"/></p>
			<div class="list-group">
				<c:forEach items="${genreService.findAll()}" var="g">
					<a href="/?genreId=${g.id}" class="list-group-item">${g.name}</a>
				</c:forEach>
			</div>
		</div>

		<div class="col-md-9">

			<div class="row row-marging">
				<form method="POST" action="/">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="col-sm-8 col-lg-8 col-md-8">
						<div class="input-group">
							<span class="input-group-addon input-group-addon-search"><i class="glyphicon glyphicon-search"></i></span>
							<input type="text" class="form-control" name="searchText" placeholder=<spring:message code="search.text.placeholder"/>>
						</div>
					</div>

					<div class="col-sm-2 col-lg-2 col-md-2">
						<select class="form-control" name="searchType">
							<c:forEach items="${searchType}" var="s">
								<option value=${s}><spring:message code="${s.name}"/></option>
							</c:forEach>
						</select>
					</div>

					<div class="col-sm-2 col-lg-2 col-md-2">
						<button type="submit" class="btn btn-primary pull-right"><spring:message code="btn.search"/></button>
					</div>
				</form>
			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12 col-md-12">
					<div class="list-group list-group-horizontal">
						<c:forEach var="l" items="${letter.letters}">
							<a href="/?letter=${l.toString()}" class="list-group-item">${l}</a>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="row row-marging">
				<div class="col-sm-12 col-lg-12 col-md-12">
					<a href="#" class="btn btn-success pull-right" role="button"><spring:message code="add.book"/></a>
					<h4><spring:message code="books.count"/> ${books.totalElements}</h4>
				</div>
			</div>

			<div class="row">

				<c:forEach var="book" items="${books.content}" begin="0" end="5">

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img class="img-responsive" src="/img/book/${book.id}" alt=""><!-- /img/book/${book.id} -->
							<div class="caption">
								<h4 class="pull-right">${book.publishYear} г.</h4>
								<h4><a href="#">${book.name}</a></h4>
								<p><strong><spring:message code="author"/></strong> ${book.author.name}</p>
								<p><strong><spring:message code="pages"/></strong> ${book.pageCount}</p>
								<p><strong><spring:message code="publisher"/></strong> ${book.publisher.name}</p>
								<p><strong><spring:message code="isbn"/></strong> ${book.isbn}</p>
								<p>
									<a href="#" class="btn btn-default btn-edit-book btn-xs" role="button"><spring:message code="read_btn"/></a>
									<a href="#" class="btn btn-default btn-edit-book pull-right btn-xs" role="button"><spring:message code="download_btn"/></a>
								</p>
								<p>
									<a href="#" class="btn btn-default btn-edit-book btn-xs" role="button"><spring:message code="edit_btn"/></a>
									<a href="#" class="btn btn-danger btn-edit-book pull-right btn-xs" role="button"><spring:message code="delete_btn"/></a>
								</p>
							</div>
							<div class="ratings">
								<p class="pull-right">15 <spring:message code="reviews"/></p>
								<p>
									<span class="glyphicon glyphicon-star"></span>
									<span class="glyphicon glyphicon-star"></span>
									<span class="glyphicon glyphicon-star"></span>
									<span class="glyphicon glyphicon-star"></span>
									<span class="glyphicon glyphicon-star"></span>
								</p>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>

			<div class="row">
				<div class="col-xs-10 col-xs-offset-1">
					<ul class="pagination">

						<c:set var="firstUrl" value="${pageContext.request.queryString}" />
						<c:if test="${not empty pageContext.request.queryString}">
							<c:set var="firstUrl" value="${'/?' += pageContext.request.queryString += '&page=1'}" />
						</c:if>


						<c:url var="firstUrl" value="${firstUrl}" />
						<c:url var="lastUrl" value="/pages/${deploymentLog.totalPages}" />
						<c:url var="prevUrl" value="/pages/${currentIndex - 1}" />
						<c:url var="nextUrl" value="/pages/${currentIndex + 1}" />

						<c:choose>
							<c:when test="${currentIndex == 1}">
								<li class="disabled"><a href="javascript: void(0)">&lt;&lt;</a></li>
								<li class="disabled"><a href="javascript: void(0)">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${firstUrl}">&lt;&lt;</a></li>
								<li><a href="${prevUrl}">&lt;</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
							<c:set var="pageUrl" value="/?page=${i}"/>
							<c:if test="${not empty pageContext.request.queryString}">
								<c:set var="pageUrl" value="${'/?' += pageContext.request.queryString += '&page='}${i}" />
							</c:if>
							<c:choose>
								<c:when test="${i == currentIndex}">
									<li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${currentIndex == books.totalPages}">
								<li class="disabled"><a href="javascript: void(0)">&gt;</a></li>
								<li class="disabled"><a href="javascript: void(0)">&gt;&gt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${nextUrl}">&gt;</a></li>
								<li><a href="${lastUrl}">&gt;&gt;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>

		</div>

	</div>

</div>


<nav class="navbar navbar-default navbar-static-bottom navbar-footer" role="navigation">

	<div class="container text-center">

		<div class="row">
			<div class="col-lg-12">
				<p class="footer-row">Copyright &copy; Styshak Sergey 2017</p>
			</div>
		</div>

	</div>
</nav>
<script type="text/javascript">
	$( document ).ready(function() {
		$('.list-group-horizontal .list-group-item').css('width','calc(100% / ${fn:length(letter.letters)})');
	});
</script>
</body>
</html>
