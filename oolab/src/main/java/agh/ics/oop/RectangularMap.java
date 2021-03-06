package agh.ics.oop;

import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height) {
        this.start = new Vector2d(0,0);
        this.end = new Vector2d(width-1, height-1);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return map_animals.get(position);
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }
}
