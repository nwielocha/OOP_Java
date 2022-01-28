package main;

import organism.Organism;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class WorldPanel extends JPanel implements Runnable {

    // Ustawienia ekranu
    final int originalTileSize = 16; // 16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    int FPS = 60;

    // System
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread worldThread; // Zegar za pomoca ktorego mozna zaczac gre oraz zakonczyc
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);

    public Organism[] organism = new Organism[10];

    public WorldPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // lepszy rendering
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupWorld()  {
        assetSetter.setStaticOrganism();
        assetSetter.setNonStaticOrganism();
    }

    public void startWorldThread() {
        // Przekazujemy WorldPanel do Thread
        worldThread = new Thread(this);
        worldThread.start(); // Automatycznie wywoluje run()
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;

        // Tutaj tworzymy petle dla naszego swiata
        while (worldThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // Update: aktualne dane o pozycji organizmu
                update();
                // Draw: rysuj ekran z zaaktualizowanymi danymi
                repaint(); // wywolanie paintComponent()
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        for (Organism value : organism) {
            if (value != null)
                value.update();
        }
    }

    // Standardowa metoda do rysowania w JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rozwiniecie klasy Graphics, od bardziej dokladej kontroli nad geometria, polozeniem, kolorami
        Graphics2D graphics2D = (Graphics2D)g; // zmieniamy Graphics na Graphics2D

        // Tile
        tileManager.draw(graphics2D);

        // Organism
        for (Organism value : organism) {
            if (value != null) {
                value.draw(graphics2D, this);
            }
        }

        graphics2D.dispose(); // oszczedza pamiec
    }
}
