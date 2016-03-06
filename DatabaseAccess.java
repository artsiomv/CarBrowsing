import java.sql.SQLException;


public class DatabaseAccess {
	String driver = "com.mysql.jdbc.Driver";
	static DBConnect db = new DBConnect(""
			+ "jdbc:mysql://71.231.50.191:3306/"
			+ "445Project", "selector", "database"
			);	
	public static UserDB [] GetUsers ()
	{
		try {
			return db.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static DealerDB [] GetDealers ()
	{
		try {
			return db.getAllDealers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}