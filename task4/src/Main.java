import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MinMovesToEqualArrayElements <input_file>");
            return;
        }

        List<Integer> nums = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                nums.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        int minMoves = minMovesToEqualArrayElements(nums);
        System.out.println(minMoves);
    }

    private static int minMovesToEqualArrayElements(List<Integer> nums) {
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);

        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}