package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    void testParse(){
        String[] string_directions = new String[] {"b", "forward", "f", "stop", "f", "forward", "right", "backward"};
        Animal testAnimal = new Animal();
        OptionsParser parser = new OptionsParser();

        MoveDirection[] directions = parser.parse(string_directions);

        for (MoveDirection dir : directions) {
            testAnimal.move(dir);
        }

        MapDirection orientation = testAnimal.getOrientaion();
        Vector2d location = testAnimal.getPosition();

        Vector2d proper_location = new Vector2d(1, 4);

        Assertions.assertEquals(MapDirection.EAST, orientation);
        Assertions.assertEquals(proper_location, location);


        MoveDirection[] proper_directions = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT,
                MoveDirection.BACKWARD};

        Assertions.assertEquals(proper_directions.length, directions.length);
        for (int i=0; i<proper_directions.length; i++) {
            Assertions.assertEquals(proper_directions[i], directions[i]);
        }
    }
}
