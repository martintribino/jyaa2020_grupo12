package com.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LocalDateTimeToStringConverter extends StdConverter<LocalDateTime, String> {
	static final DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
            .parseCaseInsensitive().parseLenient()
            .appendPattern(GenericHelper.LOCALDATETIME_FORMAT);
	static final DateTimeFormatter DATE_FORMATTER = builder.toFormatter(Locale.ENGLISH);

	@Override
	public String convert(LocalDateTime value) {
		return value.format(DATE_FORMATTER);
	}

}

