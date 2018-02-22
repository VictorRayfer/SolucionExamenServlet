package es.Victor.Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Videogame {

	private String title;
	private Integer pegi;
	private Date releaseDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPegi() {
		return pegi;
	}

	public void setPegi(Integer pegi) {
		this.pegi = pegi;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setReleaseDateFromString(String releaseDate2) {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = textFormat.parse(releaseDate2);
		} catch (ParseException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		this.releaseDate = date;
	}

}
