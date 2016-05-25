package com.inothnagel.VisualBinarySearchTree;

/**
 * Created by inothnagel on 2016/05/25.
 */
public class Node {
    private final int value;
    private double x;
    private double y;
    private double width;
    private double height;

    public Node(int i) {
        this.value = i;
        width = height = 100;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
