package University.work.OOP.Project.HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {


    JLabel name, age, gender, job, salary, phone, Email,IDCARDNumber;
     JTextField t1, t2, t3, t4, t5,t6;
     JRadioButton rbmale, rbfmale;
     JComboBox cbjob;
     JButton b1;

    AddEmployee() {
        setLayout(null);
        setResizable(false);
        name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        name.setBounds(60, 30, 120, 30);
        add(name);
        t1 = new JTextField();
        t1.setBounds(200, 30, 150, 30);
        add(t1);
        age = new JLabel("AGE");
        age.setBounds(60, 80, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);
        t2 = new JTextField();
        t2.setBounds(200, 80, 150, 30);
        add(t2);
        gender = new JLabel("Gender");
        gender.setBounds(60, 130, 120, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(rbmale);
        rbfmale = new JRadioButton("Female");
        rbfmale.setBounds(280, 130, 100, 30);
        rbfmale.setBackground(Color.WHITE);
        rbfmale.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(rbfmale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfmale);
        job = new JLabel("Job");
        job.setBounds(60, 180, 120, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);
        cbjob = new JComboBox(new String[]{"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"});
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        cbjob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(cbjob);
        salary = new JLabel("Salary");
        salary.setBounds(60, 230, 120, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(salary);
        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 30);
        add(t3);
        phone = new JLabel("Phone");
        phone.setBounds(60, 280, 120, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(phone);
        t4 = new JTextField();
        t4.setBounds(200, 280, 150, 30);
        add(t4);
        Email = new JLabel("Email");
        Email.setBounds(60, 330, 120, 30);
        Email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(Email);
        t5 = new JTextField();
        IDCARDNumber = new JLabel("IDCARDNumber");
        IDCARDNumber.setBounds(60, 380, 120, 30);
        IDCARDNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(IDCARDNumber);
        t6 = new JTextField();
        t6.setBounds(200, 380, 150, 30);
        add(t6);
        t5.setBounds(200, 330, 150, 30);
        add(t5);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200, 430, 150, 30);

        b1.addActionListener(this);
        add(b1);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\tenth.jpg");
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(380, 60, 450, 375);
        add(l1);

        // Set action listener for the button
        b1.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String email = t5.getText();
        String idCardNumber = t6.getText();
        String gender = null;

        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfmale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        if (name.isEmpty() || age.isEmpty() || gender == null || job.isEmpty() || salary.isEmpty() ||
                phone.isEmpty() || email.isEmpty() || idCardNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!age.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Age must be a positive integer.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!salary.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "Invalid salary format. Use numbers.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!phone.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be 11 digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("\\w+@\\w+\\.\\w+")) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!idCardNumber.matches("\\d{13}")) {
            JOptionPane.showMessageDialog(this, "ID card number must be 16 digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Conn conn = new Conn();
            String query = "INSERT INTO employee VALUES('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + idCardNumber + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Employee Added Successfully");
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}