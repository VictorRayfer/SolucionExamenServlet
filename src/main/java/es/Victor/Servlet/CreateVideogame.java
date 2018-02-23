package es.Victor.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.Victor.Model.Console;
import es.Victor.Model.Videogame;
import es.Victor.Service.ConsoleService;
import es.Victor.Service.VideogameService;

public class CreateVideogame extends HttpServlet {

	private VideogameService service = new VideogameService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Videogame game = service.assembleUserFromRequest(req);
		service.createNewVideogameFromRequest(game);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateVideogame.jsp");
		dispatcher.forward(req, resp);
	}

	public VideogameService getService() {
		return service;
	}

	public void setVideogameService(VideogameService service) {
		this.service = service;
	}
}