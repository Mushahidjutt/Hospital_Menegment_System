import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;   // Import the Libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FrontPage extends JFrame implements ActionListener {   // Extend with JFram and Implement Api
    private  JButton btnSignUp;   // Declare Private Buttons
    private JButton btnLogin;

    private JTextField setId;  // Declare  Private Text Field

    private JPasswordField textPasswordSignUp;   // Declare Private TextField for Password

    public FrontPage()   // Constructor
    {
        setTitle("Hospital Management System ");    // Title
        setBounds(200,100,900,600);   // Bounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // End of GUI Application
        ImageIcon pic= new ImageIcon("logo.png");  // Hospital Logo
        setIconImage(pic.getImage());  // Fetch the Image
        setLayout(null);  // Set the Layout

  // Heading
        JLabel menu= new JLabel("Green Line Hospital");  // Hospital Name
        menu.setBounds(330,40,550, 80);  // Set Bounds
        Font font= new Font("Arial", Font.BOLD, 24);  // Font
        menu.setFont(font);
        menu.setForeground(Color.BLUE);   // Color
        add(menu);


                //  Set BackGround Picture


        ImageIcon imgBackground= new ImageIcon("background.png");
        Image img= imgBackground.getImage();
        Image temp_image= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        imgBackground = new ImageIcon(temp_image);  // Temporary object
        JLabel background_FrontPage= new JLabel(" ", imgBackground, JLabel.CENTER );
        background_FrontPage.setBounds(0,0,900,600);  // Set Bounds
        add(background_FrontPage);

         // Panel Coding
        JPanel singUpPage= new JPanel();     // Declare and Initialize Panel
        singUpPage.setLayout(null);   // Set Layout  and size below
        singUpPage.setSize(400,350);
        singUpPage.setBackground(new Color(0,0,0,60));   // set Background
        singUpPage.setBounds(250,175,400,350);  // Set Bounds

             // Label for SignUp
        JLabel setNameSignUp= new JLabel("Enter Username");
        setNameSignUp.setBackground(new Color(0,0,0,80));  // Set Background
        setNameSignUp.setBounds(50, 10,300,50);// Set Bounds
        Font setFont= new Font("Times New Romans", Font.ITALIC, 20);
        setNameSignUp.setFont(setFont);  // Set Font
        setNameSignUp.setForeground(Color.BLACK);// Color
        singUpPage.add(setNameSignUp);   // Gain the Memory

        // Set Textfield for Id

        setId= new JTextField();
        setId.setBounds(50,60,300, 40);
        Font setIdFont= new Font("Arial", Font.BOLD, 16);  // Font
        setId.setFont(setIdFont);
        setId.setForeground(Color.BLACK); // Color
        singUpPage.add(setId);   // Gain the Memory




         // Set LAble for Password

        JLabel setPasswordSignUp= new JLabel("Enter Password");  // Text
        setPasswordSignUp.setBackground(new Color(0,0,0,80));   // Backend Color
        setPasswordSignUp.setBounds(50, 110,300,50);  // Bounds
        Font setUFont= new Font("Times New Romans", Font.ITALIC, 20);
        setPasswordSignUp.setFont(setUFont);  // Add Font
        setPasswordSignUp.setForeground(Color.BLACK);
        singUpPage.add(setPasswordSignUp);  // Gain the Memory

        // Set text Area for Password

        textPasswordSignUp= new JPasswordField();
        textPasswordSignUp.setBounds(50,160,300, 40); // Set Bounds
        Font textPasswordSignUpFont= new Font("Arial", Font.BOLD, 16);  // Font
        textPasswordSignUp.setFont(textPasswordSignUpFont);
        textPasswordSignUp.setForeground(Color.BLACK); // Color
        singUpPage.add(textPasswordSignUp);// Gain the Memory

            // Code for Button

         // Sign Up

        btnSignUp= new JButton("Sign Up");
        btnSignUp.setBounds(50,250,100, 50);  // Set Bounds
        btnSignUp.addActionListener(this);
        singUpPage.add(btnSignUp);  // Gain the Memory

   //   Login Button

        btnLogin= new JButton("Login"); // Button Name
        btnLogin.setBounds(200,250,100, 50);  // Bounds
        btnLogin.addActionListener(this);
        singUpPage.add(btnLogin);  // gain the Memory

        background_FrontPage.add(singUpPage);   // Gain Memory of the Whole Page


        setVisible(true);  // Display on Screen

    }

    public static void main(String[] args) {  // Main function of the Class
        new FrontPage();
    }

    @Override   // Function Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSignUp){  // Code Under the Sign Up Button
            if(setId.getText().trim().isEmpty() || textPasswordSignUp.getText().trim().isEmpty())
                JOptionPane.showConfirmDialog(this,"all fields are requied");  // Condition
            else {


                FileWriter writer = null;   // Data Store in the File (Login.txt)
                try {
                    writer = new FileWriter("login.txt",true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                try {
                    bufferedWriter.write(setId.getText().trim()+","+textPasswordSignUp.getText().trim()+"\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                dispose();   // Close the Current PAge

                new Login();   // Object of Login
                try {
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        }

        // Code under the Button(Login)

        else if(e.getSource()==btnLogin){
            if(setId.getText().trim().isEmpty() || textPasswordSignUp.getText().trim().isEmpty())
                JOptionPane.showConfirmDialog(this,"all fields are requied","Message",JOptionPane.PLAIN_MESSAGE);// Condition
      else{
            FileReader reader = null;   // Code to Reade Data from File (Login.txt)
            BufferedReader bufferedReader = null;
            boolean flag = true;
            try {
                reader = new FileReader("login.txt");
                bufferedReader = new BufferedReader(reader);
                String line = null;
                String token[] = null;
                while ((line = bufferedReader.readLine()) != null) {
                    token = line.split(",");
                    if (setId.getText().equals(token[0]) && textPasswordSignUp.getText().equals(token[1])) {
                        dispose();  // Close the current Screen
                        flag = false;
                        Login log = new Login();


                    }
                }
                if(flag)
                {   // Sow the Message according to Given Condition
                    JOptionPane.showInternalConfirmDialog(null,"username or password is in-correct");
                }

            }catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
        }
    }
}    // End of Class   (FrontPage)
