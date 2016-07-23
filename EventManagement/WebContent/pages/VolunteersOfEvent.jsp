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
<title>Volunteers Of event</title>
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
			<h2 class="sub-header">
				<h:outputText value="#{volunteersOfEvent.event.eventName} "></h:outputText>
				volunteers
			</h2>
			<div class="table-responsive">
				<h:form>
					<h:dataTable value="#{volunteersOfEvent.volunteers}"
						var="volunteer" styleClass="table table-striped">
						<h:column>
							<h:outputText
								value="#{volunteer.firstName} #{volunteer.lastName}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{volunteer.phoneNo}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="#{volunteer.email}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandLink value="delete" action="#{volunteersOfEvent.navNext}">
								<f:setPropertyActionListener value="volunteersOfEvent" target="#{volunteersOfEvent.action}"/>
								<f:setPropertyActionListener value="#{volunteer.userId}" target="#{volunteersOfEvent.volunteerId}"/>
								<f:setPropertyActionListener value="delVolunteer" target="#{volunteersOfEvent.work}"/>
								<f:setPropertyActionListener value="#{volunteersOfEvent.event.eventId}" target="#{volunteersOfEvent.eventId}"/>
							</h:commandLink>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{volunteersOfEvent.volunteers}"></t:saveState>
		<t:saveState value="#{volunteersOfEvent.event}"></t:saveState>
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