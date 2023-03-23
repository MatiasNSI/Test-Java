import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
// Complete la siguiente funcion climbingLeaderboard.
static int[] climbingLeaderboard(int[] scores, int[] alice) {
    //Convierto el array en un Hashset para eliminar repetidos
    Set<Integer> newScores = Arrays.stream(scores)
            .boxed()
            .collect(Collectors.toSet());
    //Transformo el Hashset en un List para ordenarlo
    List<Integer> finalScores = new ArrayList<>(newScores);
    Collections.sort(finalScores);
    int[] aliceResults = new int[alice.length];
    //por cada puntaje de alice verifico que posicion le corresponde en la tabla de resultados
    for(int i = 0; i <= alice.length -1; i++){
        int count = 1;
        for (int j  = finalScores.size()-1; j >=0; j--) {
            if (alice[i] < finalScores.get(j)) {
                count++;
            }
            aliceResults[i] = count;
        }
    }
    return aliceResults;
}

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] scores = new int[scoresCount];
        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }
        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] alice = new int[aliceCount];
        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}