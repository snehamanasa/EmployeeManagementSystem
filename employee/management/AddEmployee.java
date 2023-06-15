package employee.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add,back;

    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/light4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(400,30,500,50);
        heading.setFont(new Font("Georgia",Font.BOLD,25));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(150,150,150,30);
        labelname.setForeground(Color.BLACK);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        image.add(labelname);

        tfname = new JTextField();
        tfname.setBounds(300,150,150,30);
        image.add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(500,150,150,30);
        labelfname.setForeground(Color.BLACK);
        labelfname.setFont(new Font("serif",Font.BOLD,20));
        image.add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(700,150,150,30);
        image.add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(150,200,150,30);
        labeldob.setForeground(Color.BLACK);
        labeldob.setFont(new Font("serif",Font.BOLD,20));
        image.add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(300,200,150,30);
        image.add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(500, 200, 150, 30);
        labelsalary.setForeground(Color.BLACK);
        labelsalary.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(700, 200, 150, 30);
        image.add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(150, 250, 150, 30);
        labeladdress.setForeground(Color.BLACK);
        labeladdress.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(300, 250, 150, 30);
        image.add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(500, 250, 150, 30);
        labelphone.setForeground(Color.BLACK);
        labelphone.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(700, 250, 150, 30);
        image.add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(150, 300, 150, 30);
        labelemail.setForeground(Color.BLACK);
        labelemail.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(300, 300, 150, 30);
        image.add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(500, 300, 250, 30);
        labeleducation.setForeground(Color.BLACK);
        labeleducation.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labeleducation);

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(700, 300, 150, 30);
        image.add(cbeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(150, 350, 150, 30);
        labeldesignation.setForeground(Color.BLACK);
        labeldesignation.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(300, 350, 150, 30);
        image.add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(500, 350, 150, 30);
        labelaadhar.setForeground(Color.BLACK);
        labelaadhar.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(700, 350, 150, 30);
        image.add(tfaadhar);

        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(150, 400, 150, 30);
        labelempId.setForeground(Color.BLACK);
        labelempId.setFont(new Font("serif", Font.BOLD, 20));
        image.add(labelempId);

        lblempId = new JLabel("" + number);
        lblempId.setBounds(300, 400, 150, 30);
        lblempId.setForeground(Color.BLACK);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        image.add(lblempId);

        add = new JButton("Add Details");
        add.setBounds(370, 500, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        image.add(add);

        back = new JButton("Back");
        back.setBounds(560, 500, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        image.add(back);

        setSize(1100,650);
        setLocation(100,20);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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

    public static void main(String[] args){
        new AddEmployee();
    }
}
