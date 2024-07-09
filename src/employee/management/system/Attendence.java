package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Attendence extends JFrame implements ActionListener{
    JButton view,add,back;
    Attendence(){
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/attendence.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);
        
        JLabel heading = new JLabel("Attendence");
        heading.setFont(new Font("Raleway", Font.BOLD,25));
        heading.setForeground(Color.blue);
        heading.setBounds(200,45,400,40);
        
        add = new JButton("Take Attendence");
        add.setBounds(100,220,150,40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Attendence");
        view.setBounds(350,220,150,40);
        view.addActionListener(this);
        image.add(view);
        
        back = new JButton("Back");
        back.setBounds(200,280,150,40);
        back.addActionListener(this);
        image.add(back);
        
        
        image.add(heading);
        
        
        setSize(600, 550);
        setLocation(220, 35);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new TakeAttendence();
        }else if(ae.getSource()== view){
            setVisible(false);
            new ViewAttendence();
        }else if(ae.getSource()== back){
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args){
        new Attendence();
    } 
    
}
