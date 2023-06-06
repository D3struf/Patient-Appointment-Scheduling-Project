import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UICreate extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new UICreate();
    }

    JTextField username, name;
    JPasswordField password;

    UICreate() {

        ImageIcon icon = new ImageIcon("images/logo.png");

        ImageIcon icon2 = new ImageIcon("images/bgImage.jpg");

        // Resize Image
        Image tempImage = icon2.getImage();
        Image tempImage2 = tempImage.getScaledInstance(1366, 745, Image.SCALE_SMOOTH);
        ImageIcon scaledicon2 = new ImageIcon(tempImage2);

        Image tempImage3 = icon.getImage();
        Image tempImage4 = tempImage3.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledicon = new ImageIcon(tempImage4);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(scaledicon2);
        bgImageLabel.setBounds(0, -25, 1366, 768);

        // Panels for prompting
        JPanel createBox = new JPanel();
        createBox.setBounds(700, 50, 500, 600);
        createBox.setBackground(Color.WHITE);
        createBox.setOpaque(true);

        // Labels for Text
        JLabel title = new JLabel();
        title.setText("Patient Appointment");
        title.setBounds(250, 300, 1366, 40);
        title.setFont(new Font("Dialog", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.LEFT);

        JLabel title2 = new JLabel();
        title2.setText("Scheduling System");
        title2.setBounds(250, 340, 1366, 35);
        title2.setFont(new Font("Dialog", Font.BOLD, 24));
        title2.setForeground(Color.BLACK);
        title2.setHorizontalAlignment(JLabel.LEFT);

        JLabel logo = new JLabel();
        logo.setIcon(scaledicon);
        logo.setBounds(180, 300, 70, 70);

        JLabel logotext = new JLabel();
        logotext.setText("Create an account");
        logotext.setFont(new Font("Dialog", Font.PLAIN, 18));
        logotext.setForeground(Color.BLACK);
        logotext.setBounds(250, 385, 300, 25);

        JLabel signUpText = new JLabel();
        signUpText.setText("Sign up");
        signUpText.setFont(new Font("Dialog", Font.BOLD, 36));
        signUpText.setForeground(Color.BLACK);
        signUpText.setBounds(750, 100, 1366, 45);

        // Text Fields for Username and Password
        username = new JTextField();
        username.setBounds(750, 200, 400, 36);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(Color.WHITE);
        username.setOpaque(true);

        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("Username");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        usernameLabel.setForeground(Color.GRAY);
        usernameLabel.setBounds(750, 180, 400, 20);

        password = new JPasswordField();
        password.setBounds(750, 260, 400, 36);
        password.setFont(new Font("Dialog", Font.PLAIN, 18));
        password.setForeground(Color.BLACK);
        password.setBackground(Color.WHITE);
        password.setOpaque(true);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordLabel.setForeground(Color.GRAY);
        passwordLabel.setBounds(750, 240, 400, 20);

        name = new JPasswordField();
        name.setBounds(750, 320, 400, 36);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        name.setOpaque(true);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        nameLabel.setForeground(Color.GRAY);
        nameLabel.setBounds(750, 300, 400, 20);

        String[] ages = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "42", "43", "44", "45", "46", "47", "48", "49", "50", "52", "53", "54", "55",
                "56", "57", "58", "59", "60", "62", "63", "64", "65", "66", "67", "68", "69", "70", "72", "73", "74",
                "75", "76", "77", "78", "79", "80", "82", "83", "84", "85", "86", "87", "88", "89", "90", "92", "93",
                "94", "95", "96", "97", "98", "99", "100" };
        JComboBox<String> age = new JComboBox<>(ages);
        age.setBounds(750, 380, 400, 36);
        age.setFont(new Font("Dialog", Font.PLAIN, 18));
        age.setForeground(Color.BLACK);
        age.setBackground(Color.WHITE);
        age.setOpaque(true);

        JLabel ageLabel = new JLabel();
        ageLabel.setText("Age");
        ageLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        ageLabel.setForeground(Color.GRAY);
        ageLabel.setBounds(750, 360, 400, 20);

        String[] gender = { "Male", "Female", "I Prefer not to say" };
        JComboBox<String> genderBox = new JComboBox<>(gender);
        genderBox.setBounds(750, 440, 400, 36);
        genderBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        genderBox.setForeground(Color.BLACK);
        genderBox.setBackground(Color.WHITE);
        genderBox.setOpaque(true);

        JLabel genderLabel = new JLabel();
        genderLabel.setText("Sex");
        genderLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        genderLabel.setForeground(Color.GRAY);
        genderLabel.setBounds(750, 420, 400, 20);

        // JLayeredPane
        JLayeredPane bgImage = new JLayeredPane();
        bgImage.setBounds(0, 0, 1366, 768);
        bgImage.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

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
        this.add(bgImage);
        bgImage.add(createBox, JLayeredPane.PALETTE_LAYER);
        bgImage.add(title, JLayeredPane.PALETTE_LAYER);
        bgImage.add(title2, JLayeredPane.PALETTE_LAYER);
        bgImage.add(logo, JLayeredPane.PALETTE_LAYER);
        bgImage.add(logotext, JLayeredPane.PALETTE_LAYER);
        bgImage.add(signUpText, JLayeredPane.MODAL_LAYER);
        bgImage.add(username, JLayeredPane.MODAL_LAYER);
        bgImage.add(usernameLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(password, JLayeredPane.MODAL_LAYER);
        bgImage.add(passwordLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(name, JLayeredPane.MODAL_LAYER);
        bgImage.add(nameLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(age, JLayeredPane.MODAL_LAYER);
        bgImage.add(ageLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(genderBox, JLayeredPane.MODAL_LAYER);
        bgImage.add(genderLabel, JLayeredPane.MODAL_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
