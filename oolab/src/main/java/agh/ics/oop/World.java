package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal);

        OptionsParser parser = new OptionsParser();
        MoveDirection[] dirs = parser.parse(new String[]{"r", "f", "f", "f"});
        Animal animal1 = new Animal();
        for (MoveDirection d : dirs) {
            animal1.move(d);
        }
        System.out.println(animal1);

//        System.out.println("Start");
//        run(transform(args));
//        System.out.println("Stop");
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
