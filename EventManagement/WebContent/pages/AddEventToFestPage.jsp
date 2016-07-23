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

<title>Add Event To Fest</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<div class="container">
			<div class="jumbotron col-sm-6">
				<div class="form-group center-block">
					<h:form id="theForm">
						<h4>Event name</h4>
						<h:inputText styleClass="form-control"
							value="#{addEventToFestPage.eventName}"></h:inputText>
						<h4>Add coordinators</h4>
						<h:selectOneMenu value="#{addEventToFestPage.coordId1}">
							<f:selectItems value="#{addEventToFestPage.organizers}"/>
						</h:selectOneMenu>
						
						<h:selectOneMenu value="#{addEventToFestPage.coordId2}">
							<f:selectItems value="#{addEventToFestPage.organizers}"/>
						</h:selectOneMenu>
						
						<h:selectOneMenu value="#{addEventToFestPage.coordId3}">
							<f:selectItems value="#{addEventToFestPage.organizers}"/>
						</h:selectOneMenu>

						<h:commandButton value="Save"
							action="#{addEventToFestPage.navNext}">
							<f:setPropertyActionListener value="addEventToFest"
								target="#{addEventToFestPage.work}" />
							<f:setPropertyActionListener value="adminEventsOfFestPage"
								target="#{addEventToFestPage.action}" />
							<f:setPropertyActionListener value="#{addEventToFestPage.festDto.festId}" target="#{addEventToFestPage.festId}"/>
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
		<t:saveState value="#{addEventToFestPage.festDto}"></t:saveState>
		<t:saveState value="#{addEventToFestPage.organizers}"></t:saveState>
	</f:view>
</body>
</html>