$(document).on("click", ".btn-edit-book", function (e) {
    resetValidation($("#modalForm"));
    $('#bookImage').rules('remove', 'required');
    $('#bookContent').rules('remove', 'required');
    $('.btn-save').html('Update');

    var _self = $(this);
    var bookId = _self.data('book-id');
    var data = {
        id: bookId
    };
    $.ajax({
        type : "GET",
        url : "/getBookById",
        data: data,
        dataType : 'json',
        timeout : 1000,
        success : function(data) {
            if(data !== null) {
                $('#modalTitle').html("Update book");
                $('#id').val(data.id);
                $('#name').val(data.name);
                $('#pageCount').val(data.pageCount);
                $('#isbn').val(data.isbn);
                $('#genre').val(data.genre.id);
                $('#author').val(data.author.id);
                $('#publisher').val(data.publisher.id);
                $('#publishYear').val(data.publishYear);
                $('#description').val(data.description);
                $('#bookImage').filestyle('placeholder', 'Обложка уже загружена в базу. Вы можете изменить её');
                $('#bookContent').filestyle('placeholder', 'Книга уже загружена в базу. Вы можете изменить её');
            }
            $('#myModal').modal('show');
        }
    });
});

$(document).on("click", "#btn-add-book", function (e) {
    resetValidation($("#modalForm"));
    $('#bookImage').rules('add', 'required');
    $('#bookContent').rules('add', 'required');
    $('.btn-save').html('Add');

    $('#modalTitle').html("Add book");
    $('#name').val("");
    $('#pageCount').val("");
    $('#isbn').val("");
    $('#genre').val("");
    $('#author').val("");
    $('#publisher').val("");
    $('#publishYear').val("");
    $('#description').val("");
    $('#bookImage').filestyle('placeholder', 'Обложка не выбрана');
    $('#bookContent').filestyle('placeholder', 'Книга не выбрана');
    $('#myModal').modal('show');
});

function resetValidation(form) {
    var validator = form.validate();
    validator.resetForm();
    form.find('.error').removeClass("error");
    form[0].reset();
}


$(document).on("click", ".star", function (e) {
	var _self = $(this);
	var cost = _self.data('cost');
	var bookId = _self.data('book-id');
	var currentRequest = _self.data('current-request');
	var data = {
		bookId: bookId,
        cost: cost,
		currentRequest: currentRequest
	};
	$.ajax({
		type : "POST",
		url : "/voteBook",
		data: data,
		dataType : 'json',
		timeout : 1000,
		success : function(data) {

		}
	});
});


$(document).on({
	mouseenter: function () {

	},
	mouseleave: function () {

	}
}, ".glyphicon-star-empty");



