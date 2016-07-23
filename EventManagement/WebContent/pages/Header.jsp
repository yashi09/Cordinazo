<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<f:subview id="header">
	<h:form>
		<div class="navbar navbar-inverse navbar-fixed-top"
			style="height: 50px;">
			<div class="container" style="width: auto; margin: 0px 20px;">
				<div class="navbar-header">

					<h:commandLink styleClass="navbar-brand active"
						action="#{homePage.navNext}">Event Manager
						<f:setPropertyActionListener value="homePage"
							target="#{homePage.action}" />
					</h:commandLink>

				</div>
				<div id="navbar" class="collapse navbar-collapse">

					<ul class="nav navbar-nav">
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Home
								<f:setPropertyActionListener value="homePage"
									target="#{homePage.action}" />
							</h:commandLink></li>
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Event
								<f:setPropertyActionListener value="festPage"
									target="#{homePage.action}" />
								<f:setPropertyActionListener value="204"
									target="#{homePage.eventTypeId}" />
							</h:commandLink></li>
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Conference
								<f:setPropertyActionListener value="conferencePage"
									target="#{homePage.action}" />
							</h:commandLink></li>
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Workshop
								<f:setPropertyActionListener value="workshopPage"
									target="#{homePage.action}" />
							</h:commandLink></li>
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Guest Lecture
								<f:setPropertyActionListener value="guestLecturePage"
									target="#{homePage.action}" />
							</h:commandLink></li>
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Admin Portal
								<f:setPropertyActionListener value="adminPage"
									target="#{homePage.action}" />
							</h:commandLink></li>
						<li style="width: inherit;"><h:commandLink
								action="#{homePage.navNext}">Coordinator Portal
							<f:setPropertyActionListener value="coordinatorPage"
									target="#{homePage.action}" />
							</h:commandLink></li>
					</ul>
					<c:if test="${login.firstName == null}">
						<ul class="nav navbar-nav navbar-right">
							<li><h:commandLink action="#{homePage.navNext}"
									value="Sign Up">
									<f:setPropertyActionListener value="registrationPage"
										target="#{homePage.action}" />
								</h:commandLink></li>
							<li><h:commandLink action="#{homePage.navNext}"
									value="Sign In">
									<f:setPropertyActionListener value="loginPage"
										target="#{homePage.action}" />
								</h:commandLink></li>

						</ul>
					</c:if>
					<c:if test="${login.firstName != null}">
						<ul class="nav navbar-nav navbar-right">

							<li><span class="glyphicon glyphicon-user"
								style="color: white;"></span> <h:selectOneMenu
									value="#{login.work}">
									<f:selectItem itemValue="logout" itemLabel="Sign out" />
								</h:selectOneMenu> <h:commandButton action="#{login.navNext}" value="submit">
								</h:commandButton></li>

						</ul>
					</c:if>

				</div>
			</div>
		</div>
	</h:form>
</f:subview>