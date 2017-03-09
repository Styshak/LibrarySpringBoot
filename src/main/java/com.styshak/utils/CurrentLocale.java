package com.styshak.utils;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class CurrentLocale {

	public String getLocaleCode() {
		return LocaleContextHolder.getLocale().getLanguage();
	}
}
