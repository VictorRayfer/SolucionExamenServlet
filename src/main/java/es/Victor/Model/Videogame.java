package es.Victor.Model;

import java.sql.Date;

public class Videogame {
	
	private String Title;
	private Integer Pegi;
	private Date ReleaseDate;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Integer getPegi() {
		return Pegi;
	}
	public void setPegi(Integer pegi) {
		Pegi = pegi;
	}
	public Date getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}
	
}
