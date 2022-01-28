package main;

import organism.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        World world = new World();

        Organism sheep1 = new Sheep(world, new Position(1, 3));
        Organism sheep2 = new Sheep(world, new Position(1, 2));
        Organism grass = new Grass(world, new Position(2, 4));
        Organism dandelion = new Dandelion(world, new Position(3, 1));

        world.addOrganism(sheep1);
        world.addOrganism(sheep2);
        world.addOrganism(grass);
        world.addOrganism(dandelion);

        world.run();
    }
}