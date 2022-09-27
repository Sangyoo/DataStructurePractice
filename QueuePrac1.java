
import java.util.*;

public class QueuePrac1 {
    public static void main(String[] args) {
//        Integer[] boxes = new Integer[]{5, 1, 4, 6};
        Integer[] boxes = new Integer[]{3,2,1,   6,5,4,3,2,1,   9,8,7,6,5,4,3,2,1,    11,10,9,8,7,6,5,4,3,2,1};
        int output = QueuePrac1.paveBox(boxes);
        System.out.println(output);
    }
    public static int paveBox(Integer[] boxes) {
        // TODO:
        int count = 0;
        int comp = 0;
        Queue<Integer> q = new LinkedList<>(Arrays.asList(boxes));
        ArrayList<Integer> countArr = new ArrayList<>();
        while(q.size()!=0){
            comp = q.peek();
            while(q.size()!=0){
                if(comp>=q.peek()){
                    q.poll();
                    count++;
                }
                else {
                    break;
                }
            }
            countArr.add(count);
            count = 0;
        }
        return countArr.stream().max(Integer::compare).orElse(-1);
//        int count = 0;
//        Queue<Integer> q = new LinkedList<>(Arrays.asList(boxes));
//        Integer comp = q.peek();
//        while(q.size()!=0) {
//            if(q.peek() <= comp){
//                q.poll();
//                count++;
//            }
//            else break;
//        }
//        return count;
    }
}
