
package slimequest;
public class CollisionEvent{
    GamePanel gp;
    public String eventCheck;
    
    public CollisionEvent(GamePanel gp){
          this.gp = gp;
    }
    
    public void EventCheck(){
        System.out.println(eventCheck);
        if(eventCheck == "nextmap" || eventCheck == "prevmap"){
              
              int currentMap = gp.tm.NumOfMap;
              if(currentMap == 1){
                  System.out.println("set new");
                  gp.player.x = 580;
                  gp.player.y = 460;
              }
              else if(currentMap == 2){
                  System.out.println("set new");
                  gp.player.x = 236;
                  gp.player.y = 52;
              }
              if(eventCheck == "nextmap"){
                  gp.tm.NumOfMap++;
              }else if(eventCheck == "prevmap"){
                  gp.tm.NumOfMap--;
              }
//            System.out.println("1");   
        }
        else if(eventCheck == "heal"){
            gp.ps.currentHp = gp.ps.maxHp;
        }
        
        
        eventCheck = "none";
//        System.out.println(eventCheck);
    }
}
