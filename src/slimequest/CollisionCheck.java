/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slimequest;

import entity.Entity;

/**
 *
 * @author fluk2
 */
public class CollisionCheck {
    GamePanel gp;
    
    public CollisionCheck(GamePanel gp){
        this.gp = gp;
    }
    
    public void checkTile(Entity entity){
        int entityleft_x = entity.x + entity.solidArea.x;
        int entityright_x = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entitytop_y = entity.y + entity.solidArea.y;
        int entitybottom_y = entity.y + entity.solidArea.y + entity.solidArea.height - 6;
        
        int entityleft_col = entityleft_x/gp.titlesize;
        int entityright_col = entityright_x/gp.titlesize;
        int entitytop_row = entitytop_y/gp.titlesize;
        int entitybottom_row = entitybottom_y/gp.titlesize;
        
        
        // must is ||  not &&
        int tileNum1,tileNum2;
        if(entity.direction == "up"){
            entitytop_row = (entitytop_y-entity.speed)/gp.titlesize;
            tileNum1 = gp.tm.map.mapnum[entitytop_row][entityleft_col];
            tileNum2 = gp.tm.map.mapnum[entitytop_row][entityright_col];
            if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            if(gp.tm.tile[tileNum1].event == gp.tm.tile[tileNum2].event){
//                entity.collision_event = gp.tm.tile[tileNum1].event;
                  gp.ce.eventCheck = gp.tm.tile[tileNum1].event;
            }
        }
        else if(entity.direction == "down"){
            entitybottom_row = (entitybottom_y+entity.speed)/gp.titlesize;
            tileNum1 = gp.tm.map.mapnum[entitybottom_row][entityleft_col];
            tileNum2 = gp.tm.map.mapnum[entitybottom_row][entityright_col];
            if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            if(gp.tm.tile[tileNum1].event == gp.tm.tile[tileNum2].event){
//                entity.collision_event = gp.tm.tile[tileNum1].event;
                 gp.ce.eventCheck = gp.tm.tile[tileNum1].event;
            }
        }
        else if(entity.direction == "right"){
            entityright_col = (entityright_x+entity.speed)/gp.titlesize;
            tileNum1 = gp.tm.map.mapnum[entitytop_row][entityright_col];
            tileNum2 = gp.tm.map.mapnum[entitybottom_row][entityright_col];
            if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            if(gp.tm.tile[tileNum1].event == gp.tm.tile[tileNum2].event){
                gp.ce.eventCheck = gp.tm.tile[tileNum1].event;
            }
        }
        else if(entity.direction == "left"){
            entityleft_col = (entityleft_x-entity.speed)/gp.titlesize;
            tileNum1 = gp.tm.map.mapnum[entitytop_row][entityleft_col];
            tileNum2 = gp.tm.map.mapnum[entitybottom_row][entityleft_col];
            if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            if(gp.tm.tile[tileNum1].event == gp.tm.tile[tileNum2].event){
                gp.ce.eventCheck = gp.tm.tile[tileNum1].event;
            }
        }
//        System.out.println(entity.collision_event);
        
    }
    
}
