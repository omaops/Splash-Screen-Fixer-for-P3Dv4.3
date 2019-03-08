/*
* All the things you nee to backup and delete are in the link below
* https://flightsimeindhoven.com/prepar3d/delete-generated-files/
*
* */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fixer {

    private JButton button1;
    private JPanel jPanel1;
    private JButton undoFixButton;
    private JLabel JLabel1;
    private JLabel JLabel2;


    public Fixer() {

        String orgSce = "C:/ProgramData/Lockheed Martin/Prepar3D v4/scenery.cfg";
        String cpySce = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_scenery.cfg";

        String orgDll = "C:/ProgramData/Lockheed Martin/Prepar3D v4/dll.xml";
        String cpyDll = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_dll.xml";

        String orgExe = "C:/ProgramData/Lockheed Martin/Prepar3D v4/exe.xml";
        String cpyExe = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_exe.xml";

        String orgSim = "C:/ProgramData/Lockheed Martin/Prepar3D v4/simobjects.cfg";
        String cpySim = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_simobjects.cfg";


        String PicURL = "C:\\Users\\Tinbite\\IdeaProjects\\P3DFixer\\Asset\\pic.jpg";
        ImageIcon imgThisImg = new ImageIcon(PicURL);
        JLabel1.setIcon(imgThisImg);



        // Try Fix Button

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fix Button Clicked");
                Handler h = new Handler();

                //Sceanery.cfg
                try {
                    if(h.check(orgSce)) {
                        h.cpyer(orgSce, cpySce);
                        h.dlter(orgSce);
                        JLabel2.setText("Fixing Scenery...");
                    }
                    else if(h.check(cpySce))
                    JLabel2.setText("You have already applied the Scenery fix");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }

                //DLL.xml
                try {
                    if(h.check(orgDll)) {
                        h.cpyer(orgDll, cpyDll);
                        h.dlter(orgDll);
                        JLabel2.setText("Fixing DLLs...");
                    }
                    else if(h.check(cpyDll))
                        JLabel2.setText("You have already applied the DLL fix");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }


                //EXE.xml
                try {
                    if(h.check(orgExe)) {
                        h.cpyer(orgExe, cpyExe);
                        h.dlter(orgExe);
                        JLabel2.setText("Fixing EXEs...");
                    }
                    else if(h.check(cpyExe))
                        JLabel2.setText("You have already applied the EXE fix");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }


                //simobjects.cfg
                try {
                    if(h.check(orgSim)) {
                        h.cpyer(orgSim, cpySim);
                        h.dlter(orgSim);
                        JLabel2.setText("Fix Applied! Try opening P3D Now");
                    }
                    else if(h.check(cpySim))
                        JLabel2.setText("You have already applied the simobjects fix");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }



            }
        });


        //Reverse fix Button

        undoFixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reverser r = new Reverser();
                Handler h = new Handler();

                //Reverse Scenery
                try {
                    if(h.check(cpySce)) {
                        r.rev(orgSce, cpySce);
                        JLabel2.setText("Scenery Fix undone. You're back to the original");
                    }
                    else if(h.check(orgSce)){
                        JLabel2.setText("You already have the original. Nothing to undo here");
                    }
                    else
                        JLabel2.setText("I don't think you have P3D at all. Fix will not work");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }

                //Revers DLL.xml
                try {
                    if(h.check(cpyDll)) {
                        r.rev(orgDll, cpyDll);
                        JLabel2.setText("DLL Fix undone. You're back to the origional");
                    }
                    else if(h.check(orgDll)){
                        JLabel2.setText("You already have the original. Nothing to undo here");
                    }
                    else
                        JLabel2.setText("I don't think you have P3D at all. Fix will not work");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }

                //Reverse Exe.xml
                try {
                    if(h.check(cpyExe)) {
                        r.rev(orgExe, cpyExe);
                        JLabel2.setText("Exe Fix undone. You're back to the original");
                    }
                    else if(h.check(orgExe)){
                        JLabel2.setText("You already have the original. Nothing to undo here");
                    }
                    else
                        JLabel2.setText("I don't think you have P3D at all. Fix will not work");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }

                //Reverse simobjects.cfg
                try {
                    if(h.check(cpySim)) {
                        r.rev(orgSim, cpySim);
                        JLabel2.setText("Simobjects Fix undone. You're back to the origional");
                    }
                    else if(h.check(orgSim)){
                        JLabel2.setText("You already have the original. Nothing to undo here");
                    }
                    else
                        JLabel2.setText("I don't think you have P3D at all. Fix will not work");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }

            }
        });
    }

    public static void main(String[] args) {
        String icn = "C:\\Users\\Tinbite\\IdeaProjects\\P3DFixer\\Asset\\icon1.png";
        ImageIcon imgThisImg1 = new ImageIcon(icn);

        JFrame frame = new JFrame("Splash-Screen Fixer for P3Dv4.3");
        frame.setIconImage(imgThisImg1.getImage());
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.setContentPane(new Fixer().jPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
