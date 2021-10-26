package 面试.爱客科技;

class d extends C{
    public d(int a) {
        super(a);
    }

    public d() {
    }
}
public abstract class C {
    int a = 1;

    public C(int a) {
        this.a = a;
    }

    public C() {
    }

    public int method() {
        return 0;
    }

    public static void main(String[] args) {
        d c = new d();
    }
}


