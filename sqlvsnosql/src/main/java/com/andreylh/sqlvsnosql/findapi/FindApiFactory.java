package com.andreylh.sqlvsnosql.findapi;

public class FindApiFactory {

	public static FindApi createFindApi() {
		return new FindApiImpl();
	}
	
}
