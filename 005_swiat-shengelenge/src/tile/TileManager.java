package tile;

import main.WorldPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    WorldPanel worldPanel;
    public Tile [] tiles;
    public int[][] mapTileNum;

    public TileManager(WorldPanel worldPanel) {
        this.worldPanel = worldPanel;

        // rozne rodzaje tla (woda, trawa..)
        tiles = new Tile[10];
        mapTileNum = new int[worldPanel.maxScreenCol][worldPanel.maxScreenRow];

        getTileImage();
        loadMap("/maps/map01.txt");
    }


    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass.png")));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
            tiles[1].collision = true;

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png")));
            tiles[2].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));

            int col = 0;
            int row = 0;

            // Wczytywanie mapy z pliku txt, skanujemy linjike po linjice
            while (col < worldPanel.maxScreenCol && row < worldPanel.maxScreenRow) {
                String line = bufferedReader.readLine();

                // Bierzyemy numery z pliku i wczytujemy jeden po drugim do tablicy numbers
                while (col < worldPanel.maxScreenCol) {
                    String[] numbers = line.split(" ");

                    // Zamiana String na integer
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col == worldPanel.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }

            bufferedReader.close();

        } catch (Exception ignored) {

        }
    }

    public void draw(Graphics2D graphics2D) {
        int col = 0, row = 0, x = 0, y = 0;

        while (col < worldPanel.maxScreenCol && row < worldPanel.maxScreenRow) {
            // Wyciagam numer kafelka ktory jest schowany w mapTileNum
            int tileNum = mapTileNum[col][row];

            graphics2D.drawImage(tiles[tileNum].image, x, y, worldPanel.tileSize, worldPanel.tileSize, null);
            col++;
            x += worldPanel.tileSize;

            if (col == worldPanel.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += worldPanel.tileSize;
            }
        }
    }
}


