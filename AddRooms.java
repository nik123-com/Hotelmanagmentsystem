package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JButton add,cancel;
     JTextField tfroom,tfprice;
     JComboBox cleancombo,typecombo,availablecombo;
    
    AddRooms(){
        setTitle("Room's Form");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        heading.setBounds(150,20,200,40);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Raleway",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        
        JLabel lblavailable = new JLabel("Room Status");
       lblavailable.setFont(new Font("Raleway",Font.PLAIN,16));
       lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        
        String availableOption[]= {"Available","Occupied"};
        availablecombo = new JComboBox(availableOption);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
        JLabel lblclean = new JLabel("Cleaning Status");
       lblclean.setFont(new Font("Raleway",Font.PLAIN,16));
       lblclean.setBounds(60,180,120,30);
        add(lblclean);
        
        String cleanOption[]= {"Cleaned","Dirty","Vacant","Out of Order"};
        cleancombo = new JComboBox(cleanOption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
         JLabel lblprice = new JLabel("Price (₹)");
        lblprice.setFont(new Font("Raleway",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("Bed Type");
       lbltype.setFont(new Font("Raleway",Font.PLAIN,16));
       lbltype.setBounds(60,280,120,30);
        add(lbltype);
        
        String typeOptions[]= {"King","Queen","Single Bed","Double Bed","Sofa Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        add = new JButton("Add Rooms");
        add.setBounds(60,350,130,30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
      JLabel image = new JLabel(i1);
      image.setBounds(400,30,500,300);
      add(image);
        
        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      
        if(ae.getSource()== add){
           
            String roomnumber = tfroom.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

         try{
             Conn conn = new Conn();
             String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
             
             conn.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"New Room Added Successfully ! ");
             
             setVisible(false);
         }catch(Exception e){
             System.out.println(e);
         }   
            
        }else if(ae.getSource()== cancel) {
            setVisible(false);
        }
    }


    public static void main(String args[]) {
       new AddRooms();
}
}
