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

<title>Add New Fest</title>
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
						<h4>Fest name</h4>
						<h:inputText value="#{addFest.festName}" styleClass="form-control"></h:inputText>
						<h4>Fest description</h4>
						<h:inputTextarea value="#{addFest.festDescription}"
							styleClass="form-control"></h:inputTextarea>
						<h4>Start date (DD-MM-YYYY)</h4>
						<h:inputText value="#{addFest.startDate}"
							styleClass="form-control ext-date"></h:inputText>
						<h4>End date (DD-MM-YYYY)</h4>
						<h:inputText value="#{addFest.endDate}"
							styleClass="form-control ext-date"></h:inputText>
						<h4>Fest scope</h4>
						<h:selectOneRadio value="#{addFest.scopeId}"
							layout="pageDirection"
							style="font-size: 16px; font-weight: normal">
							<f:selectItem itemValue="101" itemLabel="Intra-college" />
							<f:selectItem itemValue="102" itemLabel="Intra-state" />
							<f:selectItem itemValue="103" itemLabel="National" />
							<f:selectItem itemValue="104" itemLabel="International" />
						</h:selectOneRadio>
						<h4>Fest Type</h4>
						<h:selectOneRadio value="#{addFest.typeId}" layout="pageDirection"
							style="font-size: 16px; font-weight: normal">
							<f:selectItem itemValue="110" itemLabel="Cultural fest" />
							<f:selectItem itemValue="120" itemLabel="Technical fest" />
						</h:selectOneRadio>
						<div class="row">
						<div class="col-sm-2">
							<h4>Event 1</h4>
							<h:inputText value="#{addFest.eventName1}" id="event1"></h:inputText>
							<h:selectOneMenu value="#{addFest.coordinator11}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{addFest.coordinator12}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{addFest.coordinator13}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
						</div>
						<div class="col-sm-2">
							<h4>Event 2</h4>
							<h:inputText value="#{addFest.eventName2}" id="event2"></h:inputText>
							<h:selectOneMenu value="#{addFest.coordinator21}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{addFest.coordinator22}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{addFest.coordinator23}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
						</div>
						<div class="col-sm-2">
							<h4>Event 3</h4>
							<h:inputText value="#{addFest.eventName3}" id="event3"></h:inputText>
							<h:selectOneMenu value="#{addFest.coordinator31}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{addFest.coordinator32}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{addFest.coordinator33}">
								<f:selectItems value="#{addFest.organizers}" />
							</h:selectOneMenu>
						</div>
						</div>
						<h:commandButton value="Add Fest" action="#{addFest.navNext}"
							styleClass="btn btn-primary">
							<f:setPropertyActionListener value="adminFestPage"
								target="#{addFest.action}" />
							<f:setPropertyActionListener value="addFestToDb"
								target="#{addFest.work}" />
						</h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			document.getElementById('theForm:event1').placeholder="Event name";
			document.getElementById('theForm:event2').placeholder="Event name";
			document.getElementById('theForm:event3').placeholder="Event name";
		</script>
		<t:saveState value="#{addFest.organizers}"></t:saveState>
	</f:view>
</body>
</html>