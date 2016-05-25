package com.inothnagel.VisualBinarySearchTree;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Main extends JFrame{
    private Canvas canvas = new Canvas();
    private Node rootNode;
    private Point startingPoint;
    private double rangeX = 10000;
    private double rangeY = 10000;

    private Main(){
        super();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        canvas.setSize(getSize());
        add(canvas);
        setVisible(true);
        canvas.createBufferStrategy(2);

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
        recursiveDrawNode(graphics, rootNode, startingPoint);
    }

    private void recursiveDrawNode(Graphics graphics, Node node, Point point) {
        drawNode(graphics, node, point);
    }

    private void drawNode(Graphics graphics, Node node, Point point) {
        graphics.fillOval(displayX(point.getX()), displayY(point.getY()), pixelWidth(node.width()), pixelHeight(node.Height()));
    }

    private void clearBackground(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0,0,getSize().width, getSize().height);
    }

    private int displayY(double y) {
        return (int) Math.round(y / pixelHeight());
    }

    private int displayX(double x) {
        return (int) Math.round(x / pixelWidth());
    }

    private double pixelHeight() {
        return rangeY / maxPixelHeight();
    }

    private double maxPixelHeight() {
        return getSize().getWidth();
    }

    private double pixelWidth() {
        return rangeX / maxPixelWidth();
    }

    private double maxPixelWidth() {
        return getSize().getHeight();
    }

    private int pixelWidth(double rangeWidth) {
        return (int) (rangeWidth / pixelWidth());
    }

    private int pixelHeight(double rangeHeight) {
        return (int) (rangeHeight / pixelHeight());
    }
}
