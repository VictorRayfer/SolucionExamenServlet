package es.Victor.Service;

import javax.servlet.http.HttpServletRequest;

import es.Victor.Assembler.VideogameAssembler;
import es.Victor.Model.Videogame;
import es.Victor.Repository.VideogameRepository;

public class VideogameService {
	
	private VideogameRepository repository = new VideogameRepository();

	public void createNewVideogameFromRequest(HttpServletRequest req) {
		Videogame videogame = VideogameAssembler.assembleVideogameFrom(req);

		insertOrUpdate(videogame);
	}

	public void insertOrUpdate(Videogame videogameFrom) {
		Videogame videogameInDatabase = repository.search(videogameFrom);
		if (null == videogameInDatabase) {
			repository.insert(videogameFrom);
		} else {
			repository.update(videogameFrom);
		}
	}

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}
}
