import java.sql.* ;
import javax.swing.*;

public class Request_Info
{
    String time;
    int duration;
    String room;
    String event;
     

    
    public Request_Info()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
        
    }

    
    public void approve()
    {
        Department_Room room = new Department_Room();
        room.name=this.room;
        room.book(this.event);

    }
    
    
    public String getInfo(){
        String info;
        info="";
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
       ;

       // Execute the query
           
       PreparedStatement stmt = conn.prepareStatement("select  * from room_requests where event=?");
        stmt.setString(1, this.event);
        ResultSet result=stmt.executeQuery();
        result.next();
       // Loop through the result set
       String description=result.getString(1)+"  ,"+result.getString(2)+"  ,"+result.getString(3);
        info=description;

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
        return info;
    }
}
