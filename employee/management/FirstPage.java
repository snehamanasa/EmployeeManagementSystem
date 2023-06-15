package employee.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener {
    FirstPage()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT");
        JLabel heading1 = new JLabel("SYSTEM");
        heading1.setBounds(700,80,1500,60);
        heading.setBounds(490,25,2000,60);
        heading.setFont(new Font("Georgia",Font.BOLD,40));
        heading.setForeground(Color.BLACK);
        heading1.setFont(new Font("Georgia",Font.BOLD,40));
        heading1.setForeground(Color.BLACK);

        add(heading);
        add(heading1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1100,650);
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400,520,200,50);
        clickhere.setBackground(Color.WHITE);
        clickhere.setForeground(Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);

        setSize(1100,650);
        setLocation(100,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String args[]){
        new FirstPage();
    }
}
