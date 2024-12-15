package FlightReservationSystem_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home extends JFrame implements ActionListener{

    public Home() {
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading= new JLabel("WELCOME TO FLIGHT RESERVATION SYSTEM");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(250, 40, 1000, 40);
        add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightdetails = new JMenuItem("Flight details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);

        JMenuItem customerdetails = new JMenuItem("Customer details");
        customerdetails.addActionListener(this);
        details.add(customerdetails);

        JMenuItem reservationdetails = new JMenuItem("Reservation details");
        reservationdetails.addActionListener(this);
        details.add(reservationdetails);

        JMenu booking = new JMenu("Booking");
        menubar.add(booking);


        JMenuItem bookflight = new JMenuItem("Book flight");
        bookflight.addActionListener(this);
        booking.add(bookflight);

        JMenuItem journeydetails = new JMenuItem("Journey details");
        journeydetails.addActionListener(this);
        details.add(journeydetails);

        JMenuItem cancelflight = new JMenuItem("Cancel flight");
        cancelflight.addActionListener(this);
        booking.add(cancelflight);

        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem bp = new JMenuItem("Boarding Pass");
        bp.addActionListener(this);
        ticket.add(bp);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(500,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if(command.equals("Customer details")) {
            new AddCustomer();
        }else if(command.equals("Flight details")) {
            new FlightInfo();
        }else if(command.equals("Book flight")) {
            new BookFlight();
        }else if(command.equals("Journey details")) {
            new JourneyDetails();
        }else if(command.equals("Cancel flight")) {
            new Cancel();
        }else if(command.equals("Boarding Pass")) {
            new BoardingPass();
        }else if(command.equals("Reservation details")) {
            new ReservationDetails();
        }

    }

    public static void main(String[] args) {
        new Home();

    }

}
