import java.sql.* ;
import javax.swing.*;
/**
 * Γράψτε μια περιγραφή της κλάσης Event_Suggestion εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class Event_Suggestion extends Event
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    int expected_people;
    int likes;
    int request;

    /**
     * Κατασευαστής αντικειμένων της κλάσης Event_Suggestion
     */
    public Event_Suggestion()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
        
    }

    /**
     * Παράδειγμα μεθόδου - αντικαταστήστε το παρόν σχόλιο με το δικό σας
     * 
     * @param  y    παράδειγμα παραμέτρου για την μέθοδο
     * @return        το άθροισμα του x με το y 
     */
    public int getLikes()
    {
        return this.likes;
        
    }
    
    public void approve(){
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
        
       Approved_Event  event = new Approved_Event();
       event.title=this.title;
       event.description=this.description;
       event.time=this.time;
       event.duration=this.duration;
       event.organizer=this.organizer;
       event.expected_people=this.expected_people;
       
       event.save();
       PreparedStatement stmt = conn.prepareStatement("delete from suggestions where title=? ");
       stmt.setString(1, this.title);
       stmt.executeUpdate();

       // Loop through the result set
       
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
