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

<title>Edit Conference Page</title>
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
						<h4>Conference name</h4>
						<h:inputText value="#{editConferencePage.confName}"
							styleClass="form-control"></h:inputText>
						<h4>Conference description</h4>
						<h:inputTextarea value="#{editConferencePage.confDescription}"
							styleClass="form-control"></h:inputTextarea>
						<h4>Acronym</h4>
						<h:inputText value="#{editConferencePage.acronym}"
							styleClass="form-control"></h:inputText>
						<h4>Start date of the conference (DD-MM-YYYY)</h4>
						<h:inputText value="#{editConferencePage.startDate}"
							styleClass="form-control"></h:inputText>
						<h4>End date of the conference (DD-MM-YYYY)</h4>
						<h:inputText value="#{editConferencePage.endDate}"
							styleClass="form-control"></h:inputText>
						<h4>Submission starts on (DD-MM-YYYY)</h4>
						<h:inputText value="#{editConferencePage.submissionStart}"
							styleClass="form-control"></h:inputText>
						<h4>Submission ends on (DD-MM-YYYY)</h4>
						<h:inputText value="#{editConferencePage.submissionEnd}"
							styleClass="form-control"></h:inputText>
						<h4>Acceptance notification (DD-MM-YYYY)</h4>
						<h:inputText value="#{editConferencePage.acceptance}"
							styleClass="form-control"></h:inputText>
						<h4>Registration ends (DD-MM-YYYY)</h4>
						<h:inputText value="#{editConferencePage.registration}"
							styleClass="form-control"></h:inputText>
						<h4>Conference scope</h4>
						<h:selectOneRadio layout="pageDirection"
							value="#{editConferencePage.scope}">
							<f:selectItem itemValue="101" itemLabel="Intra-college" />
							<f:selectItem itemValue="102" itemLabel="Intra-state" />
							<f:selectItem itemValue="103" itemLabel="National" />
							<f:selectItem itemValue="104" itemLabel="International" />
						</h:selectOneRadio>
						<h4>Venue</h4>
						<h:inputText value="#{editConferencePage.venue}"
							styleClass="form-control"></h:inputText>
							<c:if test="${login.role eq 1}">
								<h:commandButton value="Save"
							action="#{editConferencePage.navNext}"
							styleClass="btn primary-btn">
							<f:setPropertyActionListener value="adminConferencePage"
								target="#{editConferencePage.action}" />
							<f:setPropertyActionListener value="save"
								target="#{editConferencePage.work}" />
						</h:commandButton>
							
							</c:if>
							<c:if test="${login.role ne 1}">
								<h:commandButton value="Save"
							action="#{editConferencePage.navNext}"
							styleClass="btn primary-btn">
							<f:setPropertyActionListener value="coordinatorPage"
								target="#{editConferencePage.action}" />
							<f:setPropertyActionListener value="save"
								target="#{editConferencePage.work}" />
						</h:commandButton>
							</c:if>
						
					</h:form>
				</div>
			</div>

		</div>
		<%-- <t:saveState value="#{editConferencePage.conference}"></t:saveState> --%>
	</f:view>
</body>
</html>