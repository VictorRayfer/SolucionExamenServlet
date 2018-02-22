package es.Victor.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.Victor.Model.Company;
import es.Victor.Service.CompanyService;

public class SelectCompanyForVideogame extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CompanyService service = new CompanyService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> listAllCompany = service.listAllCompany();
		req.setAttribute("listAllCompanyVG", listAllCompany);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideogameByCompany.jsp");
		dispatcher.forward(req, resp);
	}
}