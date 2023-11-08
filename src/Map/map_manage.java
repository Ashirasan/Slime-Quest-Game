package Map;

import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;

public class map_manage {

    GamePanel gp;
    public Tile[] tile_list;
    public int num_of_map;
    public int Map[][];

    public map_manage(GamePanel gp) {
        this.gp = gp;
        tile_list = new Tile[20];
        loadImage();    
    }

    private void loadImage() {
        try {
            //grass 0
            tile_list[0] = new Tile();
            tile_list[0].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/newgrass.png"));

            //water 1
            tile_list[1] = new Tile();
            tile_list[1].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/newwater.png"));
            tile_list[1].consin = true;
            
            //tree 2
            tile_list[2] = new Tile();
            tile_list[2].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/newtree.png"));
            tile_list[2].consin = true;
            
            //tomb 3
            tile_list[3] = new Tile();
            tile_list[3].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/newtomb.png"));
            tile_list[3].consin = true;
            tile_list[3].Event = "heal";
            
            //bridge next
            tile_list[4] = new Tile();
            tile_list[4].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/nextbridge.png"));
            tile_list[4].consin = true;
            tile_list[4].Event = "nextUp";
            
            //bridge prev
            tile_list[5] = new Tile();
            tile_list[5].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/prevbridge.png"));
            tile_list[5].consin = true;
            tile_list[5].Event = "prevDown";
            
            //shop
            tile_list[6] = new Tile();
            tile_list[6].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/shop.png"));
            tile_list[6].consin = true;
            tile_list[6].Event = "shop";
            
            //boss
            tile_list[7] = new Tile();
            tile_list[7].Image = ImageIO.read(getClass().getResourceAsStream("/picture/tile/newgrass.png"));
            tile_list[7].consin = true;
            tile_list[7].Event = "boss";
            
            //shop
            tile_list[8] = new Tile();
            tile_list[8].Image = ImageIO.read(getClass().getResourceAsStream("/Picture/monster/king1.png"));
            
            
        } catch (IOException e) {
            System.out.println("Cant load Image");
        }
    }

    public void draw_Map(Graphics g) {
        int x = 0, y = 0;
        select_map();
        for (int i = 0; i < gp.max_row; i++) {
            for (int j = 0; j < gp.max_col; j++) {
                g.drawImage(tile_list[Map[i][j]].Image, x, y, gp.title_size, gp.title_size, null);
                x += gp.title_size;
            }
            x = 0;
            y += gp.title_size;
        }
        if(num_of_map == 3){
            g.drawImage(tile_list[8].Image, 3*gp.title_size, 2*gp.title_size, gp.title_size, gp.title_size, null);
        }
//        g.drawImage(tile_list[0].Image, 0, 0, gp.title_size, gp.title_size, null);
    }

    private void select_map() {
//        int Map[][];
//            int temp_map[][];
        if (num_of_map == 1) {
            int temp_map[][]
                    = {{1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 2, 2, 2, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1},
                    {1, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 1},
                    {1, 0, 0, 0, 0, 2, 1, 1, 1, 2, 0, 0, 0, 0, 2, 1},
                    {1, 0, 0, 0, 0, 2, 1, 1, 1, 2, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 2, 1, 1, 1, 2, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 2, 2, 0, 2, 2, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
            Map = new int[gp.max_row][gp.max_col];
            for (int i = 0; i < gp.max_row; i++) {
                for (int j = 0; j < gp.max_col; j++) {
                    Map[i][j] = temp_map[i][j];
                }
            }
        } else if (num_of_map == 2) {
            int temp_map[][]
                    = {{1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1},
                       {1, 0, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1},
                       {1, 0, 0, 0, 0, 2, 0, 2, 1, 2, 0, 0, 0, 6, 2, 1},
                       {1, 0, 2, 2, 2, 2, 2, 2, 1, 2, 0, 0, 0, 0, 2, 1},
                       {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 1},
                       {1, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 1, 1, 1, 2, 1},
                       {1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 1},
                       {1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 1},
                       {1, 0, 2, 1, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 1},
                       {1, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 2, 1},
                       {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
                       {1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
            Map = new int[gp.max_row][gp.max_col];
            for (int i = 0; i < gp.max_row; i++) {
                for (int j = 0; j < gp.max_col; j++) {
                    Map[i][j] = temp_map[i][j];
                }
            }
        } else if (num_of_map == 3) {
            int temp_map[][]
                    = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                       {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                       {1, 2, 0, 7, 0, 2, 2, 2, 1, 2, 0, 0, 0, 0, 2, 1},
                       {1, 2, 0, 0, 0, 2, 2, 2, 1, 2, 0, 0, 0, 0, 2, 1},
                       {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
                       {1, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 0, 2, 2, 1},
                       {1, 2, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 1},
                       {1, 2, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 1},
                       {1, 2, 2, 1, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 1},
                       {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
                       {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1},
                       {1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1}};
            Map = new int[gp.max_row][gp.max_col];
            for (int i = 0; i < gp.max_row; i++) {
                for (int j = 0; j < gp.max_col; j++) {
                    Map[i][j] = temp_map[i][j];
                }
            }
        } 
    }
}
