package connection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteQueries{
	
	// Demo Querry
	public ResultSet demoDelete(Connection conn)
	{
		Statement statement=null;
		try 
		{
			statement = conn.createStatement();
		    statement.executeUpdate("DELETE FROM rcm WHERE rcm_id = 2");
		
			ResultSet res = statement.executeQuery("SELECT * FROM  rcm");
			   while (res.next()) {
			          int id = res.getInt("rcm_id");
			          String msg = res.getString("location");
			          System.out.println(id + "\t" + msg);
			          }
			   return res;
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
	}

}