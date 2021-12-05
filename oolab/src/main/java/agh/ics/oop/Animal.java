package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal {
    private MapDirection orientaion = MapDirection.NORTH;
    private Vector2d position; // = new Vector2d(2, 2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal() {
        position = new Vector2d(2, 2);
        map = new RectangularMap(5, 5);
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString(){
        return switch (orientaion) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientaion = orientaion.next();
            case LEFT -> orientaion  = orientaion.previous();
            case FORWARD, BACKWARD -> {
                Vector2d step = orientaion.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    step = step.opposite();
                }

                Vector2d new_location = position.add(step);
                if (map.canMoveTo(new_location)) {
                    positionChanged(position, new_location);
                    position = new_location;
                }
            }
        }
    }

    void addObserver(IPositionChangeObserver observer)  {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d old_position, Vector2d new_position) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(old_position, new_position);
        }
    }

    public MapDirection getOrientaion() {
        return orientaion;
    }

    public Vector2d getPosition() {
        return position;
    }
}
