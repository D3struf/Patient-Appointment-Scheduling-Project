import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIHomePage extends JFrame implements ActionListener {
    private Main main;

    JButton patientViewButton;
    JButton scheduleButton;
    JButton paymentButton;
    JButton logoutButton;

    // Frame
    UIHomePage(Main main) {
        this.main = main;
        String currentName = main.getCurrentUserName();
        String currentDate = main.getCurrentSchedule();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/bghomepage.png"));

        // Resize Image
        Image tempImage = bgImage.getImage();
        Image tempImage2 = tempImage.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(tempImage2);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(bgImage);
        bgImageLabel.setBounds(0, -20, 1366, 768);

        patientViewButton = new JButton();
        patientViewButton.setText("Patient Information");
        patientViewButton.setFont(new Font("Dialog", Font.BOLD, 18));
        patientViewButton.setForeground(Color.WHITE);
        patientViewButton.setBackground(Color.BLUE);
        patientViewButton.setOpaque(true);
        patientViewButton.setFocusable(false);
        patientViewButton.addActionListener(this);
        patientViewButton.setBounds(60, 315, 250, 50);

        scheduleButton = new JButton();
        scheduleButton.setText("Schedule");
        scheduleButton.setFont(new Font("Dialog", Font.BOLD, 18));
        scheduleButton.setForeground(Color.WHITE);
        scheduleButton.setBackground(Color.BLUE);
        scheduleButton.setOpaque(true);
        scheduleButton.setFocusable(false);
        scheduleButton.addActionListener(this);
        scheduleButton.setBounds(60, 384, 250, 50);

        paymentButton = new JButton();
        paymentButton.setText("Payment");
        paymentButton.setFont(new Font("Dialog", Font.BOLD, 18));
        paymentButton.setForeground(Color.WHITE);
        paymentButton.setBackground(Color.BLUE);
        paymentButton.setOpaque(true);
        paymentButton.setFocusable(false);
        paymentButton.addActionListener(this);
        paymentButton.setBounds(60, 452, 250, 50);

        logoutButton = new JButton();
        logoutButton.setText("Logout");
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 18));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(0xD62839));
        logoutButton.setOpaque(true);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);
        logoutButton.setBounds(60, 655, 250, 50);

        JTextField username = new JTextField();
        username.setHorizontalAlignment(SwingConstants.RIGHT);
        username.setText("Welcome, " + currentName);
        username.setBounds(1085, 23, 200, 35);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(0xe8eaec));
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setEditable(false);

        JTextField sched = new JTextField();
        username.setHorizontalAlignment(SwingConstants.CENTER);
        sched.setText(currentDate);
        sched.setBounds(445, 480, 380, 35);
        sched.setFont(new Font("Dialog", Font.BOLD, 18));
        sched.setForeground(Color.BLACK);
        sched.setBackground(new Color(0x698f9a));
        sched.setCaretColor(Color.WHITE);
        sched.setBorder(BorderFactory.createEmptyBorder());
        sched.setEditable(false);

        // JLayered for layers
        JLayeredPane bgImageLayer = new JLayeredPane();
        bgImageLayer.setBounds(0, 0, 1366, 768);
        bgImageLayer.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

        // Style the Frame
        this.setIconImage(icon.getImage());
        this.setTitle("Patient Appointment Scheduling System");
        this.getContentPane().setBackground(new Color(0xFFFFFF));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerFrameOnScreen(this);
        this.setLayout(null);
        this.setSize(1366, 768);
        this.setVisible(true);
        this.setResizable(false);

        // add Objects
        this.add(bgImageLayer);
        bgImageLayer.add(patientViewButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(scheduleButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(paymentButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(logoutButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sched, JLayeredPane.PALETTE_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == patientViewButton) {
            new UIPatientInformation(main);
            this.dispose();
        }
        if (e.getSource() == scheduleButton) {
            if (main.getCurrentSchedule().isEmpty()) {
                new UIAppSched();
                this.dispose();
            }
            else {
                new UIPatientInfo();
                this.dispose();
            }
        }
        if (e.getSource() == paymentButton) {
            if (main.getCurrentPayment() == 1) {
                ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("images/paid.png"));
                JOptionPane.showMessageDialog(null, "You have already paid for your appointment.", "Payment", JOptionPane.INFORMATION_MESSAGE, logo);
            }
            else {
                new UIPayment();
                this.dispose();
            }
        }
        if (e.getSource() == logoutButton) {
            new UILogin(main);
            this.dispose();
        }
    }

}
