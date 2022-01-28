package organism;

import main.WorldPanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Alien extends Organism {

    /*
    public Alien(WorldPanel worldPanel) {
        super(worldPanel);
    }

     */

    public Alien() {
        super(new WorldPanel());
        direction = "down";
        speed = 4;

        getImage();
    }

    @Override
    public void getImage() {
        try {
            up = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_up.png")));
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_up1.png")));
            down = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_down.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_down1.png")));
            left = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_left.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_left1.png")));
            right = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_right.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/alien/alien_right1.png")));
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
