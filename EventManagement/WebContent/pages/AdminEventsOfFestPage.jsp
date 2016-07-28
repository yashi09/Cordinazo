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

<title>Admin Events Of Fest Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="Sidebar.jsp"></jsp:include>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h:form>
				<h:commandLink value="Add event to #{adminEventsOfFestPage.festName}" action="#{adminEventsOfFestPage.navNext}">
					<f:setPropertyActionListener value="addEventToFestPage" target="#{adminEventsOfFestPage.action}"/>
					<f:setPropertyActionListener value="#{adminEventsOfFestPage.festDto.festId}" target="#{adminEventsOfFestPage.festId}"/>
					<f:setPropertyActionListener value="addEventToFest" target="#{adminEventsOfFestPage.work}"/>
				</h:commandLink>
				<h2 class="sub-header">Events of <h:outputText value="#{adminEventsOfFestPage.festName}"></h:outputText></h2>
			</h:form> 
			
			<div class="table-responsive">
			<h:form>
				<h:dataTable styleClass="table table-striped"
					value="#{adminEventsOfFestPage.festEvents}" var="event">
					<h:column>
					<f:facet name="header">
								<h:outputText value="Name"></h:outputText>
							</f:facet>
					<h:outputText value="#{event.eventName}"></h:outputText>
					</h:column>
					<h:column>
					<f:facet name="header">
								<h:outputText value="Description"></h:outputText>
							</f:facet>
					<h:outputText value="#{event.eventDescription}"></h:outputText>
					</h:column>
					<h:column>
					<f:facet name="header">
								<h:outputText value="Venue"></h:outputText>
							</f:facet>
					<h:outputText value="#{event.venue}"></h:outputText>
					</h:column>
					<h:column>
					<f:facet name="header">
								<h:outputText value="1st prize"></h:outputText>
							</f:facet>
					<h:outputText value="#{event.firstPrize}"></h:outputText>
					</h:column>
					<h:column>
					<f:facet name="header">
								<h:outputText value="2nd prize"></h:outputText>
							</f:facet>
					<h:outputText value="#{event.secondPrize}"></h:outputText>
					</h:column>
					<h:column>
					<f:facet name="header">
								<h:outputText value="3rd prize"></h:outputText>
							</f:facet>
					<h:outputText value="#{event.thirdPrize}"></h:outputText>
					</h:column>
					<h:column><h:commandLink value="Coordinators" action="#{adminEventsOfFestPage.navNext}">
						<f:setPropertyActionListener value="viewEventCoordinators" target="#{adminEventsOfFestPage.work}"/>
						<f:setPropertyActionListener value="#{event.eventId}" target="#{adminEventsOfFestPage.eventId}"/>
						<f:setPropertyActionListener value="adminCoordsOfEventPage" target="#{adminEventsOfFestPage.action}"/>
					</h:commandLink>
					</h:column>
					<h:column><h:commandLink value="Edit" action="#{adminEventsOfFestPage.navNext}">
						<f:setPropertyActionListener value="editEvent" target="#{adminEventsOfFestPage.work}"/>
						<f:setPropertyActionListener value="#{event.eventId}" target="#{adminEventsOfFestPage.eventId}"/>
						<f:setPropertyActionListener value="editEventPage" target="#{adminEventsOfFestPage.action}"/>
					</h:commandLink>
					</h:column>
					<h:column><h:commandLink value="Delete" action="#{adminEventsOfFestPage.navNext}">
						<f:setPropertyActionListener value="deleteEvent" target="#{adminEventsOfFestPage.work}"/>
						<f:setPropertyActionListener value="#{event.eventId}" target="#{adminEventsOfFestPage.eventId}"/>
						<f:setPropertyActionListener value="#{adminEventsOfFestPage.festDto.festId}" target="#{adminEventsOfFestPage.festId}"/>
						<f:setPropertyActionListener value="adminEventsOfFestPage" target="#{adminEventsOfFestPage.action}"/>
					</h:commandLink>
					</h:column>
				</h:dataTable>
			</h:form>
		</div>
		</div>
		<t:saveState value="#{adminEventsOfFestPage.festDto}"></t:saveState>
		<t:saveState value="#{adminEventsOfFestPage.festEvents}"></t:saveState>
</f:view>
</body>
</html>