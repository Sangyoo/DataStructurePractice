import java.util.*;

public class Solution {
    // 재귀를 사용한 풀이
    public static void main(String[] args) {
        boolean result = Solution.getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result);
    }
    public static boolean getDirections(int[][] matrix, int from, int to) {
     Queue<Integer> queue = new LinkedList<>();
     //첫 시작점으로 from을 할당합니다.
     queue.add(from);

     // 방문했다는 것을 표시하기 위해 1차원 배열을 생성합니다. 초기값은 false로 생성됩니다.
     boolean[] isVisited = new boolean[matrix.length];
     // 첫 정점 방문 여부를 표시합니다.
     isVisited[from] = true;

     // queue(방문할 곳)의 사이즈가 0이 될 때까지 반복합니다.
     while(queue.size() > 0) {

       // queue에서 정점을 하나 빼서 now에 할당합니다.
       int now = queue.poll();

       // 목적지인지 검사하고, 목적지라면 true를 반환합니다.
       if(now == to) return true;

       // 해당 정점의 간선들을 확인합니다.
       for(int next = 0; next < matrix[now].length; next++) {
         // 만약, 간선이 있고 방문하지 않았다면
         if(matrix[now][next] == 1 && !isVisited[next]) {
           // queue에 next를 넣습니다. (다음 정점으로 가기 위해)
           queue.add(next);
           // 해당 정점을 방문했다는 것을 표시합니다.
           isVisited[next] = true;
         }
       }
     }
     // 길이 없다면 false를 반환합니다.
     return false;
    }
}