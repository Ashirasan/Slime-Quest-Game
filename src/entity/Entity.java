package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    public int x,y;
    public int speed;
    
    public BufferedImage up1,up2,down1,down2,right1,right2,left1,left2,stand1,stand2;
    public String direction;
    
    public int spriteNum = 1;
    public int spritecount = 0;
    
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public String collision_event = "none";
    
    
    //logic 
    public int countWalk;
    
}
