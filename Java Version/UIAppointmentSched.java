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
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/appSched.png"));
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
        button3.setText("Logout");
        button3.setFont(new Font("Dialog", Font.BOLD, 18));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(0xD62839));
        button3.setOpaque(true);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBounds(60, 655, 250, 50);