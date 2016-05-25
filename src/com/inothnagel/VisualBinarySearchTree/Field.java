package com.inothnagel.VisualBinarySearchTree;

/**
 * game field
 */
public class Field {
    private double width = 1000;
    private double height= 1000;

    public Field(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
