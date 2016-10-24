package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {

	private Connection connection;

	public Connector() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");

	}
	
	public void connect(String path) throws SQLException {
		connection = DriverManager.getConnection("jdbc:sqlite:" + path);
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}
	
	public void executeUpdateQuery(String query) throws SQLException {
		connection.createStatement().executeUpdate(query);
	}
	
	public boolean isConnected() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			return true;
		}
		return false;
	}
}
