
package entity;

import slimequest.GamePanel;

public class enemyStats {
    GamePanel gp;
    public int enemylv ;
    public int maxHp;
    public int currentHp;
    public int atk;
    public int def;
    
    public enemyStats(GamePanel gp){
        this.gp = gp;
    }
    
    public void setStats(){
        maxHp = 30 + (enemylv-1)*10;
        currentHp = maxHp;
        atk = 8 + (enemylv-1)*5;
        def = 2 + (enemylv-1)*2;
    }
}
