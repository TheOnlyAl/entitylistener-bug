package de.theonlyal.payara.entitylistenerbug;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/audit")
public class AuditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private AuditEntityServiceBean service;

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		final String lastChange = service.persistEntity();

		final PrintWriter writer = resp.getWriter();
		writer.println(lastChange);

		writer.close();
	}

}