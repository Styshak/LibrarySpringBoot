$.validator.addMethod("notEqual", function(value, element, param) {
	return this.optional(element) || value !== param;
}, "Please, select a value");

$(function() {
	$("#modalForm").validate({
		rules: {
			name: "required",
			pageCount : {
				required: true,
				digits: true
			},
			isbn: {
				required: true
			},
			genre: {
				required: true,
				notEqual: "NONE"
			},
			author: {
				required: true,
				notEqual: "NONE"
			},
			publisher: {
				required: true,
				notEqual: "NONE"
			},
			publishYear: {
				required: true,
				digits: true,
				range: [1800, 2017]
			},
			image: {
				required: true,
				extension: "jpg|jpeg|gif|bmp|png"
			},
			content: {
				required: true,
				extension: "pdf"
			}
		},
		messages: {
			name: "Обязательное поле для заполнения",
			pageCount : {
				required: "Обязательное поле для заполнения",
				digits: "Некорректный формат, разрешены только цифры"
			},
			isbn: "Обязательное поле для заполнения",
			publishYear : {
				required: "Обязательное поле для заполнения",
				digits: "Некорректный формат, разрешены только цифры",
				range: "Допустимый диапазон годов от 1800 до 2017"
			},
			image: {
				required: "Обязательное поле для заполнения",
				extension: "Неправильный формат. Разрешен jpg|jpeg|gif|bmp|png"
			},
			content: {
				required: "Обязательное поле для заполнения",
				extension: "Неправильный формат. Разрешен pdf"
			},
            genre: {
                required: "Обязательное поле для заполнения"
            },
            author: {
                required: "Обязательное поле для заполнения"
            },
            publisher: {
                required: "Обязательное поле для заполнения"
            }
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
});

