import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;
import java.sql.* ;
public class GetaRoomApp {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    User user = new User();
    Profile p=new Profile();
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GetaRoomApp window = new GetaRoomApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GetaRoomApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        createMainMenu();
        createStudentMenu();
        createAdminMenu();
        createUniversityRepMenu();
        createOrganizerMenu();
        createActivityForm();
        createRequestManagementPanel();
        createViewActivitiesPanel();
        createForumPanel();
        createAddRoomForm();
        createGroupForm();
        createGroupsManagementPanel();
        createViewGroupsPanel();
        createRoles();
        createSupportForm();
        createSupportPanel();
        
        
    }

    private void createMainMenu() {
        JPanel mainMenu = new JPanel();
        mainPanel.add(mainMenu, "mainMenu");
        mainMenu.setLayout(null);

        JLabel lblWelcome = new JLabel("Καλώς ήρθατε στο GetaRoom!");
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblWelcome.setBounds(150, 30, 300, 40);
        mainMenu.add(lblWelcome);

        JLabel lblTitle = new JLabel("Όνομα:");
        lblTitle.setBounds(100, 100, 100, 25);
        mainMenu.add(lblTitle);

        JTextField txtTitle = new JTextField();
        txtTitle.setBounds(200, 100, 200, 25);
        mainMenu.add(txtTitle);
        
        JLabel lblPassword = new JLabel("Κωδικός:");
        lblPassword.setBounds(100, 160, 100, 25);
        mainMenu.add(lblPassword);

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(200, 160, 200, 25);
        mainMenu.add(txtPassword);
        
        JButton btnSubmit = new JButton("Υποβολή");
        btnSubmit.setBounds(200, 250, 200, 25);
        mainMenu.add(btnSubmit);
        
        btnSubmit.addActionListener(e -> {
            String name = txtTitle.getText();
            String pass = txtPassword.getText();
            String password="";
            String type="";
        
        
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
        
       
       
       
       
       PreparedStatement stmt = conn.prepareStatement("select * from users where name=?");
       stmt.setString(1, name);
       ResultSet result = stmt.executeQuery();
       result.next();
       type=result.getString(2);
       user.p=p;
       p.type=type;
       p.name=name;
       p.password=result.getString(4);
       user.id=result.getInt(1);
       p.email=result.getString(5);
       p.phone=result.getString(6);
       
       //JOptionPane.showMessageDialog(frame, "Αποσύνδεση...");
       if(!pass.equals(p.password))
       JOptionPane.showMessageDialog(frame, "Λάθος στοιχεία");
       else{
       
       
       if(type.equals("student"))
       btnSubmit.addActionListener(es -> cardLayout.show(mainPanel, "studentMenu"));
       else if(type.equals("admin"))
       btnSubmit.addActionListener(es -> cardLayout.show(mainPanel, "adminMenu"));
       else if(type.equals("organizer"))
       btnSubmit.addActionListener(es -> cardLayout.show(mainPanel, "organizerMenu"));
       else if(type.equals("udr"))
       btnSubmit.addActionListener(es -> cardLayout.show(mainPanel, "universityRepMenu"));
    createNotificationsPanel();
    createBookRoom();
    createRoomRequestPanel();
}
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
   catch( Exception ex )
   {
      System.out.println( ex ) ;
   }
        ////btnStudent.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
        //btnAdmin.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
        //btnUniversityRep.addActionListener(e -> cardLayout.show(mainPanel, "universityRepMenu"));
      
        });//btnOrganizer.addActionListener(e -> cardLayout.show(mainPanel, "organizerMenu"));
    }

    private void createStudentMenu() {
        JPanel studentMenu = new JPanel();
        mainPanel.add(studentMenu, "studentMenu");
        studentMenu.setLayout(null);
        
        

        JLabel lblStudentMenu = new JLabel("Μενού Φοιτητή");
        lblStudentMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblStudentMenu.setBounds(250, 30, 200, 40);
        studentMenu.add(lblStudentMenu);
        
        JButton btnNot = new JButton("μηνύματα");
        btnNot.setBounds(300, 000, 110, 30);
        studentMenu.add(btnNot);
        JButton btnSupport = new JButton("υποστήριξη");
        btnSupport.setBounds(100, 000, 110, 30);
        studentMenu.add(btnSupport);

        JButton btnViewActivities = new JButton("Προβολή Δραστηριοτήτων");
        btnViewActivities.setBounds(200, 100, 250, 40);
        studentMenu.add(btnViewActivities);

        JButton btnCommunicationForum = new JButton("Επικοινωνία μέσω του forum");
        btnCommunicationForum.setBounds(200, 160, 250, 40);
        studentMenu.add(btnCommunicationForum);
        
        JButton btnJoinGroup = new JButton("Εγγραφή σε σύλλογο");
        btnJoinGroup.setBounds(200, 220, 250, 40);
        studentMenu.add(btnJoinGroup);

       

        JButton btnLogoutStudent = new JButton("Αποσύνδεση");
        btnLogoutStudent.setBounds(200, 280, 250, 40);
        studentMenu.add(btnLogoutStudent);

        btnViewActivities.addActionListener(e -> cardLayout.show(mainPanel, "viewActivitiesPanel"));
        btnCommunicationForum.addActionListener(e -> cardLayout.show(mainPanel, "forumPanel"));
        btnJoinGroup.addActionListener(e -> cardLayout.show(mainPanel, "viewGroupsPanel"));
        btnNot.addActionListener(e -> cardLayout.show(mainPanel, "notifications"));
        btnSupport.addActionListener(e -> cardLayout.show(mainPanel, "supportForm"));
        
        btnLogoutStudent.addActionListener(e -> {
            // Κώδικας για αποσύνδεση του φοιτητή
            JOptionPane.showMessageDialog(frame, "Αποσύνδεση...");
        });
    }
    
    
    private void createOrganizerMenu() {
        JPanel organizerMenu = new JPanel();
        mainPanel.add(organizerMenu, "organizerMenu");
        organizerMenu.setLayout(null);

        JLabel lblOrganizerMenu = new JLabel("Μενού οργανωτή");
        lblOrganizerMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblOrganizerMenu.setBounds(250, 30, 200, 40);
        organizerMenu.add(lblOrganizerMenu);

        JButton btnViewActivities = new JButton("Δημιουργία συλλόγου");
        btnViewActivities.setBounds(200, 100, 250, 40);
        organizerMenu.add(btnViewActivities);

        JButton btnCommunicationForum = new JButton("Επικοινωνία μέσω του forum");
        btnCommunicationForum.setBounds(200, 160, 250, 40);
        organizerMenu.add(btnCommunicationForum);

        JButton btnCreateActivity = new JButton("Δημιουργία Δραστηριότητας");
        btnCreateActivity.setBounds(200, 220, 250, 40);
        organizerMenu.add(btnCreateActivity);

        JButton btnLogoutStudent = new JButton("Κράτηση αίθουσας");
        btnLogoutStudent.setBounds(200, 280, 250, 40);
        organizerMenu.add(btnLogoutStudent);

        btnViewActivities.addActionListener(e -> cardLayout.show(mainPanel, "groupForm"));
        btnCommunicationForum.addActionListener(e -> cardLayout.show(mainPanel, "forumPanel"));
        btnCreateActivity.addActionListener(e -> cardLayout.show(mainPanel, "activityForm"));
        btnLogoutStudent.addActionListener(e -> cardLayout.show(mainPanel, "book"));
    }

    private void createAdminMenu() {
        JPanel adminMenu = new JPanel();
        mainPanel.add(adminMenu, "adminMenu");
        adminMenu.setLayout(null);

        JLabel lblAdminMenu = new JLabel("Μενού Διαχειριστή");
        lblAdminMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAdminMenu.setBounds(200, 30, 200, 40);
        adminMenu.add(lblAdminMenu);

        JButton btnManageContent = new JButton("Διαχείριση Περιεχομένου");
        btnManageContent.setBounds(200, 100, 200, 40);
        adminMenu.add(btnManageContent);

        JButton btnManageEvents = new JButton("Διαχείριση Αιτημάτων Διοργάνωσης");
        btnManageEvents.setBounds(200, 160, 200, 40);
        adminMenu.add(btnManageEvents);

        JButton btnManageGroups = new JButton("Διαχείριση Αιτημάτων Συλλόγου");
        btnManageGroups.setBounds(200, 220, 200, 40);
        adminMenu.add(btnManageGroups);
        
        
        JButton btnManageSupport = new JButton("Διαχείριση Αιτημάτων Υποστήριξης");
        btnManageSupport.setBounds(200, 280, 200, 40);
        adminMenu.add(btnManageSupport);

        JButton btnBackToMainFromAdmin = new JButton("Ανάθεση ρόλων");
        btnBackToMainFromAdmin.setBounds(200, 340, 200, 40);
        adminMenu.add(btnBackToMainFromAdmin);

        btnManageEvents.addActionListener(e -> cardLayout.show(mainPanel, "requestManagement"));
        btnBackToMainFromAdmin.addActionListener(e -> cardLayout.show(mainPanel, "rolesPanel"));
        btnManageGroups.addActionListener(e -> cardLayout.show(mainPanel, "groupManagement"));
        btnManageSupport.addActionListener(e -> cardLayout.show(mainPanel, "supportManagement"));

        //btnManageContent.addActionListener(e -> cardLayout.show(mainPanel, "requestManagement"));
    }


    private void createAddRoomForm() {
        JPanel addRoomForm = new JPanel();
        mainPanel.add(addRoomForm, "addRoomForm");
        addRoomForm.setLayout(null);

        JLabel lblTitle = new JLabel("Προσθήκη Αίθουσας");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(200, 30, 200, 40);
        addRoomForm.add(lblTitle);

        JLabel lblName = new JLabel("Όνομα Αίθουσας:");
        lblName.setBounds(100, 100, 100, 30);
        addRoomForm.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(220, 100, 200, 30);
        addRoomForm.add(txtName);

        JLabel lblCapacity = new JLabel("Χωρητικότητα:");
        lblCapacity.setBounds(100, 150, 100, 30);
        addRoomForm.add(lblCapacity);

        JTextField txtCapacity = new JTextField();
        txtCapacity.setBounds(220, 150, 200, 30);
        addRoomForm.add(txtCapacity);

        JLabel lblHours = new JLabel("Διαθέσιμες Ώρες:");
        lblHours.setBounds(100, 200, 100, 30);
        addRoomForm.add(lblHours);

        JComboBox<String> comboHours = new JComboBox<>(new String[] {"08:00-10:00", "10:00-12:00", "12:00-14:00"});
        comboHours.setBounds(220, 200, 200, 30);
        addRoomForm.add(comboHours);

        JLabel lblSpecialReq = new JLabel("Ειδικές Απαιτήσεις:");
        lblSpecialReq.setBounds(100, 250, 100, 30);
        addRoomForm.add(lblSpecialReq);

        JTextField txtSpecialReq = new JTextField();
        txtSpecialReq.setBounds(220, 250, 200, 30);
        addRoomForm.add(txtSpecialReq);

        JButton btnSubmit = new JButton("Υποβολή");
        btnSubmit.setBounds(220, 300, 100, 30);
        addRoomForm.add(btnSubmit);

        JLabel lblMessage = new JLabel("");
        lblMessage.setBounds(100, 350, 320, 30);
        addRoomForm.add(lblMessage);

        btnSubmit.addActionListener(e -> {
            String name = txtName.getText();
            String capacity = txtCapacity.getText();
            String hours = (String) comboHours.getSelectedItem();
            String specialReq = txtSpecialReq.getText();

            if (name.isEmpty() || capacity.isEmpty() || hours.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ συμπληρώστε όλα τα πεδία.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            } else {
                
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
        
       
       
       
       
       PreparedStatement stmt = conn.prepareStatement("insert into rooms(name,capacity,special_info,department)  values(?,?,?,?)");
       stmt.setString(1, name);
       stmt.setInt(2, Integer.parseInt(capacity));
       stmt.setString(3, specialReq);
       stmt.setString(4, "ceid");
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
   catch( Exception ex )
   {
      System.out.println( ex ) ;
   }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                // Εδώ θα μπει ο κώδικας για την καταχώρηση της αίθουσας στο σύστημα
                JOptionPane.showMessageDialog(frame, "Η αίθουσα καταχωρήθηκε επιτυχώς!", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "universityRepMenu");
            }
        });

        JButton btnBack = new JButton("Πίσω");
        btnBack.setBounds(100, 300, 100, 30);
        addRoomForm.add(btnBack);

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "universityRepMenu"));
    }
    
    
    private void createSupportForm() {
        JPanel supportForm = new JPanel();
        mainPanel.add(supportForm, "supportForm");
        supportForm.setLayout(null);

        JLabel lblTitle = new JLabel("Υποστήριξη");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(200, 30, 200, 40);
        supportForm.add(lblTitle);

        JLabel lblName = new JLabel("Θέμα:");
        lblName.setBounds(100, 100, 100, 30);
        supportForm.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(220, 100, 200, 30);
        supportForm.add(txtName);

        JLabel lblCapacity = new JLabel("Κείμενο:");
        lblCapacity.setBounds(100, 150, 100, 30);
        supportForm.add(lblCapacity);

        JTextField txtTxt = new JTextField();
        txtTxt.setBounds(220, 150, 200, 30);
        supportForm.add(txtTxt);

        

        JButton btnSubmit = new JButton("Υποβολή");
        btnSubmit.setBounds(220, 300, 100, 30);
        supportForm.add(btnSubmit);

        

        btnSubmit.addActionListener(e -> {
            String theme = txtName.getText();
            String text = txtTxt.getText();
            

            
                
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
        
       
       
       
       
       PreparedStatement stmt = conn.prepareStatement("insert into support(user,theme,request)  values(?,?,?)");
       stmt.setString(2, theme);
       stmt.setString(3,text);
       stmt.setString(1,user.p.name);
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
   catch( Exception ex )
   {
      System.out.println( ex ) ;
   }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                // Εδώ θα μπει ο κώδικας για την καταχώρηση της αίθουσας στο σύστημα
                
                cardLayout.show(mainPanel, "studentMenu");
            
        });

        JButton btnBack = new JButton("Πίσω");
        btnBack.setBounds(100, 300, 100, 30);
        supportForm.add(btnBack);

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "universityRepMenu"));
    }
    
    
    private void createBookRoom() {
        JPanel bookRoom = new JPanel();
        mainPanel.add(bookRoom, "book");
        bookRoom.setLayout(null);

        JLabel lblTitle = new JLabel("Κράτηση Αίθουσας");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(200, 30, 200, 40);
        bookRoom.add(lblTitle);

        JLabel lblName = new JLabel("Όνομα Αίθουσας:");
        lblName.setBounds(100, 100, 100, 30);
        bookRoom.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(200, 100, 200, 30);
        bookRoom.add(txtName);

        

        JLabel lblHours = new JLabel("Ώρα και ημέρα:");
        lblHours.setBounds(100, 200, 200, 30);
        bookRoom.add(lblHours);

        JTextField txtTime = new JTextField();
        txtTime.setBounds(200, 200, 200, 30);
        bookRoom.add(txtTime);

        

        JButton btnSubmit = new JButton("Υποβολή");
        btnSubmit.setBounds(220, 300, 100, 30);
        bookRoom.add(btnSubmit);

        JLabel lblMessage = new JLabel("");
        lblMessage.setBounds(100, 350, 320, 30);
        bookRoom.add(lblMessage);

        btnSubmit.addActionListener(e -> {
            String name = txtName.getText();
            String time=txtTime.getText();

            
                
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
        
       
       PreparedStatement stmt = conn.prepareStatement("select title from events  where organizer=?");
       stmt.setString(1, user.p.name);
       ResultSet result=stmt.executeQuery();
       result.next();
       String event=result.getString(1);
       
        stmt = conn.prepareStatement("insert into room_requests(room,event,time)  values(?,?,?)");
       stmt.setString(1, name);
       stmt.setString(2, event);
       stmt.setString(3, time);
       
       
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
   catch( Exception ex )
   {
      System.out.println( ex ) ;
   }
                
        
                JOptionPane.showMessageDialog(frame, "Η αίθουσα καταχωρήθηκε επιτυχώς!", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "organizerRepMenu");
            
        });

        JButton btnBack = new JButton("Πίσω");
        btnBack.setBounds(100, 300, 100, 30);
        bookRoom.add(btnBack);

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "universityRepMenu"));
    }

    private void createUniversityRepMenu() {
        JPanel universityRepMenu = new JPanel();
        mainPanel.add(universityRepMenu, "universityRepMenu");
        universityRepMenu.setLayout(null);

        JLabel lblTitle = new JLabel("Μενού Πανεπιστημιακού Υπεύθυνου");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(150, 30, 300, 40);
        universityRepMenu.add(lblTitle);

        JButton btnAddRoom = new JButton("Προσθήκη Αίθουσας");
        btnAddRoom.setBounds(200, 100, 200, 40);
        universityRepMenu.add(btnAddRoom);
        
        JButton btnRequests = new JButton("Διαχείρηση αιτήματος αίθουσας");
        btnRequests.setBounds(200, 200, 200, 40);
        universityRepMenu.add(btnRequests);

        btnAddRoom.addActionListener(e -> cardLayout.show(mainPanel, "addRoomForm"));
        btnRequests.addActionListener(e -> cardLayout.show(mainPanel, "roomManagement"));
    }
    
    
    
    private void createRoomRequestPanel() {
        JPanel requestManagementPanel = new JPanel();
        mainPanel.add(requestManagementPanel, "roomManagement");
        requestManagementPanel.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Διαχείριση Αιτημάτων Κράτησης");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        requestManagementPanel.add(lblRequestManagement);

        // Placeholder for request list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add some example requests
        //listModel.addElement("Αίτημα 1: Κράτηση αίθουσας για μάθημα");
        //listModel.addElement("Αίτημα 2: Κράτηση αίθουσας για εκδήλωση");

        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        requestManagementPanel.add(requestList);

        JButton btnApproveRequest = new JButton("Έγκριση");
        btnApproveRequest.setBounds(100, 270, 100, 40);
        requestManagementPanel.add(btnApproveRequest);

        JButton btnRejectRequest = new JButton("Πληροφορίες");
        btnRejectRequest.setBounds(220, 270, 100, 40);
        requestManagementPanel.add(btnRejectRequest);
        
        

        JButton btnBackToAdminMenu = new JButton("Επιστροφή στο Μενού Διαχειριστή");
        btnBackToAdminMenu.setBounds(340, 270, 200, 40);
        requestManagementPanel.add(btnBackToAdminMenu);
        
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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select event from room_requests  ");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       
       listModel.addElement(name);
    }
       
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
        
        
        
        
        btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                JOptionPane.showMessageDialog(frame, "Το αίτημα '" + selectedRequest + "' εγκρίθηκε.");
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });

        
        
        
        btnRejectRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                Request_Info event=new Request_Info();
                event.event=selectedRequest;
                String info=event.getInfo();
                JOptionPane.showMessageDialog(frame, info);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });

        btnBackToAdminMenu.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
    }


    private void createActivityForm() {
        JPanel activityForm = new JPanel();
        mainPanel.add(activityForm, "activityForm");
        activityForm.setLayout(null);

        JLabel lblActivityForm = new JLabel("Δημιουργία Δραστηριότητας");
        lblActivityForm.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblActivityForm.setBounds(150, 30, 300, 40);
        activityForm.add(lblActivityForm);

        JLabel lblTitle = new JLabel("Τίτλος:");
        lblTitle.setBounds(100, 100, 100, 25);
        activityForm.add(lblTitle);

        JTextField txtTitle = new JTextField();
        txtTitle.setBounds(200, 100, 200, 25);
        activityForm.add(txtTitle);

        JLabel lblDescription = new JLabel("Περιγραφή:");
        lblDescription.setBounds(100, 150, 100, 25);
        activityForm.add(lblDescription);

        JTextArea txtDescription = new JTextArea();
        txtDescription.setBounds(200, 150, 200, 75);
        activityForm.add(txtDescription);

        JLabel lblStartTime = new JLabel("Προτεινόμενη Αρχική Ώρα:");
        lblStartTime.setBounds(100, 250, 150, 25);
        activityForm.add(lblStartTime);

        JTextField txtStartTime = new JTextField();
        txtStartTime.setBounds(260, 250, 100, 25);
        activityForm.add(txtStartTime);

        JLabel lblExpectedParticipants = new JLabel("Αναμενόμενος Αριθμός Ατόμων:");
        lblExpectedParticipants.setBounds(100, 300, 200, 25);
        activityForm.add(lblExpectedParticipants);

        JTextField txtExpectedParticipants = new JTextField();
        txtExpectedParticipants.setBounds(300, 300, 100, 25);
        activityForm.add(txtExpectedParticipants);

        JButton btnSubmitActivity = new JButton("Υποβολή");
        btnSubmitActivity.setBounds(320, 350, 100, 40);
        activityForm.add(btnSubmitActivity);

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(100, 350, 200, 40);
        activityForm.add(btnBackToStudentMenu);

        btnSubmitActivity.addActionListener(e -> {
            String title = txtTitle.getText();
            String description = txtDescription.getText();
            String startTime = txtStartTime.getText();
            String expectedParticipants = txtExpectedParticipants.getText();
            
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
        
       
       
       
       
       PreparedStatement stmt = conn.prepareStatement("insert into suggestions(title, description,time,duration,organizer,people,likes,request) values(?,?,?,?,?,?,?,?)");
       stmt.setString(1, title);
       stmt.setString(2, description);
       stmt.setString(3, startTime);
       stmt.setInt(4, 2);
       stmt.setString(5, p.name);
       stmt.setInt(6, Integer.parseInt(expectedParticipants));
       stmt.setInt(7, 0);
       stmt.setInt(8, user.id);
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
   catch( Exception ee )
   {
      System.out.println( ee ) ;
   }

            JOptionPane.showMessageDialog(frame, "Η δραστηριότητα '" + title + "' υποβλήθηκε με επιτυχία!");
            txtTitle.setText("");
            txtDescription.setText("");
            txtStartTime.setText("");
            txtExpectedParticipants.setText("");
            cardLayout.show(mainPanel, "studentMenu");
        });

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }
    
    
    
    
    
    private void createGroupForm() {
        JPanel activityForm = new JPanel();
        mainPanel.add(activityForm, "groupForm");
        activityForm.setLayout(null);

        JLabel lblActivityForm = new JLabel("Δημιουργία Συλλόγου");
        lblActivityForm.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblActivityForm.setBounds(150, 30, 300, 40);
        activityForm.add(lblActivityForm);

        JLabel lblTitle = new JLabel("Τίτλος:");
        lblTitle.setBounds(100, 100, 100, 25);
        activityForm.add(lblTitle);

        JTextField txtTitle = new JTextField();
        txtTitle.setBounds(200, 100, 200, 25);
        activityForm.add(txtTitle);

        JLabel lblDescription = new JLabel("Περιγραφή:");
        lblDescription.setBounds(100, 150, 100, 25);
        activityForm.add(lblDescription);

        JTextArea txtDescription = new JTextArea();
        txtDescription.setBounds(200, 150, 200, 75);
        activityForm.add(txtDescription);

        

        JButton btnSubmitActivity = new JButton("Υποβολή");
        btnSubmitActivity.setBounds(320, 350, 100, 40);
        activityForm.add(btnSubmitActivity);

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(100, 350, 200, 40);
        activityForm.add(btnBackToStudentMenu);

        btnSubmitActivity.addActionListener(e -> {
            String title = txtTitle.getText();
            String description = txtDescription.getText();
            
            
                Group_Suggestion suggest = new Group_Suggestion();
                suggest.name=title;
                suggest.description=description;
                suggest.save();
                

            JOptionPane.showMessageDialog(frame, "Η δραστηριότητα '" + title + "' υποβλήθηκε με επιτυχία!");
            txtTitle.setText("");
            txtDescription.setText("");
            cardLayout.show(mainPanel, "organizerMenu");
        });

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "organizerMenu"));
    }

    private void createRequestManagementPanel() {
        JPanel requestManagementPanel = new JPanel();
        mainPanel.add(requestManagementPanel, "requestManagement");
        requestManagementPanel.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Διαχείριση Αιτημάτων Δραστηριότητας");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        requestManagementPanel.add(lblRequestManagement);

        // Placeholder for request list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add some example requests
        //listModel.addElement("Αίτημα 1: Κράτηση αίθουσας για μάθημα");
        //listModel.addElement("Αίτημα 2: Κράτηση αίθουσας για εκδήλωση");

        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        requestManagementPanel.add(requestList);

        JButton btnApproveRequest = new JButton("Έγκριση");
        btnApproveRequest.setBounds(100, 270, 100, 40);
        requestManagementPanel.add(btnApproveRequest);

        JButton btnRejectRequest = new JButton("Απόρριψη");
        btnRejectRequest.setBounds(220, 270, 100, 40);
        requestManagementPanel.add(btnRejectRequest);

        JButton btnBackToAdminMenu = new JButton("Επιστροφή στο Μενού Διαχειριστή");
        btnBackToAdminMenu.setBounds(340, 270, 200, 40);
        requestManagementPanel.add(btnBackToAdminMenu);
        
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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select title,description from suggestions  ");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       desc=result.getString(2);
       listModel.addElement(name);
    }
       
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
        
        
        
        
        btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
                Event_Suggestion suggest = new Event_Suggestion();
                User user = new User();
                Profile p = new Profile();
                user.p=p;
                p.name="john";
                suggest.title=selectedRequest;
                suggest.organizer=user;
                suggest.approve();
                JOptionPane.showMessageDialog(frame, "Το αίτημα '" + selectedRequest + "' εγκρίθηκε.");
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });

        btnRejectRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
                Event_Suggestion suggest = new Event_Suggestion();
                User user = new User();
                Profile p = new Profile();
                user.p=p;
                p.name="john";
                suggest.title=selectedRequest;
                suggest.organizer=user;
                suggest.reject();
                JOptionPane.showMessageDialog(frame, "Το αίτημα '" + selectedRequest + "' απορρίφθηκε.");
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για απόρριψη.");
            }
        });

        btnBackToAdminMenu.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
    }
    
    
    private void createSupportPanel() {
        JPanel supportPanel = new JPanel();
        mainPanel.add(supportPanel, "supportManagement");
        supportPanel.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Διαχείριση Αιτημάτων υποστήριξης");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        supportPanel.add(lblRequestManagement);

        // Placeholder for request list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add some example requests
        //listModel.addElement("Αίτημα 1: Κράτηση αίθουσας για μάθημα");
        //listModel.addElement("Αίτημα 2: Κράτηση αίθουσας για εκδήλωση");

        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 200, 150);
        supportPanel.add(requestList);

        JButton btnApproveRequest = new JButton("Απάντηση");
        btnApproveRequest.setBounds(100, 270, 100, 40);
        supportPanel.add(btnApproveRequest);
        
        JTextArea txtDescription = new JTextArea();
        txtDescription.setBounds(300, 100, 200, 75);
        supportPanel.add(txtDescription);


        JButton btnBackToAdminMenu = new JButton("Επιστροφή στο Μενού Διαχειριστή");
        btnBackToAdminMenu.setBounds(340, 270, 200, 40);
        supportPanel.add(btnBackToAdminMenu);
        
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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select theme from support ");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       
       listModel.addElement(name);
    }
       
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
        
        
        
        
        btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
                Administrator admin = new Administrator();
                admin.p=this.p;
                String request=selectedRequest;
                String answer=txtDescription.getText();
                admin.solve(request,answer);
                
                
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });

        

        btnBackToAdminMenu.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
    }
    
    private void createNotificationsPanel() {
        JPanel NotificationsPanel = new JPanel();
        mainPanel.add(NotificationsPanel, "notifications");
        NotificationsPanel.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Μηνύματα");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        NotificationsPanel.add(lblRequestManagement);

        // Placeholder for request list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        

        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        NotificationsPanel.add(requestList);

        

        

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(340, 270, 200, 40);
        NotificationsPanel.add(btnBackToStudentMenu);
        
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
        
       
       
       String name,text;
       
       PreparedStatement stmt = conn.prepareStatement("select sender,text from notification where user=? ");
       stmt.setString(1,user.p.name);
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       text=result.getString(2);
       listModel.addElement(name+":   "+text);
    }
       
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
        
        
        
        
        

        

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }
    
    
    
    
    private void createGroupsManagementPanel() {
        JPanel groupsManagementPanel = new JPanel();
        mainPanel.add(groupsManagementPanel, "groupManagement");
        groupsManagementPanel.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Διαχείριση Αιτημάτων Συλλόγου");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        groupsManagementPanel.add(lblRequestManagement);

        // Placeholder for request list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add some example requests
        //listModel.addElement("Αίτημα 1: Κράτηση αίθουσας για μάθημα");
        //listModel.addElement("Αίτημα 2: Κράτηση αίθουσας για εκδήλωση");

        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        groupsManagementPanel.add(requestList);

        JButton btnApproveRequest = new JButton("Έγκριση");
        btnApproveRequest.setBounds(100, 270, 100, 40);
        groupsManagementPanel.add(btnApproveRequest);

        JButton btnRejectRequest = new JButton("Απόρριψη");
        btnRejectRequest.setBounds(220, 270, 100, 40);
        groupsManagementPanel.add(btnRejectRequest);

        JButton btnBackToAdminMenu = new JButton("Επιστροφή στο Μενού Διαχειριστή");
        btnBackToAdminMenu.setBounds(340, 270, 200, 40);
        groupsManagementPanel.add(btnBackToAdminMenu);
        
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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select title from group_suggestions  ");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       
       listModel.addElement(name);
    }
       
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
        
        
        
        
        btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
                Group_Suggestion suggest = new Group_Suggestion();
                suggest.name=selectedRequest;
                suggest.approve();
                JOptionPane.showMessageDialog(frame, "Το αίτημα '" + selectedRequest + "' εγκρίθηκε.");
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });

        btnRejectRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
                Group_Suggestion suggest = new Group_Suggestion();
                suggest.name=selectedRequest;
                suggest.reject();
                JOptionPane.showMessageDialog(frame, "Το αίτημα '" + selectedRequest + "' απορρίφθηκε.");
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για απόρριψη.");
            }
        });

        btnBackToAdminMenu.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
    }

    private void createViewActivitiesPanel() {
        JPanel viewActivitiesPanel = new JPanel();
        mainPanel.add(viewActivitiesPanel, "viewActivitiesPanel");
        viewActivitiesPanel.setLayout(null);

        

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(200, 320, 200, 40);
        viewActivitiesPanel.add(btnBackToStudentMenu);
        
        JButton btnApproveRequest = new JButton("Πληροφορίες");
        btnApproveRequest.setBounds(100, 270, 100, 40);
        viewActivitiesPanel.add(btnApproveRequest);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        viewActivitiesPanel.add(requestList);
        
        

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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select title from events");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       listModel.addElement(name);
    }
    
    
    
    
    
    
       
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
        
   btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                Approved_Event event=new Approved_Event();
                event.title=selectedRequest;
                String info=event.getInfo();
                JOptionPane.showMessageDialog(frame, info);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
   
        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }
    
    
    private void createRoles() {
        JPanel rolesPanel = new JPanel();
        mainPanel.add(rolesPanel, "rolesPanel");
        rolesPanel.setLayout(null);

        

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(200, 320, 200, 40);
        rolesPanel.add(btnBackToStudentMenu);
        
        
        JButton btnUniversity = new JButton("Εκπρόσωπος σχολής");
        btnUniversity.setBounds(100, 270, 100, 40);
        rolesPanel.add(btnUniversity);
        JButton btnOrganizer = new JButton("Διοργανωτής");
        btnOrganizer.setBounds(200, 270, 100, 40);
        rolesPanel.add(btnOrganizer);
        JButton btnAdmin = new JButton("Υπέυθυνος");
        btnAdmin.setBounds(300, 270, 100, 40);
        rolesPanel.add(btnAdmin);
        JButton btnStrip = new JButton("Αφαίρεση ρόλου");
        btnStrip.setBounds(00, 270, 100, 40);
        rolesPanel.add(btnStrip);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        rolesPanel.add(requestList);
        
        

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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select name from users");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       listModel.addElement(name);
    }
    
    
    
    
    
    
       
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
        
   btnStrip.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                User user=new User();
                Profile p = new Profile();
                user.p=p;
                user.p.name=selectedRequest;
                user.role(0);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
        
        btnUniversity.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                User user=new User();
                Profile p = new Profile();
                user.p=p;
                user.p.name=selectedRequest;
                user.role(1);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
        
        btnOrganizer.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                User user=new User();
                Profile p = new Profile();
                user.p=p;
                user.p.name=selectedRequest;
                user.role(2);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
        
        btnAdmin.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                User user=new User();
                Profile p = new Profile();
                user.p=p;
                user.p.name=selectedRequest;
                user.role(3);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
   
        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }
    
    
    private void createViewGroupsPanel() {
        JPanel createViewGroupsPanel = new JPanel();
        mainPanel.add(createViewGroupsPanel, "viewGroupsPanel");
        createViewGroupsPanel.setLayout(null);


        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(200, 320, 200, 40);
        createViewGroupsPanel.add(btnBackToStudentMenu);
        
        JButton btnApproveRequest = new JButton("Πληροφορίες");
        btnApproveRequest.setBounds(100, 270, 100, 40);
        createViewGroupsPanel.add(btnApproveRequest);
        
        JButton btnJoin = new JButton("Εγγραφή");
        btnJoin.setBounds(200, 270, 100, 40);
        createViewGroupsPanel.add(btnJoin);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> requestList = new JList<>(listModel);
        requestList.setBounds(100, 100, 400, 150);
        createViewGroupsPanel.add(requestList);
        
        

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
        
       
       
       String name,desc;
       
       PreparedStatement stmt = conn.prepareStatement("select title from groups_table");
       ResultSet result = stmt.executeQuery();
       while(result.next()){
        
       name=result.getString(1);
       listModel.addElement(name);
    }
    
    
    
    
    
    
       
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
        
   btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                Group group=new Group();
                group.name=selectedRequest;
                String info=group.getInfo();
                JOptionPane.showMessageDialog(frame, info);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
        
        btnJoin.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                
                Group group=new Group();
                group.name=selectedRequest;
                group.addMember(user.id);
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });
   
        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }

    private void createForumPanel() {
        JPanel forumPanel = new JPanel();
        mainPanel.add(forumPanel, "forumPanel");
        forumPanel.setLayout(new BorderLayout());

        JLabel lblForum = new JLabel("Επικοινωνία μέσω του forum");
        lblForum.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblForum.setHorizontalAlignment(SwingConstants.CENTER);
        forumPanel.add(lblForum, BorderLayout.NORTH);

        String[] columnNames = {"Όνομα Συζήτησης", "Κατηγορία", "Άτομα", "Απαντήσεις", "Τελευταία Απάντηση"};
        Object[][] data = {
                {"Συζήτηση 1", "Γενικά", 10, 5, "20/05/2024"},
                {"Συζήτηση 2", "Ακαδημαϊκά", 8, 3, "19/05/2024"},
                {"Συζήτηση 3", "Εκδηλώσεις", 15, 7, "18/05/2024"},
                {"Συζήτηση 4", "Τεχνολογία", 12, 6, "17/05/2024"},
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        forumPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnBackToStudentMenuFromForum = new JButton("Επιστροφή στο Μενού Φοιτητή");
        forumPanel.add(btnBackToStudentMenuFromForum, BorderLayout.SOUTH);

        btnBackToStudentMenuFromForum.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }
}
