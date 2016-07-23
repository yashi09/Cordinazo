<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Submit a paper</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="container">
			<div class="jumbotron col-sm-10">
				<div class="form-group center-block">
					<h:form id="theForm" enctype="multipart/form-data">
						<div class="panel panel-default">
							<div class="panel-body">
								<h3>Author 1</h3>
								<br> First name :
								<h:inputText value="#{submitPaper.fName1}"></h:inputText>
								<br> Last name :
								<h:inputText value="#{submitPaper.lName1}"></h:inputText>
								Email :
								<h:inputText value="#{submitPaper.email1}"></h:inputText>
								Organization :
								<h:inputText value="#{submitPaper.organization1}"></h:inputText>
								<h3>Author 2</h3>
								<br> First name :
								<h:inputText value="#{submitPaper.fName2}"></h:inputText>
								<br> Last name :
								<h:inputText value="#{submitPaper.lName2}"></h:inputText>
								Email :
								<h:inputText value="#{submitPaper.email2}"></h:inputText>
								Organization :
								<h:inputText value="#{submitPaper.organization2}"></h:inputText>
								<h3>Author 3</h3>
								<br> First name :
								<h:inputText value="#{submitPaper.fName3}"></h:inputText>
								<br> Last name :
								<h:inputText value="#{submitPaper.lName3}"></h:inputText>
								Email :
								<h:inputText value="#{submitPaper.email3}"></h:inputText>
								Organization :
								<h:inputText value="#{submitPaper.organization3}"></h:inputText>
								<h3>Author 4</h3>
								<br> First name :
								<h:inputText value="#{submitPaper.fName4}"></h:inputText>
								<br> Last name :
								<h:inputText value="#{submitPaper.lName4}"></h:inputText>
								Email :
								<h:inputText value="#{submitPaper.email4}"></h:inputText>
								Organization :
								<h:inputText value="#{submitPaper.organization4}"></h:inputText>
								<h3>Author 5</h3>
								<br> First name :
								<h:inputText value="#{submitPaper.fName5}"></h:inputText>
								<br> Last name :
								<h:inputText value="#{submitPaper.lName5}"></h:inputText>
								Email :
								<h:inputText value="#{submitPaper.email5}"></h:inputText>
								Organization :
								<h:inputText value="#{submitPaper.organization5}"></h:inputText>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-body">
							Title : <h:inputText value="#{submitPaper.title}"></h:inputText><br>
							Abstract : <h:inputTextarea value="#{submitPaper.paperAbstract}"></h:inputTextarea>
							</div>
						</div>
						<t:inputFileUpload value="#{submitPaper.paper}" label="Browse file" storage="file"></t:inputFileUpload>
						<h:commandButton styleClass="btn" value="Submit" action="#{submitPaper.navNext}">
							<f:setPropertyActionListener value="submitPaper" target="#{submitPaper.work}"/>
							<f:setPropertyActionListener value="conferenceDetails" target="#{submitPaper.action}"/>
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
	</f:view>
</body>
</html>