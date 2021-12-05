package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private Map<Vector2d, Grass> map_grass = new HashMap<>();
    public MapBoundary map_boundary = new MapBoundary();
    private final MapVisualiser visualiser = new MapVisualiser(this);

    public GrassField(int amount_of_grass) {
        this.start = new Vector2d(0, 0);
        this.end = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        placeGrass(amount_of_grass);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d location = animal.getPosition();
        if (canMoveTo(location)) {
            animals.add(animal);
            map_animals.put(location, animal);
            animal.addObserver(this);

            map_boundary.addAnimalVector(animal.getPosition());
            animal.addObserver(map_boundary);

            return true;
        } else {
            throw new IllegalArgumentException(location + " is not legal location");
        }
    }

    public void placeGrass(int amount_of_grass) {
        int left_to_place = amount_of_grass;

        while (left_to_place > 0) {
            int x = randomPosition(amount_of_grass);
            int y = randomPosition(amount_of_grass);
            if (objectAt(new Vector2d(x, y)) == null) {
                Vector2d grass_position = new Vector2d(x, y);
                map_grass.put(grass_position, new Grass(grass_position));
                map_boundary.addGrassVector(grass_position);
                left_to_place--;
            }
        }
    }

    private int randomPosition(int amount_of_grass) {
        int min = 0;
        int max = (int) Math.sqrt(amount_of_grass * 10);
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (map_animals.containsKey(position)) {
            return map_animals.get(position);
        }

        return map_grass.get(position);
    }

    private void setStartAndEnd() {
        start = map_boundary.getMin_grass();
        Vector2d animal_start = new Vector2d(map_boundary.getVectors_x().get(0).getX(),
                map_boundary.getVectors_y().get(0).getY());
        start = start.lowerLeft(animal_start);

        end = map_boundary.getMax_grass();
        Vector2d animal_end = new Vector2d(map_boundary.getVectors_x().get(map_boundary.lastIndex()).getX(),
                map_boundary.getVectors_y().get(map_boundary.lastIndex()).getY());
        end = end.upperRight(animal_end);
    }

    @Override
    public String toString() {
        setStartAndEnd();
        return visualiser.draw(start, end);
    }

}
