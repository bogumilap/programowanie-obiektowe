package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Vector2d start;
    protected Vector2d end;
    protected final MapVisualiser visualiser = new MapVisualiser(this);
    protected Map<Vector2d, Animal> map_animals = new HashMap<>();
    protected List<Animal> animals = new ArrayList<>();

    private boolean isInsideMap(Vector2d position) {
        return (position.follows(start) && position.precedes(end));
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
            map_animals.put(location, animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position) != null);
    }


    @Override
    public String toString() {
        return visualiser.draw(start, end);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = map_animals.get(oldPosition);
        map_animals.remove(oldPosition, animal);
        map_animals.put(newPosition, animal);
    }
}
