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

        String org = "C:/ProgramData/Lockheed Martin/Prepar3D v4/scenery.cfg";
        String cpy = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_scenery.cfg";

        String PicURL = "C:\\Users\\Tinbite\\IdeaProjects\\P3DFixer\\Asset\\pic.jpg";
        ImageIcon imgThisImg = new ImageIcon(PicURL);
        JLabel1.setIcon(imgThisImg);



        // Try Fix Button

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fix Button Clicked");
                Handler h = new Handler();
                try {
                    if(h.check(org)) {
                        h.cpyer();
                        h.dlter(org);
                        JLabel2.setText("Fix Applied! Try opening P3D Now");
                    }
                    else if(h.check(cpy))
                    JLabel2.setText("You have already applied the fix");
                }
                catch(Exception E){
                    JLabel2.setText("Remember! Run As Admin");
                }


            }
        });


        //Revers fix Button

        undoFixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reverser r = new Reverser();
                Handler h = new Handler();
                try {
                    if(h.check(cpy)) {
                        r.rev();
                        JLabel2.setText("Fix undone. You're back to the origional");
                    }
                    else if(h.check(org)){
                        JLabel2.setText("You aready have the origional. Nothing to undo here");
                    }
                    else
                        JLabel2.setText("I dont think you have P3D at all. Fix will not work");
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
