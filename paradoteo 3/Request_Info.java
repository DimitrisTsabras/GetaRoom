import java.sql.* ;
import javax.swing.*;
/**
 * Γράψτε μια περιγραφή της κλάσης Request_Info εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class Request_Info
{
    String time;
    int duration;
    String room;
    String event;
     

    /**
     * Κατασευαστής αντικειμένων της κλάσης Request_Info
     */
    public Request_Info()
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
        Department_Room room = new Department_Room();
        room.name=this.room;
        room.book(this.event);

    }
}
