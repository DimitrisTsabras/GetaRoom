import java.sql.* ;
import javax.swing.*;
/**
 * Γράψτε μια περιγραφή της κλάσης Join_Request εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class Join_Request
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    String text;
    String user;
    String group;

    /**
     * Κατασευαστής αντικειμένων της κλάσης Join_Request
     */
    public Join_Request()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
        
    }

    /**
     * Παράδειγμα μεθόδου - αντικαταστήστε το παρόν σχόλιο με το δικό σας
     * 
     * @param  y    παράδειγμα παραμέτρου για την μέθοδο
     * @return        το άθροισμα του x με το y 
     */
    public void approve()
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
        
       Group  group = new Group();
       User user = new User();
       
       
       
       PreparedStatement stmt = conn.prepareStatement("select * from users where name=? ");
       stmt.setString(1, this.user);
       ResultSet result = stmt.executeQuery();
       result.next();
       user.id=result.getInt(1);
       stmt = conn.prepareStatement("select * from groups_table where title=? ");
       stmt.setString(1, this.group);
       result = stmt.executeQuery();
       result.next();
       group.name=result.getString(1);
       group.addMember(user.id);
       
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
