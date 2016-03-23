import java.sql.SQLException;


public class DatabaseAccess {
	String driver = "com.mysql.jdbc.Driver";
	static DBConnect db = new DBConnect(""
			+ "jdbc:mysql://73.239.204.41/"
			+ "445Project", "selector", "database"
			);	
	public static UserDB [] GetUsers () {
		try {
			return db.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static DealerDB [] GetDealers () {
		try {
			return db.getAllDealers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void insert (String sql) throws SQLException {
		DBConnect.insertListing(sql);
	}
}
