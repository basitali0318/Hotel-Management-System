package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1, t2, t4, t5, t6;
    JComboBox<String> t3;
    JComboBox<String> t7;
    JButton b1, b2;

    AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        JLabel l1 = new JLabel("Add Drivers");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(150, 20, 200, 20);
        add(l1);
        setResizable(false);
        setLayout(null);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        name.setBounds(60, 80, 120, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 80, 150, 30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        age.setBounds(60, 130, 120, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 130, 150, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gender.setBounds(60, 180, 120, 30);
        add(gender);

        String[] genders = {"Male", "Female"};
        t3 = new JComboBox<>(genders);
        t3.setBounds(200, 180, 150, 30);
        t3.setBackground(Color.WHITE);
        add(t3);

        JLabel carModel = new JLabel("Car Model");
        carModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        carModel.setBounds(60, 230, 120, 30);
        add(carModel);

        t4 = new JTextField();
        t4.setBounds(200, 230, 150, 30);
        add(t4);

        JLabel carCompany = new JLabel("Car Company");
        carCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        carCompany.setBounds(60, 280, 120, 30);
        add(carCompany);

        t5 = new JTextField();
        t5.setBounds(200, 280, 150, 30);
        add(t5);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        location.setBounds(60, 330, 120, 30);
        add(location);

        t6 = new JTextField();
        t6.setBounds(200, 330, 150, 30);
        add(t6);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(60, 380, 120, 30);
        add(available);

        String[] availabilities = {"Available", "Occupied"};
        t7 = new JComboBox<>(availabilities);
        t7.setBounds(200, 380, 150, 30);
        t7.setBackground(Color.WHITE);
        add(t7);

        b1 = new JButton("Add Driver");
        b1.setBounds(60, 450, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Cancel");
        b2.setBounds(220, 450, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\eleven.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(400, 80, 500, 300);
        add(l2);


        setBounds(320, 200, 940, 570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddDriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) t3.getSelectedItem();
            String carModel = t4.getText();
            String carCompany = t5.getText();
            String location = t6.getText();
            String availability = (String) t7.getSelectedItem();

            if (name.equals("") || age.equals("") || carModel.equals("") || carCompany.equals("") || location.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are required");
            } else if (!age.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Age should be numeric");
            } else if (name.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Name should not contain numbers");
            } else if (carCompany.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Car Company should not contain numbers");
            } else if (!carModel.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Car Model should contain only numbers");
            } else {
                // Assuming you have a database connection class "Conn" with an instance "c".
                Conn c = new Conn();
                String str = "insert into drivers (name, age, gender, car_model, car_company, location, availability) VALUES " +
                        "('" + name + "', '" + age + "', '" + gender + "', '" + carModel + "', '" + carCompany + "', '" + location + "', '" + availability + "')";

                try {
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "New Driver Added");
                    this.setVisible(false);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == b2) {
            this.setVisible(false);
        }
    }
}