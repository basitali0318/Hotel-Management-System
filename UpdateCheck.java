package University.work.OOP.Project.HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.* ;


public class UpdateCheck extends JFrame implements ActionListener {
    JLabel t1, t2, t3, t4, t5, t6, t7, t8;
    JTextField t11, t12, t13, t14, t15, t16;
    Choice c1;
    JButton b1, b2, b3;

    UpdateCheck() {
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 500);
        t1 = new JLabel("Update Status");
        t1.setForeground(Color.BLUE);
        t1.setBounds(90, 20, 200, 30);
        t1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));

        add(t1);
        t2 = new JLabel("Customer ID");
        t2.setBounds(30, 80, 100, 20);
        add(t2);
        c1 = new Choice();
        c1.setBounds(250, 80, 150, 25);
        add(c1);
        try {
            Conn c = new Conn();
            String str = "select * from customers";
            java.sql.ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("id_number"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        t3 = new JLabel("Room Number");
        t3.setBounds(30, 120, 100, 20);
        add(t3);
        t11 = new JTextField();
        t11.setBounds(250, 120, 150, 25);
        add(t11);
        t4 = new JLabel("Name");
        t4.setBounds(30, 160, 100, 20);
        add(t4);
        t12 = new JTextField();
        t12.setBounds(250, 160, 150, 25);
        add(t12);
        t5 = new JLabel("Check-In");
        t5.setBounds(30, 200, 100, 20);
        add(t5);
        t13 = new JTextField();
        t13.setBounds(250, 200, 150, 25);
        add(t13);
        t6 = new JLabel("Amount Paid");
        t6.setBounds(30, 240, 100, 20);
        add(t6);
        t14 = new JTextField();
        t14.setBounds(250, 240, 150, 25);
        add(t14);
        t7 = new JLabel("Pending Amount");
        t7.setBounds(30, 280, 100, 20);
        add(t7);
        t15 = new JTextField();
        t15.setBounds(250, 280, 150, 25);
        add(t15);
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30, 320, 100, 25);
        add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150, 320, 100, 25);
        add(b2);
        b2.addActionListener(this);
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270, 320, 100, 25);
        add(b3);
        b3.addActionListener(this);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\nine.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        t8 = new JLabel(i3);
        t8.setBounds(450, 50, 500, 300);
        add(t8);

        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateCheck();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String id = c1.getSelectedItem();
            String str = "select * from customers where id_number='" + id + "'";
            try {
                Conn c = new Conn();
                java.sql.ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    t11.setText(rs.getString("room_number"));
                    t12.setText(rs.getString("name"));
                    t13.setText(rs.getString("check_in_date"));
                    t14.setText(rs.getString("deposit"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='" + t11.getText() + "'");
                while (rs2.next()) {
                    t15.setText(rs2.getString("price"));
                    double amountPaid = Double.parseDouble(t14.getText());
                    double pendingAmount = Double.parseDouble(t15.getText());
                    double total = amountPaid + pendingAmount;
                    t16 = new JTextField();
                    t16.setText(String.valueOf(total));

                }
            } catch (SQLException ee) {
                throw new RuntimeException(ee);
            }
        } else if (e.getSource() == b2) {
            String id = c1.getSelectedItem();
            String room = t11.getText();
            String name = t12.getText();
            String checkin = t13.getText();
            String amountpaid = t14.getText();
            String pending = t15.getText();
            String total = t16.getText();
            try {
                Conn c = new Conn();
                String str = "update customers set room_number='" + room + "',name='" + name + "',check_in_date='" + checkin + "',deposit='" + amountpaid +  "' where id_number='" + id + "'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reciption().setVisible(true);
                this.setVisible(false);
            } catch (SQLException ee) {
                throw new RuntimeException(ee);
            }
        } else if (e.getSource() == b3) {
            new Reciption().setVisible(true);
            this.setVisible(false);
        }
    }
}