package organism;

import main.Position;
import main.World;

import java.util.ArrayList;
import java.util.Random;

public abstract class Animal extends Organism {

    Random random = new Random();

    public Animal (World world, Position position, int power, int initiative, int liveLength, int powerToReproduce, char sign) {
        super(world, position, power, initiative, liveLength, powerToReproduce, sign);
    }

    @Override
    public void move() {
        ArrayList<Position> positions = world.collisionChecker.checkIfFreePosition(getPosition());
        this.getPreviousPosition().setX(getPosition().getX());
        this.getPreviousPosition().setY(getPosition().getY());
        int i = 0;

        for (Position ignored : positions) {
            i++;
        }

        int rand = random.nextInt(i);

        if (rand == 0) {
            getPosition().setX(positions.get(rand).getX());
            getPosition().setY(positions.get(rand).getY());
        }
        if (rand == 1) {
            getPosition().setX(positions.get(rand).getX());
            getPosition().setY(positions.get(rand).getY());
        }
        if (rand == 2) {
            getPosition().setX(positions.get(rand).getX());
            getPosition().setY(positions.get(rand).getY());
        }
        if (rand == 3) {
            getPosition().setX(positions.get(rand).getX());
            getPosition().setY(positions.get(rand).getY());
        }

    }
}