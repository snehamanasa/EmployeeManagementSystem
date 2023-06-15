package employee.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    JButton view, add,update,remove;


    Home(){
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image9.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);


        //JLabel heading1 = new JLabel("EMPLOYEE MANAGEMENT");
        //heading1.setBounds(520,40,1400,70);
        //heading1.setFont(new Font("Georgia",Font.PLAIN,40));
        //heading1.setForeground(Color.WHITE);
        //image.add(heading1);

        add = new JButton("Add Employee");
        add.setBounds(650,200,350,50);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(650,270,350,50);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650,340,350,50);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(650,410,350,50);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1100,650);
        setLocation(100,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
             new AddEmployee();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }
        else {
            setVisible(false);
            new RemoveEmployee();
        }

    }

    public static void main(String[] args){

        new Home();
    }
}
