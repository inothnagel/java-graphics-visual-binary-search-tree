package com.inothnagel.VisualBinarySearchTree;

import java.awt.*;

public class CoordinateMapper {
    private final Canvas canvas;
    private final Field field;

    public CoordinateMapper(Canvas canvas, Field field) {
        this.canvas = canvas;
        this.field = field;
    }

    public FieldCoordinate toFieldCoordinate(CanvasCoordinate canvasCoordinate) {
        return new FieldCoordinate(
                this,
                canvasCoordinate.x * pixelWidth(),
                canvasCoordinate.y * pixelHeight()
        );
    }

    public CanvasCoordinate toCanvasCoordinate(FieldCoordinate fieldCoordinate) {
        return new CanvasCoordinate(
                this,
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

    public FieldCoordinate newFieldCoordinate(float x, float y) {
        return new FieldCoordinate(this, x, y);
    }

    public CanvasCoordinate newCanvasCoordinate(float x, float y) {
        return new CanvasCoordinate(this, x, y);
    }

    public FieldCoordinate fieldCoordinateFromCanvasCoordinates(float x, float y) {
        return new CanvasCoordinate(this, x, y).toFieldCoordinate();
    }

    public CanvasCoordinate getMouseCoordinates() {
        return new CanvasCoordinate(
                this,
                (float) canvas.getMousePosition().getX(),
                (float) canvas.getMousePosition().getY()
        );
    }
}
