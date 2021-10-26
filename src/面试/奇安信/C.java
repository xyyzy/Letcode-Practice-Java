package 面试.奇安信;

public class C {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = a;
        String d = new String(a);
        String e = new String("123");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(a.equals(e));
    }
}
