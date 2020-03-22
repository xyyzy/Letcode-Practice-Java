package 周赛._181_力扣周赛._5364_按既定顺序创建目标数组;

import java.util.Vector;

public class Solution {
    public  int[] createTargetArray(int[] nums, int[] index) {

        int[] arr= new int[nums.length];
        if (nums==null)
            return arr;
        for (int i = 0; i <index.length ; i++) {
            insertAtArray(arr,nums[i],index[i]);
        }
        return arr;
    }
    public void insertAtArray(int[] a,int n,int k) {
        //在数组中插入数据，相当于对数组的元素进行赋值，会对当前的数据进行覆盖
        for(int i=a.length-1;i>k;i--) {
            a[i]=a[i-1];
        }
        a[k]=n;
    }
    //库函数
    public static int[] createTargetArray1(int[] nums, int[] index){
        Vector<Integer> ans = new Vector<>();
        int n = nums.length,i;
        ans.clear();
        for (int j = 0; j <n ; j++) {
            ans.add(index[j],nums[j]);
        }
        int[] arr = new int[nums.length];
        for (int j = 0; j < ans.size(); j++) {
            Integer A = ans.get(j);
            arr[j] = A.intValue();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        int [] arr = createTargetArray1(nums,index);
        for (int a: arr
             ) {
            System.out.println(a);
        }
    }


}
