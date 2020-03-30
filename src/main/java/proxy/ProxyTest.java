package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Cook cooker = new Cooker();
        CookHandler cookHandler = new CookHandler(cooker);
        Cook proxy = (Cook) Proxy.newProxyInstance(cookHandler.getClass().getClassLoader(), cooker.getClass().getInterfaces(), cookHandler);
        System.out.println(proxy.getClass().getName());
        proxy.dealWithFood();
        proxy.cook();
        byte[] proxyClass = ProxyGenerator.generateProxyClass(proxy.getClass().getName(), cooker.getClass().getInterfaces());
        FileOutputStream fos = null;
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        try {
            fos = new FileOutputStream("/Users/weimin/Desktop/" + proxy.getClass().getName() + ".class");
            fos.write(proxyClass);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
