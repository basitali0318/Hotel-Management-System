package University.work.OOP.Project.HotelManagmentSystem;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JTextField user ;
    JPasswordField pass;
    JButton login,cancel;

    Login(){
        getContentPane().setBackground(java.awt.Color.WHITE);
        setLayout(null);
        setResizable(false);
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);
        user = new JTextField();
        user.setBounds(150, 20, 150, 30);
        add(user);
         pass = new JPasswordField();
        pass.setBounds(150, 70, 150, 30);
        add(pass);
         login = new JButton("Login");
        login.setBackground(java.awt.Color.BLACK);
        login.setForeground(java.awt.Color.WHITE);
        login.setBounds(40, 140, 120, 30);
        login.addActionListener(this);
        add(login);
        cancel = new JButton("Cancel");
        cancel.setBackground(java.awt.Color.BLACK);
        cancel.setForeground(java.awt.Color.WHITE);
        cancel.setBounds(180, 140, 120, 30);
        cancel.addActionListener(this);
        add(cancel);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\second.jpg");
        Image i2   = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);


    setBounds(500,200,600,300);
setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = user.getText();
            String password = new String(pass.getPassword()); // Get the password as a string

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both username and password.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}