package es.Victor.Assembler;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import es.Victor.Model.Videogame;

public class VideogameAssembler {

	public static Videogame assembleVideogameForm(HttpServletRequest request) {
		Videogame videogame = new Videogame();
		videogame.setTitle(request.getParameter("title"));
		videogame.setPegi(Integer.parseInt(request.getParameter("pegi")));
		videogame.setReleaseDate(Date.valueOf(request.getParameter("releaseDate")));
		return videogame;
	}
}