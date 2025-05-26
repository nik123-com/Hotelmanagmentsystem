package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice typeofcar;

    Pickup() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Pickup Service");

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        typeofcar = new Choice();
        typeofcar.setBounds(150, 100, 200, 25);
        add(typeofcar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select distinct model from driver");
            while (rs.next()) {
                typeofcar.add(rs.getString("model"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(620, 160, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        table.setTableHeader(null); // ✅ Remove table header
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String selectedModel = typeofcar.getSelectedItem();
                String query = "select * from driver where model = '" + selectedModel + "'";

                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception(); // Reception class should be defined
        }
    }

    public static void main(String args[]) {
        new Pickup();
    }
}
