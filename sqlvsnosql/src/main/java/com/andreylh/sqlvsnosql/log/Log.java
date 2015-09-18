package com.andreylh.sqlvsnosql.log;

import java.time.LocalTime;

public class Log {
	
	private static final String MSG_PREFIX = "%s : %s - %s";
	
	public static void log(String msg, Object... args) {
		if (args.length > 0) {
			System.out.println(String.format(MSG_PREFIX, Thread.currentThread().getName(), LocalTime.now().toString(), String.format(msg, args)));
		} else {
			System.out.println(String.format(MSG_PREFIX, Thread.currentThread().getName(), LocalTime.now().toString(), msg));
		}
	}
	
}
