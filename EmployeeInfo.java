package University.work.OOP.Project.HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;

    EmployeeInfo() {
        setLayout(null);

        setResizable(false);
        JLabel l2 = new JLabel("Name");
        l2.setBounds(10, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Age");
        l3.setBounds(120, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(230, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(340, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(430, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(540, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("ID Card Number");
        l8.setBounds(650, 10, 120, 20);
        add(l8);

        t1 = new JTable();
        t1.setBounds(0, 40, 780, 400);
        add(t1);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 780, 600);
        setVisible(true);

        b1 = new JButton("Back");
        b1.setBounds(100, 460, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Reciption().setVisible(true);
            this.setVisible(false);
        }
    }
}
