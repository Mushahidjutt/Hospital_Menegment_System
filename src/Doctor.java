import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Doctor extends JFrame implements ActionListener{           // Class Doctor
    private  JButton btnAddDoctor;
    private JButton btnGoBackToLoginPage;
    private JTable doctorTable;                   ////////      Private Attributes      /////////////
    private DefaultTableModel defaultTable;
    private JScrollPane scrollPane;
    private JTextField textDName;
    private JTextField textDSpecialization;
    private JTextField textDExperience;
    private  JTextField textDRoom;
    private JTextField textDSalary;
    private  JLabel backgroundDoctorImgPage;

    public Doctor() {         //////  Constructors   /////////


        setTitle("Hospital Management System ");      ////        Title    ////
        setBounds(200,100,900,600);  // Bounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon pic= new ImageIcon("logo.png");   // Logo
        setIconImage(pic.getImage());
        setLayout(null);  // Set the Layout

       //////////      Heading     //////////

        JLabel headingLableDoctor= new JLabel("Doctors Information");   // Text
        headingLableDoctor.setBounds(500,50,550, 80);  // Bounds
        Font fontheadingLableDoctor= new Font("Arial", Font.BOLD, 24);
        headingLableDoctor.setFont(fontheadingLableDoctor);  // Font
        headingLableDoctor.setForeground(Color.BLUE);  // Color
        add(headingLableDoctor);

              ////////    Code for Background Pic  ////////

        ImageIcon backgroundDoctorImg = new ImageIcon("doctorBackground.png");
        Image img = backgroundDoctorImg.getImage();
        Image temImage = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);  // Size
        backgroundDoctorImg = new ImageIcon(temImage);
         backgroundDoctorImgPage = new JLabel(" ", backgroundDoctorImg, JLabel.CENTER);  // Layout
        backgroundDoctorImgPage.setBounds(0, 0, 900, 600);  // Bounds
        add(backgroundDoctorImgPage);


        JPanel DoctorPage = new JPanel();     /// Panel for doctor
        DoctorPage.setLayout(null);  // Layout
        DoctorPage.setSize(400, 350);    /// Size
        DoctorPage.setBackground(new Color(0, 0, 0, 20));  // Color
        DoctorPage.setBounds(0, 20, 400, 550);



        JLabel setDoctorName= new JLabel("Doctor Name");   /// Doctor Name
        setDoctorName.setBounds(30, 120,200,200);   // Bounds
        Font setFontDoctorName= new Font("Times New Romans", Font.BOLD, 12);
        setDoctorName.setFont(setFontDoctorName);  // Font
        setDoctorName.setForeground(Color.BLACK);
        DoctorPage.add(setDoctorName);// Gain the Memory

        // Text Field to write the Doctor Name
         textDName= new JTextField();
        textDName.setBounds(165,206,230, 30);     // Bounds
        Font setDNameFont= new Font("Arial", Font.BOLD, 12); // Font
        textDName.setFont(setDNameFont);
        textDName.setForeground(Color.BLACK); // Color
        DoctorPage.add(textDName);

                          /////////////            Doctor Specialization            ////////////
        JLabel setDoctorSpecialization= new JLabel("Doctor Specialization");
        setDoctorSpecialization.setBounds(30, 140,200,250);
        Font setFontDoctorSpecialization= new Font("Times New Romans", Font.BOLD, 12);  // Font
        setDoctorSpecialization.setFont(setFontDoctorSpecialization);
        setDoctorSpecialization.setForeground(Color.BLACK);  // Color
        DoctorPage.add(setDoctorSpecialization);

        /////////////  Text Field to write Doctor Specialization  ////////////

         textDSpecialization= new JTextField();
        textDSpecialization.setBounds(165,250,230, 30);  // Bounds
        Font textDSpecializationFont= new Font("Arial", Font.BOLD, 12);
        textDSpecialization.setFont(textDSpecializationFont);  // Font
        textDSpecialization.setForeground(Color.BLACK); // Color
        DoctorPage.add(textDSpecialization);

              // Label of Doctor Experience
        JLabel setDExperience= new JLabel("Doctor Experience");
        setDExperience.setBounds(30, 190,200,250);  // Bounds
        Font setFontDExperience= new Font("Times New Romans", Font.BOLD, 12);
        setDExperience.setFont(setFontDExperience);  // Font
        setDExperience.setForeground(Color.BLACK);  // Color
        DoctorPage.add(setDExperience);


                     ///////        Text Field to write Doctor Experience     ////////

         textDExperience= new JTextField();
        textDExperience.setBounds(165,300,230, 30);
        Font textDFontExperienceFont= new Font("Arial", Font.BOLD, 12);
        textDExperience.setFont(textDFontExperienceFont);
        textDExperience.setForeground(Color.BLACK);
        DoctorPage.add(textDExperience);

         // Label for Doctor Salary
        JLabel setDSalary= new JLabel("Doctor Salary");
        setDSalary.setBounds(30, 235,200,250);   // Bounds
        Font setFontDSalary= new Font("Times New Romans", Font.BOLD, 12);
        setDSalary.setFont(setFontDSalary);   /// Font
        setDSalary.setForeground(Color.BLACK);  // Color
        DoctorPage.add(setDSalary);  // Gain the Memory

                /////     Text field to write data about Doctor salary     ///////

         textDSalary= new JTextField();
        textDSalary.setBounds(165,345,230, 30);
        Font textDSalaryFont= new Font("Arial", Font.BOLD, 12);
        textDSalary.setFont(textDSalaryFont);  // Font
        textDSalary.setForeground(Color.BLACK);  // Color
        DoctorPage.add(textDSalary);   // Gain the memory


        JLabel setDRoom= new JLabel("Doctor Room No");   // Text
        setDRoom.setBounds(30, 278,200,250); // Bounds
        Font setFontDRoom= new Font("Times New Romans", Font.BOLD, 12);
        setDRoom.setFont(setFontDRoom);   // Font
        setDRoom.setForeground(Color.BLACK);
        DoctorPage.add(setDRoom);   // Gain the Memory



         textDRoom= new JTextField();  // Text
        textDRoom.setBounds(165,390,230, 30); // Bounds
        Font textDRoomFont= new Font("Arial", Font.BOLD, 12);
        textDRoom.setFont(textDRoomFont);
        textDRoom.setForeground(Color.BLACK);   // Color
        DoctorPage.add(textDRoom);  // Gain the Memory



        btnAddDoctor= new JButton("Add Doctor Record");  // Text
        btnAddDoctor.setBounds(50,470,160,30);// Bounds
        btnAddDoctor.addActionListener(this);    //Listen the action
        DoctorPage.add(btnAddDoctor); // Gain the Memory


        btnGoBackToLoginPage = new JButton("Back");  // Text
        btnGoBackToLoginPage.setBounds(10,30,80,30);  // Bounds
        btnGoBackToLoginPage.addActionListener(this);  // Listen the action
        DoctorPage.add(btnGoBackToLoginPage); // Gain the Memory


        backgroundDoctorImgPage.add(DoctorPage);




        setVisible(true);      //////           Display the GUI            ////////////////



    }

    public static void main(String[] args) {
        new Doctor();
    }

    public void makeTable()       //////     Public Method     //////
    {
        doctorTable = new JTable();
        scrollPane = new JScrollPane(doctorTable);
        scrollPane.setBounds(450,150, 400, 350);

        defaultTable = new DefaultTableModel();
        doctorTable.setModel(defaultTable);
                    ////////    Code to Add Columns      //////////
        defaultTable.addColumn("Name");
        defaultTable.addColumn("Specialization");
        defaultTable.addColumn("Experience");
        defaultTable.addColumn("Salary");
        defaultTable.addColumn("RoomNo");

        FileReader fr= null;
        try {        //////////     Code to Read Data From File      ////////////
            fr = new FileReader("Doctor.txt");
            BufferedReader br= new BufferedReader(fr);
            String line = null;
            String token[] = null;
            while((line = br.readLine())!= null)
            {
                token = line.split(",");
                defaultTable.addRow(token);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        backgroundDoctorImgPage.add(scrollPane);


    }
    @Override
    public void actionPerformed(ActionEvent e) {  // Action Performed By Buttons

        if (e.getSource()==btnGoBackToLoginPage)  // Go Back to Login Class
        {
            dispose();
            new Login();
        }
        else if (e.getSource()==btnAddDoctor)
        {                ///////  Conditions   ////////////
            if(textDName.getText().trim().isEmpty()|| textDSpecialization.getText().trim().isEmpty()||textDExperience.getText().trim().isEmpty()||textDRoom.getText().trim().isEmpty())
                JOptionPane.showConfirmDialog(this,"all fields are requied");

            else if( textDName.getText().isEmpty()&& textDSpecialization.getText().isEmpty()&& textDExperience.getText().isEmpty()&&  textDRoom.getText().isEmpty())

            {
                JOptionPane.showConfirmDialog(null,"All Fields are Empty","Message",JOptionPane.PLAIN_MESSAGE);
            }
            else {


            try {
                makeTable();   // Function Call

                String row[] = {textDName.getText(),textDSpecialization.getText(),textDExperience.getText(),textDSalary.getText(),textDRoom.getText()};
                defaultTable.addRow(row);
                FileWriter fw= new FileWriter("Doctor.txt", true);   //Code to add Doctor  (write the data to file)
                BufferedWriter bw= new BufferedWriter(fw);
                bw.write(textDName.getText()+","+textDSpecialization.getText()+","+textDSalary.getText()+","+textDExperience.getText()+","+textDRoom.getText()+"\n");
                bw.close();
                fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }
        }
    }
}

