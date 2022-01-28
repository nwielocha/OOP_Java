package organism;

import main.WorldPanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Wolf extends Organism {

    /*
    public Wolf(WorldPanel worldPanel) {
        super(worldPanel);
    }

     */

    public Wolf() {
        super(new WorldPanel());
        direction = "down";
        speed = 3;
        power = 8;
        initiative = 5;
        live = 20;
        powerToReproduce = 16;
        sign = 'W';

        getImage();
    }

    @Override
    public void getImage() {
        try {
            up = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_up.png")));
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_up1.png")));
            down = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_down.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_down1.png")));
            left = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_right.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_right1.png")));
            right = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_left.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/wolf/wolf_left1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAction() {
        actionCounter++;

        // Co 2 sekundy bedzie zmienial kierunek
        if (actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25)
                direction = "up";
            if (i > 25 && i <= 50)
                direction = "down";
            if (i > 50 && i <= 75)
                direction = "left";
            if (i > 75)
                direction = "right";

            actionCounter = 0;
        }
    }
}
