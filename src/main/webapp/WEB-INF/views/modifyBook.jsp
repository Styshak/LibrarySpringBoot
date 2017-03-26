<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<form:form method="post" modelAttribute="book" id="modalForm" action="/addBook?currentRequest=${requestScope['javax.servlet.forward.request_uri']}">
	<div class="container">
		<div class="container">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Modal Header</h4>
						</div>
						<div class="modal-body">
							<spring:bind path="name">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="name" class="form-control" placeholder="Название" id="name"/>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="pageCount">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="pageCount" class="form-control" placeholder="Кол-во страниц"/>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="isbn">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="isbn" class="form-control" placeholder="ISBN"/>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="genre">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:select path="genre" class="form-control" >
											<form:options items="${genreService.findAll()}" itemLabel="name" />
										</form:select>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="author">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:select path="author" class="form-control" >
											<form:options items="${authorService.findAll()}" itemLabel="name" />
										</form:select>
									</div>
								</div>
								<form:errors path="author"/>
							</spring:bind>
							<spring:bind path="publisher">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:select path="publisher" class="form-control" >
											<form:options items="${publisherService.findAll()}" itemLabel="name" />
										</form:select>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="publishYear">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:input type="text" path="publishYear" class="form-control" placeholder="Год выпуска"/>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="description">
								<div class="form-group">
									<div class="input-group" style="width: 100%">
										<form:textarea type="text" path="description" class="form-control" placeholder="Описание" rows="5"/>
									</div>
								</div>
							</spring:bind>

							<div class="form-group">
								<div class="input-group" style="width: 100%">
									<input type="file" class="form-control filestyle" name="image" data-buttonText="Выберите обложку"/>
								</div>
							</div>

							<div class="form-group">
								<div class="input-group" style="width: 100%">
									<input type="file" class="form-control filestyle" name="content" data-buttonText="Выберите книгу"/>
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

<script type="javascript">

</script>

</body>
</html>
