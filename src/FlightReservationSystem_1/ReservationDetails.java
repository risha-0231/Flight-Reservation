package FlightReservationSystem_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ReservationDetails extends JFrame implements ActionListener {
    JTextField tfaadhar;
    JLabel tfname,tfage, lblsrc,lbldest,labelfname,labelfcode,labeldate,tfpnr;
    JButton fetch;
    public ReservationDetails() {

        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("FLIGHT");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.WHITE);
        heading.setOpaque(true);
        getContentPane().add(heading);
        heading.setBounds(380, 10, 450, 30);

        JLabel subheading = new JLabel("Reservation Details");
        subheading.setFont(new Font("Arial", Font.BOLD, 25));
        subheading.setForeground(Color.BLACK);
        getContentPane().add(subheading);
        subheading.setBounds(360, 50, 300, 27);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        aadhar.setForeground(Color.BLACK);
        aadhar.setBounds(10, 100, 300, 30);
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(140,100,250,30);
        add(tfaadhar);

        fetch = new JButton("Enter");
        fetch.setBackground(Color.WHITE);
        fetch.setForeground(Color.BLACK);
        fetch.setBounds(500,100,300,30);
        fetch.addActionListener(this);
        add(fetch);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        name.setForeground(Color.BLACK);
        add(name);
        name.setBounds(10, 140, 300, 30);

        tfname = new JLabel();
        tfname.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        tfname.setBounds(250,140,300,30);
        add(tfname);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        age.setForeground(Color.BLACK);
        add(age);
        age.setBounds(10, 180, 300, 30);

        tfage = new JLabel();
        tfage.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        tfage.setBounds(250,180,300,30);
        add(tfage);

        JLabel address = new JLabel("Source");
        address.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        address.setForeground(Color.BLACK);
        add(address);
        address.setBounds(10, 220, 300, 30);

        lblsrc = new JLabel();
        lblsrc.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblsrc.setBounds(250,220,300,30);
        add(lblsrc);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        lblfname.setBounds(10, 300, 150, 25);

        labelfname = new JLabel();
        labelfname.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        labelfname.setBounds(250,300,300,30);
        add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblfcode.setForeground(Color.BLACK);
        add(lblfcode);
        lblfcode.setBounds(10, 340, 300, 30);

        labelfcode = new JLabel();
        labelfcode.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        labelfcode.setBounds(250,340,300,30);
        add(labelfcode);

        JLabel lblgender = new JLabel("Destination");
        lblgender.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblgender.setBounds(10, 260, 300, 30);
        add(lblgender);

        lbldest = new JLabel();
        lbldest.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lbldest.setBounds(250, 260, 300, 30);
        add(lbldest);


        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lbldate.setForeground(Color.BLACK);
        add(lbldate);
        lbldate.setBounds(10, 380, 300, 30);

        labeldate = new JLabel();
        labeldate.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        labeldate.setBounds(250,380,300,30);
        add(labeldate);

        JLabel lblpnr = new JLabel("PNR");
        lblpnr.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        lblpnr.setBounds(10, 420, 300, 30);
        add(lblpnr);

        tfpnr = new JLabel();
        tfpnr.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        tfpnr.setBounds(250, 420, 300, 30);
        add(tfpnr);

        setSize(1000, 500);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String aadhar = tfaadhar.getText();
        try {
            Connect con = new Connect();
            String query = "select * from reservation1 where aadhar='" + aadhar + "'";
            ResultSet rs = con.s.executeQuery(query);
            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                tfage.setText(rs.getString("age"));
                lblsrc.setText(rs.getString("source"));
                lbldest.setText(rs.getString("destination"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
                tfpnr.setText(rs.getString("pnr"));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ReservationDetails();
    }
}
