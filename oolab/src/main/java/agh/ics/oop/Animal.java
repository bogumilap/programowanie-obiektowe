package agh.ics.oop;

public class Animal {
    private MapDirection orientaion = MapDirection.NORTH;
    private Vector2d location; // = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal() {
        location = new Vector2d(2, 2);
        map = new RectangularMap(5, 5);
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.location = initialPosition;
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

                Vector2d new_location = location.add(step);
                if (map.canMoveTo(new_location)) {
                    location = new_location;
                }
            }
        }
    }

    public MapDirection getOrientaion() {
        return orientaion;
    }

    public Vector2d getLocation() {
        return location;
    }
}
