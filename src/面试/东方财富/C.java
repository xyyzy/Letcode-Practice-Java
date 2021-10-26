package 面试.东方财富;

public class C {
    static int n;
    static int q;

    public static void main(String[] args) {
        n=7;
        q = (int) Math.sqrt(n);
        if (dfs(0, 0, 0) == 0)
            System.out.println(-1);

    }

    private static int dfs(int k, int w, int v) {
        if (w == n)
            return 1;
        if (w > n)
            return 0;
        for (int j = k + 1; j <= q; j++) {
            if (dfs(j,w+j*j,v+1)>0){
                if (v==0)
                    System.out.print(j*j);
                else {
                    System.out.print(j * j);
                    System.out.println("+");
                }
                return 1;
            }
        }
        return 0;
    }
}
