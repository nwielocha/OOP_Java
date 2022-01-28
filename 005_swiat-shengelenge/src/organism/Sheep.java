package organism;

import main.WorldPanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Sheep extends Organism {

    /*
    public Sheep(WorldPanel worldPanel) {
        super(worldPanel);
    }

     */

    public Sheep() {
        super(new WorldPanel());
        direction = "down";
        speed = 1 ;
        power = 3;
        initiative = 3;
        live = 10;
        powerToReproduce = 6;
        sign = 'S';

        getImage();
    }

    @Override
    public void getImage() {
        try {
            up = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_up.png")));
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_up1.png")));
            down = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_down.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_down1.png")));
            left = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_left.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_left1.png")));
            right = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_right.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sheep/sheep_right1.png")));
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
