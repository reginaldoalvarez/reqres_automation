package com.appgate.regres.questions;

public class Quantity {

	public static TotalUsers ofUsersIsTheSameAsFieldTotal() {
		return new TotalUsers();
	}

	public static PerPageUsers ofUsersIsTheSameAsFieldPerPage() {
		return new PerPageUsers();
	}
	
	public static TotalPages ofUsersIsTheSameAsFieldTotalPages() {
		return new TotalPages();
	}

}
