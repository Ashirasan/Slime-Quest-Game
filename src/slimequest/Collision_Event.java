package slimequest;

public class Collision_Event {

    GamePanel gp;
    public String eventListen = "none";

    public Collision_Event(GamePanel gp) {
        this.gp = gp;

    }

    public void Collision_Event_Update() {
        if (gp.gameState == "game_start") {
            if (eventListen == "heal") {
                System.out.println("Heal");
                heal();
            } else if (eventListen == "nextUp") {
                System.out.println("NextMapUp");
                nextMapUp();
            } else if (eventListen == "prevDown") {
                System.out.println("PrevMapDown");
                prevMapDown();
            } else if (eventListen == "shop") {
                gp.gameSupState = "shop";
                eventListen = "none";
            } else if (eventListen == "boss") {
                foundBoss();
                eventListen = "none";
            }
        }
    }

    public void heal() {
        gp.player_Stats.currentHp = gp.player_Stats.MaxHp;
        gp.player_Stats.currentMp = gp.player_Stats.MaxMp;
        eventListen = "none";
    }

    public void nextMapUp() {
//        gp.player.current_col
        gp.player.current_row = gp.max_row - 2;
        gp.map_m.num_of_map++;
        eventListen = "none";
    }

    public void prevMapDown() {
        gp.player.current_row = 1;
        gp.map_m.num_of_map--;
        eventListen = "none";
    }

    public void foundBoss() {
        gp.monster_Stats.Monster_found = "King Slime";
        gp.monster_Stats.mLv = 10;
        gp.monster_Stats.setMonsterStats();
        gp.gameState = "battle_menu";
        
    }

}
