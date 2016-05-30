package com.inothnagel.VisualBinarySearchTree;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FieldCoordinateTest {
    public CoordinateMapper coordinateMapper;
    public FieldCoordinate fieldCoordinate;

    @Before
    public void setup() {
        Canvas canvas = new Canvas();
        canvas.setSize(400, 300);
        Field field = new Field(800, 600);
        coordinateMapper = new CoordinateMapper(canvas, field);
        fieldCoordinate = new FieldCoordinate(coordinateMapper, 150, 250);
    }


    @Test
    public void convertsToCanvasCoordinate() {
        CanvasCoordinate canvasCoordinate = fieldCoordinate.toCanvasCoordinate();
        assertThat(canvasCoordinate.x, is(75f));
        assertThat(canvasCoordinate.y, is(125f));
    }
}