import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Δημιουργία και εμφάνιση του κύριου παραθύρου
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("GetaRoom");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);

                // Προσθήκη του μενού δημιουργίας δραστηριότητας
                CreateActivityMenu createActivityMenu = new CreateActivityMenu();
                frame.add(createActivityMenu.getPanel());

                frame.setVisible(true);
            }
        });
    }
}
