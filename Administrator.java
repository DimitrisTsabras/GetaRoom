import java.sql.* ;
import javax.swing.*;

public class Administrator extends User
{
    
    

    
    public Administrator()
    {
        
        
    }

    
    public void solve(String request,String answer)
    {
        try
    {
       // Load the database driver
       Class.forName( "com.mysql.cj.jdbc.Driver" ) ;

       // Get a connection to the database
       Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/demo?user=root&password=terrorism" ) ;

       // Print all warnings
       for( SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning() )
       {
          System.out.println( "SQL Warning:" ) ;
          System.out.println( "State  : " + warn.getSQLState()  ) ;
          System.out.println( "Message: " + warn.getMessage()   ) ;
          System.out.println( "Error  : " + warn.getErrorCode() ) ;
       }

       // Get a statement from the connection
       

       // Execute the query
        String user;
        PreparedStatement stmt = conn.prepareStatement("select user from  support where theme=?");
        stmt.setString(1,request);
        ResultSet result = stmt.executeQuery();
        result.next();
        user=result.getString(1);
        
        stmt = conn.prepareStatement("insert into notification (sender,user,text) values(?,?,?)");
        stmt.setString(1,this.p.name);
        stmt.setString(2,user);
        stmt.setString(3,answer);
        stmt.executeUpdate();
        
        stmt = conn.prepareStatement("delete from support where theme=?");
        stmt.setString(1,request);
        stmt.executeUpdate();
       // Loop through the result set
       

       // Close the result set, statement and the connection
       
       conn.close() ;
   }
   catch( SQLException se )
   {
       System.out.println( "SQL Exception:" ) ;

       // Loop through the SQL Exceptions
       while( se != null )
       {
          System.out.println( "State  : " + se.getSQLState()  ) ;
          System.out.println( "Message: " + se.getMessage()   ) ;
          System.out.println( "Error  : " + se.getErrorCode() ) ;

          se = se.getNextException() ;
       }
   }
   catch( Exception e )
   {
      System.out.println( e ) ;
   }
        
    }
}
