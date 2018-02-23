package es.Victor.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.Victor.Model.Console;
import es.Victor.Service.ConsoleService;

public class DeleteConsole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConsoleService service = new ConsoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Console console = service.assembleUserFromRequest(req);
		service.deleteConsole(console);
		loginRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", req.getParameter("name"));
		confirmationRedirect(req, resp);
	}
<<<<<<< HEAD:src/main/java/es/Victor/Servlet/DeleteConsoleServlet.java
	
	private void listRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsoleList.jsp");
=======

	protected void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ConfirmationDeleteConsole.jsp");
>>>>>>> master:src/main/java/es/Victor/Servlet/DeleteConsole.java
		dispatcher.forward(req, resp);
	}

	protected void loginRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ListConsole.jsp");
		dispatcher.forward(req, resp);
	}
}