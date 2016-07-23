package com.pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.manager.EventManager;
import com.pojo.AuthorDetailsDto;
import com.pojo.ConferenceDetailsDto;
import com.pojo.ConferencePaperMappingClass;
import com.pojo.PaperAuthorMappingClass;
import com.pojo.PaperDetailsDto;
import com.util.MailUtil;

public class SubmitPaper extends BasePage{
	private EventManager manager;
	private int conferenceId;
	private ConferenceDetailsDto conferenceDto;
	private String fName1;
	private String lName1;
	private String email1;
	private String organization1;
	private String fName2;
	private String lName2;
	private String email2;
	private String organization2;
	private String fName3;
	private String lName3;
	private String email3;
	private String organization3;
	private String fName4;
	private String lName4;
	private String email4;
	private String organization4;
	private String fName5;
	private String lName5;
	private String email5;
	private String organization5;
	private String fName6;
	private String lName6;
	private String email6;
	private String organization6;
	private String fName7;
	private String lName7;
	private String email7;
	private String organization7;
	private String title;
	private String paperAbstract;
	private UploadedFile paper;
	private String work;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			conferenceId = (int)map.get("conferenceId");
			conferenceDto = manager.getConference(conferenceId);
			getContext().put("conferenceDto", conferenceDto);
			
		}
	}

	@SuppressWarnings("resource")
	@Override
	public Map<String, Object> postProcess() {
		conferenceDto = (ConferenceDetailsDto) getContext().get("conferenceDto");
		getContext().remove("conferenceDto");
		//Iterator<UserDetailsDto> itr=conferenceDto.getEventUsers().iterator();
		//((UserDetailsDto)getContext().get("userKaObject")).getEmail();
		File f=new File("/home/yashi/Desktop/apache-tomcat-6.0.44/temp/abstract.txt");
		try {
			InputStream is=paper.getInputStream();
			OutputStream os=new FileOutputStream(f);
			int bite=0;
			while((bite=is.read())!=-1){
				os.write(bite);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		MailUtil.sendMail("yashi09999@gmail.com", f);
		//MailUtil.sendMail(((UserDetailsDto)getContext().get("userKaObject")).getEmail(), f);
		PaperDetailsDto paper= new PaperDetailsDto();
		//Set<AuthorDetailsDto> authors = new HashSet<AuthorDetailsDto>();
		paper.setAbstractOfPaper(paperAbstract);
		paper.setTitle(title);
		paper.setConferenceId(conferenceDto.getEventId());
		if(this.paper!=null){
			paper.setPaperStatus(1);
		}else if(this.paper==null){
			paper.setPaperStatus(0);
		}
		manager.addPaper(paper);
		ConferencePaperMappingClass conferencePaper = new ConferencePaperMappingClass();
		conferencePaper.setConferenceId(conferenceDto.getEventId());
		conferencePaper.setPaperId(paper.getPaperId());
		manager.addPaperToConference(conferencePaper);
		if(fName1!=null && !fName1.isEmpty()){
			AuthorDetailsDto author = new AuthorDetailsDto();
			author.setEmail(email1);
			author.setFirstName(fName1);
			author.setLastName(lName1);
			author.setOrganization(organization1);
			author.setPaperId(paper.getPaperId());
			
			manager.addAuthor(author);
			PaperAuthorMappingClass paperAuthor = new PaperAuthorMappingClass();
			paperAuthor.setAuthorId(author.getAuthorId());
			paperAuthor.setPaperId(paper.getPaperId());
			manager.addAuthorToPaper(paperAuthor);
			//authors.add(author);
		}
		if(fName2!=null && !fName2.isEmpty()){
			AuthorDetailsDto author = new AuthorDetailsDto();
			author.setEmail(email2);
			author.setFirstName(fName2);
			author.setLastName(lName2);
			author.setOrganization(organization2);
			author.setPaperId(paper.getPaperId());
			manager.addAuthor(author);
			PaperAuthorMappingClass paperAuthor = new PaperAuthorMappingClass();
			paperAuthor.setAuthorId(author.getAuthorId());
			paperAuthor.setPaperId(paper.getPaperId());
			manager.addAuthorToPaper(paperAuthor);
			//authors.add(author);
		}
		if(fName3!=null && !fName3.isEmpty()){
			AuthorDetailsDto author = new AuthorDetailsDto();
			author.setEmail(email3);
			author.setFirstName(fName3);
			author.setLastName(lName3);
			author.setOrganization(organization3);
			author.setPaperId(paper.getPaperId());
			manager.addAuthor(author);
			PaperAuthorMappingClass paperAuthor = new PaperAuthorMappingClass();
			paperAuthor.setAuthorId(author.getAuthorId());
			paperAuthor.setPaperId(paper.getPaperId());
			manager.addAuthorToPaper(paperAuthor);
			//authors.add(author);
		}
		if(fName4!=null && !fName4.isEmpty()){
			AuthorDetailsDto author = new AuthorDetailsDto();
			author.setEmail(email4);
			author.setFirstName(fName4);
			author.setLastName(lName4);
			author.setOrganization(organization4);
			author.setPaperId(paper.getPaperId());
			manager.addAuthor(author);
			PaperAuthorMappingClass paperAuthor = new PaperAuthorMappingClass();
			paperAuthor.setAuthorId(author.getAuthorId());
			paperAuthor.setPaperId(paper.getPaperId());
			manager.addAuthorToPaper(paperAuthor);
			//authors.add(author);
		}
		if(fName5!=null && !fName5.isEmpty()){
			AuthorDetailsDto author = new AuthorDetailsDto();
			author.setEmail(email5);
			author.setFirstName(fName5);
			author.setLastName(lName5);
			author.setOrganization(organization5);
			author.setPaperId(paper.getPaperId());
			manager.addAuthor(author);
			PaperAuthorMappingClass paperAuthor = new PaperAuthorMappingClass();
			paperAuthor.setAuthorId(author.getAuthorId());
			paperAuthor.setPaperId(paper.getPaperId());
			manager.addAuthorToPaper(paperAuthor);
			//authors.add(author);
		}
	//	paper.setAuthors(authors);
	//	conferenceDto.getConferencePapers().add(paper);
	//	manager.updateConference(conferenceDto);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("conferenceId", conferenceDto.getEventId());
		return map;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public int getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}

	public ConferenceDetailsDto getConferenceDto() {
		return conferenceDto;
	}

	public void setConferenceDto(ConferenceDetailsDto conferenceDto) {
		this.conferenceDto = conferenceDto;
	}

	public String getfName1() {
		return fName1;
	}

	public void setfName1(String fName1) {
		this.fName1 = fName1;
	}

	public String getlName1() {
		return lName1;
	}

	public void setlName1(String lName1) {
		this.lName1 = lName1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getOrganization1() {
		return organization1;
	}

	public void setOrganization1(String organization1) {
		this.organization1 = organization1;
	}

	public String getfName2() {
		return fName2;
	}

	public void setfName2(String fName2) {
		this.fName2 = fName2;
	}

	public String getlName2() {
		return lName2;
	}

	public void setlName2(String lName2) {
		this.lName2 = lName2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getOrganization2() {
		return organization2;
	}

	public void setOrganization2(String organization2) {
		this.organization2 = organization2;
	}

	public String getfName3() {
		return fName3;
	}

	public void setfName3(String fName3) {
		this.fName3 = fName3;
	}

	public String getlName3() {
		return lName3;
	}

	public void setlName3(String lName3) {
		this.lName3 = lName3;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getOrganization3() {
		return organization3;
	}

	public void setOrganization3(String organization3) {
		this.organization3 = organization3;
	}

	public String getfName4() {
		return fName4;
	}

	public void setfName4(String fName4) {
		this.fName4 = fName4;
	}

	public String getlName4() {
		return lName4;
	}

	public void setlName4(String lName4) {
		this.lName4 = lName4;
	}

	public String getEmail4() {
		return email4;
	}

	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	public String getOrganization4() {
		return organization4;
	}

	public void setOrganization4(String organization4) {
		this.organization4 = organization4;
	}

	public String getfName5() {
		return fName5;
	}

	public void setfName5(String fName5) {
		this.fName5 = fName5;
	}

	public String getlName5() {
		return lName5;
	}

	public void setlName5(String lName5) {
		this.lName5 = lName5;
	}

	public String getEmail5() {
		return email5;
	}

	public void setEmail5(String email5) {
		this.email5 = email5;
	}

	public String getOrganization5() {
		return organization5;
	}

	public void setOrganization5(String organization5) {
		this.organization5 = organization5;
	}

	public String getfName6() {
		return fName6;
	}

	public void setfName6(String fName6) {
		this.fName6 = fName6;
	}

	public String getlName6() {
		return lName6;
	}

	public void setlName6(String lName6) {
		this.lName6 = lName6;
	}

	public String getEmail6() {
		return email6;
	}

	public void setEmail6(String email6) {
		this.email6 = email6;
	}

	public String getOrganization6() {
		return organization6;
	}

	public void setOrganization6(String organization6) {
		this.organization6 = organization6;
	}

	public String getfName7() {
		return fName7;
	}

	public void setfName7(String fName7) {
		this.fName7 = fName7;
	}

	public String getlName7() {
		return lName7;
	}

	public void setlName7(String lName7) {
		this.lName7 = lName7;
	}

	public String getEmail7() {
		return email7;
	}

	public void setEmail7(String email7) {
		this.email7 = email7;
	}

	public String getOrganization7() {
		return organization7;
	}

	public void setOrganization7(String organization7) {
		this.organization7 = organization7;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPaperAbstract() {
		return paperAbstract;
	}

	public void setPaperAbstract(String paperAbstract) {
		this.paperAbstract = paperAbstract;
	}

	public UploadedFile getPaper() {
		return paper;
	}

	public void setPaper(UploadedFile paper) {
		this.paper = paper;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
}
