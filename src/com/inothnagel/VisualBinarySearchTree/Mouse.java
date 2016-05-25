package com.inothnagel.VisualBinarySearchTree;

import java.awt.*;

/**
 * Created by inothnagel on 2016/05/25.
 */
public class Mouse {
    private final Field field;
    private final Canvas canvas;

    public Mouse (Canvas canvas, Field field) {
        this.canvas = canvas;
        this.field = field;
    }

    public double getFieldX() {
        return getDisplayX() * getPixelWidth();
    }

    public double getFieldY() {
        return getDisplayY() * getPixelHeight();
    }

    public double getDisplayX() {
        return canvas.getMousePosition().getX();
    }

    public double getDisplayY() {
        return canvas.getMousePosition().getY();
    }

    public double getPixelWidth() {
        return field.getWidth() / canvas.getWidth();
    }

    public double getPixelHeight() {
        return field.getHeight() / canvas.getHeight();
    }
}
