import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 28));
        titlePanel.add(titleLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JButton reservationListButton = new JButton("Reservation Listing");
        reservationListButton.setFont(new Font("Arial", Font.BOLD, 19));
        reservationListButton.setBackground(new Color(242, 150, 13));
        reservationListButton.setForeground(Color.WHITE);
       
        JButton newReservationButton = new JButton("Create New Reservation");
        newReservationButton.setFont(new Font("Arial", Font.BOLD, 19));
        newReservationButton.setBackground(new Color(242, 150, 13));
        newReservationButton.setForeground(Color.WHITE);
       
        reservationListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openReservationListing();
            }
        });

        newReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openNewReservation();
            }
        });

        buttonPanel.add(reservationListButton);
        buttonPanel.add(newReservationButton);

        // Adding panels to frame
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void openReservationListing() {
        Reservation reservationListingScreen = new Reservation();
        reservationListingScreen.setVisible(true);
        dispose(); 
    }

    private void openNewReservation() {
        Customer customerScreen = new Customer("");
        customerScreen.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }
}
