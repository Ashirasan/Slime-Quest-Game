package slimequest;

import java.awt.Color;
import java.awt.Graphics;

public class Notice {

    GamePanel gp;

    public String noticeTitle = "none";

    //battle attack defense
    public String noticeTotalDamege, noticeTotalManaRegen, noticeTotalDef;
    //battle use item
    public String noticeItemUse, noticeTotalHeal, noticeUseItemComplete;
    //battle use skill
    public String noticeTotalDamageSkill, noticeSkillUse, noticeUseSkillComplete;
    //battle run
    public String noticeRunComplete;
    //battle result
    public String noticeBattleResult, noticeExpReward, noticeGoldReward;

    public Notice(GamePanel gp) {
        this.gp = gp;
    }

    public void draw_Player_Attack_notice(Graphics g) {
        int x;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        g.drawString("Player use Attack to", 170, 320);
        g.drawString(gp.monster_Stats.Monster_found, 390, 320);
        g.drawString("Player deal ", 170, 350);
        g.drawString(noticeTotalDamege, 300, 350);
        x = gp.ui.getTextLength(noticeTotalDamege, g);
        g.drawString("damage", 300 + x + 20, 350);
        g.drawString("to", 170, 380);
        g.drawString(gp.monster_Stats.Monster_found, 200, 380);
        g.drawString("Press 'Enter' to Continuous", 170, 520);

    }

    public void draw_Monster_Attack_notice(Graphics g) {
        int x, xdamage;
        String Monster = gp.monster_Stats.Monster_found;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        x = gp.ui.getTextLength(Monster, g);
        g.drawString(Monster, 170, 320);
        g.drawString("use Attack to Player", 170 + x + 10, 320);

        g.drawString(Monster, 170, 350);
        g.drawString("deal ", 170 + x + 10, 350);
        g.drawString(noticeTotalDamege, 170 + x + 10 + 50, 350);
        xdamage = gp.ui.getTextLength(noticeTotalDamege, g);
        g.drawString("damage", 170 + x + 10 + 50 + xdamage + 10, 350);
        g.drawString("to Player", 170, 380);
        g.drawString("Press 'Enter' to Continuous", 170, 520);
    }

    public void draw_Player_Defense(Graphics g) {
        int x, xdamage, xdef;
        String Monster = gp.monster_Stats.Monster_found;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        g.drawString("Player use Defense", 170, 320);
        g.drawString("Player Def boots to", 170, 350);
        g.drawString(noticeTotalDef, 380, 350);

        x = gp.ui.getTextLength(Monster, g);
        xdamage = gp.ui.getTextLength(noticeTotalDamege, g);
        g.drawString(Monster, 170, 380);
        g.drawString("deal ", 170 + x + 10, 380);
        g.drawString(noticeTotalDamege, 170 + x + 10 + 50, 380);
        g.drawString("damage", 170 + x + 10 + 50 + xdamage + 10, 380);

        x = gp.ui.getTextLength(noticeTotalManaRegen, g);
        g.drawString("Player gain", 170, 410);
        g.drawString(noticeTotalManaRegen, 300, 410);
        g.drawString("mana", 300 + x + 10, 410);

        g.drawString("Press 'Enter' to Continuous", 170, 520);
    }

    public void draw_UseItem(Graphics g) {
        int x;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        if (noticeItemUse == "NoUse") {
            g.drawString("Player don't have Item", 170, 320);
        } else {
            g.drawString("Player Use", 170, 320);
            g.drawString(noticeItemUse, 280, 320);
            g.drawString("Player has been Heal", 170, 350);
            g.drawString(noticeTotalHeal, 390, 350);
        }

        g.drawString("Press 'Enter' to Continuous", 170, 520);
    }

    public void draw_UseSkill(Graphics g) {
        int x;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        if (noticeUseSkillComplete == "no") {
            g.drawString("Player don't enough Mana", 170, 320);
        } else if (noticeUseSkillComplete == "yes") {
            g.drawString("Player Use", 170, 320);
            g.drawString(noticeSkillUse, 280, 320);
            g.drawString("Player deal", 170, 350);
            x = gp.ui.getTextLength(noticeTotalDamageSkill, g);
            g.drawString(noticeTotalDamageSkill, 290, 350);
            g.drawString("damage", 290 + x + 10, 350);
        }
        g.drawString("Press 'Enter' to Continuous", 170, 520);
    }

    public void draw_Run(Graphics g) {
        int x;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        if (noticeRunComplete == "no") {
            g.drawString("Player fail to escape from monster", 170, 320);
        } else if (noticeRunComplete == "yes") {
            g.drawString("Player run away from monster", 170, 320);
        }

        g.drawString("Press 'Enter' to Continuous", 170, 520);
    }

    public void draw_result(Graphics g) {
        int x;
        g.fillRect(144, 265, 480, 288);
        g.setColor(Color.gray);
        g.fillRect(154, 275, 460, 268);
        g.setColor(Color.black);

        if (noticeBattleResult == "win") {
            g.drawString("Player defeat Monster", 170, 320);
            g.drawString("Player gain Exp", 170, 350);
            g.drawString(noticeExpReward, 340, 350);
            g.drawString("Player gain Gold", 170, 380);
            g.drawString(noticeGoldReward, 350, 380);
        } else if (noticeBattleResult == "lose") {
            g.drawString("Player has been defeat by Monster", 170, 320);
        }

        g.drawString("Press 'Enter' to Continuous", 170, 520);
    }

    public void draw_Found_Monster(Graphics g) {
        int x;
        String text;
        g.fillRect(144, 155, 480, 278);
        g.setColor(Color.gray);
        g.fillRect(154, 165, 460, 258);
        g.setColor(Color.black);
        
        g.setFont(gp.ui.PixelMplus40r);
        text = "Alert";
        x = gp.ui.setcenter_X(text, g);
        g.drawString(text, x, 210);
        
        g.setFont(gp.ui.PixelMplus20r);
        text = "Player Found Monster";
        x = gp.ui.setcenter_X(text, g);
        g.drawString(text, x, 240);
        
        g.drawString("Press 'Enter' to Continuous", 170, 400);
    }
    public void draw_Lu_Up(Graphics g){
        int x,xread;
        int oldLvValue = gp.player_Stats.lv - 1;
        String text;
        String oldLv = String.valueOf(gp.player_Stats.lv - 1);
        String newLv = String.valueOf(gp.player_Stats.lv);
        String oldHp = String.valueOf(50 + (oldLvValue * 50)), newHp = String.valueOf(gp.player_Stats.MaxHp);
        String oldMp = String.valueOf(10 + (oldLvValue * 10)), newMp = String.valueOf(gp.player_Stats.MaxMp);
        String oldAtk = String.valueOf(10 + (oldLvValue * 5)), newAtk = String.valueOf(gp.player_Stats.Atk);
        String oldDef = String.valueOf((oldLvValue * 5)), newDef = String.valueOf(gp.player_Stats.Def);
        String oldExp = String.valueOf(50 + (oldLvValue * 25)), newExp = String.valueOf(gp.player_Stats.MaxExp);
        
        
        g.fillRect(144, 155, 480, 278);
        g.setColor(Color.gray);
        g.fillRect(154, 165, 460, 258);
        g.setColor(Color.black);
        
        g.setFont(gp.ui.PixelMplus40r);
        text = "Level Up";
        x = gp.ui.setcenter_X(text, g);
        g.drawString(text, x, 210);
        
        //lv
        g.setFont(gp.ui.PixelMplus20r);
        g.drawString("Lv :", 250, 240);
        g.drawString(oldLv, 300, 240);
        xread = gp.ui.getTextLength(oldLv, g);
        g.drawString("---->", 300+xread+10, 240);
        g.drawString(newLv, 300+xread+10+60, 240);
        
        //Hp
        g.drawString("Hp :", 250, 270);
        g.drawString(oldHp, 300, 270);
        xread = gp.ui.getTextLength(oldHp, g);
        g.drawString("---->", 300+xread+10, 270);
        g.drawString(newHp, 300+xread+10+60, 270);
        
        //Mp
        g.drawString("Mana :", 250, 300);
        g.drawString(oldMp, 320, 300);
        xread = gp.ui.getTextLength(oldMp, g);
        g.drawString("---->", 320+xread+10, 300);
        g.drawString(newMp, 320+xread+10+60, 300);
        
        //Atk
        g.drawString("Atk :", 250, 330);
        g.drawString(oldAtk, 310, 330);
        xread = gp.ui.getTextLength(oldAtk, g);
        g.drawString("---->", 310+xread+10, 330);
        g.drawString(newAtk, 310+xread+10+60, 330);
        
        //Def
        g.drawString("Def :", 250, 360);
        g.drawString(oldDef, 310, 360);
        xread = gp.ui.getTextLength(oldDef, g);
        g.drawString("---->", 310+xread+10, 360);
        g.drawString(newDef, 310+xread+10+60, 360);
        
        //Exp
        g.drawString("Exp :", 250, 390);
        g.drawString(oldExp, 310, 390);
        xread = gp.ui.getTextLength(oldExp, g);
        g.drawString("---->", 310+xread+10, 390);
        g.drawString(newExp, 310+xread+10+60, 390);
    }
}
