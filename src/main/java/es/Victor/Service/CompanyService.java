package es.Victor.Service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.Victor.Assembler.CompanyAssembler;
import es.Victor.Connection.ConnectionManager;
import es.Victor.Connection.H2Connection;
import es.Victor.Model.Company;
import es.Victor.Repository.CompanyRepository;

public class CompanyService {
	CompanyAssembler assembler = new CompanyAssembler();
	ConnectionManager manager = new H2Connection();
	private CompanyRepository repository = new CompanyRepository();

	public Company assembleUserFromRequest(HttpServletRequest req) {
		return CompanyAssembler.assembleCompanyFrom(req);
	}

	public void createNewCompanyFromRequest(Company companyForm) {
		repository.insertCompany(companyForm);
	}

	public List<Company> listAllCompany() {
		return repository.searchAll();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
}