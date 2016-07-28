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
<title>Coordinator Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="col-sm-9 col-md-10 main">
			<h2 class="sub-header">My Events</h2>

			<div class="table-responsive">
				<h:form>
					<h:dataTable value="#{coordinatorPage.events}" var="event"
						styleClass="table table-striped">
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
						<h:column>
							<f:facet name="header">
								<h:outputText value="Venue"></h:outputText>
							</f:facet>
							<h:outputText value="#{event.venue}"></h:outputText>
						</h:column>
						<c:choose>
							<c:when
								test="${event.class.name == 'ConferenceDetailsDto'}">
								<h:column>
									<h:commandLink value="Edit conference"
										action="#{coordinatorPage.navNext}">
										<f:setPropertyActionListener value="#{event.eventId}"
											target="#{coordinatorPage.eventId}" />
										<f:setPropertyActionListener value="editConferencePage"
											target="#{coordinatorPage.action}" />
									</h:commandLink>
								</h:column>
							</c:when>
							<c:otherwise>
							<c:choose>
								<c:when
									test="${event.class.name == 'WorkshopDetailsDto'}">
									<h:column>
										<h:commandLink value="Edit workshop"
											action="#{coordinatorPage.navNext}">
											<f:setPropertyActionListener value="#{event.eventId}"
												target="#{coordinatorPage.eventId}" />
											<f:setPropertyActionListener value="editWorkshopPage"
												target="#{coordinatorPage.action}" />
										</h:commandLink>
									</h:column>
								</c:when>
								<c:otherwise>
								<c:choose>
									<c:when
										test="${event.class.name == 'GuestLectureDetailsDto'}">
										<h:column>
											<h:commandLink value="Edit guest lecture"
												action="#{coordinatorPage.navNext}">
												<f:setPropertyActionListener value="#{event.eventId}"
													target="#{coordinatorPage.eventId}" />
												<f:setPropertyActionListener value="editGuestLecture"
													target="#{coordinatorPage.action}" />
											</h:commandLink>
										</h:column>
									</c:when>
									<c:otherwise>
										<h:column>
											<h:commandLink value="Edit event"
												action="#{coordinatorPage.navNext}">
												<f:setPropertyActionListener value="#{event.eventId}"
													target="#{coordinatorPage.eventId}" />
												<f:setPropertyActionListener value="editEventPage"
													target="#{coordinatorPage.action}" />
											</h:commandLink>
										</h:column>
									</c:otherwise>
									</c:choose>
								</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						<h:column>
							<h:commandLink value="Coordinators"
								action="#{coordinatorPage.navNext}">
								<f:setPropertyActionListener value="#{event.eventId}"
									target="#{coordinatorPage.eventId}" />
								<f:setPropertyActionListener value="viewCoordsOfEvent"
									target="#{coordinatorPage.action}" />
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink value="Volunteers"
								action="#{coordinatorPage.navNext}">
								<f:setPropertyActionListener value="#{event.eventId}"
									target="#{coordinatorPage.eventId}" />
								<f:setPropertyActionListener value="volunteersOfEvent"
									target="#{coordinatorPage.action}" />
							</h:commandLink>
						</h:column>
						<h:column>
							<h:commandLink value="Participants"
								action="#{coordinatorPage.navNext}">
								<f:setPropertyActionListener value="#{event.eventId}"
									target="#{coordinatorPage.eventId}" />
								<f:setPropertyActionListener value="participantsOfEvent"
									target="#{coordinatorPage.action}" />
							</h:commandLink>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{coordinatorPage.events}"></t:saveState>
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