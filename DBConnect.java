import java.sql.*;
import java.util.Vector;


public class DBConnect {
	private static Connection Conn;
	DBConnect(String db_url, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Conn = DriverManager.getConnection(db_url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// run query
	public String SelectQuery(String query){
	    Statement statement;
	    String result = "";
		try {
			statement = Conn.createStatement();
	        String queryString; 
	        if (query == ""){
	        	queryString = "select * from sysobjects where type='u'";
	        } else {
	        	queryString = query;
	        }
	        ResultSet rset = statement.executeQuery(queryString);
	        while (rset.next()) {
	           result = rset.getString(1);
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public UserDB[] getAllUsers() throws SQLException {
		UserDB custArr[];
		Vector<UserDB> vCustomer = new Vector<UserDB>();
		 
		Statement statment = Conn.createStatement();
		String queryString;
		ResultSet rset;
		queryString = "SELECT * FROM User;";
		rset = statment.executeQuery(queryString);
		while(rset.next()){
			UserDB c = new UserDB();
			c.fName = rset.getString("fName");
			c.lName = rset.getString("lName");
			c.bDay = rset.getString("bDay");
			c.address = rset.getString("address");
			c.phoneNum = rset.getInt("phoneNum");
			c.email = rset.getString("email");
			c.username = rset.getString("username");
			c.password = rset.getString("password");
			c.idNum = rset.getString("idNum");
			vCustomer.add(c);
		}
		custArr = new UserDB[vCustomer.size()];
		vCustomer.toArray(custArr);
		return custArr;	
	}
	
	public DealerDB[] getAllDealers() throws SQLException {
		DealerDB custArr[];
		Vector<DealerDB> vCustomer = new Vector<DealerDB>();
		 
		Statement statment = Conn.createStatement();
		String queryString;
		ResultSet rset;
		queryString = "SELECT * FROM DealershipInfo;";
		rset = statment.executeQuery(queryString);
		while(rset.next()){
			DealerDB d = new DealerDB();
			d.id = rset.getString("id");
			d.owner = rset.getString("owner");
			d.phoneNum = rset.getInt("phoneNum");
			d.address = rset.getString("address");
			d.email = rset.getString("email");
			vCustomer.add(d);
		}
		custArr = new DealerDB[vCustomer.size()];
		vCustomer.toArray(custArr);
		return custArr;	
	}

	public static String[] getType(String querySttring) throws SQLException {
		String typesArr[];
		Vector<String> vCustomer = new Vector<String>();
		 
		Statement statment = Conn.createStatement();
		String queryString;
		ResultSet rset;
		queryString = querySttring;
		rset = statment.executeQuery(queryString);
		while(rset.next()){
			vCustomer.add(rset.getString(1));
		}
		typesArr = new String[vCustomer.size()];
		vCustomer.toArray(typesArr);
		return typesArr;	
	}
	
	public static void insertListing(String queryString) throws SQLException {
		String sql = queryString;
		Statement stmt = null;
		stmt = Conn.createStatement();
		stmt.executeUpdate(sql);
	}
	
	public static String selectQuery(String queryString, String name) throws SQLException {
		String sql = queryString;
		Statement stmt = null;
		stmt = Conn.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		String res = null;
		while(rset.next()){
			res = rset.getString(name);
		}
		return res;
	}
	
	public static int getVehicleCount(String queryString) throws SQLException {
		String sql = queryString;
		Statement stmt = null;
		stmt = Conn.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		int res = 0;
		while(rset.next()){
			res = rset.getInt(1);
		}
		return res;
	}
	
	public static void deleteVehicle(String queryString) throws SQLException {
		String sql = queryString;
		Statement stmt = null;
		stmt = Conn.createStatement();
		stmt.executeUpdate(sql);
	}
}
