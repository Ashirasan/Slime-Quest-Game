package Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;

public class Player_Battle_Animation {

    GamePanel gp;
    private BufferedImage playerPic1, playerPic2;
    private int spriteNum = 1, spriteCount = 0;

    public Player_Battle_Animation(GamePanel gp) {
        this.gp = gp;
        // load image
        loadImage();
    }

    private void loadImage() {
        try {
            playerPic1 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_stand1.png"));
            playerPic2 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_stand2.png"));
        } catch (IOException e) {
            //
        }
    }
    
    public void drawPlayer_Animation(Graphics g){
        spriteCount++;
        if(spriteCount>10){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCount = 0;
        }
        if(spriteNum == 1){
            g.drawImage(playerPic1, 168, 206, gp.title_size, gp.title_size, null);  
        } 
        else if(spriteNum == 2){
            g.drawImage(playerPic2, 168, 206, gp.title_size, gp.title_size, null);  
        }
    }

}
