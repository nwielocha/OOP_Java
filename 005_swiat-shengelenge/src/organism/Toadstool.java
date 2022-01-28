package organism;

import main.WorldPanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Toadstool extends Organism {

    public Toadstool() {
        super(new WorldPanel());
        direction = "down";
        power = 0;
        initiative = 0;
        live = 16;
        powerToReproduce = 4;
        sign = 'T';

        getImage();
    }

    @Override
    public void getImage() {
        try {
            down = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/toadstool/toadstool.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAction() {
        direction = "down";
    }
}
