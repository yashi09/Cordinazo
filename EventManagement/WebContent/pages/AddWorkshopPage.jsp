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

<title>Add New Workshop</title>
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
						<h4>Workshop name</h4>
						<h:inputText value="#{addWorkshopPage.wsName}"></h:inputText><br>
						<h4>Workshop description</h4>
						<h:inputTextarea value="#{addWorkshopPage.wsDesc}"></h:inputTextarea><br>
						<h4>Tentative start date (dd-mm-yyyy)</h4>
						<h:inputText value="#{addWorkshopPage.startDate}"></h:inputText><br>
						<h4>Tentative end date (dd-mm-yyyy)</h4>
						<h:inputText value="#{addWorkshopPage.endDate}"></h:inputText><br>
						<h4>Fees</h4>
						<h:inputText value="#{addWorkshopPage.fees}"></h:inputText><br>
						<h4>Scope</h4>
						<h:selectOneRadio value="#{addWorkshopPage.scope}" layout="pageDirection">
							<f:selectItem itemValue="101" itemLabel="Intra-college"/>
							<f:selectItem itemValue="102" itemLabel="Intra-state"/>
							<f:selectItem itemValue="103" itemLabel="National"/>
							<f:selectItem itemValue="104" itemLabel="International"/>
						</h:selectOneRadio>
						<h4>Venue</h4>
						<h:inputText value="#{addWorkshopPage.venue}"></h:inputText>
						<h:commandButton value="Add workshop" action="#{addWorkshopPage.navNext}">
							<f:setPropertyActionListener value="adminWorkshopPage" target="#{addWorkshopPage.action}"/>
							<f:setPropertyActionListener value="addWorkshop" target="#{addWorkshopPage.work}"/>
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
</f:view>
</body>
</html>