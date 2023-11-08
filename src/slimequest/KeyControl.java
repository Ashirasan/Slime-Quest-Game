package slimequest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {

    GamePanel gp;
    public boolean wPressed, sPressed, dPressed, aPressed;

    public KeyControl(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        // menu lobby
        if (gp.gameStatus == "menu") {
            if (code == KeyEvent.VK_W) {
                gp.uic.command--;
            }
            if (code == KeyEvent.VK_S) {
                gp.uic.command++;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.uic.command == 1) {
                    //create new save
                    gp.save.newSave();
                    gp.save.readSave();
                    gp.ps.setStats();
                    gp.gameStatus = "gameStart";
                } else if (gp.uic.command == 2) {
                    gp.save.readSave();
                    gp.ps.setStats();
                    gp.gameStatus = "gameStart";
                }
                else if (gp.uic.command == 3) {
                    System.exit(0);
                }
                gp.uic.command = 1;
            }
        }

        
        // when game start
        else if (gp.gameStatus == "gameStart") {
            if (code == KeyEvent.VK_W) {
                wPressed = true;
            }
            else if (code == KeyEvent.VK_S) {
                sPressed = true;
            }
            else if (code == KeyEvent.VK_D) {
                dPressed = true;
            }
            else if (code == KeyEvent.VK_A) {
                aPressed = true;
            }
            else if(code == KeyEvent.VK_ESCAPE){
                wPressed = false;
                sPressed = false;
                dPressed = false;
                aPressed = false;
                gp.gameStatus = "menu_in_game";
            }
            else if(code == KeyEvent.VK_P){
                gp.ps.currentHp = gp.ps.maxHp;
            }
        }
        
        //open in game menu
        else if(gp.gameStatus=="menu_in_game"){
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameStatus = "gameStart";
            }
            else if (code == KeyEvent.VK_W) {
                gp.uic.command--;
            }
            else if (code == KeyEvent.VK_S) {
                gp.uic.command++;
            }
            else if(code == KeyEvent.VK_ENTER){
                if(gp.uic.command == 1){
                    gp.save.SaveGame();
                }
                else if(gp.uic.command == 2){
                    gp.gameStatus = "menu";
//                    System.exit(0);
                }
                gp.uic.command = 1;
            }
        }
        
        
        // battle
        else if(gp.gameStatus == "battle"){
            if(code == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
            else if(code == KeyEvent.VK_D){
                gp.uic.command++;
            }
            else if(code == KeyEvent.VK_A){
                gp.uic.command--;
            }
            else if(code == KeyEvent.VK_ENTER){
                if(gp.uic.command == 1){
                    gp.gl.battleCommand = "attack";
                }
                else if(gp.uic.command == 2){
                    gp.gl.battleCommand = "defence";
                }
                else if(gp.uic.command == 3){
                    gp.gl.dia = "none";
                    gp.gameStatus = "gameStart";
                }
                gp.uic.command = 1;
            }
        }
        
        // GameOver
        else if(gp.gameStatus == "gameOver"){
            if(code == KeyEvent.VK_ENTER){
                if(gp.uic.command == 1){
                    gp.gameStatus = "menu";
                }
                else if(gp.uic.command == 2){
                    System.exit(0);
                }
                gp.uic.command = 1;
            }
            else if (code == KeyEvent.VK_W) {
                gp.uic.command--;
            }
            else if (code == KeyEvent.VK_S) {
                gp.uic.command++;
            }
            
        }

    }

    
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (gp.gameStatus == "gameStart") {
            if (code == KeyEvent.VK_W) {
                wPressed = false;
            }
            else if (code == KeyEvent.VK_S) {
                sPressed = false;
            }
            else if (code == KeyEvent.VK_D) {
                dPressed = false;
            }
            else if (code == KeyEvent.VK_A) {
                aPressed = false;
            }
        }

    }
    

}
