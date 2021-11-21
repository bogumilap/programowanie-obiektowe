package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    void testPlaceAndCanMoveTo() {
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal1 = new Animal(map, new Vector2d(5, 5));
        map.place(animal1);

        Assertions.assertFalse(map.canMoveTo(new Vector2d(5, 5)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(5, 6)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(9, 9)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(10,10)));
    }

    @Test
    void testIsOccupied() {
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal1 = new Animal(map, new Vector2d(5, 5));
        map.place(animal1);

        Assertions.assertTrue(map.isOccupied(new Vector2d(5, 5)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(5,6)));
    }

    @Test
    void testObjectAt() {
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal1 = new Animal(map, new Vector2d(5, 5));
        map.place(animal1);

        Assertions.assertEquals(map.objectAt(new Vector2d(5, 5)), animal1);
        Assertions.assertNull(map.objectAt(new Vector2d(5, 6)));
    }
}

