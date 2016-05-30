package com.inothnagel.VisualBinarySearchTree;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CanvasCoordinateTest {
    private CanvasCoordinate canvasCoordinate;

    @Before
    public void setup() {
        Canvas canvas = new Canvas();
        canvas.setSize(400, 300);

        Field field = new Field(800, 600);

        CoordinateMapper coordinateMapper = new CoordinateMapper(canvas, field);
        canvasCoordinate = new CanvasCoordinate(coordinateMapper, 150, 250);
    }

    @Test
    public void convertsToFieldCoordinate() {
        FieldCoordinate fieldCoordinate = canvasCoordinate.toFieldCoordinate();
        assertThat(fieldCoordinate.x, is(300f));
        assertThat(fieldCoordinate.y, is(500f));
    }
}