<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Registreer cursist</title>
<!-- <link href="bootstrap/css/bootstrap.css" rel="stylesheet"> -->
</head>
<body>
	<div class="hero-unit">
		<h1>Cursist registratie...</h1>
	</div>
	<div class="span12">
		<c:if test="${not empty param['error']}">
			<div>
				<span class="label label-important">${param['error']}</span>
			</div>
		</c:if>
		<form class="form-horizontal" method="post">
			<div class="control-group">
				<label class="control-label" for="registratieGebruikersnaam">Gebruikersnaam</label>
				<div class="controls">
					<input type="text" name="registratieGebruikersnaam"
						placeholder="Gebruikersnaam">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="registratieEmail">Email</label>
				<div class="controls">
					<input type="text" name="registratieEmail" placeholder="Email">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button id="registreer" type="submit" class="btn btn-success">Registreer</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>