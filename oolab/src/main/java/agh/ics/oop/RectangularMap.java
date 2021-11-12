package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private List<Animal> animals = new ArrayList<>();
    private MapVisualiser visualiser = new MapVisualiser(this);
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private boolean isInsideMap(Vector2d position) {
        return (position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width-1, height-1)));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (isInsideMap(position) && !isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d location = animal.getLocation();
        if (canMoveTo(location)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getLocation().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getLocation().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return visualiser.draw(new Vector2d(0,0), new Vector2d(width, height));
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
