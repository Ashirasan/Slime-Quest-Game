package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;
import slimequest.KeyControl;

public class Player extends Entity {

    GamePanel gp;
    KeyControl kc;

    public Player(GamePanel gp, KeyControl kc) {
        this.gp = gp;
        this.kc = kc;

        solidArea = new Rectangle();
//        solidArea.x = 0;
//        solidArea.y = 0;
//        solidArea.width = gp.titlesize;
//        solidArea.height = gp.titlesize;
        solidArea.x = 2 * gp.scale;
        solidArea.y = 4 * gp.scale;
        solidArea.width = 14 * gp.scale;
        solidArea.height = 11 * gp.scale;

        DefaultValue();
        getImage();
    }

    // set DefaultValue
    public void DefaultValue() {
        x = 200;
        y = 100;
        speed = 4;
        direction = "stand";

    }

    //Load player sprite
    public void getImage() {

        try {
            stand1 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_stand1.png"));
            stand2 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_stand2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_down2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_right2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/Player/MySlime_left2.png"));

        } catch (IOException e) {
            //
        }
    }

    //Update Control
    public void update() {
        if (kc.wPressed == true) {
            direction = "up";
        } else if (kc.sPressed == true) {
            direction = "down";
        } else if (kc.dPressed == true) {
            direction = "right";
        } else if (kc.aPressed == true) {
            direction = "left";
        } else {
            direction = "stand";
        }

        collisionOn = false;
        gp.cc.checkTile(this);

        // check collision
        if (collisionOn == false) {
            if (direction == "up") {
                y -= speed;
                countWalk++;
            } else if (direction == "down") {
                y += speed;
                countWalk++;
            } else if (direction == "right") {
                x += speed;
                countWalk++;
            } else if (direction == "left") {
                x -= speed;
                countWalk++;
            }
        }
//        System.out.println(x+" "+y);

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

    //Draw player sprite
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (direction == "up") {

            if (spriteNum == 1) {
                image = up1;
            }
            if (spriteNum == 2) {
                image = up2;
            }
        } else if (direction == "down") {
            if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down2;
            }
        } else if (direction == "right") {
            if (spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right2;
            }

        } else if (direction == "left") {
            if (spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left2;
            }
        } else if (direction == "stand") {
            if (spriteNum == 1) {
                image = stand1;
            }
            if (spriteNum == 2) {
                image = stand2;
            }
        }
        g2.drawImage(image, x, y, gp.titlesize, gp.titlesize, null);
    }
}
