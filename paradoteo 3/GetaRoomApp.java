import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;

public class GetaRoomApp {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

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
        createActivityForm();
        createRequestManagementPanel();
        createViewActivitiesPanel();
        createForumPanel();
        createAddRoomForm();
    }

    private void createMainMenu() {
        JPanel mainMenu = new JPanel();
        mainPanel.add(mainMenu, "mainMenu");
        mainMenu.setLayout(null);

        JLabel lblWelcome = new JLabel("Καλώς ήρθατε στο GetaRoom!");
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblWelcome.setBounds(150, 30, 300, 40);
        mainMenu.add(lblWelcome);

        JButton btnStudent = new JButton("Είσοδος ως Φοιτητής");
        btnStudent.setBounds(200, 100, 200, 40);
        mainMenu.add(btnStudent);

        JButton btnAdmin = new JButton("Είσοδος ως Διαχειριστής");
        btnAdmin.setBounds(200, 160, 200, 40);
        mainMenu.add(btnAdmin);

        JButton btnUniversityRep = new JButton("Είσοδος ως Πανεπιστημιακός Υπεύθυνος");
        btnUniversityRep.setBounds(200, 220, 200, 40);
        mainMenu.add(btnUniversityRep);

        btnStudent.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
        btnAdmin.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
        btnUniversityRep.addActionListener(e -> cardLayout.show(mainPanel, "universityRepMenu"));
    }

    private void createStudentMenu() {
        JPanel studentMenu = new JPanel();
        mainPanel.add(studentMenu, "studentMenu");
        studentMenu.setLayout(null);

        JLabel lblStudentMenu = new JLabel("Μενού Φοιτητή");
        lblStudentMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblStudentMenu.setBounds(250, 30, 200, 40);
        studentMenu.add(lblStudentMenu);

        JButton btnViewActivities = new JButton("Προβολή Δραστηριοτήτων");
        btnViewActivities.setBounds(200, 100, 250, 40);
        studentMenu.add(btnViewActivities);

        JButton btnCommunicationForum = new JButton("Επικοινωνία μέσω του forum");
        btnCommunicationForum.setBounds(200, 160, 250, 40);
        studentMenu.add(btnCommunicationForum);

        JButton btnCreateActivity = new JButton("Δημιουργία Δραστηριότητας");
        btnCreateActivity.setBounds(200, 220, 250, 40);
        studentMenu.add(btnCreateActivity);

        JButton btnLogoutStudent = new JButton("Αποσύνδεση");
        btnLogoutStudent.setBounds(200, 280, 250, 40);
        studentMenu.add(btnLogoutStudent);

        btnViewActivities.addActionListener(e -> cardLayout.show(mainPanel, "viewActivitiesPanel"));
        btnCommunicationForum.addActionListener(e -> cardLayout.show(mainPanel, "forumPanel"));
        btnCreateActivity.addActionListener(e -> cardLayout.show(mainPanel, "activityForm"));
        btnLogoutStudent.addActionListener(e -> {
            // Κώδικας για αποσύνδεση του φοιτητή
            JOptionPane.showMessageDialog(frame, "Αποσύνδεση...");
        });
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

        JButton btnManageRequests = new JButton("Διαχείριση Αιτημάτων Κράτησης");
        btnManageRequests.setBounds(200, 160, 200, 40);
        adminMenu.add(btnManageRequests);

        JButton btnBackToMainFromAdmin = new JButton("Επιστροφή στο Κεντρικό Μενού");
        btnBackToMainFromAdmin.setBounds(200, 220, 200, 40);
        adminMenu.add(btnBackToMainFromAdmin);

        btnManageRequests.addActionListener(e -> cardLayout.show(mainPanel, "requestManagement"));
        btnBackToMainFromAdmin.addActionListener(e -> cardLayout.show(mainPanel, "mainMenu"));
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

        btnAddRoom.addActionListener(e -> cardLayout.show(mainPanel, "addRoomForm"));
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

            JOptionPane.showMessageDialog(frame, "Η δραστηριότητα '" + title + "' υποβλήθηκε με επιτυχία!");
            txtTitle.setText("");
            txtDescription.setText("");
            txtStartTime.setText("");
            txtExpectedParticipants.setText("");
            cardLayout.show(mainPanel, "studentMenu");
        });

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }

    private void createRequestManagementPanel() {
        JPanel requestManagementPanel = new JPanel();
        mainPanel.add(requestManagementPanel, "requestManagement");
        requestManagementPanel.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Διαχείριση Αιτημάτων Κράτησης");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        requestManagementPanel.add(lblRequestManagement);

        // Placeholder for request list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add some example requests
        listModel.addElement("Αίτημα 1: Κράτηση αίθουσας για μάθημα");
        listModel.addElement("Αίτημα 2: Κράτηση αίθουσας για εκδήλωση");

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

        btnApproveRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
                JOptionPane.showMessageDialog(frame, "Το αίτημα '" + selectedRequest + "' εγκρίθηκε.");
            } else {
                JOptionPane.showMessageDialog(frame, "Παρακαλώ επιλέξτε ένα αίτημα για έγκριση.");
            }
        });

        btnRejectRequest.addActionListener(e -> {
            String selectedRequest = requestList.getSelectedValue();
            if (selectedRequest != null) {
                listModel.removeElement(selectedRequest);
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

        JLabel lblViewActivities = new JLabel("Τυχαία Δραστηριότητα");
        lblViewActivities.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblViewActivities.setBounds(200, 30, 200, 40);
        viewActivitiesPanel.add(lblViewActivities);

        JTextArea txtActivityDetails = new JTextArea();
        txtActivityDetails.setBounds(100, 100, 400, 150);
        txtActivityDetails.setEditable(false);
        viewActivitiesPanel.add(txtActivityDetails);

        JButton btnShowRandomActivity = new JButton("Εμφάνιση Τυχαίας Δραστηριότητας");
        btnShowRandomActivity.setBounds(200, 270, 200, 40);
        viewActivitiesPanel.add(btnShowRandomActivity);

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(200, 320, 200, 40);
        viewActivitiesPanel.add(btnBackToStudentMenu);

        btnShowRandomActivity.addActionListener(e -> {
            String[] titles = {"Σκακιστικός Αγώνας", "Σεμινάριο Προγραμματισμού", "Αθλητικός Αγώνας", "Καλλιτεχνικό Εργαστήρι"};
            String[] descriptions = {
                    "Ένας συναρπαστικός αγώνας σκακιού μεταξύ κορυφαίων παικτών.",
                    "Ένα σεμινάριο για τις τελευταίες τάσεις στον προγραμματισμό.",
                    "Ένας αγώνας μπάσκετ μεταξύ των τμημάτων του πανεπιστημίου.",
                    "Ένα εργαστήρι τέχνης με έμφαση στη ζωγραφική και τη γλυπτική."
            };
            String[] times = {"10:00", "12:00", "15:00", "17:00"};

            Random random = new Random();
            int index = random.nextInt(titles.length);

            String title = titles[index];
            String description = descriptions[index];
            String time = times[index];

            String activityDetails = "Τίτλος: " + title + "\n\nΠεριγραφή: " + description + "\n\nΏρα: " + time;
            txtActivityDetails.setText(activityDetails);
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