<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Start Bootstrap</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
						<li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>

	</div>

</nav>


<div class="container">

	<div class="row">

		<div class="col-md-3">
			<p class="lead">Online library</p>
			<div class="list-group">
				<a href="#" class="list-group-item">Category 1</a>
				<a href="#" class="list-group-item">Category 2</a>
				<a href="#" class="list-group-item">Category 3</a>
			</div>
		</div>

		<div class="col-md-9">

			<div class="row row-marging">

				<div class="col-sm-8 col-lg-8 col-md-8">
					<div class="input-group">
						<span class="input-group-addon input-group-addon-search"><i class="glyphicon glyphicon-search"></i></span>
						<input type="text" class="form-control" placeholder="Search...">
					</div>
				</div>

				<div class="col-sm-2 col-lg-2 col-md-2">
					<select class="form-control">
						<option value="one">Название</option>
						<option value="two">Автор</option>
					</select>
				</div>

				<div class="col-sm-2 col-lg-2 col-md-2">
					<button type="button" class="btn btn-default pull-right">Search</button>
				</div>

			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12 col-md-12">
					<div class="list-group list-group-horizontal">
						<a href="#" class="list-group-item">А</a>
						<a href="#" class="list-group-item">Б</a>
						<a href="#" class="list-group-item">В</a>
						<a href="#" class="list-group-item">Г</a>
						<a href="#" class="list-group-item">Д</a>
						<a href="#" class="list-group-item">Е</a>
						<a href="#" class="list-group-item">Ё</a>
						<a href="#" class="list-group-item">Ж</a>
						<a href="#" class="list-group-item">З</a>
						<a href="#" class="list-group-item">И</a>
						<a href="#" class="list-group-item">Й</a>
						<a href="#" class="list-group-item">К</a>
						<a href="#" class="list-group-item">Л</a>
						<a href="#" class="list-group-item">М</a>
						<a href="#" class="list-group-item">Н</a>
						<a href="#" class="list-group-item">О</a>
						<a href="#" class="list-group-item">П</a>
						<a href="#" class="list-group-item">Р</a>
						<a href="#" class="list-group-item">С</a>
						<a href="#" class="list-group-item">Т</a>
						<a href="#" class="list-group-item">У</a>
						<a href="#" class="list-group-item">Ф</a>
						<a href="#" class="list-group-item">Х</a>
						<a href="#" class="list-group-item">Ц</a>
						<a href="#" class="list-group-item">Ч</a>
						<a href="#" class="list-group-item">Ш</a>
						<a href="#" class="list-group-item">Щ</a>
						<a href="#" class="list-group-item">Э</a>
						<a href="#" class="list-group-item">Ю</a>
						<a href="#" class="list-group-item">Я</a>
					</div>
				</div>
			</div>

			<div class="row row-marging">
				<div class="col-sm-12 col-lg-12 col-md-12">
					<a href="#" class="btn btn-success pull-right" role="button">Добавить книгу</a>
					<h4>Найдено книг: 6</h4>
				</div>
			</div>

			<div class="row">

				<c:forEach var="item" begin="1" end="6">

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="caption">
								<h4 class="pull-right">2008 г.</h4>
								<h4><a href="#">First Product</a></h4>
								<p>
									<a href="#" class="btn btn-default btn-edit-book" role="button">Читать</a>
									<a href="#" class="btn btn-default btn-edit-book pull-right" role="button">Скачать</a>
								</p>
								<p>
									<a href="#" class="btn btn-default btn-edit-book" role="button">Изменить</a>
									<a href="#" class="btn btn-danger btn-edit-book pull-right" role="button">Удалить</a>
								</p>
								<p>
									This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								</p>
							</div>
							<div class="ratings">
								<p class="pull-right">15 reviews</p>
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
						<li class="disabled"><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li><a href="#">7</a></li>
						<li><a href="#">8</a></li>
						<li><a href="#">...</a></li>
						<li><a href="#">99</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>

		</div>

	</div>

</div>


<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">

	<div class="container text-center">

		<div class="row">
			<div class="col-lg-12">
				<p class="footer-row">Copyright &copy; Styshak Sergey 2017</p>
			</div>
		</div>

	</div>
</nav>
</body>
</html>
