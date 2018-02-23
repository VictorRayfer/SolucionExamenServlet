package es.Victor.Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Videogame {

	private String title;
	private String pegi;
	private Date releaseDate;
	private int companyId;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPegi() {
		return pegi;
	}

	public void setPegi(String pegi) {
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
