package com.util;

import com.pojo.EventDetailsDto;
import com.pojo.FestDetailsDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.dialect.DialectFactory.DatabaseDialectMapper;
public class EventUtil {
	
	public static Date getDate(String date){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			Date retDate = new Date();
			try {
				retDate = sdf.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return retDate;
	}
	
	
	public static List<List<EventDetailsDto>> processEvents(List<EventDetailsDto> dtos){
		List<List<EventDetailsDto>> eventsList =new ArrayList();
		List<EventDetailsDto> dtos2 = null;
		int count=0;
		for(int i=0;i<dtos.size();i++){
			count++;
			if(count<=4){
				if(count==1){
					dtos2= new ArrayList<EventDetailsDto>();
				} 
				dtos2.add(dtos.get(i));
				if(count%4==0){
					count=0;
					eventsList.add(dtos2);
				} else {
					if((count+1)==dtos.size()){
						eventsList.add(dtos2);
					}
				}
			}
		}
		//System.out.println("---------------"+eventsList.get(0).get(0).getEventName());
		
		return eventsList;
	}
	
	public static DataModel processFests(List<FestDetailsDto> dtos){
		List<List<FestDetailsDto>> eventsList =new ArrayList<List<FestDetailsDto>>();
		List<FestDetailsDto> dtos2 = null;
		int count=0;
		for(int i=0;i<dtos.size();i++){
			count++;
			if(count<=4){
				if(count==1){
					dtos2= new ArrayList<FestDetailsDto>();
				} 
				dtos2.add(dtos.get(i));
				if(count%4==0){
					count=0;
					DataModel dmDto = new ListDataModel(dtos2);
					eventsList.add(dtos2);
				} else {
					if((count+1)==dtos.size()){
						DataModel dmDto = new ListDataModel(dtos2);
						eventsList.add(dtos2);
					}
				}
			}
		}
		DataModel dm1 = new ListDataModel(eventsList);
		//System.out.println("---------------"+eventsList.get(0).get(0).getEventName());
		
		return dm1;
	}
}
