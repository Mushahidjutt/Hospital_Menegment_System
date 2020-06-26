import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Room extends JFrame implements ActionListener {
    private JButton goBackLogin;    //make button  for logout
    private JButton btnAddRoomRecord;   //make button for add add room record
    private JLabel backgroundRoomImgPage ;  //make label for background image
    private JTextField setTWard;    //it use for take total ward number
    private JTextField textRoom;    //it is use for take room
    private JTextField textPatientPerRoom;  //it use for take how many patient is in a room
    private JTextField textDoctorPerRoom ;  //it use for how many doctors are avalable in a room
    private JTextField textBlockNo; //it is use for take how many room are block.
    private JTable Rtable;  //it is use for make a Room table
    private JScrollPane RScrollPane;    //it is use for take the table of room numbers
    private DefaultTableModel defaultRTable;    //it is for adding data in room number

    public Room() {

        setLayout(null);
        setTitle("Hospital Management System ");
        setBounds(200, 100, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon pic = new ImageIcon("logo.png");
        setIconImage(pic.getImage());


        goBackLogin = new JButton("Back");
        goBackLogin.setBounds(10, 30, 80, 30);
        goBackLogin.addActionListener(this);
        add(goBackLogin);

        btnAddRoomRecord = new JButton("Update Record");
        btnAddRoomRecord.setBounds(300, 500, 140, 30);
        btnAddRoomRecord.addActionListener(this);
        add(btnAddRoomRecord);


        JLabel headingLableRoom = new JLabel("Rooms Information");
        headingLableRoom.setBounds(100, 50, 550, 80);
        Font fontHeadingLableRoom = new Font("Arial", Font.BOLD, 24);
        headingLableRoom.setFont(fontHeadingLableRoom);
        headingLableRoom.setForeground(Color.BLUE);
        add(headingLableRoom);


//


        ImageIcon backgroundRoomImg = new ImageIcon("roomBackground.png");
        Image img = backgroundRoomImg.getImage();
        Image tempoImage = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        backgroundRoomImg = new ImageIcon(tempoImage);
         backgroundRoomImgPage = new JLabel(" ", backgroundRoomImg, JLabel.CENTER);
        backgroundRoomImgPage.setBounds(0, 0, 900, 600);
        add(backgroundRoomImgPage);


        JPanel RoomPage = new JPanel();
        RoomPage.setLayout(null);
        RoomPage.setSize(300, 270);
        RoomPage.setBackground(new Color(0, 0, 0, 20));
        RoomPage.setBounds(0, 200, 300, 270);



//




        JLabel setTotalWards = new JLabel("Total Wards");
        setTotalWards.setBounds(200, 10, 200, 20);
        Font setTotalWardsFont = new Font("Times New Romans", Font.BOLD, 14);
        setTotalWards.setFont(setTotalWardsFont);
        setTotalWards.setForeground(Color.BLACK);
        RoomPage.add(setTotalWards);
         setTWard = new JTextField();
        setTWard.setBounds(300, 206, 130, 30);
        Font setPNameFont = new Font("Arial", Font.BOLD, 20);
        setTWard.setForeground(Color.BLACK);
        add(setTWard);
/////////////////////////////////////////////

        JLabel setRoom = new JLabel("Total Rooms");
        setRoom.setBounds(200, 75, 200, 20);
        Font setFontRoom = new Font("Times New Romans", Font.BOLD, 14);
        setRoom.setFont(setFontRoom);
        setRoom.setForeground(Color.BLACK);
        RoomPage.add(setRoom);

         textRoom = new JTextField();
        textRoom.setBounds(300, 270, 130, 30);
        Font textRoomFont = new Font("Arial", Font.BOLD, 20);
        textRoom.setForeground(Color.BLACK);
        add(textRoom);


        JLabel setPatientPerRoom = new JLabel("Patients in a Room");
        setPatientPerRoom.setBounds(160, 130, 200, 20);
        Font setFontPatientPerRoom = new Font("Times New Romans", Font.BOLD, 14);
        setPatientPerRoom.setFont(setFontPatientPerRoom);
        setPatientPerRoom.setForeground(Color.BLACK);
        RoomPage.add(setPatientPerRoom);


         textPatientPerRoom = new JTextField();
        textPatientPerRoom.setBounds(300, 328, 130, 30);
        Font textPatientPerRoomFont = new Font("Arial", Font.BOLD, 20);
        textPatientPerRoom.setForeground(Color.BLACK);
        add(textPatientPerRoom);

        JLabel setDoctorPerRoom = new JLabel("Doctors in a Room");
        setDoctorPerRoom.setBounds(160, 185, 200, 20);
        Font setFontDoctorPerRoom = new Font("Times New Romans", Font.BOLD, 14);
        setDoctorPerRoom.setFont(setFontDoctorPerRoom);
        setDoctorPerRoom.setForeground(Color.BLACK);
       RoomPage.add(setDoctorPerRoom);


         textDoctorPerRoom = new JTextField();
        textDoctorPerRoom.setBounds(300, 385, 130, 30);
        Font textDoctorPerRoomFont = new Font("Arial", Font.BOLD, 11);
        textDoctorPerRoom.setFont(textDoctorPerRoomFont);
        textDoctorPerRoom.setForeground(Color.BLACK);
        add(textDoctorPerRoom);
        JLabel setBLock = new JLabel("Block No");
        setBLock.setBounds(200, 230, 200, 20);
        Font setBLockFont= new Font("Times New Romans", Font.BOLD, 14);
        setBLock.setFont(setBLockFont);
        setBLock.setForeground(Color.BLACK);
        RoomPage.add(setBLock);


        textBlockNo = new JTextField();
        textBlockNo.setBounds(300, 430, 130, 30);
        Font textBlockNoFont = new Font("Arial", Font.BOLD, 11);
        textBlockNo.setFont(textBlockNoFont);
        textBlockNo.setForeground(Color.BLACK);
        add(textBlockNo);




        backgroundRoomImgPage.add(RoomPage);



        setVisible(true);


    }


    public static void main(String[] args) {
        new Room();
    }
    public void makeRoomTable()
    {

        Rtable = new JTable();
        RScrollPane = new JScrollPane(Rtable);
        RScrollPane.setBounds(450,150, 420, 350);

        defaultRTable = new DefaultTableModel();
        Rtable.setModel(defaultRTable);
        defaultRTable.addColumn("Block No");
        defaultRTable.addColumn("Wards");
        defaultRTable.addColumn("Total Room");
        defaultRTable.addColumn("Patients in Room");
        defaultRTable.addColumn("Doctors in Room");



        FileReader fr= null;
        try {
            fr = new FileReader("Room.txt");
            BufferedReader br= new BufferedReader(fr);
            String line = null;
            String token[] = null;
            while((line = br.readLine())!= null)
            {
                token = line.split(",");
                defaultRTable.addRow(token);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        backgroundRoomImgPage.add(RScrollPane);


    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBackLogin) {
            dispose();
            new Login();
        }


        else if(e.getSource()==btnAddRoomRecord)
        {
            if(setTWard.getText().trim().isEmpty()|| textRoom.getText().trim().isEmpty()||textPatientPerRoom.getText().trim().isEmpty()||textDoctorPerRoom.getText().trim().isEmpty())
                JOptionPane.showConfirmDialog(this,"all fields are requied");
            else if( setTWard.getText().isEmpty()&& textRoom.getText().isEmpty()&& textPatientPerRoom.getText().isEmpty()&&  textDoctorPerRoom.getText().isEmpty())

        {
            JOptionPane.showConfirmDialog(null," All Fields are Empty","Message",JOptionPane.PLAIN_MESSAGE);
        }
        else {


            try {
                makeRoomTable();
                String row[] = {textBlockNo.getText(),setTWard.getText(),textRoom.getText(),textPatientPerRoom.getText(),textDoctorPerRoom.getText()};
                defaultRTable.addRow(row);
                FileWriter fw= new FileWriter("Room.txt", true);
                BufferedWriter bw= new BufferedWriter(fw);
                bw.write(textBlockNo.getText()+","+setTWard.getText()+","+textRoom.getText()+","+textPatientPerRoom.getText()+","+textDoctorPerRoom.getText()+"\n");
                bw.close();
                fw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }            //Code to add Doctor  (write the data to file)
        }
    }



}