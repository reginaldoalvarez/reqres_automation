package com.appgate.regres.tasks;

import net.serenitybdd.screenplay.Tasks;

public class Find {
	public static GetSingleUser SigleUserWithId(int id) {
		return Tasks.instrumented(GetSingleUser.class, id);
	}
	
	public static GetAllUsers AllUsersWithPage(int page) {
		return Tasks.instrumented(GetAllUsers.class, page);
	}
	
	public static GetAllUsers AllUsers() {
		return Tasks.instrumented(GetAllUsers.class);
	}
}
