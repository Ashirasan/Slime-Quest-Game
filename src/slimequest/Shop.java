
package slimequest;


public class Shop {
    GamePanel gp;
    public int hpPotionNum = 0,LhpPotionNum = 0;
    public int mpPotionNum = 0,LmpPotionNum = 0;
    public int hpPotionPrice = 20,LhpPotionPrice = 50;
    public int mpPotionPrice = 25,LmpPotionPrice = 60;
    public int totalPrice = 0;

    public Shop(GamePanel gp) {
        this.gp = gp;
    }
    
    public void shop_check(){
        if(hpPotionNum<0){
            hpPotionNum = 0;
        } else if(LhpPotionNum<0){
            LhpPotionNum = 0;
        } else if(mpPotionNum<0){
            mpPotionNum = 0;
        } else if(LmpPotionNum<0){
            LmpPotionNum = 0;
        }
    }
    
    public void calTotalPrice(){
        totalPrice = hpPotionNum*hpPotionPrice + LhpPotionNum*LhpPotionPrice + mpPotionNum*mpPotionPrice + LmpPotionNum*LmpPotionPrice;
    }
    
    public void buy(){
        gp.player_Stats.currentGold -= totalPrice;
        gp.inventory.HpPotionHave += hpPotionNum;
        gp.inventory.LHpPotionHave += LhpPotionNum;
        gp.inventory.MpPotionHave += mpPotionNum;
        gp.inventory.LHpPotionHave += LmpPotionNum;
        setShopDefault();
    }
    
    public void setShopDefault(){
        hpPotionNum=0;
        LhpPotionNum=0;
        mpPotionNum=0;
        LmpPotionNum=0;
        totalPrice = 0;
    }
}
