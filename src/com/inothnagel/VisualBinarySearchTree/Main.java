package com.inothnagel.VisualBinarySearchTree;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Main extends JFrame{
    private Canvas canvas= new Canvas();

    private Main(){
        super();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        canvas.setSize(getSize());
        add(canvas);
        setVisible(true);
        canvas.createBufferStrategy(2);
    }

    public static void main(String arg[]) throws InterruptedException {
        Main main = new Main();
        main.loop();
    }

    private void moveBlobs() {

    }

    private void loop() throws InterruptedException {
        while (true) {
            Graphics graphics = canvas.getBufferStrategy().getDrawGraphics();
            clearBackground(graphics);
            // move action here
            canvas.getBufferStrategy().show();
            sleep(40);
        }
    }

    private void clearBackground(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0,0,getSize().width, getSize().height);
    }
}
