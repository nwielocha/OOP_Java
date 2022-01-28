package organism;

import main.WorldPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Organism {

    WorldPanel worldPanel;
    public int x, y;
    public int speed;
    public int power;
    public int live;
    public int powerToReproduce;
    public int initiative;
    public char sign;
    public BufferedImage up, up1, down, down1, left, left1, right, right1;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // przestrzen ktora wyznacza miesjce kolizji
    public boolean collisionOn = false;
    public int actionCounter = 0;

    public Organism(WorldPanel worldPanel) {
        this.worldPanel = worldPanel;
    }

    /*
    public Organism() {

    }

     */

    public void getImage() {

    }


    public void setAction() {

    }

    public void update() {
        setAction();

        collisionOn = false;
        worldPanel.collisionChecker.checkTile(this);

        if (!collisionOn) {
            switch (direction) {
                case "up" -> y -= speed;
                case "down" -> y += speed;
                case "left" -> x -= speed;
                case "right" -> x += speed;
            }
        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1)
                spriteNum = 2;
            else if (spriteNum == 2)
                spriteNum = 1;

            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D graphics2D, WorldPanel worldPanel) {
        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1)
                    image = up;
                if (spriteNum == 2)
                    image = up1;
            }
            case "down" -> {
                if (spriteNum == 1)
                    image = down;
                if (spriteNum == 2)
                    image = down1;
            }
            case "left" -> {
                if (spriteNum == 1)
                    image = left;
                if (spriteNum == 2)
                    image = left1;
            }
            case "right" -> {
                if (spriteNum == 1)
                    image = right;
                if (spriteNum == 2)
                    image = right1;
            }
        }

        graphics2D.drawImage(image, x, y, worldPanel.tileSize, worldPanel.tileSize, null);
    }
}
