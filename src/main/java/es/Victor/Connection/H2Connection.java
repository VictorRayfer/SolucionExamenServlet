package es.Victor.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseUser() {
		return "sa";
	}

	@Override
	public String getDatabasePassword() {
		return "";
	}
}