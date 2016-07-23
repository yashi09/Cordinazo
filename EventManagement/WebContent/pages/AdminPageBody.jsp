<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<f:subview id="adminBody">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<c:choose>
			<c:when test="${adminPage.work == null && adminPage.list != null}">
				<h:form>
					<h1 class="page-header">College Events</h1>
					<div class="add-festival">
						<span class="glyphicon glyphicon-hand-right"></span>
						<t:commandLink action="#{adminPage.navNext}" value="Add Event">
							<f:setPropertyActionListener value="addEvent"
								target="#{adminPage.work}" />
							<f:setPropertyActionListener value="adminPage"
								target="#{adminPage.action}" />
						</t:commandLink>
					</div>
				</h:form>
				<h2 class="sub-header">Upcoming Events</h2>
				<h:form>
					<div class="table-responsive">
						<h:dataTable styleClass="table table-striped"
							value="#{adminPage.list}" var="event">
							<t:column>
								<h:outputText value="#{event.eventId}"></h:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.eventName}"></t:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.eventDescription}"></t:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.startDate}"></t:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.endDate}"></t:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.venue}"></t:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.eventTypeDetails.eventType}"></t:outputText>
							</t:column>
							<t:column>
								<t:outputText value="#{event.scopeDto.scope}"></t:outputText>
							</t:column>
							<t:column>
								<t:commandLink action="#{adminPage.navNext}" value="Edit">
									<f:setPropertyActionListener value="editEvent"
										target="#{adminPage.work}" />
									<f:setPropertyActionListener value="eventPage"
										target="#{adminPage.action}" />
									<f:setPropertyActionListener value="#{event.eventId}"
										target="#{adminPage.eventId}" />
								</t:commandLink>
							</t:column>
							<t:column>
								<t:commandLink action="#{adminPage.navNext}" value="Delete">
									<f:setPropertyActionListener value="adminPage"
										target="#{adminPage.action}" />
									<f:setPropertyActionListener value="delEvent"
										target="#{adminPage.work}" />
									<f:setPropertyActionListener value="#{event.eventId}"
										target="#{adminPage.eventId}" />
								</t:commandLink>
							</t:column>
						</h:dataTable>
						<%-- <t:commandLink action="#{adminPage.navNext}" value="Add Event">
							<f:setPropertyActionListener value="addEvent"
								target="#{adminPage.work}" />
							<f:setPropertyActionListener value="eventPage"
								target="#{adminPage.action}" />
						</t:commandLink --%>>
					</div>
				</h:form>
			</c:when>
			<c:otherwise>
				<c:set value="addEvent" var="addEvent" scope="request" />
				<c:if test="${adminPage.work == addEvent}">
					<div class="jumbotron" style="text-align: center;">
						<div class="container">
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<h:form>
											<h4>Event Name</h4>
											<br>
											<h:inputText value="#{adminPage.eventName}"
												styleClass="form-control"></h:inputText>
											<br>
											<h4>Event Description</h4>
											<br>
											<h:inputTextarea value="#{adminPage.eventDescription}"
												styleClass="form-control"></h:inputTextarea>
											<br>
											<h4>Tentative Start Date(DD-MM-YYYY)</h4>
											<br>
											<h:inputText styleClass="form-control"
												value="#{adminPage.startDate}"></h:inputText>
											<br>
											<h4>Tentative End Date(DD-MM-YYYY)</h4>
											<h:inputText styleClass="form-control"
												value="#{adminPage.endDate}"></h:inputText>
											<br>
											<h4>Scope Of Event</h4>
											<br>
											<h:selectOneRadio value="#{adminPage.scope}">
												<f:selectItem itemValue="101" itemLabel="Intra-college" />
												<f:selectItem itemValue="102" itemLabel="Intra-State" />
												<f:selectItem itemValue="103" itemLabel="National" />
												<f:selectItem itemValue="104" itemLabel="International" />
											</h:selectOneRadio>
											<br>
											<h4>Venue Of The Event</h4>
											<br>
											<h:inputText styleClass="form-control"
												value="#{adminPage.venue}"></h:inputText>
											<h4>Type Of Event</h4>
											<br>
											<h:selectOneRadio value="#{adminPage.eventType}">
												<f:selectItem itemValue="201" itemLabel="Conference" />
												<br>
												<f:selectItem itemValue="202" itemLabel="Workshop" />
												<br>
												<f:selectItem itemValue="203" itemLabel="Guest Lecture" />
												<br>
												<f:selectItem itemValue="204" itemLabel="Campus Event" />
											</h:selectOneRadio>
											<t:commandButton styleClass="btn btn-primary btn-lg"
												action="#{adminPage.navNext}" value="Add Event">
												<f:setPropertyActionListener value="addEventToDb"
													target="#{adminPage.work}" />
												<f:setPropertyActionListener value="adminPage"
													target="#{adminPage.action}" />
											</t:commandButton>
										</h:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</f:subview>