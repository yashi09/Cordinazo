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
				<h:form id="theForm">
		
		<div class="row ">
			<div class="col-sm-12">
				<div class="col-sm-6 col-sm-offset-3">
					<h1>
						<h:outputText value="#{conferenceDetails.conference.eventName}"></h:outputText><br>
						<h:outputText value="#{conferenceDetails.conference.acronym}"></h:outputText>
					</h1>
					<h3>
						<h:outputText
							value="#{conferenceDetails.conference.eventDescription}"></h:outputText>
					</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="container">
			<div class="col-sm-4"> 
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Important links</h3>
					</div>
					<div class="panel-body">
					<ul class="list-group">
							<li class="list-group-item"><h:commandLink value="My submissions" action="#{conferenceDetails.navNext}">
								<f:setPropertyActionListener value="mySubmissions" target="#{conferenceDetails.work}"/>
								<f:setPropertyActionListener value="mySubmissions" target="#{conferenceDetails.action}"/>
							</h:commandLink></li>
							<li class="list-group-item"><h:commandLink value="Make a submission" action="#{conferenceDetails.navNext}">
								<f:setPropertyActionListener value="submitPaper" target="#{conferenceDetails.work}"/>
								<f:setPropertyActionListener value="submitPaper" target="#{conferenceDetails.action}"/>
							</h:commandLink></li>
							<li class="list-group-item">
							<h:commandLink value="Accepted format" id="format" onclick="window.open('../images/format.pdf');">
								<f:setPropertyActionListener value="paperFormat" target="#{conferenceDetails.work}"/>
								<f:setPropertyActionListener value="paperFormat" target="#{conferenceDetails.action}"/>
							</h:commandLink>
							<li class="list-group-item"><h:commandLink value="Program shedule" action="#{conferenceDetails.navNext}">
								<f:setPropertyActionListener value="programSchedule" target="#{conferenceDetails.action}"/>
								<f:setPropertyActionListener value="programSchedule" target="#{conferenceDetails.work}"/>
							</h:commandLink>
							<li class="list-group-item"><h:commandLink value="Organizing committee" action="#{conferenceDetails.navNext}">
								<f:setPropertyActionListener value="organizingCommittee" target="#{conferenceDetails.work}"/>
								<f:setPropertyActionListener value="organizingCommittee" target="#{conferenceDetails.action}"/>
							</h:commandLink>
							<li class="list-group-item"><h:commandLink value="Accepted papers"></h:commandLink>
							<li class="list-group-item"><h:commandLink value="Registered papers"></h:commandLink>
					</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Important dates</h3>
					</div>
					<div class="panel-body">
						Start of paper submission <b><h:outputText value="#{conferenceDetails.conference.submissionStart}"></h:outputText></b><br>
						Last date for paper submission <b><h:outputText value="#{conferenceDetails.conference.submissionEnd}"></h:outputText></b><br>
						Acceptance notification to authors <b><h:outputText value="#{conferenceDetails.conference.acceptanceDate}"></h:outputText></b>
						Registration <b><h:outputText value="#{conferenceDetails.conference.registrationDate}"></h:outputText></b><br>
						Conference dates <b><h:outputText value="#{conferenceDetails.conference.startDate} - #{conferenceDetails.conference.endDate}"></h:outputText></b>
					</div>
				</div>
			</div>
			</div>
		</div>
		</h:form>
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
	<script type="text/javascript">
		document.getElementById('theForm:format').href="../images/format.pdf";
	</script>
</body>
</html>