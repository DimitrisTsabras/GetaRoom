import java.sql.* ;
import javax.swing.*;

public class University_Deparment_Representative extends User
{
    
   String department;

    
    public University_Deparment_Representative()
    {
        
        
    }

    
    public void addRoom(String room, int capacity, String special_info)
    {
        try
    {
       
       Class.forName( "com.mysql.cj.jdbc.Driver" ) ;

       
       Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/demo?user=root&password=terrorism" ) ;

       
       for( SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning() )
       {
          System.out.println( "SQL Warning:" ) ;
          System.out.println( "State  : " + warn.getSQLState()  ) ;
          System.out.println( "Message: " + warn.getMessage()   ) ;
          System.out.println( "Error  : " + warn.getErrorCode() ) ;
       }

       
        PreparedStatement stmt = conn.prepareStatement("insert into rooms(name,capacity,special_info,department) values(?,?,?,?)");
        stmt.setString(1, room);
        stmt.setInt(2, capacity);
        stmt.setString(3, special_info);
        stmt.setString(4, this.department);
       

        stmt.executeUpdate();

       
       
       conn.close() ;
   }
   catch( SQLException se )
   {
       System.out.println( "SQL Exception:" ) ;

       
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
