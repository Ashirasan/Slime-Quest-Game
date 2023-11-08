package slimequest;

public class Collision_Check {

    GamePanel gp;

    public Collision_Check(GamePanel gp) {
        this.gp = gp;
    }

    public void Collision_check_update() {
        try {
            if (gp.player.playerState == "up") {
                if (gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row - 1][gp.player.current_col]].consin == true) {
                    gp.player.playerCollision = true;
                }
                gp.c_event.eventListen = gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row - 1][gp.player.current_col]].Event;
            }
            else if (gp.player.playerState == "down") {
                if (gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row + 1][gp.player.current_col]].consin == true) {
                    gp.player.playerCollision = true;
                }
                gp.c_event.eventListen = gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row + 1][gp.player.current_col]].Event;
            }
            else if (gp.player.playerState == "left") {
                if (gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row ][gp.player.current_col - 1]].consin == true) {
                    gp.player.playerCollision = true;
                }
                gp.c_event.eventListen = gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row ][gp.player.current_col - 1]].Event;
            }
            else if (gp.player.playerState == "right") {
                if (gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row ][gp.player.current_col + 1]].consin == true) {
                    gp.player.playerCollision = true;
                }
                gp.c_event.eventListen = gp.map_m.tile_list[gp.map_m.Map[gp.player.current_row ][gp.player.current_col + 1]].Event;
            }

        } catch (Exception e) {
            System.err.println("out of map");
            gp.player.playerCollision = true;
        }

    }

}
