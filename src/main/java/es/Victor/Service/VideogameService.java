package es.Victor.Service;

import java.util.List;

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

	public void insertOrUpdate(Videogame videogameForm) {
		Videogame videogameInDatabase = repository.search(videogameForm);
		if (null == videogameInDatabase) {
			repository.insert(videogameForm);
		} else {
			repository.update(videogameForm);
		}
	}
	
	public List<Videogame> listAllVideogame(){
		return repository.searchAll();
		
	}
	

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}
}
