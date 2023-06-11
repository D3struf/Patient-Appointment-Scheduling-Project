import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIAppSched extends JFrame implements ActionListener {

    // public static void main(String[] args) {
    //     new UIAppSched();
    // }

    private Main main;

    JButton patientViewButton;
    JButton scheduleButton;
    JButton paymentButton;
    JButton backButton;
    JButton createButton;

    UIAppSched(Main main) {
        this.main = main;
        String currentUserName = main.getCurrentUserName();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/appSched.png"));
        // Resize Image
        Image tempImage = bgImage.getImage();
        Image tempImage2 = tempImage.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(tempImage2);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(bgImage);
        bgImageLabel.setBounds(0, -20, 1366, 768);

        // JLayered for layers
        JLayeredPane bgImageLayer = new JLayeredPane();
        bgImageLayer.setBounds(0, 0, 1366, 768);
        bgImageLayer.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

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
        scheduleButton.setBackground(new Color(0x698f9a));
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

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Dialog", Font.BOLD, 18));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(0xD62839));
        backButton.setOpaque(true);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setBounds(60, 655, 250, 50);

        createButton = new JButton();
        createButton.setText("Create");
        createButton.setFont(new Font("Dialog", Font.BOLD, 18));
        createButton.setForeground(Color.BLACK);
        createButton.setBackground(new Color(0xFFD600));
        createButton.setOpaque(true);
        createButton.setFocusable(false);
        createButton.addActionListener(this);
        createButton.setBounds(1025, 591, 250, 50);
        createButton.setBorder(BorderFactory.createEmptyBorder());

        // Text Fields
        JTextField username = new JTextField();
        username.setHorizontalAlignment(SwingConstants.RIGHT);
        username.setText("Welcome, " + currentUserName);
        username.setBounds(1035, 23, 250, 35);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(0xe8eaec));
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setEditable(false);

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

        // add objects
        this.add(bgImageLayer);
        bgImageLayer.add(patientViewButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(scheduleButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(paymentButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(backButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(createButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            new UIAppointmentSched(main);
            this.dispose();
        }
        if (e.getSource() == patientViewButton) {
            new UIPatientInformation(main);
            this.dispose();
        }
        if (e.getSource() == paymentButton) {
            if (main.getCurrentPayment() == 1) {
                ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("images/paid.png"));
                JOptionPane.showMessageDialog(null, "You have already paid for your appointment.", "Payment", JOptionPane.INFORMATION_MESSAGE, logo);
            }
            else {
                new UIPayment(main);
                this.dispose();
            }
        }
        if(e.getSource() == backButton) {
            new UIHomePage(main);
            this.dispose();
        }
    }

}