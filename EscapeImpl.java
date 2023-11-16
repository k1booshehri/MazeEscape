import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class EscapeImpl implements Escape {
    boolean reached = false;

    /**
     * Find a path from the entrance to the exit in a maze.
     *
     * @param maze is a 2D array of characters showing the maze elements
     * @return A list of coordinates, from the exit point to the entrance point. The first item of the list is the coordinate of exit point while the last item is the coordinate of the entrance point.
     */
    @Override
    public List<Pair<Integer, Integer>> escape(final char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'E') {
                    // found the entrance
                    boolean reached = false;
                    boolean[][] visited = new boolean[maze.length][maze[0].length];
                    List<Pair<Integer, Integer>> draft = myPerfectRecursionMethod(new Pair<>(i, j), maze, reached, visited);
                    Collections.reverse(draft);
                    if (draft.size() == 1 && draft.get(0).second == j && draft.get(0).first == i) {
                        draft = new ArrayList<>();
                    }
                    return (draft);
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Pair<Integer, Integer>> myPerfectRecursionMethod(Pair<Integer, Integer> p, char[][] maze, boolean reach, boolean[][] visited) {
        final List<Pair<Integer, Integer>> result = new ArrayList<>();
        if (p.first >= maze.length || p.second >= maze[0].length || p.first == -1 || p.second == -1 || reach) {
            return result;
        }
        if (maze[p.first][p.second] == 'X') {
            result.add(new Pair<>(p.first, p.second));
            reached = true;
            return result;
        }
        if (maze[p.first][p.second] == 'W' || visited[p.first][p.second] == true) {
            return result;
        }
        if (maze[p.first][p.second] == ' ' || maze[p.first][p.second] == 'E') {
            result.add(new Pair<>(p.first, p.second));
            visited[p.first][p.second] = true;
            List<Pair<Integer, Integer>> tempList = myPerfectRecursionMethod(new Pair<>(p.first + 1, p.second), maze, reached, visited);
            if (reached) {
                result.addAll(tempList);
            }
            tempList = myPerfectRecursionMethod(new Pair<>(p.first, p.second + 1), maze, reached, visited);
            if (reached) {
                result.addAll(tempList);
            }
            tempList = myPerfectRecursionMethod(new Pair<>(p.first - 1, p.second), maze, reached, visited);
            if (reached) {
                result.addAll(tempList);
            }
            tempList = myPerfectRecursionMethod(new Pair<>(p.first, p.second - 1), maze, reached, visited);
            if (reached) {
                result.addAll(tempList);
            }
        }
        return result;
    }
}