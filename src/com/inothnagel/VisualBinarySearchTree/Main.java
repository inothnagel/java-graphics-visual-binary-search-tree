package com.inothnagel.VisualBinarySearchTree;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Main extends JFrame {
    private Canvas canvas = new Canvas();
    private Node rootNode;
    private Point startingPoint = new Point(300, 300);
    private Field field;
    private CoordinateMapper coordinateMapper;

    private Main() {
        super();
        field = new Field(1000,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        canvas.setSize(getSize());
        add(canvas);
        setVisible(true);
        canvas.createBufferStrategy(2);
        this.coordinateMapper = new CoordinateMapper(canvas, field);
        rootNode = initTree();
    }

    private Node initTree() {
        return new Node(13);
    }

    public static void main(String arg[]) throws InterruptedException {
        Main main = new Main();
        main.loop();
    }

    private void loop() throws InterruptedException {
        while (true) {
            Graphics graphics = canvas.getBufferStrategy().getDrawGraphics();
            clearBackground(graphics);
            renderTree(graphics, rootNode);
            canvas.getBufferStrategy().show();
            sleep(40);
        }
    }

    private void renderTree(Graphics graphics, Node rootNode) {
//        recursiveDrawNode(graphics, rootNode, startingPoint);
    }

    private void recursiveDrawNode(Graphics graphics, Node node, Point point) {
        drawNode(graphics, node, point);
    }

    private void drawNode(Graphics graphics, Node node, Point point) {
        graphics.setColor(new Color(200, 200, 200));
        graphics.fillOval(displayX(point.getX()), displayY(point.getY()), pixelWidth(node.getWidth()), pixelHeight(node.getHeight()));
    }

    private void clearBackground(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, getSize().width, getSize().height);
    }

    private int displayY(double y) {
        return (int) Math.round(y / pixelHeight());
    }

    private int displayX(double x) {
        return (int) Math.round(x / pixelWidth());
    }

    private int pixelWidth(double rangeWidth) {
        return (int) (rangeWidth / pixelWidth());
    }

    private int pixelHeight(double rangeHeight) {
        return (int) (rangeHeight / pixelHeight());
    }

    private void printCoordinates(Graphics graphics) {
        double mouseX = canvas.getMousePosition().getX();
        double mouseY = canvas.getMousePosition().getY();
        graphics.setColor(new Color(200, 200, 200));
        graphics.drawString("Mouse: " + mouseX + " " + mouseY, 20, 20);
        graphics.drawString("Field: " + mouseFieldX() + " " + mouseFieldY() ,20, 40);
    }

    private double mouseFieldY() {
        return coordinateMapper.getFieldPosition(getMousePosition()).getY();
    }

    private double mouseFieldX() {
        return coordinateMapper.getFieldPosition(getMousePosition()).getX();
    }
}
