package organism;

import main.Position;
import main.World;

import java.util.ArrayList;
import java.util.Random;

public abstract class Organism {

    World world;
    private Position position;
    private int power;
    private int initiative;
    private int lifeLength;
    private int powerToReproduce;
    private char sign;
    private final Position lastPosition = new Position(0, 0);
    private boolean isStopped = false;

    public Organism(World world, Position position, int power, int initiative, int liveLength, int powerToReproduce, char sign) {
        this.world = world;
        this.position = position;
        this.power = power;
        this.initiative = initiative;
        this.lifeLength = liveLength;
        this.powerToReproduce = powerToReproduce;
        this.sign = sign;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getLifeLength() {
        return lifeLength;
    }

    public void setLifeLength(int lifeLength) {
        this.lifeLength = lifeLength;
    }

    public int getPowerToReproduce() {
        return powerToReproduce;
    }

    public void setPowerToReproduce(int powerToReproduce) {
        this.powerToReproduce = powerToReproduce;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public Position getPreviousPosition() {
        return lastPosition;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    public boolean ifReproduce() {
        return this.power >= this.powerToReproduce;
    }

    public abstract void move();

    public void reproduce() {
        Position position = chooseBirthPlace();

        if (position == null) {
            Organism newOrganism = this.newOne(world, getPosition());
            world.addOrganism(newOrganism);
        } else {
            Organism newOrganism = this.newOne(world, position);
            world.addOrganism(newOrganism);
        }

        world.sortOrganisms();
    }

    public void increasePower(int x) {
        this.setPower(this.getPower() + x);
    }

    public void decreaseLifeLength() {
        this.setLifeLength(this.getLifeLength() - 1);
    }

    public boolean isDead() {
        if (lifeLength < 1) {
            world.addRemovedOrganism(this);
            return true;
        }
        return false;
    }

    public void action() {
        ArrayList<Organism> organismArrayList = world.collisionChecker.checkIfOrganism(this);

        for (Organism value : world.getOrganisms()) {
            for (Organism organism : organismArrayList) {
                if (organism != null && organism.getPosition().isEqual(value.getPosition())) {
                    if (value.getSign() == this.getSign() && value.ifReproduce() && this.ifReproduce()) {
                        world.addNewOrganism(value);
                        this.setPower(this.getPower() / 2);
                        value.setPower(value.getPower() / 2);
                    } else if (this.getSign() == 'S' && value.getSign() == 'G') {
                        while (!this.ifReproduce()) {
                            world.addRemovedOrganism(value);
                            increasePower(2);
                        }
                    } else if (this.getSign() == 'W' && value.getSign() == 'S') {
                        while (!this.ifReproduce()) {
                            world.addRemovedOrganism(value);
                            increasePower(5);
                        }
                    }
                }
            }
        }

        if (this instanceof Plant && this.ifReproduce()) {
            world.addNewOrganism(this);
        }
    }

    public void update() {
        if (!(this instanceof Alien) && !isDead() && !isStopped()) {
            action();
        }
        if (!(this instanceof Plant) && world.collisionChecker.checkIfPossibleMove(getPosition()) && !isStopped()) {
            this.move();
        }

        increasePower(1);
        decreaseLifeLength();

        if (this instanceof Animal) {
            ((Animal) this).setStopped(false);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " power = " + this.power + ", liveLength = " + this.lifeLength + ", powerToReproduce = "
                + this.powerToReproduce + ", position = " + this.position;
    }

    public Position chooseBirthPlace() {
        ArrayList<Position> positions = world.collisionChecker.checkIfFreePosition(getPosition());
        Random random = new Random();
        int i = 0;

        for (Position ignored : positions) {
            i++;
        }

        int rand = random.nextInt(i);

        if (rand == 0)
            return positions.get(rand);
        if (rand == 1)
            return positions.get(rand);
        if (rand == 2)
            return positions.get(rand);
        if (rand == 3)
            return positions.get(rand);

        return null;
    }

    public abstract Organism newOne(World world, Position position);
}