package FlightReservationSystem_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    JTextField tfaadhar;
    JLabel tfname,tfage,tfaddress,labelgender,labelfname,labelfcode;
    JButton fetch,flight,bookflight;
    Choice source,dest;
    JDateChooser dc;
    public BookFlight() {

        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Book Flight");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.WHITE);
        heading.setOpaque(true);
        getContentPane().add(heading);
        heading.setBounds(10, 10, 300, 30);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        aadhar.setForeground(Color.BLACK);
        aadhar.setBounds(10, 60, 300, 30);
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(120,60,300,30);
        add(tfaadhar);

        fetch = new JButton("Fetch");
        fetch.setBackground(Color.WHITE);
        fetch.setForeground(Color.BLACK);
        fetch.setBounds(500,60,300,30);
        fetch.addActionListener(this);
        add(fetch);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        name.setForeground(Color.BLACK);
        add(name);
        name.setBounds(10, 100, 300, 30);

        tfname = new JLabel();
        tfname.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        tfname.setBounds(120,100,300,30);
        add(tfname);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        age.setForeground(Color.BLACK);
        add(age);
        age.setBounds(10, 150, 300, 30);

        tfage = new JLabel();
        tfage.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        tfage.setBounds(120,150,300,30);
        add(tfage);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        address.setForeground(Color.BLACK);
        add(address);
        address.setBounds(10, 200, 300, 30);

        tfaddress = new JLabel();
        tfaddress.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        tfaddress.setBounds(120,200,300,30);
        add(tfaddress);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        lblfname.setBounds(10, 400, 300, 30);

        labelfname = new JLabel();
        labelfname.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        labelfname.setBounds(200,400,300,30);
        add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblfcode.setForeground(Color.BLACK);
        add(lblfcode);
        lblfcode.setBounds(10, 450, 300, 30);

        labelfcode = new JLabel();
        labelfcode.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        labelfcode.setBounds(200,450,300,30);
        add(labelfcode);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblgender.setBounds(10, 250, 300, 30);
        add(lblgender);

        labelgender = new JLabel("Gender");
        labelgender.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        labelgender.setBounds(120, 250, 300, 30);
        add(labelgender);

        JLabel lblsource= new JLabel("Source");
        lblsource.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblsource.setBounds(10, 300, 200, 30);
        add(lblsource);

        source = new Choice();
        source.setBounds(300,300,300,30);
        add(source);

        JLabel lbldest = new JLabel("Destination");
        lbldest.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lbldest.setBounds(10, 350, 200, 30);
        add(lbldest);

        dest = new Choice();
        dest.setBounds(300,350,300,30);
        add(dest);

        try{
            Connect con = new Connect();
            String query="select * from flight";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                dest.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        flight = new JButton("Search flights");
        flight.setBackground(Color.DARK_GRAY);
        flight.setForeground(Color.WHITE);
        flight.setBounds(650, 320, 150, 30);
        flight.addActionListener(this);
        add(flight);

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lbldate.setForeground(Color.BLACK);
        add(lbldate);
        lbldate.setBounds(10, 500, 300, 30);

        dc = new JDateChooser();
        dc.setBounds(300,500,300,30);
        add(dc);

        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.DARK_GRAY);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(200, 550, 150, 30);
        bookflight.addActionListener(this);
        add(bookflight);

        setSize(900, 700);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==fetch) {
            String aadhar = tfaadhar.getText();
            try {
                Connect con = new Connect();
                String query = "select * from passenger where aadhar='" + aadhar + "'";
                ResultSet rs = con.s.executeQuery(query);
               if(rs.next()) {
                   tfname.setText(rs.getString("name"));
                   tfage.setText(rs.getString("age"));
                   tfaddress.setText(rs.getString("address"));
                   labelgender.setText(rs.getString("gender"));

               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Aadhar no.");
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource()==flight)
        {
               String src=source.getSelectedItem();
               String des=dest.getSelectedItem();
                try {
                    Connect con = new Connect();
                    String query = "select * from flight where source='" + src + "'and destination='" + des + "'";
                    ResultSet rs = con.s.executeQuery(query);
                    if(rs.next()) {
                        labelfname.setText(rs.getString("fname"));
                        labelfcode.setText(rs.getString("code"));

                    }else{
                        JOptionPane.showMessageDialog(null, "No flights available");
                        setVisible(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
            }
        }else {
            Random rnd = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String age = tfage.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String des = dest.getSelectedItem();
            String ddate = ((JTextField) dc.getDateEditor().getUiComponent()).getText();
            try {
                Connect con = new Connect();
                String query = "insert into reservation1 values('PNR-"+rnd.nextInt(1000000)+"', 'TIC-"+rnd.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+age+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Reservation added");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new BookFlight();
    }
}
