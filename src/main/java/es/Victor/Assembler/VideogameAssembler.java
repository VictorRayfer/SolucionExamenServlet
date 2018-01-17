package es.Victor.Assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.Victor.Model.Videogame;

public class VideogameAssembler {

	public static Videogame assembleVideogameFrom(HttpServletRequest request) {

		Videogame videogame = new Videogame();
		videogame.setTitle(request.getParameter("Title"));
		videogame.setPegi(Integer.parseInt(request.getParameter("Pegi")));
		videogame.setReleaseDate(Date.valueOf(request.getParameter("ReleaseDate")));
		return videogame;
	}
}