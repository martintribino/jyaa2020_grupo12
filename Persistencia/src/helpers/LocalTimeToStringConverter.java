package helpers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LocalTimeToStringConverter extends StdConverter<LocalTime, String> {
	static final DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
            .parseCaseInsensitive().parseLenient()
            //.parseDefaulting(ChronoField.YEAR_OF_ERA, 2016L)
            .appendPattern("[yyyy-MM-dd]");
	static final DateTimeFormatter DATE_FORMATTER = builder.toFormatter(Locale.ENGLISH);

	@Override
	public String convert(LocalTime value) {
	      return value.format(DATE_FORMATTER);
	}

}
