
package slimequest;
import entity.Player;
import entity.animationOnly;
import entity.enemyStats;
import entity.playerStats;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;
//import slimequest.entity.Player;

public class GamePanel extends JPanel implements Runnable {
    // Screen setting
    int origintitlesize = 16;
    public int scale = 3;
    public int titlesize = origintitlesize*scale; // 48x48 title size
//    int titlesize = 16; // 16x16 test title size
    
    public int maxScreenCol = 16; // 768 width
    public int maxScreenRow = 12; // 576 height
    
    int ScreenWidth = maxScreenCol * titlesize;
    int ScreenHeight = maxScreenRow * titlesize;
    
    //FPS
    double FPS = 60;
    
    // Game Status
    public String gameStatus = "menu";
//    public String gameStatus = "battle";
//    public String gameStatus = "gameOver";
    
    
    
    // Call class
    public Save save = new Save(this);
    public playerStats ps = new playerStats(this);
    public enemyStats es = new enemyStats(this);
    public CollisionEvent ce = new CollisionEvent(this);
    public CollisionCheck cc = new CollisionCheck(this);
    public GameLogic gl = new GameLogic(this);
    public animationOnly ao = new animationOnly(this);
    public KeyControl kc = new KeyControl(this);
    public UI ui = new UI(this,kc);
    public UICommand uic = new UICommand(this);
    public Player player = new Player(this,kc);
    public TileManager tm = new TileManager(this);
    
    
    Thread gt;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kc);
        this.setFocusable(true);
    }
    
    public void GameThreadStart(){
        gt = new Thread(this);
        gt.start();
    }
    
    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lasttime = System.nanoTime();
        long currenttime;
        //call fun read stats in this
        
        while(gt != null){
            currenttime = System.nanoTime();
            delta += (currenttime - lasttime)/drawInterval;
            lasttime = currenttime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
//                System.out.println("game is running");
        }
    }
    
    public void update(){
        
        if(gameStatus=="menu"){
            uic.checkCommand();
        }
        
        else if(gameStatus=="gameStart"){
            player.update();
            ce.EventCheck();
            gl.useLogic();
            //check num map
//            System.out.println(tm.NumOfMap);
        }
        
        else if(gameStatus=="menu_in_game"){
            uic.checkCommand();
        }
        
        else if(gameStatus == "battle"){
            ao.updateAni();
            uic.checkCommand();
            gl.useLogic();
        }
        else if(gameStatus == "gameOver"){
            uic.checkCommand();
        }
        

    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
//        System.out.println("test x y player = " +player.x + " "+player.y);
        if(gameStatus=="menu"){
            ui.drawui(g2);
        }
        
        else if(gameStatus=="gameStart"){
            tm.draw(g2);
            player.draw(g2);
            g2.dispose();
        }
        
        else if(gameStatus=="menu_in_game"){
            
            tm.draw(g2);
            player.draw(g2);
            ui.drawui(g2);
            
            g2.dispose();
        }
        
        else if(gameStatus == "battle"){
            ui.drawui(g2);
            ao.drawAni(g2);
            ui.dialog(g2);
            g2.dispose();
        }
        
        else if(gameStatus == "gameOver"){
            ui.drawui(g2);
            g2.dispose();
        }
            
    }
    
}
