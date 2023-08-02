package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JLabel checkIn;
    Choice c2;
    JTextField t1, t2, t4, t5, t6;
    JComboBox<String> c1;
    JRadioButton r1, r2;
    JButton b1, b2;


    AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        l1 = new JLabel("New Customer Form");
        l1.setBounds(100, 20, 300, 30);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        l2 = new JLabel("ID Type");
        l2.setBounds(35, 80, 100, 20);
        add(l2);
        c1 = new JComboBox<>(new String[]{"Passport", "Voter-Id Card", "Driving License", "ID Card"});
        c1.setBounds(200, 80, 150, 25);
        c1.setBackground(Color.WHITE);
        add(c1);
        l3 = new JLabel("Number");
        l3.setBounds(35, 120, 100, 20);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(200, 120, 150, 25);
        add(t1);
        l4 = new JLabel("Name");
        l4.setBounds(35, 160, 100, 20);
        add(l4);
        t2 = new JTextField();
        t2.setBounds(200, 160, 150, 25);
        add(t2);
        l5 = new JLabel("Gender");
        l5.setBounds(35, 200, 100, 20);
        add(l5);
        r1 = new JRadioButton("Male");
        r1.setBounds(200, 200, 60, 25);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBounds(270, 200, 80, 25);
        r2.setBackground(Color.WHITE);
        add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        l6 = new JLabel("Country");
        l6.setBounds(35, 240, 100, 20);
        add(l6);
        t4 = new JTextField();
        t4.setBounds(200, 240, 150, 25);
        add(t4);
        l7 = new JLabel("Allocated Room Number");
        l7.setBounds(35, 280, 150, 20);
        add(l7);
        c2 = new Choice();
        c2.setBounds(200, 280, 150, 25);
        add(c2);
        try {
            Conn c = new Conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c2.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        t5 = new JTextField();
        t5.setBounds(200, 280, 150, 25);
        add(t5);
        l8 = new JLabel("Checked In");
        l8.setBounds(35, 320, 100, 20);
        add(l8);
        Date date = new Date();
        checkIn = new JLabel("" + date);
        checkIn.setBounds(200, 320, 150, 25);
        checkIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(checkIn);
        b1 = new JButton("Add Customer");
        b1.setBounds(50, 400, 120, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Back");
        b2.setBounds(200, 400, 120, 25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        l9 = new JLabel("Deposit");
        l9.setBounds(35, 360, 100, 20);
        add(l9);
        t6 = new JTextField();
        t6.setBounds(200, 360, 150, 25);
        add(t6);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\fifth.png");
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(400, 50, 300, 400);
        add(l10);


        setBounds(300, 200, 800, 550);
        setVisible(true);

    }


    public static void main(String[] args) {
        new AddCustomer();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String idType = (String) c1.getSelectedItem();
            String idNumber = t1.getText();
            String name = t2.getText();
            String gender = r1.isSelected() ? "Male" : "Female";
            String country = t4.getText();
            String roomNumber = c2.getSelectedItem();
            String checkInDate = checkIn.getText();
            String deposit = t6.getText();

            // Empty Field Validation for required fields
            if (idType.isEmpty() || name.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields.");
                return;
            }

            // Name Validation
            if (!name.matches("^[a-zA-Z\\s]*$")) {
                JOptionPane.showMessageDialog(null, "Name can only contain letters and spaces.");
                return;
            }

            // Country Validation
            if (!country.matches("^[a-zA-Z\\s]*$")) {
                JOptionPane.showMessageDialog(null, "Country can only contain letters and spaces.");
                return;
            }

            // Deposit Validation
            try {
                double depositAmount = Double.parseDouble(deposit);
                if (depositAmount < 0) {
                    JOptionPane.showMessageDialog(null, "Deposit must be a positive number.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Deposit must be a valid number.");
                return;
            }

            // Room Number Validation
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM room WHERE roomnumber = '" + roomNumber + "' AND available = 'Available'";
                ResultSet rs = c.s.executeQuery(query);

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Selected room number does not exist or is already occupied.");
                    return;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // All validations passed, proceed to add the customer
            try {
                Conn c = new Conn();
                String query = "INSERT INTO customers (id_type, id_number, name, gender, country, room_number, check_in_date, deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = c.c.prepareStatement(query);
                stmt.setString(1, idType);
                stmt.setString(2, idNumber);
                stmt.setString(3, name);
                stmt.setString(4, gender);
                stmt.setString(5, country);
                stmt.setString(6, roomNumber);
                stmt.setString(7, checkInDate);
                stmt.setString(8, deposit);

                String query2 = "UPDATE room SET available = 'Occupied' WHERE roomnumber = ?";
                PreparedStatement stmt2 = c.c.prepareStatement(query2);
                stmt2.setString(1, roomNumber);

                stmt.executeUpdate();
                stmt2.executeUpdate();

                JOptionPane.showMessageDialog(null, "New Customer Added");
                this.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            this.setVisible(false);
        }
    }
}