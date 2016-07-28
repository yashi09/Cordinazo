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

<title>Admin Guest Lecture Page</title>
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
				<h:commandLink value="Add gest lecture"
					action="#{adminGuestLecture.navNext}">
					<f:setPropertyActionListener value="addGuestLecture" target="#{adminGuestLecture.action}"/>
				</h:commandLink>
				<h2 class="sub-header">Upcoming guest lectures</h2>
			</h:form>

			<div class="table-responsive">
				<h:form>
					<h:dataTable styleClass="table table-striped"
						value="#{adminGuestLecture.guestLectures}" var="guestLecture">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name"></h:outputText>
							</f:facet>
							<h:outputText value="#{guestLecture.eventName}"></h:outputText>
						</h:column>
						<h:column>
						<f:facet name="header">
								<h:outputText value="Date"></h:outputText>
							</f:facet>
							<h:outputText value="#{guestLecture.startDate}"></h:outputText>
						</h:column>
						<h:column>
						<f:facet name="header">
								<h:outputText value="Time"></h:outputText>
							</f:facet>
							<h:outputText value="#{guestLecture.time}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandLink value="coordinators" action="#{adminGuestLecture.navNext}">
								<f:setPropertyActionListener value="adminCoordsOfEventPage" target="#{adminGuestLecture.action}"/>
								<f:setPropertyActionListener value="viewCoords" target="#{adminGuestLecture.work}"/>
								<f:setPropertyActionListener value="#{guestLecture.eventId}" target="#{adminGuestLecture.guestLectureId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink value="edit" action="#{adminGuestLecture.navNext}">
								<f:setPropertyActionListener value="editGuestLecture" target="#{adminGuestLecture.action}"/>
								<f:setPropertyActionListener value="edit" target="#{adminGuestLecture.work}"/>
								<f:setPropertyActionListener value="#{guestLecture.eventId}" target="#{adminGuestLecture.guestLectureId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink value="delete" action="#{adminGuestLecture.navNext}">
								<f:setPropertyActionListener value="adminGuestLecture" target="#{adminGuestLecture.action}"/>
								<f:setPropertyActionListener value="del" target="#{adminGuestLecture.work}"/>
								<f:setPropertyActionListener value="#{guestLecture.eventId}" target="#{adminGuestLecture.guestLectureId}"/>
							</h:commandLink>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{adminGuestLecture.guestLectures}"></t:saveState>
</f:view>
</body>
</html>