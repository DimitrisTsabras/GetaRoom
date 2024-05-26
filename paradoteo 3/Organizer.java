import java.sql.* ;
import javax.swing.*;
/**
 * Γράψτε μια περιγραφή της κλάσης Organizer εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class Organizer extends User
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    String pending;
    String current;

    /**
     * Κατασευαστής αντικειμένων της κλάσης Organizer
     */
    public Organizer()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
        
    }

    /**
     * Παράδειγμα μεθόδου - αντικαταστήστε το παρόν σχόλιο με το δικό σας
     * 
     * @param  y    παράδειγμα παραμέτρου για την μέθοδο
     * @return        το άθροισμα του x με το y 
     */
    public void suggestEvent(String title, String description, String time, int duration,int people)
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
        
        PreparedStatement stmt = conn.prepareStatement("insert into suggestions(title,description,time,duration,organizer,people,likes,request) values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, title);
        stmt.setString(2, description);
        stmt.setString(3, time);
        stmt.setInt(4, duration);
        stmt.setString(5, this.profile.name);
        stmt.setInt(6, people);
        stmt.setInt(7, 0);
        stmt.setInt(8, this.id);
       

        stmt.executeUpdate();

       
       
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
