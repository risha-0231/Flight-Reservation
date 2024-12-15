package FlightReservationSystem_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton reset,submit,close;
    JTextField tfuser;
    JPasswordField tfpswd;
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbluser= new JLabel("Username");
        lbluser.setBounds(20,20,80,20);
        add(lbluser);

        tfuser=new JTextField();
        tfuser.setBounds(130,20,200,20);
        add(tfuser);

        JLabel lblpswd= new JLabel("Password");
        lblpswd.setBounds(20,40,80,20);
        add(lblpswd);
        tfpswd=new JPasswordField();
        tfpswd.setBounds(130,40,200,20);
        add(tfpswd);

        reset=new JButton("Reset");
        reset.setBounds(40,120,80,20);
        reset.addActionListener(this);
        add(reset);
        submit=new JButton("Submit");
        submit.setBounds(140,120,80,20);
        submit.addActionListener(this);
        add(submit);
        close=new JButton("Close");
        close.setBounds(240,120,80,20);
        close.addActionListener(this);
        add(close);


        setSize(400,250);
        setLocation(500,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username =tfuser.getText();
            String password =tfpswd.getText();

            try {
                Connect c = new Connect();

                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    System.out.println("else");
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        } else if (ae.getSource() == close) {System.out.println("close");
            setVisible(false);
        } else if (ae.getSource() == reset) {System.out.println("reset");
            tfuser.setText("");
            tfpswd.setText("");
        }System.out.println("end");
    }

    public static void main(String[] args) {
        new Login();

    }

}