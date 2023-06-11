import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIOnlinePayment extends JFrame implements ActionListener {

    private Main main;

    JButton patientViewButton;
    JButton scheduleButton;
    JButton paymentButton;
    JButton backButton;
    JButton submitButton;
    JComboBox<String> bank;
    JComboBox<String> type;

    UIOnlinePayment(Main main) {
        this.main = main;
        String currentUserName = main.getCurrentUserName();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/transaction.png"));
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
        scheduleButton.setBackground(Color.BLUE);
        scheduleButton.setOpaque(true);
        scheduleButton.setFocusable(false);
        scheduleButton.addActionListener(this);
        scheduleButton.setBounds(60, 384, 250, 50);

        paymentButton = new JButton();
        paymentButton.setFont(new Font("Dialog", Font.BOLD, 18));
        paymentButton.setText("Payment");
        paymentButton.setForeground(Color.WHITE);
        paymentButton.setBackground(new Color(0x698f9a));
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

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(new Color(0xFFD600));
        submitButton.setOpaque(true);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(1045, 610, 250, 50);
        submitButton.setBorder(BorderFactory.createEmptyBorder());

        String[] banks = { "Banco de Oro (BDO)", "Bank of the Philippine Islands (BPI)", "Metrobank",  "Land Bank of the Philippines", "Development Bank of the Philippines (DBP)", "Philippine National Bank (PNB)", 
                            "Security Bank", "Union Bank of the Philippines", "EastWest Bank", "RCBC", "China Bank", "UCPB", "Citibank Philippines", "PSBank", "Robinsons Bank", "Maybank Philippines", "Standard Chartered Bank Philippines",
                            "HSBC Philippines", "Bank of Commerce", "Philippine Veterans Bank", "GCash", "PayMaya", "PayPal" };
        bank = new JComboBox<>(banks);
        bank.setBounds(665, 325, 400, 35);
        bank.setFont(new Font("Dialog", Font.PLAIN, 18));
        bank.setForeground(Color.BLACK);
        bank.setBackground(Color.WHITE);

        String[] types = { "Visa", "Mastercard", "Maestro", "American Express", "E-Wallet" };
        type = new JComboBox<>(types);
        type.setBounds(665, 405, 250, 35);
        type.setFont(new Font("Dialog", Font.PLAIN, 18));
        type.setForeground(Color.BLACK);
        type.setBackground(Color.WHITE);

        // Text Fields
        JTextField username = new JTextField();
        username.setHorizontalAlignment(SwingConstants.RIGHT);
        username.setText("Welcome, " + currentUserName);
        username.setBounds(1035, 23, 250, 35);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(0xe8eaec));
        username.setBorder(BorderFactory.createEmptyBorder());

        JTextField accnum = new JTextField();
        accnum.setBounds(665, 488, 250, 35);
        accnum.setFont(new Font("Dialog", Font.PLAIN, 18));
        accnum.setForeground(Color.BLACK);
        accnum.setBackground(Color.WHITE);

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
        bgImageLayer.add(submitButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bank, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(type, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(accnum, JLayeredPane.PALETTE_LAYER);

        ImageIcon fee = new ImageIcon(getClass().getClassLoader().getResource("images/online.png"));
        JOptionPane.showMessageDialog(null, "RESERVATION FEE: Php " + Variables.RESERVATION_FEE + ".00", "Payment", JOptionPane.INFORMATION_MESSAGE, fee);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String code = main.confirmationCode();
            ImageIcon cash = new ImageIcon(getClass().getClassLoader().getResource("images/online.png"));
            JOptionPane.showMessageDialog(null, "Payment Successful!\n\nYour Confirmation Code: " + code + "\nPlease take note of your Confirmation Code, Thank You!!\n", "Payment", JOptionPane.INFORMATION_MESSAGE, cash);
            main.paymentMethod();
        }
        if (e.getSource() == patientViewButton) {
            new UIPatientInformation(main);
            this.dispose();
        }
        if (e.getSource() == scheduleButton) {
            if (main.getCurrentSchedule().isEmpty()) {
                new UIAppSched(main);
                this.dispose();
            }
            else {
                new UIPatientInfo(main);
                this.dispose();
            }
        }
        if(e.getSource() == backButton) {
            new UIHomePage(main);
            this.dispose();
        }
    }

}
