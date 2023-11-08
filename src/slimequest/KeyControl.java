package slimequest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {

    GamePanel gp;

    KeyControl(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if ("main_menu".equals(gp.gameState)) {
            if (code == KeyEvent.VK_W) {
                gp.ui_c.Num_command_Current--;
            } else if (code == KeyEvent.VK_S) {
                gp.ui_c.Num_command_Current++;
            } else if (code == KeyEvent.VK_ENTER) {
                if (gp.ui_c.Num_command_Current == 1) {
                    gp.save.CreateNewSave();
                    gp.save.readSave();
                    gp.player_Stats.setPlayerStats();
                    gp.gameState = "cutscene";
                    gp.gameSupState = "cutsceneStart";
//                    gp.gameState = "game_start";
                } else if (gp.ui_c.Num_command_Current == 2) {
                    gp.save.readSave();
                    gp.player_Stats.setPlayerStats();
                    gp.gameState = "game_start";
                } else if (gp.ui_c.Num_command_Current == 3) {
                    System.exit(0);
                }
                gp.ui_c.Num_command_Current = 1;
            }
        } else if ("game_start".equals(gp.gameState)) {
            if (gp.gameSupState == "none") {
                // walk
                if (code == KeyEvent.VK_W) {
                    gp.player.playerState = "up";
//                gp.player.current_col--;
                } else if (code == KeyEvent.VK_S) {
                    gp.player.playerState = "down";
//                gp.player.current_col++;
                } else if (code == KeyEvent.VK_A) {
                    gp.player.playerState = "left";
//                gp.player.current_row--;
                } else if (code == KeyEvent.VK_D) {
                    gp.player.playerState = "right";
//                gp.player.current_row++;
                } else if (code == KeyEvent.VK_ESCAPE) {
                    gp.gameSupState = "menu_InGame";
                }
            } else if (gp.gameSupState == "notice") {
                if (gp.notice.noticeTitle == "foundMonster") {
                    if (code == KeyEvent.VK_ENTER) {
                        gp.gameSupState = "none";
                        gp.notice.noticeTitle = "none";
                        gp.gameLogic.FoundMonster();
                    }
                } else {
                    if (code == KeyEvent.VK_ENTER) {
                        gp.gameSupState = "none";
                        gp.notice.noticeTitle = "none";
                    }
                }
            } else if (gp.gameSupState == "menu_InGame") {
                if (code == KeyEvent.VK_ESCAPE) {
                    gp.gameSupState = "none";
                } else if (code == KeyEvent.VK_W) {
                    gp.ui_c.Num_command_Current--;
                } else if (code == KeyEvent.VK_S) {
                    gp.ui_c.Num_command_Current++;
                } else if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui_c.Num_command_Current == 1) {
                        gp.gameSupState = "useItemInGame";
                    } else if (gp.ui_c.Num_command_Current == 2) {
                        gp.save.SavaGame();
                        gp.gameSupState = "none";
                    } else if (gp.ui_c.Num_command_Current == 3) {
                        gp.gameSupState = "none";
                        gp.gameState = "main_menu";
                    }
                    gp.ui_c.Num_command_Current = 1;
                }

            } else if (gp.gameSupState == "useItemInGame") {
                if (code == KeyEvent.VK_ESCAPE) {
                    gp.gameSupState = "menu_InGame";
                    gp.ui_c.Num_command_Current = 1;
                } else if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui_c.Num_command_Current == 1) {
                        gp.gameLogic.Item = "HpPotion";
                        gp.gameLogic.useitem();
                        gp.gameSupState = "menu_InGame";
                    } else if (gp.ui_c.Num_command_Current == 2) {
                        gp.gameLogic.Item = "LHpPotion";
                        gp.gameLogic.useitem();
                        gp.gameSupState = "menu_InGame";

                    } else if (gp.ui_c.Num_command_Current == 3) {
                        gp.gameLogic.Item = "MpPotion";
                        gp.gameLogic.useitem();
                        gp.gameSupState = "menu_InGame";

                    } else if (gp.ui_c.Num_command_Current == 4) {
                        gp.gameLogic.Item = "LMpPotion";
                        gp.gameLogic.useitem();
                        gp.gameSupState = "menu_InGame";

                    }

                    gp.ui_c.Num_command_Current = 1;
                } else if (code == KeyEvent.VK_W) {
                    gp.ui_c.Num_command_Current--;
                } else if (code == KeyEvent.VK_S) {
                    gp.ui_c.Num_command_Current++;
                }
            } else if (gp.gameSupState == "shop") {
                if (code == KeyEvent.VK_ESCAPE) {
                    gp.gameSupState = "none";
                    gp.ui_c.Num_command_Current = 1;
                    gp.shop.setShopDefault();
                } else if (code == KeyEvent.VK_W) {
                    gp.ui_c.Num_command_Current--;
                } else if (code == KeyEvent.VK_S) {
                    gp.ui_c.Num_command_Current++;
                }else if(code == KeyEvent.VK_ENTER){
                    if(gp.ui_c.Num_command_Current == 5){
                        if(gp.shop.totalPrice > gp.player_Stats.currentGold){
                            System.out.println("Not Enouge gold");
                        }else{
                            gp.shop.buy();
                            gp.gameSupState = "none";
                            gp.ui_c.Num_command_Current = 1;
                        }
                    }
                }
                
                
                if (gp.ui_c.Num_command_Current == 1) {
                    if (code == KeyEvent.VK_D) {
                        gp.shop.hpPotionNum++;
                    } else if (code == KeyEvent.VK_A) {
                        gp.shop.hpPotionNum--;
                    }
                } else if (gp.ui_c.Num_command_Current == 2) {
                    if (code == KeyEvent.VK_D) {
                        gp.shop.LhpPotionNum++;
                    } else if (code == KeyEvent.VK_A) {
                        gp.shop.LhpPotionNum--;
                    }
                } else if(gp.ui_c.Num_command_Current == 3){
                    if(code == KeyEvent.VK_D){
                        gp.shop.mpPotionNum++;
                    }else if(code == KeyEvent.VK_A){
                        gp.shop.mpPotionNum--;
                    }
                } else if(gp.ui_c.Num_command_Current == 4){
                    if(code == KeyEvent.VK_D){
                        gp.shop.LmpPotionNum++;
                    }else if(code == KeyEvent.VK_A){
                        gp.shop.LmpPotionNum--;
                    }
                }
            }

            //test
            if (code == KeyEvent.VK_UP) {
                gp.map_m.num_of_map++;
            } else if (code == KeyEvent.VK_DOWN) {
                gp.player_Stats.currentExp += 400;
            }
        } else if ("battle_menu".equals(gp.gameState)) {
            if (gp.gameSupState == "none") {
                if (code == KeyEvent.VK_W) {
                    gp.ui_c.Num_command_Current--;
                } else if (code == KeyEvent.VK_S) {
                    gp.ui_c.Num_command_Current++;
                } else if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui_c.Num_command_Current == 1) {
                        //
                        gp.gameLogic.LogicBattleAction = "attack";
                        gp.action_A.action = "attack";
                    } else if (gp.ui_c.Num_command_Current == 2) {
                        //
                        gp.gameLogic.LogicBattleAction = "defense";
                        gp.action_A.action = "defence";
                    } else if (gp.ui_c.Num_command_Current == 3) {
                        //
                        gp.gameSupState = "skillMenu";
                    } else if (gp.ui_c.Num_command_Current == 4) {
                        //
                        gp.gameSupState = "useItem";
                    } else if (gp.ui_c.Num_command_Current == 5) {
                        //
                        gp.gameLogic.LogicBattleAction = "run";
                    }
                    gp.ui_c.Num_command_Current = 1;
                }

            } //close battle sup none
            else if (gp.gameSupState == "notice") {
                if (gp.action_A.action == "none") {
                    if (code == KeyEvent.VK_ENTER) {
                        gp.gameSupState = "none";
                        gp.notice.noticeTitle = "none";
                    }
                }

            }//close battle sup notice
            else if (gp.gameSupState == "useItem") {
                if (code == KeyEvent.VK_W) {
                    gp.ui_c.Num_command_Current--;
                } else if (code == KeyEvent.VK_S) {
                    gp.ui_c.Num_command_Current++;
                } else if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui_c.Num_command_Current == 1) {
                        gp.gameLogic.Item = "HpPotion";
                    } else if (gp.ui_c.Num_command_Current == 2) {
                        gp.gameLogic.Item = "LHpPotion";
                    } else if (gp.ui_c.Num_command_Current == 3) {
                        gp.gameLogic.Item = "MpPotion";
                    } else if (gp.ui_c.Num_command_Current == 4) {
                        gp.gameLogic.Item = "LMpPotion";
                    }
                    gp.gameLogic.LogicBattleAction = "useItem";
//                    gp.gameSupState = "none";
                }
                if (code == KeyEvent.VK_ESCAPE) {
                    gp.ui_c.Num_command_Current = 1;
                    gp.gameSupState = "none";
                }
            }// close sup useItem
            else if (gp.gameSupState == "skillMenu") {
                if (code == KeyEvent.VK_A) {
                    gp.ui_c.Num_command_Current--;
                } else if (code == KeyEvent.VK_D) {
                    gp.ui_c.Num_command_Current++;
                } else if (code == KeyEvent.VK_ENTER) {
                    gp.skill.setSkill();
                    gp.gameLogic.LogicBattleAction = "useSkill";
                } else if (code == KeyEvent.VK_ESCAPE) {
                    gp.ui_c.Num_command_Current = 1;
                    gp.gameSupState = "none";
                }
            }
        } // close battle state
        
        else if(gp.gameState == "cutscene"){
            if(gp.cutscene.cutsceneStatus == true){
                if(code == KeyEvent.VK_ENTER){
                    gp.cutscene.cutsceneNum++;
                }
            }
            
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
