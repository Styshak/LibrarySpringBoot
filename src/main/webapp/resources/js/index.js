function editBook(bookId) {
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
            $('#myModal').modal('show');
        }
    });
}
