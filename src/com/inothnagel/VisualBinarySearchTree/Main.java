package com.inothnagel.VisualBinarySearchTree;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Main extends JFrame {
    private Canvas canvas = new Canvas();
    private Field field;
    private CoordinateMapper coordinateMapper;

    private Main() {
        super();
        field = new Field(1000, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        canvas.setSize(getSize());
        add(canvas);
        setVisible(true);
        canvas.createBufferStrategy(2);
        this.coordinateMapper = new CoordinateMapper(canvas, field);
    }

    public static void main(String arg[]) throws InterruptedException {
        Main main = new Main();
        main.loop();
    }

    private void loop() throws InterruptedException {
        while (true) {
            Graphics graphics = canvas.getBufferStrategy().getDrawGraphics();
            clearBackground(graphics);
            printCoordinates(graphics);
            canvas.getBufferStrategy().show();
            sleep(40);
        }
    }

    private void printCoordinates(Graphics graphics) {
        if (getMousePosition() == null) {
            return;
        }

        float mouseX = (float) canvas.getMousePosition().getX();
        float mouseY = (float) canvas.getMousePosition().getY();

        FieldCoordinate fieldCoordinate = coordinateMapper.toFieldPosition(
                new CanvasCoordinate(
                        canvas.getMousePosition().getX(),
                        canvas.getMousePosition().getY()
                )
        );

        graphics.setColor(new Color(200, 200, 200));
        graphics.drawString("Mouse: " + mouseX + " " + mouseY, 20, 20);
        graphics.drawString("Field: " + fieldCoordinate.x + " " + fieldCoordinate.y, 20, 40);
    }

    private void clearBackground(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, getSize().width, getSize().height);
    }

}
