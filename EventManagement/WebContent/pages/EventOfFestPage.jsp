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

<title>Event Of Fest</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="row">
			<div class="col-sm-12"
				style="background-color: grey; padding-left: 20px;">
				<h3>
					<h:outputText value="#{eventsOfFest.eventName}"></h:outputText>
				</h3>
			</div>
		</div>
		<div class="container" style="margin-top: 2%;">

			<div class="col-sm-5">
				<div class="thumbnail" style="max-width: 300px;">
					<h:graphicImage alt="100x100"
						value="../images/#{eventsOfFest.eventName}.jpg"
						styleClass="img-thumbnail" style="height: 300px; width: 300px;"></h:graphicImage>
				</div>
			</div>

			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Prizes</h3>
					</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item">First prize : <h:outputText
									value="#{eventsOfFest.firstPrize}"></h:outputText></li>
							<li class="list-group-item">Second prize : <h:outputText
									value="#{eventsOfFest.secondPrize}"></h:outputText></li>
							<li class="list-group-item">Third prize : <h:outputText
									value="#{eventsOfFest.thirdPrize}"></h:outputText></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Event Coordinators</h3>
					</div>
					<div class="panel-body">
						<h:dataTable value="#{eventsOfFest.eventCoordinaters}"
							var="coordinator">
							<h:column>
								<h:outputText
									value="#{coordinator.firstName} #{coordinator.lastName}"></h:outputText>
								<br>
								<h:outputText value="#{coordinator.phoneNo}"></h:outputText>
								<br>
								<h:outputText value="#{coordinator.email}"></h:outputText>
								<hr>
							</h:column>
						</h:dataTable>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Description</h3>
					</div>
					<div class="panel-body">
						<h:outputText value="#{eventsOfFest.eventDesc}"></h:outputText>
					</div>
				</div>
			</div>

			<h:form>
				<div style="background-color: white; position: fixed; bottom: 0;">
					<c:if test="${eventsOfFest.volunteer eq true}">
						<h:commandButton styleClass="btn btn-lg btn-success"
							value="Withdraw volunteering" action="#{eventsOfFest.navNext}">
							<f:setPropertyActionListener value="eventsOfFest"
								target="#{eventsOfFest.action}" />
							<f:setPropertyActionListener value="withdrawVolunteering"
								target="#{eventsOfFest.work}" />
							<f:setPropertyActionListener
								value="#{eventsOfFest.eventDetail.eventId}"
								target="#{eventsOfFest.eventId}" />
						</h:commandButton>
					</c:if>
					<c:if test="${eventsOfFest.volunteer eq false}">
						<h:commandButton styleClass="btn btn-lg btn-success"
							value="Volunteer" action="#{eventsOfFest.navNext}">
							<f:setPropertyActionListener value="eventsOfFest"
								target="#{eventsOfFest.action}" />
							<f:setPropertyActionListener value="volunteer"
								target="#{eventsOfFest.work}" />
							<f:setPropertyActionListener
								value="#{eventsOfFest.eventDetail.eventId}"
								target="#{eventsOfFest.eventId}" />
						</h:commandButton>
					</c:if>
					<c:if test="${eventsOfFest.participant eq true}">
						<h:commandButton styleClass="btn-lg btn btn-success"
							value="Withdraw participation" action="#{eventsOfFest.navNext}">
							<f:setPropertyActionListener value="eventsOfFest"
								target="#{eventsOfFest.action}" />
							<f:setPropertyActionListener value="withdrawParticipation"
								target="#{eventsOfFest.work}" />
							<f:setPropertyActionListener
								value="#{eventsOfFest.eventDetail.eventId}"
								target="#{eventsOfFest.eventId}" />
						</h:commandButton>
					</c:if>
					<c:if test="${eventsOfFest.participant eq false}">
						<h:commandButton styleClass="btn-lg btn btn-success"
							value="Participate" action="#{eventsOfFest.navNext}">
							<f:setPropertyActionListener value="eventsOfFest"
								target="#{eventsOfFest.action}" />
							<f:setPropertyActionListener value="participate"
								target="#{eventsOfFest.work}" />
							<f:setPropertyActionListener
								value="#{eventsOfFest.eventDetail.eventId}"
								target="#{eventsOfFest.eventId}" />
						</h:commandButton>
					</c:if>
				</div>
			</h:form>
		</div>
		<t:saveState value="#{eventsOfFest.eventDetail}"></t:saveState>
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