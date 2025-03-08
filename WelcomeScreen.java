import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



public class WelcomeScreen extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
 

    private HashMap<String, String> credentials;

    public WelcomeScreen() {
        setTitle("Welcome to EPICUREAN EATS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        credentials = new HashMap<>();
        credentials.put("admin", "password");   

        JLabel lblWelcome = new JLabel("Welcome to Epicurean Eats!");
        lblWelcome.setFont(new Font("Georgia", Font.BOLD, 28));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setForeground(Color.WHITE);

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(20);
        lblUsername.setFont(new Font("Georgia", Font.BOLD, 12));
        lblUsername.setForeground(Color.WHITE);


        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(20);
        lblPassword.setFont(new Font("Georgia", Font.BOLD, 12));
        lblPassword.setForeground(Color.WHITE);



        
        /**
         * Represents the Login button on the Welcome Screen.
         * When clicked, it validates the entered username and password
         * and opens the Customer Screen if the credentials are correct.
         * Otherwise, it displays an error message.
         */
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the username and password
                if (validateCredentials(txtUsername.getText(), new String(txtPassword.getPassword()))) {
                    // Open the Customer screen if credentials are correct
                    openMainMenu();
                } else {
                    // Display error message if credentials are incorrect
                    JOptionPane.showMessageDialog(WelcomeScreen.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add hover effect
    btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnLogin.setBackground(new Color(255, 204, 0));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnLogin.setBackground(UIManager.getColor("control"));  // Reset to default color
    }
    });

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color( 222, 184, 135)); 
        
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUsername)
                                        .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addContainerGap(50, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(160, Short.MAX_VALUE)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(160, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblWelcome)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername)
                                        .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private boolean validateCredentials(String username, String password) {
        // Check if the entered username exists in the credentials map,
        // and if its corresponding password matches the entered password
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    // private void openCustomerScreen() {
    //     // Open the Customer screen

    //     Customer customerScreen = new Customer("");
    //     //customerScreen.setVisible(true);
    //     dispose(); // Close the current welcome screen
    // }

    private void openMainMenu() {
        MainMenu mainMenu = new MainMenu(); 
        mainMenu.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            welcomeScreen.setVisible(true);
            
        });
    }
}
