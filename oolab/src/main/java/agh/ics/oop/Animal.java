package agh.ics.oop;

public class Animal {
    private MapDirection orientaion = MapDirection.NORTH;
    private Vector2d location = new Vector2d(2, 2);

    @Override
    public String toString(){
        String str = orientaion + ", (" + location.getX() + ", " + location.getY() + ")";
        return str;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientaion = orientaion.next();
            case LEFT -> orientaion  = orientaion.previous();
            case FORWARD -> {
                Vector2d new_location = location.add(orientaion.toUnitVector());
                if (new_location.getX() < 5 && new_location.getX() >= 0
                        && new_location.getY() < 5 && new_location.getY() >= 0) {
                    location = new_location;
                }
            }
            case BACKWARD -> {
                Vector2d new_polozenie = location.subtract(orientaion.toUnitVector());
                if (new_polozenie.getX() >= 0 && new_polozenie.getX() < 5
                        && new_polozenie.getY() >= 0 && new_polozenie.getY() < 5) {
                    location = new_polozenie;
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
