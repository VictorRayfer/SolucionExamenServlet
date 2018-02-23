package es.Victor.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2Connection implements ConnectionManager {

	public Connection open(String jdbcUrl) {
		Connection connect = null;
		try {
			Class.forName("org.h2.Driver");
			connect = DriverManager.getConnection(jdbcUrl + ";INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'", "sa",
					"");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return connect;
	}

	public Connection executeSql(Connection connect, String sql) {
		PreparedStatement prepareStatement;
		try {
			prepareStatement = connect.prepareStatement(sql);
			prepareStatement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return connect;
	}

	public void close(Connection connect) {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}