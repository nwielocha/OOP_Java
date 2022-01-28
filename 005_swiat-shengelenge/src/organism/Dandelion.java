package organism;

import main.WorldPanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Dandelion extends Organism {

    public Dandelion() {
        super(new WorldPanel());
        direction = "down";
        power = 0;
        initiative = 0;
        live = 6;
        powerToReproduce = 2;
        sign = 'D';

        getImage();
    }

    @Override
    public void getImage() {
        try {
            down = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/dandelion/dandelion.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAction() {
        direction = "down";
    }
}
