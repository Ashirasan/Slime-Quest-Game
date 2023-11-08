package Entity;

import slimequest.GamePanel;


public class MonsterStats {
    
    GamePanel gp;
    public String Monster_found;
    public String Monster_List[] = {"error","Red slime","Mage slime","Knight slime","King Slime"};
    public int mLv;
    public int mMaxHp,mcurrentHp;
    public int mAtk,mDef;
    
    //reward 
    public int ExpReward,gold;
    

    public MonsterStats(GamePanel gp) {
        this.gp = gp;
        //test fix lv fix monster
    }
    
    public void setMonsterStats(){
        if(Monster_found == "Red slime"){
            mMaxHp = 30 + (mLv*20);
            mAtk = 5 + (mLv*5);
            mDef = (mLv*2);
            ExpReward = (mLv*15);
            gold = (mLv*3);
        }
        else if(Monster_found == "Mage slime"){
            mMaxHp = 20+(mLv*15);
            mAtk = 10 + (mLv*10);
            mDef = (mLv*2);
            ExpReward = (mLv*25);
            gold = (mLv*9);
        }
        else if(Monster_found == "Knight slime"){
            mMaxHp = 35+(mLv*35);
            mAtk = 8 + (mLv*7);
            mDef = (mLv*5);
            ExpReward = (mLv*30);
            gold = (mLv*12);
        }
        else if(Monster_found == "King Slime"){
            mMaxHp = (mLv*60);
            mAtk = (mLv*10);
            mDef = (mLv*7);
            ExpReward = (mLv*50);
            gold = (mLv*20);
        }
        mcurrentHp = mMaxHp;
    }
    
    
    
}
