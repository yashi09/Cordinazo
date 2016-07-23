package com.pages;

import java.util.Map;

import com.manager.FestManager;
import com.pojo.FestDetailsDto;

public class EditFestPage extends BasePage{
	private FestManager manager;
	private int festId;
	private FestDetailsDto fest;
	private String work;
	private String startDate;
	private String endDate;

	@Override
	public void preProcess(Map<String, Object> map) {
		festId =(int) map.get("festId");
		fest = manager.getFest(festId);

	}

	@Override
	public Map<String, Object> postProcess() {
		if(work!=null && !work.isEmpty()){
			/*fest.setStartDate(EventUtil.getDate(startDate));
			fest.setEndDate(EventUtil.getDate(endDate));*/
			if(fest!=null)
				manager.updateFest(fest);
			else
				System.out.println("fest is null");
		}
		return null;
	}

	public FestManager getManager() {
		return manager;
	}

	public void setManager(FestManager manager) {
		this.manager = manager;
	}

	public int getFestId() {
		return festId;
	}

	public void setFestId(int festId) {
		this.festId = festId;
	}

	public FestDetailsDto getFest() {
		return fest;
	}

	public void setFest(FestDetailsDto fest) {
		this.fest = fest;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
