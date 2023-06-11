import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPatientInfo extends JFrame implements ActionListener {

    // public static void main(String[] args) {
    //     new UIPatientInfo();
    // }
    private Main main;

    UIPatientInfo(Main main) {
        this.main = main;

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
        button1.setBackground(new Color(0x698f9a));
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
        button3.setText("Back");
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

         JTextField user = new JTextField();
        user.setBounds(562, 224, 250, 35);
        user.setFont(new Font("Dialog", Font.PLAIN, 18));
        user.setForeground(Color.BLACK);
        user.setBackground(Color.WHITE);

        JTextField name = new JTextField();
        name.setBounds(562, 290, 250, 35);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);

        JTextField code = new JTextField();
        code.setBounds(1103, 223, 215, 35);
        code.setFont(new Font("Dialog", Font.PLAIN, 18));
        code.setForeground(Color.BLACK);
        code.setBackground(Color.WHITE);

        JTextField date = new JTextField();
        date.setBounds(1103, 289, 215, 35);
        date.setFont(new Font("Dialog", Font.PLAIN, 18));
        date.setForeground(Color.BLACK);
        date.setBackground(Color.WHITE);

        JTextField doc = new JTextField();
        doc.setBounds(705, 481, 215, 35);
        doc.setFont(new Font("Dialog", Font.PLAIN, 18));
        doc.setForeground(Color.BLACK);
        doc.setBackground(Color.WHITE);

        JTextField dept = new JTextField();
        dept.setBounds(705, 549, 215, 35);
        dept.setFont(new Font("Dialog", Font.PLAIN, 18));
        dept.setForeground(Color.BLACK);
        dept.setBackground(Color.WHITE);

        JTextField sched = new JTextField();
        sched.setBounds(705, 617, 215, 35);
        sched.setFont(new Font("Dialog", Font.PLAIN, 18));
        sched.setForeground(Color.BLACK);
        sched.setBackground(Color.WHITE);

        JTextField num = new JTextField();
        num.setBounds(1103, 481, 215, 35);
        num.setFont(new Font("Dialog", Font.PLAIN, 18));
        num.setForeground(Color.BLACK);
        num.setBackground(Color.WHITE);

        JTextField email = new JTextField();
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
        bgImageLayer.add(button, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button3, JLayeredPane.PALETTE_LAYER);
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
        // TODO Auto-generated method stub
    }

}