package com.inothnagel.VisualBinarySearchTree;

import java.awt.*;

public class CoordinateMapper {
    private final Canvas canvas;
    private final Field field;

    public CoordinateMapper(Canvas canvas, Field field) {
        this.canvas = canvas;
        this.field = field;
    }

    public FieldCoordinate toFieldPosition(CanvasCoordinate canvasCoordinate) {
        return new FieldCoordinate(
                canvasCoordinate.x * pixelWidth(),
                canvasCoordinate.y * pixelHeight()
        );
    }

    public CanvasCoordinate toCanvasPosition(FieldCoordinate fieldCoordinate) {
        return new CanvasCoordinate(
                fieldCoordinate.x / pixelWidth(),
                fieldCoordinate.y / pixelHeight()
        );
    }

    private float pixelHeight() {
        return field.getHeight() / canvas.getHeight();
    }

    private float pixelWidth() {
        return field.getWidth() / canvas.getWidth();
    }
}
