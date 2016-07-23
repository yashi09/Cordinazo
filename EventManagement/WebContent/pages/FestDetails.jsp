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

<title>Event Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css" />
</head>
<body>
	<f:view>
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="row" style="background-color: silver;">
			<div class="col-sm-12">
				<div class="col-sm-3">
					<h:graphicImage value="../images/#{festDetails.festName}.jpg"
						alt="200x200" style="height: 200px; width: 200px;">

					</h:graphicImage>
				</div>
				<div class="col-sm-9">
					<h1>
						Hearty welcome to
						<h:outputText value="#{festDetails.festName}"></h:outputText>
					</h1>
					<h3>Where everything begins.</h3>
				</div>
			</div>
		</div>
		<div class="container theme-showcase">
			<div class="row">
				<h:form>
					<div class="col-sm-12">
						<div class="panel panel-default" style="padding-left: 10%;">
							<div class="pannel-heading">
								<h3>Informal Events</h3>
							</div>

							<div class="pannel-body">
								<h:panelGrid columns="6">
									<c:forEach items="#{festDetails.list}" var="event">
										<h:column>
											<h:commandLink action="#{festDetails.navNext}">
												<f:setPropertyActionListener value="eventsOfFest"
																target="#{festDetails.action}" />
												<f:setPropertyActionListener value="#{event.eventId}"
																target="#{festDetails.eventId}" />
												<div class="col-sm-12" style="width: 145px;">
													<div class="thumbnail">
														<h:graphicImage id="image" alt="100x100"
															styleClass="img-thumbnail"
															style="height: 100px; width: 100px;"
															value="../images/#{event.eventName}.jpg">
														</h:graphicImage>
														<div class="caption">
															<h4>
																<h:outputText value="#{event.eventName}"></h:outputText>
															</h4>
														</div>
													</div>
												</div>
											</h:commandLink>
										</h:column>
									</c:forEach>
								</h:panelGrid>
							</div>
						</div>
					</div>
				</h:form>
			</div>
			<div class="row">
				<div
					style="position: fixed; bottom: 0; width: 100%; background-color: #FFFF;">
					<h:form>
						<h:commandButton action="homePage" value="Volunteer"></h:commandButton>
					</h:form>
				</div>
			</div>
		</div>
		<t:saveState value="#{festDetails.list}"></t:saveState>
	</f:view>
	<script src="../js/jQuery.min.js"></script>
	<script type="text/javascript" src="../js/ie10-viewport.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/docs.min.js"></script>
	<script type="text/javascript" src="../js/base.js"></script>
	<script type="text/javascript" src="../js/prettify-1.0.min.js"></script>
	<script>
		if (top != self) {
			top.location.replace(self.location.href);
		}
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-47462200-1', 'eonasdan.github.io');
		ga('send', 'pageview');
	</script>
</body>
</html>