import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        long startTime = System.nanoTime();


        final char[][] maze = new char[][] {
                {'E', 'W', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' '},
        };

        final Escape escape = new EscapeImpl();
        final List<Pair<Integer, Integer>> result = escape.escape(maze);
        for (Pair<Integer, Integer> pair : result) {
            System.out.println(
                "(" + pair.first + ", " + pair.second + ")"
            );
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
