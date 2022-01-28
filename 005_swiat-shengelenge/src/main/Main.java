package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("World");

        WorldPanel worldPanel = new WorldPanel();
        window.add(worldPanel);

        window.pack(); // zeby zobaczyc okno

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        worldPanel.setupWorld();
        worldPanel.startWorldThread();
    }
}
