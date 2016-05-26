package com.inothnagel.VisualBinarySearchTree;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CoordinateMapperTest {
    CoordinateMapper mapper;

    @Before
    public void setup() {
        Canvas canvas = new Canvas();
        canvas.setSize(400, 300);
        Field field = new Field(800f, 600f);
        mapper = new CoordinateMapper(canvas, field);
    }

    @Test
    public void convertsCanvasToFieldCoordinates() {
        CanvasCoordinate canvasCoordinate = new CanvasCoordinate(200f, 150f);
        FieldCoordinate fieldCoordinate = mapper.toFieldPosition(canvasCoordinate);
        assertThat(fieldCoordinate.x, is(400f));
        assertThat(fieldCoordinate.y, is(300f));
    }

    @Test
    public void convertsFieldCoordinatesToCanvasCoordinates() {
        FieldCoordinate fieldCoordinate = new FieldCoordinate(700f, 300f);
        CanvasCoordinate canvasCoordinate = mapper.toCanvasPosition(fieldCoordinate);
        assertThat(canvasCoordinate.x, is(350f));
        assertThat(canvasCoordinate.y, is(150f));
    }

}