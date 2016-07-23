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

<title>Admin Conference Page</title>
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
				<h:commandLink value="Add Conference"
					action="#{adminConferencePage.navNext}">
					<f:setPropertyActionListener value="addConference"
						target="#{adminConferencePage.action}" />
				</h:commandLink>
				<h2 class="sub-header">Upcoming conferences</h2>
			</h:form>

			<div class="table-responsive">
				<h:form>
					<h:dataTable styleClass="table table-striped"
						value="#{adminConferencePage.conferences}" var="conference">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Name"></h:outputText>
							</f:facet>
							<h:outputText value="#{conference.eventName}"></h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Acronym"></h:outputText>
							</f:facet>
							<h:outputText value="#{conference.acronym}"></h:outputText>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Submission"></h:outputText>
							</f:facet>
							<h:outputText value="#{conference.submissionEnd}"></h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Acceptance"></h:outputText>
							</f:facet>
							<h:outputText value="#{conference.acceptanceDate}"></h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Registration"></h:outputText>
							</f:facet>
							<h:outputText value="#{conference.registrationDate}"></h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Duration"></h:outputText>
							</f:facet>
							<h:outputText
								value="#{conference.startDate}"></h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Venue"></h:outputText>
							</f:facet>
							<h:outputText value="#{conference.venue}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandLink action="#{adminConferencePage.navNext}"
								value="edit">
								<f:setPropertyActionListener value="edit" target="#{adminConferencePage.work}" />
								<f:setPropertyActionListener value="editConferencePage" target="#{adminConferencePage.action}"/>
								<f:setPropertyActionListener value="#{conference.eventId}" target="#{adminConferencePage.conferenceId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink action="#{adminConferencePage.navNext}"
								value="papers">
								<f:setPropertyActionListener value="viewPapers" target="#{adminConferencePage.work}" />
								<f:setPropertyActionListener value="papersOfConference" target="#{adminConferencePage.action}"/>
								<f:setPropertyActionListener value="#{conference.eventId}" target="#{adminConferencePage.conferenceId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink action="#{adminConferencePage.navNext}"
								value="research areas">
								<f:setPropertyActionListener value="researchAreas" target="#{adminConferencePage.work}" />
								<f:setPropertyActionListener value="adminConfResearchAreas" target="#{adminConferencePage.action}"/>
								<f:setPropertyActionListener value="#{conference.eventId}" target="#{adminConferencePage.conferenceId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink action="#{adminConferencePage.navNext}"
								value="coordinators">
								<f:setPropertyActionListener value="viewCoords" target="#{adminConferencePage.work}" />
								<f:setPropertyActionListener value="adminCoordsOfEventPage" target="#{adminConferencePage.action}"/>
								<f:setPropertyActionListener value="#{conference.eventId}" target="#{adminConferencePage.conferenceId}"/>
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink action="#{adminConferencePage.navNext}"
								value="delete">
								<f:setPropertyActionListener value="delete" target="#{adminConferencePage.work}" />
								<f:setPropertyActionListener value="#{conference.eventId}" target="#{adminConferencePage.conferenceId}"/>
								<f:setPropertyActionListener value="adminConferencePage" target="#{adminConferencePage.action}"/>
							</h:commandLink>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{adminConferencePage.conferences}"></t:saveState>
	</f:view>
	<script src="../js/jQuery.min.js"></script>
	<script type="text/javascript" src="../js/ie10-viewport.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/docs.min.js"></script>
	<script type="text/javascript" src="../js/base.js"></script>
	<script type="text/javascript" src="../js/prettify-1.0.min.js"></script>
	<script>
		if (top != self) {
			top.location.replace(self.location.href);
		}
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-47462200-1', 'eonasdan.github.io');
		ga('send', 'pageview');
	</script>
</body>
</html>