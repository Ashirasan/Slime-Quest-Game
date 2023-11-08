package slimequest;

public class UI_command {
    GamePanel gp;
    int Num_command_min=0;
    int Num_command_max=2;
    public int Num_command_Current=1;

    UI_command(GamePanel gp){
        this.gp = gp;
    }

    public void check_UI_command(){
        if(Num_command_Current<Num_command_min){
            Num_command_Current=Num_command_max;
        }
        else if(Num_command_Current>Num_command_max){
            Num_command_Current=Num_command_min;
        }
    }

}
