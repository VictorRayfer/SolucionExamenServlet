package es.Victor.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.Victor.Model.Videogame;
import es.Victor.Service.VideogameService;

public class DeleteVideogame extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VideogameService service = new VideogameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Videogame game = service.assembleUserFromRequest(req);
		service.deleteVideogame(game);
		loginRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", req.getParameter("title"));
		confirmationRedirect(req, resp);
	}

	protected void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ConfirmationDeleteVideogame.jsp");
		dispatcher.forward(req, resp);
	}

	protected void loginRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ListVideogame.jsp");
		dispatcher.forward(req, resp);
	}
}