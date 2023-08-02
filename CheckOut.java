package University.work.OOP.Project.HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice c1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton b1, b2;
    CheckOut()
    {
        setResizable(false);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            l1 = new JLabel("Check Out");
            l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
            l1.setBounds(100, 20, 100, 30);
            add(l1);
            l2 = new JLabel("Customer-ID");
            l2.setBounds(30, 80, 100, 20);
            add(l2);
        c1 = new Choice();
        c1.setBounds(150, 80, 150, 25);
        add(c1);

        l3 = new JLabel("Room Number");
        l3.setBounds(30, 120, 100, 20);
        add(l3);
        l4 = new JLabel("");
        l4.setBounds(150, 120, 150, 25);
        add(l4);
        l5 = new JLabel("Check-In");
        l5.setBounds(30, 160, 100, 20);
        add(l5);
        l6 = new JLabel("");
        l6.setBounds(150, 160, 150, 25);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        add(l6);
        l7 = new JLabel("Check-Out");
        l7.setBounds(30, 200, 100, 20);
        add(l7);
        l8 = new JLabel(""+new Date());
        l8.setBounds(150, 200, 150, 25);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        add(l8);
        Date d = new Date();
        b1 = new JButton("Check-Out");
        b1.setBounds(30, 270, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Back");
        b2.setBounds(170, 270, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        try {
            Conn c = new Conn();
            String str = "select * from customers";
            java.sql.ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("id_number"));
                l4.setText(rs.getString("room_number"));
                l6.setText(rs.getString("check_in_date"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\sixth.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l9 = new JLabel(i3);
        l9.setBounds(350, 20, 400, 300);
        add(l9);

        setVisible(true);
        setBounds(300,200,800,400);

    }

    public static void main(String[] args) {
        new CheckOut();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            String id = c1.getSelectedItem();
            String room = l4.getText();
            String str = "delete from customers where id_number = '"+id+"'";
            System.out.println("Selected id: " + id);
            String str2 = "update room set available = 'Available' where roomnumber = '"+room+"'";
            Conn c = new Conn();
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Check-Out Done");
                new Reciption().setVisible(true);
                this.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if(e.getSource()==b2)
        {
            new Reciption().setVisible(true);
            this.setVisible(false);
        }

    }
}
