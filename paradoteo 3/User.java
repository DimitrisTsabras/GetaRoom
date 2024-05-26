import java.util.*;
import java.sql.* ;
import javax.swing.*;
/**
 * Γράψτε μια περιγραφή της κλάσης User εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class User
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    
    int id;
    Profile profile;
    List<String> notifications=new ArrayList<String>();

    /**
     * Κατασευαστής αντικειμένων της κλάσης User
     */
    public User()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
        
    }

    /**
     * Παράδειγμα μεθόδου - αντικαταστήστε το παρόν σχόλιο με το δικό σας
     * 
     * @param  y    παράδειγμα παραμέτρου για την μέθοδο
     * @return        το άθροισμα του x με το y 
     */
    public void support(String theme, String text)
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
       ;

       // Execute the query
        
        PreparedStatement stmt = conn.prepareStatement("insert into support(user,theme,request) values(?,?,?)");
        stmt.setString(1, this.profile.name);
        stmt.setString(2, theme);
        stmt.setString(3, text);
       
       

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
    
    
    public void join(String text, String group)
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
       boolean open;

       // Execute the query
        
        PreparedStatement stmt = conn.prepareStatement("select privacy from groups_table where title=?");
        stmt.setString(1,group);

        ResultSet result = stmt.executeQuery();
        result.next();
        open=result.getBoolean(1);
        
        Join_Request request = new Join_Request();
        request.text=text;
        request.user=this.profile.name;
        request.group=group;
        request.save();
        if(!open) request.approve();
        
       
       
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
