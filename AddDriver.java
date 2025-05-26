package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton add,cancel;
     JTextField tfname,tfage,tflocation;
     JComboBox gendercombo,availablecombo,carType,carmodel;
    
    AddDriver(){
        setTitle("Driver's Form");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        heading.setBounds(150,10,200,40);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Raleway",Font.PLAIN,16));
        lblname.setBounds(60,70,120,30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        
        JLabel lblage = new JLabel("Age");
       lblage.setFont(new Font("Raleway",Font.PLAIN,16));
       lblage.setBounds(60,110,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        
        JLabel lblclean = new JLabel("Gender");
       lblclean.setFont(new Font("Raleway",Font.PLAIN,16));
       lblclean.setBounds(60,150,120,30);
        add(lblclean);
        
        String cleanOption[]= {"Male","Female"};
        gendercombo = new JComboBox(cleanOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
         JLabel lblprice = new JLabel("Car Models ");
        lblprice.setFont(new Font("Raleway",Font.PLAIN,16));
        lblprice.setBounds(60,190,120,30);
        add(lblprice);
        
      carType = new JComboBox(new String[]{"Swift","I20","Creta","TATA-Punch","Bolero","Innova Crysta","Fortuner","WR-V","Amaze","Kia-Sonet","Kia-carens","Kwid","Superb","Virtus","Hector","Compass","Rolls-Royce Phantom","Rolls-Royce Ghost","Verna"});
      carType.setBounds(200,190,150,30);
        carType.setBackground(Color.WHITE);
        add(carType);
        
        JLabel lbltype = new JLabel("Car Company");
       lbltype.setFont(new Font("Raleway",Font.PLAIN,16));
       lbltype.setBounds(60,230,120,30);
        add(lbltype);
        
      carmodel = new JComboBox(new String[]{"Maruti suzuki","Hyundai","Tata Motors","Rolls-Royce","Mahindra","Toyota","Honda","Kia","Renault","Skoda","Volkswagen","MG Motor","Nissan","Jeep"});
        carmodel.setBounds(200,230,150,30);
        carmodel.setBackground(Color.WHITE);
        add(carmodel);
        
        JLabel lblavailable = new JLabel("Available");
       lblavailable.setFont(new Font("Raleway",Font.PLAIN,16));
       lblavailable.setBounds(60,270,120,30);
        add(lblavailable);
        
        String driverOptions[]= {"Available","Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
       lbllocation.setFont(new Font("Raleway",Font.PLAIN,16));
       lbllocation.setBounds(60,310,120,30);
        add(lbllocation);
        
          tflocation = new JTextField();
       tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setBounds(60,370,130,30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,370,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
      Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(400,30,500,300);
      add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      
        if(ae.getSource()== add){
           
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = (String) carType.getSelectedItem();
            String model =(String) carmodel.getSelectedItem();
            String available = (String) availablecombo.getSelectedItem() ;
            String location = tflocation.getText();
         try{
             Conn conn = new Conn();
             String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+model+"','"+company+"','"+available+"','"+location+"')";
             
             conn.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"New Driver Added Successfully ! ");
             
             setVisible(false);
         }catch(Exception e){
             System.out.println(e);
         }   
            
        }else if(ae.getSource()== cancel) {
            setVisible(false);
        }
    }


    public static void main(String args[]) {
       new AddDriver();
}
}
