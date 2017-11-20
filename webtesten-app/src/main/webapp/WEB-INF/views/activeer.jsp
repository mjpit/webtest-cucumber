<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Activeer cursist</title>
<!-- <link href="bootstrap/css/bootstrap.css" rel="stylesheet"> -->
</head>
<body>
	<div class="hero-unit">
		<h1>Cursist activatie...</h1>
	</div>
	<div class="span12">
		<c:if test="${not empty param['error']}">
			<div>
				<span class="label label-important">${param['error']}</span>
			</div>
		</c:if>
		<p>Bedankt voor uw registratie.</p>
		<p>Voer uw gebruikersnaam en de via email verzonden activatiecode
			in en activeer uw account!</p>
		<form class="form-horizontal" method="post">
			<div class="control-group">
				<label class="control-label" for="activatieGebruikersnaam">Gebruikersnaam</label>
				<div class="controls">
					<input type="text" name="activatieGebruikersnaam"
						placeholder="Gebruikersnaam">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="activatiecode">Activatiecode</label>
				<div class="controls">
					<input type="text" name="activatiecode" placeholder="Activatiecode">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button id="activeer" type="submit" class="btn btn-success">Activeer</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>