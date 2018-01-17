package es.Victor.Assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.Victor.Model.Company;

public class CompanyAssembler {

	public static Company assembleUserFrom(HttpServletRequest request) {
		
		Company company = new Company();
		company.setName(request.getParameter("Name"));
		company.setCreationDate(Date.valueOf(request.getParameter("CreationDate")));
		return company;
	}
}
