
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TakeAttendence extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tffname,tfphone,tfnid,tfemail,tfsalary,tfaddress,tfdesignation,lblfhalf,lblshalf,tfempId;
    JDateChooser date;
    JComboBox First_half,Second_half ;
    JLabel  lblempId,attFirst;
    JButton add,back;
    Choice cemployeeId;
    TakeAttendence(){
      
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        
        JLabel heading = new JLabel("Attendence Section");
        heading.setBounds(280,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labeleducation = new JLabel("Search Your ID");
        labeleducation.setBounds(50,120,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,18));
        add(labeleducation);
        
        
        cemployeeId =new Choice();
        cemployeeId.setBounds(200,120,150,25);
        add(cemployeeId);
       
       
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,180,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200,180,150,25);
        add(tfname);
        
        JLabel attFirst = new JLabel("First Half");
        attFirst.setBounds(50,320,150,30);
        attFirst.setFont(new Font("serif",Font.PLAIN,18));
        add(attFirst);
        
        String Att_1[] ={"Present","Absent"};
        First_half = new JComboBox(Att_1);
        First_half.setBackground(Color.WHITE);
        First_half.setBounds(200,320,150,25);
        add(First_half);
        
        JLabel attSec = new JLabel("Second Half");
        attSec.setBounds(50,390,150,30);
        attSec.setFont(new Font("serif",Font.PLAIN,18));
        add(attSec);
        
        String Att_2[] ={"Present","Absent"};
        Second_half = new JComboBox(Att_1);
        Second_half.setBackground(Color.WHITE);
        Second_half.setBounds(200,390,150,25);
        add(Second_half); 
                
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,250,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,18));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,250,150,25);
        add(tfemail);
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(400,250,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,18));      
        add(labelempId);
       
        lblempId = new JLabel("" +lblempId);      
        lblempId.setBounds(530,250,150,25);
        lblempId.setFont(new Font("serif",Font.PLAIN,18));
        add(lblempId);
       
        JLabel labeldob = new JLabel("Date");
        labeldob.setBounds(400,180,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,18));
        add(labeldob);


        date = new JDateChooser();
        date.setBounds(480,180,150,25);
        add(date);
    
        add = new JButton("Add Attendence");
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
        
         try{
            Conn c =new Conn();
            
            ResultSet rs =c.s.executeQuery("select * from employee");  
          
          while(rs.next()){
              cemployeeId.add(rs.getString("empId"));
                                     
          }
         
        }catch(Exception e){
            e.printStackTrace();
        }
         cemployeeId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empId='"+cemployeeId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        
                        tfname.setText(rs.getString("name"));
                        tfemail.setText(rs.getString("email"));
                        lblempId.setText(rs.getString("empId"));
                        
                       
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
        
            }
         });
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
    String name = tfname.getText();
    String email = tfemail.getText();
    String empId = lblempId.getText();
    String firsthalf =(String)First_half.getSelectedItem();
    String secondhalf =(String)Second_half.getSelectedItem();
    String Date =((JTextField) date.getDateEditor().getUiComponent()).getText();
    
    try{
        Conn conn = new Conn();
        String query = "insert into attendence values('"+name+"','"+email+"','"+firsthalf+"','"+secondhalf+"','"+empId+"','"+Date+"')";
        conn.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Take Attendence Sucessfully");
    setVisible(false);
    new Attendence();
    }catch (Exception e){
    e.printStackTrace();
    }
    
    }else{
    setVisible(false);
        new Attendence();
    }
    
    }

    public static void main(String[] args){
    new TakeAttendence();
    }
}
