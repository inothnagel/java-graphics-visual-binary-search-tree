package com.inothnagel.VisualBinarySearchTree;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by inothnagel on 2016/05/26.
 */
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
        CanvasPosition canvasPosition = new CanvasPosition(200f, 150f);
        FieldPosition fieldPosition = mapper.toFieldPosition(canvasPosition);
        assertThat(fieldPosition.x, is(400f));
        assertThat(fieldPosition.y, is(300f));
    }

    @Test
    public void convertsFieldCoordinatesToCanvasCoordinates() {
        FieldPosition fieldPosition = new FieldPosition(700f, 300f);
        CanvasPosition canvasPosition = mapper.toCanvasPosition(fieldPosition);
        assertThat(canvasPosition.x, is(350f));
        assertThat(canvasPosition.y, is(150f));
    }
}