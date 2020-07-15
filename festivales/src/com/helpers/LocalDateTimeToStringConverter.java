package com.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LocalDateTimeToStringConverter extends StdConverter<LocalDateTime, String> {
	static final DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
            .parseCaseInsensitive().parseLenient()
            //.parseDefaulting(ChronoField.YEAR_OF_ERA, 2016L)
            .appendPattern("yyyy-MM-dd'T'HH:mm");
	static final DateTimeFormatter DATE_FORMATTER = builder.toFormatter(Locale.ENGLISH);

	@Override
	public String convert(LocalDateTime value) {
		return value.format(DATE_FORMATTER);
	}

}
