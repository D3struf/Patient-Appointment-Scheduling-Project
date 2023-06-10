import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPatientInformation extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new UIPatientInformation();
    }

    UIPatientInformation() {

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
        JLayeredPane bgImageLayer = new JLayeredPane();
        bgImageLayer.setBounds(0, 0, 1366, 768);
        bgImageLayer.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

        JButton button = new JButton();
        button.setText("Patient Information");
        button.setFont(new Font("Dialog", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0x698f9a));
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
        button2.setBackground(Color.BLUE);
        button2.setOpaque(true);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBounds(60, 452, 250, 50);

        JButton button3 = new JButton();
        button3.setText("Logout");
        button3.setFont(new Font("Dialog", Font.BOLD, 18));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(0xD62839));
        button3.setOpaque(true);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBounds(60, 655, 250, 50);

        // Text Fields
        JTextField username = new JTextField();
        username.setBounds(1035, 23, 250, 35);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(0xe8eaec));
        username.setBorder(BorderFactory.createEmptyBorder());

        JButton edit = new JButton();
        edit.setText("Edit");
        edit.setFont(new Font("Dialog", Font.BOLD, 18));
        edit.setForeground(Color.BLACK);
        edit.setBackground(new Color(0xFFD600));
        edit.setOpaque(true);
        edit.setFocusable(false);
        edit.addActionListener(this);
        edit.setBounds(1060, 607, 250, 50);
        edit.setBorder(BorderFactory.createEmptyBorder());

        JTextField user = new JTextField();
        user.setBounds(580, 223, 250, 35);
        user.setFont(new Font("Dialog", Font.PLAIN, 18));
        user.setForeground(Color.BLACK);
        user.setBackground(Color.WHITE);

        JTextField pass = new JTextField();
        pass.setBounds(580, 313, 250, 35);
        pass.setFont(new Font("Dialog", Font.PLAIN, 18));
        pass.setForeground(Color.BLACK);
        pass.setBackground(Color.WHITE);

        JTextField name = new JTextField();
        name.setBounds(985, 223, 250, 35);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);

        String[] ages = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "42", "43", "44", "45", "46", "47", "48", "49", "50", "52", "53", "54",
                "55", "56", "57", "58", "59", "60", "62", "63", "64", "65", "66", "67", "68", "69", "70", "72", "73",
                "74", "75", "76", "77", "78", "79", "80", "82", "83", "84", "85", "86", "87", "88", "89", "90", "92",
                "93", "94", "95", "96", "97", "98", "99", "100" };
        JComboBox<String> age = new JComboBox<>(ages);
        age.setBounds(985, 313, 250, 35);
        age.setFont(new Font("Dialog", Font.PLAIN, 18));
        age.setForeground(Color.BLACK);
        age.setBackground(Color.WHITE);

        JTextField num = new JTextField();
        num.setBounds(580, 410, 250, 35);
        num.setFont(new Font("Dialog", Font.PLAIN, 18));
        num.setForeground(Color.BLACK);
        num.setBackground(Color.WHITE);

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
                "2022", "2023", "less than 1 year old" };

        JComboBox<String> bday = new JComboBox<>(month);
        bday.setBounds(580, 497, 150, 35);
        bday.setFont(new Font("Dialog", Font.PLAIN, 18));
        bday.setForeground(Color.BLACK);
        bday.setBackground(Color.WHITE);

        JComboBox<String> bday1 = new JComboBox<>(days);
        bday1.setBounds(740, 497, 150, 35);
        bday1.setFont(new Font("Dialog", Font.PLAIN, 18));
        bday1.setForeground(Color.BLACK);
        bday1.setBackground(Color.WHITE);

        JComboBox<String> bday2 = new JComboBox<>(years);
        bday2.setBounds(900, 497, 150, 35);
        bday2.setFont(new Font("Dialog", Font.PLAIN, 18));
        bday2.setForeground(Color.BLACK);
        bday2.setBackground(Color.WHITE);
        bday2.setSelectedIndex(103);

        String[] sexlist = { "Male", "Female", "I prefer not to say" };
        JComboBox<String> sex = new JComboBox<>(sexlist);
        sex.setBounds(985, 410, 250, 35);
        sex.setFont(new Font("Dialog", Font.PLAIN, 18));
        sex.setForeground(Color.BLACK);
        sex.setBackground(Color.WHITE);

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
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(edit, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(user, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(pass, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(name, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(age, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(num, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bday, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sex, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bday1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(bday2, JLayeredPane.PALETTE_LAYER);
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
