
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tffname,tfphone,tfnid,tfemail,tfsalary,tfaddress,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId ;
    JButton add,back;
    AddEmployee(){
      
        
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(280,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,120,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(170,125,150,25);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(390,120,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(580,125,150,25);
        add(tffname);
        
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,180,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,18));
        add(labeldob);
        
       dcdob = new JDateChooser();
       dcdob.setBounds(170,185,150,25);
       add(dcdob);
       
       
       JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(390,180,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,18));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(580,185,150,25);
        add(tfsalary);
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,240,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,18));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(170,245,150,25);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(390,240,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,18));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(580,245,150,25);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,18));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(170,305,150,25);
        add(tfemail);
        
        
         JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(390,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,18));
        add(labeleducation);
        
        String courses[] ={"BBA","BCA","BA","BSC","B.COM","BTech","MBA","MCA","MA","MTech","MSC","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(580,310,150,25);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,360,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,18));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(170,365,150,25);
        add(tfdesignation);
        
        JLabel labelnid = new JLabel("NID No");
        labelnid.setBounds(390,360,150,30);
        labelnid.setFont(new Font("serif",Font.PLAIN,18));
        add(labelnid);
        
        tfnid = new JTextField();
        tfnid.setBounds(580,373,150,25);
        add(tfnid);
        
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50,420,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,18));
        add(labelempId);
        
        lblempId = new JLabel("" +number);
        lblempId.setBounds(170,425,150,25);
        lblempId.setFont(new Font("serif",Font.PLAIN,18));
        add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250,480,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,480,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
       
        setSize(800,600);
        setLocation(225,30);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
    String name = tfname.getText();
    String fname = tffname.getText();
    String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
    String salary = tfsalary.getText();
    String address = tfaddress.getText();
    String phone = tfphone.getText();
    String email = tfemail.getText();
    String education = (String)cbeducation.getSelectedItem();
    String designation = tfdesignation.getText();
    String nid = tfnid.getText();
    String empId = lblempId.getText();
    
    try{
        Conn conn = new Conn();
        String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+nid+"','"+empId+"')";
    conn.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Details added successfully");
    setVisible(false);
    new Home();
    }catch (Exception e){
    e.printStackTrace();
    }
    
    }else{
    setVisible(false);
    new Home();
    }
    
    }

    public static void main(String[] args){
    new AddEmployee();
    }
}
