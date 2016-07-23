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

<title>Event Management Home</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css">
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="container theme-showcase">
		<h:form>
			<div class="row">
				<div class="col-sm-6">

					<h:commandLink action="#{homePage.navNext}" style="text-decoration: none;">
						<div class="panel home-list"
							style="margin-top: 3%; background-image: url('../images/workshops.jpg'); padding-left: 5%; padding-bottom: 30%;">
							<h1>Workshops</h1>
						</div>
						<f:setPropertyActionListener value="workshopPage" target="#{homePage.action}"/>
						<f:setPropertyActionListener value="202" target="#{homePage.eventTypeId}"/>
					</h:commandLink>
				</div>
				<div class="col-sm-6">
					<h:commandLink action="#{homePage.navNext}" style="text-decoration: none;">
						<div class="panel home-list"
							style="margin-top: 3%; background-image: url('../images/conferences.jpg'); padding-left: 5%; padding-bottom: 30%;">
							<h1>Conferences</h1>
						</div>
						<f:setPropertyActionListener value="conferencePage" target="#{homePage.action}"/>
						<f:setPropertyActionListener value="201" target="#{homePage.eventTypeId}"/>
					</h:commandLink>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9">
					<h:commandLink action="#{homePage.navNext}" style="text-decoration: none;">
						<div class="panel home-list"
							style="background-image: url('../images/events.jpg'); padding-left: 5%; padding-bottom: 33%;">
							<h1>Upcoming Events</h1>
						</div>
						<f:setPropertyActionListener value="festPage" target="#{homePage.action}"/>
						<f:setPropertyActionListener value="204" target="#{homePage.eventTypeId}"/>
					</h:commandLink>
				</div>
				<div class="col-sm-3">
					<h:commandLink action="#{homePage.navNext}" style="text-decoration: none;">

						<div class="panel home-list"
							style="background-image: url('../images/guest_lectures.jpg'); padding-left: 10%; padding-bottom: 91%;">
							<h1>Guest Lectures</h1>
						</div>
						<f:setPropertyActionListener value="guestLecturePage" target="#{homePage.action}"/>
						<f:setPropertyActionListener value="203" target="#{homePage.eventTypeId}"/>
					</h:commandLink>
				</div>
			</div>
			</h:form>
		</div>
	</f:view>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- 	<script src="../js/jQuery.min.js"></script>
 -->	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/ie10-viewport.js"></script>
	<script type="text/javascript" src="../js/docs.min.js"></script>
</body>
</html>