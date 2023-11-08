
package tile;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import maps.mapload;
import slimequest.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public mapload map;
    public int NumOfMap;
    
    
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[20];
        NumOfMap = 1;
        getTileImage();
    }
    
    // load tile image
    public void getTileImage(){
        try{
            tile[0] = new Tile();  //grass
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/grass.png"));
            tile[0].event = "none";
            
            tile[1] = new Tile();  //water
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/water.png"));
            tile[1].collision=true;
            tile[1].event = "none";
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/bridge_next_left.png"));
            tile[2].collision = true;
            tile[2].event = "nextmap";
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/bridge_next_mid.png"));
            tile[3].collision = true;
            tile[3].event = "nextmap";
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/bridge_next_right.png"));
            tile[4].collision = true;
            tile[4].event = "nextmap";
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/bridge_prev_left.png"));
            tile[5].collision = true;
            tile[5].event = "prevmap";
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/bridge_prev_mid.png"));
            tile[6].collision = true;
            tile[6].event = "prevmap";
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/bridge_prev_right.png"));
            tile[7].collision = true;
            tile[7].event = "prevmap";
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/tomb1.png"));
            tile[8].collision = true;
            tile[8].event = "heal";
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/tomb2.png"));
            tile[9].collision = true;
            tile[9].event = "heal";
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/tomb3.png"));
            tile[10].collision = true;
            tile[10].event = "heal";
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/tomb4.png"));
            tile[11].collision = true;
            tile[11].event = "heal";
                 
        }catch(IOException e){
          //  
        }
    }
    
    // Draw tile image
    public void draw(Graphics2D g2){
//        int NumOfMap = 2;
        int x = 0;
        int y = 0;
        map = new mapload(NumOfMap);   // row  and  col
        for(int row=0;row<12;row++){
            for(int col=0;col<16;col++){
                g2.drawImage(tile[map.mapnum[row][col]].image, x, y, gp.titlesize, gp.titlesize, null);
                x+=gp.titlesize;
            }
            x = 0;
            y+=gp.titlesize;
        }
        
    }
}
