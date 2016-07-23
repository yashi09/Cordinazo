package com.pages.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.pojo.UserDetailsDto;

public class UserDetailsConverter implements Converter {

	public UserDetailsConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return new UserDetailsDto();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		UserDetailsDto dto=(UserDetailsDto)arg2;
		return dto.getFirstName();
	}

}
