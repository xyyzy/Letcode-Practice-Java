package 面试.东方财富1;

import java.util.*;

public class A {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param blocks     int整型一维数组 每个州的选票数
     * @param blockIndex int整型 关键州下标
     * @return int整型
     */
    int all = 0;
    int key = 0;
    int res = 0;
    int len=0;
    public int CountCriticalVotes(int[] blocks, int blockIndex) {
        if(blocks==null||blocks.length==0)
            return 0;
        // write code here
        for (int block : blocks) {
            all += block;
        }

        key = blocks[blockIndex];
        blocks[blockIndex] = 0;
        len = blocks.length;

        Arrays.sort(blocks);
        dfs(blocks, 1, 0);
        return res;
    }

    private void dfs(int[] blocks, int begin, int sum) {
        if (begin == len) {
            if (key >= Math.abs(2 * sum - all + key)) {
                res++;
            }
            return;
        }
        //投给A
        dfs(blocks, begin + 1, sum + blocks[begin]);
        //不投给A
        dfs(blocks, begin + 1, sum);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,7,4};
        A a = new A();
        int i = a.CountCriticalVotes(arr, 2);
        System.out.println(i);
    }
}
