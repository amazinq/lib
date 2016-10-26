package library.dao;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LibraryDAO {

	public static final String TABLE_NAME = "Movies";
	public static final String COLUMN_ID = "ID";
	public static final String COLUMN_TITLE = "Title";
	public static final String COLUMN_LOCATION = "Location";
	public static final String COLUMN_TYPE = "Type";
	public static final String COLUMN_DIRECTOR = "Director";
	public static final String COLUMN_GENRE = "Genre";
	public static final String COLUMN_RELEASE_YEAR = "Year";
	public static final String COLUMN_AGE_RESTRICTION = "FSK";
	public static final String COLUMN_RUNNING_TIME = "Duration";
	public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS" + TABLE_NAME + " ( " + COLUMN_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT NOT NULL, " + COLUMN_LOCATION
			+ " TEXT NOT NULL, " + COLUMN_TYPE + " TEXT NOT NULL, " + COLUMN_DIRECTOR + " TEXT NULL, " + COLUMN_GENRE
			+ " TEXT NULL, " + COLUMN_RELEASE_YEAR + " INTEGER NULL, " + COLUMN_AGE_RESTRICTION + " INTEGER NULL, "
			+ COLUMN_RUNNING_TIME + " INTEGER NULL );";

	private Connector connector;

	public LibraryDAO() throws ClassNotFoundException {
		connector = new Connector();
	}

	public void connectToLibrary(String path) throws IOException, SQLException {
		File databaseFile = new File(path);
		if (!databaseFile.exists()) {
			databaseFile.createNewFile();
			connector.connect(path);
		}
		connector.connect(path);
		connector.executeUpdateQuery(CREATE_TABLE_QUERY);
	}

	public void updateLibraryElement(HashMap<String, String> valuesToUpdate) {

	}
	
	public void insertLibraryElement(HashMap<String, String> valuesToInsert) {
		
	}

	/**
	 * 
	 * @param searchConditions has to be NULL if no restrictions are set 
	 * @return resultset
	 * @throws SQLException
	 */
	public ResultSet getLibraryFromDatabase(HashMap<String, String> searchConditions) throws SQLException {
		ResultSet result = null;
		StringBuilder queryStringBuilder = new StringBuilder();
		if (searchConditions == null) {
			queryStringBuilder.append("SELECT * FROM " + TABLE_NAME + ";");
		} else {
			queryStringBuilder.append("SELECT * FROM " + TABLE_NAME + " WHERE ");
			int iterator = 0;
			for(String s : searchConditions.keySet()) {
				if(iterator != 0) {
					queryStringBuilder.append(" AND ");
				}
				queryStringBuilder.append(s + " LIKE '%" + searchConditions.get(s) + "%'");
				iterator++;
			}
			queryStringBuilder.append(";");

		}
		result = connector.executeSelectQuery(queryStringBuilder.toString());

		return result;
	}
}
