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

<title>Add New Guest Lecture</title>
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
						<h3>Name</h3>
						<h:inputText value="#{addGuestLecture.glName}"></h:inputText><br>
						<h3>Description</h3>
						<h:inputText value="#{addGuestLecture.desc}"></h:inputText><br>
						<h3>Date</h3>
						<h:inputText value="#{addGuestLecture.date}"></h:inputText><br>
						<h3>Time (hh:mm)</h3>
						<h:inputText value="#{addGuestLecture.time}"></h:inputText><br>
						<h3>Venue</h3>
						<h:inputText value="#{addGuestLecture.venue}"></h:inputText><br>
						<h3>Scope</h3>
						<h:selectOneRadio value="#{addGuestLecture.scope}" layout="pageDirection">
							<f:selectItem itemValue="101" itemLabel="Intra-college"/>
							<f:selectItem itemValue="102" itemLabel="Intra-state"/>
							<f:selectItem itemValue="103" itemLabel="National"/>
							<f:selectItem itemValue="104" itemLabel="International"/>
						</h:selectOneRadio>
						<h:commandButton value="Add guest lecture" action="#{addGuestLecture.navNext}">
							<f:setPropertyActionListener value="addGuestLecture" target="#{addGuestLecture.work}"/>
							<f:setPropertyActionListener value="adminGuestLecture" target="#{addGuestLecture.action}"/>
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
</f:view>
</body>
</html>