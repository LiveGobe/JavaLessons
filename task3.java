import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task3 {
    public static void main(String[] args) {

        // 1)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        numbers.removeIf(number -> number % 2 == 0);

        System.out.println(numbers);

        // 2)
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(9);

        int min = list.get(0);
        int max = list.get(0);
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        double avg = (double) sum / list.size();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Average: " + avg);

        // 3)
        List<String> planets = new ArrayList<>(Arrays.asList("saturn", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Earth", "Uranus", "Neptune"));
        Map<String, Integer> planetCounts = new HashMap<>();

        for (String planet : planets) {
            if (planetCounts.containsKey(planet)) {
                planetCounts.put(planet, planetCounts.get(planet) + 1);
            } else {
                planetCounts.put(planet, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : planetCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}