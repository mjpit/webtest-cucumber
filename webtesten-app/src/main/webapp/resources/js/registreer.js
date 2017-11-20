var h1 = document.querySelector('h1');
var errorLabel = document.querySelector('.label-important');
var activatieformulier = document.getElementById('activatieformulier');
var registratieformulier = document.getElementById('registratieformulier');
var currentPage = 'registreer';

function hide(element) {
	element.style.display = 'none';
}

function show(element) {
	element.style.display = '';
}

function onSubmit(element, handler) {
	element.addEventListener('submit', function(event) {
		event.preventDefault();
		handler(event.target);
	});
}

function post(url, body, handler) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState === XMLHttpRequest.DONE
				&& request.status === 200) {
			proceed(parseHtml(request.responseText), handler);
		}
	};
	request.open('POST', url, true);
	request.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded; charset=UTF-8');
	console.log('Sending', body);
	request.send(body);
}

function parseHtml(response) {
	var html = document.createElement('html');
	html.innerHTML = response;
	return html;
}

function proceed(responseHtml, nextScreen) {
	var foutmelding = responseHtml.querySelector('.label-important');
	if (foutmelding) {
		console.log(foutmelding.textContent);
		errorLabel.textContent = foutmelding.textContent;
		show(errorLabel);
	} else {
		nextScreen(responseHtml);
	}
}

window.addEventListener('hashchange', setHashState);

function setHashState() {
	hide(errorLabel);
	switch (window.location.hash) {
	case '#activeer':
		document.title = 'Activeer cursist';
		h1.textContent = 'Cursist activatie...';
		hide(registratieformulier);
		show(activatieformulier);
		break;
	case '#account':
		document.title = 'Account page';
		hide(registratieformulier);
		hide(activatieformulier);
		break;
	default:
		document.title = 'Registreer cursist';
		h1.textContent = 'Cursist registratie...';
		show(registratieformulier);
		hide(activatieformulier);
		break;
	}
}

setHashState();

onSubmit(registratieformulier, function(form) {
	var registratieGebruikersnaam = form
			.querySelector('[name=registratieGebruikersnaam]').value;
	var registratieEmail = form.querySelector('[name=registratieEmail]').value;
	var body = "registratieGebruikersnaam="
			+ encodeURIComponent(registratieGebruikersnaam) + '&'
			+ "registratieEmail=" + encodeURIComponent(registratieEmail);
	post('/registreer', body, function(responseHtml) {
		currentPage = window.location.hash = 'activeer';
	});
});

onSubmit(activatieformulier, function(form) {
	var activatieGebruikersnaam = form
			.querySelector('[name=activatieGebruikersnaam]').value;
	var activatiecode = form.querySelector('[name=activatiecode]').value;
	var body = "activatieGebruikersnaam="
			+ encodeURIComponent(activatieGebruikersnaam) + '&'
			+ "activatiecode=" + encodeURIComponent(activatiecode);
	post('/activeer', body, function(responseHtml) {
		currentPage = window.location.hash = 'account';
		h1.textContent = responseHtml.querySelector('h1').textContent;
	});
});
