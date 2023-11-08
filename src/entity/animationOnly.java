package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;

public class animationOnly {

    BufferedImage player1, player2, enemy1, enemy2;
    GamePanel gp;
    int spritecount;
    int spriteNum = 1;
    public String enemy = "redslime";

    public animationOnly(GamePanel gp) {
        this.gp = gp;
    }
    
    public void updateAni(){
        spritecount++;
        if (spritecount > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spritecount = 0;
        }
    }

    public void drawAni(Graphics2D g2) {
        enemyCheck();
        if(spriteNum == 1){
           g2.drawImage(player1, 150, 180, gp.titlesize, gp.titlesize, null);
           g2.drawImage(enemy1, 550, 180, gp.titlesize, gp.titlesize, null); 
        }else if(spriteNum == 2){
           g2.drawImage(player2, 150, 180, gp.titlesize, gp.titlesize, null);
           g2.drawImage(enemy2, 550, 180, gp.titlesize, gp.titlesize, null);
        }
        
    }

    private void enemyCheck() {
        try {
            player1 = ImageIO.read(getClass().getResourceAsStream("/res/AnimationOnly/player1.png"));
            player2 = ImageIO.read(getClass().getResourceAsStream("/res/AnimationOnly/player2.png"));
            if (enemy == "redslime") {
                enemy1 = ImageIO.read(getClass().getResourceAsStream("/res/AnimationOnly/redslime1.png"));
                enemy2 = ImageIO.read(getClass().getResourceAsStream("/res/AnimationOnly/redslime2.png"));
            }
        } catch (IOException e) {

        }

    }
}
