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

<title>Admin Coordinators Of Fest Page</title>
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
				<h:selectOneMenu value="#{adminCoordsOfEventPage.coordId}">
					<f:selectItems value="#{adminCoordsOfEventPage.organizers}"/>
				</h:selectOneMenu>
				<h:commandButton
					value="Add coordinator to #{adminCoordsOfEventPage.eventName}"
					action="#{adminCoordsOfEventPage.navNext}">
					<f:setPropertyActionListener value="adminCoordsOfEventPage"
						target="#{adminCoordsOfEventPage.action}" />
					<f:setPropertyActionListener value="addCoordToEvent"
						target="#{adminCoordsOfEventPage.work}" />
					<f:setPropertyActionListener
						value="#{adminCoordsOfEventPage.eventDto.eventId}"
						target="#{adminCoordsOfEventPage.eventId}" />
				</h:commandButton>
			</h:form>
			<h2 class="sub-header">
				Coordinators of
				<h:outputText value="#{adminCoordsOfEventPage.eventName}"></h:outputText>
			</h2>
			<div class="table-responsive">
				<h:form>
					<h:dataTable styleClass="table table-striped"
						value="#{adminCoordsOfEventPage.eventCoords}" var="coord">
						<h:column>
							<h:outputText value="#{coord.firstName} #{coord.lastName}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{coord.email}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{coord.phoneNo}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandLink value="Delete"
								action="#{adminCoordsOfEventPage.navNext}">
								<f:setPropertyActionListener value="delCoord"
									target="#{adminCoordsOfEventPage.work}" />
								<f:setPropertyActionListener value="adminCoordsOfEventPage"
									target="#{adminCoordsOfEventPage.action}" />
								<f:setPropertyActionListener
									value="#{coord.userId}"
									target="#{adminCoordsOfEventPage.coordId}" />
								<f:setPropertyActionListener value="#{adminCoordsOfEventPage.eventDto.eventId}" target="#{adminCoordsOfEventPage.eventId}"/>
							</h:commandLink>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{adminCoordsOfEventPage.eventCoords}"></t:saveState>
		<t:saveState value="#{adminCoordsOfEventPage.eventDto}"></t:saveState>
		<t:saveState value="#{adminCoordsOfEventPage.organizers}"></t:saveState>
	</f:view>
</body>
</html>