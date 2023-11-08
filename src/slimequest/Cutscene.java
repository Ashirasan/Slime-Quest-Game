package slimequest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cutscene {

    GamePanel gp;
    BufferedImage Start[], End[];
    public boolean cutsceneStatus = false;
    public int cutsceneNum = 1;

    public Cutscene(GamePanel gp) {
        this.gp = gp;
        Start = new BufferedImage[7];
        End = new BufferedImage[6];
        loadImage();
    }

    private void loadImage() {
        try {
            Start[1] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/start1.png"));
            Start[2] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/start2.png"));
            Start[3] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/start3.png"));
            Start[4] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/start4.png"));
            Start[5] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/start5.png"));
            Start[6] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/start6.png"));

            End[1] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/end1.png"));
            End[2] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/end2.png"));
            End[3] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/end3.png"));
            End[4] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/end4.png"));
            End[5] = ImageIO.read(getClass().getResourceAsStream("/picture/cutscene/end5.png"));

        } catch (IOException e) {

        }
    }

    public void draw_cutscene_start(Graphics g) {
        int maxNum = 6;
        //end cutscene
        if (maxNum < cutsceneNum) {
            cutsceneStatus = false;
            gp.monster_Stats.Monster_found = "Red slime";
            gp.monster_Stats.mLv = 1;
            gp.monster_Stats.setMonsterStats();
            gp.gameState = "battle_menu";
            gp.gameSupState = "none";
            cutsceneNum = 1;
        } else {
            cutsceneStatus = true;
        }
        try {
            g.drawImage(Start[cutsceneNum], 0, 0, gp.max_width, gp.max_height, null);
            g.setColor(Color.white);
            if (cutsceneNum != 1) {
                g.fillRect(50, 410, 670, 170);
                g.setColor(Color.gray);
                g.fillRect(60, 420, 650, 150);
            }

        } catch (Exception e) {
            System.out.println("End cutscene");
        }
        if (cutsceneNum == 1) {
            g.setFont(gp.ui.PixelMplus60r);
            g.setColor(Color.WHITE);
            String text = "Slime Quest";
            int x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 150);
            text = "Chapter : 1";
            x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 250);
            text = "The Slime Forest";
            x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 350);

//            g.setColor(Color.WHITE);
//            g.setFont(gp.ui.PixelMplus20r);
//            text = "In the darkness ... you can't see anything";
//            g.drawString(text, 70, 440);
        } else if (cutsceneNum == 2) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "In the darkness ... you can't see anything.";
            g.drawString(text, 70, 440);
            text = "Util the light has come.";
            g.drawString(text, 70, 460);
        } else if (cutsceneNum == 3) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "Me : Arghhhhhhh my eyeeee";
            g.drawString(text, 70, 440);
            text = "Me : Where am i ?";
            g.drawString(text, 70, 460);
            text = "Me : This is forest ?";
            g.drawString(text, 70, 480);
        } else if (cutsceneNum == 4) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "Me : Why am here and who i am.";
            g.drawString(text, 70, 440);
            text = "Me : Ah Overthere have a monster";
            g.drawString(text, 70, 460);
            text = "Me : wait... i am monster too ?";
            g.drawString(text, 70, 480);
            text = "Me : May be i should ask him what happen to me";
            g.drawString(text, 70, 500);
        } else if (cutsceneNum == 5) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "Red Slime : Kill him as my King order.";
            g.drawString(text, 70, 440);
            text = "Me : Whoa! slowdown i am slime too";
            g.drawString(text, 70, 460);
            text = "Red Slime : No this is my King order";
            g.drawString(text, 70, 480);
        } else if (cutsceneNum == 6) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "Me : Okkk , Come on i will deal with you.";
            g.drawString(text, 70, 440);
            text = "Me : And go to your King ask him what happen to me";
            g.drawString(text, 70, 460);
        }
    }

    public void draw_cutscene_end(Graphics g) {
        int maxNum = 5;
        //end cutscene
        if (maxNum < cutsceneNum) {
            cutsceneStatus = false;
//            gp.monster_Stats.Monster_found = "Red slime";
//            gp.monster_Stats.mLv = 1;
//            gp.monster_Stats.setMonsterStats();
            gp.gameState = "main_menu";
            gp.gameSupState = "none";
            cutsceneNum = 1;
        } else {
            cutsceneStatus = true;
        }
        try {
            g.drawImage(End[cutsceneNum], 0, 0, gp.max_width, gp.max_height, null);
            g.setColor(Color.white);
            if (cutsceneNum != 5) {
                g.fillRect(50, 410, 670, 170);
                g.setColor(Color.gray);
                g.fillRect(60, 420, 650, 150);
            }

        } catch (Exception e) {
            System.out.println("End cutscene");
        }
        if (cutsceneNum == 1) {
//            g.setFont(gp.ui.PixelMplus60r);
//            g.setColor(Color.WHITE);
//            String text = "Slime Quest";
//            int x = gp.ui.setcenter_X(text, g);
//            g.drawString(text, x, 150);
//            text = "Chapter : 1";
//            x = gp.ui.setcenter_X(text, g);
//            g.drawString(text, x, 250);
//            text = "The Slime Forest";
//            x = gp.ui.setcenter_X(text, g);
//            g.drawString(text, x, 350);

            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "King Slime : No wayyyyy, Why.. why am lose.";
            g.drawString(text, 70, 440);
            text = "King Slime : It is impossible.";
            g.drawString(text, 70, 460);
        } else if (cutsceneNum == 2) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "King Slime : Nooooo my Lord give me another chance";
            g.drawString(text, 70, 440);
            text = "King Slime : I will not lose again.....";
            g.drawString(text, 70, 460);
        }else if (cutsceneNum == 3) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "King Slime : .............";
            g.drawString(text, 70, 440);
            text = "Me : W... What happen ?";
            g.drawString(text, 70, 460);
        }
        else if (cutsceneNum == 4) {
            String text;
            int x;
            g.setColor(Color.WHITE);
            g.setFont(gp.ui.PixelMplus20r);
            text = "Me : Why he melt to liquid";
            g.drawString(text, 70, 440);
            text = "Me : What should i do after this";
            g.drawString(text, 70, 460);
            text = "Me : Wait.. ,He say 'My Lord' ";
            g.drawString(text, 70, 480);
            text = "Me : Maybe i should go somewhere and find him Lord";
            g.drawString(text, 70, 500);
            text = "Me : Ok let go,Now my journey has begin";
            g.drawString(text, 70, 520);
        }
        else if (cutsceneNum == 5) {
            g.setFont(gp.ui.PixelMplus60r);
            g.setColor(Color.WHITE);
            String text = "Chapter : 2";
            int x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 150);
            text = "The Journey Begin";
            x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 250);
            text = "Coming Soon....";
            x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 350);
            text = "Made by Achi";
            x = gp.ui.setcenter_X(text, g);
            g.drawString(text, x, 450);
           
        }
        
    }

}
