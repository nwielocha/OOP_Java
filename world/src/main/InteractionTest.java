package main;

import org.junit.Test;
import organism.Organism;
import organism.Sheep;

import static org.junit.Assert.assertEquals;

public class InteractionTest {

    @Test
    public void testSheepReproducing() {
        World world = new World();
        Organism sheep = new Sheep(world, new Position(1, 1));
        Organism sheep1 = new Sheep(world, new Position(1, 2));

        world.addOrganism(sheep);
        world.addOrganism(sheep1);
        world.setTurn(10);

        assertEquals(2, world.getOrganisms().size());
    }

}
