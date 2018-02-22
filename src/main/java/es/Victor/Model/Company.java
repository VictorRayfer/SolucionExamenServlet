package es.Victor.Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Company {

	private Integer id;
	private String name;
	private Date creationDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setCreationDateFromString(String creationDate2) {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = textFormat.parse(creationDate2);
		} catch (ParseException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		this.creationDate = date;
	}
}
