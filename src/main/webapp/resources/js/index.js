/*function editBook(bookId) {
    var data = {
        id: bookId
    };
    $.ajax({
        type : "GET",
        url : "/getBookById",
        data: data,
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            //$('#myModal').modal('show');
            $('myModal').on('show.bs.modal', function(e) {

                //get data-id attribute of the clicked element
                var bookId = $(e.relatedTarget).data('book-id');

                //populate the textbox
                $(e.currentTarget).find('input[name="bookId"]').val(bookId);
            });
        }
    });
}*/

$(document).on("click", ".btn-edit-book", function (e) {
    e.preventDefault();
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
    e.preventDefault();
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
