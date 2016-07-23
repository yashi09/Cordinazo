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

<title>Event Registration Page</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css">
<link rel="stylesheet" type="text/css" href="styles/signin.css" />
</head>
<body>
	<f:view>
		<div class="row">
			<div class="container">
				<c:if test="${login.firstName==null}">
					<div class="col-sm-5 jumbotron form-group"
						style="margin-right: 16%;">
						<h:form styleClass="form-signin" id="theForm1">
							<h4>Sign in to participate</h4>
							<h:inputText styleClass="form-control"
								value="#{eventRegistration.email}" id="email"></h:inputText>
							<h:inputSecret styleClass="form-control"
								value="#{eventRegistration.pwd}" id="pwd"></h:inputSecret>
							<t:commandLink styleClass="btn btn-sm btn-link"
								value="Forgot password ?" action="#{eventRegistration.navNext}">
								<f:setPropertyActionListener value="" target="#{eventRegistration.action}" />
								<f:setPropertyActionListener value="forgotPassword"
									target="#{login.work}" />
							</t:commandLink>
							<h:commandButton styleClass="btn btn-lg btn-primary btn-block"
								value="Sign in" action="#{eventRegistration.navNext}">
								<f:setPropertyActionListener value=""
									target="#{eventRegistration.action}" />
								<f:setPropertyActionListener value="login"
									target="#{login.work}" />
							</h:commandButton>
						</h:form>
					</div>


					<div class="col-sm-5 jumbotron form-group">
						<h:form id="theForm">
							<h4>Name</h4>
							<h:inputText styleClass="form-control" id="fName"
								value="#{eventRegistration.firstName}"></h:inputText>
							<h:inputText styleClass="form-control" id="lName"
								value="#{eventRegistration.lastName}"></h:inputText>
							<h4>Email address</h4>
							<h:inputText styleClass="form-control"
								value="#{eventRegistration.email}"></h:inputText>
							<h4>Password</h4>
							<h:inputText styleClass="form-control"
								value="#{eventRegistration.pwd}"></h:inputText>
							<h4>Phone</h4>
							<h:inputText styleClass="form-control"
								value="#{eventRegistration.phoneNo}"></h:inputText>
							<h:commandButton styleClass="btn btn-primary" value="Register"
								action="#{eventRegistration.navNext}">
								<f:setPropertyActionListener value=""
									target="#{eventRegistration.action}" />
								<f:setPropertyActionListener value="register"
									target="#{eventRegistration.work}" />
							</h:commandButton>
						</h:form>
					</div>
				</c:if>
			</div>
		</div>
	</f:view>
</body>
<script type="text/javascript">
	document.getElementById('theForm:fName').placeholder = "First";
	document.getElementById('theForm:lName').placeholder = "Last";
	document.getElementById('theForm1:email').placeholder = "Email address";
	document.getElementById('theForm1:pwd').placeholder = "Password";
	document.getElementById('theForm1:email').type = "email";
</script>

</html>