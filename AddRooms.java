package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1, t2;
    JComboBox cb1, cb2, cb3;
    JButton b1, b2;

    AddRooms() {
        getContentPane().setBackground(Color.WHITE);
        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(150, 20, 200, 20);
        add(l1);
        setResizable(false);
        setLayout(null);

        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma", Font.PLAIN, 16));
        room.setBounds(60, 80, 120, 30);
        add(room);

        t1 = new JTextField();
        t1.setBounds(200, 80, 150, 30);
        add(t1);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(60, 130, 120, 30);
        add(available);

        String[] s1 = {"Available", "Occupied"};
        cb1 = new JComboBox(s1);
        cb1.setBounds(200, 130, 150, 30);
        cb1.setBackground(Color.WHITE);
        add(cb1);

        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma", Font.PLAIN, 16));
        status.setBounds(60, 180, 120, 30);
        add(status);

        String[] s2 = {"Cleaned", "Dirty"};
        cb2 = new JComboBox(s2);
        cb2.setBounds(200, 180, 150, 30);
        cb2.setBackground(Color.WHITE);
        add(cb2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);

        t2 = new JTextField();
        t2.setBounds(200, 230, 150, 30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        type.setBounds(60, 280, 120, 30);
        add(type);

        String[] s3 = {"Single Bed", "Double Bed"};
        cb3 = new JComboBox(s3);
        cb3.setBounds(200, 280, 150, 30);
        cb3.setBackground(Color.WHITE);
        add(cb3);

        b1 = new JButton("Add Room");
        b1.setBounds(60, 350, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Cancel");
        b2.setBounds(220, 350, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\twelve.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(400, 50, 500, 300);
        add(l2);

        setBounds(330, 200, 940, 470);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String room = t1.getText();
            String available = (String) cb1.getSelectedItem();
            String status = (String) cb2.getSelectedItem();
            String price = t2.getText();
            String type = (String) cb3.getSelectedItem();

            if(room.equals("") || price.equals("")) {
                JOptionPane.showMessageDialog(null, "Room or Price cannot be empty");
            }
            else if(!room.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Room number should be numeric");
            }
            else if(!price.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Price should be numeric");
            }
            else {
                Conn c = new Conn();
                String str = "insert into room values('" + room + "','" + available + "','" + status + "','" + price + "','" + type + "')";
                try {
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "New Room Added");
                    this.setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        } else if (e.getSource() == b2) {
            this.setVisible(false);
        }
    }
}