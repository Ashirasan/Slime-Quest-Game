
package slimequest;
import java.util.Random;

public class GameLogic {
    GamePanel gp;
    String battleCommand = "none";
    String dia = "none";
    public GameLogic(GamePanel gp){
        this.gp = gp;
        
    }
    
    public void useLogic(){
        if(gp.gameStatus == "gameStart"){
            if(gp.player.countWalk == 150)
            foundEnemy();
        }
        else if(gp.gameStatus == "battle"){
            if(battleCommand == "attack"){
                attack();
                dia = "attack";
            }
            else if(battleCommand == "defence"){
                defence();
                dia = "defence";
            }
            checkBattle();
            battleCommand = "none";
        }
        levelup();
    }
    
    public void attack(){
        if(gp.es.def<gp.ps.atk){
           gp.es.currentHp = gp.es.currentHp - gp.ps.atk + gp.es.def; 
        }
        else if(gp.es.def>=gp.ps.atk){
            gp.es.currentHp -=1;
        }
        
        if(gp.ps.def<gp.es.atk){
            gp.ps.currentHp = gp.ps.currentHp - gp.es.atk + gp.ps.def;
        }
        else if(gp.ps.def>=gp.es.atk){
            gp.ps.currentHp -=1;
        }
        
    }
    
    public void defence(){
        int newdef = gp.ps.def *2;
        if(newdef<gp.es.atk){
            gp.ps.currentHp = gp.ps.currentHp - gp.es.atk + newdef;
        }
        else if(newdef>=gp.es.atk){
            gp.ps.currentHp -= 1;
        }
    }
    
    public void checkBattle(){
        if(gp.ps.currentHp<=0){
            gp.ps.currentHp = 0;
            System.out.println("You lose");
            gp.gameStatus = "gameOver";
            dia = "none";
        }
        else if(gp.es.currentHp<=0){
            gp.es.currentHp = 0;
            System.out.println("You win");
            gp.gameStatus = "gameStart";
            winBattle();
            dia = "none";
        }
        else if(gp.es.currentHp<=0&&gp.ps.currentHp<=0){
            gp.ps.currentHp = 0;
            gp.es.currentHp = 0;
            System.out.println("You lose");
            gp.gameStatus = "gameOver";
            dia = "none";
        }
    }
    
    public void winBattle(){
        int expgain;
        expgain = (gp.es.enemylv*5)+10;
        gp.ps.currentExp+=expgain;
        
    }
    
    public void levelup(){
        int exp;
        if(gp.ps.currentExp>=gp.ps.maxExp){
            exp = gp.ps.currentExp - gp.ps.maxExp;
            gp.ps.currentlv++;
            gp.ps.setStats();
            gp.ps.currentExp = exp;
            gp.ps.currentHp = gp.ps.maxHp;
        }
    }
    
    public void foundEnemy(){
        System.out.println("Found enemy");
        Random rd = new Random();
        int enemyMinLv  , enemyMaxLv ;
        int rdLv;
        
        if(gp.tm.NumOfMap == 1){
            enemyMaxLv = 5;
            enemyMinLv = 1;
            rdLv = rd.nextInt(enemyMinLv,enemyMaxLv);
            gp.es.enemylv = rdLv;
        }
        else if(gp.tm.NumOfMap == 2){
            enemyMaxLv = 8;
            enemyMinLv = 4;
            rdLv = rd.nextInt(enemyMinLv,enemyMaxLv);
            gp.es.enemylv = rdLv;
        }
        gp.es.setStats();
        
        //set enemy
        gp.kc.wPressed =false;
        gp.kc.sPressed =false;
        gp.kc.dPressed =false;
        gp.kc.aPressed =false;
        gp.ao.enemy = "redslime";
        gp.gameStatus = "battle";
        gp.player.countWalk = 0;
    }
    
}
