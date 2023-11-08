
package slimequest;

public class UICommand {
    GamePanel gp;
    int command = 1;
    public int max;
    public int min;
    
    public UICommand(GamePanel gp){
        this.gp=gp;
    }
    
    public void checkCommand(){
        if(command<min){
            command = max;
        }else if(command>max){
            command = min;
        }
    }
}
