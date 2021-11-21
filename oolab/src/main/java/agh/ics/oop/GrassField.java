package agh.ics.oop;

public class GrassField extends AbstractWorldMap {
    private final int amount_of_grass;
    private final Grass[] positions;
    private final MapVisualiser visualiser = new MapVisualiser(this);

    public GrassField(int amount_of_grass) {
        this.start = new Vector2d(0, 0);
        this.end = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.amount_of_grass = amount_of_grass;
        this.positions = new Grass[amount_of_grass];
        placeGrass(positions);
    }

    public void placeGrass(Grass[] positions) {
        int left_to_place = amount_of_grass;
        int min = 0;
        int max = (int) Math.sqrt(amount_of_grass*10);

        while (left_to_place > 0) {
            int x = min + (int) (Math.random() * ((max - min) + 1));
            int y = min + (int) (Math.random() * ((max - min) + 1));
            if (objectAt(new Vector2d(x, y)) == null) {
                positions[amount_of_grass-left_to_place] = new Grass(new Vector2d(x, y));
                left_to_place--;
            }
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Grass grass : positions) {
            if (grass != null && grass.getPosition().equals(position)) {
                return grass;
            }
        }

        for (Animal animal : animals) {
            if (animal.getLocation().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        int width = 0;
        int height = 0;
        for (Animal animal : animals) {
            width = Math.max(width, animal.getLocation().getX());
            height = Math.max(height, animal.getLocation().getY());
        }
        for (Grass grass : positions) {
            width = Math.max(width, grass.getPosition().getX());
            height = Math.max(height, grass.getPosition().getY());
        }
        return visualiser.draw(start, new Vector2d(width, height));
    }
}
