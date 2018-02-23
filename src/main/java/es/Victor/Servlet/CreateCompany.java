package es.Victor.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.Victor.Model.Company;
import es.Victor.Service.CompanyService;

public class CreateCompany extends HttpServlet {

	private CompanyService service = new CompanyService();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company company = service.assembleUserFromRequest(req);
		service.createNewCompanyFromRequest(company);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateCompany.jsp");
		dispatcher.forward(req, resp);
	}

	public CompanyService getService() {
		return service;
	}

	public void setService(CompanyService service) {
		this.service = service;
	}
}