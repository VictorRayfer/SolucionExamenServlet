package es.Victor.Model;

import java.sql.Date;

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
}
