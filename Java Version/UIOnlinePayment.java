import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIOnlinePayment extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new UIOnlinePayment();
    }

    UIOnlinePayment() {

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

        JButton button = new JButton();
        button.setText("Patient Information");
        button.setFont(new Font("Dialog", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setOpaque(true);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(60, 315, 250, 50);

        JButton button1 = new JButton();
        button1.setText("Schedule");
        button1.setFont(new Font("Dialog", Font.BOLD, 18));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLUE);
        button1.setOpaque(true);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBounds(60, 384, 250, 50);

        JButton button2 = new JButton();
        button2.setText("Payment");
        button2.setFont(new Font("Dialog", Font.BOLD, 18));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(0x698f9a));
        button2.setOpaque(true);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBounds(60, 452, 250, 50);

        JButton button3 = new JButton();
        button3.setText("Back");
        button3.setFont(new Font("Dialog", Font.BOLD, 18));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(0xD62839));
        button3.setOpaque(true);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBounds(60, 655, 250, 50);

        JButton edit = new JButton();
        edit.setText("Submit");
        edit.setFont(new Font("Dialog", Font.BOLD, 18));
        edit.setForeground(Color.BLACK);
        edit.setBackground(new Color(0xFFD600));
        edit.setOpaque(true);
        edit.setFocusable(false);
        edit.addActionListener(this);
        edit.setBounds(1045, 610, 250, 50);
        edit.setBorder(BorderFactory.createEmptyBorder());

         String[] banks = { "Banco de Oro (BDO)", "Bank of the Philippine Islands (BPI)", "Metrobank",  "Land Bank of the Philippines", "Development Bank of the Philippines (DBP)", "Philippine National Bank (PNB)", 
                            "Security Bank", "Union Bank of the Philippines", "EastWest Bank", "RCBC", "China Bank", "UCPB", "Citibank Philippines", "PSBank", "Robinsons Bank", "Maybank Philippines", "Standard Chartered Bank Philippines",
                            "HSBC Philippines", "Bank of Commerce", "Philippine Veterans Bank", "GCash", "PayMaya", "PayPal" };
        JComboBox<String> bank = new JComboBox<>(banks);
        bank.setBounds(665, 325, 400, 35);
        bank.setFont(new Font("Dialog", Font.PLAIN, 18));
        bank.setForeground(Color.BLACK);
        bank.setBackground(Color.WHITE);

        String[] types = { "Visa", "Mastercard", "Maestro", "American Express", "E-Wallet" };
        JComboBox<String> type = new JComboBox<>(types);
        type.setBounds(665, 405, 250, 35);
        type.setFont(new Font("Dialog", Font.PLAIN, 18));
        type.setForeground(Color.BLACK);
        type.setBackground(Color.WHITE);

        // Text Fields
        JTextField username = new JTextField();
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
        bgImageLayer.add(button, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button3, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(edit, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bank, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(type, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(accnum, JLayeredPane.PALETTE_LAYER);




    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

}
