package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimulationEngineTest {
    @Test
    void testRun() {
        String strings[] = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(strings);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        // (2, 2)N
        // f        r        f        r        f        f        f        f
        // (2, 3)N  (2, 3)E  (2, 3)E  (2, 3)S  (2, 2)S  (2, 1)S  (2, 0)S  (2, 0)S

        // (3, 4)N
        // b        l        f        r        f        f        f        f
        // (3, 3)N  (3, 3)W  (3, 3)W  (3, 3)N  (3, 4)N  (3, 4)N  (3, 4)N  (3, 4)N

        List<Animal> animals = ((RectangularMap) map).getAnimals();
        Vector2d location1 = animals.get(0).getPosition();
        MapDirection orientation1 = animals.get(0).getOrientaion();
        Vector2d location2 = animals.get(1).getPosition();
        MapDirection orientation2 = animals.get(1).getOrientaion();

        Assertions.assertTrue(new Vector2d(2, 0).equals(location1));
        Assertions.assertTrue(new Vector2d(3, 4).equals(location2));

        Assertions.assertEquals(MapDirection.SOUTH, orientation1);
        Assertions.assertEquals(MapDirection.NORTH, orientation2);
    }
}
