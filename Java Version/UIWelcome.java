import javax.swing.*;
import java.awt.*;

public class UIWelcome {
    public static void main(String[] args) {
        new UIWelcome();
    }

    // Frame
    JFrame welcomeFrame;
    JProgressBar progressBar;

    UIWelcome() {
        welcomeFrame = new JFrame();
        progressBar = new JProgressBar();

        ImageIcon icon = new ImageIcon("images/logo.png");
        ImageIcon bgicon = new ImageIcon("images/bgicon.jpg");
        ImageIcon jicon = new ImageIcon("images/java.png");
        ImageIcon ticon = new ImageIcon("images/tup.png");

        // Resize Image
        Image tempImage = icon.getImage();
        Image tempImage2 = tempImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(tempImage2);

        Image tempImage3 = bgicon.getImage();
        Image tempImage4 = tempImage3.getScaledInstance(583, 680, Image.SCALE_SMOOTH);
        bgicon = new ImageIcon(tempImage4);

        Image tempImage5 = jicon.getImage();
        Image tempImage6 = tempImage5.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        jicon = new ImageIcon(tempImage6);

        Image tempImage7 = ticon.getImage();
        Image tempImage8 = tempImage7.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        ticon = new ImageIcon(tempImage8);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(bgicon);
        bgImageLabel.setBounds(0, -30, 683, 768);

        // JLayeredPane
        JLayeredPane bgImage = new JLayeredPane();
        bgImage.setBounds(683, 0, 683, 768);
        bgImage.add(bgImageLabel, JLayeredPane.PALETTE_LAYER);

        // Labels
        JLabel subject = new JLabel();
        subject.setText("  Programming Language");
        subject.setBounds(40, 160, 230, 20);
        subject.setFont(new Font("Dialog", Font.BOLD, 18));
        subject.setForeground(Color.white);
        subject.setBackground(Color.lightGray);
        subject.setOpaque(true);
        subject.setHorizontalAlignment(JLabel.LEFT);

        JLabel title = new JLabel();
        title.setText("Patient Appointment");
        title.setBounds(40, 200, 1366, 65);
        title.setFont(new Font("Dialog", Font.BOLD, 60));
        title.setForeground(new Color(0xD62839));
        title.setHorizontalAlignment(JLabel.LEFT);

        JLabel title2 = new JLabel();
        title2.setText("Scheduling System");
        title2.setBounds(40, 275, 1366, 55);
        title2.setFont(new Font("Dialog", Font.BOLD, 48));
        title2.setForeground(new Color(0xD62839));
        title2.setHorizontalAlignment(JLabel.LEFT);

        JLabel JavaLogo = new JLabel();
        JavaLogo.setIcon(jicon);
        JavaLogo.setBounds(40, 660, 65, 65);
        JavaLogo.setVerticalAlignment(JLabel.CENTER);
        JavaLogo.setHorizontalAlignment(JLabel.LEFT);

        JLabel JavaText = new JLabel();
        JavaText.setText("Java 20");
        JavaText.setBounds(115, 680, 100, 40);
        JavaText.setFont(new Font("Dialog", Font.BOLD, 24));
        JavaText.setForeground(Color.GRAY);
        JavaText.setHorizontalAlignment(JLabel.LEFT);

        JLabel TupLogo = new JLabel();
        TupLogo.setIcon(ticon);
        TupLogo.setBounds(250, 670, 55, 55);
        TupLogo.setVerticalAlignment(JLabel.CENTER);
        TupLogo.setHorizontalAlignment(JLabel.LEFT);

        JLabel TupText = new JLabel();
        TupText.setText("TUP - Manila Students");
        TupText.setBounds(315, 680, 500, 40);
        TupText.setFont(new Font("Dialog", Font.BOLD, 24));
        TupText.setForeground(Color.GRAY);
        TupText.setHorizontalAlignment(JLabel.LEFT);

        // Developers
        JLabel dev1 = new JLabel();
        dev1.setText("This program is created by the following Developers:");
        dev1.setBounds(40, 350, 1366, 20);
        dev1.setFont(new Font("Dialog", Font.BOLD, 18));
        dev1.setForeground(Color.lightGray);
        dev1.setHorizontalAlignment(JLabel.LEFT);

        JLabel dev2 = new JLabel();
        dev2.setText("Project Lead: John Paul Monter");
        dev2.setBounds(40, 380, 1366, 20);
        dev2.setFont(new Font("Dialog", Font.BOLD, 18));
        dev2.setForeground(Color.lightGray);
        dev2.setHorizontalAlignment(JLabel.LEFT);

        JLabel dev3 = new JLabel();
        dev3.setText("Jeanne May Carolino");
        dev3.setBounds(40, 410, 1366, 20);
        dev3.setFont(new Font("Dialog", Font.BOLD, 18));
        dev3.setForeground(Color.lightGray);
        dev3.setHorizontalAlignment(JLabel.LEFT);

        JLabel dev4 = new JLabel();
        dev4.setText("Almira Jill Garcia");
        dev4.setBounds(40, 440, 1366, 20);
        dev4.setFont(new Font("Dialog", Font.BOLD, 18));
        dev4.setForeground(Color.lightGray);
        dev4.setHorizontalAlignment(JLabel.LEFT);

        // Progress Bar
        progressBar.setValue(0);
        progressBar.setBounds(0, 758, 1366, 10);
        progressBar.setForeground(new Color(0xBA324F));

        // Style the Frame
        welcomeFrame.setIconImage(icon.getImage());
        welcomeFrame.setTitle("Patient Appointment Scheduling System");
        welcomeFrame.getContentPane().setBackground(new Color(0xFFFFFF));

        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setUndecorated(true);
        centerFrameOnScreen(welcomeFrame);
        welcomeFrame.setLayout(null);
        welcomeFrame.setSize(1366, 768);
        welcomeFrame.setVisible(true);
        welcomeFrame.setResizable(false);

        // Add objects
        welcomeFrame.add(progressBar);
        welcomeFrame.add(subject);
        welcomeFrame.add(title);
        welcomeFrame.add(title2);
        welcomeFrame.add(JavaLogo);
        welcomeFrame.add(bgImage);
        welcomeFrame.add(JavaText);
        welcomeFrame.add(TupLogo);
        welcomeFrame.add(TupText);
        welcomeFrame.add(dev1);
        welcomeFrame.add(dev2);
        welcomeFrame.add(dev3);
        welcomeFrame.add(dev4);

        progressFill();
    }

    private void progressFill() {
        int counter = 0;
        while (counter <= 100) {
            progressBar.setValue(counter);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        welcomeFrame.dispose();
    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 8;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);
    }
}