package 面试.In;

public class B {
    static int num =1;
    public static void main(String[] args) {
        int year = 15;
        get(year);
        System.out.println(num);
    }

    private static void get(int n) {
        for (int i = 0; i <n; i++) {
            if (i==1||i==3) {
                num++;
                get(n-i);
            }
            if (i==4){
                num--;
                break;
            }
        }
    }
}
