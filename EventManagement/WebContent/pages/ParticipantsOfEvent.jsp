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
<title>Volunteers Of event</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="col-sm-9 col-md-10 main">
			<h2 class="sub-header">
				<h:outputText value="#{participantsOfEvent.event.eventName} "></h:outputText>
				participants
			</h2>
			<div class="table-responsive">
				<h:form>
					<h:dataTable value="#{participantsOfEvent.participants}"
						var="participant" styleClass="table table-striped">
						<h:column>
						<h:outputText value="#{participant.firstName} #{participant.lastName}"></h:outputText>
						</h:column>
						<h:column>
						<h:outputText value="#{participant.phoneNo}"></h:outputText>
						</h:column>
						<h:column>
						<h:outputText value="#{participant.email}"></h:outputText>
						</h:column>
					</h:dataTable>
				</h:form>
			</div>
		</div>
</f:view>
</body>
</html>