package slimequest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UI {

    GamePanel gp;
    KeyControl kc;
    Font arial_40;
    Font for_menu_text;
    Font for_battle_stats;
    int x = 0;
    int y = 0;
    //image
    BufferedImage bg_menu,bg_battle,bg_gameOver;

    public UI(GamePanel gp, KeyControl kc) {
        this.gp = gp;
        this.kc = kc;
        arial_40 = new Font("Arial", Font.BOLD, 40);
        for_menu_text = new Font("Arial", Font.PLAIN, 30);
        for_battle_stats = new Font("Arial", Font.BOLD, 20);
        loadImage();
    }
    
    public void loadImage(){
        try{
            bg_menu = ImageIO.read(getClass().getResourceAsStream("/res/bg/bg_menu.png"));
            bg_battle = ImageIO.read(getClass().getResourceAsStream("/res/bg/bg_battle.png"));
            bg_gameOver = ImageIO.read(getClass().getResourceAsStream("/res/bg/bg_gameOver.png"));
        }catch(IOException e){
            
        }
    }

    public void drawui(Graphics2D g2) {

        if (gp.gameStatus == "menu") {
            //set max min command
            gp.uic.max = 3;
            gp.uic.min = 1;
            
            g2.drawImage(bg_menu, 0,0,gp.ScreenWidth,gp.ScreenHeight,null);
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            text = "Slime Quest";

            x = setcenter_X(text, g2);
//            y=gp.ScreenHeight/2 - (gp.titlesize*3);  // set y center

            g2.drawString(text, x, 120);

            //Start
            text = "New Game";
            x = setcenter_X(text, g2);
            g2.drawString(text, x, 300);
            if (gp.uic.command == 1) {
                g2.drawString(">", x - 30, 300);
            }

            //Start
            text = "Continue";
            x = setcenter_X(text, g2);
            g2.drawString(text, x, 400);
            if (gp.uic.command == 2) {
                g2.drawString(">", x - 30, 400);
            }

            //Exit
            text = "Exit";
            x = setcenter_X(text, g2);
            g2.drawString(text, x, 500);
            if (gp.uic.command == 3) {
                g2.drawString(">", x - 30, 500);
            }

        } else if (gp.gameStatus == "menu_in_game") {
            String text;
            String readtext;
            gp.uic.max = 2;
            gp.uic.min = 1;
            g2.setFont(for_menu_text);

            g2.setColor(Color.black);
            g2.fillRect(30, 60, 250, 475);

            g2.fillRect(500, 300, 150, 150);

            g2.setColor(Color.white);

            // Status  not have int stats
            text = "Status";
            g2.drawString(text, 50, 100);

            text = "LV :";
            g2.drawString(text, 50, 175);
            readtext = String.valueOf(gp.ps.currentlv);
            g2.drawString(readtext, 120, 175);

            text = "HP :";
            g2.drawString(text, 50, 250);
            readtext = String.valueOf(gp.ps.currentHp);
            g2.drawString(readtext, 120, 250);
            int newX = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
            g2.drawString("/", 120 + newX + 10, 250);
            readtext = String.valueOf(gp.ps.maxHp);
            g2.drawString(readtext, 120 + newX + 30, 250);

            text = "ATK :";
            g2.drawString(text, 50, 325);
            readtext = String.valueOf(gp.ps.atk);
            g2.drawString(readtext, 135, 325);

            text = "DEF :";
            g2.drawString(text, 50, 400);
            readtext = String.valueOf(gp.ps.def);
            g2.drawString(readtext, 135, 400);

            text = "EXP :";
            g2.drawString(text, 50, 475);
            readtext = String.valueOf(gp.ps.currentExp);
            g2.drawString(readtext, 140, 475);
            newX = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
            g2.drawString("/", 140 + newX + 10, 475);
            readtext = String.valueOf(gp.ps.maxExp);
            g2.drawString(readtext, 140 + newX + 30, 475);

            // menu command
            text = "Save";
            g2.drawString(text, 550, 360);
            if (gp.uic.command == 1) {
                g2.drawString(">", 525, 360);
            }

            text = "Exit";
            g2.drawString(text, 550, 410);
            if (gp.uic.command == 2) {
                g2.drawString(">", 525, 410);
            }

        } else if (gp.gameStatus == "battle") {
            g2.drawImage(bg_battle, 0,0,gp.ScreenWidth,gp.ScreenHeight,null);
//            gp.save.readSave();
//            gp.ps.setStats();
//            gp.es.setStats();
            String text;
            String readtext;

            gp.uic.max = 3;
            gp.uic.min = 1;

            g2.setFont(arial_40);
            g2.setColor(Color.black);
            text = "Battle Start";
            x = setcenter_X(text, g2);
            g2.drawString(text, x, 50);
            
            
            g2.setColor(Color.white);
            g2.setFont(for_battle_stats);
            
            // player
            text = "Lv :";
            g2.drawString(text, 60, 110);
            readtext = String.valueOf(gp.ps.currentlv);
            g2.drawString(readtext, 110, 110);
            text = "HP :";
            g2.drawString(text, 60, 130);
            readtext = String.valueOf(gp.ps.currentHp);
            g2.drawString(readtext, 110, 130);
            int newX = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
            g2.drawString("/", 110 + newX + 10, 130);
            readtext = String.valueOf(gp.ps.maxHp);
            g2.drawString(readtext, 110 + newX + 25, 130);
            
            
            text = "ATK :";
            g2.drawString(text, 60, 240);
            readtext = String.valueOf(gp.ps.atk);
            g2.drawString(readtext, 120, 240);
            text = "DEF :";
            g2.drawString(text, 60, 260);
            readtext = String.valueOf(gp.ps.def);
            g2.drawString(readtext, 120, 260);
            text = "EXP :";
            g2.drawString(text, 60, 280);
            readtext = String.valueOf(gp.ps.currentExp);
            g2.drawString(readtext, 120, 280);
            newX = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
            g2.drawString("/", 120 + newX + 10, 280);
            readtext = String.valueOf(gp.ps.maxExp);
            g2.drawString(readtext, 120 + newX + 30, 280);

            //enemy
            text = "Lv :";
            g2.drawString(text, 550, 110);
            readtext = String.valueOf(gp.es.enemylv);
            g2.drawString(readtext, 600, 110);
            text = "HP :";
            g2.drawString(text, 550, 130);
            readtext = String.valueOf(gp.es.currentHp);
            g2.drawString(readtext, 600, 130);
            newX = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
            g2.drawString("/", 600 + newX + 10, 130);
            readtext = String.valueOf(gp.es.maxHp);
            g2.drawString(readtext, 600 + newX + 25, 130);
            
            
            text = "ATK :";
            g2.drawString(text, 550, 240);
            readtext = String.valueOf(gp.es.atk);
            g2.drawString(readtext, 610, 240);
            text = "DEF :";
            g2.drawString(text, 550, 260);
            readtext = String.valueOf(gp.es.def);
            g2.drawString(readtext, 610, 260);

            //Command
            text = "Attack";
            g2.drawString(text, 125, 375);
            if (gp.uic.command == 1) {
                g2.drawString(">", 105, 375);
            }

            text = "Defence";
            g2.drawString(text, 325, 375);
            if (gp.uic.command == 2) {
                g2.drawString(">", 305, 375);
            }

            text = "Run";
            g2.drawString(text, 525, 375);
            if (gp.uic.command == 3) {
                g2.drawString(">", 505, 375);
            }

        } else if (gp.gameStatus == "gameOver") {
            g2.drawImage(bg_gameOver, 0,0,gp.ScreenWidth,gp.ScreenHeight,null);
            gp.uic.max = 2;
            gp.uic.min = 1;
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            text = "Game Over";
            x = setcenter_X(text, g2);
//            y=gp.ScreenHeight/2 - (gp.titlesize*3);  // set y center
            g2.drawString(text, x, 140);

            //Return to menu
            text = "Return to menu";
            x = setcenter_X(text, g2);
            g2.drawString(text, x, 450);
            if (gp.uic.command == 1) {
                g2.drawString(">", x - 30, 450);
            }
            //Exit
            text = "Exit";
            x = setcenter_X(text, g2);
            g2.drawString(text, x, 500);
            if (gp.uic.command == 2) {
                g2.drawString(">", x - 30, 500);
            }
        }
    }

    public void dialog(Graphics2D g2) {
        if (gp.gameStatus == "battle") {
            if (gp.gl.dia == "attack") {
                g2.setFont(for_battle_stats);
                g2.setColor(Color.white);
                String text;
                String readtext = "1";

                text = "You deal ";
                g2.drawString(text, 100, 400);
                if (gp.es.def < gp.ps.atk) {
                    readtext = String.valueOf(gp.ps.atk - gp.es.def);
                } else if (gp.es.def >= gp.ps.atk) {
                    readtext = "1";
                }
                g2.drawString(readtext, 195, 400);
                x = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
                g2.drawString("damage", 195 + x + 10, 400);

                text = "You take ";
                g2.drawString(text, 100, 425);
                if (gp.ps.def < gp.es.atk) {
                    readtext = String.valueOf(gp.es.atk - gp.ps.def);
                } else if (gp.ps.def >= gp.es.atk) {
                    readtext = "1";
                }
                g2.drawString(readtext, 195, 425);
                x = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
                g2.drawString("damage", 195 + x + 10, 425);

            } else if (gp.gl.dia == "defence") {
                g2.setFont(for_battle_stats);
                g2.setColor(Color.white);
                String text;
                String readtext = "1";

                text = "You take ";
                g2.drawString(text, 100, 400);
                int newdef = gp.ps.def * 2;
                if (newdef < gp.es.atk) {
                    readtext = String.valueOf(gp.es.atk - newdef);
                } else if (newdef >= gp.es.atk) {
                    readtext = "1";
                }
                g2.drawString(readtext, 195, 400);
                x = (int) g2.getFontMetrics().getStringBounds(readtext, g2).getWidth();
                g2.drawString("damage", 195 + x + 10, 400);
            }
            
        }
    }

    public int setcenter_X(String text, Graphics2D g2) {
        int text_L;
        text_L = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.ScreenWidth / 2 - text_L / 2;
        return x;
    }

}
