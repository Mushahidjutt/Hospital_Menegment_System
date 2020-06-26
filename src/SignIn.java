import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   // Include API and other Library
import java.io.*;



public class SignIn<fileWritter, bufferedWritter> extends JFrame implements ActionListener{  // Class SignIn
    private JButton btnForMenu;// Private Attribute
    public SignIn()
    {  // Constructor


        setTitle("Hospital Management System ");  // Title
        setBounds(200,100,1100,700);  // Bounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Close the GUI when Exit
        ImageIcon pic= new ImageIcon("logo.png");  // Logo
        setIconImage(pic.getImage());
        setLayout(null);  // Set Layout
        JLabel signIn= new JLabel("Sign In Here");    // Label for Sign In
        signIn.setBounds(500,50,550, 80);
        Font fontSignIn= new Font("Arial", Font.BOLD, 24);  // Font
        signIn.setFont(fontSignIn);
        signIn.setForeground(Color.BLUE);  // Color
        add(signIn);

        // Label for ID
        JLabel setSignInId= new JLabel("ID");     // Text (Name)
        setSignInId.setBounds(200, 120,200,200); // Bounds
        Font setIdFont= new Font("Times New Romans", Font.ITALIC, 16);
        setSignInId.setFont(setIdFont); // Font
        setSignInId.setForeground(Color.BLACK);  // Color
        add(setSignInId);  // Gain the Memory
//        Text Field For ID
        JTextField textId= new JTextField();
        textId.setBounds(240,206,230, 30);  // Bounds
        Font textIdFont= new Font("Arial", Font.ITALIC, 20);
        textId.setFont(textIdFont);// Font
        textId.setForeground(Color.BLACK);  // Color
        add(textId);
                     // Label For Password
        JLabel setSignInPassword= new JLabel("Password");  // Label Name
        setSignInPassword.setBounds(180, 180,200,200); // Bounds
        Font setSignInPasswordFont= new Font("Times New Romans", Font.ITALIC, 14);
        setSignInPassword.setFont(setSignInPasswordFont); // Font
        setSignInPassword.setForeground(Color.BLACK); // Color
        add(setSignInPassword);
   // Text Field for Password
        JPasswordField setTextSignInPassword= new JPasswordField();
        setTextSignInPassword.setBounds(270,270,200, 30);
        Font setTextSignInPasswordFont= new Font("Arial", Font.BOLD, 16); // Font
        setTextSignInPassword.setFont(setTextSignInPasswordFont);
        setTextSignInPassword.setForeground(Color.BLACK); // Color
        add(setTextSignInPassword); // Gain the MEmory

// Code of Button

        btnForMenu = new JButton("Sign In");  // Button Name
        btnForMenu.setBounds(280,320,180, 30);   // Bounds
        btnForMenu.addActionListener(this);  // Action Listener
        add(btnForMenu);  // Gain the Memory




        setVisible(true);  // Show the Interface on Screen

    }

    public static void main(String[] args) {
        new SignIn();
    }  // MAin Function


    @Override
    public void actionPerformed(ActionEvent e) {   // Action Performed By Button
        if (e.getSource()==btnForMenu)
        {
            dispose();  // Close the Current Screen
            new Login();  // Go to Class Login
        }
    }
}