package com.inothnagel.VisualBinarySearchTree;

import com.sun.javafx.geom.Point2D;

public class Coordinate extends Point2D {
    private final CoordinateMapper coordinateMapper;

    public Coordinate(CoordinateMapper coordinateMapper, float x, float y) {
        super(x, y);
        this.coordinateMapper = coordinateMapper;
    }

    public CoordinateMapper getCoordinateMapper() {
        return coordinateMapper;
    }
}
