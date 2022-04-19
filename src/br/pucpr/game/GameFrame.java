package br.pucpr.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.awt.event.KeyEvent.*;

public class GameFrame extends JFrame {
    private Set<Integer> keys = new HashSet<>();
    private boolean running = true;
    private double x =10;
    private double x2 = 790;
    private BufferedImage ship;

    public GameFrame(String title, int w, int h) {
        super(title);
        setSize(w, h);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        setUndecorated(true);
        setIgnoreRepaint(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                createBufferStrategy(2);
                new Thread(() -> gameLoop()).start();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keys.remove(e.getKeyCode());
            }
        });
    }

    private boolean isDown(int code) {
        return keys.contains(code);
    }

    private void setup() throws IOException{
        ship = ImageIO.read(getClass().getResourceAsStream("/br/pucpr/game/assets/ship.png"));
    }

    private void update(double s){
        if (isDown(VK_RIGHT)) {
            x+= 400 * s;
        } else if (isDown(VK_LEFT)) {
            x-= 400* s;
        }

        if (isDown(VK_ESCAPE)){
            running = false;
        }
        x2-= 400 * s;
    }

    private void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,getWidth(), getHeight());

        g2d.setColor(Color.white);
        g2d.drawImage(ship, (int)x , 400, 100, 120, null);


        g2d.setColor(Color.RED);
        g2d.fillOval((int)x2,150,30,30);

    }

    private void gameLoop(){
        try{
            setup();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        long time = 1;
        while (running){
            var before = System.currentTimeMillis();

            update(time/ 1000.0);
            draw((Graphics2D) getBufferStrategy().getDrawGraphics());
            if (!getBufferStrategy().contentsLost()) {
                getBufferStrategy().show();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("Game Interrupted");
                running = false;
            }

            time = System.currentTimeMillis()- before;
        }
        EventQueue.invokeLater(() -> dispose());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                new GameFrame("Game", 800, 600).setVisible(true)
        );
    }

}