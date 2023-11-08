package Entity;

import slimequest.GamePanel;

public class PlayerStats {

    GamePanel gp;
    public int lv;
    public int MaxHp, currentHp;
    public int MaxMp, currentMp;
    public int Atk, Def;
    public int MaxExp, currentExp;
    public int currentGold;

    public PlayerStats(GamePanel gp) {
        this.gp = gp;
        //test 
        lv = 1;

    }

    public void setPlayerStats() {
        MaxHp = 50 + (lv * 50);
        MaxMp = 10 + (lv * 10);
        Atk = 10 + (lv * 5);
        Def = (lv * 5);
        MaxExp = 50 + (lv * 25);
    }
    
    public void loadStats(){
        
    }

}
