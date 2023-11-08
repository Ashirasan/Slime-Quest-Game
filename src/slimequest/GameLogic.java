package slimequest;

import java.util.Random;

public class GameLogic {

    GamePanel gp;

    //random monster
    public int walkCount = 0;

    // battle
    public String LogicBattleAction = "none";
    public String Item;
    public boolean checkResult = true;

    public GameLogic(GamePanel gp) {
        this.gp = gp;
    }

    //check
    public void gamelogicCheck() {
        if (gp.gameState == "game_start") {
            if (walkCount == 15) {
                gp.gameSupState = "notice";
                gp.notice.noticeTitle = "foundMonster";
                gp.action_A.setDefault();
                System.out.println("Found Monster");
                walkCount = 0;
            }
            else if(gp.player_Stats.currentExp>=gp.player_Stats.MaxExp){
                LvUp();
                gp.gameSupState = "notice";
                gp.notice.noticeTitle = "LvUp";
            }
        } else if (gp.gameState == "battle_menu") {
            if (checkResult == true) {
                battleResultCheck();
            }


            if (LogicBattleAction == "attack") {
                attack();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "monster_attack") {
                monster_attack();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "defense") {
                defense();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "useItem") {
                useitem();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "UseItemComplete") {
                monster_attack();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "useSkill") {
                useSkill();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "UseSkillComplete") {
                monster_attack();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "run") {
                run();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "runCompleteNo") {
                monster_attack();
                gp.gameSupState = "notice";
            } else if (LogicBattleAction == "runCompleteYes") {
                gp.gameState = "game_start";
                LogicBattleAction = "none";
            } else if (LogicBattleAction == "win") {
                LogicBattleAction = "closeBattleWin";

            } else if (LogicBattleAction == "lose") {
                LogicBattleAction = "closeBattleLose";

            } else if (LogicBattleAction == "closeBattleWin") {
                if(gp.monster_Stats.Monster_found == "King Slime"){
                    gp.gameState = "cutscene";
                    gp.gameSupState = "cutsceneEnd";
                }else{
                    gp.gameState = "game_start";
                }
                LogicBattleAction = "none";
                checkResult = true;
            } else if (LogicBattleAction == "closeBattleLose") {
                gp.gameState = "main_menu";
                LogicBattleAction = "none";
                checkResult = true;
            }

            System.out.println(gp.gameSupState);
            System.out.println(gp.notice.noticeTitle);
        }
    }

    //Function logic
    // Random Monster
    public void FoundMonster() {
        int monster_number = 0, monster_lv = 1;
        int minMonsterLv, maxMonsterLv;
        int maxListMonsterFound = 1, minListMonsterFound = 1;
        Random rdMonster = new Random();
        Random rdLv = new Random();

        if (gp.map_m.num_of_map == 1) {
            minMonsterLv = 1;
            maxMonsterLv = 3;
            monster_number = 1;
            monster_lv = rdLv.nextInt(minMonsterLv, maxMonsterLv + 1);
        } else if (gp.map_m.num_of_map == 2) {
            minMonsterLv = 4; // min lv
            maxMonsterLv = 6; // max lv
            minListMonsterFound = 1; // list monster
            maxListMonsterFound = 2; //
            monster_number = rdMonster.nextInt(minListMonsterFound, maxListMonsterFound + 1); // random monster
            monster_lv = rdLv.nextInt(minMonsterLv, maxMonsterLv + 1); // random Lv
        }else if (gp.map_m.num_of_map == 3) {
            minMonsterLv = 7; // min lv
            maxMonsterLv = 9; // max lv
            minListMonsterFound = 2; // list monster
            maxListMonsterFound = 3; //
            monster_number = rdMonster.nextInt(minListMonsterFound, maxListMonsterFound + 1); // random monster
            monster_lv = rdLv.nextInt(minMonsterLv, maxMonsterLv + 1); // random Lv
        }
        // ---> more map

        gp.monster_Stats.Monster_found = gp.monster_Stats.Monster_List[monster_number];
        gp.monster_Stats.mLv = monster_lv;
        gp.monster_Stats.setMonsterStats();
        gp.gameState = "battle_menu";
    }

    //Battle Logic
    public void attack() {
//        System.out.println("attack");
        int atkMin = gp.player_Stats.Atk - 3;
        int atkMax = gp.player_Stats.Atk;
        int totalAtk;
        int MonsterDef = gp.monster_Stats.mDef;
        Random rdAtk = new Random();
        totalAtk = rdAtk.nextInt(atkMin, atkMax + 1);
        if (MonsterDef < totalAtk) {
            totalAtk = totalAtk - MonsterDef;
        } else if (MonsterDef >= totalAtk) {
            totalAtk = 1;
        }
        gp.monster_Stats.mcurrentHp -= totalAtk;
        if (gp.monster_Stats.mcurrentHp < 0) {
            gp.monster_Stats.mcurrentHp = 0;
        }
        // send total atk
        gp.notice.noticeTitle = "playerAttack";
        gp.notice.noticeTotalDamege = String.valueOf(totalAtk);
        LogicBattleAction = "monster_attack";
    }

    public void monster_attack() {
        int atkMin = gp.monster_Stats.mAtk - 3;
        int atkMax = gp.monster_Stats.mAtk;
        int totalAtk;
        int PlayerDef = gp.player_Stats.Def;
        Random rdAtk = new Random();
        totalAtk = rdAtk.nextInt(atkMin, atkMax + 1);
        if (PlayerDef < totalAtk) {
            totalAtk = totalAtk - PlayerDef;
        } else if (PlayerDef >= totalAtk) {
            totalAtk = 1;
        }
        gp.player_Stats.currentHp -= totalAtk;
        if (gp.player_Stats.currentHp < 0) {
            gp.player_Stats.currentHp = 0;
        }
        // send monster total atk
        gp.notice.noticeTitle = "MonsterAttack";
        gp.notice.noticeTotalDamege = String.valueOf(totalAtk);
        LogicBattleAction = "none";
    }

    public void defense() {
        // player def
        int totalDef = gp.player_Stats.Def * 2;
        double totalManaRegen;
        Random rdManaRegen = new Random();
        totalManaRegen = rdManaRegen.nextInt(15, 21);
//        System.out.println("random % "+totalManaRegen);
        // monster atk
        int atkMin = gp.monster_Stats.mAtk - 3;
        int atkMax = gp.monster_Stats.mAtk;
        int totalAtk;
        Random rdAtk = new Random();
        totalAtk = rdAtk.nextInt(atkMin, atkMax + 1);

        if (totalDef < totalAtk) {
            totalAtk = totalAtk - totalDef;
        } else if (totalDef >= totalAtk) {
            totalAtk = 1;
        }
        gp.player_Stats.currentHp -= totalAtk;
        if (gp.player_Stats.currentHp < 0) {
            gp.player_Stats.currentHp = 0;
        }

        totalManaRegen = gp.player_Stats.MaxMp * (totalManaRegen / 100);
        if (gp.player_Stats.currentMp != gp.player_Stats.MaxMp) {
            gp.player_Stats.currentMp += totalManaRegen;
            if (gp.player_Stats.currentMp > gp.player_Stats.MaxMp) {
                gp.player_Stats.currentMp = gp.player_Stats.MaxMp;
            }
        }
//        System.out.println(totalManaRegen);
        //send value to notice
        gp.notice.noticeTotalDamege = String.valueOf(totalAtk);
        gp.notice.noticeTotalManaRegen = String.valueOf((int) totalManaRegen);
        gp.notice.noticeTotalDef = String.valueOf(totalDef);

        gp.notice.noticeTitle = "playerDefense";
        LogicBattleAction = "none";
    }

    //Battle Logic use item
    public void useitem() {
        boolean useItemComplete = false;
        System.out.println("Use Item System");
        String potionUse = "NoUse";
        double totalHeal = 0;

        if (Item == "HpPotion") {
            if (gp.inventory.HpPotionHave > 0) {
                useItemComplete = true;
                totalHeal = gp.player_Stats.MaxHp / 4;
                gp.player_Stats.currentHp += (int) totalHeal;
                gp.inventory.HpPotionHave--;
                potionUse = "Hp Potion";
                gp.action_A.action = "useHpPotion";
            }
        } else if (Item == "LHpPotion") {
            if (gp.inventory.LHpPotionHave > 0) {
                useItemComplete = true;
                totalHeal = gp.player_Stats.MaxHp / 2;
                gp.player_Stats.currentHp += (int) totalHeal;
                gp.inventory.LHpPotionHave--;
                potionUse = "Large Hp Potion";
                gp.action_A.action = "useHpPotion";
            }
        } else if (Item == "MpPotion") {
            if (gp.inventory.MpPotionHave > 0) {
                useItemComplete = true;
                totalHeal = gp.player_Stats.MaxMp / 4;
                gp.player_Stats.currentMp += (int) totalHeal;
                gp.inventory.MpPotionHave--;
                potionUse = "Mana Potion";
                gp.action_A.action = "useMpPotion";
            }
        } else if (Item == "LMpPotion") {
            if (gp.inventory.LMpPotionHave > 0) {
                useItemComplete = true;
                totalHeal = gp.player_Stats.MaxMp / 2;
                gp.player_Stats.currentMp += (int) totalHeal;
                gp.inventory.LMpPotionHave--;
                potionUse = "Large Mana Potion";
                gp.action_A.action = "useMpPotion";
            }
        }

        if (gp.player_Stats.currentHp > gp.player_Stats.MaxHp) {
            gp.player_Stats.currentHp = gp.player_Stats.MaxHp;
        } else if (gp.player_Stats.currentMp > gp.player_Stats.MaxMp) {
            gp.player_Stats.currentMp = gp.player_Stats.MaxMp;
        }

        if (useItemComplete == false) {
            LogicBattleAction = "none";
        } else if (useItemComplete == true) {
            LogicBattleAction = "UseItemComplete";
        }

        // send value to notice
        gp.notice.noticeTitle = "useItem";
        gp.notice.noticeItemUse = potionUse;
        gp.notice.noticeTotalHeal = String.valueOf((int) totalHeal);
    }

    public void useSkill() {
        String Skilluse = gp.skill.SkillChoose;
        int ManaUse = gp.skill.ManaUse;
        int DamageScale = gp.skill.DamageScale;
        int TotalDamage = 0;
        int MonsterDef = gp.monster_Stats.mDef;

        if (gp.player_Stats.currentMp >= ManaUse) {
            TotalDamage = gp.player_Stats.Atk * DamageScale;
            if (MonsterDef < TotalDamage) {
                TotalDamage = TotalDamage - MonsterDef;
            } else if (MonsterDef >= TotalDamage) {
                TotalDamage = 1;
            }
            gp.action_A.action = "useSkill";
            gp.monster_Stats.mcurrentHp -= TotalDamage;
            gp.player_Stats.currentMp -= ManaUse;
            gp.notice.noticeUseSkillComplete = "yes";
            if (gp.monster_Stats.mcurrentHp < 0) {
                gp.monster_Stats.mcurrentHp = 0;
            }
            LogicBattleAction = "UseSkillComplete";

        } else if (gp.player_Stats.currentMp < ManaUse) {
            LogicBattleAction = "none";
            gp.notice.noticeUseSkillComplete = "no";
        }

        gp.notice.noticeTitle = "useSkill";
        gp.notice.noticeSkillUse = Skilluse;
        gp.notice.noticeTotalDamageSkill = String.valueOf((int) TotalDamage);
    }

    public void run() {
        String runComplete = "no";
        int runStatus;
        Random rdRun = new Random();
        runStatus = rdRun.nextInt(1, 3);
        if (runStatus == 1) {
            runComplete = "yes";
            LogicBattleAction = "runCompleteYes";
        } else if (runStatus == 2) {
            runComplete = "no";
            LogicBattleAction = "runCompleteNo";
        }
        System.out.println(runStatus);
        gp.notice.noticeRunComplete = runComplete;
        gp.notice.noticeTitle = "run";
    }

    public void battleResultCheck() {
        String battleResult = "none";
        if (gp.monster_Stats.mcurrentHp <= 0) {
            battleResult = "win";
            gp.notice.noticeBattleResult = battleResult;
            gp.notice.noticeExpReward = String.valueOf(gp.monster_Stats.ExpReward);
            gp.notice.noticeGoldReward = String.valueOf(gp.monster_Stats.gold);

            // cal reward
            gp.player_Stats.currentExp += gp.monster_Stats.ExpReward;
            gp.player_Stats.currentGold += gp.monster_Stats.gold;

            LogicBattleAction = "win";
            gp.gameSupState = "notice";
            gp.notice.noticeTitle = "result";
            checkResult = false;

        } else if (gp.player_Stats.currentHp <= 0) {
            battleResult = "lose";
            gp.notice.noticeBattleResult = battleResult;

            LogicBattleAction = "lose";
            gp.gameSupState = "notice";
            gp.notice.noticeTitle = "result";
            checkResult = false;
        }

    }

    // Lv up
    public void LvUp() {
        int expSurplus;
        expSurplus=gp.player_Stats.currentExp-gp.player_Stats.MaxExp;
        gp.player_Stats.lv++;
        gp.player_Stats.currentExp = 0;
        gp.player_Stats.setPlayerStats();
        gp.player_Stats.currentExp += expSurplus;
        
        gp.player_Stats.currentHp = gp.player_Stats.MaxHp;
        gp.player_Stats.currentMp = gp.player_Stats.MaxMp;
    }
}
