package com.infosupport.kc.registratie.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infosupport.kc.registratie.srv.CursistRegistratieManager;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	CursistRegistratieManager manager;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		manager.delete();
		response.sendRedirect("registreer");
	}
}
