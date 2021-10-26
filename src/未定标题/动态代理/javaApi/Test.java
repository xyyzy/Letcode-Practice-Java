package 未定标题.动态代理.javaApi;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserDao userDaoImpl = new UserDaoImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDaoImpl);

        //类加载器
        ClassLoader classLoader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();
        //主要加载器
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        newProxyInstance.save();
    }
}
