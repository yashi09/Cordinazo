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

<title>Admin Workshop Page</title>
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
				<h:commandLink value="Add Workshop"
					action="#{adminWorkshopPage.navNext}">
					<f:setPropertyActionListener value="addWorkshop"
						target="#{adminWorkshopPage.work}" />
					<f:setPropertyActionListener value="addWorkshopPage" target="#{adminWorkshopPage.action}"/>
				</h:commandLink>
				<h2 class="sub-header">Upcoming workshops</h2>
			</h:form>

			<div class="table-responsive">
				<h:form>
					<h:dataTable styleClass="table table-striped"
						value="#{adminWorkshopPage.workshops}" var="workshop">
						<h:column>
							<h:outputText value="#{workshop.eventName}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{workshop.eventDescription}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{workshop.startDate}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{workshop.endDate}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandLink value="coordinators" action="#{adminWorkshopPage.navNext}">
								<f:setPropertyActionListener value="viewCoordinators" target="#{adminWorkshopPage.work}"/>
								<f:setPropertyActionListener value="#{workshop.eventId}" target="#{adminWorkshopPage.workshopId}"/>
								<f:setPropertyActionListener value="adminCoordsOfEventPage" target="#{adminWorkshopPage.action}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink value="edit" action="#{adminWorkshopPage.navNext}">
								<f:setPropertyActionListener value="editWorkshop" target="#{adminWorkshopPage.work}"/>
								<f:setPropertyActionListener value="editWorkshopPage" target="#{adminWorkshopPage.action}"/>
								<f:setPropertyActionListener value="#{workshop.eventId}" target="#{adminWorkshopPage.workshopId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink value="delete" action="#{adminWorkshopPage.navNext}">
								<f:setPropertyActionListener value="delWorkshop" target="#{adminWorkshopPage.work}"/>
								<f:setPropertyActionListener value="adminWorkshopPage" target="#{adminWorkshopPage.action}"/>
								<f:setPropertyActionListener value="#{workshop.eventId}" target="#{adminWorkshopPage.workshopId}"/>
							</h:commandLink>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{adminWorkshopPage.workshops}"></t:saveState>
</f:view>
</body>
</html>