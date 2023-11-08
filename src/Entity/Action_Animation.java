package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import slimequest.GamePanel;

public class Action_Animation {

    GamePanel gp;
    int spriteCount = 0;
    int spriteNum = 0;
    int x = 0, tempx = 0;

    private BufferedImage attack[];
    private BufferedImage defence[];
    private BufferedImage HpPotion[];
    private BufferedImage MpPotion[];
    private BufferedImage fireBall[];
    private BufferedImage beam[];

    public String action = "none"; // animation

    public Action_Animation(GamePanel gp) {
        this.gp = gp;
        attack = new BufferedImage[7];
        defence = new BufferedImage[3];
        HpPotion = new BufferedImage[7];
        MpPotion = new BufferedImage[7];
        fireBall = new BufferedImage[4];
        beam = new BufferedImage[6];
        loadImage();
    }

    private void loadImage() {
        try {
            // Attack
            attack[1] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/attack1.png"));
            attack[2] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/attack2.png"));
            attack[3] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/attack3.png"));
            attack[4] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/attack4.png"));
            attack[5] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/attack5.png"));

            // Defence
            defence[1] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/defence1.png"));
            defence[2] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/defence2.png"));

            // HP Potion 
            HpPotion[1] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/HpPoiton1.png"));
            HpPotion[2] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/HpPoiton2.png"));
            HpPotion[3] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/HpPoiton3.png"));
            HpPotion[4] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/HpPoiton4.png"));
            HpPotion[5] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/HpPoiton5.png"));
            HpPotion[6] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/HpPoiton6.png"));

            // MP Potion
            MpPotion[1] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/MpPotion1.png"));
            MpPotion[2] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/MpPotion2.png"));
            MpPotion[3] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/MpPotion3.png"));
            MpPotion[4] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/MpPotion4.png"));
            MpPotion[5] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/MpPotion5.png"));
            MpPotion[6] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/MpPotion6.png"));

            // fire ball
            fireBall[1] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/fireball1.png"));
            fireBall[2] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/fireball2.png"));
            fireBall[3] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/fireball3.png"));

            // beam
            beam[1] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/beam1.png"));
            beam[2] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/beam2.png"));
            beam[3] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/beam3.png"));
            beam[4] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/beam4.png"));
            beam[5] = ImageIO.read(getClass().getResourceAsStream("/Picture/animation/beam5.png"));

        } catch (IOException e) {
            //
        }
    }

    public void setDefault() {
        action = "none";
        spriteCount = 0;
        spriteNum = 0;
    }

    public void draw_Attack(Graphics g) {

        spriteCount++;
        if (spriteCount > 5) {
            if (spriteNum == 0) {
                spriteNum = 1;
            } else if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            }
            spriteCount = 0;
        }

        if (spriteNum == 1) {
            g.drawImage(attack[1], 590, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 2) {
            g.drawImage(attack[2], 590, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 3) {
            g.drawImage(attack[3], 590, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 4) {
            g.drawImage(attack[4], 590, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 5) {
            g.drawImage(attack[5], 590, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 6) {
            g.drawImage(attack[5], 590, 200, gp.title_size, gp.title_size, null);
            action = "none";
            spriteNum = 0;
        }

    }

    public void draw_defence(Graphics g) {
        spriteCount++;
        if (spriteCount > 20) {
            if (spriteNum == 0) {
                spriteNum = 1;
            } else if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            }
            spriteCount = 0;
        }
        if (spriteNum == 1) {
            g.drawImage(defence[1], 210, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 2) {
            g.drawImage(defence[2], 210, 200, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 3) {
            g.drawImage(defence[2], 210, 200, gp.title_size, gp.title_size, null);
            action = "none";
            spriteNum = 0;
        }
    }

    public void draw_use_HpPotion(Graphics g) {
        spriteCount++;
        if (spriteCount > 10) {
            if (spriteNum == 0) {
                spriteNum = 1;
            } else if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            } else if (spriteNum == 6) {
                spriteNum = 7;
            }
            spriteCount = 0;
        }
        if (spriteNum == 1) {
            g.drawImage(HpPotion[1], 210, 190, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 2) {
            g.drawImage(HpPotion[2], 210, 190, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 3) {
            g.drawImage(HpPotion[3], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 4) {
            g.drawImage(HpPotion[4], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 5) {
            g.drawImage(HpPotion[5], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 6) {
            g.drawImage(HpPotion[6], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 7) {
            g.drawImage(HpPotion[6], 210, 190, gp.title_size, gp.title_size, null);
            action = "none";
            spriteNum = 0;
        }

    }

    public void draw_use_MpPotion(Graphics g) {
        spriteCount++;
        if (spriteCount > 10) {
            if (spriteNum == 0) {
                spriteNum = 1;
            } else if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            } else if (spriteNum == 6) {
                spriteNum = 7;
            }
            spriteCount = 0;
        }
        if (spriteNum == 1) {
            g.drawImage(MpPotion[1], 210, 190, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 2) {
            g.drawImage(MpPotion[2], 210, 190, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 3) {
            g.drawImage(MpPotion[3], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 4) {
            g.drawImage(MpPotion[4], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 5) {
            g.drawImage(MpPotion[5], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 6) {
            g.drawImage(MpPotion[6], 210, 190, gp.title_size, gp.title_size, null);

        } else if (spriteNum == 7) {
            g.drawImage(MpPotion[6], 210, 190, gp.title_size, gp.title_size, null);
            action = "none";
            spriteNum = 0;
        }

    }

 
    public void draw_Fire_Ball(Graphics g) {

        spriteCount++;
        if (spriteCount > 10) {
            if (spriteNum == 0) {
                spriteNum = 1;
            } else if (spriteNum == 1) {
                spriteNum = 0;
            }
            spriteCount = 0;
        }
        if (spriteNum == 0) {
            g.drawImage(fireBall[1], 250 + x, 190, gp.title_size, gp.title_size, null);
        } else if (spriteNum == 1) {
            g.drawImage(fireBall[2], 250 + x, 190, gp.title_size, gp.title_size, null);
        }
        x += 5;
        if (x + 250 > 600) {
            g.drawImage(fireBall[3], 600, 190, gp.title_size, gp.title_size, null);
            spriteNum = 3;
        }
        if (x + 250 >= 750) {
            spriteNum = 0;
            x = 0;
            action = "none";
        }

    }

    public void draw_beam(Graphics g) {

        if (spriteCount > 40) {
            if (spriteNum == 0) {
                spriteNum = 1;
            }
            spriteCount = 0;
        }
        if (spriteNum == 0) {
            g.drawImage(beam[1], 210, 200, gp.title_size, gp.title_size, null);
            spriteCount++;
        } else if (spriteNum == 1) {
            g.drawImage(beam[5], 220, 200, gp.title_size, gp.title_size, null);
            g.drawImage(beam[2], 230, 200, gp.title_size + x, gp.title_size, null);
            g.drawImage(beam[3], 240 + x, 200, gp.title_size, gp.title_size, null);
            x += 5;
            if (240 + x > 600) {
                spriteNum = 3;
            }
        } else if (spriteNum == 3) {
            spriteCount++;
            if (spriteCount > 40) {
                if (spriteNum == 3) {
                    spriteNum = 0;
                    x = 0;
                    action = "none";
                    spriteCount = 0;
                }
            }
            g.drawImage(fireBall[3], 600, 190, gp.title_size, gp.title_size, null);
        }
    }
}
