import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UILogin extends JFrame implements ActionListener {
    // public static void main(String[] args) {
    // new UILogin();
    // }

    private Main main;

    // Frame
    JFrame loginFrame;
    JButton loginButton;
    JButton createAccountButton;
    JTextField username;
    JPasswordField password;

    UILogin(Main main) {
        this.main = main;
        loginFrame = new JFrame();

        // Logo
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
        JPanel loginBox = new JPanel();
        loginBox.setBounds(700, 50, 500, 600);
        loginBox.setBackground(Color.WHITE);
        loginBox.setOpaque(true);

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
        logotext.setText("Sign in or create an account");
        logotext.setFont(new Font("Dialog", Font.PLAIN, 18));
        logotext.setForeground(Color.BLACK);
        logotext.setBounds(250, 385, 300, 25);

        JLabel signInText = new JLabel();
        signInText.setText("Sign in");
        signInText.setFont(new Font("Dialog", Font.BOLD, 36));
        signInText.setForeground(Color.BLACK);
        signInText.setBounds(750, 100, 1366, 45);

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
        password.setBounds(750, 280, 400, 36);
        password.setFont(new Font("Dialog", Font.PLAIN, 18));
        password.setForeground(Color.BLACK);
        password.setBackground(Color.WHITE);
        password.setOpaque(true);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordLabel.setForeground(Color.GRAY);
        passwordLabel.setBounds(750, 260, 400, 20);

        // Buttons for Login and Create Account
        loginButton = new JButton("Login");
        loginButton.setBounds(750, 340, 400, 50);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLUE);
        loginButton.setOpaque(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        JPanel seperator1 = new JPanel();
        seperator1.setBackground(new Color(0xDEE5E5));
        seperator1.setOpaque(true);
        seperator1.setBounds(750, 425, 190, 2);

        JLabel or = new JLabel();
        or.setText("or");
        or.setFont(new Font("Dialog", Font.BOLD, 14));
        or.setForeground(new Color(0xDEE5E5));
        or.setBounds(945, 413, 50, 20);

        JPanel seperator2 = new JPanel();
        seperator2.setBackground(new Color(0xDEE5E5));
        seperator2.setOpaque(true);
        seperator2.setBounds(965, 425, 185, 2);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(750, 465, 400, 50);
        createAccountButton.setFont(new Font("Dialog", Font.BOLD, 18));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setBackground(new Color(0x40ab28));
        createAccountButton.setOpaque(true);
        createAccountButton.addActionListener(this);

        JLabel createAccountLabel = new JLabel();
        createAccountLabel.setText("Don't have saved information? Create an account.");
        createAccountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        createAccountLabel.setForeground(Color.BLACK);
        createAccountLabel.setBounds(790, 520, 400, 20);
        createAccountLabel.setFocusable(false);

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
        bgImage.add(loginBox, JLayeredPane.PALETTE_LAYER);
        bgImage.add(title, JLayeredPane.PALETTE_LAYER);
        bgImage.add(title2, JLayeredPane.PALETTE_LAYER);
        bgImage.add(logo, JLayeredPane.PALETTE_LAYER);
        bgImage.add(logotext, JLayeredPane.PALETTE_LAYER);
        bgImage.add(signInText, JLayeredPane.MODAL_LAYER);
        bgImage.add(username, JLayeredPane.MODAL_LAYER);
        bgImage.add(usernameLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(password, JLayeredPane.MODAL_LAYER);
        bgImage.add(passwordLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(loginButton, JLayeredPane.MODAL_LAYER);
        bgImage.add(seperator1, JLayeredPane.MODAL_LAYER);
        bgImage.add(or, JLayeredPane.MODAL_LAYER);
        bgImage.add(seperator2, JLayeredPane.MODAL_LAYER);
        bgImage.add(createAccountButton, JLayeredPane.MODAL_LAYER);
        bgImage.add(createAccountLabel, JLayeredPane.MODAL_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon success = new ImageIcon("images/success.png");
        ImageIcon wrong = new ImageIcon("images/wrong.png");
        if (e.getSource() == loginButton) {
            loginButton.setEnabled(false);
            String username2 = String.valueOf(username.getText());
            String password2 = String.valueOf(password.getPassword());

            boolean validation = main.login_Account(username2, password2);
            System.out.println(validation);
            if (validation) {
                JOptionPane.showMessageDialog(null, "Login Successful!", "Patient Appointment Scheduling System",
                        JOptionPane.INFORMATION_MESSAGE, success);
                this.dispose();
                // call next UI
            }
            else {
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect!",
                        "Patient Appointment Scheduling System", JOptionPane.ERROR_MESSAGE, wrong);
                loginButton.setEnabled(true);
            }
        }
        if (e.getSource() == createAccountButton) {
            createAccountButton.setEnabled(false);
            this.dispose();
            new UICreate();
        }
    }
}
