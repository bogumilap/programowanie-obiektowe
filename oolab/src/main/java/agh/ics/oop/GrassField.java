package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private Map<Vector2d, Grass> map_grass = new HashMap<>();
    private final MapVisualiser visualiser = new MapVisualiser(this);

    public GrassField(int amount_of_grass) {
        this.start = new Vector2d(0, 0);
        this.end = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        placeGrass(amount_of_grass);
    }

    public void placeGrass(int amount_of_grass) {
        int left_to_place = amount_of_grass;

        while (left_to_place > 0) {
            int x = randomPosition(amount_of_grass);
            int y = randomPosition(amount_of_grass);
            if (objectAt(new Vector2d(x, y)) == null) {
                Vector2d grass_position = new Vector2d(x, y);
                map_grass.put(grass_position, new Grass(grass_position));
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

    @Override
    public String toString() {
        int first_x = Integer.MAX_VALUE;
        int first_y = Integer.MAX_VALUE;
        int last_x = 0;
        int last_y = 0;

        for (Vector2d key : map_animals.keySet()) {
            first_x = Math.min(first_x, key.getX());
            first_y = Math.min(first_y, key.getY());
            last_x = Math.max(last_x, key.getX());
            last_y = Math.max(last_y, key.getY());
        }

        for (Vector2d key : map_grass.keySet()) {
            first_x = Math.min(first_x, key.getX());
            first_y = Math.min(first_y, key.getY());
            last_x = Math.max(last_x, key.getX());
            last_y = Math.max(last_y, key.getY());
        }

        return visualiser.draw(new Vector2d(first_x, first_y), new Vector2d(last_x, last_y));
    }
}
