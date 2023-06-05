import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIHomePage extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new UIHomePage();
    }

    // Frame

    UIHomePage() {

        ImageIcon icon = new ImageIcon("images/logo.png");
        ImageIcon bgImage = new ImageIcon("images/bghome.png");

        // Resize Image
        Image tempImage = bgImage.getImage();
        Image tempImage2 = tempImage.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(tempImage2);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(bgImage);
        bgImageLabel.setBounds(0, -20, 1366, 768);

        JButton account = new JButton("Account");
        account.setBounds(120, 480, 400, 50);
        account.setFont(new Font("Dialog", Font.BOLD, 18));
        account.setForeground(Color.WHITE);
        account.setBackground(new Color(0x44546b));
        account.setOpaque(true);
        account.setFocusable(false);

        JButton appointment = new JButton("Appointment");
        appointment.setBounds(100, 100, 400, 50);
        appointment.setFont(new Font("Dialog", Font.BOLD, 18));
        appointment.setForeground(Color.WHITE);
        appointment.setBackground(new Color(0x44546b));
        appointment.setOpaque(true);

        // JLayered for layers
        JLayeredPane bgImageLayer = new JLayeredPane();
        bgImageLayer.setBounds(0, 0, 1366, 768);
        bgImageLayer.add(bgImageLabel, JLayeredPane.DEFAULT_LAYER);

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
        this.add(bgImageLayer);
        bgImageLayer.add(account, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(appointment, JLayeredPane.PALETTE_LAYER);
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
