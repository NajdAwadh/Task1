import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame implements ActionListener {
     JButton loadButton; 
      JLabel fileNamefield ;
    public void initialize(){
/* 
       
     setTitle("Form1");
       // setIconImage(new ImageIcon(imgURL).getImage());
        setSize(500 ,600) ;
        setBounds(100 , 100 ,500 ,300);
        setLayout(new GirdLayout);
        Container c=getContentPane();
        c.add(loadPanel);
        c.add(displayPanel);
        setMinimumSize(new Dimension(300 ,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
       // this.add(loadPanel);
       // this.add(displayPanel);
        //this.add(displayPanel); */

setTitle("Form1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(100,100,645,470);
        Border br = BorderFactory.createLineBorder(Color.gray);
        Container c=getContentPane();
        //Creating a JPanel for the JFrame
        JPanel loadPanel=new JPanel();
        

        JPanel displayPanel=new JPanel();
        
        loadPanel.setLayout(null);

        displayPanel.setLayout(null);

        //-----
        loadButton = new JButton("Load File");
        loadButton.setFocusable(false);
        loadButton.addActionListener(this);

        JLabel fileName = new JLabel("File Name") ;
        fileNamefield = new JLabel("");
       fileNamefield.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
       //fileNamefield.setEditable(false); 

       JLabel Id = new JLabel("ID:") ;
       JTextField IDfield = new JTextField();
       IDfield.setEditable(false);
       
       JLabel Time = new JLabel("Time Stamp:") ;
       JTextField Timefield = new JTextField();
       Timefield.setEditable(false);
       
       JLabel Azimuth = new JLabel("Azimuth:") ;
       JTextField Azimuthfield = new JTextField();
       Azimuthfield.setEditable(false);

       JLabel Elevation = new JLabel("Elevation:") ;
       JTextField Elevationfield = new JTextField();
       Elevationfield.setEditable(false);
       JLabel Range = new JLabel("Range:") ;
       JTextField Rangefield = new JTextField();
       Rangefield.setEditable(false);
//----------

        fileName.setBounds(60,120,100,30);
        loadButton.setBounds(100,30,100,50);
        fileNamefield.setBounds(130,120,100,30);


        Id.setBounds(50,12,100,30);
        IDfield.setBounds(130,20,100,20);

        Time.setBounds(50,30,100,30);
        Timefield.setBounds(130,40,100,20);

        Azimuth.setBounds(50,50,100,30);
        Azimuthfield.setBounds(130,60,100,20);

        Elevation.setBounds(50,70,100,30);
        Elevationfield.setBounds(130,80,100,20);

        Range.setBounds(50,90,100,30);
        Rangefield.setBounds(130,100,100,20);



        loadPanel.add(loadButton ); 
        loadPanel.add(fileName);
        loadPanel.add(fileNamefield);
    
        
        //loadPanel.add(fileName);
       
        //displayPanel.add(label3);
        displayPanel.add(Id );
        displayPanel.add(IDfield );
        displayPanel.add(Time );
        displayPanel.add(Timefield );
        displayPanel.add(Azimuth );
        displayPanel.add(Azimuthfield );
        displayPanel.add(Elevation );
        displayPanel.add(Elevationfield );
        displayPanel.add(Range );
        displayPanel.add(Rangefield );
        
        // changing the background color of the panel to yellow
        //Panel 1
        loadPanel.setBounds(100,10,300,200);
        //Panel 2
        //panel2.setBounds(320,10,300,200);
        //Panel 3
        displayPanel.setBounds(100,220,300,200);
        //Panel 4
       // panel4.setBounds(320,220,300,200);
        
        // Panel border
        loadPanel.setBorder(br);
        displayPanel.setBorder(br);
        
        //adding the panel to the Container of the JFrame
        c.add(loadPanel);
       // c.add(panel2);
        c.add(displayPanel);
       // c.add(panel4);
       
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource()==loadButton){
            JFileChooser file_load = new JFileChooser();
            //file_load.showOpenDialog(null);
            int res = file_load.showOpenDialog(null);
            if (res== JFileChooser.APPROVE_OPTION){
                File file_path = new File(file_load.getSelectedFile().getAbsolutePath());
                String name = file_path.toString() ;
                fileNamefield = new JLabel(name);
                System.out.println(file_path);
                System.out.println(name);
                //
                FileReadingExample(name);
            //----------------------------------

            }
        }
    }
    

   public void FileReadingExample (String filePath){
    try {
            // Provide the path of the file you want to read
            //String filePath = "path/to/your/file.txt";

            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);

            // Wrap FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process each line of the file here
                System.out.println(line);
            }

            // Close the resources
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}

