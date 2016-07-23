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

<title>Add New Conference</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<div class="container">
			<div class="jumbotron col-sm-6">
				<div class="form-group center-block">
					<h:form  id="theForm">
						<h4>Conference name</h4>
						<h:inputText value="#{addConference.confName}" styleClass="form-control"></h:inputText>
						<h4>Conference description</h4>
						<h:inputTextarea value="#{addConference.confDescription}" styleClass="form-control"></h:inputTextarea>
						<h4>Acronym</h4>
						<h:inputText value="#{addConference.acronym}" styleClass="form-control"></h:inputText>
						<h4>Tentative start date of the conference (DD-MM-YYYY)</h4>
						<h:inputText value="#{addConference.startDate}" styleClass="form-control"></h:inputText>
						<h4>Tentative end date of the conference (DD-MM-YYYY)</h4>
						<h:inputText value="#{addConference.endDate}" styleClass="form-control"></h:inputText>
						<h4>Submission starts on (DD-MM-YYYY)</h4>
						<h:inputText value="#{addConference.submissionStart}" styleClass="form-control"></h:inputText>
						<h4>Submission ends on (DD-MM-YYYY)</h4>
						<h:inputText value="#{addConference.submissionEnd}" styleClass="form-control"></h:inputText>
						<h4>Acceptance notification (DD-MM-YYYY)</h4>
						<h:inputText value="#{addConference.acceptance}" styleClass="form-control"></h:inputText>
						<h4>Registration ends (DD-MM-YYYY)</h4>
						<h:inputText value="#{addConference.registration}" styleClass="form-control"></h:inputText>
						<h4>Research areas</h4>
						<h:inputText value="#{addConference.topic1}" styleClass="form-control"></h:inputText>
						<h:inputText value="#{addConference.topic2}" styleClass="form-control"></h:inputText>
						<h:inputText value="#{addConference.topic3}" styleClass="form-control"></h:inputText>
						<h:inputText value="#{addConference.topic4}" styleClass="form-control"></h:inputText>
						<h:inputText value="#{addConference.topic5}" styleClass="form-control"></h:inputText>
						<h4>Organizer</h4>
						<h:selectOneMenu value="#{addConference.organizer1}">
							<f:selectItems value="#{addConference.organizers}"/>
						</h:selectOneMenu>
						<h4>Conference scope</h4>
						<h:selectOneRadio layout="pageDirection" value="#{addConference.scope}">
							<f:selectItem itemValue="101" itemLabel="Intra-college"/>
							<f:selectItem itemValue="102" itemLabel="Intra-state"/>
							<f:selectItem itemValue="103" itemLabel="National"/>
							<f:selectItem itemValue="104" itemLabel="International"/>
						</h:selectOneRadio>
						<h4>Venue</h4>
						<h:inputText value="#{addConference.venue}" styleClass="form-control"></h:inputText>
						<h:commandButton value="Add conference" action="#{addConference.navNext}" styleClass="btn primary-btn">
							<f:setPropertyActionListener value="adminConferencePage" target="#{addConference.action}"/>
							<f:setPropertyActionListener value="addConference" target="#{addConference.work}"/>
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
		<t:saveState value="#{addConference.organizers}"></t:saveState>
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