package com.pages;

import java.util.Map;

public class Admin extends BasePage{

	@Override
	public void preProcess(Map map) {
		System.out.println("inside preProcess in Admin");
	}

	@Override
	public Map postProcess() {
		System.out.println("inside postProcess in Admin");
		return null;
	}
}
