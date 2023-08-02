package University.work.OOP.Project.HotelManagmentSystem;
import java.awt.event.*;
import javax.swing.*;
public class HotelManagmentSystem extends JFrame implements ActionListener {
    HotelManagmentSystem() {
        super("Hotel Managment System");
        setLayout(null);
        setResizable(false);
        setBounds(100, 100, 1366, 565);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1 = new ImageIcon("C:\\Users\\basit\\OneDrive - Higher Education Commission\\Documents\\University work\\OOP Project\\Hotel Managment System\\Images\\first.jpg");
        JLabel Image = new JLabel(i1);
        add(Image);
        Image.setBounds(0,0,1366,565);
        JLabel text = new JLabel("Hotel Managment System");
        text.setBounds(20, 450, 1000, 70);
        text.setForeground(java.awt.Color.WHITE);
        text.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 58));
        Image.add(text);
        JButton next = new JButton("Next");
        next.setBackground(java.awt.Color.WHITE);
        next.setForeground(java.awt.Color.BLACK);
        next.addActionListener(this);
        next.setBounds(1150, 450, 150, 70);
        next.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 26));
        Image.add(next);
        setVisible(true);
        while(true) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            text.setVisible(true);
        }
    }
    public void addPanel(JPanel panel) {
        add(panel);
    }


    public static void main(String[] args) {
        new HotelManagmentSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
}
