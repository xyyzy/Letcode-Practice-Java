public class FieldHasNoPolymorphic {
    static class Father{
        public int money = 1;
        public Father(){
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney(){
            System.out.println("I am Father,i have "+ money);
        }
    }
    static class Son extends Father{
        public int money = 3;
        public Son(){
            money = 4;
            showMeTheMoney();
        }
        public void showMeTheMoney(){
            System.out.println("I am son,i have "+ money);
        }
    }

    public static void main(String[] args) {
         Father gay=new Son();
        System.out.println("this gay have " + gay.money);
    }
}
