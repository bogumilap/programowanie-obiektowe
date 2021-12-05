package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] strings) {
        int counter = 0;

        for (String string : strings) {
            if (string.equals("b") || string.equals("backward") || string.equals("f") || string.equals("forward") ||
            string.equals("r") || string.equals("right") || string.equals("l") || string.equals("left")) {
                counter++;
            }
        }

        MoveDirection[] parsed = new MoveDirection[counter];

        int index = 0;
        for (String string : strings) {
            switch (string) {
                case "f", "forward" -> {
                    parsed[index] = MoveDirection.FORWARD;
                    index++;
                }
                case "b", "backward" -> {
                    parsed[index] = MoveDirection.BACKWARD;
                    index++;
                }
                case "r", "right" -> {
                    parsed[index] = MoveDirection.RIGHT;
                    index++;
                }
                case "l", "left" -> {
                    parsed[index] = MoveDirection.LEFT;
                    index++;
                }
                default -> throw new IllegalArgumentException(string + " is not legal move specification");
            }
        }

        return parsed;
    }
}
