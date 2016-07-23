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

<title>Edit Fest Page</title>
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
					<h:form id="theForm">
						<h4>Fest name</h4>
						<h:inputText value="#{editFestPage.fest.festName}"></h:inputText>
						<h4>Fest Description</h4>
						<h:inputTextarea value="#{editFestPage.fest.festDescription}"></h:inputTextarea>
						<h4>Start date</h4>
						<h:inputText value="#{editFestPage.fest.startDate}"></h:inputText>
						<h4>End date</h4>
						<h:inputText value="#{editFestPage.fest.endDate}"></h:inputText>
						<h4>Venue</h4>
						<h:inputText value="#{editFestPage.fest.venue}"></h:inputText>
						<h4>Fest Scope</h4>
						<h:selectOneRadio value="#{editFestPage.fest.scopeDto.scopeId}" layout="pageDirection">
							<f:selectItem itemValue="101" itemLabel="Intra-college"/>
							<f:selectItem itemValue="102" itemLabel="Intra-state"/>
							<f:selectItem itemValue="103" itemLabel="National"/>
							<f:selectItem itemValue="104" itemLabel="International"/>
						</h:selectOneRadio>
						<h4>Fest type</h4>
						<h:selectOneRadio value="#{editFestPage.fest.typeDto.eventTypeId}" layout="pageDirection">
							<f:selectItem itemValue="110" itemLabel="Cultural fest"/>
							<f:selectItem itemValue="120" itemLabel="Technical fest"/>
						</h:selectOneRadio>
						<h:commandButton styleClass="btn btn-primary" action="#{editFestPage.navNext}" value="Save Fest">
							<f:setPropertyActionListener value="adminFestPage" target="#{editFestPage.action}"/>
							<f:setPropertyActionListener value="saveFest" target="#{editFestPage.work}"/>
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
		<t:saveState value="#{editFestPage.fest}"></t:saveState>
</f:view>
</body>
</html>