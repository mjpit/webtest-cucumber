package com.infosupport.kc.registratie.web.servlets;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.infosupport.kc.registratie.srv.CursistRegistratieManager;

@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	CursistRegistratieManager manager;

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		request.getRequestDispatcher("/WEB-INF/views/account.jsp").forward(request, response);
	}

}
