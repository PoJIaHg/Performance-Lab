public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CircularArrayTraversal <n> <m>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        if (n <= 0 || m <= 0) {
            System.out.println("Invalid input: n and m must be positive integers.");
            return;
        }

        StringBuilder path = new StringBuilder();
        int currentIndex = 0;

        for (int i = 0; i < n; i++) {
            path.append(currentIndex + 1);
            currentIndex = (currentIndex + m - 1) % n;
        }

        System.out.println("Path: " + path.toString());
    }
}