package 未定标题.动态代理.javaApi;

public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存数据方法");
    }
}
