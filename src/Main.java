import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char key = text.toLowerCase().charAt(i);
            if (key != ' ' && key != ',' && key != '.') {

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }

        System.out.println(map);

        int maxValue = max(map);
        int minValue = min(map);

        for (char key : map.keySet()) {
            if (map.get(key) == maxValue) {
                System.out.println("Чаще всего встречалась буква " + key + " - " + maxValue + " раза");
            }
            if (map.get(key) == minValue) {
                System.out.println("Реже всего встречалась буква " + key + " - " + minValue + " раз");
            }
        }
    }

    public static int max(Map<Character, Integer> map) {
        int max = -1;
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int min(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
