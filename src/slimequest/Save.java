
package slimequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Save {
    GamePanel gp;
    
    public Save(GamePanel gp){
        this.gp = gp;
    }
    
    public void newSave(){
         File file = new File("playerStats.txt");

        try {
            file.createNewFile();
            FileWriter filew = new FileWriter("playerStats.txt");
            //Lv
            filew.write("1");
            filew.write(System.lineSeparator());
            //CurrentHP
            filew.write("50");
            filew.write(System.lineSeparator());
            //CurrentExp
            filew.write("0");
            filew.write(System.lineSeparator());

            //Location x y spawn
            filew.write("150");  //x
            filew.write(System.lineSeparator());
            filew.write("400");  //y
            filew.write(System.lineSeparator());
            filew.write("1");  //map
            filew.write(System.lineSeparator());
            filew.close();
            
            

        } catch (IOException e) {

        }
        System.out.println("New save has been create");
    }
    
    public void readSave(){
        int readStats[];
        readStats = new int[6];
        int count = 0;
        try {
            File file = new File("playerStats.txt");
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
        gp.ps.currentlv = readStats[0];
        gp.ps.currentHp = readStats[1];
        gp.ps.currentExp = readStats[2];
        
        // set spawn x y
        gp.player.x = readStats[3];
        gp.player.y = readStats[4];
        // set spawn map
        gp.tm.NumOfMap = readStats[5];
        System.out.println("Game has been load");
    }
    
    public void SaveGame(){
        File file = new File("playerStats.txt");
        String data;

        try {
            file.createNewFile();
            FileWriter filew = new FileWriter("playerStats.txt");
            //CurrentLv
            data = String.valueOf(gp.ps.currentlv);
            filew.write(data);
            filew.write(System.lineSeparator());
            //CurrentHP
            data = String.valueOf(gp.ps.currentHp);
            filew.write(data);
            filew.write(System.lineSeparator());
            data = String.valueOf(gp.ps.currentExp);
            filew.write(data);
            filew.write(System.lineSeparator());

            //Location x y spawn
            data = String.valueOf(gp.player.x);
            filew.write(data);  //x
            filew.write(System.lineSeparator());
            data = String.valueOf(gp.player.y);
            filew.write(data);  //y
            filew.write(System.lineSeparator());
            data = String.valueOf(gp.tm.NumOfMap);
            filew.write(data);  //map
            filew.write(System.lineSeparator());
            filew.close();  

        } catch (IOException e) {

        }
        System.out.println("Game has been save");
    }
}
