package com.inothnagel.VisualBinarySearchTree;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CoordinateMapperTest {
    CoordinateMapper coordinateMapper;

    @Before
    public void setup() {
        Canvas canvas = new Canvas();
        canvas.setSize(400, 300);
        Field field = new Field(800f, 600f);
        coordinateMapper = new CoordinateMapper(canvas, field);
    }

    @Test
    public void convertsCanvasToFieldCoordinates() {
        CanvasCoordinate canvasCoordinate = new CanvasCoordinate(coordinateMapper, 200f, 150f);
        FieldCoordinate fieldCoordinate = coordinateMapper.toFieldCoordinate(canvasCoordinate);
        assertThat(fieldCoordinate.x, is(400f));
        assertThat(fieldCoordinate.y, is(300f));
    }

    @Test
    public void convertsFieldCoordinatesToCanvasCoordinates() {
        FieldCoordinate fieldCoordinate = new FieldCoordinate(coordinateMapper, 700f, 300f);
        CanvasCoordinate canvasCoordinate = coordinateMapper.toCanvasCoordinate(fieldCoordinate);
        assertThat(canvasCoordinate.x, is(350f));
        assertThat(canvasCoordinate.y, is(150f));
    }

    @Test
    public void actsAsCoordinateFactoryForFieldCoordinate() {
        FieldCoordinate fieldCoordinate = coordinateMapper.newFieldCoordinate(1,2);
        assertThat(fieldCoordinate.x, is(1f));
        assertThat(fieldCoordinate.y, is(2f));
        assertThat(fieldCoordinate.getCoordinateMapper(), is(coordinateMapper));
    }

    @Test
    public void actsAsCoordinateFactoryForCanvasCoordinate() {
        CanvasCoordinate canvasCoordinate = coordinateMapper.newCanvasCoordinate(3,4);
        assertThat(canvasCoordinate.x, is(3f));
        assertThat(canvasCoordinate.y, is(4f));
        assertThat(canvasCoordinate.getCoordinateMapper(), is(coordinateMapper));
    }

    @Test
    public void generatesFieldCoordinateFromCanvasCoordinateValues() {
        FieldCoordinate fieldCoordinate = coordinateMapper.fieldCoordinateFromCanvasCoordinates(150f, 250f);
        assertThat(fieldCoordinate.x, is(300f));
        assertThat(fieldCoordinate.y, is(500f));
    }

    @Test void returnsMouseCoordinatesAsCanvasCoordinates() {
        throw new RuntimeException("TODO: Import Mockito using Ant and then use it to mock out the" +
                "canvas.GetMousePosition method");
        when(coordinateMapper.canvas.getMousePosition()).thenReturn(new Point(123, 124));
        CanvasCoordinate mouseCoordinates = coordinateMapper.mouseCoordinates();
        assertThat(mouseCoordinates.x, is(123f));
        assertThat(mouseCoordinates.y, is(124f));
    }

}