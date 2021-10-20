package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    void testNext(){
        MapDirection result = MapDirection.NORTH.next();
        Assertions.assertEquals(MapDirection.EAST, result);

        result = MapDirection.EAST.next();
        Assertions.assertEquals(MapDirection.SOUTH, result);

        result = MapDirection.SOUTH.next();
        Assertions.assertEquals(MapDirection.WEST, result);

        result = MapDirection.WEST.next();
        Assertions.assertEquals(MapDirection.NORTH, result);
    }

    @Test
    void testPrevious(){
        MapDirection result = MapDirection.SOUTH.previous();
        Assertions.assertEquals(MapDirection.EAST, result);

        result = MapDirection.WEST.previous();
        Assertions.assertEquals(MapDirection.SOUTH, result);

        result = MapDirection.NORTH.previous();
        Assertions.assertEquals(MapDirection.WEST, result);

        result = MapDirection.EAST.previous();
        Assertions.assertEquals(MapDirection.NORTH, result);
    }
}
