package es.Victor.Assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.Victor.Model.Videogame;

public class VideogameAssembler {

	public static Videogame assembleVideogameFrom(HttpServletRequest request) {

		Videogame videogame = new Videogame();
		videogame.setTitle(request.getParameter("title"));
		Videogame.setPegi(request.getParameter("pegi"));
		videogame.setReleaseDateFromString((request.getParameter("releaseDate")));
		return videogame;
	}
}