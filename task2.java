import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class task2 {
    public static String buildWhereClause(String jsonParams) {
        Map<String, String> params = new HashMap<>();
        int start = jsonParams.indexOf('{');
        int end = jsonParams.indexOf('}');
        if (start!= -1 && end!= -1 && start < end) {
            String[] paramArray = jsonParams.substring(start + 1, end).split(",");
            for (String param : paramArray) {
                String[] keyValue = param.split(":");
                if (keyValue.length == 2) {
                    params.put(keyValue[0].replace("\"", ""), keyValue[1].replace("\"", ""));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("WHERE ");

        if (!params.get("name").equals("null")) {
            sb.append("name = '").append(params.get("name")).append("' AND ");
        }

        if (!params.get("country").equals("null")) {
            sb.append("country = '").append(params.get("country")).append("' AND ");
        }

        if (!params.get("city").equals("null")) {
            sb.append("city = '").append(params.get("city")).append("' AND ");
        }
        
        if (!params.get("age").equals("null")) {
            sb.append("age = ").append(params.get("age")).append(" AND ");
        }

        sb.setLength(sb.length() - 5);

        return sb.toString();
    }

    public static void main(String[] args) {
        // 1)
        String jsonParams = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
        String whereClause = task2.buildWhereClause(jsonParams);
        System.out.println(whereClause);

        // 2)
        int[] arr = {5, 2, 8, 3, 1, 9, 4, 6, 7};
        int n = arr.length;
        try {
            FileWriter writer = new FileWriter("log.txt");
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    writer.write("Iteration " + (i + 1) + "." + (j + 1) + ": " + Arrays.toString(arr) + "\n");
                }
            }
            writer.write("Sorted array: " + Arrays.toString(arr) + "\n");
            writer.close();
            System.out.println("Sorted array: " + Arrays.toString(arr));
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}