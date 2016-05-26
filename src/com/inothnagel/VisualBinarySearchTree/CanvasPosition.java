package com.inothnagel.VisualBinarySearchTree;

import com.sun.javafx.geom.Point2D;

/**
 * Created by inothnagel on 2016/05/26.
 */
public class CanvasPosition extends Point2D {
    public CanvasPosition(float x, float y) {
        super(x,y);
    }


    public CanvasPosition(double x, double y) {
//        evil unsafe casting for now
//        todo: validate that we don't exceed float max value
        super((float) x, (float) y);
    }
}
