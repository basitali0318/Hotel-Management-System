package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1266,760);
        setLayout(null);
        setResizable(false);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\third.jpg");
       Image i2 = i1.getImage().getScaledInstance(1266, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1266,760);
        add(l1);
        JLabel text= new JLabel("Welcome to the BS Hotel");
text.setBounds(300, 50, 1000, 50);
text.setForeground(java.awt.Color.WHITE);
text.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 58));
l1.add(text);
JMenuBar menuBar = new JMenuBar();
menuBar.setBounds(0,0,1266,30);
l1.add(menuBar);
JMenu hotelManagement = new JMenu("Hotel Management");
hotelManagement.setForeground(Color.BLUE);
menuBar.add(hotelManagement);
JMenuItem reception = new JMenuItem("Reception");
reception.addActionListener(this);
hotelManagement.add(reception);
JMenu admin = new JMenu("Admin");
JMenuItem admin1 = new JMenuItem("Add Employee");
admin.add(admin1);
admin1.addActionListener(this);
JMenuItem admin2 = new JMenuItem("Add Rooms");
admin.add(admin2);
admin2.addActionListener(this);
JMenuItem admin3 = new JMenuItem("Add Drivers");
admin.add(admin3);
admin3.addActionListener(this);
admin.setForeground(java.awt.Color.BLUE);
menuBar.add(admin);
   setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Rooms")){
            new AddRooms().setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Drivers")){
            new AddDriver().setVisible(true);
        }
        else if(e.getActionCommand().equals("Reception")){
            new Reciption().setVisible(true);
        }


    }
}
