import java.time.Period;
import java.util.ArrayList;

public class thirtieighth_rank_of_alph {
    public static void main(String[] args) {
        // if aa? output: aa not [aa, aa],
        ArrayList list = new ArrayList(Permutation("aa"));
        System.out.println(list);
    }

    private static ArrayList<String> result = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        boolean[] visited = new boolean[str.length()];
        // dfs to traverse
        StringBuilder rank = new StringBuilder();
        dfs(rank, str, visited);

        // swap and recursive
        return result;
    }

    private static void dfs(StringBuilder rank, String str, boolean[] visited) {
        if (rank.length() == visited.length) {
            String finalStr = rank.toString();
            if (!result.contains(finalStr)) {
                result.add(finalStr);
            }
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                rank.append(str.charAt(i));
                dfs(rank, str, visited);
                visited[i] = false;
                rank.deleteCharAt(rank.length() - 1);
            }
        }
        return;
    }
}
