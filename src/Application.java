import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Application {
    public static void main(String[] args) throws Exception {
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:///tmp/")});
        Class<?> myClass = Class.forName("MyClass", false, urlClassLoader);
        Object o = myClass.newInstance();
        Method lol = myClass.getDeclaredMethod("lol");
        Thread.currentThread().setContextClassLoader(urlClassLoader);
        lol.invoke(o);
    }

    public static void doStuff(String clazz) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(clazz, false, Thread.currentThread().getContextClassLoader());
//        Class<?> aClass = Class.forName(clazz);
        System.out.println(": " + aClass.getName());
    }
}
