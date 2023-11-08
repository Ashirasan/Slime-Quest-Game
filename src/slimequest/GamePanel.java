package slimequest;

import Entity.Action_Animation;
import Entity.MonsterStats;
import Entity.Monster_Battle_Animation;
import Entity.Player;
import Entity.PlayerStats;
import Entity.Player_Battle_Animation;
import Entity.Skill;
import Map.map_manage;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    // set title size
    int origin_title_size = 16;
    int scale = 3;
    public int title_size = scale * origin_title_size;

    // set screen size
    public int max_col = 16;
    public int max_row = 12;
    public int max_width = max_col * title_size;  // 16 x 48 = 768  /2 ---> 384
    public int max_height = max_row * title_size; // 12 x 48 = 576  /2 ---> 288

    // set game config
    double fps = 60;
    String gameState = "main_menu";
    String gameSupState = "none";

    // Class Call
    public KeyControl KC = new KeyControl(this);
    public UI ui = new UI(this);
    public UI_command ui_c = new UI_command(this);
    public map_manage map_m = new map_manage(this);
    public Collision_Check c_check = new Collision_Check(this);
    public Collision_Event c_event = new Collision_Event(this);
    
    public GameLogic gameLogic = new GameLogic(this);
    public Save save = new Save(this);
    public Shop shop = new Shop(this);
    public Inventory inventory = new Inventory(this);
    public Skill skill = new Skill(this);
    public Player player = new Player(this);
    public PlayerStats player_Stats = new PlayerStats(this);
    public Player_Battle_Animation player_Animation = new Player_Battle_Animation(this);
    public MonsterStats monster_Stats = new MonsterStats(this);
    public Monster_Battle_Animation monster_Animation = new Monster_Battle_Animation(this);
    public Action_Animation action_A = new Action_Animation(this);
    public Notice notice = new Notice(this);
    public Cutscene cutscene = new Cutscene(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(max_width, max_height));
        this.addKeyListener(KC);
        this.setFocusable(true);
        
    }

    // Thread
    Thread gameThread = new Thread() {
        @Override
        public void run() {
            while (true) {
                // System.out.println("GameStart");
                update();
                repaint();

                try {
                    Thread.sleep(1000 / 60);
                } catch (Exception e) {

                }
            }

        }
    };

    public void update() {
        if ("main_menu".equals(gameState)) {
            ui_c.check_UI_command();
        } else if ("game_start".equals(gameState)) {
            if (gameSupState == "none") {
                c_check.Collision_check_update();
                c_event.Collision_Event_Update();
                player.update();
                gameLogic.gamelogicCheck();
                
                if (gameSupState == "notice") {
                    //
                }
            } else if (gameSupState == "menu_InGame") {
                ui_c.check_UI_command();
            } else if (gameSupState == "useItemInGame"){
                ui_c.check_UI_command();
            } else if (gameSupState == "shop"){
                ui_c.check_UI_command();
                shop.shop_check();
                shop.calTotalPrice();
            }
            
        } else if ("battle_menu".equals(gameState)) {
            if (gameSupState == "none") {
                ui_c.check_UI_command();
                gameLogic.gamelogicCheck();
            } else if (gameSupState == "useItem") {
                ui_c.check_UI_command();
                gameLogic.gamelogicCheck();
            } else if (gameSupState == "notice") {
                //
            } else if (gameSupState == "skillMenu") {
                ui_c.check_UI_command();
                gameLogic.gamelogicCheck();
            } 

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Graphics2D g2 = (Graphics2D)g;

        if ("main_menu".equals(gameState)) {          /// Main menu
            ui.draw_main_menu(g);
            g.dispose();
        } else if ("game_start".equals(gameState)) {  /// Game Start
            map_m.draw_Map(g);
            player.draw(g);

            //notice
            if (notice.noticeTitle == "foundMonster") {
                notice.draw_Found_Monster(g);
            } else if (notice.noticeTitle == "LvUp") {
                notice.draw_Lu_Up(g);
            }
            //UI
            if (gameSupState == "menu_InGame") {
                ui.draw_menu_InGame(g);
                ui.draw_system(g);
            }else if (gameSupState == "useItemInGame"){
                ui.draw_menu_InGame(g);
//                ui.draw_use_item_in_game(g);
                ui.draw_Item_Battle_menu(g);
            }else if(gameSupState == "shop"){
                ui.draw_shop(g);
            }

            g.dispose();
        } else if ("battle_menu".equals(gameState)) { /// Battle
            ui.draw_battle_menu(g);
            player_Animation.drawPlayer_Animation(g);
            monster_Animation.drawMonster_Animation(g);

            //animation
            if (action_A.action == "attack") {
                action_A.draw_Attack(g);
            } else if (action_A.action == "defence") {
                action_A.draw_defence(g);
            } else if (action_A.action == "useHpPotion") {
                action_A.draw_use_HpPotion(g);
            } else if (action_A.action == "useMpPotion") {
                action_A.draw_use_MpPotion(g);
            } else if (action_A.action == "useSkill") {
                if (skill.SkillChoose == skill.SkillList[1]) {
                    action_A.draw_Fire_Ball(g);
                } else if (skill.SkillChoose == skill.SkillList[2]) {
                    action_A.draw_beam(g);
                }
            }

            //notice
            if (notice.noticeTitle == "playerAttack") {
                notice.draw_Player_Attack_notice(g);
            } else if (notice.noticeTitle == "MonsterAttack") {
                notice.draw_Monster_Attack_notice(g);
            } else if (notice.noticeTitle == "playerDefense") {
                notice.draw_Player_Defense(g);
            } else if (notice.noticeTitle == "useItem") {
                notice.draw_UseItem(g);
            } else if (notice.noticeTitle == "useSkill") {
                notice.draw_UseSkill(g);
            } else if (notice.noticeTitle == "run") {
                notice.draw_Run(g);
            } else if (notice.noticeTitle == "result") {
                notice.draw_result(g);
                gameSupState = "notice";
            }

            //UI
            if (gameSupState == "useItem") {
                ui.draw_Item_Battle_menu(g);
            } else if (gameSupState == "skillMenu") {
                ui.draw_Skill_menu(g);
            }

            g.dispose();
        }
        else if(gameState == "cutscene"){
            if(gameSupState == "cutsceneStart"){
                cutscene.draw_cutscene_start(g);
            }else if(gameSupState == "cutsceneEnd"){
                cutscene.draw_cutscene_end(g);
            }
            
        }

    }
}
