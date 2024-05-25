import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
        createContentManagementPanel(); // Added content management panel
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

        btnManageContent.addActionListener(e -> cardLayout.show(mainPanel, "contentManagement"));
        btnManageRequests.addActionListener(e -> cardLayout.show(mainPanel, "requestManagement"));
        btnBackToMainFromAdmin.addActionListener(e -> cardLayout.show(mainPanel, "mainMenu"));
    }

    private void createUniversityRepMenu() {
        JPanel universityRepMenu = new JPanel();
        mainPanel.add(universityRepMenu, "universityRepMenu");
        universityRepMenu.setLayout(null);

        JLabel lblUniversityRepMenu = new JLabel("Μενού Πανεπιστημιακού Υπεύθυνου");
        lblUniversityRepMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblUniversityRepMenu.setBounds(150, 30, 300, 40);
        universityRepMenu.add(lblUniversityRepMenu);

        JButton btnManageSpaces = new JButton("Διαχείριση Χώρων");
        btnManageSpaces.setBounds(200, 100, 200, 40);
        universityRepMenu.add(btnManageSpaces);

        JButton btnBackToMainFromUniRep = new JButton("Επιστροφή στο Κεντρικό Μενού");
        btnBackToMainFromUniRep.setBounds(200, 160, 200, 40);
        universityRepMenu.add(btnBackToMainFromUniRep);

        btnBackToMainFromUniRep.addActionListener(e -> cardLayout.show(mainPanel, "mainMenu"));
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
            // Κώδικας για την υποβολή της δραστηριότητας
            JOptionPane.showMessageDialog(frame, "Η δραστηριότητα υποβλήθηκε!");
        });

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }

    private void createRequestManagementPanel() {
        JPanel requestManagement = new JPanel();
        mainPanel.add(requestManagement, "requestManagement");
        requestManagement.setLayout(null);

        JLabel lblRequestManagement = new JLabel("Διαχείριση Αιτημάτων Κράτησης");
        lblRequestManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblRequestManagement.setBounds(150, 30, 300, 40);
        requestManagement.add(lblRequestManagement);

        // Ακολουθεί κώδικας για τη δημιουργία του πίνακα αιτημάτων κράτησης
        // και κουμπιών έγκρισης/απόρριψης για κάθε αίτημα

        JButton btnBackToAdminMenu = new JButton("Επιστροφή στο Μενού Διαχειριστή");
        btnBackToAdminMenu.setBounds(200, 300, 200, 40);
        requestManagement.add(btnBackToAdminMenu);

        btnBackToAdminMenu.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
    }

    private void createViewActivitiesPanel() {
        JPanel viewActivitiesPanel = new JPanel();
        mainPanel.add(viewActivitiesPanel, "viewActivitiesPanel");
        viewActivitiesPanel.setLayout(null);

        JLabel lblViewActivities = new JLabel("Προβολή Δραστηριοτήτων");
        lblViewActivities.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblViewActivities.setBounds(200, 30, 200, 40);
        viewActivitiesPanel.add(lblViewActivities);

        // Ακολουθεί κώδικας για την προβολή δραστηριοτήτων

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(200, 300, 200, 40);
        viewActivitiesPanel.add(btnBackToStudentMenu);

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }

    private void createForumPanel() {
        JPanel forumPanel = new JPanel();
        mainPanel.add(forumPanel, "forumPanel");
        forumPanel.setLayout(null);

        JLabel lblForum = new JLabel("Forum Επικοινωνίας");
        lblForum.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblForum.setBounds(200, 30, 200, 40);
        forumPanel.add(lblForum);

        // Ακολουθεί κώδικας για το forum επικοινωνίας

        JButton btnBackToStudentMenu = new JButton("Επιστροφή στο Μενού Φοιτητή");
        btnBackToStudentMenu.setBounds(200, 300, 200, 40);
        forumPanel.add(btnBackToStudentMenu);

        btnBackToStudentMenu.addActionListener(e -> cardLayout.show(mainPanel, "studentMenu"));
    }

    private void createContentManagementPanel() {
        JPanel contentManagement = new JPanel();
        mainPanel.add(contentManagement, "contentManagement");
        contentManagement.setLayout(null);

        JLabel lblContentManagement = new JLabel("Διαχείριση Περιεχομένου");
        lblContentManagement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblContentManagement.setBounds(200, 30, 200, 40);
        contentManagement.add(lblContentManagement);

        // Ακολουθεί κώδικας για τη δημιουργία του πίνακα συνομιλιών και των κουμπιών έγκρισης/απόρριψης
        String[] columnNames = {"Συνομιλία", "Αποδοχή", "Απόρριψη"};
        Object[][] data = {
                {"Συνομιλία 1", "Αποδοχή", "Απόρριψη"},
                {"Συνομιλία 2", "Αποδοχή", "Απόρριψη"},
                // Προσθέστε και άλλες συνομιλίες εδώ
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 500, 150);
        contentManagement.add(scrollPane);

        JButton btnBackToAdminMenu = new JButton("Επιστροφή στο Μενού Διαχειριστή");
        btnBackToAdminMenu.setBounds(200, 300, 200, 40);
        contentManagement.add(btnBackToAdminMenu);

        btnBackToAdminMenu.addActionListener(e -> cardLayout.show(mainPanel, "adminMenu"));
    }
}
