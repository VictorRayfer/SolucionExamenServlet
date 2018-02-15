package es.Victor.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.Victor.Connection.AbstractConnection;
import es.Victor.Model.Videogame;

public class VideogameRepository {

	private AbstractConnection connection = new AbstractConnection() {

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
	};

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/Videogame.sql'";

	public void insert(Videogame gameForm) {
		Connection connect = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO GAME (title,pegi,releaseDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, gameForm.getTitle());
			preparedStatement.setInt(2, gameForm.getPegi());
			preparedStatement.setDate(3, gameForm.getReleaseDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(connect);
	}

	public void update(Videogame videogame) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;	
		try {
			connect = connection.open(jdbcUrl);
			preparedStatement = connect
					.prepareStatement("UPDATE GAME SET " + "title = ?, pegi = ?, releaseDate = ? WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.setInt(2, videogame.getPegi());
			preparedStatement.setDate(3, videogame.getReleaseDate());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(connect);
		}
	}

	public Videogame search(Videogame gameForm) {
		Videogame videogameInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection connect = connection.open(jdbcUrl);	
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM GAME WHERE title = ?");
			prepareStatement.setString(1, gameForm.getTitle());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				videogameInDatabase = new Videogame();
				videogameInDatabase.setTitle(resultSet.getString(0));
				videogameInDatabase.setPegi(resultSet.getInt(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		connection.close(connect);
		return videogameInDatabase;
	}

	public List<Videogame> searchAll() {
		List<Videogame> listGames = new ArrayList<Videogame>();
		Connection connect = connection.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM GAME");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setPegi(resultSet.getInt(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));

				listGames.add(videogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		connection.close(connect);
		return listGames;
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
