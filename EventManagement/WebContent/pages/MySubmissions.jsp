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

<title>Admin Coordinators Of Fest Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>

		<div class="table-responsive">
			<h:form>
				<h:dataTable styleClass="table table-striped"
					value="#{mySubmissions.papers}" var="paper">
					<%-- <c:set value="${mySubmissions.papers}" var="p"></c:set> --%>
					<h:column>
						<h:outputText value="#{paper.title}"></h:outputText>
					</h:column>
					<h:column>
						<h:outputText value="#{paper.abstractOfPaper}"></h:outputText>
					</h:column>
						<h:column>
							<h:outputText value="Not submitted" rendered="#{paper.paperStatus eq 0}"></h:outputText>
							<h:outputText value="Submitted" rendered="#{paper.paperStatus eq 1}"></h:outputText>
							<h:outputText value="Accepted" rendered="#{paper.paperStatus eq 2}"></h:outputText>
							<h:outputText value="Registered" rendered="#{paper.paperStatus eq 3}"></h:outputText>
						</h:column>
					<%-- 	<h:column>
							<t:inputFileUpload ></t:inputFileUpload>
						</h:column>
						<h:column>
							<h:outputText value="Submitted"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="Accepted"></h:outputText>
						</h:column>
						<h:column>
							<h:outputText value="Registered"></h:outputText>
						</h:column> --%>
				</h:dataTable>
			</h:form>
		</div>
	</f:view>
</body>
</html>