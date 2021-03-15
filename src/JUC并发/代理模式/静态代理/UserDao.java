package JUC并发.代理模式.静态代理;

public interface UserDao {
    public void save();
}

class UserDaoImpl implements UserDao{

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}

class UserDaoProxy implements UserDao{
    private UserDao userDao;
    public UserDaoProxy(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("开启事物...");
        userDao.save();
        System.out.println("关闭事物...");
    }
}

class Test{
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.save();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
