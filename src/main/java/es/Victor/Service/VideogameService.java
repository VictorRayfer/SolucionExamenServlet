package es.Victor.Service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.Victor.Assembler.VideogameAssembler;
import es.Victor.Connection.ConnectionManager;
import es.Victor.Connection.H2Connection;
import es.Victor.Model.Videogame;
import es.Victor.Repository.VideogameRepository;

public class VideogameService {

	VideogameAssembler assembler = new VideogameAssembler();
	private VideogameRepository repository = new VideogameRepository();
	ConnectionManager manager = new H2Connection();

	public Videogame assembleUserFromRequest(HttpServletRequest req) {
		return VideogameAssembler.assembleVideogameFrom(req);
	}

	public void createNewVideogameFromRequest(Videogame gameForm) {
		Videogame gameDB = repository.search(gameForm);
		if (gameDB == null) {
			repository.insertGame(gameForm);
		} else {
			repository.update(gameForm);
		}
	}

	public List<Videogame> listAllVideogames() {
		return repository.searchAll();
	}

	public List<Videogame> OrderByTitle() {
		return repository.orderByTitle();
	}

	public List<Videogame> OrderByReleaseDate() {
		return repository.orderByReleaseDate();
	}

	public void deleteVideoGame(Videogame game) {
		repository.delete(game);
	}

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}

	public List<Videogame> listAllByCompany(int companyId) {
		return repository.selectByCompany(companyId);
	}
}