<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/additional-methods.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-filestyle/1.2.1/bootstrap-filestyle.min.js"></script>
	<script src="/resources/js/modifyBookValidation.js"></script>
</head>
<body>
<!-- Modal -->
<form:form method="post" modelAttribute="book" id="modalForm" action="/saveOrUpdateBook?currentRequest=${requestScope['javax.servlet.forward.request_uri']}">
	<div class="container">
		<div class="container">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>

							<c:choose>
								<c:when test="${book['id'] eq 0}">
									<h4 class="modal-title">Add book</h4>
								</c:when>
								<c:otherwise>
									<h4 class="modal-title">Update Book</h4>
								</c:otherwise>
							</c:choose>

						</div>
						<div class="modal-body">

								<form:input type="hidden" path="id" class="form-control" id="id"/>

								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="name" class="form-control" placeholder="Название" id="name"/>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="pageCount" class="form-control" placeholder="Кол-во страниц" id="pageCount"/>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="isbn" class="form-control" placeholder="ISBN" id="isbn"/>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:select path="genre" class="form-control" >
											<form:options items="${genreService.findAll()}" itemLabel="name" id="genre"/>
										</form:select>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:select path="author" class="form-control" >
											<form:options items="${authorService.findAll()}" itemLabel="name" id="author"/>
										</form:select>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:select path="publisher" class="form-control" >
											<form:options items="${publisherService.findAll()}" itemLabel="name" id="publisher"/>
										</form:select>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="publishYear" class="form-control" placeholder="Год выпуска" id="publishYear"/>
									</div>
								</div>


								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:textarea type="text" path="description" class="form-control" placeholder="Описание" rows="5" id="description"/>
									</div>
								</div>


							<div class="form-group">
								<div class="input-group" style="width: 100%">
									<input type="file" class="form-control filestyle" name="image" data-buttonText="Выберите обложку" id="bookImage" data-placeholder="No file selected"/>
								</div>
							</div>

							<div class="form-group">
								<div class="input-group" style="width: 100%">
									<input type="file" class="form-control filestyle" name="content" data-buttonText="Выберите книгу" id="bookContent" data-placeholder="No file selected"/>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary" role="button">Add</button>
							<button type="button" class="btn btn-default" role="button" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>
<!-- Modal -->

</body>
</html>
