import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIAppointmentSched extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new UIAppointmentSched();
    }

    UIAppointmentSched() {

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

        JButton edit = new JButton();
        edit.setText("Submit");
        edit.setFont(new Font("Dialog", Font.BOLD, 18));
        edit.setForeground(Color.BLACK);
        edit.setBackground(new Color(0xFFD600));
        edit.setOpaque(true);
        edit.setFocusable(false);
        edit.addActionListener(this);
        edit.setBounds(1050, 655, 250, 50);
        edit.setBorder(BorderFactory.createEmptyBorder());

        // Text Fields
         JTextField username = new JTextField();
         username.setBounds(1035, 23, 250, 35);
         username.setFont(new Font("Dialog", Font.PLAIN, 18));
         username.setForeground(Color.BLACK);
         username.setBackground(new Color(0xe8eaec));
         username.setBorder(BorderFactory.createEmptyBorder());

        JTextField d1 = new JTextField();
        d1.setBounds(470, 348, 220, 35);
        d1.setFont(new Font("Dialog", Font.PLAIN, 18));
        d1.setForeground(Color.BLACK);
        d1.setBackground(Color.WHITE);

        JTextField d2 = new JTextField();
        d2.setBounds(470, 427, 220, 35);
        d2.setFont(new Font("Dialog", Font.PLAIN, 18));
        d2.setForeground(Color.BLACK);
        d2.setBackground(Color.WHITE);

        JTextField d3 = new JTextField();
        d3.setBounds(470, 506, 220, 35);
        d3.setFont(new Font("Dialog", Font.PLAIN, 18));
        d3.setForeground(Color.BLACK);
        d3.setBackground(Color.WHITE);

        JTextField p1 = new JTextField();
        p1.setBounds(740, 348, 220, 35);
        p1.setFont(new Font("Dialog", Font.PLAIN, 18));
        p1.setForeground(Color.BLACK);
        p1.setBackground(Color.WHITE);

        JTextField p2 = new JTextField();
        p2.setBounds(740, 427, 220, 35);
        p2.setFont(new Font("Dialog", Font.PLAIN, 18));
        p2.setForeground(Color.BLACK);
        p2.setBackground(Color.WHITE);

        JTextField p3 = new JTextField();
        p3.setBounds(740, 506, 220, 35);
        p3.setFont(new Font("Dialog", Font.PLAIN, 18));
        p3.setForeground(Color.BLACK);
        p3.setBackground(Color.WHITE);

        JTextField sa1 = new JTextField();
        sa1.setBounds(1010, 348, 220, 35);
        sa1.setFont(new Font("Dialog", Font.PLAIN, 18));
        sa1.setForeground(Color.BLACK);
        sa1.setBackground(Color.WHITE);

        JTextField sa2 = new JTextField();
        sa2.setBounds(1010, 427, 220, 35);
        sa2.setFont(new Font("Dialog", Font.PLAIN, 18));
        sa2.setForeground(Color.BLACK);
        sa2.setBackground(Color.WHITE);

        JTextField sa3 = new JTextField();
        sa3.setBounds(1010, 506, 220, 35);
        sa3.setFont(new Font("Dialog", Font.PLAIN, 18));
        sa3.setForeground(Color.BLACK);
        sa3.setBackground(Color.WHITE);

         String[] choices = { "1", "2", "3" };
        JComboBox<String> choice = new JComboBox<>(choices);
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
        bgImageLayer.add(button, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button1, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button2, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(button3, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(username, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(edit, JLayeredPane.PALETTE_LAYER);
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
        // TODO Auto-generated method stub
    }

}
    