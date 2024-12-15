package FlightReservationSystem_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfphone,tfaadhar,tfaddress;
    JRadioButton rbmale,rbfemale;
    public AddCustomer() {

        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add Customer");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.WHITE);
        heading.setOpaque(true);
        getContentPane().add(heading);
        heading.setBounds(10, 10, 300, 30);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        name.setForeground(Color.BLACK);
        add(name);
        name.setBounds(10, 50, 300, 30);

        tfname = new JTextField();
        tfname.setBounds(120,50,300,30);
        add(tfname);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        age.setForeground(Color.BLACK);
        add(age);
        age.setBounds(10, 100, 300, 30);

        tfage = new JTextField();
        tfage.setBounds(120,100,300,30);
        add(tfage);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        address.setForeground(Color.BLACK);
        add(address);
        address.setBounds(10, 150, 300, 30);

        tfaddress = new JTextField();
        tfaddress.setBounds(120,150,300,30);
        add(tfaddress);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        gender.setForeground(Color.BLACK);
        gender.setBounds(10, 200, 300, 30);
        add(gender);

        ButtonGroup bg = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(120,200,130,30);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270,200,130,30);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel phone = new JLabel("Phone No.");
        phone.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        phone.setForeground(Color.BLACK);
        phone.setBounds(10, 250, 300, 30);
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(120,250,300,30);
        add(tfphone);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        aadhar.setForeground(Color.BLACK);
        aadhar.setBounds(10, 300, 300, 30);
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(120,300,300,30);
        add(tfaadhar);

        JButton save = new JButton("Save");
        save.setBackground(Color.DARK_GRAY);
        save.setForeground(Color.WHITE);
        save.setBounds(10, 350, 300, 30);
        save.addActionListener(this);
        add(save);

        setSize(900, 600);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender=null;
        if(rbmale.isSelected())
            gender="Male";
        else
            gender="Female";
        try{
            Connect con = new Connect();
            String query="insert into passenger values('"+name+"','"+age+"','"+address+"','"+gender+"','"+phone+"','"+aadhar+"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
         new AddCustomer();
    }
}
