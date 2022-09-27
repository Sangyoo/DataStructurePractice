import java.util.*;

public class greedy2 {
    public static void main(String[] args) {
        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        int output1 = greedy2.partTimeJob(4000);
        System.out.println(output1); // --> 8

        // 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = greedy2.partTimeJob(4972);
        System.out.println(output2); // --> 18
    }
    public static int partTimeJob(int k) {
        // TODO:
        int[] change = new int[]{500,100,50,10,5,1};
        int count =0;
        int quotient = 0;
        int remainder = 0;
        for(int c : change) {
            quotient = k / c;
            remainder = k % c;
            if(k==0) break;
            if(c==1) {
                count += quotient;
                break;
            }
            //나누어떨어지는경우
            if( remainder == 0) {
                count+=quotient;
                break;
            }
            else{
                k-=quotient*c;
                count+=quotient;
            }
        }
        return count;
        //k를 500으로 나눴을때의 몫을 저장하고 1보다 크면
        // k-500*몫을 k에 저장
        // count에 몫을 더함
        //k를 100으로 나눴을 때의 몫을 저장하고 1보다 크면
        //k-100*몫이 k가 됨
        //count에 몫을 더함
        //k를 50으로 나눴을 때의 몫을 저장하고 1보다 크면
        //k-50*몫이 k가 됨
        //count에 몫을 더함
        //k를 10으로 나눴을 때의 몫을 저장하고 1보다 크면
        //k-10*몫이 k가 됨
        //count에 몫을 더함
        //k를 5으로 나눴을 때의 몫을 저장하고 1보다 크면
        //k-5*몫이 k가 됨
        //count에 몫을 더함
        //k>0 (아직 다 나눠지지 않은 경우)
        //count에 몫을 더함

    }
}
