package es.Victor.Service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.Victor.Assembler.ConsoleAssembler;
import es.Victor.Connection.ConnectionManager;
import es.Victor.Connection.H2Connection;
import es.Victor.Model.Console;
import es.Victor.Repository.ConsoleRepository;

public class ConsoleService {

	ConsoleAssembler assembler = new ConsoleAssembler();
	ConnectionManager manager = new H2Connection();
	private ConsoleRepository repository = new ConsoleRepository();

	public Console assembleUserFromRequest(HttpServletRequest req) {
		return ConsoleAssembler.assembleConsoleFrom(req);
	}

	public void createNewConsoleFromRequest(Console consoleForm) {
		Console consoleInDatabase = repository.search(consoleForm);
		if (consoleInDatabase == null) {
			repository.insertConsole(consoleForm);
		} else {
			repository.update(consoleForm);
		}
	}

	public List<Console> listAllConsoles() {
		return repository.searchAll();
	}

	public List<Console> listOrderByTitle() {
		return repository.orderByTitle();
	}

	public void deleteConsole(Console console) {
		repository.delete(console);
	}

	public ConsoleRepository getRepository() {
		return repository;
	}

	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}
	public List<Console> listAllByCompany(int companyId) {
		return repository.selectByCompany(companyId);
	}
}
