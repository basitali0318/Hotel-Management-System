package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener {
    JTable t1;
    JLabel Pickup,Cartype;
    Choice c1;
    JButton b1,b2;
    JCheckBox c2;
    PickUp() {
        setLayout(null);
        setResizable(false);
        Pickup = new JLabel("Pickup Service");
        Pickup.setBounds(400,30,200,30);
        Pickup.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Pickup);
        Cartype = new JLabel("Type of Car");
        Cartype.setBounds(50,100,100,20);
        add(Cartype);
        c1= new Choice();
        c1.setBounds(150,100,150,25);
        add(c1);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            while (rs.next()){
                c1.add(rs.getString("car_company"));

            }
        }catch (Exception e){
            throw new RuntimeException(e);

            }

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50,160,100,20);
        add(l2);
        JLabel l3 = new JLabel("Age");
        l3.setBounds(200,160,100,20);
        add(l3);
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(330,160,100,20);
        add(l4);
        JLabel l5 = new JLabel("Company");
        l5.setBounds(460,160,100,20);
        add(l5);
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(860,160,100,20);
        add(l6);
        JLabel l7 = new JLabel("Model");
        l7.setBounds(630,160,100,20);
        add(l7);
        JLabel l8 = new JLabel("Location");
        l8.setBounds(750,160,100,20);
        add(l8);

        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            t1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception e){
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1000,600);
        setVisible(true);
        b2 = new JButton("Submit");
        b2.setBounds(300,520,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        b1 = new JButton("Back");
        b1.setBounds(500,520,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
    }
        public static void main(String[] args) {
        new PickUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2){
            try{
                Conn c = new Conn();
                String str = "select * from drivers where car_company = '"+c1.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else  if(e.getSource() == b1){
            new Reciption().setVisible(true);
            this.setVisible(false);

        }

    }

}
