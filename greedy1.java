import java.util.*;
public class greedy1 {
    public static void main(String[] args) {
        int output = greedy1.movingStuff(
//                new int[]{70, 50, 80, 50},
//                new int[]{42, 25, 60, 73, 103, 167},
                new int[]{60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182},
                200);
        System.out.println(output);
    }
    public static int movingStuff(int[] stuff, int limit) {
        // TODO:
        ArrayList<Integer> stuff2 = new ArrayList<>();
        for(int s: stuff) {
            stuff2.add(s);
        }
        int weight = 0;
        int boxNumber = 0;
        int sum = 0;
        int boxCapacity = 0;
        System.out.println(stuff2);
        //for문으로 stuff2를 돈다
        while(!stuff2.isEmpty()) {
            //가장 무게가 작은 짐의 무게를 저장
            weight = stuff2.stream().min(Integer::compare).orElse(0);
            sum += weight;
            //박스의 무게제한을 넘지 않았고, 안에 든개 1개 이하면
            if(sum <= limit && boxCapacity<=1) {
                //짐을 stuff2에서 꺼낸다(리스트에서 삭제)
                stuff2.remove((Integer) weight);
                //마지막 하나 남은 짐이라면
                boxCapacity ++;
                if(stuff2.isEmpty()) {
                    boxNumber++;
                    break;
                }
            }
            //무게제한을 넘었다면
            else {
                //짐을 꺼내지 않고 boxNumber++
                boxNumber++;
                //sum 초기화
                sum = 0;
                boxCapacity=0;
            }
        }
        return boxNumber;
    }
}
