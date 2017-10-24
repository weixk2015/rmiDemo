import server.IService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args){
        try {
            Context context = new InitialContext();
            IService service01 = (IService) Naming.lookup("rmi://localhost:8888/service01");
            Class stubClass = service01.getClass();
            System.out.println("get an instance of Class" + stubClass);
            Class[] interfaces = stubClass.getInterfaces();
            for (Class c : interfaces){
                System.out.println("stubClass implements "+c.getName());
            }
            System.out.println(service01.service("hello world!"));

        } catch (RemoteException | NamingException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
