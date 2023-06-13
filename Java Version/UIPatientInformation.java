import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UIPatientInformation extends JFrame implements ActionListener {
    private Main main;

    JButton patientViewButton;
    JButton scheduleButton;
    JButton paymentButton;
    JButton backButton;
    JButton togglePassword;
    JTextField user;
    JPasswordField pass;
    JTextField name;
    JComboBox<String> age;
    JTextField num;
    JComboBox<String> bday;
    JComboBox<String> bday1;
    JComboBox<String> bday2;
    JComboBox<String> sex;
    Boolean showPassword = false;
    JButton editButton;
    JButton saveButton;
    JLayeredPane bgImageLayer;
    JPanel coverBox;

    ImageIcon hide = new ImageIcon(getClass().getClassLoader().getResource("images/hide.png"));
    ImageIcon show = new ImageIcon(getClass().getClassLoader().getResource("images/show.png"));

    UIPatientInformation(Main main) {
        this.main = main;
        String currentUserName = main.getCurrentUserName();
        String currentPassword = main.getCurrentPassword();
        String currentName = main.getCurrentName();
        String currentContactNo = main.getCurrentContactNumber();
        String currentSex = main.getCurrentSex();
        int currentAge = main.getCurrentAge();
        String currentBday = main.getCurrentBirthday();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/patientView.png"));
        // Resize Image
        Image tempImage = bgImage.getImage();
        Image tempImage2 = tempImage.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(tempImage2);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(bgImage);
        bgImageLabel.setBounds(0, -20, 1366, 768);

        // JLayered for layers
        bgImageLayer = new JLayeredPane();
        bgImageLayer.setBounds(0, 0, 1366, 768);
        bgImageLayer.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

        patientViewButton = new JButton();
        patientViewButton.setText("Patient Information");
        patientViewButton.setFont(new Font("Dialog", Font.BOLD, 18));
        patientViewButton.setForeground(Color.WHITE);
        patientViewButton.setBackground(new Color(0x698f9a));
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

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Dialog", Font.BOLD, 18));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(0xD62839));
        backButton.setOpaque(true);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setBounds(60, 655, 250, 50);

        // Text Fields
        JTextField username = new JTextField();
        username.setHorizontalAlignment(SwingConstants.RIGHT);
        username.setText("Welcome, " + currentUserName);
        username.setBounds(1085, 23, 200, 35);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(0xe8eaec));
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setEditable(false);

        editButton = new JButton();
        editButton.setText("Edit");
        editButton.setFont(new Font("Dialog", Font.BOLD, 18));
        editButton.setForeground(Color.BLACK);
        editButton.setBackground(new Color(0xFFD600));
        editButton.setOpaque(true);
        editButton.setFocusable(false);
        editButton.addActionListener(this);
        editButton.setBounds(1060, 607, 250, 50);
        editButton.setBorder(BorderFactory.createEmptyBorder());

        user = new JTextField();
        user.setText(currentUserName);
        user.setBounds(580, 223, 250, 35);
        user.setFont(new Font("Dialog", Font.PLAIN, 18));
        user.setForeground(Color.BLACK);
        user.setBackground(Color.WHITE);
        user.setEditable(false);

        pass = new JPasswordField();
        pass.setText(currentPassword);
        pass.setBounds(580, 313, 250, 35);
        pass.setFont(new Font("Dialog", Font.PLAIN, 18));
        pass.setForeground(Color.BLACK);
        pass.setBackground(Color.WHITE);
        pass.setEditable(false);

        //Resize Image
        Image tempImage3 = hide.getImage();
        Image tempImage4 = tempImage3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        hide = new ImageIcon(tempImage4);

        Image tempImage5 = show.getImage();
        Image tempImage6 = tempImage5.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        show = new ImageIcon(tempImage6);
        
        togglePassword = new JButton();
        togglePassword.setIcon(show);
        togglePassword.setFocusable(false);
        togglePassword.setBorder(BorderFactory.createEmptyBorder());
        togglePassword.setBounds(795, 315, 30, 30);
        togglePassword.setBackground(Color.WHITE);
        togglePassword.addActionListener(this);

        name = new JTextField();
        name.setText(currentName);
        name.setBounds(985, 223, 250, 35);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        name.setEditable(false);

        String[] ages = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73",
                "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92",
                "93", "94", "95", "96", "97", "98", "99", "100" };
        age = new JComboBox<>(ages);
        age.setBounds(985, 313, 250, 35);
        age.setFont(new Font("Dialog", Font.PLAIN, 18));
        age.setForeground(Color.BLACK);
        age.setBackground(Color.WHITE);
        age.setSelectedIndex(currentAge - 1);
        age.setEnabled(false);

        num = new JTextField();
        num.setText(currentContactNo);
        num.setBounds(580, 410, 250, 35);
        num.setFont(new Font("Dialog", Font.PLAIN, 18));
        num.setForeground(Color.BLACK);
        num.setBackground(Color.WHITE);
        num.setEditable(false);

        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        String[] years = { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930",
                "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943",
                "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956",
                "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
                "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
                "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995",
                "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
                "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021",
                "2022", "2023"};
        
        String[] currentBday2 = currentBday.split(" ");
        int mark1 = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i].equals(currentBday2[0])) {
                mark1 = i;
                break;
            }
        }
        bday = new JComboBox<>(month);
        bday.setBounds(580, 497, 150, 35);
        bday.setFont(new Font("Dialog", Font.PLAIN, 18));
        bday.setForeground(Color.BLACK);
        bday.setBackground(Color.WHITE);
        bday.setSelectedIndex(mark1);
        bday.setEnabled(false);

        int mark2 = 0;
        if (currentBday2.length >= 2) {
            for (int i = 0; i < days.length; i++) {
                if (days[i].equals(currentBday2[1])) {
                    mark2 = i;
                    break;
                }
            }
        }
        bday1 = new JComboBox<>(days);
        bday1.setBounds(740, 497, 150, 35);
        bday1.setFont(new Font("Dialog", Font.PLAIN, 18));
        bday1.setForeground(Color.BLACK);
        bday1.setBackground(Color.WHITE);
        bday1.setSelectedIndex(mark2);
        bday1.setEnabled(false);

        int mark3 = 0;
        if (currentBday2.length >= 2) {
            for (int i = 0; i < years.length; i++) {
                if (years[i].equals(currentBday2[2])) {
                    mark3 = i;
                    break;
                }
            }
        }
        bday2 = new JComboBox<>(years);
        bday2.setBounds(900, 497, 150, 35);
        bday2.setFont(new Font("Dialog", Font.PLAIN, 18));
        bday2.setForeground(Color.BLACK);
        bday2.setBackground(Color.WHITE);
        bday2.setSelectedIndex(103);
        bday2.setSelectedIndex(mark3);
        bday2.setEnabled(false);

        String[] sexlist = {"Male", "Female", "I prefer not to say" };
        int set = 2;
        for (int i = 0; i < sexlist.length; i++) {
            if (sexlist[i].equals(currentSex)) {
                set = i;
                break;
            }
        }
        sex = new JComboBox<>(sexlist);
        sex.setBounds(985, 410, 250, 35);
        sex.setFont(new Font("Dialog", Font.PLAIN, 18));
        sex.setForeground(Color.BLACK);
        sex.setBackground(Color.WHITE);
        sex.setSelectedIndex(set);
        sex.setEnabled(false);

        coverBox = new JPanel();
        coverBox.setBounds(1060, 607, 300, 50);
        coverBox.setBackground(Color.WHITE);
        coverBox.setOpaque(true);

        saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setFont(new Font("Dialog", Font.BOLD, 18));
        saveButton.setForeground(Color.BLACK);
        saveButton.setBackground(new Color(0xFFD600));
        saveButton.setOpaque(true);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        saveButton.setBounds(1060, 607, 250, 50);
        saveButton.setBorder(BorderFactory.createEmptyBorder());

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
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(editButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(user, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(pass, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(name, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(age, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(num, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bday, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sex, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bday1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bday2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(togglePassword, JLayeredPane.MODAL_LAYER);

        Encryption encrypt = new Encryption();
        encrypt.retrieveKey();
        this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                // Save the file here
                main.save();
                encrypt.saveKey();
                super.windowClosing(e);
            }
        });
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 16;
        int centerY = (screenSize.height - frame.getHeight()) / 16;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Resize Image
        Image tempImage3 = hide.getImage();
        Image tempImage4 = tempImage3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        hide = new ImageIcon(tempImage4);

        Image tempImage5 = show.getImage();
        Image tempImage6 = tempImage5.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        show = new ImageIcon(tempImage6);

        if (e.getSource() == togglePassword) {
            if(showPassword) {
                togglePassword.setIcon(show);
                pass.setEchoChar('*');
            } else {
                togglePassword.setIcon(hide);
                pass.setEchoChar((char) 0);
            }
        }
        showPassword = !showPassword;

        if (e.getSource() == editButton) {
            user.setEditable(true);
            pass.setEditable(true);
            name.setEditable(true);
            age.setEnabled(true);
            num.setEditable(true);
            bday.setEnabled(true);
            bday1.setEnabled(true);
            bday2.setEnabled(true);
            sex.setEnabled(true);
            bgImageLayer.add(coverBox, JLayeredPane.MODAL_LAYER);
            bgImageLayer.add(saveButton, JLayeredPane.POPUP_LAYER);
        }

        if (e.getSource() == saveButton) {
            ImageIcon success = new ImageIcon(getClass().getClassLoader().getResource("images/success.png"));
            String username2 = String.valueOf(user.getText());
            String password2 = String.valueOf(pass.getPassword());
            String name2 = String.valueOf(name.getText());
            int age2 = Integer.parseInt(String.valueOf(age.getSelectedItem()));
            String gender2 = String.valueOf(sex.getSelectedItem());
            String bdayMonth2 = String.valueOf(bday.getSelectedItem());
            String bdayDays2 = String.valueOf(bday1.getSelectedItem());
            String bdayYears2 = String.valueOf(bday2.getSelectedItem());
            String contactNo2 = String.valueOf(num.getText());
            String birthday = bdayMonth2 + " " + bdayDays2 + " " + bdayYears2;
            main.updatePatientInformation(username2, password2, name2, age2, gender2, birthday, contactNo2);
            JOptionPane.showMessageDialog(null, "Account Edited Successfully!", "Patient Appointment Scheduling System",
                        JOptionPane.INFORMATION_MESSAGE, success);
            new UIHomePage(main);
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
        if (e.getSource() == paymentButton) {
            if (main.getCurrentAppointmentDate().isEmpty()) {
                ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("images/error.png"));
                JOptionPane.showMessageDialog(null, "You have not scheduled an appointment yet.", "Payment", JOptionPane.INFORMATION_MESSAGE, logo);
            } else if (main.getCurrentPayment() == 1) {
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
