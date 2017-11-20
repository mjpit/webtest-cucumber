package com.infosupport.kc.registratie.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infosupport.kc.registratie.domain.exceptions.OngeldigeCursistRegistratieException;
import com.infosupport.kc.registratie.srv.CursistRegistratieManager;

@WebServlet(urlPatterns = "/registreer")
public class RegistreerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	CursistRegistratieManager manager;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/registreer.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("registratieGebruikersnaam");
		String email = request.getParameter("registratieEmail");	
		System.out.printf("Registreer: gebruikersnaam %s email %s\n", username, email);
		try {
			manager.registreer(username, email);
			response.sendRedirect("activeer");
		} catch (OngeldigeCursistRegistratieException e) {
			System.out.println("Ongeldige cursis registratie");
			response.sendRedirect("registreer?error=Ongeldige registratie");
		}
	}
}
