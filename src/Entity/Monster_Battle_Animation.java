
package Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;


public class Monster_Battle_Animation {
    GamePanel gp;
    private int spriteNum = 1, spriteCount = 0;
    private BufferedImage monster_pic1,monster_pic2;

    public Monster_Battle_Animation(GamePanel gp) {
        this.gp = gp ;
        //test     
    }
    
    private void selectMonster(){
        try {
            if(gp.monster_Stats.Monster_found == "Red slime"){
                monster_pic1 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/red_slime1.png"));
                monster_pic2 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/red_slime2.png"));
            }
            else if(gp.monster_Stats.Monster_found == "Mage slime"){
                monster_pic1 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/mage_slime1.png"));
                monster_pic2 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/mage_slime2.png"));
            }
            else if(gp.monster_Stats.Monster_found == "Knight slime"){
                monster_pic1 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/knight1.png"));
                monster_pic2 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/knight2.png"));
            }
            else if(gp.monster_Stats.Monster_found == "King Slime"){
                monster_pic1 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/king1.png"));
                monster_pic2 = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/king2.png"));
            }
        } catch (IOException e) {
            //
        }
    }
    
    
    public void drawMonster_Animation(Graphics g){
        
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
        
        selectMonster();
        if(spriteNum == 1){
            g.drawImage(monster_pic1, 600, 200, gp.title_size, gp.title_size, null);  
        } 
        else if(spriteNum == 2){
            g.drawImage(monster_pic2, 600, 200, gp.title_size, gp.title_size, null);  
        }
        
    }
}
