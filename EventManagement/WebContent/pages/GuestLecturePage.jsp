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
	<div class="container">
		
			<div class="col-sm-6">
				<div class="thumbnail" style="max-width: 300px;">
					<h:graphicImage alt="600x300"
						value="../images/#{guestLecturePage.guestLectureDto.eventName}.jpg"
						styleClass="img-thumbnail" style="height: 300px; width: 600px;"></h:graphicImage>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Coordinators</h3>
					</div>
					<div class="panel-body">
						<c:forEach items="#{guestLecturePage.guestLectureDto.eventUsers}" var="coord">
							<h:outputText value="#{coord.firstName} #{coord.lastName}"></h:outputText><br>
							<h:outputText value="#{coord.phoneNo}"></h:outputText><br>
							<h:outputText value="#{coord.email}"></h:outputText>
							<hr>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-default">
					<div class="panel-body">
						<h:outputText value="Date : #{guestLecturePage.guestLectureDto.startDate}"></h:outputText><br>
						<h:outputText value="Time : #{guestLecturePage.guestLectureDto.time}"></h:outputText><br>
						<h:outputText value="Venue : #{guestLecturePage.guestLectureDto.venue}"></h:outputText>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Description</h3>
					</div>
					<div class="panel-body">
						<h:outputText value="#{guestLecturePage.guestLectureDto.eventDescription}"></h:outputText>
					</div>
				</div>
			</div>
			<h:form>
				<div style="background-color: white; position: fixed; bottom: 0;">
					<c:if test="${guestLecturePage.volunteer eq true}">
						<h:commandButton styleClass="btn btn-lg btn-success"
							value="Withdraw volunteering" action="#{guestLecturePage.navNext}">
							<f:setPropertyActionListener value="guestLecturePage"
								target="#{guestLecturePage.action}" />
							<f:setPropertyActionListener value="withdrawVolunteering"
								target="#{guestLecturePage.work}" />				
						</h:commandButton>
					</c:if>
					<c:if test="${guestLecturePage.volunteer eq false}">
						<h:commandButton styleClass="btn btn-lg btn-success"
							value="Volunteer" action="#{guestLecturePage.navNext}">
							<f:setPropertyActionListener value="guestLecturePage"
								target="#{guestLecturePage.action}" />
							<f:setPropertyActionListener value="volunteer"
								target="#{guestLecturePage.work}" />
						</h:commandButton>
					</c:if>
					<c:if test="${guestLecturePage.interested eq true}">
						<h:commandButton styleClass="btn-lg btn btn-success"
							value="Not interested" action="#{guestLecturePage.navNext}">
							<f:setPropertyActionListener value="guestLecturePage"
								target="#{guestLecturePage.action}" />
							<f:setPropertyActionListener value="notInterested"
								target="#{guestLecturePage.work}" />
						</h:commandButton>
					</c:if>
					<c:if test="${guestLecturePage.interested eq false}">
						<h:commandButton styleClass="btn-lg btn btn-success"
							value="Interested" action="#{guestLecturePage.navNext}">
							<f:setPropertyActionListener value="guestLecturePage"
								target="#{guestLecturePage.action}" />
							<f:setPropertyActionListener value="interested"
								target="#{guestLecturePage.work}" />
						</h:commandButton>
					</c:if>
				</div>
			</h:form>
		</div>
		
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