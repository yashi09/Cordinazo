package com.event.listeners;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.pages.Login;

public class AppListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent evnt) {
		try{
			FacesContext fc=evnt.getFacesContext();
			Map m=fc.getExternalContext().getSessionMap();
			//System.out.println(m.containsKey("login")+"----------");
			if(m.containsKey("login")){
				Login loginPage=(Login)m.get("login");
				if(!loginPage.isLoggedIn()){
					fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "loginPage");
				}
			}else{
				fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "loginPage");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void beforePhase(PhaseEvent evnt) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
