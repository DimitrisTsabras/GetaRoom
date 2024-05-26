import java.sql.* ;
import javax.swing.*;
/**
 * Γράψτε μια περιγραφή της κλάσης main εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class main
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    

    /**
     * Κατασευαστής αντικειμένων της κλάσης main
     */
   

    /**
     * Παράδειγμα μεθόδου - αντικαταστήστε το παρόν σχόλιο με το δικό σας
     * 
     * @param  y    παράδειγμα παραμέτρου για την μέθοδο
     * @return        το άθροισμα του x με το y 
     */
    public static void main(String args[]) 
    {
        // Γράψτε τον κώδικα σας εδώ
        //Group test = new Group();
        User user= new User();
        Administrator admin = new Administrator();
        Profile p1=new Profile();
        user.profile=p1;
        user.profile.changeCredentials(1,"john");
        //User user2=new User();
        
        /*Profile p2=new Profile();
        user2.profile=p2;
        user2.profile.changeCredentials(1,"jack");
        Join_Request r1=new Join_Request();
        Join_Request r2=new Join_Request();
        r1.group=test;
        r1.user=user;
        r2.group=test;
        r2.user=user2;
        test.addRequest(r1);
        test.addRequest(r2);
        for(Join_Request r:test.requests)
        r.approve();
        Profile p=new Profile();
        Event_Suggestion event = new Event_Suggestion();
        event.title="gaes";
        event.description="bla bla";
        event.time="02/01/2020";
        event.duration=2;
        event.organizer=user;
        event.expected_people=10;
        event.likes=11;
        event.request=1;
        event.saveEvent();
        event.approve();
        Approved_Event event2 = new Approved_Event();
        event2.organizer=event.organizer;*/
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
        
       
       /*Group_Suggestion suggest= new Group_Suggestion();
       suggest.name="games";
       suggest.description="there will be games";
       suggest.makeOpenorPrivate(1);
       suggest.save();
       suggest.approve();
       
       Join_Request request = new Join_Request();
       request.user="john";
       request.group="games";
       request.text="bla";
       request.approve();*/
       
       //PreparedStatement stmt = conn.prepareStatement("select * from events where title=? ");
       //stmt.setString(1, event.title);
       //ResultSet result = stmt.executeQuery();
       
       
       /*Event_Suggestion event = new Event_Suggestion();
       event.title="geams";
       event.description="geams for all";
       event.time="12/2/1999";
       event.duration=2;
       event.organizer=user;
       event.expected_people=30;
       event.likes=2;
       event.request=1;
       event.saveEvent();
       
       event.like();
       event.like();
       event.like();
       event.like();*/
       admin.solve("wtf");
        
       
       
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
