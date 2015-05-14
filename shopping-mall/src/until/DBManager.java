package until;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public DBManager() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection()
	{
		Connection conn= null;
		Context InitContext;
		try {
			InitContext = new InitialContext();
			Context envContext = (Context) InitContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}	
	public static void close(Connection conn , Statement pstmt , ResultSet rs)
	{
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void close(Connection conn , Statement pstmt)
	{
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	
	
	
}
