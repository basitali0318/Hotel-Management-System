package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JTable t1;
    JLabel SearchRoom,bedType;
    JComboBox c1;
    JButton b1,b2;
    JCheckBox c2;
    SearchRoom() {
        setLayout(null);
        setResizable(false);
        SearchRoom = new JLabel("Search for Room");
        SearchRoom.setBounds(400,30,200,30);
        SearchRoom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(SearchRoom);
        bedType = new JLabel("Bed Type");
        bedType.setBounds(50,100,100,20);
        add(bedType);
        c1 = new JComboBox(new String[]{"Single Bed","Double Bed"});
        c1.setBounds(150,100,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        c2= new JCheckBox("Only Display Available");
        c2.setBounds(650,100,150,25);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Tahoma",Font.PLAIN,12));
        add(c2);

        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(50,160,100,20);
        add(l2);
        JLabel l3 = new JLabel("Availability");
        l3.setBounds(270,160,100,20);
        add(l3);
        JLabel l4 = new JLabel("Status");
        l4.setBounds(450,160,100,20);
        add(l4);
        JLabel l5 = new JLabel("Price");
        l5.setBounds(670,160,100,20);
        add(l5);
        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(870,160,100,20);
        add(l6);
        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == b2){
            try{
                Conn c = new Conn();
                 String str = "select * from room where type = '"+c1.getSelectedItem()+"'";
                 String str2 = "select * from room where available = 'Available' AND type = '"+c1.getSelectedItem()+"'";

                ResultSet rs ;
                if (c2.isSelected()){
                    rs = c.s.executeQuery(str2);
                }
                else {
                    rs = c.s.executeQuery(str);
                }
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
