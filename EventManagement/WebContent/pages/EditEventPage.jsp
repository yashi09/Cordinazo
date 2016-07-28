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

<title>Edit Event Page</title>
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
						<h:inputText value="#{editEventPage.event.eventName}"></h:inputText>
						<h4>event description</h4>
						<h:inputTextarea value="#{editEventPage.event.eventDescription}"></h:inputTextarea>
						<h4>First prize</h4>
						<h:inputText value="#{editEventPage.event.firstPrize}"></h:inputText>
						<h4>Second prize</h4>
						<h:inputText value="#{editEventPage.event.secondPrize}"></h:inputText>
						<h4>Third prize</h4>
						<h:inputText value="#{editEventPage.event.thirdPrize}"></h:inputText>
						<h4>Venue</h4>
						<h:inputText value="#{editEventPage.event.venue}"></h:inputText>
						<c:if test="${login.role eq 1}">
						<h:commandButton styleClass="btn btn-primary" value="Save event" action="#{editEventPage.navNext}">
							<f:setPropertyActionListener value="adminEventsOfFestPage" target="#{editEventPage.action}"/>
							<f:setPropertyActionListener value="saveEvent" target="#{editEventPage.work}"/>
						</h:commandButton>
						
						</c:if>
						<c:if test="${login.role ne 1}">
						<h:commandButton styleClass="btn btn-primary" value="Save event" action="#{editEventPage.navNext}">
							<f:setPropertyActionListener value="coordinatorPage" target="#{editEventPage.action}"/>
							<f:setPropertyActionListener value="saveEvent" target="#{editEventPage.work}"/>
						</h:commandButton>
						</c:if>
					</h:form>
				</div>
			</div>
		</div>
		<t:saveState value="#{editEventPage.event}"></t:saveState>
</f:view>
</body>
</html>