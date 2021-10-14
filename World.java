package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("Start");

        Direction[] dirs = new Direction[args.length];
        transform(args, dirs);

        run(dirs);

        System.out.println("Stop");
    }


    public static void transform(String[] args, Direction[] dirs){
        for (int i=0; i<args.length; i++){
            switch (args[i]) {
                case "l" -> dirs[i] = Direction.l;
                case "r" -> dirs[i] = Direction.r;
                case "f" -> dirs[i] = Direction.f;
                case "b" -> dirs[i] = Direction.b;
            }
        }
    }


    public static void run(Direction[] dirs){
        System.out.println("zwierzak idzie do przodu");

        for (int i=0; i<dirs.length; i++){
            Direction dir = dirs[i];
            switch (dir) {
                case f -> System.out.print("Zwierzak idzie do przodu");
                case b -> System.out.print("Zwierzak idzie do tyłu");
                case r -> System.out.print("Zwierzak skręca w prawo");
                case l -> System.out.print("Zwierzak skręca w lewo");
            }
            if (i < dirs.length-1) System.out.println(", ");
            else System.out.println();
        }
    }
}
