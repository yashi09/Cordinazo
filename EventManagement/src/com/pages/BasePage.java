package com.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.context.FacesContext;

public abstract class BasePage {
	public abstract void preProcess(Map<String,Object> map);
	public abstract Map<String,Object> postProcess();
	private String action;
	private String currentPage;
	private static Map<String,Object> context=new ConcurrentHashMap<String,Object>();
	
	
	@SuppressWarnings("deprecation")
	public String navNext(){
		System.out.println("inside navNext. action = "+action);
		String retVal=null;
		Map<String,Object> map = new HashMap<String,Object>();
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			System.out.println("inside navNext. calling this.postProcess();");
			map = this.postProcess();
		} catch(Exception e){
			e.printStackTrace();
		}
		if(action!=null){
			retVal=action;
		}
		if((BasePage)context.getApplication().getVariableResolver().resolveVariable(context, retVal)!=null){
			((BasePage)context.getApplication().getVariableResolver().resolveVariable(context, retVal)).preProcess(map);
		}
		return retVal;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public static Map<String, Object> getContext(){
		return BasePage.context;
	}
}
