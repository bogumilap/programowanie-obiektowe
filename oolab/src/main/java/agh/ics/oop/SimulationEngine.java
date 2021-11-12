package agh.ics.oop;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
    }

    private void addToMap() {
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
        }
    }

    @Override
    public void run() {
        addToMap();

        int count = 0;
        int numOfAnimals = positions.length;
        while (count < directions.length) {
            Vector2d currentAnimal = positions[count % numOfAnimals];
            if (map.objectAt(currentAnimal) instanceof Animal) {
                ((Animal) map.objectAt(currentAnimal)).move(directions[count]);
            }
            count++;
        }
    }
}
