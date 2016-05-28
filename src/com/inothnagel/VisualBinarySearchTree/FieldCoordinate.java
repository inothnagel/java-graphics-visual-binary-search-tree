package com.inothnagel.VisualBinarySearchTree;

public class FieldCoordinate extends Coordinate {

    public FieldCoordinate(CoordinateMapper coordinateMapper, float x, float y) {
        super(coordinateMapper, x, y);
    }

    public CanvasCoordinate toCanvasCoordinate() {
        return getCoordinateMapper().toCanvasCoordinate(this);
    }
}
