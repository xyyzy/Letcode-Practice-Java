package 贪心._45_跳跃游戏II_hard;

public class Solution {
    /*
    * 贪心
    * */
    public static int jump(int[] nums) {
        //边界
        int end = 0;
        //在每次可跳跃的距离中选择最远的
        int distanceMost = 0;
        int  steps = 0;
        /*
        这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。
        因为开始的时候边界是第 00个位置，steps 已经加 1 了。
        如果最后一步刚好跳到了末尾，此时 steps 其实不用加 1 了。如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 1
        * */
        for (int i = 0; i < nums.length-1; i++) {
            distanceMost = Math.max(distanceMost,i+nums[i]);
            if (i==end){
                end = distanceMost;
                steps++;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        int b = jump(arr);
        System.out.println(b);
    }
}
