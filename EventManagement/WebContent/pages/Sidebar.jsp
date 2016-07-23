<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<f:subview id="sidebar">
	<div class="container-fluid">
		<div class="row">
			<h:form>
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar">
						<li class="active"><h:commandLink
								action="#{adminPage.navNext}" value="Overview">
								<f:setPropertyActionListener value="adminPage"
									target="#{adminPage.action}" />
							</h:commandLink></li>
						<li><h:commandLink action="#{adminPage.navNext}"
								value="Event">
							 	<f:setPropertyActionListener value="adminFestPage"
									target="#{adminPage.action}" />
							</h:commandLink></li>
						<li><h:commandLink action="#{adminPage.navNext}"
								value="Conference">
								<f:setPropertyActionListener value="adminConferencePage"
									target="#{adminPage.action}" />
							</h:commandLink></li>
						<li><h:commandLink action="#{adminPage.navNext}"
								value="Workshop">
								<f:setPropertyActionListener value="adminWorkshopPage"
									target="#{adminPage.action}" />
							</h:commandLink></li>
						<li><h:commandLink action="#{adminPage.navNext}"
								value="Guest Lecture">
								<f:setPropertyActionListener value="adminGuestLecturePage"
									target="#{adminPage.action}" />
							</h:commandLink></li>
					</ul>
				</div>
			</h:form>
		</div>
	</div>
</f:subview>