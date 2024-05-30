import java.sql.* ;
import javax.swing.*;

public class Event_Suggestion extends Event
{
    
    int expected_people;
    int likes;
    int request;

    
    public Event_Suggestion()
    {
        
        
    }

    
    public int getLikes()
    {
        return this.likes;
        
    }
    
    public void like(){
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

       
        int likes;
        PreparedStatement stmt = conn.prepareStatement("select  likes from suggestions where title=?");
        stmt.setString(1, this.title);
        
        ResultSet result =stmt.executeQuery();
        result.next();
        likes=result.getInt(1);
        stmt = conn.prepareStatement("update suggestions set likes=?   where title = ?");
        
       
       stmt.setString(2,this.title);
        stmt.setInt(1,likes+1);
        

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
    
    public void approve(){
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
        
       Approved_Event  event = new Approved_Event();
       User user = new User();
        Profile p = new Profile();
        user.profile=p;
        
       
       PreparedStatement stmt = conn.prepareStatement("select * from suggestions where title=? ");
       stmt.setString(1, this.title);
       ResultSet result = stmt.executeQuery();
       result.next();
       event.title=this.title;
       event.description=result.getString(2);
       event.time=result.getString(3);
       event.duration=result.getInt(4);
       p.name=result.getString(5);
       event.organizer=user;
       event.expected_people=result.getInt(6);
       
       event.save();
        stmt = conn.prepareStatement("delete from suggestions where title=? ");
       stmt.setString(1, this.title);
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
    
    public void saveEvent(){
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
           
       PreparedStatement stmt = conn.prepareStatement("INSERT INTO suggestions(title, description,time, duration,organizer,people,likes,request) VALUES (?,?, ?, ?,?,?,?,?)");
        
       
       
        stmt.setString(1, this.title);
        stmt.setString(2, this.description);
        stmt.setString(3, this.time);
        stmt.setInt(4, this.duration);
        stmt.setString(5, this.organizer.profile.name);
        stmt.setInt(6, this.expected_people);
        stmt.setInt(7, this.likes);
        stmt.setInt(8, this.request);

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
