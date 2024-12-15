package FlightReservationSystem_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblpnr=new JLabel("PNR details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpnr.setForeground(Color.BLACK);
        lblpnr.setBounds(10, 10, 300, 30);
        add(lblpnr);

        table = new JTable();

        pnr = new JTextField();
        pnr.setBounds(10, 50, 300, 30);
        add(pnr);

        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(10, 80, 300, 30);
        show.addActionListener(this);
        add(show);



        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        jsp.setBackground(Color.WHITE);
        add(jsp);

        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Connect conn = new Connect();

            ResultSet rs = conn.s.executeQuery("select * from reservation1 where PNR='"+pnr.getText()+"'");

            if(!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "PNR not found");
                return;
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}