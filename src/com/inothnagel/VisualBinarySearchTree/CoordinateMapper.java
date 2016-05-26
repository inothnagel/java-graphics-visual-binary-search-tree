package com.inothnagel.VisualBinarySearchTree;

import com.sun.javafx.geom.Point2D;

import java.awt.*;

/**
 * Created by inothnagel on 2016/05/25.
 */
public class CoordinateMapper {
    private final Canvas canvas;
    private final Field field;

    public CoordinateMapper(Canvas canvas, Field field) {
        this.canvas = canvas;
        this.field = field;
    }


    public FieldPosition toFieldPosition(CanvasPosition canvasPosition) {
        return new FieldPosition(
                canvasPosition.x * pixelWidth(),
                canvasPosition.y * pixelHeight()
        );
    }

    public CanvasPosition toCanvasPosition(FieldPosition fieldPosition) {
        return new CanvasPosition(
                fieldPosition.x / pixelWidth(),
                fieldPosition.y / pixelHeight()
        );
    }

    private float pixelHeight() {
        return field.getHeight() / canvas.getHeight();
    }

    private float pixelWidth() {
        return field.getWidth() / canvas.getWidth();
    }
}
