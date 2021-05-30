package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
	private static String jdbcURL  = "jdbc:mysql://localhost:3306/billing_address?useSSL=false";
	private static String user     = "root";
private static	String password = "chaitali@7040";
	
	private static boolean error=false;
	
	private static Connection  connection = null;
	private static Statement statement=null;
	private static ResultSet resultset=null;
	
	
	
	
	public static List<String> Get_data(String value ) throws SQLException{
		List<String> result = new ArrayList<String>();
		String Query ="select * from persons where fullname='"+value+"'";
		try {
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println("\\n Connected to database!");
			
			statement=connection.createStatement();
			resultset=statement.executeQuery(Query);
			
			
			int i=1;
			ResultSetMetaData rsmd = resultset.getMetaData();
			int col = rsmd.getColumnCount();
			
			
			while(resultset.next())
			{
				
	         while(i<=col)
	         {
	        	 result.add(resultset.getString(i));
	        	 i++;
	         }
			}
			
	
			
		}
		catch (Exception exception)
		{
			error=true;
			exception.printStackTrace();
		}
		finally
		{
if(resultset!= null) 		resultset.close();
			if(statement != null) 		statement.close();
			if(connection != null) 		connection.close();
			
			if(error)					System.out.println("\nFailed!");
			else                        System.out.println("\nSuccess!");
		}
		
		
		return result;
			}

	
	
	}

		
	

	
	

