
/**
 * Γράψτε μια περιγραφή της κλάσης Profile εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
public class Profile
{
    // μεταβλητές στιγμιοτύπου - αντικαταστήστε το ακόλουθο παράδειγμα
    // με τις δικές σας μεταβλητές
    String type;
    String name;
    String password;
    String email;
    String phone;

    /**
     * Κατασευαστής αντικειμένων της κλάσης Profile
     */
    public Profile()
    {
        // αρχικοποίηση μεταβλητών στιγμιοτύπου
       
    }

    /**
     * Παράδειγμα μεθόδου - αντικαταστήστε το παρόν σχόλιο με το δικό σας
     * 
     * @param  y    παράδειγμα παραμέτρου για την μέθοδο
     * @return        το άθροισμα του x με το y 
     */
    public boolean checkCredentials(int field,String data)
    {
        if(field==1){
        
         for (char c : data.toCharArray()) {
      if (Character.isDigit(c)) {
         return false;
      }
   }
    return true;
    } 
    
    if(field==4){
        
         for (char c : data.toCharArray()) {
      if (!Character.isDigit(c)) {
         return false;
      }
   }
    return true;
    } return false;
    }
    
    
    public void changeCredentials(int field, String data){
        if(field==1) 
        if(checkCredentials(1,data)) this.name=data;
        if(field==2) this.password=data;
        if(field==3) this.email=data;
        if(field==4) 
        if(checkCredentials(4,data)) this.phone=data;
    }
}
