import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String INPUT = "Game 1: 20 green, 3 red, 2 blue; 9 red, 16 blue, 18 green; 6 blue, 19 red, 10 green; 12 red, 19 green, 11 blue\n" +
            "Game 2: 12 green, 3 blue, 16 red; 6 red, 4 blue, 12 green; 11 green, 4 red, 3 blue; 8 green, 15 red, 5 blue\n" +
            "Game 3: 13 blue, 4 red, 8 green; 2 green, 4 red, 19 blue; 5 blue; 10 blue, 6 green, 2 red; 19 blue; 8 blue, 6 red\n" +
            "Game 4: 14 green, 8 blue, 10 red; 11 green, 7 blue, 8 red; 8 green, 18 blue, 11 red\n" +
            "Game 5: 7 red, 7 green, 1 blue; 2 red, 1 green, 2 blue; 2 blue, 7 green; 7 red, 3 blue, 11 green\n" +
            "Game 6: 3 green, 1 red, 3 blue; 5 green, 19 red, 8 blue; 7 red, 2 green, 10 blue; 1 blue, 1 green, 12 red; 6 blue, 1 green, 16 red\n" +
            "Game 7: 1 blue; 2 blue, 11 red, 3 green; 1 blue, 7 red; 2 green, 2 red; 3 green, 4 red, 1 blue; 3 blue, 3 green, 9 red\n" +
            "Game 8: 4 red, 6 green, 4 blue; 4 red, 1 green; 9 blue, 1 green, 11 red\n" +
            "Game 9: 3 blue, 17 red, 5 green; 8 blue, 9 green, 1 red; 6 green, 2 blue, 2 red\n" +
            "Game 10: 3 green, 8 blue; 2 green, 2 red, 3 blue; 1 green, 2 red, 1 blue; 1 red, 3 green, 9 blue; 11 blue; 7 blue\n" +
            "Game 11: 3 red, 3 blue, 9 green; 3 green, 4 red, 8 blue; 1 red, 12 blue; 2 red, 5 blue, 7 green; 11 blue, 2 red, 6 green\n" +
            "Game 12: 15 green, 3 blue, 1 red; 10 green, 2 blue, 2 red; 2 blue, 15 green; 1 red, 10 green, 2 blue; 16 green, 2 red\n" +
            "Game 13: 2 green, 3 blue, 5 red; 9 green, 5 blue, 1 red; 10 blue, 4 red\n" +
            "Game 14: 1 red, 3 green, 20 blue; 8 red, 5 green, 1 blue; 12 blue, 1 green, 2 red; 8 red, 2 green, 2 blue\n" +
            "Game 15: 14 blue, 3 green, 8 red; 16 red, 10 blue; 2 green, 10 blue, 9 red; 12 red, 3 blue, 2 green; 4 green, 6 red, 4 blue\n" +
            "Game 16: 9 green, 7 red, 5 blue; 15 green, 4 red; 3 green, 6 red\n" +
            "Game 17: 1 green, 7 red, 10 blue; 8 blue, 2 red, 1 green; 7 red, 1 green, 9 blue; 1 red\n" +
            "Game 18: 2 blue, 1 green, 1 red; 9 red, 4 green, 2 blue; 3 green, 10 red, 1 blue\n" +
            "Game 19: 1 blue, 5 green, 13 red; 8 green, 15 red, 1 blue; 4 green, 6 red, 1 blue; 2 blue, 3 green; 8 red, 2 blue, 9 green\n" +
            "Game 20: 1 green, 1 blue, 1 red; 7 blue, 2 red; 3 red, 3 blue, 1 green; 2 blue, 2 red\n" +
            "Game 21: 1 blue, 2 red, 13 green; 13 green, 5 blue, 7 red; 4 green, 13 red, 2 blue\n" +
            "Game 22: 7 green, 16 red, 6 blue; 1 red, 5 blue, 10 green; 5 blue, 4 green, 14 red; 6 green, 6 blue; 6 blue, 4 green, 2 red\n" +
            "Game 23: 2 blue, 3 green, 1 red; 2 blue; 3 red, 4 green\n" +
            "Game 24: 10 red, 6 green, 12 blue; 1 red, 13 blue, 1 green; 7 blue, 9 green, 1 red; 7 red, 7 green, 5 blue\n" +
            "Game 25: 13 green, 15 blue, 10 red; 14 green, 6 blue, 1 red; 14 green, 5 red, 15 blue; 7 green, 6 red, 14 blue; 6 red, 2 blue, 17 green; 13 blue, 4 red, 4 green\n" +
            "Game 26: 16 green, 12 blue; 10 blue, 17 green, 3 red; 12 blue, 12 green; 8 blue, 5 green; 1 red, 10 blue, 2 green\n" +
            "Game 27: 12 blue, 4 red; 12 blue, 2 green, 1 red; 16 blue, 4 red, 1 green; 11 blue, 3 red; 1 green, 3 red, 1 blue\n" +
            "Game 28: 16 green, 2 blue, 14 red; 7 blue, 9 red, 8 green; 6 blue, 12 green, 19 red; 9 blue, 10 red, 15 green; 19 red, 7 blue, 10 green; 5 green, 6 red, 3 blue\n" +
            "Game 29: 1 red, 2 green; 11 blue, 5 green, 4 red; 6 red, 6 green, 12 blue; 14 blue, 5 red, 4 green; 5 green, 8 red, 6 blue; 8 blue, 4 red, 4 green\n" +
            "Game 30: 15 red, 2 blue, 6 green; 4 red, 3 green, 2 blue; 9 blue, 3 green, 16 red; 1 green, 11 blue, 13 red\n" +
            "Game 31: 2 blue, 4 green, 3 red; 3 red, 3 blue, 4 green; 1 red, 6 blue; 3 red, 6 blue, 2 green; 3 green, 1 red, 6 blue; 7 green, 1 blue, 2 red\n" +
            "Game 32: 8 green; 3 blue, 14 green; 8 green, 5 blue, 5 red; 6 green, 9 red, 4 blue\n" +
            "Game 33: 6 red, 10 green; 8 green; 2 blue, 13 green; 3 red, 2 blue, 1 green; 2 red, 3 green; 2 red, 12 green, 1 blue\n" +
            "Game 34: 1 blue, 12 red, 1 green; 2 blue, 7 red; 9 blue, 1 red, 1 green\n" +
            "Game 35: 1 blue, 2 green; 3 red, 1 blue; 2 red; 2 green, 5 red; 1 red, 1 green\n" +
            "Game 36: 12 green, 3 blue, 6 red; 15 green, 10 blue, 3 red; 5 red, 9 green, 14 blue\n" +
            "Game 37: 2 red, 13 green, 6 blue; 2 green; 17 green, 9 blue, 4 red; 7 blue, 1 red, 2 green\n" +
            "Game 38: 9 red, 12 blue; 11 blue, 2 red; 5 red; 10 red, 2 blue; 2 blue, 1 green, 13 red\n" +
            "Game 39: 11 green, 8 red, 17 blue; 3 red, 3 green, 7 blue; 12 blue, 13 red, 11 green; 17 blue, 11 green, 9 red; 8 blue, 12 green, 2 red\n" +
            "Game 40: 4 green, 2 red; 5 green, 1 blue, 12 red; 11 red, 2 green; 6 red, 1 green\n" +
            "Game 41: 13 green, 4 red, 1 blue; 9 green, 1 blue, 3 red; 20 red; 3 green, 19 red, 1 blue\n" +
            "Game 42: 3 green, 1 red, 6 blue; 6 green, 7 blue; 1 red, 11 green, 6 blue; 5 green, 9 blue, 7 red\n" +
            "Game 43: 2 blue, 9 green, 9 red; 8 red, 2 green, 10 blue; 15 green, 6 blue; 6 red, 2 blue, 2 green; 2 green, 2 blue, 13 red; 7 green, 6 blue, 6 red\n" +
            "Game 44: 6 blue, 3 green, 3 red; 4 red, 3 blue; 3 red, 4 green\n" +
            "Game 45: 2 red, 19 blue; 3 red, 19 blue, 17 green; 12 red, 8 green, 19 blue; 14 green, 11 red, 1 blue; 10 red, 8 green, 1 blue; 6 red, 1 blue, 19 green\n" +
            "Game 46: 4 red; 8 blue, 3 green; 3 red, 3 green, 1 blue; 4 blue, 2 green, 5 red\n" +
            "Game 47: 5 blue, 9 red, 2 green; 5 blue, 7 green, 6 red; 13 green, 5 blue, 10 red\n" +
            "Game 48: 8 green, 12 blue, 1 red; 8 green, 9 blue, 2 red; 8 blue, 12 green, 3 red; 5 green, 13 blue, 2 red\n" +
            "Game 49: 4 red, 18 blue; 4 blue, 3 red, 2 green; 7 red, 2 green, 10 blue; 1 green, 5 red, 5 blue; 6 blue, 4 red\n" +
            "Game 50: 13 green, 1 blue, 6 red; 1 blue, 1 red, 13 green; 15 green, 2 red; 1 blue, 1 green, 2 red; 5 green, 1 blue, 1 red; 13 green\n" +
            "Game 51: 1 green, 6 red; 1 green, 3 blue, 6 red; 7 red, 3 blue; 3 blue, 9 red; 2 blue, 2 red\n" +
            "Game 52: 2 red, 12 green, 9 blue; 8 green, 2 red, 11 blue; 13 blue, 2 red, 10 green; 5 blue, 2 green\n" +
            "Game 53: 18 red, 13 blue, 3 green; 10 blue, 6 green, 15 red; 7 red, 1 green, 4 blue; 6 blue, 16 red, 10 green\n" +
            "Game 54: 4 blue, 5 green; 4 green, 4 blue, 2 red; 2 red; 4 green, 1 red\n" +
            "Game 55: 7 green, 1 red, 4 blue; 2 green, 7 red, 2 blue; 4 blue, 4 red, 2 green; 3 blue; 5 blue, 6 red, 12 green; 13 green\n" +
            "Game 56: 10 red, 1 green, 6 blue; 1 blue, 4 green; 4 green, 6 blue, 10 red; 7 green, 4 blue; 10 blue, 7 red, 8 green; 7 blue, 1 green\n" +
            "Game 57: 8 blue, 2 red, 7 green; 8 blue, 1 red, 11 green; 7 blue, 1 green, 7 red; 7 red, 14 green, 5 blue; 7 red, 4 green, 8 blue\n" +
            "Game 58: 17 green, 1 red; 7 blue, 2 red, 18 green; 4 red, 15 green, 18 blue\n" +
            "Game 59: 12 green, 6 blue; 10 green, 8 blue, 2 red; 1 red, 11 green, 1 blue; 4 green, 6 blue, 2 red; 5 blue, 1 green, 2 red\n" +
            "Game 60: 4 green, 2 red; 2 blue, 6 green, 5 red; 1 red, 3 green, 1 blue; 6 blue, 3 green\n" +
            "Game 61: 1 red, 1 blue; 5 red, 11 blue, 1 green; 1 red, 13 blue, 1 green\n" +
            "Game 62: 12 green, 5 blue; 1 blue, 5 red, 18 green; 9 green, 2 red, 10 blue; 11 blue, 7 green; 10 green, 4 red, 3 blue\n" +
            "Game 63: 15 red, 1 blue, 10 green; 2 green, 11 blue, 1 red; 4 blue, 2 green, 9 red\n" +
            "Game 64: 11 red, 2 blue; 1 blue, 14 red; 2 green, 2 blue, 12 red; 3 red; 13 red, 1 blue; 1 green, 12 red\n" +
            "Game 65: 10 blue, 1 red; 12 blue, 1 green; 1 green, 3 blue, 1 red\n" +
            "Game 66: 5 green, 14 blue; 6 green, 9 blue, 1 red; 6 green, 2 blue; 5 green\n" +
            "Game 67: 2 blue, 1 red; 3 blue, 1 red; 5 blue, 2 red; 2 red, 7 blue, 2 green; 1 green, 2 blue, 2 red\n" +
            "Game 68: 2 blue, 13 green; 5 green, 1 red; 2 blue, 9 green, 1 red; 18 green, 1 red\n" +
            "Game 69: 15 green, 8 red, 8 blue; 5 red, 11 green, 2 blue; 9 red, 6 blue, 11 green; 6 green, 4 red, 5 blue\n" +
            "Game 70: 4 blue, 2 red; 1 red, 1 green, 1 blue; 5 blue, 1 green, 2 red; 1 blue; 1 red, 1 green; 3 blue\n" +
            "Game 71: 5 red, 2 blue; 1 blue, 4 green; 10 green, 5 red, 2 blue; 2 blue, 6 green, 4 red\n" +
            "Game 72: 9 blue, 1 green; 1 red, 5 blue; 7 blue, 1 red, 11 green; 3 green, 1 red, 11 blue\n" +
            "Game 73: 1 green, 1 red, 10 blue; 12 blue; 2 red, 9 blue\n" +
            "Game 74: 5 blue; 4 blue, 2 red, 8 green; 1 red, 4 blue, 1 green\n" +
            "Game 75: 9 green, 9 blue, 10 red; 8 blue, 17 green, 1 red; 3 blue, 2 red, 4 green; 10 blue, 8 green, 7 red; 7 blue, 10 red, 5 green\n" +
            "Game 76: 11 green, 12 blue, 8 red; 11 red, 11 green, 8 blue; 6 red, 9 blue, 14 green; 14 blue, 12 red, 9 green\n" +
            "Game 77: 1 red, 3 blue, 2 green; 4 green, 5 blue; 1 blue, 1 red; 3 green, 4 blue, 1 red; 5 green, 1 red, 3 blue; 1 red, 2 green\n" +
            "Game 78: 10 blue, 4 green, 12 red; 6 green, 10 red, 10 blue; 14 blue, 3 green, 8 red; 5 red, 6 green; 4 green; 20 blue, 5 red, 5 green\n" +
            "Game 79: 13 green; 15 green, 9 blue, 6 red; 5 red, 10 green, 6 blue; 13 green, 6 red, 4 blue\n" +
            "Game 80: 1 red, 9 blue; 1 green, 10 blue, 3 red; 9 blue, 1 green, 1 red\n" +
            "Game 81: 2 blue, 1 red; 2 blue, 5 green; 2 red, 7 green, 2 blue; 3 blue; 2 green, 2 red; 7 green, 2 blue, 1 red\n" +
            "Game 82: 7 red, 12 blue, 4 green; 9 red, 11 green, 8 blue; 10 blue, 8 red, 9 green; 6 red, 2 blue, 7 green; 12 red, 8 green, 9 blue\n" +
            "Game 83: 14 blue; 10 blue, 3 red, 4 green; 7 blue, 10 green, 2 red; 3 red, 4 blue, 12 green\n" +
            "Game 84: 12 red, 13 blue, 2 green; 11 red, 3 green, 15 blue; 15 red, 4 green, 5 blue; 1 red, 3 green, 11 blue; 3 green, 4 red, 3 blue\n" +
            "Game 85: 8 blue, 1 green, 1 red; 1 red, 8 blue, 4 green; 3 red, 13 blue, 8 green\n" +
            "Game 86: 9 blue, 4 green, 4 red; 4 red, 2 blue, 4 green; 10 red, 2 green; 7 blue, 4 green, 12 red\n" +
            "Game 87: 1 blue, 9 green, 10 red; 1 red, 11 blue, 2 green; 17 blue, 3 red\n" +
            "Game 88: 12 red, 6 green, 9 blue; 18 blue, 17 red, 7 green; 16 red, 6 green; 6 green, 5 red, 12 blue\n" +
            "Game 89: 12 green, 10 blue, 2 red; 4 blue, 15 green, 1 red; 7 green, 11 blue; 12 green, 7 blue, 2 red; 14 blue, 12 green, 2 red\n" +
            "Game 90: 14 blue, 1 red, 3 green; 3 green, 2 blue, 3 red; 1 red, 16 blue; 1 green, 10 blue\n" +
            "Game 91: 11 red, 5 green; 5 red, 5 green, 1 blue; 8 red, 1 blue, 4 green; 1 blue, 3 green, 8 red\n" +
            "Game 92: 19 green, 2 red, 10 blue; 9 blue, 11 green, 4 red; 10 blue, 5 green, 2 red; 3 red, 5 blue, 7 green\n" +
            "Game 93: 1 green, 7 blue, 5 red; 9 green, 6 red, 13 blue; 11 blue, 12 red, 7 green; 1 red, 12 blue, 7 green\n" +
            "Game 94: 4 red, 9 green, 1 blue; 11 green, 11 blue, 4 red; 10 red, 17 blue, 11 green; 5 blue, 12 red, 2 green; 14 blue, 6 green, 5 red; 8 green, 19 blue, 13 red\n" +
            "Game 95: 5 green, 1 blue, 7 red; 3 blue, 14 red, 17 green; 3 blue, 7 red, 9 green; 17 red, 6 green, 1 blue; 17 red, 4 green\n" +
            "Game 96: 3 red, 10 green; 9 green, 11 red; 2 red, 6 green, 2 blue; 1 blue, 9 red, 1 green; 12 red, 1 blue; 4 green, 12 red\n" +
            "Game 97: 3 green, 11 red, 1 blue; 3 green, 13 red, 4 blue; 1 green, 3 blue, 12 red; 4 green, 10 red; 4 blue, 10 green, 12 red\n" +
            "Game 98: 6 blue, 12 red; 17 red, 1 green, 11 blue; 13 blue, 9 red; 9 red, 6 blue, 2 green\n" +
            "Game 99: 15 green, 1 blue, 11 red; 12 green, 12 blue, 14 red; 12 green, 10 blue, 1 red\n" +
            "Game 100: 1 green, 11 red, 4 blue; 4 green, 1 red; 9 red, 2 blue; 5 blue, 11 red, 9 green";

    public static void main(String[] args) {
        //12 red, 13 green, 14 blue

        String[] games = INPUT.split("\n");
        int idSum = Arrays.stream(games)
                .filter(g -> isPossible(g.split(": ")[1]))
                .map(g -> g.split(" ")[1].split(":")[0]) // get game id
                .map(Integer::parseInt)
                .reduce(Integer::sum).orElse(0);

        System.out.println(idSum);
    }

    private static boolean isPossible(String game) {
        List<String> pairs = new ArrayList<>();
        String[] singleGames = game.split("; ");
        Arrays.stream(singleGames)
                .forEach(sg -> {
                    String[] split = sg.split(", ");
                    pairs.addAll(Arrays.stream(split).toList());
                });

        AtomicBoolean ret = new AtomicBoolean(true);
        pairs.stream().forEach(p -> {
            String[] split = p.split(" ");
            int key = Integer.parseInt(split[0]);
            if(!validPair(key, split[1])) {
                ret.set(false);
            }
        });
        return ret.get();
    }

    private static boolean validPair(int count, String color) {
        switch(color) {
            case "red": if(count > 12) return false;
            case "green": if(count > 13) return false;
            case "blue": if(count > 14) return false;
        }
        return true;
    }


}