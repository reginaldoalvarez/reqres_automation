package com.appgate.regres.utils;

public class Variables {

	public static String ENV_URL;

	public static void loadEnvironmentVariables() {
		if (System.getProperty("ENVURL") == null) {
			ENV_URL="https://reqres.in";
		} else {
			ENV_URL = System.getProperty("ENVURL");
		}
	}

}
