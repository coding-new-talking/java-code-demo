package org.cnt.java.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lixinjie
 * @since 2019-07-08
 */
public class Logger {

	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	private Logger() {
	}
	
	public static Logger getLogger() {
		return new Logger();
	}
	
	public void info(String format, Object... params) {
		StackTraceElement ste = new Exception().getStackTrace()[1];
		format = format.replaceAll("\\{\\}", "%s");
		format = "%s [INFO] " + format + " - %s.%s(%s:%d)";
		System.out.println(String.format(format, buildParams(params, ste)));
	}
	
	public static String time() {
		return LocalDateTime.now().format(dtf);
	}
	
	public static Object[] buildParams(Object[] params, StackTraceElement ste) {
		Object[] ps = new Object[params.length + 5];
		ps[0] = time();
		for (int i = 0; i < params.length; i++) {
			ps[i + 1] = params[i];
		}
		ps[ps.length - 4] = ste.getClassName();
		ps[ps.length - 3] = ste.getMethodName();
		ps[ps.length - 2] = ste.getFileName();
		ps[ps.length - 1] = ste.getLineNumber();
		return ps;
	}
}
