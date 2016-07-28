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

<title>Admin Events Of Fest Page</title>
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
				<div class="table-responsive">
					<h:dataTable styleClass="table table-striped"
						value="#{adminPapersOfConf.papers}" var="paper">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Title"></h:outputText>
							</f:facet>
							<h:outputText value="#{paper.title}"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="Submitted" rendered="#{paper.paperStatus eq '1'}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandButton value="Accept" rendered="#{paper.paperStatus eq '1'}" action="#{adminPapersOfConf.navNext}">
								<f:setPropertyActionListener value="acceptPaper" target="#{adminPapersOfConf.work}"/>
								<f:setPropertyActionListener value="#{paper.paperId}" target="#{adminPapersOfConf.paperId}"/>
								<f:setPropertyActionListener value="adminPapersOfConf" target="#{adminPapersOfConf.action}"/>
							</h:commandButton>
						</h:column>
						<h:column>
							<h:outputText value="Accepted" rendered="#{paper.paperStatus eq '2'}"></h:outputText>
						</h:column>
						<h:column>
							<h:commandButton value="Register" rendered="#{paper.paperStatus eq '2'}" action="#{adminPapersOfConf.navNext}">
								<f:setPropertyActionListener value="registerPaper" target="#{adminPapersOfConf.work}"/>
								<f:setPropertyActionListener value="#{paper.paperId}" target="#{adminPapersOfConf.paperId}"/>
								<f:setPropertyActionListener value="adminPapersOfConf" target="#{adminPapersOfConf.action}"/>
							</h:commandButton>
						</h:column>
						<h:column>
							<h:outputText value="Registered" rendered="#{paper.paperStatus eq '3'}"></h:outputText>
						</h:column>
					</h:dataTable>
				</div>
			</h:form>
		</div>
		<t:saveState value="#{adminPapersOfConf.papers}"></t:saveState>
	</f:view>
</body>
</html>