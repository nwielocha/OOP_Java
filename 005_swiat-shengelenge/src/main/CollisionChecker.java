package main;

import organism.Organism;

public class CollisionChecker {

    WorldPanel worldPanel;

    public CollisionChecker(WorldPanel worldPanel) {
        this.worldPanel = worldPanel;
    }

    public void checkTile(Organism organism) {
        int organismLeftX = organism.x + organism.solidArea.x;
        int organismRightX = organism.x + organism.solidArea.x + organism.solidArea.width;
        int organismTopY = organism.y + organism.solidArea.y;
        int organismBottomY = organism.y + organism.solidArea.y + organism.solidArea.height;

        int organismLeftCol = organismLeftX / worldPanel.tileSize;
        int organismRightCol = organismRightX / worldPanel.tileSize;
        int organismTopRow = organismTopY / worldPanel.tileSize;
        int organismBottomRow = organismBottomY / worldPanel.tileSize;

        // Musimy sprawdzic tylko 2 rogi prostokata idac np do gory
        int tileNum1, tileNum2;

        switch (organism.direction) {
            case "up" -> {
                organismTopRow = (organismTopY - organism.speed) / worldPanel.tileSize;
                tileNum1 = worldPanel.tileManager.mapTileNum[organismLeftCol][organismTopRow];
                tileNum2 = worldPanel.tileManager.mapTileNum[organismRightCol][organismTopRow];
                if (worldPanel.tileManager.tiles[tileNum1].collision || worldPanel.tileManager.tiles[tileNum2].collision) {
                    organism.collisionOn = true;
                }
            }
            case "down" -> {
                organismBottomRow = (organismBottomY + organism.speed) / worldPanel.tileSize;
                tileNum1 = worldPanel.tileManager.mapTileNum[organismLeftCol][organismBottomRow];
                tileNum2 = worldPanel.tileManager.mapTileNum[organismRightCol][organismBottomRow];
                if (worldPanel.tileManager.tiles[tileNum1].collision || worldPanel.tileManager.tiles[tileNum2].collision) {
                    organism.collisionOn = true;
                }
            }
            case "left" -> {
                organismLeftCol = (organismLeftX - organism.speed) / worldPanel.tileSize;
                tileNum1 = worldPanel.tileManager.mapTileNum[organismLeftCol][organismTopRow];
                tileNum2 = worldPanel.tileManager.mapTileNum[organismRightCol][organismBottomRow];
                if (worldPanel.tileManager.tiles[tileNum1].collision || worldPanel.tileManager.tiles[tileNum2].collision) {
                    organism.collisionOn = true;
                }
            }
            case "right" -> {
                organismRightCol = (organismRightX + organism.speed) / worldPanel.tileSize;
                tileNum1 = worldPanel.tileManager.mapTileNum[organismLeftCol][organismTopRow];
                tileNum2 = worldPanel.tileManager.mapTileNum[organismRightCol][organismBottomRow];
                if (worldPanel.tileManager.tiles[tileNum1].collision || worldPanel.tileManager.tiles[tileNum2].collision) {
                    organism.collisionOn = true;
                }
            }
        }
    }
}
