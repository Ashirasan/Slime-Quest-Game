
package slimequest;

import javax.swing.JFrame;

public class SlimeQuest {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setResizable(false);
//        window.setSize(1280,960);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack(); 
        window.setVisible(true);
        gp.gameThread.start();
    }
    
}
