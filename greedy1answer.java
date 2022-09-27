import java.util.*;

public class greedy1answer {
    public static void main(String[] args) {
        int output = greedy1answer.movingStuff(
//                new int[]{70, 50, 80, 50},
//                new int[]{42, 25, 60, 73, 103, 167},
                new int[]{60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182},
                200);
        System.out.println(output);

    }
    public static int movingStuff(int[] stuff, int limit) {
        // TODO:
        Arrays.sort(stuff);
        int min = 0;
        int max = stuff.length-1;
        int twoBox = 0;
        //while문을 돌면서
        while(min<max) {
            //min+max가 한상자에 들어가면
            if(stuff[min]+stuff[max] <= limit) {
                //twoBox++
                twoBox++;
                //max-1, min+1
                max--;
                min++;
            }
            //min+max가 한상자에 안들어가면
            else {
                max--;
            }
        }
        return stuff.length-twoBox;
    }
}
