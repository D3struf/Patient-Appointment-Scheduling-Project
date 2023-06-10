import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UICreate extends JFrame implements ActionListener {
    // public static void main(String[] args) {
    //     new UICreate();
    // }
    private Main main;

    JTextField username, name, contactNo;
    JPasswordField password;
    JButton createAccountButton;
    JComboBox<String> age;
    JComboBox<String> genderBox;
    JComboBox<String> bdayMonth, bdayDays, bdayYears;

    UICreate(Main main) {
        this.main = main;

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("images/bgImage.jpg"));

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
        signUpText.setBounds(750, 85, 1366, 45);

        // Text Fields for Username and Password
        username = new JTextField();
        username.setBounds(750, 170, 400, 36);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(Color.WHITE);
        username.setOpaque(true);

        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("Username");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        usernameLabel.setForeground(Color.GRAY);
        usernameLabel.setBounds(750, 150, 400, 20);

        password = new JPasswordField();
        password.setBounds(750, 235, 400, 36);
        password.setFont(new Font("Dialog", Font.PLAIN, 18));
        password.setForeground(Color.BLACK);
        password.setBackground(Color.WHITE);
        password.setOpaque(true);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordLabel.setForeground(Color.GRAY);
        passwordLabel.setBounds(750, 215, 400, 20);

        name = new JTextField();
        name.setBounds(750, 300, 400, 36);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        name.setOpaque(true);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        nameLabel.setForeground(Color.GRAY);
        nameLabel.setBounds(750, 280, 400, 20);

        String[] ages = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "42", "43", "44", "45", "46", "47", "48", "49", "50", "52", "53", "54", "55",
                "56", "57", "58", "59", "60", "62", "63", "64", "65", "66", "67", "68", "69", "70", "72", "73", "74",
                "75", "76", "77", "78", "79", "80", "82", "83", "84", "85", "86", "87", "88", "89", "90", "92", "93",
                "94", "95", "96", "97", "98", "99", "100" };
        age = new JComboBox<>(ages);
        age.setBounds(750, 365, 190, 36);
        age.setFont(new Font("Dialog", Font.PLAIN, 18));
        age.setForeground(Color.BLACK);
        age.setBackground(Color.WHITE);
        age.setOpaque(true);

        JLabel ageLabel = new JLabel();
        ageLabel.setText("Age");
        ageLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        ageLabel.setForeground(Color.GRAY);
        ageLabel.setBounds(750, 345, 180, 20);

        String[] gender = { "Male", "Female", "I Prefer not to say" };
        genderBox = new JComboBox<>(gender);
        genderBox.setBounds(960, 365, 190, 36);
        genderBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        genderBox.setForeground(Color.BLACK);
        genderBox.setBackground(Color.WHITE);
        genderBox.setOpaque(true);

        JLabel genderLabel = new JLabel();
        genderLabel.setText("Sex");
        genderLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        genderLabel.setForeground(Color.GRAY);
        genderLabel.setBounds(960, 345, 180, 20);

        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        String[] years = { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930",
                "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943",
                "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956",
                "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
                "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
                "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995",
                "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
                "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
                "2022", "2023"};

        bdayMonth = new JComboBox<>(month);
        bdayMonth.setBounds(750, 430, 150, 35);
        bdayMonth.setFont(new Font("Dialog", Font.PLAIN, 18));
        bdayMonth.setForeground(Color.BLACK);
        bdayMonth.setBackground(Color.WHITE);

        bdayDays = new JComboBox<>(days);
        bdayDays.setBounds(920, 430, 100, 35);
        bdayDays.setFont(new Font("Dialog", Font.PLAIN, 18));
        bdayDays.setForeground(Color.BLACK);
        bdayDays.setBackground(Color.WHITE);

        bdayYears = new JComboBox<>(years);
        bdayYears.setBounds(1040, 430, 110, 35);
        bdayYears.setFont(new Font("Dialog", Font.PLAIN, 18));
        bdayYears.setForeground(Color.BLACK);
        bdayYears.setBackground(Color.WHITE);
        bdayYears.setSelectedIndex(103);

        JLabel bdayLabel = new JLabel();
        bdayLabel.setText("Birthday");
        bdayLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        bdayLabel.setForeground(Color.GRAY);
        bdayLabel.setBounds(750, 410, 180, 20);

        contactNo = new JTextField();
        contactNo.setBounds(750, 495, 400, 36);
        contactNo.setFont(new Font("Dialog", Font.PLAIN, 18));
        contactNo.setForeground(Color.BLACK);
        contactNo.setBackground(Color.WHITE);
        contactNo.setOpaque(true);

        JLabel contactNoLabel = new JLabel();
        contactNoLabel.setText("Contact Number");
        contactNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        contactNoLabel.setForeground(Color.GRAY);
        contactNoLabel.setBounds(750, 475, 180, 20);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(750, 560, 400, 50);
        createAccountButton.setFont(new Font("Dialog", Font.BOLD, 18));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setBackground(new Color(0x40ab28));
        createAccountButton.setOpaque(true);
        createAccountButton.setFocusable(false);
        createAccountButton.addActionListener(this);

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
        bgImage.add(bdayMonth, JLayeredPane.MODAL_LAYER);
        bgImage.add(bdayDays, JLayeredPane.MODAL_LAYER);
        bgImage.add(bdayYears, JLayeredPane.MODAL_LAYER);
        bgImage.add(bdayLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(contactNo, JLayeredPane.MODAL_LAYER);
        bgImage.add(contactNoLabel, JLayeredPane.MODAL_LAYER);
        bgImage.add(createAccountButton, JLayeredPane.MODAL_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon success = new ImageIcon(getClass().getClassLoader().getResource("images/success.png"));
        ImageIcon wrong = new ImageIcon(getClass().getClassLoader().getResource("images/wrong.png"));
        if (e.getSource() == createAccountButton) {
            createAccountButton.setEnabled(false);
            String username2 = String.valueOf(username.getText());
            String password2 = String.valueOf(password.getPassword());
            String name2 = String.valueOf(name.getText());
            int age2 = Integer.parseInt(String.valueOf(age.getSelectedItem()));
            String gender2 = String.valueOf(genderBox.getSelectedItem());
            String bdayMonth2 = String.valueOf(bdayMonth.getSelectedItem());
            String bdayDays2 = String.valueOf(bdayDays.getSelectedItem());
            String bdayYears2 = String.valueOf(bdayYears.getSelectedItem());
            String contactNo2 = String.valueOf(contactNo.getText());

            String birthday = bdayMonth2 + " " + bdayDays2 + " " + bdayYears2;

            if (main.inputPatientInformation(username2, password2, name2, age2, gender2, birthday, contactNo2)) {
                JOptionPane.showMessageDialog(null, "Account Created Successfully!", "Patient Appointment Scheduling System",
                        JOptionPane.INFORMATION_MESSAGE, success);
                this.dispose();
                new UIHomePage();
            }
            else {
                JOptionPane.showMessageDialog(null, "Username is already taken! Please try again.",
                        "Patient Appointment Scheduling System", JOptionPane.ERROR_MESSAGE, wrong);
                createAccountButton.setEnabled(true);
            }
        }
    }
}
