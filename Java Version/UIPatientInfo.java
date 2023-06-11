import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPatientInfo extends JFrame implements ActionListener {

    // public static void main(String[] args) {
    //     new UIPatientInfo();
    // }
    private Main main;

    JButton patientViewButton;
    JButton scheduleButton;
    JButton paymentButton;
    JButton backButton;

    UIPatientInfo(Main main) {
        this.main = main;
        String currentUserName = main.getCurrentUserName();
        String currentName = main.getCurrentName();
        String currentCode = main.getCurrentAppointmentCode();
        String currentDate = main.getCurrentAppointmentDate();
        String currentDoctor = main.getCurrentAppointmentDoctor();
        String currentDepartment = main.getCurrentAppointmentDoctorDepartment();
        String currentSchedule = main.getCurrentAppointmentDoctorSchedule();
        String currentNumber = main.getCurrentAppointmentDoctorContactNumber();
        String currentEmail = main.getCurrentAppointmentDoctorEmail();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/appointmentSched.png"));
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

         // Text Fields
        JTextField username = new JTextField();
        username.setHorizontalAlignment(SwingConstants.RIGHT);
        username.setText("Welcome, " + currentUserName);
        username.setEditable(false);
        username.setBounds(1035, 23, 250, 35);
        username.setFont(new Font("Dialog", Font.PLAIN, 18));
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(0xe8eaec));
        username.setBorder(BorderFactory.createEmptyBorder());

        JTextField user = new JTextField();
        user.setText(currentUserName);
        user.setEditable(false);
        user.setBounds(562, 224, 250, 35);
        user.setFont(new Font("Dialog", Font.PLAIN, 18));
        user.setForeground(Color.BLACK);
        user.setBackground(Color.WHITE);

        JTextField name = new JTextField();
        name.setText(currentName);
        name.setEditable(false);
        name.setBounds(562, 290, 250, 35);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);

        JTextField code = new JTextField();
        code.setText(currentCode);
        code.setEditable(false);
        code.setBounds(1103, 223, 215, 35);
        code.setFont(new Font("Dialog", Font.BOLD, 18));
        code.setForeground(Color.BLACK);
        code.setBackground(Color.WHITE);

        JTextField date = new JTextField();
        date.setText(currentDate);
        date.setEditable(false);
        date.setBounds(1103, 289, 215, 35);
        date.setFont(new Font("Dialog", Font.PLAIN, 18));
        date.setForeground(Color.BLACK);
        date.setBackground(Color.WHITE);

        JTextField doc = new JTextField();
        doc.setText(currentDoctor);
        doc.setEditable(false);
        doc.setBounds(705, 481, 215, 35);
        doc.setFont(new Font("Dialog", Font.BOLD, 18));
        doc.setForeground(Color.BLACK);
        doc.setBackground(Color.WHITE);

        JTextField dept = new JTextField();
        dept.setText(currentDepartment);
        dept.setEditable(false);
        dept.setBounds(705, 549, 215, 35);
        dept.setFont(new Font("Dialog", Font.PLAIN, 18));
        dept.setForeground(Color.BLACK);
        dept.setBackground(Color.WHITE);

        JTextField sched = new JTextField();
        sched.setText(currentSchedule);
        sched.setEditable(false);
        sched.setBounds(705, 617, 350, 35);
        sched.setFont(new Font("Dialog", Font.PLAIN, 18));
        sched.setForeground(Color.BLACK);
        sched.setBackground(Color.WHITE);

        JTextField num = new JTextField();
        num.setText(currentNumber);
        num.setEditable(false);
        num.setBounds(1103, 481, 215, 35);
        num.setFont(new Font("Dialog", Font.PLAIN, 18));
        num.setForeground(Color.BLACK);
        num.setBackground(Color.WHITE);

        JTextField email = new JTextField();
        email.setText(currentEmail);
        email.setEditable(false);
        email.setBounds(1103, 549, 215, 35);
        email.setFont(new Font("Dialog", Font.PLAIN, 18));
        email.setForeground(Color.BLACK);
        email.setBackground(Color.WHITE);

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
        bgImageLayer.add(user, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(name, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(code, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(date, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(doc, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(dept, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sched, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(num, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(email, JLayeredPane.PALETTE_LAYER);

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