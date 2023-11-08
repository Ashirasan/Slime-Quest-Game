
package slimequest;

import javax.swing.JFrame;

public class SlimeQuest {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("Slime Quest");
//        window.setDefaultCloseOperation(JFram.);
        window.setResizable(false);
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.GameThreadStart();
        
    }
    
}
