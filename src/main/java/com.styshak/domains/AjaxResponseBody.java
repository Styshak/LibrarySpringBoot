package com.styshak.domains;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by sergey on 21.03.17.
 */

@Getter
@Setter
public class AjaxResponseBody {

	@JsonView
	String msg;

	@JsonView
	String code;

	@JsonView
	Book book;
}
