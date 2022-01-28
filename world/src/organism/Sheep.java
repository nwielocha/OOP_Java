package organism;

import main.Position;
import main.World;

public class Sheep extends Animal{
    public Sheep(World world, Position position) {
        super(world, position, 3, 3, 10, 6, 'S');
    }

    @Override
    public Organism newOne(World world, Position position) {
        return new Sheep(world, new Position(position.getX(), position.getY()));
    }
}