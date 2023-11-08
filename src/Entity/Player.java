package Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;
import slimequest.KeyControl;

public class Player {
    GamePanel gp;
    public int current_row,current_col;
    public int x , y , spriteNum = 1 , spriteCount = 0, speed = 12;
    BufferedImage stand1,stand2,up1,up2,down1,down2,left1,left2,right1,right2;
    public String playerState = "stand";
    String Animation_state = "stand";
    public boolean playerCollision = false;
    
    

    public Player(GamePanel gp) {
        this.gp = gp;
        loadImage();
        
    }
    
    private void update_row_col(){
        x = gp.title_size*current_col;
        y = gp.title_size*current_row;
    }
    
    private  void loadImage(){
        try {
            stand1 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_stand1.png"));
            stand2 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_stand2.png"));
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_up2.png"));
            
            down1 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_down2.png"));
            
            left1 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_left2.png"));
            
            right1 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Picture/player/MySlime_right2.png"));
        } catch (IOException e) {
            //
        }
    }
    public void update(){
//          System.out.println("row = "+current_row+" col = "+current_col );
//          System.out.println("y = "+y+" x = "+x );
        
        if(playerState == "up" && playerCollision == false){
            current_row--;
            Animation_state = "up";
            spriteNum = 3;
            gp.gameLogic.walkCount++;
        }
        else if(playerState == "down" && playerCollision == false){
            current_row++;
            Animation_state = "down";
            spriteNum = 3;
            gp.gameLogic.walkCount++;
        }
        else if(playerState == "left" && playerCollision == false){
            current_col--;
            Animation_state = "left";
            spriteNum = 3;
            gp.gameLogic.walkCount++;
        }
        else if(playerState == "right" && playerCollision == false){
            current_col++;
            Animation_state = "right";
            spriteNum = 3;
            gp.gameLogic.walkCount++;
        }
        update_row_col();
        
        spriteCount++;
        if(spriteCount>10){  //set delay sprite
            if(spriteNum == 2){
                spriteNum = 1;
            }else if(spriteNum == 1){
                spriteNum = 2;   
            }else if(spriteNum == 3){
                spriteNum = 4;   
            }else if(spriteNum == 4){
                spriteNum = 1;   
            }
            spriteCount=0;
        }
    }
    
    public void draw(Graphics g){
        BufferedImage Image = null;

        if(Animation_state == "stand"){
            if(spriteNum == 1){
                Image = stand1;
            }
            else if(spriteNum == 2){
                Image = stand2;
            }
        }
        else if(Animation_state == "up"){
            if(spriteNum == 1){
                Image = stand1;
            }
            else if(spriteNum == 2){
                Image = stand2;
            }
            else if(spriteNum == 3){
                Image = up1;
            }
            else if(spriteNum == 4){
                Image = up2;
            }
//               Image =up2;
        }
        else if(Animation_state == "down"){
            if(spriteNum == 1){
                Image = stand1;
            }
            else if(spriteNum == 2){
                Image = stand2;
            }
            else if(spriteNum == 3){
                Image = down1;
            }
            else if(spriteNum == 4){
                Image = down2;
            }
        }
        
        else if(Animation_state == "left"){
            if(spriteNum == 1){
                Image = stand1;
            }
            else if(spriteNum == 2){
                Image = stand2;
            }
            else if(spriteNum == 3){
                Image = left1;
            }
            else if(spriteNum == 4){
                Image = left2;
            }
        }
        
        else if(Animation_state == "right"){
            if(spriteNum == 1){
                Image = stand1;
            }
            else if(spriteNum == 2){
                Image = stand2;
            }
            else if(spriteNum == 3){
                Image = right1;
            }
            else if(spriteNum == 4){
                Image = right2;
            }
        }
        
        g.drawImage(Image, x, y, gp.title_size, gp.title_size, null);
        
        playerState = "stand";
        playerCollision = false;
    }
    
}
