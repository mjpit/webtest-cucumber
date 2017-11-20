package com.infosupport.kc.registratie.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infosupport.kc.registratie.domain.Cursist;
import com.infosupport.kc.registratie.domain.exceptions.OngeldigeCursistActivatieException;
import com.infosupport.kc.registratie.srv.CursistRegistratieManager;

@WebServlet(urlPatterns = "/activeer")
public class ActiveerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	CursistRegistratieManager manager;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/activeer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gebruikersnaam = request.getParameter("activatieGebruikersnaam");
		String activatiecode = request.getParameter("activatiecode");
		try {
			System.out.printf("Activeer: activatiecode %s gebruikersnaam %s\n", activatiecode, gebruikersnaam);
			Cursist cursist = manager.activeer(gebruikersnaam, activatiecode);
			request.getSession().setAttribute("cursist", cursist);
			response.sendRedirect("account");
		} catch (OngeldigeCursistActivatieException e) {
			System.out.println("Ongeldige activatie");
			response.sendRedirect("activeer?error=Ongeldige activatie");
		}
	}

}
