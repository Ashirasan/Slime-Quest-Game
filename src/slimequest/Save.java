/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slimequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fluk2
 */
public class Save {

    GamePanel gp;

    public Save(GamePanel gp) {
        this.gp = gp;
    }

    public void CreateNewSave() {
        File file = new File("Save.txt");

        try {
            file.createNewFile();
            FileWriter filew = new FileWriter("Save.txt");
            //Lv
            filew.write("1");
            filew.write(System.lineSeparator());
            //CurrentHP
            filew.write("100");
            filew.write(System.lineSeparator());
            //CurrentMp
            filew.write("20");
            filew.write(System.lineSeparator());
            //CurrentExp
            filew.write("0");
            filew.write(System.lineSeparator());
            //CurrentGold
            filew.write("0");
            filew.write(System.lineSeparator());

            //Location col row spawn
            filew.write("7");  //col
            filew.write(System.lineSeparator());
            filew.write("7");  //row
            filew.write(System.lineSeparator());
            filew.write("1");  //map
            filew.write(System.lineSeparator());

            // item
            filew.write("0");  //hp potion
            filew.write(System.lineSeparator());
            filew.write("0");  //L hp potion
            filew.write(System.lineSeparator());
            filew.write("0");  //Mp potion
            filew.write(System.lineSeparator());
            filew.write("0");  //L Mp potion
            filew.write(System.lineSeparator());

            filew.close();

        } catch (IOException e) {

        }
        System.out.println("New save has been create");
    }

    public void readSave() {
        int readStats[];
        readStats = new int[12];
        int count = 0;
        try {
            File file = new File("Save.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readStats[count] = Integer.parseInt(data);
                System.out.println(readStats[count]);
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not have save");
            e.printStackTrace();
        }
        // set current stats
        gp.player_Stats.lv = readStats[0]; // lv
        gp.player_Stats.currentHp = readStats[1]; // hp
        gp.player_Stats.currentMp = readStats[2]; // mp
        gp.player_Stats.currentExp = readStats[3]; // exp
        gp.player_Stats.currentGold = readStats[4]; // gold

        // set spawn col row
        gp.player.current_col = readStats[5]; // col
        gp.player.current_row = readStats[6]; // row

        // set spawn map
        gp.map_m.num_of_map = readStats[7]; // map

        // set item
        gp.inventory.HpPotionHave = readStats[8];
        gp.inventory.LHpPotionHave = readStats[9];
        gp.inventory.MpPotionHave = readStats[10];
        gp.inventory.LHpPotionHave = readStats[11];

        System.out.println("Game has been load");
    }

    public void SavaGame() {
        File file = new File("Save.txt");
        String data;

        try {
            file.createNewFile();
            FileWriter filew = new FileWriter("Save.txt");
            //CurrentLv
            data = String.valueOf(gp.player_Stats.lv);
            filew.write(data);
            filew.write(System.lineSeparator());
            //CurrentHP
            data = String.valueOf(gp.player_Stats.currentHp);
            filew.write(data);
            filew.write(System.lineSeparator());
            //Mp
            data = String.valueOf(gp.player_Stats.currentMp);
            filew.write(data);
            filew.write(System.lineSeparator());
            //Exp
            data = String.valueOf(gp.player_Stats.currentExp);
            filew.write(data);
            filew.write(System.lineSeparator());
            //Gold
            data = String.valueOf(gp.player_Stats.currentGold);
            filew.write(data);
            filew.write(System.lineSeparator());

            //Location x y spawn
            // col
            data = String.valueOf(gp.player.current_col);
            filew.write(data);  
            filew.write(System.lineSeparator());
            // row
            data = String.valueOf(gp.player.current_row);
            filew.write(data);  
            filew.write(System.lineSeparator());
            // map
            data = String.valueOf(gp.map_m.num_of_map);
            filew.write(data);  
            filew.write(System.lineSeparator());
            
            //Item
            //hp
            data = String.valueOf(gp.inventory.HpPotionHave);
            filew.write(data);  
            filew.write(System.lineSeparator());
            //L hp
            data = String.valueOf(gp.inventory.LHpPotionHave);
            filew.write(data);  
            filew.write(System.lineSeparator());
            //mp
            data = String.valueOf(gp.inventory.MpPotionHave);
            filew.write(data);  
            filew.write(System.lineSeparator());
            //L mp
            data = String.valueOf(gp.inventory.LMpPotionHave);
            filew.write(data);  
            filew.write(System.lineSeparator());
            
            filew.close();

        } catch (IOException e) {

        }
        System.out.println("Game has been save");
    }

}
