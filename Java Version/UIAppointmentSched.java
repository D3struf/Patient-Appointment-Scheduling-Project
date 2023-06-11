import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIAppointmentSched extends JFrame implements ActionListener {

    // public static void main(String[] args) {
    //     new UIAppointmentSched();
    // }
    private Main main;

    JButton patientViewButton;
    JButton scheduleButton;
    JButton paymentButton;
    JButton backButton;
    JButton submitButton;
    JComboBox<String> choice;
    Main.APPOINTMENT[] appointment;

    UIAppointmentSched(Main main) {
        this.main = main;
        String currentUserName = main.getCurrentUserName();
        appointment = main.generateAppointmentSchedules();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/appsched1.png"));
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

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(new Color(0xFFD600));
        submitButton.setOpaque(true);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(1050, 655, 250, 50);
        submitButton.setBorder(BorderFactory.createEmptyBorder());

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

        JTextField d1 = new JTextField();
        d1.setHorizontalAlignment(SwingConstants.CENTER);
        d1.setText(appointment[0].getDate());
        d1.setEditable(false);
        d1.setBounds(470, 348, 220, 35);
        d1.setFont(new Font("Dialog", Font.PLAIN, 18));
        d1.setForeground(Color.BLACK);
        d1.setBackground(Color.WHITE);

        JTextField d2 = new JTextField();
        d2.setHorizontalAlignment(SwingConstants.CENTER);
        d2.setText(appointment[1].getDate());
        d2.setEditable(false);
        d2.setBounds(470, 427, 220, 35);
        d2.setFont(new Font("Dialog", Font.PLAIN, 18));
        d2.setForeground(Color.BLACK);
        d2.setBackground(Color.WHITE);

        JTextField d3 = new JTextField();
        d3.setHorizontalAlignment(SwingConstants.CENTER);
        d3.setText(appointment[2].getDate());
        d3.setEditable(false);
        d3.setBounds(470, 506, 220, 35);
        d3.setFont(new Font("Dialog", Font.PLAIN, 18));
        d3.setForeground(Color.BLACK);
        d3.setBackground(Color.WHITE);

        JTextField p1 = new JTextField();
        p1.setHorizontalAlignment(SwingConstants.CENTER);
        p1.setText(String.valueOf(appointment[0].getNumPatients()));
        p1.setEditable(false);
        p1.setBounds(740, 348, 220, 35);
        p1.setFont(new Font("Dialog", Font.PLAIN, 18));
        p1.setForeground(Color.BLACK);
        p1.setBackground(Color.WHITE);

        JTextField p2 = new JTextField();
        p2.setHorizontalAlignment(SwingConstants.CENTER);
        p2.setText(String.valueOf(appointment[1].getNumPatients()));
        p2.setEditable(false);
        p2.setBounds(740, 427, 220, 35);
        p2.setFont(new Font("Dialog", Font.PLAIN, 18));
        p2.setForeground(Color.BLACK);
        p2.setBackground(Color.WHITE);

        JTextField p3 = new JTextField();
        p3.setHorizontalAlignment(SwingConstants.CENTER);
        p3.setText(String.valueOf(appointment[2].getNumPatients()));
        p3.setEditable(false);
        p3.setBounds(740, 506, 220, 35);
        p3.setFont(new Font("Dialog", Font.PLAIN, 18));
        p3.setForeground(Color.BLACK);
        p3.setBackground(Color.WHITE);

        JTextField sa1 = new JTextField();
        sa1.setHorizontalAlignment(SwingConstants.CENTER);
        sa1.setText(String.valueOf(appointment[0].getNumPatients()) + " / " + String.valueOf(Variables.MAX_PATIENTS));
        sa1.setEditable(false);
        sa1.setBounds(1010, 348, 220, 35);
        sa1.setFont(new Font("Dialog", Font.PLAIN, 18));
        sa1.setForeground(Color.BLACK);
        sa1.setBackground(Color.WHITE);

        JTextField sa2 = new JTextField();
        sa2.setHorizontalAlignment(SwingConstants.CENTER);
        sa2.setText(String.valueOf(appointment[1].getNumPatients()) + " / " + String.valueOf(Variables.MAX_PATIENTS));
        sa2.setEditable(false);
        sa2.setBounds(1010, 427, 220, 35);
        sa2.setFont(new Font("Dialog", Font.PLAIN, 18));
        sa2.setForeground(Color.BLACK);
        sa2.setBackground(Color.WHITE);

        JTextField sa3 = new JTextField();
        sa3.setHorizontalAlignment(SwingConstants.CENTER);
        sa3.setText(String.valueOf(appointment[2].getNumPatients()) + " / " + String.valueOf(Variables.MAX_PATIENTS));
        sa3.setEditable(false);
        sa3.setBounds(1010, 506, 220, 35);
        sa3.setFont(new Font("Dialog", Font.PLAIN, 18));
        sa3.setForeground(Color.BLACK);
        sa3.setBackground(Color.WHITE);

        String[] choices = { "1", "2", "3" };
        choice = new JComboBox<>(choices);
        choice.setBounds(607, 585, 220, 35);
        choice.setFont(new Font("Dialog", Font.PLAIN, 18));
        choice.setForeground(Color.BLACK);
        choice.setBackground(Color.WHITE);
        
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
        bgImageLayer.add(submitButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(d1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(d2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(d3, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(p1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(p2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(p3, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sa1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sa2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(sa3, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(choice, JLayeredPane.PALETTE_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code;
        if (e.getSource() == submitButton) {
            int chosen = choice.getSelectedIndex();
            if(appointment[chosen].getNumPatients() >= Variables.MAX_PATIENTS) {
                ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("images/full.png"));
                JOptionPane.showMessageDialog(null, "This schedule is already full.", "Schedule", JOptionPane.INFORMATION_MESSAGE, logo);
            }
            else {
                ImageIcon logo2 = new ImageIcon(getClass().getClassLoader().getResource("images/proceed.png"));
                Main.DOCTOR selectedDoctor = main.appointDoctor();
                code = main.appointmentCode();
                main.appointmentSchedule(appointment[chosen], selectedDoctor, code);
                JOptionPane.showMessageDialog(null, "Successfully Created an Appointment Schedule.\n\nAppointment Code: " + code + "\nDoctor: " + selectedDoctor.getName() + "\nDate: " + appointment[chosen].getDate(), "Schedule", JOptionPane.INFORMATION_MESSAGE, logo2);
                new UIPatientInfo(main);
                this.dispose();
            }
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