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

<title>Conference Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="row ">
			<div class="col-sm-12"
				style="background-image: url('../images/conference_banner.jpg'); background-size: cover; color: white; padding-left: 5%; padding-bottom: 10%;">
				<h1>Conferences</h1>
				<%--<h3>Because in your dreams, every detail matters</h3> --%>
			</div>
		</div>
		<div class="row">
			<div class="container" style="padding-top: 15px;">
				<h:form>
					<h:panelGrid columns="4">
						<c:forEach items="#{conferencePage.conferences}" var="conference">
							<h:column>
								<div class="col-sm-12">
									<div class="thumbnail">
										<h:graphicImage id="image" alt="200x200"
											styleClass="img-thumbnail"
											style="height: 200px; width: 200px;"
											value="../images/#{conference.eventName}.jpg">
										</h:graphicImage>
										<div class="caption">
										<h3><h:outputText value="#{conference.eventName}"></h:outputText></h3>
										<p><h:outputText value="#{conference.startDate} to #{conference.endDate}"></h:outputText></p>
										<h:commandLink styleClass="btn secondary-button" action="#{conferencePage.navNext}">
											More details &raquo;
											<f:setPropertyActionListener value="#{conference.eventId}" target="#{conferencePage.conferenceId}"/>
											<f:setPropertyActionListener value="conferenceDetails" target="#{conferencePage.action}"/>
										</h:commandLink>
										</div>
									</div>
								</div>
							</h:column>
						</c:forEach>
					</h:panelGrid>
				</h:form>
			</div>
		</div>
		<t:saveState value="#{conferencePage.conferences}"></t:saveState>
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