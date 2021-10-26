package 面试.吉比特;

public class Singleton {
    public Singleton(){
        System.out.println("单例创建");
    }
    public static class SingletonClassInstance{
        private static final Singleton singLeton= new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonClassInstance.singLeton;
    }
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton singleton = new Singleton();
        System.out.println(singleton==s1);
        System.out.println(s1 == s2);

    }

    public void sort(int[] arr, int left, int right) {
        int[] res = new int[arr.length];
        while (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            mergeSort(arr, left, right,res);
        }
    }

    private int[] mergeSort(int[] arr, int left, int right, int[] res) {
        int mid = left + (right - left) / 2;
        int t = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                res[t++] = arr[i++];
            } else {
                res[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            res[t++] = arr[i++];
        }
        while (j <= right) {
            res[t++] = arr[j++];
        }
        return res;
    }
}
