package JUC并发.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.lang.reflect.Proxy;

interface UserDao {
    public void save();
}

class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}

class InvocationHandlerImpl  implements InvocationHandler {
    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        Object result = method.invoke(target, args);
        System.out.println("保存事务");
        return result;
    }

}



class DynamicProxyTest {
    public static void main(String[] args) {
       //被代理对象
        UserDao userDaoImpl = new UserDaoImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDaoImpl);
        //类加载器
        ClassLoader loader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();

        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        newProxyInstance.save();
    }
}