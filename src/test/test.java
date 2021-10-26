package test;

public class test {


    public static long count = 0;

    public static void main(String[] args) {
        try{
            while (true) {
                count(1,2);
            }
        }catch (Throwable e){
            System.out.println("count="+count);
            throw e;
        }
    }

    private static void count(long arg1, long arg2) {
        long num1 = 1;
        long num2 = 2;
        count++;
        count(arg1, arg2);
    }

}
