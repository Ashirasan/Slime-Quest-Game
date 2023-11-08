
package Entity;

import slimequest.GamePanel;


public class Skill {
    GamePanel gp;
    public String SkillList[] = {"error","Fire Ball","Beam"};
//    public String DamageScaleList[] = {"error","2","10"};
//    public String ManaList[] = {"error","15","200"};
    public String SkillChoose;
    public int DamageScale,ManaUse;
    
    public Skill(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setSkill(){
        SkillChoose = SkillList[gp.ui_c.Num_command_Current];
        if(SkillChoose == "Fire Ball"){
            DamageScale = 3;
            ManaUse = 15;
        }
        else if(SkillChoose == "Beam"){
            DamageScale = 10;
            ManaUse = 200;
        }
//        DamageScale = DamageScaleList[gp.ui_c.Num_command_Current];
//        ManaUse = ManaList[gp.ui_c.Num_command_Current];
        // More Skill in Future
    }
    
}
