package agh.ics.oop;

abstract class AbstractWorldMap implements IWorldMap {
    protected Vector2d start;
    protected Vector2d end;
    protected final MapVisualiser visualiser = new MapVisualiser(this);
//    protected List<Animal> animals = new ArrayList<>();

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
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position) != null);
    }

    @Override
    public String toString() {
        return visualiser.draw(start, end);
    }
}
