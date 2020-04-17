package 贪心._55_跳跃游戏_mid;

/**
 *
 * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
 * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
 * 如果可以一直跳到最后，就成功了。
 * */
public class Solution {
    public static boolean canJump(int[] nums) {
        int distanceMost =0;
        for (int i = 0; i < nums.length; i++) {
            if (i<=distanceMost){
                //维护最远距离
                distanceMost = Math.max(distanceMost,i+nums[i]);
                if (distanceMost>= nums.length-1)
                    return true;
            }else {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        boolean b = canJump(arr);
        System.out.println(b);
    }
}
