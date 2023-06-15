package employee.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tfusername,tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(180,210,300,40);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(340,220,165,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(180,260,300,40);
        lblpassword.setForeground(Color.WHITE);
        lblpassword.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(340,270,165,30);
        add(tfpassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(250,330,160,40);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image4.png"));
        Image i2 = i1.getImage().getScaledInstance(1100,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1100,650);
        add(image);

        setSize(1000,600);
        setLocation(180,35);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        try{
         String username = tfusername.getText();
         String password = tfpassword.getText();

         Conn c = new Conn();
         String query = "select * from login where username = '"+username+"' and password = '"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            } else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        new Login();
    }
}
