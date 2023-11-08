package slimequest;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UI {

    GamePanel gp;
    BufferedImage main_menu, battle_menu;
    Font pixelSan100sb, pixelSan60sb, pixelSan20sb;
    Font pixelSan20r;
    Font PixelMplus20r,PixelMplus40r,PixelMplus60r;

    UI(GamePanel gp) {
        this.gp = gp;
        loadFont();
        // load Image
        loadImage();

    }
///customFont/

    private void loadFont() {
        try {
            pixelSan100sb = Font.createFont(Font.TRUETYPE_FONT, new File("PixelifySans-SemiBold.ttf")).deriveFont(100f);
            pixelSan60sb = Font.createFont(Font.TRUETYPE_FONT, new File("PixelifySans-SemiBold.ttf")).deriveFont(60f);
            pixelSan20sb = Font.createFont(Font.TRUETYPE_FONT, new File("PixelifySans-SemiBold.ttf")).deriveFont(20f);
            pixelSan20r = Font.createFont(Font.TRUETYPE_FONT, new File("PixelifySans-Regular.ttf")).deriveFont(20f);

            PixelMplus20r = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(20f);
            PixelMplus40r = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(40f);
            PixelMplus60r = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(80f);

        } catch (IOException | FontFormatException e) {
            System.out.println("Cant load font");
        }
    }

    private void loadImage() {
        try {
            main_menu = ImageIO.read(getClass().getResourceAsStream("/picture/menu/main_menu.png"));
            battle_menu = ImageIO.read(getClass().getResourceAsStream("/Picture/menu/battle_menu.png"));
        } catch (IOException e) {
            System.out.println("Cant load Image");
        }
    }

    public void draw_main_menu(Graphics g) {
        gp.ui_c.Num_command_min = 1;
        gp.ui_c.Num_command_max = 3;

        String text;
        int x;
        g.drawImage(main_menu, 0, 0, gp.max_width, gp.max_height, null);

        g.setColor(Color.white);
        g.setFont(pixelSan100sb);

        text = "Slime Quest";
        x = setcenter_X(text, g);
        g.drawString(text, x, 150);

        g.setFont(pixelSan60sb);
        text = "New Game";
        x = setcenter_X(text, g);
        g.drawString(text, x, 250);
        if (gp.ui_c.Num_command_Current == 1) {
            g.drawString(">", x - 40, 250);
        }

        text = "Continous";
        x = setcenter_X(text, g);
        g.drawString(text, x, 350);
        if (gp.ui_c.Num_command_Current == 2) {
            g.drawString(">", x - 40, 350);
        }

        text = "Exit";
        x = setcenter_X(text, g);
        g.drawString(text, x, 450);
        if (gp.ui_c.Num_command_Current == 3) {
            g.drawString(">", x - 40, 450);
        }

    }

    public void draw_battle_menu(Graphics g) {
        gp.ui_c.Num_command_min = 1;
        gp.ui_c.Num_command_max = 5;
        String text, readtext;
        int x, readx;
        // backgound
        g.drawImage(battle_menu, 0, 0, gp.max_width, gp.max_height, null);

        // text title
        g.setFont(pixelSan60sb);
        text = "Battle Start";
        x = setcenter_X(text, g);
        g.drawString(text, x, 50);

        // text menu
        g.setFont(pixelSan20sb);
        text = "Attack";
        x = setcenter_X(text, g);
        g.drawString(text, x, 365);
        if (gp.ui_c.Num_command_Current == 1) {
            g.drawString(">", x - 20, 365);
        }

        text = "Defense";
        x = setcenter_X(text, g);
        g.drawString(text, x, 405);
        if (gp.ui_c.Num_command_Current == 2) {
            g.drawString(">", x - 20, 405);
        }

        text = "Skill";
        x = setcenter_X(text, g);
        g.drawString(text, x, 445);
        if (gp.ui_c.Num_command_Current == 3) {
            g.drawString(">", x - 20, 445);
        }

        text = "Item";
        x = setcenter_X(text, g);
        g.drawString(text, x, 485);
        if (gp.ui_c.Num_command_Current == 4) {
            g.drawString(">", x - 20, 485);
        }

        text = "Run";
        x = setcenter_X(text, g);
        g.drawString(text, x, 525);
        if (gp.ui_c.Num_command_Current == 5) {
            g.drawString(">", x - 20, 525);
        }

        // Show player Stats
        g.setFont(PixelMplus20r);
        //LV
        text = "Lv :";
        g.drawString(text, 50, 365);
        readtext = String.valueOf(gp.player_Stats.lv);
        g.drawString(readtext, 100, 365);

        //HP
        text = "HP :";
        g.drawString(text, 50, 405);
        // current hp
        readtext = String.valueOf(gp.player_Stats.currentHp);
        g.drawString(readtext, 100, 405);
        readx = getTextLength(readtext, g);
        g.drawString("/", 100 + readx + 5, 405);
        // Max hp
        readtext = String.valueOf(gp.player_Stats.MaxHp);
        g.drawString(readtext, 100 + readx + 5 + 15, 405);

        //MP
        text = "Mana :";
        g.drawString(text, 50, 445);
        readtext = String.valueOf(gp.player_Stats.currentMp);
        g.drawString(readtext, 120, 445);
        readx = getTextLength(readtext, g);
        g.drawString("/", 120 + readx + 5, 445);
        // Max hp
        readtext = String.valueOf(gp.player_Stats.MaxMp);
        g.drawString(readtext, 120 + readx + 5 + 15, 445);

        //Atk
        text = "Atk :";
        g.drawString(text, 50, 485);
        readtext = String.valueOf(gp.player_Stats.Atk);
        g.drawString(readtext, 110, 485);

        //Def
        text = "Def :";
        g.drawString(text, 50, 525);
        readtext = String.valueOf(gp.player_Stats.Def);
        g.drawString(readtext, 110, 525);

        // Monster stats
        //LV
        text = "Lv :";
        g.drawString(text, 540, 365);
        readtext = String.valueOf(gp.monster_Stats.mLv);
        g.drawString(readtext, 590, 365);

        //HP
        text = "HP :";
        g.drawString(text, 540, 405);
        // current hp
        readtext = String.valueOf(gp.monster_Stats.mcurrentHp);
        g.drawString(readtext, 590, 405);
        readx = getTextLength(readtext, g);
        g.drawString("/", 590 + readx + 5, 405);
        // Max hp
        readtext = String.valueOf(gp.monster_Stats.mMaxHp);
        g.drawString(readtext, 590 + readx + 5 + 15, 405);

        //Atk
        text = "Atk :";
        g.drawString(text, 540, 445);
        readtext = String.valueOf(gp.monster_Stats.mAtk);
        g.drawString(readtext, 600, 445);

        //Def
        text = "Def :";
        g.drawString(text, 540, 485);
        readtext = String.valueOf(gp.monster_Stats.mDef);
        g.drawString(readtext, 600, 485);

    }

    public void draw_Item_Battle_menu(Graphics g) {
        gp.ui_c.Num_command_min = 1;
        gp.ui_c.Num_command_max = 4;
        int x;
        String text,textread;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);
        
        g.setFont(PixelMplus40r);
        text = "Inventory";
        x = setcenter_X(text, g);
        g.drawString(text, x, 320);
        
        g.setFont(PixelMplus20r);
        
        g.drawString("HP Potion", 190, 360);
        textread = String.valueOf(gp.inventory.HpPotionHave);
        g.drawString(textread, 420, 360);
        if(gp.ui_c.Num_command_Current == 1){
            g.drawString(">", 170, 360);
        }
        
        g.drawString("Large HP Potion", 190, 390);
        textread = String.valueOf(gp.inventory.LHpPotionHave);
        g.drawString(textread, 420, 390);
        if(gp.ui_c.Num_command_Current == 2){
            g.drawString(">", 170, 390);
        }
        
        g.drawString("Mana Potion", 190, 420);
        textread = String.valueOf(gp.inventory.MpPotionHave);
        g.drawString(textread, 420, 420);
        if(gp.ui_c.Num_command_Current == 3){
            g.drawString(">", 170, 420);
        }
        
        g.drawString("Large Mana Potion", 190, 450);
        textread = String.valueOf(gp.inventory.LMpPotionHave);
        g.drawString(textread, 420, 450);
        if(gp.ui_c.Num_command_Current == 4){
            g.drawString(">", 170, 450);
        }
        
        
        g.drawString("Press 'Enter' to Use Item", 170, 490);
        g.drawString("Press 'Esc' Back to Menu", 170, 520);
    }
    
    public void draw_Skill_menu(Graphics g){
        gp.ui_c.Num_command_min = 1;
        gp.ui_c.Num_command_max = gp.skill.SkillList.length-1;
        gp.skill.setSkill();
//        System.out.print(gp.ui_c.Num_command_max);
        int x,xread;
        String text,textread;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);
        
        g.setFont(PixelMplus40r);
        text = "Skill Choose";
        x = setcenter_X(text, g);
        g.drawString(text, x, 320);
        g.setFont(PixelMplus20r);
        
        text = gp.skill.SkillList[gp.ui_c.Num_command_Current];
        x = setcenter_X(text, g);
        xread = getTextLength(text, g);
        g.drawString(text, x, 370);
        g.drawString("<", x-20, 370);
        g.drawString(">", x+xread+10, 370);
        
        g.drawString("Damage Scale Atk x", 200, 410);
        g.drawString(String.valueOf(gp.skill.DamageScale), 400, 410);
        g.drawString("Mana Use", 200, 440);
        g.drawString(String.valueOf(gp.skill.ManaUse), 290, 440);
        
//        gp.skill.DamageScaleList[gp.ui_c.Num_command_Current]
//        gp.skill.ManaList[gp.ui_c.Num_command_Current]

        
        g.drawString("Press 'Enter' to Use Skill", 170, 490);
        g.drawString("Press 'Esc' Back to Menu", 170, 520);
    }
    
    public void draw_menu_InGame(Graphics g){
        gp.ui_c.Num_command_min = 1;
        gp.ui_c.Num_command_max = 3;
        int x,xread;
        String text,textread;
        g.fillRect(80, 80, 240, 340);
        g.setColor(Color.gray);
        g.fillRect(90, 90, 220, 320);
        g.setColor(Color.black);
        
        g.setFont(PixelMplus40r);
        g.drawString("Stats", 100, 130);
        g.setFont(PixelMplus20r);
        
        g.drawString("Lv :", 100, 160);
        g.drawString(String.valueOf(gp.player_Stats.lv), 150, 160);
        
        text = String.valueOf(gp.player_Stats.MaxHp);
        textread = String.valueOf(gp.player_Stats.currentHp);
        g.drawString("Hp :", 100, 190);
        g.drawString(textread, 150, 190);
        xread = getTextLength(textread, g);
        g.drawString("/", 150+xread+10, 190);
        g.drawString(text, 150+xread+10+20, 190);
        
        text = String.valueOf(gp.player_Stats.MaxMp);
        textread = String.valueOf(gp.player_Stats.currentMp);
        g.drawString("Mana :", 100, 220);
        g.drawString(textread, 170, 220);
        xread = getTextLength(textread, g);
        g.drawString("/", 170+xread+10, 220);
        g.drawString(text, 170+xread+10+20, 220);
        
        text = String.valueOf(gp.player_Stats.Atk);
        textread = String.valueOf(gp.player_Stats.Atk);
        g.drawString("Atk :", 100, 250);
        g.drawString(textread, 160, 250);
        
        textread = String.valueOf(gp.player_Stats.Def);
        g.drawString("Def :", 100, 280);
        g.drawString(textread, 160, 280);
        
        text = String.valueOf(gp.player_Stats.MaxExp);
        textread = String.valueOf(gp.player_Stats.currentExp);
        g.drawString("Exp :", 100, 310);
        g.drawString(textread, 160, 310);
        xread = getTextLength(textread, g);
        g.drawString("/", 170+xread+10, 310);
        g.drawString(text, 170+xread+10+20, 310);
        
        g.setFont(PixelMplus40r);
        g.drawString("Gold", 100, 355);
        g.setFont(PixelMplus20r);
        g.drawString(String.valueOf(gp.player_Stats.currentGold), 100, 380);
        
        
    }
    
    public void draw_system(Graphics g){
        g.setColor(Color.black);        
        g.fillRect(450, 200, 240, 220);
        g.setColor(Color.gray);
        g.fillRect(460, 210, 220, 200);
        g.setColor(Color.black); 
        
        g.setFont(PixelMplus40r);
        g.drawString("Menu", 470, 250);
        
        g.drawString("Item", 500, 290);
        if(gp.ui_c.Num_command_Current == 1){
            g.drawString(">", 480, 290);
        }
        g.drawString("Save", 500, 330);
        if(gp.ui_c.Num_command_Current == 2){
            g.drawString(">", 480, 330);
        }
        
        g.drawString("Exit", 500, 370);
        if(gp.ui_c.Num_command_Current == 3){
            g.drawString(">", 480, 370);
        } 
    }
    
    public void draw_use_item_in_game(Graphics g){
        g.setColor(Color.black);        
        g.fillRect(450, 150, 240, 270);
        g.setColor(Color.gray);
        g.fillRect(460, 160, 220, 250);
        g.setColor(Color.black); 
        
        g.setFont(PixelMplus40r);
        g.drawString("Item", 470, 200);
        
        g.setFont(PixelMplus20r);
        g.drawString("Hp Potion", 0, 0);
    }
    
    public void draw_shop(Graphics g){
        gp.ui_c.Num_command_min = 1;
        gp.ui_c.Num_command_max = 5;
        
        g.setColor(Color.black);        
        g.fillRect(100, 120, 560, 380);
        g.setColor(Color.gray);
        g.fillRect(110, 130, 540, 360);
        g.setColor(Color.black); 
        
        
        g.setFont(PixelMplus40r);
        g.drawString("Welcome to my shop", 150, 190);
        
        g.setFont(PixelMplus20r);
        g.drawString("Hp Potion", 170, 230);
        g.drawString(String.valueOf(gp.shop.hpPotionPrice)+" G", 380, 230);
        g.drawString(String.valueOf(gp.shop.hpPotionNum)+" ea", 470, 230);
        if(gp.ui_c.Num_command_Current == 1){
            g.drawString(">", 150, 230);
        }
        
        g.drawString("Large Hp Potion", 170, 260);
        g.drawString(String.valueOf(gp.shop.LhpPotionPrice)+" G", 380, 260);
        g.drawString(String.valueOf(gp.shop.LhpPotionNum)+" ea", 470, 260);
        if(gp.ui_c.Num_command_Current == 2){
            g.drawString(">", 150, 260);
        }
        
        g.drawString("Mana Potion", 170, 290);
        g.drawString(String.valueOf(gp.shop.mpPotionPrice)+" G", 380, 290);
        g.drawString(String.valueOf(gp.shop.mpPotionNum)+" ea", 470, 290);
        if(gp.ui_c.Num_command_Current == 3){
            g.drawString(">", 150, 290);
        }
        
        g.drawString("Mana Potion", 170, 320);
        g.drawString(String.valueOf(gp.shop.LmpPotionPrice)+" G", 380, 320);
        g.drawString(String.valueOf(gp.shop.LmpPotionNum)+" ea", 470, 320);
        if(gp.ui_c.Num_command_Current == 4){
            g.drawString(">", 150, 320);
        }
        
        if(gp.shop.totalPrice > gp.player_Stats.currentGold){
            g.setColor(Color.red);
        }else{
            g.setColor(Color.black);
        }
        g.drawString("Total", 170, 360);
        g.drawString(String.valueOf(gp.shop.totalPrice)+" G", 250, 360);
        
        g.setColor(Color.black);
        g.drawString("Gold you have : "+String.valueOf(gp.player_Stats.currentGold)+" G", 170, 390);
        
        g.drawString("Confirm buy", 170, 420);
        if(gp.ui_c.Num_command_Current == 5){
            g.drawString(">", 150, 420);
        }
        
        g.drawString("Press 'Esc' to exit shop", 170, 470);
    }

    public int setcenter_X(String text, Graphics g) {
        int text_L;
        text_L = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = gp.max_width / 2 - text_L / 2;
        return x;
    }

    public int getTextLength(String text, Graphics g) {
        int text_L;
        text_L = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
        return text_L;
    }

}
