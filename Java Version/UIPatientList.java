import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPatientList extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new UIPatientList();
    }

    // Frame
    UIPatientList() {

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
        ImageIcon bgImage = new ImageIcon(getClass().getClassLoader().getResource("images/patientlist.png"));

        // Resize Image
        Image tempImage = bgImage.getImage();
        Image tempImage2 = tempImage.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(tempImage2);

        // Labels for Image
        JLabel bgImageLabel = new JLabel();
        bgImageLabel.setIcon(bgImage);
        bgImageLabel.setBounds(0, -20, 1366, 768);

        JButton patientButton = new JButton();
        patientButton.setText("Patients");
        patientButton.setFont(new Font("Dialog", Font.BOLD, 18));
        patientButton.setForeground(Color.WHITE);
        patientButton.setBackground(new Color(0x698f9a));
        patientButton.setOpaque(true);
        patientButton.setFocusable(false);
        patientButton.addActionListener(this);
        patientButton.setBounds(60, 315, 250, 50);

        JButton doctorButton = new JButton();
        doctorButton.setText("Doctors");
        doctorButton.setFont(new Font("Dialog", Font.BOLD, 18));
        doctorButton.setForeground(Color.WHITE);
        doctorButton.setBackground(Color.BLUE);
        doctorButton.setOpaque(true);
        doctorButton.setFocusable(false);
        doctorButton.addActionListener(this);
        doctorButton.setBounds(60, 384, 250, 50);

        JButton securityButton = new JButton();
        securityButton.setText("Security");
        securityButton.setFont(new Font("Dialog", Font.BOLD, 18));
        securityButton.setForeground(Color.WHITE);
        securityButton.setBackground(Color.BLUE);
        securityButton.setOpaque(true);
        securityButton.setFocusable(false);
        securityButton.addActionListener(this);
        securityButton.setBounds(60, 452, 250, 50);

        JButton logoutButton = new JButton();
        logoutButton.setText("Back");
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 18));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(0xD62839));
        logoutButton.setOpaque(true);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);
        logoutButton.setBounds(60, 655, 250, 50);

        //set Table
        JTable table = new JTable();
        Object[] columnNames = {"Code", "Name", "Age", "Sex", "Birthday", "Contact No.", "Date", "Assigned Doctor", "Payment Status"};
        DefaultTableModel model = new DefaultTableModel();

        //set columns
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);

        //set table
        table.setRowHeight(30);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.setFont(new Font("Dialog", Font.PLAIN, 12));
        table.setAutoCreateRowSorter(true);
        table.setEnabled(false);
        table.setCellSelectionEnabled(false);
        table.setDefaultEditor(getClass(), null);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 14));
        table.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(132);
        table.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(17);
        table.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(17);
        table.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(132);
        table.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(96);
        table.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(132);
        table.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(115);
        table.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(110);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setBounds(408,300,932,391);

        Object[] row = new Object[4];
        row[1] = "Jeanne May Carolino";
        model.addRow(row);
        model.addRow(row);

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
        bgImageLayer.add(patientButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(doctorButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(securityButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(logoutButton, JLayeredPane.PALETTE_LAYER);
        bgImageLayer.add(scrollPane, JLayeredPane.PALETTE_LAYER);
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