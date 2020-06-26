import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;  // Include the API and other Libraries
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {   // Class Login

    private JButton btnPatient;   // Private Buttons
    private JButton btnDoctor;
    private JButton btnRooms;
//    private JButton btnExpenditures;
    private JButton goBackToFront;

    public Login() {                       // Constructor


        setTitle("Hospital Management System ");   // Title
        setBounds(200, 100, 900, 600);  // set the Bounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the Interface when Exit
        ImageIcon pic = new ImageIcon("logo.png");// Logo
        setIconImage(pic.getImage());
        setLayout(null);// Set the Layout

             ////////////////    Heading          ////////////////

        JLabel menuSelect = new JLabel("Select one from the Given Menu"); // Text
        menuSelect.setBounds(20, 0, 550, 80);
        Font menuSelectfont = new Font("Arial", Font.BOLD, 24);  // Font
        menuSelect.setFont(menuSelectfont);
        menuSelect.setForeground(Color.BLUE);// Color
        add(menuSelect);  // Gain the Memory


        ImageIcon backgroundLoginImg = new ImageIcon("loginPic.png");   // Background Pic
        Image img = backgroundLoginImg.getImage();
        Image tempImage = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        backgroundLoginImg = new ImageIcon(tempImage);  // Pass the Object as a Perameter
        JLabel backgroundFrontPage = new JLabel(" ", backgroundLoginImg, JLabel.CENTER);
        backgroundFrontPage.setBounds(0, 0, 900, 600);   // Set bounds
        add(backgroundFrontPage);  // Gaain the Memory

        // Code of Login Panel

        JPanel LoginPage = new JPanel();
        LoginPage.setLayout(null);   // set Layout
        LoginPage.setSize(400, 350);   // set Size
        LoginPage.setBackground(new Color(0, 0, 0, 60));  ///set the Color of our own choice
        LoginPage.setBounds(0, 80, 200, 350); // set the Bounds

 // Code for Patient's Button
        btnPatient = new JButton("Patient");  // Text
        btnPatient.setBounds(10, 120, 120, 30); // Bounds
//        btnPatient.setBackground(new Color(160, 182, 45));
        btnPatient.addActionListener(this);  // Perform the Action
        LoginPage.add(btnPatient); /// Gain the Memory

        // Code for Doctor's Button

        btnDoctor = new JButton("Doctor"); // Text
        btnDoctor.setBounds(10, 160, 120, 30);// Bounds
        btnDoctor.addActionListener(this); // Perform the Action
        LoginPage.add(btnDoctor);// Gain the Memory

        // Code for Doctor's Button

        btnRooms = new JButton("Rooms");// Text
        btnRooms.setBounds(10, 200, 120, 30);// Bounds
        btnRooms.addActionListener(this); // Perform the Action
        LoginPage.add(btnRooms);// Gain the Memory

//        btnExpenditures = new JButton("Expenditures");
//        btnExpenditures.setBounds(10, 240, 120, 30);
//        btnExpenditures.addActionListener(this);
//        LoginPage.add(btnExpenditures);

        // Code for Back's Button

        goBackToFront = new JButton("Logout");   //// Text
        goBackToFront.setBounds(10, 40, 80, 30); // Bounds
        goBackToFront.addActionListener(this);  // Perform the Action
        LoginPage.add(goBackToFront);// Gain the Memory


        backgroundFrontPage.add(LoginPage);  // Panel Gain the Memory


        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }   // Main Function
//

    @Override  // Function Override
    public void actionPerformed(ActionEvent e) {   // Action Performed On the Buttons
        if (e.getSource() == btnPatient) {
            dispose();  // Close the current Screen
            new Patient();  // Go to Patient Screen
        } else if (e.getSource() == goBackToFront) {
            dispose(); // Close the current Screen
            new FrontPage();  // Go to FrontPage Screen
        } else if (e.getSource() == btnRooms) {
            dispose(); // Close the current Screen
            new Room();   // Go to Room Screen
        } else if (e.getSource() == btnDoctor) {
            dispose(); // Close the current Screen
            new Doctor();   // Go to Doctor Screen
        }


    }
}

