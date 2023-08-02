package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class rooms extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    rooms(){
        setLayout(null);
        setResizable(false);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\eight.jpg");
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(500,0,600,600);
        add(l1);
        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(10,10,100,20);
        add(l2);
        JLabel l3 = new JLabel("Availability");
        l3.setBounds(120,10,100,20);
        add(l3);
        JLabel l4 = new JLabel("Status");
        l4.setBounds(230,10,100,20);
        add(l4);
        JLabel l5 = new JLabel("Price");
        l5.setBounds(340,10,100,20);
        add(l5);
        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(430,10,100,20);
        add(l6);
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        try{
            Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from room");
              t1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception e){
            e.printStackTrace();
        }
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1050,600);
        setVisible(true);
        b1 = new JButton("Back");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
    }

    public static void main(String[] args) {
        new rooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new Reciption().setVisible(true);
            this.setVisible(false);
        }

    }
}
