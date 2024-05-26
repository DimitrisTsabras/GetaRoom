  

import java.util.*;
import java.sql.*;

/**
 * Γράψτε μια περιγραφή της κλάσης Group εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class Group
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    String name;
    String description;
    List<Tag> tags=new ArrayList<Tag>();
    //List<User> members=new ArrayList<User>();
    //List<Join_Request> requests=new ArrayList<Join_Request>();
    List<String> notifications=new ArrayList<String>();
    boolean privacy;
    /**
     * Κατασευαστής αντικειμένων της κλάσης Group
     */
    public Group()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
        
    }

    
    public void addTag(Tag tag)
    {
        tags.add(tag);
        
    }


    public void addDetails(String name,String description)
    {
        this.name=name;
        this.description=description;
    }
    
    public void getDetails()
    {
        System.out.println(this.name);
        System.out.println(this.description);
        
    }
    public void makeOpenorPrivate(int op)
    {
        if(op==0) this.privacy=false;
        else this.privacy=true;
        
    }
    
    public  String getPrivacy()
    {
        if(this.privacy==false) return "open";
        else return "private";
    
    
    }
    
    public void addMember(int id)
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
           
       PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + this.name +"_members(id) VALUES (?)");
        
        stmt.setInt(1,id);
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
    
    
    
    public void save(){
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
           
       PreparedStatement stmt = conn.prepareStatement("INSERT INTO groups_table(title, description,privacy) VALUES (?,?,?)");
        
        stmt.setString(1, this.name);
        stmt.setString(2, this.description);
        stmt.setBoolean(3, this.privacy);
        

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
