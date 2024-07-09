package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton view,add,update,remove,attendance;
    Home(){
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(995, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,995,630);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("Raleway", Font.BOLD,25));
        heading.setBounds(550,45,400,40);
        
        add = new JButton("Add Employee");
        add.setBounds(570,110,150,40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(740,110,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(570,170,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(740,170,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        attendance = new JButton("Attendance Employee");
        attendance.setBounds(650,230,170,40);
        attendance.addActionListener(this);
        image.add(attendance);
        
        image.add(heading);
        
        
        setSize(995, 650);
        setLocation(150, 35);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()== view){
            setVisible(false);
            new ViewEmployee();
        }else if (ae.getSource()==update){
             setVisible(false);
            new ViewEmployee();
        }else if (ae.getSource()==attendance){
             setVisible(false);
            new Attendence();//akto change korta hoba.
        }
        else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String[] args){
        new Home();
    } 
    
}
