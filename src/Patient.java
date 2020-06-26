import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;   // Api and other Libraries
import java.awt.event.ActionListener;
import java.io.*;
import java.util.EventListener;

public class Patient extends JFrame implements ActionListener {   // class Patient
    private  JButton addPatient;
    private JButton goBackToLogin;
    private JTable pTable;                    //////////////  Private Attributes   /////////////
    private JScrollPane pScrollPane;
    private DefaultTableModel pDefaultTableModel;
    private JTextField setPName;
    private JTextField textPage;
    private JTextField textPDisease;
    private JTextField textPCareTaker;
    private JTextField textPRoomNo;

    public Patient() {
                                     ////////     Constructor   //////////

        setLayout(null);  //set the Layout
        setTitle("Hospital Management System ");        // Title
        setBounds(200,100,900,600); // set Bounds
        setBackground(Color.GRAY);  // Color
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Close the GUI when Exit
        ImageIcon pic= new ImageIcon("logo.png"); // Logo
        setIconImage(pic.getImage());
        try {
                      /////////  Background Pic  //////////

            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("pBack.jpg")))));

        }
        catch (IOException e)
        {                                     // Exception Handling
            e.printStackTrace();
        };

        ////////     Heading  /////////

        JLabel headingLablePatient= new JLabel("Patient Information");   // Text
        headingLablePatient.setBounds(100,50,550, 80);  // Bounds
        Font fontHeadingLablePatient= new Font("Arial", Font.BOLD, 24);
        headingLablePatient.setFont(fontHeadingLablePatient);  // Font
        headingLablePatient.setForeground(Color.BLUE);  // Color
        add(headingLablePatient);

        // Lable for Patient Name

        JLabel setPatientName= new JLabel("Patient Name");      // Text
        setPatientName.setBounds(5, 120,200,200);  // Bounds
        Font setFontName= new Font("Times New Romans", Font.BOLD, 12);
        setPatientName.setFont(setFontName);
        setPatientName.setForeground(Color.BLACK); // Color
        add(setPatientName);  // Gain the Memory

        // Text Field for writing Name
         setPName= new JTextField();
        setPName.setBounds(120,206,150, 30);  // Bounds
        Font setPNameFont= new Font("Arial", Font.BOLD, 12);
        setPName.setFont(setPNameFont);
        setPName.setForeground(Color.BLACK); // Color
        add(setPName);  // Gain the Memory

        ////////////////    Label for Patient Age      ///////////////////

        JLabel setPatientAge= new JLabel("Patient Age");   // Text
        setPatientAge.setBounds(5, 160,200,250);  // Bounds
        Font setFontPatientAge= new Font("Times New Romans", Font.BOLD, 12);
        setPatientAge.setFont(setFontPatientAge);  // Font
        setPatientAge.setForeground(Color.BLACK);  // color

        // Text Field to write the Age

         textPage= new JTextField();
        textPage.setBounds(120,270,150, 30);  // Bounds
        Font textPasswordFont= new Font("Arial", Font.BOLD, 12);
        textPage.setFont(textPasswordFont);
        textPage.setForeground(Color.BLACK);// Font and Color
        add(textPage);

            // Label for Patient Disease

        JLabel setPDisease= new JLabel("Patient Disease");  // Text
        setPDisease.setBounds(5, 220,200,250); // Bounds
        Font setFontPDisease= new Font("Times New Romans", Font.BOLD, 12);
        setPDisease.setFont(setFontPDisease);// Font
        setPDisease.setForeground(Color.BLACK);  // Color

        // Text Field to write the Patient's Disease

         textPDisease= new JTextField();
        textPDisease.setBounds(120,328,150, 30);  // Bounds
        Font textPDiseaseFont= new Font("Arial", Font.BOLD, 12);  // Font
        textPDisease.setFont(textPDiseaseFont);
        textPDisease.setForeground(Color.BLACK); // Color
        add(textPDisease);  // Gain the Memory

          ////////  Label for Patient's visitor

        JLabel setPCareTaker= new JLabel("Patient Visitor");  // Text
        setPCareTaker.setBounds(5, 270,200,250);  // Bounds
        Font setPCareTakerFont= new Font("Times New Romans", Font.BOLD, 12);
        setPCareTaker.setFont(setPCareTakerFont);  // Font
        setPCareTaker.setForeground(Color.BLACK);// Color
        add(setPCareTaker); // Gain the Memory

        // Text Field to write the Visitor name

         textPCareTaker= new JTextField();
        textPCareTaker.setBounds(120,385,150, 30);  // Bounds
        Font textPCareTakerFont= new Font("Arial", Font.BOLD, 12);
        textPCareTaker.setFont(textPCareTakerFont);  // Font
        textPCareTaker.setForeground(Color.BLACK); // Color
        add(textPCareTaker);  // Gain the Memory

       // Label to set Room No

        JLabel setPRoomNo= new JLabel("Patient Room No.");
        setPRoomNo.setBounds(5, 320,200,250);  // Bounds
        Font setPRoomNoFont= new Font("Times New Romans", Font.BOLD, 12);
        setPRoomNo.setFont(setPRoomNoFont);  // Font
        setPRoomNo.setForeground(Color.BLACK);  // Color
        add(setPRoomNo);  // Gain the Memory

         // TExt Field to write the Room Number of Patient

         textPRoomNo= new JTextField();
        textPRoomNo.setBounds(120,440,150, 30);  // Bounds
        Font textPRoomNoFont= new Font("Arial", Font.BOLD, 12);
        textPRoomNo.setFont(textPRoomNoFont);  ///// font
        textPRoomNo.setForeground(Color.BLACK);  // Color
        add(textPRoomNo);  // Gain the Memory



        add(setPatientName);
        add(setPatientAge); // Gain the Memory Now
        add(setPDisease);

        /// Code for Buttons ///

        addPatient= new JButton("Add Patient Record");   // Text
        addPatient.setBounds(100,500,160,30);  // Bounds
        addPatient.addActionListener(this);  // Listen the Action
        add(addPatient);  // Gain The Memory


        goBackToLogin = new JButton("Back");  // Text
        goBackToLogin.setBounds(10,30,80,30);  // Bounds
        goBackToLogin.addActionListener(this); // Listen the Action
        add(goBackToLogin); // Gain The Memory




        setVisible(true);  // Show the Graphical User Interface on the Screen




    }

    public static void main(String[] args) {
        new Patient();
    }  // Main Function

    public void makePTable()  // public Method
    {
//


        pTable = new JTable();   // Table for Patient
        pScrollPane = new JScrollPane(pTable);    // Scroll Pane
        pScrollPane.setBounds(450,150, 420, 350);  // set the Bounds

        pDefaultTableModel = new DefaultTableModel();  // DEfault table Model
        pTable.setModel(pDefaultTableModel);

                ///////////    Code for WRite the Columns     ////////////

        pDefaultTableModel.addColumn("Name");
        pDefaultTableModel.addColumn("Age");
        pDefaultTableModel.addColumn("Disease");
        pDefaultTableModel.addColumn("Visitor");
        pDefaultTableModel.addColumn("Room No");



        FileReader fr= null;         // Code to REad the Data From Patient's Txt File
        try {
            fr = new FileReader("Patient.txt");
            BufferedReader br= new BufferedReader(fr);
            String line = null;
            String token[] = null;
            while((line = br.readLine())!= null)
            {
                token = line.split(",");
                pDefaultTableModel.addRow(token);
            }

        } catch (FileNotFoundException e) {   // Exception Handling
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

   add(pScrollPane);  // Scroll Pane Gain the Memory here

//

    }



    @Override   //////   Function Override   ///////
    public void actionPerformed(ActionEvent e) {      // Action Performed By Buttons
        if(e.getSource()==addPatient){
//            System.out.println("Patient Added Successfully  :)");
            {                //////////     Conditions     //////////////

                if(setPName.getText().trim().isEmpty()|| textPage.getText().trim().isEmpty()||textPCareTaker.getText().trim().isEmpty()||textPRoomNo.getText().trim().isEmpty())
                    JOptionPane.showConfirmDialog(this,"all fields are required");



                else if( setPName.getText().isEmpty()&& textPage.getText().isEmpty()&& textPCareTaker.getText().isEmpty()&&  textPRoomNo.getText().isEmpty()&&  textPDisease.getText().isEmpty())

            {
                JOptionPane.showConfirmDialog(null,"All Fields are Empty","Message",JOptionPane.PLAIN_MESSAGE);
            }
            else {


                try {
                    makePTable();           //////////      Show the Data      ///////////
                    String row[] = {setPName.getText(),textPage.getText(),textPDisease.getText(),textPCareTaker.getText(),textPRoomNo.getText()};
                    pDefaultTableModel.addRow(row);
                    FileWriter fw= new FileWriter("Patient.txt", true);  //  Code to Write Data in the File
                    BufferedWriter bw= new BufferedWriter(fw);
                    bw.write(setPName.getText()+","+textPage.getText()+","+textPDisease.getText()+","+textPCareTaker.getText()+","+textPRoomNo.getText()+"\n");
                    bw.close();
                    fw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
            }

        }
        else  if(e.getSource()==goBackToLogin){   // Back to Login Class
            dispose();  //// Close the Current Screen
            new Login();
        }
    }


}
