package organism;

import main.Position;
import main.World;

public class Dandelion extends Plant {
    public Dandelion(World world, Position position) {
        super(world, position, 0, 0, 6, 2, 'D');
    }

    @Override
    public void move() {

    }

    @Override
    public Organism newOne(World world, Position position) {
        return new Dandelion(world, position);
    }
}