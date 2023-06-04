import javax.swing.*;
import java.awt.*;

public class UILogin {
    public static void main(String[] args) {
        new UILogin();
    }

    // Frame
    JFrame loginFrame;

    UILogin() {
        loginFrame = new JFrame();

        // Logo
        ImageIcon icon = new ImageIcon("images/logo.png");
        ImageIcon icon2 = new ImageIcon("images/tupbg.png");

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

        // JLayeredPane
        JLayeredPane bgImage = new JLayeredPane();
        bgImage.setBounds(0, 0, 1366, 768);
        bgImage.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

        // Style the Frame
        loginFrame.setIconImage(icon.getImage());
        loginFrame.setTitle("Patient Appointment Scheduling System");
        loginFrame.getContentPane().setBackground(new Color(0xFFFFFF));

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerFrameOnScreen(loginFrame);
        loginFrame.setLayout(null);
        loginFrame.setSize(1366, 768);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);

        // add Objects
        loginFrame.add(bgImage);
        bgImage.add(loginBox, JLayeredPane.PALETTE_LAYER);
        bgImage.add(title, JLayeredPane.PALETTE_LAYER);
        bgImage.add(title2, JLayeredPane.PALETTE_LAYER);
        bgImage.add(logo, JLayeredPane.PALETTE_LAYER);
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }

}
