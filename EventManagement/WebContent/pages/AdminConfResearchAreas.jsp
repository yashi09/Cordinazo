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

<title>Admin Conference Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="Sidebar.jsp"></jsp:include>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h:form>
			<h:inputText value="#{adminConfResearchAreas.topic}"></h:inputText>
			<h:commandButton value="Add topic" action="#{adminConfResearchAreas.navNext}">
				<f:setPropertyActionListener value="addTopic" target="#{adminConfResearchAreas.work}"/>
				<f:setPropertyActionListener value="adminConfResearchAreas" target="#{adminConfResearchAreas.action}"/>
			</h:commandButton>
			
			<h2 class="sub-header">
				Research areas of
				<h:outputText value="#{adminConfResearchAreas.conference.acronym}"></h:outputText>
			</h2>
			<div class="table-responsive">
				<h:dataTable value="#{adminConfResearchAreas.topics}" var="topic" styleClass="table table-striped">
					<h:column>
						<f:facet name="header">
								<h:outputText value="Research area"></h:outputText>
							</f:facet>
						<h:outputText value="#{topic}"></h:outputText>
					</h:column>
					<h:column>
						<h:commandLink action="#{adminConfResearchAreas.navNext}" value="delete">
							<f:setPropertyActionListener value="adminConfResearchAreas" target="#{adminConfResearchAreas.action}"/>
							<f:setPropertyActionListener value="#{topic}" target="#{adminConfResearchAreas.topic}"/>
							<f:setPropertyActionListener value="delTopic" target="#{adminConfResearchAreas.work}"/>
						</h:commandLink>
					</h:column>
				</h:dataTable>
				</div>
			</h:form>
		</div>
		<t:saveState value="#{adminConfResearchAreas.topics}"></t:saveState>
</f:view>
</body>
</html>