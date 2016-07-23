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

<title>Sign In</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
<link rel="stylesheet" type="text/css" href="styles/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="styles/external.css">
<link rel="stylesheet" type="text/css" href="styles/signin.css"/>

</head>
<body>
<f:view>
	<div class="container">
		<h:form styleClass="form-signin" id="theForm">
			<h2>Please sign in</h2>
			
			<h:inputText id="inputEmail" styleClass="form-control" value="#{login.loginEmail}"></h:inputText>
			<h:inputSecret id="inputPassword" styleClass="form-control" value="#{login.loginPwd}"></h:inputSecret>
			<h:commandButton styleClass="btn btn-lg btn-primary btn-block" action="#{login.navNext}" value="Sign in">
				<f:setPropertyActionListener value="login" target="#{login.work}"/>
				<f:setPropertyActionListener value="homePage" target="#{login.action}"/>
			</h:commandButton>
			<h:commandLink styleClass="btn btn-sm btn-link" value="Forgot password ?" action="#{login.navNext}">
				<f:setPropertyActionListener value="forgotPassword" target="#{login.work}"/>
				<f:setPropertyActionListener value="" target="#{login.action}"/>
			</h:commandLink>
			
		</h:form>
		<h:form id="signupForm">
			<h2>Not have an account ?</h2>
			
			<h:inputText id="fName" styleClass="form-control" value="#{login.firstName}"></h:inputText>
			<h:inputText id="lName" styleClass="form-control" value="#{login.lastName}"></h:inputText>
			<h:inputText id="email" styleClass="form-control" value="#{login.email}"></h:inputText>
			<h:inputText id="phone" styleClass="form-control" value="#{login.phoneNo}"></h:inputText>
			<h:inputSecret id="pwd" styleClass="form-control" value="#{login.password}"></h:inputSecret>
			<h:selectOneRadio value="#{login.role}">
				<f:selectItem itemValue="2" itemLabel="Student"/>
				<f:selectItem itemValue="3" itemLabel="Coordinator"/>
			</h:selectOneRadio>
			<h:commandLink styleClass="btn btn-lg btn-success" action="#{login.navNext}" value="Sign up">
				<f:setPropertyActionListener value="signUp" target="#{login.work}"/>
				<f:setPropertyActionListener value="login" target="#{login.action}"/>
			</h:commandLink>
		</h:form>
	</div>
</f:view>
<script type="text/javascript">
				document.getElementById('theForm:inputEmail').type="email";
				document.getElementById('theForm:inputEmail').placeholder="Email address";
				document.getElementById('theForm:inputPassword').placeholder="Password";
				
				document.getElementById('signupForm:email').type="email";
				document.getElementById('signupForm:fName').placeholder="First name";
				document.getElementById('signupForm:lName').placeholder="Last name";
				document.getElementById('signupForm:email').placeholder="Email address";
				document.getElementById('signupForm:phone').placeholder="Contact number";
				document.getElementById('signupForm:pwd').placeholder="Password";

				
			</script>
</body>
</html>