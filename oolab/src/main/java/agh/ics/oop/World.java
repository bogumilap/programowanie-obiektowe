package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            GrassField map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map.map_boundary.getMin_grass());
            System.out.println(map.map_boundary.getMax_grass());
            System.out.println(map);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        // f b r l f f r r f f f f f f f f
    }

    public static Direction[] transform(String[] args){
        int cnt = 0;
        for (String current : args) {
            if (current.equals("l") || current.equals("r") || current.equals("b") || current.equals("f")) {
                cnt++;
            }
        }

        Direction[] dirs = new Direction[cnt];
        int ind = 0;
        for (String s : args){
            switch (s) {
                case "l" -> {
                    dirs[ind] = Direction.l;
                    ind++;
                }
                case "r" -> {
                    dirs[ind] = Direction.r;
                    ind++;
                }
                case "f" -> {
                    dirs[ind] = Direction.f;
                    ind++;
                }
                case "b" -> {
                    dirs[ind] = Direction.b;
                    ind++;
                }
            }
        }

        return dirs;
    }


    public static void run(Direction[] directions){
        System.out.println("zwierzak idzie do przodu");

        for (int i=0; i<directions.length; i++){
            Direction dir = directions[i];
            switch (dir) {
                case f -> System.out.print("Zwierzak idzie do przodu");
                case b -> System.out.print("Zwierzak idzie do tyłu");
                case r -> System.out.print("Zwierzak skręca w prawo");
                case l -> System.out.print("Zwierzak skręca w lewo");
            }
            if (i < directions.length-1) System.out.println(", ");
            else System.out.println();
        }
    }
}
