
package entity;

import slimequest.GamePanel;

public class playerStats {
    GamePanel gp;
    //test
    public int currentlv;
    public int maxHp;
    public int currentHp;
    public int atk;
    public int def;
    public int maxExp;
    public int currentExp;
    
    
    public playerStats(GamePanel gp){
        this.gp = gp;
        
        
    }
    
    public void setStats(){
        maxHp = 50 + (currentlv-1)*10;
        atk = 10 + (currentlv-1)*5;
        def = 6 + (currentlv-1)*2;
        maxExp = 100 + (((currentlv-1)*100)/2);
    }
    
    
}
