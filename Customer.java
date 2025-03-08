import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;


/**
 * The Customer class represents a JFrame application for creating new reservations.
 * It provides fields for entering customer information such as name, phone number,
 * email, number of persons, date of reservation, and time of reservation.
 * The class also includes buttons to save the reservation, close the window, and
 * view the restaurant reservation list.
 */

public class Customer extends JFrame {
    private JTextField txtName;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;
    private JTextField txtNumberofPersons;
    private JTextField txtDateofReservation;
    private JTextField txtTimeofReservation;

    private JComboBox<String> ambianceComboBox;
    

    private JButton cmdSave;
    private JButton cmdClose;
    private JButton cmdResturantReservationList;

    private JPanel pnlCommand;
    private JPanel pnlDisplay;

    private Customer thiscus;
    private Reservation thisForm;
    private Reservation Rscreen;
    private WelcomeScreen screen;

    public Customer(String test) {
        setTitle("Create New Reservation");
        //thiscus= this;
        //this.thisForm= thisForm;
        //ReservationListingScreen reslist =new ReservationListingScreen(); 
        //this.thisForm = thisForm;
        //this.thisForm=reslist;
        //this.screen= thisscreen;
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

       
        // Initialize contentPanel and set its background color
        //JPanel contentPanel = new JPanel();
        //contentPanel.setBackground(new Color( 255, 255, 153)); // Light brown color (RGB: 222, 184, 135)

        //add(headerPanel, BorderLayout.NORTH); // Add headerPanel to the top of the frame
        //add(contentPanel, BorderLayout.CENTER); // Add contentPanel to the center of the frame
        
        String[] ambianceOptions = {"Romantic", "Family Gathering", "Friend Group", "Fine Dining", "Outdoor"};
        ambianceComboBox = new JComboBox<>(ambianceOptions);
        ambianceComboBox.setSelectedIndex(0); // Default selection
        pnlCommand.add(ambianceComboBox); // Add to panel

        pnlDisplay.setLayout(new GridLayout(6, 2));

        pnlDisplay.add(new JLabel("Name:"));
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);

       
        pnlDisplay.add(new JLabel("Phone Number:"));
        txtPhoneNumber = new JTextField(20);
        pnlDisplay.add(txtPhoneNumber);

        pnlDisplay.add(new JLabel("Email Address:"));
        txtEmail = new JTextField(20);
        pnlDisplay.add(txtEmail);

        pnlDisplay.add(new JLabel("Number of Persons:"));
        txtNumberofPersons = new JTextField(20);
        pnlDisplay.add(txtNumberofPersons);

        pnlDisplay.add(new JLabel("Date of Reservation:"));
        txtDateofReservation = new JTextField(20);
        pnlDisplay.add(txtDateofReservation);

        pnlDisplay.add(new JLabel("Time of Reservation:"));
        txtTimeofReservation = new JTextField(20);
        pnlDisplay.add(txtTimeofReservation);

        cmdSave = new JButton("Save");
        cmdSave.setBackground(new Color(255, 204, 0));  
        cmdSave.setForeground(Color.WHITE);  

        //String selectedAmbiance = (String) ambianceComboBox.getSelectedItem();


        cmdClose = new JButton("Close");
        cmdClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdClose.setBackground(new Color(230, 66, 25));  // Set your desired color
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdClose.setBackground(UIManager.getColor("control"));  // Reset to default color
            }
        });
        
        cmdResturantReservationList = new JButton("Restaurant Reservation List");
        cmdResturantReservationList.setBackground(new Color(204, 102, 0));  // Change to your desired color
        cmdResturantReservationList.setForeground(Color.WHITE);  // Change to your desired color

        cmdSave.addActionListener(new SaveButtonListener());
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Action listener for the Restaurant Reservation List button

        cmdResturantReservationList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Show Restaurant Reservation List");
                // Directly create and display a new ReservationListingScreen instance
                //ReservationListingScreen reservationListingScreen = new ReservationListingScreen();
                //thisForm.setVisible(true);
                openResScreen();
            }
        
        });

        // cmdResturantReservationList.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
                
        //         // You need to implement what should happen when this button is clicked.
        //         // For example, open a new window or display a list of restaurant reservations.
        //         //JOptionPane.showMessageDialog(null, "Show Restaurant Reservation List");
        //         ReservationListingScreen cancelRes = new ReservationListingScreen();
        //         cancelRes.setVisible(true);
        //         //JOptionPane.
        //     }
        // });
        

        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);
        pnlCommand.add(cmdResturantReservationList);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);


        
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = txtName.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String email = txtEmail.getText();
            String numberOfPersons = txtNumberofPersons.getText();
            String dateofReservation= txtDateofReservation.getText();
            String timeOfReservation = txtTimeofReservation.getText();
            // String selectedAmbiance=ambianceOp.getEditor();
            String selectedAmbiance = (String) ambianceComboBox.getSelectedItem();


            int numperson= 0;

            try{
                numperson =Integer.parseInt(numberOfPersons);
            }catch(NumberFormatException ex){
            }

            // Basic validation
            if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || numberOfPersons.isEmpty()
                    || timeOfReservation.isEmpty()) {
                JOptionPane.showMessageDialog(Customer.this, "Please fill in all fields.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                CustomerInfo person = new CustomerInfo(name, phoneNumber, email, numperson, dateofReservation, timeOfReservation, selectedAmbiance);
                // Assuming a ReservationListingScreen class is available
                if (thisForm != null) { // Add a null check before invoking methods on thisForm
                    thisForm.addPerson(person);
                }
                //thisForm.addPerson(person);

            // Optionally, you can clear the fields after saving
            clearFields();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ResList.txt", true))) {
                writer.write(person.getName() + " " + person.getnNum()+ " "+ person.getMail()+
                " "+ person.getRes()+ " "+ person.getDate()+ " "+ person.getTime()+" "+ person.getAmbiance());
                writer.newLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to save person data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Additional validation for email and number of persons can be added here
            //Points point=new Points("");
        }
    }

    private void openResScreen() {
        // Open the Customer screen
        
        // ReservationListingScreen resScreen = new ReservationListingScreen();
        // resScreen.setVisible(true);
        Reservation res= new Reservation();
        res.setVisible(true);
        dispose(); // Close the current welcome screen
    }


    

    private void clearFields() {
        txtName.setText("");
        txtPhoneNumber.setText("");
        txtEmail.setText("");
        txtNumberofPersons.setText("");
        txtTimeofReservation.setText("");
    }

    //  public static void main(String[] args) {
    //     //ReservationListingScreen reservationListingScreen = new ReservationListingScreen();
    //     new Customer("");
    //     // new Customer(this);
    //  }
}