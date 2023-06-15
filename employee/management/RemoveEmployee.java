package employee.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpId;
    JButton delete, back;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setForeground(Color.BLACK);
        labelempId.setFont(new Font("Georgia",Font.BOLD,22));
        labelempId.setBounds(50, 190, 150, 30);
        add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(242, 197, 158, 33);
        add(cEmpId);

        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setFont(new Font("Georgia",Font.BOLD,22));
        labelname.setBounds(50, 253, 150, 30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(250, 250, 100, 40);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setFont(new Font("Georgia",Font.BOLD,22));
        labelphone.setBounds(50, 303, 150, 30);
        add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(250, 300, 100, 40);
        add(lblphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setFont(new Font("Georgia",Font.BOLD,22));
        labelemail.setBounds(50, 353, 150, 30);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(250, 350, 200, 40);
        add(lblemail);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(100, 450, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(250, 450, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(190, 0, 1100, 650);
        add(image);


        setSize(1100,650);
        setLocation(100,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
