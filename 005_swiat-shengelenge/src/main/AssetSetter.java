package main;

import organism.Dandelion;
import organism.Sheep;
import organism.Toadstool;
import organism.Wolf;

public class AssetSetter {

    WorldPanel worldPanel;

    public AssetSetter(WorldPanel worldPanel) {
        this.worldPanel = worldPanel;
    }

    public void setStaticOrganism() {
        worldPanel.organism[0] = new Dandelion();
        worldPanel.organism[0].x = 7 * worldPanel.tileSize;
        worldPanel.organism[0].y = 8 * worldPanel.tileSize;

        worldPanel.organism[1] = new Dandelion();
        worldPanel.organism[1].x = 5 * worldPanel.tileSize;
        worldPanel.organism[1].y = 9 * worldPanel.tileSize;

        worldPanel.organism[2] = new Toadstool();
        worldPanel.organism[2].x = 6 * worldPanel.tileSize;
        worldPanel.organism[2].y = 3 * worldPanel.tileSize;
    }

    public void setNonStaticOrganism() {
        // Kosmita pojawia sie randomowo i znika randomowo

        worldPanel.organism[3] = new Sheep();
        worldPanel.organism[3].x = 12 * worldPanel.tileSize;
        worldPanel.organism[3].y = 3 * worldPanel.tileSize;

        worldPanel.organism[4] = new Sheep();
        worldPanel.organism[4].x = 12 * worldPanel.tileSize;
        worldPanel.organism[4].y = 10 * worldPanel.tileSize;

        worldPanel.organism[5] = new Wolf();
        worldPanel.organism[5].x = 3 * worldPanel.tileSize;
        worldPanel.organism[5].y = 3 * worldPanel.tileSize;
    }
}
