package agh.ics.oop;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MapBoundary implements IPositionChangeObserver {
    private List<Vector2d> vectors_x = new LinkedList<>();
    private List<Vector2d> vectors_y = new LinkedList<>();
    private Vector2d min_grass = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Vector2d max_grass = new Vector2d(0, 0);

    public void addAnimalVector(Vector2d vector) {
        vectors_x.add(vector);
        Collections.sort(vectors_x, (a, b) -> Integer.compare(a.getX(), b.getX()));

        vectors_y.add(vector);
        Collections.sort(vectors_y, (a, b) -> Integer.compare(a.getY(), b.getY()));
    }

    public void addGrassVector(Vector2d vector) {
        min_grass = min_grass.lowerLeft(vector);
        max_grass = max_grass.upperRight(vector);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        vectors_x.remove(oldPosition);
        vectors_y.remove(oldPosition);
        addAnimalVector(newPosition);
    }

    public int lastIndex() {
        return (vectors_x.size() - 1);
    }

    public List<Vector2d> getVectors_x() {
        return vectors_x;
    }

    public List<Vector2d> getVectors_y() {
        return vectors_y;
    }

    public Vector2d getMin_grass() {
        return min_grass;
    }

    public Vector2d getMax_grass() {
        return max_grass;
    }
}
