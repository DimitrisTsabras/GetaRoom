import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateActivityMenu {
    private JPanel mainPanel;

    public CreateActivityMenu() {
        mainPanel = new JPanel(new BorderLayout());

        // Δημιουργία του πάνω μέρους με τον τίτλο και το λογότυπο
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(59, 89, 152));

        JLabel titleLabel = new JLabel("GetaRoom", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("/mnt/data/image.png"));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Δημιουργία του κάτω μέρους με τα κουτιά δραστηριοτήτων
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Προσθήκη δραστηριοτήτων
        String[] titles = {"Τίτλος 1", "Τίτλος 2", "Τίτλος 3", "Τίτλος 4"};
        String[] descriptions = {
                "Αρχή της περιγραφής της δραστηριότητας 1...",
                "Αρχή της περιγραφής της δραστηριότητας 2...",
                "Αρχή της περιγραφής της δραστηριότητας 3...",
                "Αρχή της περιγραφής της δραστηριότητας 4..."
        };
        String[] imagePaths = {
                "path/to/image1.png",
                "path/to/image2.png",
                "path/to/image3.png",
                "path/to/image4.png"
        };

        for (int i = 0; i < 4; i++) {
            JPanel activityPanel = new JPanel(new BorderLayout());
            activityPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            activityPanel.setBackground(Color.LIGHT_GRAY);

            JLabel activityTitle = new JLabel(titles[i], SwingConstants.CENTER);
            activityTitle.setFont(new Font("Arial", Font.BOLD, 18));
            activityPanel.add(activityTitle, BorderLayout.NORTH);

            JLabel activityImage = new JLabel(new ImageIcon(imagePaths[i]));
            activityImage.setHorizontalAlignment(SwingConstants.CENTER);
            activityImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            final int activityIndex = i; // Ανάγκη για χρήση στο listener
            activityImage.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Ανακατεύθυνση σε νέα σελίδα για την συγκεκριμένη δραστηριότητα
                    JFrame activityFrame = new JFrame(titles[activityIndex]);
                    activityFrame.setSize(400, 300);
                    activityFrame.setLocationRelativeTo(null);

                    JPanel activityDetailPanel = new JPanel(new BorderLayout());
                    activityDetailPanel.add(new JLabel(titles[activityIndex], SwingConstants.CENTER), BorderLayout.NORTH);
                    activityDetailPanel.add(new JLabel(descriptions[activityIndex], SwingConstants.CENTER), BorderLayout.CENTER);

                    activityFrame.add(activityDetailPanel);
                    activityFrame.setVisible(true);
                }
            });
            activityPanel.add(activityImage, BorderLayout.CENTER);

            JLabel activityDescription = new JLabel(descriptions[i], SwingConstants.CENTER);
            activityPanel.add(activityDescription, BorderLayout.SOUTH);

            centerPanel.add(activityPanel);
        }

        // Δημιουργία του κάτω μέρους με το footer
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel footerLabel = new JLabel("Go GetaRoom, CEID", SwingConstants.CENTER);
        bottomPanel.add(footerLabel, BorderLayout.WEST);

        JButton backButton = new JButton("Πίσω");
        bottomPanel.add(backButton, BorderLayout.EAST);

        // Προσθήκη των panels στο κύριο panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
