package main;

import organism.Alien;
import organism.Organism;
import organism.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class World {

    public final int worldX = 20;
    public final int worldY = 10;
    public int turn = 0;
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    Map map = new Map(this);

    Organism alien = new Alien(this, new Position(0, 0), 0, 0, 0, 0, 'A');
    private final ArrayList<Organism> organisms;
    private final ArrayList<Organism> newOrganisms;
    private final ArrayList<Organism> removedOrganisms;

    public World() {
        this.organisms = new ArrayList<>();
        this.newOrganisms = new ArrayList<>();
        this.removedOrganisms = new ArrayList<>();
    }


    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }


    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }


    public void sortOrganisms() {
        organisms.sort(Comparator.comparing(Organism::getInitiative));
        Collections.reverse(organisms);
    }

    public void addOrganism(Organism organism) {
        organisms.add(organism);
    }

    public void addNewOrganism(Organism organism) {
        newOrganisms.add(organism);
    }

    public void addRemovedOrganism(Organism organism) {
        removedOrganisms.add(organism);
    }

    public void removeOrganism(Organism organism) {
        organisms.remove(organism);
    }

    public void run() throws InterruptedException {
        while (true) {
            map.setMap(organisms);
            map.printMap();
            update();
            Thread.sleep(300);
        }
    }

    public void runNTurns(int turn) throws InterruptedException {
        for (int i = 0; i < turn; i++) {
            map.setMap(organisms);
            map.printMap();
            update();
            Thread.sleep(300);
        }
    }

    public void organismManager() {
        if (!removedOrganisms.isEmpty()) {
            for (Organism organism : removedOrganisms) {
                map.grid[organism.getPosition().getX()][organism.getPosition().getY()] = ' ';
                removeOrganism(organism);
            }
        }
        if (!newOrganisms.isEmpty()) {
            for (Organism organism : newOrganisms) {
                organism.reproduce();
            }
        }
        newOrganisms.clear();
    }

    public void update() {
        for (Organism organism : organisms) {
            organism.update();
            updateMap(organism);
        }
        organismManager();
        alienManager();

        for (Organism organism : organisms) {
            if (!(organism instanceof Plant)) {
                System.out.println(organism.getSign() + " " + organism.getPosition().getX() + ":" + organism.getPosition().getY());
            }
        }
    }

    public void updateMap (Organism organism) {
        map.grid[organism.getPreviousPosition().getX()][organism.getPreviousPosition().getY()] = ' ';
        map.grid[organism.getPosition().getX()][organism.getPosition().getY()] = organism.getSign();
    }

    public Organism getOrganismByPosition(Organism currentOrganism, Position checkPosition) {
        for (Organism organism : organisms) {
            if (checkPosition.getX() == organism.getPosition().getX() && checkPosition.getY() == organism.getPosition().getY() && organism != currentOrganism) {
                return organism;
            }
        }
        return null;
    }

    public boolean checkIfOccupied(Position checkPosition) {
        for (Organism organism : organisms) {
            if (checkPosition.getX() == organism.getPosition().getX() && checkPosition.getY() == organism.getPosition().getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean alienExists() {
        for (Organism organism : organisms) {
            if (organism.getSign() == 'A') {
                return true;
            }
        }
        return false;
    }

    public void alienManager() {
        if (!alienExists()) {
            Random random = new Random();
            int rand = random.nextInt(6);
            int randX = random.nextInt(worldX - 3) + 1;
            int randY = random.nextInt(worldY - 3) + 1;

            while (checkIfOccupied(new Position(randX, randY))) {
                randX = random.nextInt(worldX - 3) + 1;
                randY = random.nextInt(worldY - 3) + 1;
            }

            if (rand == 0) {
                Organism newOrganism = alien.newOne(this, new Position(randX, randY));
                addOrganism(newOrganism);
                sortOrganisms();
            }
        }
    }
}