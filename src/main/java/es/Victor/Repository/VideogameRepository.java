package es.Victor.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.Victor.Connection.ConnectionManager;
import es.Victor.Connection.H2Connection;
import es.Victor.Model.Videogame;

public class VideogameRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new H2Connection();

	public Videogame search(Videogame gameForm) {
		Videogame gameDB = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection connect = manager.open(jdbcUrl);
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM Game WHERE title = ?");
			prepareStatement.setString(1, gameForm.getTitle());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				gameDB = new Videogame();
				gameDB.setTitle(resultSet.getString(1));
				gameDB.setPegi(resultSet.getString(2));
				gameDB.setReleaseDate(resultSet.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connect);
		}
		return gameDB;
	}

	public void insertVideogame(Videogame gameForm) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect
					.prepareStatement("INSERT INTO Game (title, age, releaseDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, gameForm.getTitle());
			preparedStatement.setString(2, gameForm.getPegi());
			preparedStatement.setDate(3, (Date) gameForm.getReleaseDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
	}

	public List<Videogame> searchAll() {
		List<Videogame> listOfGames = new ArrayList<Videogame>();
		Connection connect = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM VIDEOGAME");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Videogame gameDB = new Videogame();
				gameDB.setTitle(resultSet.getString(1));
				gameDB.setPegi(resultSet.getString(2));
				gameDB.setReleaseDate(resultSet.getDate(3));
				;
				listOfGames.add(gameDB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connect);
		}
		return listOfGames;
	}

	public List<Videogame> orderByTitle() {
		List<Videogame> listOfGames = new ArrayList<Videogame>();
		Connection connect = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM Game ORDER BY name ASC");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Videogame gameDB = new Videogame();
				gameDB.setTitle(resultSet.getString(1));
				gameDB.setPegi(resultSet.getString(2));
				gameDB.setReleaseDate(resultSet.getDate(3));
				;
				listOfGames.add(gameDB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connect);
		}
		return listOfGames;
	}

	public List<Videogame> orderByReleaseDate() {
		List<Videogame> listOfGames = new ArrayList<Videogame>();
		Connection connect = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM Game ORDER BY releaseDate ASC");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Videogame gameDB = new Videogame();
				gameDB.setTitle(resultSet.getString(1));
				gameDB.setPegi(resultSet.getString(2));
				gameDB.setReleaseDate(resultSet.getDate(3));
				listOfGames.add(gameDB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connect);
		}
		return listOfGames;
	}

	public void delete(Videogame gameForm) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM Game WHERE title = ?");
			preparedStatement.setString(1, gameForm.getTitle());
			preparedStatement.executeUpdate();
			System.out.println("DELETE FROM Game WHERE title = ?");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
	}

	public void update(Videogame consoleForm) {
		Connection connect = manager.open(jdbcUrl);
		manager.close(connect);
	}

	public List<Videogame> selectByCompany(int id) {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		Connection connect = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM VIDEOGAME WHERE companyID = ?");
			prepareStatement.setString(1, id + "");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Videogame gameDB = new Videogame();
				gameDB.setTitle(resultSet.getString(1));
				gameDB.setPegi(resultSet.getString(2));
				gameDB.setReleaseDate(resultSet.getDate(3));
				gameDB.setCompanyId(resultSet.getInt(4));
				listVideogame.add(gameDB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connect);
		}
		return listVideogame;
	}
}
