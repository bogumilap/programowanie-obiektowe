package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private IWorldMap map;
    private final Vector2d[] positions;
    private List<Animal> animals = new LinkedList<>();

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        addToMap();
    }

    private void addToMap() {
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }

    @Override
    public void run() {
        int count = 0;
        int numOfAnimals = animals.size();
        while (count < directions.length) {
            Animal currentAnimal = animals.get(count % numOfAnimals);
            currentAnimal.move(directions[count]);
            count++;
        }
    }
}
