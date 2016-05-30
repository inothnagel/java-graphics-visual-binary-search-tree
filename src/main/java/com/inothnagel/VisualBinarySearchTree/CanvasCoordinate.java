package com.inothnagel.VisualBinarySearchTree;

public class CanvasCoordinate extends Coordinate {
    public CanvasCoordinate(CoordinateMapper coordinateMapper, float x, float y) {
        super(coordinateMapper, x, y);
    }

    public CanvasCoordinate(CoordinateMapper coordinateMapper, double x, double y) {
//        evil unsafe casting for now
//        todo: validate that we don't exceed float max value
        super(coordinateMapper, (float) x, (float) y);
    }

    public FieldCoordinate toFieldCoordinate() {
        return getCoordinateMapper().toFieldCoordinate(this);
    }
}
