package JUC并发.代理模式.CGLIB动态代理;




interface UserDao {
    void save();
}


//接口实现类
class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("保存数据方法");
    }
}

