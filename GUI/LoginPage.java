package GUI;
import javax.swing.*;
import java.awt.*;
import Entity.*;
import EntityList.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginPage extends JFrame implements ActionListener {
 
    Font titleFont = new Font("Cambria", Font.BOLD, 30);
    Font font15 = new Font("Cambria", Font.BOLD, 15);
    Font font20 = new Font("Cambria", Font.BOLD, 20);
 
    JLabel titleLabel, userLabel, passLabel;
    JTextField userTextField;
    JPasswordField passTextField;
    JButton loginButton, resetButton;
 
    public LoginPage() {
        super("Login Page");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);  // Width, Height
        this.setLocation(400, 200);  // X, Y
        this.getContentPane().setBackground(new Color(218, 232, 252));
        this.setLayout(null);
 
        // Title
        titleLabel = new JLabel("Login to Cartio");
        titleLabel.setBounds(100, 20, 250, 40);
        titleLabel.setFont(titleFont);
 
        // Username Label
        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 80, 100, 30);
        userLabel.setFont(font15);
 
        // Username Text Field
        userTextField = new JTextField();
        userTextField.setBounds(150, 80, 200, 30);
        userTextField.setFont(font15);
 
        // Password Label
        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 120, 100, 30);
        passLabel.setFont(font15);
 
        // Password Field
        passTextField = new JPasswordField();
        passTextField.setBounds(150, 120, 200, 30);
        passTextField.setFont(font15);
 
        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 170, 90, 30);
        loginButton.setBackground(Color.GREEN);
        loginButton.setFont(font15);
        loginButton.addActionListener(this);
 
        // Reset Button
        resetButton = new JButton("Reset");
        resetButton.setBounds(260, 170, 90, 30);
        resetButton.setBackground(Color.RED);
        resetButton.setFont(font15);
        resetButton.addActionListener(this);
 
        // Add components to JFrame
        this.add(titleLabel);
        this.add(userLabel);
        this.add(userTextField);
        this.add(passLabel);
        this.add(passTextField);
        this.add(loginButton);
        this.add(resetButton);
 
        // Display the frame
        this.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userTextField.getText();
            String password = new String(passTextField.getPassword());
 
            // Hardcoded credentials for demo purpose
            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                // Open the Product Inventory Page
                new ProductInventoryPage();
                this.dispose();  // Close the login page
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            userTextField.setText("");
            passTextField.setText("");
        }
    }
 
    public static void main(String[] args) {
        new LoginPage();
    }
}