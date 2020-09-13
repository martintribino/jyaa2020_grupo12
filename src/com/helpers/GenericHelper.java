package com.helpers;

import java.text.Format;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.text.Normalizer.Form;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class GenericHelper {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");

	public static final String LOCALDATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String LOCALDATE_FORMAT = "yyyy-MM-dd";
	public static final String LOCALTIME_FORMAT = "HH:mm:ss";
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat(GenericHelper.LOCALDATETIME_FORMAT);

	public static String slugToday() {
		Date today = Calendar.getInstance().getTime();
		Format formatter = new SimpleDateFormat(GenericHelper.LOCALDATETIME_FORMAT);
		String s = formatter.format(today);
		String slug = GenericHelper.toSlug(s);
		return GenericHelper.toSlug(slug);
	}

	private static String toSlug(String input) {
		String slug = Normalizer.normalize(input, Form.NFD);
		slug = WHITESPACE.matcher(slug).replaceAll("");
		slug = NONLATIN.matcher(slug).replaceAll("");
	    slug = EDGESDHASHES.matcher(slug).replaceAll("");

		return slug.toLowerCase(Locale.ENGLISH);
	}

}
