package es.Victor.Service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.Victor.Assembler.ConsoleAssembler;
import es.Victor.Model.Console;
import es.Victor.Repository.ConsoleRepository;

public class ConsoleService {

	private ConsoleRepository repository = new ConsoleRepository();

	public void createNewConsoleFromRequest(HttpServletRequest req) {
		Console console = ConsoleAssembler.assembleConsoleFrom(req);
		insertOrUpdate(console);
	}

	public void insertOrUpdate(Console consoleFrom) {
		Console consoleInDatabase = repository.search(consoleFrom);
		if (null == consoleInDatabase) {
			repository.insert(consoleFrom);
		} else {
			repository.update(consoleFrom);
		}
	}

	public List<Console> listAllConsole() {
		return repository.searchAll();
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
