package organism;

import main.Position;
import main.World;

public class Wolf extends Animal {
    public Wolf(World world, Position position) {
        super(world, position, 8, 5, 20, 16, 'W');
    }

    @Override
    public Organism newOne(World world, Position position) {
        return new Wolf(world, new Position(position.getX(), position.getY()));
    }
}
