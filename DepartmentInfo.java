package University.work.OOP.Project.HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class DepartmentInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;

    DepartmentInfo() {
        setLayout(null);
        setResizable(false);
        JLabel l1 = new JLabel("Department Information");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(150, 20, 250, 20);
        add(l1);

        JLabel l2 = new JLabel("Department Name");
        l2.setBounds(10, 60, 120, 20);
        add(l2);

        JLabel l3 = new JLabel("Location");
        l3.setBounds(140, 60, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Number of Employees");
        l4.setBounds(240, 60, 150, 20);
        add(l4);

        t1 = new JTable();
        t1.setBounds(0, 90, 400, 200);
        add(t1);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM Department");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 450, 400);
        setVisible(true);

        b1 = new JButton("Back");
        b1.setBounds(150, 300, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
    }

    public static void main(String[] args) {
        new DepartmentInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Reciption().setVisible(true);
            this.setVisible(false);
        }
    }
}
