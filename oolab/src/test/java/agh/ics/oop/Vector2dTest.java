package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    void testEquals(){
        Vector2d vector = new Vector2d(2, 1);

        Assertions.assertTrue(vector.equals(vector));

        Assertions.assertTrue(vector.equals(new Vector2d(2, 1)));

        Assertions.assertFalse(vector.equals("abcd"));
    }

    @Test
    void testToString(){
        Vector2d vector = new Vector2d(2, 1);

        String result = vector.toString();

        Assertions.assertEquals("(2, 1)", result);
    }

    @Test
    void testPrecedes(){
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d vector3 = new Vector2d(2, 3);

        Assertions.assertTrue(vector1.precedes(vector1));
        Assertions.assertTrue(vector1.precedes(vector2));
        Assertions.assertTrue(vector1.precedes(vector3));

        Assertions.assertFalse(vector2.precedes(vector1));
        Assertions.assertTrue(vector2.precedes(vector3));

        Assertions.assertFalse(vector3.precedes(vector1));
        Assertions.assertFalse(vector3.precedes(vector2));
    }

    @Test
    void testFollows(){
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d vector3 = new Vector2d(2, 3);

        Assertions.assertTrue(vector1.follows(vector1));
        Assertions.assertFalse(vector1.follows(vector2));
        Assertions.assertFalse(vector1.follows(vector3));

        Assertions.assertTrue(vector2.follows(vector1));
        Assertions.assertFalse(vector2.follows(vector3));

        Assertions.assertTrue(vector3.follows(vector1));
        Assertions.assertTrue(vector3.follows(vector2));
    }

    @Test
    void testUpperRight(){
        Vector2d v1 = new Vector2d(2, 1);
        Vector2d v2 = new Vector2d(1, 2);

        Vector2d result = v1.upperRight(v2);

        Assertions.assertEquals(new Vector2d(2, 2), result);
    }

    @Test
    void testLowerLeft(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(1, 2);

        Vector2d result = vector1.lowerLeft(vector2);

        Assertions.assertEquals(new Vector2d(1, 1), result);
    }

    @Test
    void testAdd(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(1, 2);

        Vector2d result = vector1.add(vector2);

        Assertions.assertEquals(new Vector2d(3, 3), result);
    }

    @Test
    void testSubstract(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(1, 2);

        Vector2d result = vector1.subtract(vector2);

        Assertions.assertEquals(new Vector2d(1, -1), result);
    }

    @Test
    void testOpposite(){
        Vector2d vector = new Vector2d(2, -1);

        Vector2d result = vector.opposite();

        Assertions.assertEquals(new Vector2d(-2, 1), result);
    }
}
