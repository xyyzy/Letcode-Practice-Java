package 面试.东方财富;

import java.util.Arrays;

public class B {
    public float calAverageScore(float[] scores) {
        // write code here
        Arrays.sort(scores);
        scores[0] = 0;
        scores[scores.length - 1] = 0;
        float sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum/(scores.length-2);
    }

    public static void main(String[] args) {

    }
}
